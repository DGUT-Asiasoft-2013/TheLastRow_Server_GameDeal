package com.cloudage.membercenter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudage.membercenter.entity.Equipment;
import com.cloudage.membercenter.entity.Payments;
import com.cloudage.membercenter.entity.Recharge;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.service.IEquipmentService;
import com.cloudage.membercenter.service.IPaymentsService;
import com.cloudage.membercenter.service.IRechargeService;
import com.cloudage.membercenter.service.IUserService;
import com.mysql.jdbc.log.Log;


@RestController
@RequestMapping("/money")
public class MoneyController {

	@Autowired
	IUserService userService;
	@Autowired
	IPaymentsService paymentsService;
	@Autowired
	IRechargeService rechargeService;
	@Autowired
	IEquipmentService equipmentService;
	
	
	@RequestMapping(value="pay/change_state",method=RequestMethod.POST)
	public boolean setPayState(@RequestParam int payId,@RequestParam int state,HttpServletRequest request){
		Payments payments=paymentsService.findPaymentsById(payId);
		if(payments==null){
			return false;
		}else {
			payments.setState(state);
			paymentsService.save(payments);
			if(state==2){
				User user=userService.findById(payments.getEquipment().getOwner().getId());
				Recharge recharge=new Recharge();
				
				String price=payments.getEquipment().getEquipvalue();
				user.setMoney(Integer.parseInt(price));
				
				recharge.setUser(user);
				recharge.setMoney("出售收益");
				recharge.setEquipment(payments.getEquipment());
				recharge.setMoneyrecord(price);
				
				userService.save(user);
				rechargeService.save(recharge);
			}
			return true;
		}
	}
	
	
	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public User getCurrentUser(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Integer uid = (Integer) session.getAttribute("uid");
		return userService.findById(uid);
	}
	
	
	@RequestMapping("/me/{user_id}/payments/{page}")
	public Page<Payments> getPaymentsOfUser(@PathVariable int user_id, @PathVariable int page) {
		return paymentsService.findPaymentsOfUser(user_id, page);
	}

	@RequestMapping("/user/{user_id}/payments/count")
	public int getPaymentsCountOfuser(@PathVariable int user_id) {
		return paymentsService.getPaymentsCountOfUser(user_id);
	}

	@RequestMapping("/user/{user_id}/payments")
	public Page<Payments> getPaymentsOfUser(@PathVariable int user_id) {
		return paymentsService.findPaymentsOfUser(user_id, 0);
	}

//	获取指定状态下的订单
	@RequestMapping(value="/pay/{pay_state}/{page}")
	public Page<Payments> getPayByState(@PathVariable int pay_state,@PathVariable int page,HttpServletRequest request){
		User user=getCurrentUser(request);
		return paymentsService.getPaymentsByState(pay_state,user.getId(),user.getId(),page);
	}
	
	
	
	@RequestMapping(value = "/user/{good_id}/payments", method = RequestMethod.POST)
	public Payments postPayments(@PathVariable int good_id, @RequestParam int good_number,HttpServletRequest request) {
		User me = getCurrentUser(request);
//		Good good=goodService.findOne(1);
		Equipment equipment=equipmentService.findEquipmentByid(good_id);
		int kucun=equipment.getEquipnumber();//		获取商品库存
		kucun=kucun-good_number;
		equipment.setEquipnumber(kucun);//新的库存
		
		Payments payments = new Payments();
		int good_money=Integer.parseInt(equipment.getEquipvalue())*good_number;	//		获取商品价格
		int user_money=me.getMoney();											//		获取用户余额
		me.setMoney(user_money-good_money);										//		设置用户新的余额
		
		Recharge recharge=new Recharge();
		recharge.setUser(me);
		recharge.setMoney("购买支出");
		recharge.setEquipment(equipment);
		recharge.setMoneyrecord("-"+good_money);
		payments.setUser(me);
//		payments.setGood(good);
		payments.setEquipment(equipment);
		payments.setNumber(good_number);
		userService.save(me);
		rechargeService.save(recharge);
		equipmentService.save(equipment);
		return paymentsService.save(payments);

	}
}

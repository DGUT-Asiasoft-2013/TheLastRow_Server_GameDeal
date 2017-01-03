package com.cloudage.membercenter.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OperatorPower;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudage.membercenter.entity.Company;
import com.cloudage.membercenter.entity.Equipment;
import com.cloudage.membercenter.entity.EquipmentOfBuy;
import com.cloudage.membercenter.entity.Game;
import com.cloudage.membercenter.entity.GameService;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.service.ICompanyService;
import com.cloudage.membercenter.service.IEquipmentOfBuyService;
import com.cloudage.membercenter.service.IEquipmentService;
import com.cloudage.membercenter.service.IGameService;
import com.cloudage.membercenter.service.IGameServiceService;
import com.cloudage.membercenter.service.IUserService;

@RestController
@RequestMapping("/equip")
public class EquipmentController {

	@Autowired
	IUserService userService;
	
	@Autowired
	ICompanyService companyService;
	
	@Autowired
	IGameService gameService;
	
	@Autowired
	IGameServiceService gameServiceService;
	
	@Autowired
	IEquipmentService equipmentService;
	
	@Autowired
	IEquipmentOfBuyService equipmentofbuyService;
	
	//������й�˾
	@RequestMapping(value = "/getcompany" , method = RequestMethod.GET)
	@ResponseBody
	public List<Company> getCompany(){
		return companyService.getAllCompany();
	}
	
	//��ȷ����
	//ͨ����˾����ù�˾
	@RequestMapping(value = "/getcompany/{companyname}" , method = RequestMethod.GET)
	@ResponseBody
	public Company getCompanyByCompanyName(@PathVariable String companyname){
		return companyService.findByCompanyName(companyname);
	}
	
	//���������Ϸ
	@RequestMapping(value = "/getgame" , method = RequestMethod.GET)
	@ResponseBody
	public List<Game> getGame(){
		return gameService.getAllGame();
	}
	
	//��ȷ����
	//ͨ����˾����øù�˾������Ϸ
	@RequestMapping(value = "/getgame/bycompany/{companyname}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Game> getGameByCompanyName(@PathVariable String companyname){
		return gameService.findByCompanyName(companyname);
	}
	
	//��ȷ����
	//ͨ����Ϸ�������Ϸ
	@RequestMapping(value = "getgame/{gamename}" , method = RequestMethod.GET)
	@ResponseBody
	public Game getGameByGameName(@PathVariable String gamename){
		return gameService.findByGameName(gamename);
	}
	
	//���������Ϸ����
	@RequestMapping(value = "/getgameservice" , method = RequestMethod.GET)
	@ResponseBody
	public List<GameService> getGameService(){
		return gameServiceService.getAllGameService();
	}
	
	//��ȷ����
	//ͨ����Ϸ����ø���Ϸ������Ϸ����
	@RequestMapping(value = "/getgameservice/bygame/{gamename}" , method = RequestMethod.GET)
	@ResponseBody
	public List<GameService> getGameServiceByGameName(@PathVariable String gamename){
		return gameServiceService.findByGameName(gamename);
	}
	
	//��ȷ����
	//ͨ����Ϸ������Ѱ����Ϸ����
	@RequestMapping(value = "getgameservice/bygame/{gamename}/{gameservicename}" , method = RequestMethod.GET)
	@ResponseBody
	public GameService getGameServiceByGameServiceName(@PathVariable String gamename , @PathVariable String gameservicename){
		return gameServiceService.findByGameServiceName(gameservicename,gamename);
	}
	
	//�������װ��
	@RequestMapping(value = "/getequipment" , method = RequestMethod.GET)
	@ResponseBody
	public List<Equipment> getEquipment(){
		return equipmentService.getAllEquipment();
	}
	
	//��ȷ����
	//ͨ���û�IDѰ��װ��
	@RequestMapping(value = "/getequipment/byuserid/{id}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Equipment> getEquipmentByUserId(@PathVariable Integer id){
		return equipmentService.findByOwnerId(id);
	}
	
	//��ȷ����
	//ͨ����˾����װ��
	@RequestMapping(value = "getequipment/bycompany/{companyname}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Equipment> getEquipmentByComapnyName(@PathVariable String companyname){
		return equipmentService.findByCompanyName(companyname);
	}
	
	//��ȷ����
	//ͨ����Ϸ����װ��
	@RequestMapping(value = "getequipment/bygame/{gamename}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Equipment> getEquipmentByGameName(@PathVariable String gamename){
		return equipmentService.findByGameName(gamename);
	}
	
	//��ȷ����
	//ͨ����Ϸ������װ��
	@RequestMapping(value = "getequipment/bygame/{gamename}/{gameservicename}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Equipment> getEquipmentByGameServiceName(@PathVariable String gamename,@PathVariable String gameservicename){
		return equipmentService.findByGameServiceName(gameservicename, gamename);
	}
	
	//ģ������
	//ͨ��װ������װ��
	@RequestMapping(value = "getequipment/byequipname/{equipname}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Equipment> findEquipmentByEquipmentName(@PathVariable String equipname){
		return equipmentService.findByEquipName(equipname);
	}
	
	//////////////////////////////////////
	//�������װ��
		@RequestMapping(value = "/getequipmentofbuy" , method = RequestMethod.GET)
		@ResponseBody
		public List<EquipmentOfBuy> getEquipmentOfBuy(){
			return equipmentofbuyService.getAllEquipmentOfBuy();
		}
		
		//��ȷ����
		//ͨ���û�IDѰ��װ��
		@RequestMapping(value = "/getequipmentofbuy/byuserid/{id}" , method = RequestMethod.GET)
		@ResponseBody
		public List<EquipmentOfBuy> getEquipmentOfBuyByUserId(@PathVariable Integer id){
			return equipmentofbuyService.findByOwnerId(id);
		}
		
		//��ȷ����
		//ͨ����˾����װ��
		@RequestMapping(value = "getequipmentofbuy/bycompany/{companyname}" , method = RequestMethod.GET)
		@ResponseBody
		public List<EquipmentOfBuy> getEquipmentOfBuyByComapnyName(@PathVariable String companyname){
			return equipmentofbuyService.findByCompanyName(companyname);
		}
		
		//��ȷ����
		//ͨ����Ϸ����װ��
		@RequestMapping(value = "getequipmentofbuy/bygame/{gamename}" , method = RequestMethod.GET)
		@ResponseBody
		public List<EquipmentOfBuy> getEquipmentOfBuyByGameName(@PathVariable String gamename){
			return equipmentofbuyService.findByGameName(gamename);
		}
		
		//��ȷ����
		//ͨ����Ϸ������װ��
		@RequestMapping(value = "getequipmentofbuy/bygame/{gamename}/{gameservicename}" , method = RequestMethod.GET)
		@ResponseBody
		public List<EquipmentOfBuy> getEquipmentOfBuyByGameServiceName(@PathVariable String gamename,@PathVariable String gameservicename){
			return equipmentofbuyService.findByGameServiceName(gameservicename, gamename);
		}
		
		//ģ������
		//ͨ��װ������װ��
		@RequestMapping(value = "getequipmentofbuy/byequipname/{equipname}" , method = RequestMethod.GET)
		@ResponseBody
		public List<EquipmentOfBuy> findEquipmentofbuyByEquipmentName(@PathVariable String equipname){
			return equipmentofbuyService.findByEquipName(equipname);
		}
	
		public User getCurrentUser(HttpServletRequest request){
			HttpSession session = request.getSession(true);
			Integer uid = (Integer) session.getAttribute("uid");
			return userService.findById(uid);
		}
		
		///////////////////////////��  ��  ��  ��  ��  //////////////////
		
		//��������װ��
		@RequestMapping(value = "saveequipment/{gamename}/{gameservicename}" , method = RequestMethod.POST)
		public Equipment saveEquipment(
				@PathVariable String gamename,
				@PathVariable String gameservicename,
				@RequestParam String equipname,
				@RequestParam String equipvalue,
				@RequestParam String equipnumber,
				@RequestParam String gameid,
//				MultipartFile picture,
				HttpServletRequest request){
			User owner = getCurrentUser(request);
			Equipment equipment = new Equipment();
			equipment.setOwner(owner);
			equipment.setGameservice(gameServiceService.findByGameServiceName(gameservicename, gamename));
			equipment.setEquipname(equipname);
			equipment.setEquipvalue(equipvalue);
			equipment.setEquipnumber(Integer.valueOf(equipnumber));
			equipment.setGameid(gameid);
			

//			if(picture!=null){
//				try{
//					String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
//					FileUtils.copyInputStreamToFile(picture.getInputStream(), new File(realPath,".png"));
//				}catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
			
			return equipmentService.save(equipment);
		}
		
		//�����չ�װ��
		@RequestMapping(value = "saveequipmentofbuy/{gamename}/{gameservicename}" , method = RequestMethod.POST)
		public EquipmentOfBuy saveEquipmentOfBuy(
				@PathVariable String gamename,
				@PathVariable String gameservicename,
				@RequestParam String equipname,
				@RequestParam String minvalue,
				@RequestParam String equipnumber,
				@RequestParam String gameid,
				HttpServletRequest request){
			User owner = getCurrentUser(request);
			EquipmentOfBuy equipmentOfBuy = new EquipmentOfBuy();
			equipmentOfBuy.setOwner(owner);
			equipmentOfBuy.setGameservice(gameServiceService.findByGameServiceName(gameservicename, gamename));
			equipmentOfBuy.setEquipname(equipname);
			equipmentOfBuy.setMinvalue(minvalue);
			equipmentOfBuy.setGameid(gameid);
			equipmentOfBuy.setEquipnumber(Integer.valueOf(equipnumber));
			return equipmentofbuyService.save(equipmentOfBuy);
		}
}

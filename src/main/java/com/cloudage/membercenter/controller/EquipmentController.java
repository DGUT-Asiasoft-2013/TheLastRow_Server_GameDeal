package com.cloudage.membercenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloudage.membercenter.entity.Company;
import com.cloudage.membercenter.entity.Equipment;
import com.cloudage.membercenter.entity.Game;
import com.cloudage.membercenter.entity.GameService;
import com.cloudage.membercenter.service.ICompanyService;
import com.cloudage.membercenter.service.IEquipmentService;
import com.cloudage.membercenter.service.IGameService;
import com.cloudage.membercenter.service.IGameServiceService;

@RestController
@RequestMapping("/equip")
public class EquipmentController {

	@Autowired
	ICompanyService companyService;
	
	@Autowired
	IGameService gameService;
	
	@Autowired
	IGameServiceService gameServiceService;
	
	@Autowired
	IEquipmentService equipmentService;
	
	//������й�˾
	@RequestMapping(value = "/getcompany" , method = RequestMethod.GET)
	@ResponseBody
	public List<Company> getCompany(){
		return companyService.getAllCompany();
	}
	
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
	
	//ͨ����˾����øù�˾������Ϸ
	@RequestMapping(value = "/getgame/bycompany/{companyname}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Game> getGameByCompanyName(@PathVariable String companyname){
		return gameService.findByCompanyName(companyname);
	}
	
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
	
	//ͨ����Ϸ����ø���Ϸ������Ϸ����
	@RequestMapping(value = "/getgameservice/bygame/{gamename}" , method = RequestMethod.GET)
	@ResponseBody
	public List<GameService> getGameServiceByGameName(@PathVariable String gamename){
		return gameServiceService.findByGameName(gamename);
	}
	
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
	
	//ͨ���û�IDѰ��װ��
	@RequestMapping(value = "/getequipment/byuserid/{id}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Equipment> getEquipmentByUserId(@PathVariable Integer id){
		return equipmentService.findByOwnerId(id);
	}
	
	//ͨ����˾����װ��
	@RequestMapping(value = "getequipment/bycompany/{companyname}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Equipment> getEquipmentByComapnyName(@PathVariable String companyname){
		return equipmentService.findByCompanyName(companyname);
	}
	
	//ͨ����Ϸ����װ��
	@RequestMapping(value = "getequipment/bygame/{gamename}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Equipment> getEquipmentByGameName(@PathVariable String gamename){
		return equipmentService.findByGameName(gamename);
	}
	
	//ͨ����Ϸ������װ��
	@RequestMapping(value = "getequipment/bygame/{gamename}/{gameservicename}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Equipment> getEquipmentByGameServiceName(@PathVariable String gamename,@PathVariable String gameservicename){
		return equipmentService.findByGameServiceName(gameservicename, gamename);
	}
	
	//ͨ��װ������װ��
	@RequestMapping(value = "getequipment/byequipname/{equipname}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Equipment> getEquipmentByEquipmentName(@PathVariable String equipname){
		return equipmentService.findByEquipName(equipname);
	}
	
	
}

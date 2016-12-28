package com.cloudage.membercenter.controller;

import java.io.File;
import java.util.List;

import javax.persistence.criteria.Predicate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.junit.runner.Request;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.cloudage.membercenter.entity.Article;
import com.cloudage.membercenter.entity.Comment;
import com.cloudage.membercenter.entity.Good;
import com.cloudage.membercenter.entity.Payments;
import com.cloudage.membercenter.entity.Recharge;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.service.IArticleService;
import com.cloudage.membercenter.service.ICommentService;
import com.cloudage.membercenter.service.IGoodService;
import com.cloudage.membercenter.service.ILikesService;

import com.cloudage.membercenter.service.IPaymentsService;
import com.cloudage.membercenter.service.IRechargeService;
import com.cloudage.membercenter.service.IUserService;

@RestController
@RequestMapping("/api")
public class APIController {

	@Autowired
	IGoodService goodService;
	
	@Autowired
	IUserService userService;

	@Autowired
	IArticleService articleService;

	
	@Autowired
	ICommentService commentService;

	@Autowired
	ILikesService likesService;


	@Autowired
	IPaymentsService paymentsService;
	
	@Autowired
	IRechargeService  rechargeService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody String hello() {

		return "HELLO WORLD";
	}

	
	//发布商品
	@RequestMapping(value = "/good", method = RequestMethod.POST)
	public Good addGood(
			@RequestParam String game_equip,
			@RequestParam String price,
			@RequestParam MultipartFile avatar_img1,
			@RequestParam String game_name,
			@RequestParam String game_company,
			@RequestParam String game_account,
			@RequestParam String game_area,
			HttpServletRequest request) {
		
		User currentUser = getCurrentUser(request);
		Good good=new Good();
		good.setAuthor(currentUser);
		good.setGame_equip(game_equip);
		good.setPrice(Integer.parseInt(price));
		good.setGame_name(game_name);
		good.setGame_company(game_company);
		good.setGame_account(game_account);
		good.setGame_area(game_area);
		
		if (avatar_img1 != null) {
			try {

				String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
				FileUtils.copyInputStreamToFile(avatar_img1.getInputStream(), new File(realPath, game_equip+currentUser.getId() + ".png"));
				good.setAvatar_img1("upload/" + game_equip+currentUser.getId() + ".png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return goodService.save(good);
	}
	
	@RequestMapping("/goodfeeds/{page}")
	public Page<Good> getGoodFeeds(@PathVariable int page) {
		return goodService.getFeeds(page);
	}

	@RequestMapping("/goodfeeds")
	public Page<Good> getGoodFeeds() {
		return getGoodFeeds(0);
	}
	
	
	
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User register(
			@RequestParam String account,
			@RequestParam String passwordHash,
			@RequestParam String email,
			@RequestParam String name,
			MultipartFile avatar, 
			HttpServletRequest request) {


		User user = new User();
		user.setAccount(account);
		user.setPasswordHash(passwordHash);
		user.setEmail(email);
		user.setName(name);
		user.setMoney(0);

		if (avatar != null) {
			try {

				String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
				FileUtils.copyInputStreamToFile(avatar.getInputStream(), new File(realPath, account + ".png"));
				user.setAvatar("upload/" + account + ".png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return userService.save(user);
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(
			@RequestParam String account,
			@RequestParam String passwordHash,
			HttpServletRequest request) {

		User user = userService.findByAccount(account);
		if (user != null && user.getPasswordHash().equals(passwordHash)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("uid", user.getId());
			return user;
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public User getCurrentUser(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Integer uid = (Integer) session.getAttribute("uid");
		return userService.findById(uid);
	}

	@RequestMapping(value = "/passwordrecover", method = RequestMethod.POST)
	public boolean resetPassword(@RequestParam String email, @RequestParam String passwordHash) {
		User user = userService.findByEmail(email);
		if (user == null) {
			return false;
		} else {
			user.setPasswordHash(passwordHash);
			userService.save(user);
			return true;
		}
	}
	 @RequestMapping(value = "/exit")
     public void exitServer(HttpServletRequest request){
      	User me = getCurrentUser(request);
      	if(me!=null){
      	request.getSession(true).removeAttribute("uid");
}
	 }
	@RequestMapping(value = "/goods/{userId}")
	public List<Good> getGoodsByUserID(@PathVariable Integer userId) {
		return goodService.findAllByAuthorId(userId);
	}

//	@RequestMapping(value = "/article", method = RequestMethod.POST)
//	public Article addArticle(@RequestParam String title, @RequestParam String text, HttpServletRequest request) {
//		User currentUser = getCurrentUser(request);
//		Article article = new Article();
//		article.setAuthor(currentUser);
//		article.setTitle(title);
//		article.setText(text);
//		return articleService.save(article);
//	}
//
//	@RequestMapping("/feeds/{page}")
//	public Page<Article> getFeeds(@PathVariable int page) {
//		return articleService.getFeeds(page);
//	}
//
//	@RequestMapping("/feeds")
//	public Page<Article> getFeeds() {
//		return getFeeds(0);
//	}

	@RequestMapping("/good/{good_id}/comments/{page}")
	public Page<Comment> getCommentsOfGood(@PathVariable int good_id, @PathVariable int page) {
		return commentService.findCommentsOfGood(good_id, page);
	}

	@RequestMapping("/good/{good_id}/comments/count")
	public int getCommentsCountOfGood(@PathVariable int good_id) {
		return commentService.getCommentCountOfGood(good_id);
	}

	@RequestMapping("/good/{good_id}/comments")
	public Page<Comment> getCommentsOfGood(@PathVariable int good_id) {
		return commentService.findCommentsOfGood(good_id, 0);
	}

	@RequestMapping(value = "/good/{good_id}/comments", method = RequestMethod.POST)
	public Comment postComment(@PathVariable int good_id, @RequestParam String text, HttpServletRequest request) {
		User me = getCurrentUser(request);
		Good good = goodService.findOne(good_id);
		Comment comment = new Comment();
		comment.setAuthor(me);
		comment.setGood(good);
		comment.setText(text);
		return commentService.save(comment);
	}

	@RequestMapping("/good/{good_id}/likes")
	public int countLikes(@PathVariable int good_id) {
		return likesService.countLikes(good_id);
	}

	@RequestMapping("/good/{good_id}/isliked")
	public boolean checkLiked(@PathVariable int good_id, HttpServletRequest request) {
		User me = getCurrentUser(request);
		return likesService.checkLiked(me.getId(), good_id);
	}

	@RequestMapping(value = "/good/{good_id}/likes", method = RequestMethod.POST)
	public int changeLikes(@PathVariable int good_id, @RequestParam boolean likes, HttpServletRequest request) {
		User me = getCurrentUser(request);
		Good good = goodService.findOne(good_id);

		if (likes)
			likesService.addLike(me, good);
		else
			likesService.removeLike(me, good);

		return likesService.countLikes(good_id);
	}

	@RequestMapping("good/s/{keyword}")
	public Page<Good> searchGoodsWithKeyword(@PathVariable String keyword,
			@RequestParam(defaultValue = "0") int page) {
		return goodService.searchEquipWithKeyword(keyword, page);
	}

	@RequestMapping("/me/{user_id}/payments/{page}")
	public Page<Payments> getPaymentsOfUser(@PathVariable int user_id, @PathVariable int page) {
		return paymentsService.findPaymentsOfUser(user_id, page);
	}

	@RequestMapping("/me/{user_id}/payments/count")
	public int getPaymentsCountOfuser(@PathVariable int user_id) {
		return paymentsService.getPaymentsCountOfUser(user_id);
	}

	@RequestMapping("/user/{user_id}/payments")
	public Page<Payments> getPaymentsOfUser(@PathVariable int user_id) {
		return paymentsService.findPaymentsOfUser(user_id, 0);
	}

	@RequestMapping(value = "/me/{user_id}/payments", method = RequestMethod.POST)
	public Payments postPayments(@PathVariable int user_id, @RequestParam String text, HttpServletRequest request) {
		User me = getCurrentUser(request);
		
		Payments payments = new Payments();
		payments.setAuthor(me);
		
		payments.setText(text);
		return paymentsService.save(payments);

	}
	@RequestMapping("/me/{user_id}/recharge/{page}")
	public Page<Recharge> getRechargeOfUser(@PathVariable int user_id, @PathVariable int page) {
		return rechargeService.findRechargeOfUser(user_id, page);
	}

	@RequestMapping("/me/{user_id}/recharge/count")
	public int getRechargeCountOfuser(@PathVariable int user_id) {
		return rechargeService.getRechargeCountOfUser(user_id);
	}

	@RequestMapping("/user/{user_id}/recharge")
	public Page<Recharge> getRechargeOfUser(@PathVariable int user_id) {
		return rechargeService.findRechargeOfUser(user_id, 0);
	}

	@RequestMapping(value = "/me/{user_id}/Recharge", method = RequestMethod.POST)
	public Recharge postRecharge(@PathVariable int user_id, @RequestParam String text, HttpServletRequest request) {
		User me = getCurrentUser(request);
		
		Recharge recharge = new Recharge();
		recharge.setUser(me);
		
		int mo=(int) (me.getMoney()+Integer.parseInt(text));//新的余额
		me.setMoney(mo);
		userService.save(me);
		
		recharge.setMoneyrecord(text);
		return rechargeService.save(recharge);

	}
}

package com.C2C.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.C2C.Entity.Good;
import com.C2C.Entity.GoodLeaveMessage;
import com.C2C.Entity.Message;
import com.C2C.Entity.Position;
import com.C2C.Entity.ProductMessageReply;
import com.C2C.Service.GoodLeaveMessageService;
import com.C2C.Service.GoodService;
import com.C2C.Service.PositionService;
import com.C2C.Service.ProductMessageReplyService;
import com.C2C.Service.VerificationCodeService;
import com.C2C.Service.Impl.GoodLeaveMessageServiceImpl;
import com.C2C.Service.Impl.GoodServiceImpl;
import com.C2C.Service.Impl.MessageServiceImpl;
import com.C2C.Service.Impl.PayServiceImpl;
import com.C2C.Service.Impl.PositionServiceImpl;
import com.C2C.Service.Impl.ProductMessageReplyServiceImpl;
import com.C2C.Service.Impl.UserServiceImpl;
import com.C2C.Service.Impl.VerificationCodeServiceImpl;
import com.alipay.api.AlipayApiException;

import net.sf.json.JSONObject;

public class Test {

	public static void printElements(Collection c) {
		Iterator it = c.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void testSearchGood() throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		String range = "江西农大";
		String category = null;
		int page = 1;
		int size = 15;
		GoodService goodService = (GoodServiceImpl)context.getBean("goodServiceImpl");
//		System.out.println(goodService.getGoodByIdGoods(1));
		List<Good> goods = goodService.getGoodsByPositionAndPage("南昌", range, 1);
		printElements(goods);
		/*List<Good> goods = goodService.getGoodsByStore(1, range, category, 0, 2000, page, size);
		printElements(goods);*/
	}
	
	public static void testPosition() throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PositionService goodService = (PositionServiceImpl)context.getBean("positionServiceImpl");
		System.out.println(goodService.getStorePositions());
	}
	
	public static void testProductMessageReplyServiceImpl() throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductMessageReplyService productMessageReplyService = (ProductMessageReplyServiceImpl)context.getBean("productMessageReplyServiceImpl");
//		List<ProductMessageReply> replys = productMessageReplyService.getProductMessageReplyById(1);
//		printElements(replys);
		productMessageReplyService.sendReply(2, 2, 1, "这是条测试用的回复");
	}
	
	public static void testGoodLeaveMessageServiceImpl() throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GoodLeaveMessageService leaveMessageService = (GoodLeaveMessageServiceImpl)context.getBean("goodLeaveMessageServiceImpl");
//		List<GoodLeaveMessage> leaveMessages = leaveMessageService.getGoodLeaveMessageByGoodId(1);
//		printElements(leaveMessages);
		leaveMessageService.sendLeaveMessage(1, 6, "你好5");
	}
	
	public static void testJson() {
		String msg = "{'getter':1,'sender':2,'message':'你好啊'}";
		JSONObject jsonTo = JSONObject.fromObject(msg);
		Message message = (Message)JSONObject.toBean(jsonTo, Message.class);
		System.out.println(message);
	}
	
	public static void testPayServiceImpl() throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PayServiceImpl payService = (PayServiceImpl)context.getBean("payServiceImpl");
		try {
			System.out.println(payService.pay(payService.newOrder(2)));
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testUserServiceImpl() throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceImpl userService = (UserServiceImpl)context.getBean("userServiceImpl");
		String email = "2453671898@qq.com";
		String passWord = "123456";
		String alipay = "2088722235394212";
//		System.out.println(userService.checkUser(email, passWord));
//		System.out.println(userService.regist(email,"李四", passWord,null));
//		System.out.println(userService.getUserByAlipay("2088722235394212"));
		System.out.println(userService.getUserInfoByIdUser(1));
	}
	
	public static void testGoodService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GoodService goodService = (GoodServiceImpl)context.getBean("goodServiceImpl");
//		goodService.issueGood(3, "test", "100", null, null, "其他");
//		Good good = goodService.getGoodByIdGoods(1);
//		System.out.println(good);
//		System.out.println(good.getLeaveMessages());
		try {
			System.out.println(goodService.getGoodsByPositionAndPage("南昌", "江西农业大学", 1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testCode() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		VerificationCodeService codeService = (VerificationCodeServiceImpl)context.getBean("verificationCodeServiceImpl");
//		System.out.println(codeService.insertEcode("2453671898@qq.com", "1234"));
//		System.out.println(codeService.checkEcode("2453671898@qq.com", "12234"));
//		System.out.println(codeService.checkEmail("2453671818@qq.com"));
//		System.out.println(codeService.updateEcode("2453671898@qq.com", "1233"));
		codeService.sendEamil("2453671898@qq.com", "1123");
	}
	
	public static void testStyle() {
		UserServiceImpl impl = new UserServiceImpl();
		System.out.println(impl.checkEmailStyle("245"));
	}
	
	public static void checkMessage() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageServiceImpl messageService = (MessageServiceImpl)context.getBean("messageServiceImpl");
//		messageService.addMessage(2, 1, 1, "123", 0);
		printElements(messageService.getMessage(2, 13, 1, 0, 5));
	}
	
	public static void main(String[] args) throws IOException{
//		testSearchGood();
//		testPosition();
//		testProductMessageReplyServiceImpl();
//		testGoodLeaveMessageServiceImpl();
//		testJson();
//		testPayServiceImpl();
//		testUserServiceImpl();
		testGoodService();
//		testCode();
//		testStyle();
		/*String time = String.valueOf(System.currentTimeMillis());
		String code = time.substring(time.length()-5);
		System.out.println(code);*/
//		checkMessage();
	}
	
}

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
import com.C2C.Service.Impl.GoodLeaveMessageServiceImpl;
import com.C2C.Service.Impl.GoodServiceImpl;
import com.C2C.Service.Impl.PayServiceImpl;
import com.C2C.Service.Impl.PositionServiceImpl;
import com.C2C.Service.Impl.ProductMessageReplyServiceImpl;
import com.C2C.Service.Impl.UserServiceImpl;
import com.alipay.api.AlipayApiException;

import net.sf.json.JSONObject;

public class Test {

	private static void printElements(Collection c) {
		Iterator it = c.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	private static void testSearchGood() throws IOException {
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
	
	private static void testPosition() throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PositionService goodService = (PositionServiceImpl)context.getBean("positionServiceImpl");
		System.out.println(goodService.getStorePositions());
	}
	
	private static void testProductMessageReplyServiceImpl() throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductMessageReplyService productMessageReplyService = (ProductMessageReplyServiceImpl)context.getBean("productMessageReplyServiceImpl");
		List<ProductMessageReply> replys = productMessageReplyService.getProductMessageReplyById(1);
		printElements(replys);
	}
	
	private static void testGoodLeaveMessageServiceImpl() throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GoodLeaveMessageService leaveMessageService = (GoodLeaveMessageServiceImpl)context.getBean("goodLeaveMessageServiceImpl");
		List<GoodLeaveMessage> leaveMessages = leaveMessageService.getGoodLeaveMessageByGoodId(1);
		printElements(leaveMessages);
	}
	
	private static void testJson() {
		String msg = "{'getter':1,'sender':2,'message':'你好啊'}";
		JSONObject jsonTo = JSONObject.fromObject(msg);
		Message message = (Message)JSONObject.toBean(jsonTo, Message.class);
		System.out.println(message);
	}
	
	private static void testPayServiceImpl() throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PayServiceImpl payService = (PayServiceImpl)context.getBean("payServiceImpl");
		try {
			System.out.println(payService.pay(payService.newOrder(2)));
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void testUserServiceImpl() throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceImpl userService = (UserServiceImpl)context.getBean("userServiceImpl");
		System.out.println(userService.checkUser("2453671894@qq.com", "123456"));
	}
	
	public static void main(String[] args) throws IOException{
		testSearchGood();
//		testPosition();
//		testProductMessageReplyServiceImpl();
//		testGoodLeaveMessageServiceImpl();
//		testJson();
//		testPayServiceImpl();
//		testUserServiceImpl();
	}
	
}

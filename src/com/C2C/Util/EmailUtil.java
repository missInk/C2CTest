package com.C2C.Util;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.util.MailSSLSocketFactory;

public class EmailUtil implements Runnable {
	
	private String email;
	private String message;
	private String subject;

	public EmailUtil(String email, String message, String subject) {
		
		this.email = email;
		this.message = message;
		this.subject = subject;
	}

	public void run() {
		String from = "2453671898@qq.com";
		// 指定发送邮件的主机smtp.qq.com(QQ)|smtp.163.com(网易)
		String host = "smtp.qq.com"; 

		Properties properties = System.getProperties();// 获取系统属性

		properties.setProperty("mail.smtp.host", host);// 设置邮件服务器
		properties.setProperty("mail.smtp.auth", "true");// 打开认证

		try {
			//QQ邮箱需要下面这段代码，163邮箱不需要
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sf);
			
			
			// 1.获取默认session对象
			Session session = Session.getDefaultInstance(properties, new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("2453671898@qq.com", "erqczihvyetadigb"); // 发件人邮箱账号、授权码
				}
			});

			// 2.创建邮件对象
			Message message = new MimeMessage(session);
			// 2.1设置发件人
			message.setFrom(new InternetAddress(from));
			// 2.2设置接收人
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			// 2.3设置邮件主题
			message.setSubject(subject);
			// 2.4设置邮件内容
			String content = "<html><head></head><body>" + this.message + "</body></html>";
			message.setContent(content, "text/html;charset=UTF-8");
			// 3.发送邮件
			try {
				Transport.send(message);
			}catch (Exception e) {
				throw new RuntimeException("邮件无法发送到指定邮箱:"+email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Thread(new EmailUtil("2356540901@qq.com", "123","主题")).start();
	}
}

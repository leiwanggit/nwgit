package com.wangl.locust.mail;

public class Test {
    public static void main(String[] args) {
        //这个类主要是设置邮件  
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("jxzcservice@163.com");
        mailInfo.setPassword("aq1sw2de");//您的邮箱密码   
        mailInfo.setFromAddress("jxzcservice@163.com");
        mailInfo.setToAddress("jinxiazuche@163.com");
        mailInfo.setSubject("一封系统问卷");
        mailInfo.setContent("问卷内容");
        //这个类主要来发送邮件  
        SimpleMailSender sms = new SimpleMailSender();
        sms.sendTextMail(mailInfo);//发送文体格式   
        sms.sendHtmlMail(mailInfo);//发送html格式  
    }
}

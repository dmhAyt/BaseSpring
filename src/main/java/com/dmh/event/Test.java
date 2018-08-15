/**
 * Copyright (C), 2015-2018,
 * FileName: Test
 * Author:   deng_yt
 * Date:     2018/8/15 14:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.event;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/15
 * @since 1.0.0
 */
public class Test {
  private static WEmailListener WEmailListener;
  private static Email email;
  private static EmailPublish emailPublish;
  public static void main(String[] args) {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "classpath:applicationContext.xml");
    WEmailListener =applicationContext.getBean(WEmailListener.class);
    emailPublish=applicationContext.getBean(EmailPublish.class);
    Scanner in = new Scanner(System.in);
    System.out.println("请输入发送人：");
    String sender = in.nextLine();
    System.out.println("请输入接收人：");
    String recipient = in.nextLine();
    System.out.println("请输入邮件标题：");
    String title = in.nextLine();
    System.out.println("请输入邮件内容：");
    String content = in.nextLine();
    email = new Email();
    email.setContent(content);
    email.setSender(sender);
    email.setRecipient(recipient);
    email.setTitle(title);
    EmailServerEvent ese = new EmailServerEvent(email);
    emailPublish.publishEvent(ese);
  }
}

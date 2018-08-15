/**
 * Copyright (C), 2015-2018,
 * FileName: EmailListener
 * Author:   deng_yt
 * Date:     2018/8/15 14:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/15
 * @since 1.0.0
 */
@Component
public class YEmailListener implements ApplicationListener<EmailServerEvent> {
  @Async
  @Override
  public void onApplicationEvent(EmailServerEvent event) {
    Email source = event.getSource();
    if("yt".equals(source.getRecipient())){
      System.out.println(this.getClass().getName()+"  "+source);
    }
  }
}

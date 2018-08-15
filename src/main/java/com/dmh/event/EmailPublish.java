/**
 * Copyright (C), 2015-2018,
 * FileName: EmailPublish
 * Author:   deng_yt
 * Date:     2018/8/15 14:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/15
 * @since 1.0.0
 */
@Component
public class EmailPublish implements ApplicationEventPublisherAware {
  private static ApplicationEventPublisher applicationEventPublisher;
  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    EmailPublish.applicationEventPublisher = applicationEventPublisher;
  }
  public  void publishEvent(EmailServerEvent communityArticleEvent) {
    applicationEventPublisher.publishEvent(communityArticleEvent);
  }
}

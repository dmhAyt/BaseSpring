/**
 * Copyright (C), 2015-2018,
 * FileName: EmailServerEvent
 * Author:   deng_yt
 * Date:     2018/8/15 13:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.event;

import org.springframework.context.ApplicationEvent;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/15
 * @since 1.0.0
 */
public class EmailServerEvent extends ApplicationEvent {

  @Override
  public Email getSource() {
    return source;
  }

  public void setSource(Object source,Email email) {
    this.source = email;
  }

  private Email source;

  /**
   * Create a new ApplicationEvent.
   *
   * @param source the object on which the event initially occurred (never {@code null})
   */
  public EmailServerEvent(Email source) {
    super(source);
    this.source = source;
  }
}

/**
 * Copyright (C), 2015-2018,
 * FileName: HandleException
 * Author:   deng_yt
 * Date:     2018/8/22 15:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.controller.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/22
 * @since 1.0.0
 */
@ControllerAdvice
public class HandleException {
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<String> handlerError(IllegalArgumentException ex){
    String message = ex.getMessage();
    return ResponseEntity.badRequest().body(message);
  }
}

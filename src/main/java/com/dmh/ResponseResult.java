/**
 * Copyright (C), 2015-2018,
 * FileName: ResponseResult
 * Author:   deng_yt
 * Date:     2018/9/3 15:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/9/3
 * @since 1.0.0
 */
public class ResponseResult<T> {
  private boolean success;
  private List<T> resultData;
  private String errorMessage;
  public ResponseResult(){

  }

  public ResponseResult(boolean success, List<T> resultData, String errorMessage) {
    this.success = success;
    this.resultData = resultData;
    this.errorMessage = errorMessage;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public List<T> getResultData() {
    return resultData;
  }

  public void setResultData(List<T> resultData) {
    this.resultData = resultData;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}

/**
 * Copyright (C), 2015-2018,
 * FileName: Folder
 * Author:   deng_yt
 * Date:     2018/8/18 12:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.dto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/18
 * @since 1.0.0
 */
public class Folder {
  private static final String  DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
  private Integer folderId;
  private String  folderType = FileType.FOLDER;
  private String  folderName;
  private Date folderCreateDate;
  private Integer folderSuperiorId;
  private Integer folderFileId;
  private Integer folderOwnUser;
  private String folderCreateDateStr;
  private boolean folderActive = true;
  private BigDecimal folderSizes;
  private int rowVersion = 1;
  public Folder(){}

  public Folder(Integer folderId, String folderType, String folderName,
      Date folderCreateDate, Integer folderSuperiorId, Integer folderFileId,
      Integer folderOwnUser, boolean folderActive, BigDecimal folderSizes, int rowVersion) {
    this.folderId = folderId;
    this.folderType = folderType;
    this.folderName = folderName;
    this.folderCreateDate = folderCreateDate;
    this.folderSuperiorId = folderSuperiorId;
    this.folderFileId = folderFileId;
    this.folderOwnUser = folderOwnUser;
    this.folderActive = folderActive;
    this.folderSizes = folderSizes;
    this.rowVersion = rowVersion;
  }

  public String getFolderCreateDateStr() {
    SimpleDateFormat sim = new SimpleDateFormat(DATE_PATTERN);
    return sim.format(folderCreateDate);
  }

  public String getFolderName() {
    return folderName;
  }

  public void setFolderName(String folderName) {
    this.folderName = folderName;
  }

  public Integer getFolderId() {
    return folderId;
  }

  public void setFolderId(Integer folderId) {
    this.folderId = folderId;
  }

  public String getFolderType() {
    return folderType;
  }

  public void setFolderType(String folderType) {
    this.folderType = folderType;
  }

  public Date getFolderCreateDate() {
    return folderCreateDate;
  }

  public void setFolderCreateDate(Date folderCreateDate) {
    this.folderCreateDate = folderCreateDate;
  }

  public Integer getFolderSuperiorId() {
    return folderSuperiorId;
  }

  public void setFolderSuperiorId(Integer folderSuperiorId) {
    this.folderSuperiorId = folderSuperiorId;
  }

  public Integer getFolderFileId() {
    return folderFileId;
  }

  public void setFolderFileId(Integer folderFileId) {
    this.folderFileId = folderFileId;
  }

  public Integer getFolderOwnUser() {
    return folderOwnUser;
  }

  public void setFolderOwnUser(Integer folderOwnUser) {
    this.folderOwnUser = folderOwnUser;
  }

  public int getRowVersion() {
    return rowVersion;
  }

  public void setRowVersion(int rowVersion) {
    this.rowVersion = rowVersion;
  }

  public boolean isFolderActive() {
    return folderActive;
  }

  public void setFolderActive(boolean folderActive) {
    this.folderActive = folderActive;
  }

  public BigDecimal isFolderSize() {
    return folderSizes;
  }

  public void setFolderSizes(BigDecimal folderSizes) {
    this.folderSizes = folderSizes;
  }

  public BigDecimal getFolderSizes() {
    return folderSizes;
  }

  @Override
  public String toString() {
    return "Folder{" +
        "folderId=" + folderId +
        ", folderType='" + folderType + '\'' +
        ", folderName='" + folderName + '\'' +
        ", folderSuperiorId=" + folderSuperiorId +
        ", folderFileId=" + folderFileId +
        ", folderOwnUser=" + folderOwnUser +
        ", folderCreateDateStr='" + folderCreateDateStr + '\'' +
        ", folderActive=" + folderActive +
        ", folderSizes=" + folderSizes +
        ", rowVersion=" + rowVersion +
        '}';
  }
}

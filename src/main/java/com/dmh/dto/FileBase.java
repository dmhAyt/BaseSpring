/**
 * Copyright (C), 2015-2018,
 * FileName: FileBase
 * Author:   deng_yt
 * Date:     2018/8/17 17:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.dto;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/17
 * @since 1.0.0
 */
public class FileBase {
  public static final String[] FILETYPE = {"TXT","ZIP","DOC","JPG"};
  public static final String LEGAL = "Y";
  public static final String ILLEGAL = "N";

  private Integer fileId;
  private String filePathMain;
  private String filePathFirst;
  private String filePathSecond;
  private String fileType;
  private String fileMd5;
  private double fileSize;
  private Date fileCreateDate;
  private int fileReferenceNumber;
  private Integer fileUploadUserId;
  private String fileIsLegal = LEGAL;

  public FileBase(){}

  public FileBase(Integer fileId, String filePathMain, String filePathFirst,
      String filePathSecond, String fileType, String fileMd5, double fileSize,
      Date fileCreateDate, int fileReferenceNumber, Integer fileUploadUserId,
      String fileIsLegal) {
    this.fileId = fileId;
    this.filePathMain = filePathMain;
    this.filePathFirst = filePathFirst;
    this.filePathSecond = filePathSecond;
    this.fileType = fileType;
    this.fileMd5 = fileMd5;
    this.fileSize = fileSize;
    this.fileCreateDate = fileCreateDate;
    this.fileReferenceNumber = fileReferenceNumber;
    this.fileUploadUserId = fileUploadUserId;
    this.fileIsLegal = fileIsLegal;
  }

  public Integer getFileId() {
    return fileId;
  }

  public void setFileId(Integer fileId) {
    this.fileId = fileId;
  }

  public String getFilePathMain() {
    return filePathMain;
  }

  public void setFilePathMain(String filePathMain) {
    this.filePathMain = filePathMain;
  }

  public String getFilePathFirst() {
    return filePathFirst;
  }

  public void setFilePathFirst(String filePathFirst) {
    this.filePathFirst = filePathFirst;
  }

  public String getFilePathSecond() {
    return filePathSecond;
  }

  public void setFilePathSecond(String filePathSecond) {
    this.filePathSecond = filePathSecond;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public String getFileMd5() {
    return fileMd5;
  }

  public void setFileMd5(String fileMd5) {
    this.fileMd5 = fileMd5;
  }

  public double getFileSize() {
    return fileSize;
  }

  public void setFileSize(double fileSize) {
    this.fileSize = fileSize;
  }

  public Date getFileCreateDate() {
    return fileCreateDate;
  }

  public void setFileCreateDate(Date fileCreateDate) {
    this.fileCreateDate = fileCreateDate;
  }

  public int getFileReferenceNumber() {
    return fileReferenceNumber;
  }

  public void setFileReferenceNumber(int fileReferenceNumber) {
    this.fileReferenceNumber = fileReferenceNumber;
  }

  public Integer getFileUploadUserId() {
    return fileUploadUserId;
  }

  public void setFileUploadUserId(Integer fileUploadUserId) {
    this.fileUploadUserId = fileUploadUserId;
  }

  public String getFileIsLegal() {
    return fileIsLegal;
  }

  public void setFileIsLegal(String fileIsLegal) {
    this.fileIsLegal = fileIsLegal;
  }

  @Override
  public String toString() {
    return "{" +
        "fileId=" + fileId +
        ", filePathMain='" + filePathMain + '\'' +
        ", filePathFirst='" + filePathFirst + '\'' +
        ", filePathSecond='" + filePathSecond + '\'' +
        ", fileType='" + fileType + '\'' +
        ", fileMd5='" + fileMd5 + '\'' +
        ", fileSize=" + fileSize +
        ", fileCreateDate=" + fileCreateDate +
        ", fileReferenceNumber=" + fileReferenceNumber +
        ", fileUploadUserId=" + fileUploadUserId +
        ", fileIsLegal='" + fileIsLegal + '\'' +
        '}';
  }
}

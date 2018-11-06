/**
 * Copyright (C), 2015-2018,
 * FileName: FolderServiceImpl
 * Author:   deng_yt
 * Date:     2018/8/22 13:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.service.impl;

import com.dmh.dto.FileType;
import com.dmh.dto.Folder;
import com.dmh.mapper.FolderMapper;
import com.dmh.service.FolderService;
import java.beans.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/22
 * @since 1.0.0
 */
@Service
public class FolderServiceImpl implements FolderService {

  private FolderMapper folderMapper;
  @Autowired
  public void setFolderMapper(FolderMapper folderMapper){
    this.folderMapper = folderMapper;
  }

  @Transactional()
  @Override
  public List<Folder> getFolderBySubFolderId(@NotNull Integer folderId, Integer userId) {
    List<Folder> folderBySuperiorId = folderMapper.findFolderBySuperiorId(folderId, userId);
    return folderBySuperiorId;
  }

  @Override
  public Folder getFolderByFolderId(@NotNull Integer folderId, Integer userId) {
    return folderMapper.findFolderById(folderId,userId);
  }

  @Override
  public Folder alterFolderName(Integer folderId, String folderName,Integer userId) {
    Folder folder = new Folder();
    folder.setFolderId(folderId);
    folder.setFolderName(folderName);
    folder.setFolderActive(true);
    folder.setFolderSuperiorId(-1);
    if(folderMapper.updateFolder(folder)==1){
      return folderMapper.findFolderById(folderId,userId);
    }else{
      return null;
    }
  }

  @Override
  public int deleteFolder(Integer folderId) {
    return  folderMapper.deleteFolder(folderId);
  }

  @Override
  public int insertFolder(Integer subFolderId, String folderName,Integer userId) {
    Folder folder = new Folder(null, FileType.FOLDER,folderName,new Date(),subFolderId,-1,userId,true,new BigDecimal(-1),1);
    return folderMapper.addFolder(folder);
  }

  @Override
  public int deleteFolderList(List<Folder> folders, Integer userId) {
    return folderMapper.deleteFolderList(folders,userId);
  }
}

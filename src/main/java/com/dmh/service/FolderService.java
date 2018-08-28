/**
 * Copyright (C), 2015-2018,
 * FileName: FolderService
 * Author:   deng_yt
 * Date:     2018/8/22 13:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.service;

import com.dmh.dto.Folder;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/22
 * @since 1.0.0
 */
public interface FolderService {
  /**
   *  根据上级文件夹id 查询文件夹中具有的文件。
   * @author deng_yt
   * @date  2018/8/22 13:38
   * @param  folderId 文件夹的唯一 id 。
   * @param  userId 必须的，为用户的ID。
   * @return
   */
  List<Folder> getFolderByFolderId(@NotNull Integer folderId,Integer userId);
  Folder alterFolderName(Integer folderId,String folderName,Integer userId);
  int deleteFolder(Integer folderId);
}

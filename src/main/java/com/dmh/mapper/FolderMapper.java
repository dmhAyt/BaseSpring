/**
 * Copyright (C), 2015-2018,
 * FileName: FolderMapper
 * Author:   deng_yt
 * Date:     2018/8/18 12:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.mapper;

import com.dmh.dto.Folder;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/18
 * @since 1.0.0
 */
public interface FolderMapper {
  // 增加
  int addFolder(@Param("folder") Folder folder);
  // 删除
  //// 根据 id 删除   //// 根据上级目录删除。  启用 spring 的事务管理。。java代码中实现逻辑
  int deleteFolder(@Param("folderId")Integer folderId);
  int deleteFolderList(@Param("folders")List<Folder> folders,@Param("userId")Integer userId);
  //  更改 不能同时修改，只能一个一个来，当 name 为 null 时不做处理 superID 小于0 时不做处理，当为0 时，是在根目录下
  int updateFolder(@Param("folder") Folder folder);
  //  查找 都必须顺带上 user id 进行查询
   //// 根据文件夹 id 查
  Folder findFolderById(@Param("folderId") Integer folderId,@Param("userId") Integer userId);
   //// 根据文件夹的名字和 id 进行查询
  Folder findFolderByIdAndName(@Param("folderId") Integer folderId,@Param("folderName") String folderName,@Param("userId") Integer userId);
   //// 根据上级文件夹的 id 进行查询
  List<Folder> findFolderBySuperiorId(@Param("superId") Integer superId,@Param("userId") Integer userId);

}

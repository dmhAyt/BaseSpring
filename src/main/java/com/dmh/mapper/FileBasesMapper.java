/**
 * Copyright (C), 2015-2018,
 * FileName: FileBasesMapper.xml
 * Author:   deng_yt
 * Date:     2018/8/17 17:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.mapper;

import com.dmh.dto.FileBase;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/17
 * @since 1.0.0
 */
public interface FileBasesMapper {




  /**
   *  增
   * @author deng_yt
   * @date  2018/8/18 9:45
   * @param  fileBase 除了 id 自增，其余的都要填写
   * @return 1 代表插入成功，0 代表插入失败
   */
  int addFileToSystem(@Param("fileBase") FileBase fileBase);

  /**
   *  删
   * @author deng_yt
   * @date  2018/8/18 9:45
   * @param  fileId file的文件 id。
   * @return 1 代表删除成功，0 代表删除失败
   */
  int deleteFileFrom(@Param("fileId") Integer fileId);

  /**
   *  更新， 修改 file 路径，修改引用数，修改是否合法
   * @author deng_yt
   * @date  2018/8/18 9:45
   * @param  fileBase 其中 fileId 是必须传入的参数，当三个路径都不为 null 时修改，为null是不更新；当引用数小于 0 时不做更新；
   *         当修改是否合法 为 null 时，不做更新 。
   * @return 1 代表删除成功，0 代表删除失败
   */
  int updateFileInfor(@Param("fileBase") FileBase fileBase);

  // 查  有单个查（file id 和 file MD5）、有分页查、有按某个人上传的查、按照 file id 批量查。
  //// 通过 fileID 进行查询 MD5 进行查询
  /**
   *  通过 fileID 进行查询 MD5 进行查询; 两个参数不能同时为 null ，当同时为 null 是返回结构为 null。
   *  当根据 id 查询时 fileMD5 为 null ，反之根据 fileMd5 查询。
   * @author deng_yt
   * @date  2018/8/18 10:15
   * @param  fileId file 的 id 号
   * @param  fileMd5 file 的MD5
   * @return
   */
  FileBase findFileByIdOrMd5(@Param("fileId") Integer fileId, @Param("fileMd5") String fileMd5);

  /**
   *  分页查询，主要用于管理者
   * @author deng_yt
   * @date  2018/8/18 10:38
   * @param pageBegin
   * @param pageSize
   * @param orderParameter
   * @return
   */
  List<FileBase> findListFile(@Param("pageBegin")int pageBegin,@Param("pageSize")int pageSize,@Param("orderParameter")String orderParameter);
  /**
   *  有按某个人上传的 分页查询
   * @author deng_yt
   * @date  2018/8/18 10:51
   * @param pageBegin
   * @param pageSize
   * @param userId
   * @return
   */
  List<FileBase> findListFileForUser(@Param("pageBegin")int pageBegin,@Param("pageSize")int pageSize,@Param("userId")Integer userId);
  //// 按照 file id 批量查
  List<FileBase> findListFileForFileId(@Param("fileIdList")List<Integer> fileIdList);
}

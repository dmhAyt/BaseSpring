/**
 * Copyright (C), 2015-2018,
 * FileName: FolderController
 * Author:   deng_yt
 * Date:     2018/8/22 13:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.controller;

import com.dmh.ResponseResult;
import com.dmh.dto.Folder;
import com.dmh.service.FolderService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author deng_yt
 * @create 2018/8/22
 * @since 1.0.0
 */
@RestController
//@SessionAttributes(value = {"userId"})
public class FolderController{

  private FolderService folderService;

  @Autowired
  public void setFolderService(FolderService folderService) {
    this.folderService = folderService;
  }

  private Logger logger = Logger.getLogger(FolderController.class);

  @RequestMapping(path = "/hello.action", method = RequestMethod.GET)
  public String sayHello() {
    logger.warn("say hello ");
    return "hello interceptor";
  }

  // 获得 session cookie 和 文件夹的 id
  @RequestMapping(value = "/folderContext.action",method = RequestMethod.POST)
  public List<Folder> getFolderContext(@RequestBody Folder folder,
      @CookieValue(value = "userID", defaultValue = "-111") String cookie) {
    cookie = "1";
    Map<String, String> errors = new HashMap<>();
    if (folder.getFolderId() != null && folder.getFolderId() >= 0) {
      if (cookie != null && Integer.parseInt(cookie) >= 0) {
        return folderService.getFolderBySubFolderId(folder.getFolderId(), Integer.parseInt(cookie));
      } else {
        errors.put("cookie", "为空");
        throw new IllegalArgumentException(errors.toString());
      }
    } else {
      errors.put("folder", "为空或者小于0");
      throw new IllegalArgumentException(errors.toString());
    }
  }

  @RequestMapping("/deleteFolder.action")
  public int deleteFolder(@RequestBody Folder folder,
      @CookieValue(value = "userID", defaultValue = "-111") String cookie) {
    cookie = "1";
    Map<String, String> errors = new HashMap<>();
    if (folder.getFolderId() != null && folder.getFolderId() >= 0) {
      if (folderService.deleteFolder(folder.getFolderId()) == 1) {
        return 1;
      } else {
        errors.put("errorMessage", "删除失败");
        throw new IllegalArgumentException(errors.toString());
      }
    } else {
      errors.put("folder", "为空或者小于0");
      throw new IllegalArgumentException(errors.toString());
    }
  }

  @RequestMapping("/alterFolderName.action")
  public Folder alterFolderName(@RequestBody Folder folder,
      @CookieValue(value = "userID", defaultValue = "-111") String cookie) {
    cookie = "1";
    Map<String, String> errors = new HashMap<>();
    if (folder.getFolderId() != null && folder.getFolderId() >= 0) {
      if (folder.getFolderName() != null && !"".equals(folder.getFolderName())) {
        Folder folder1 = folderService
            .alterFolderName(folder.getFolderId(), folder.getFolderName(),
                Integer.parseInt(cookie));
        if (folder1 == null) {
          errors.put("errorMessage", "没有这个对应的文件");
          throw new IllegalArgumentException(errors.toString());
        } else {
          return folderService.getFolderByFolderId(folder1.getFolderId(), Integer.parseInt(cookie));
        }
      } else {
        errors.put("folderName", "不能为空");
        throw new IllegalArgumentException(errors.toString());
      }
    } else {
      errors.put("folder", "为空或者小于0");
      throw new IllegalArgumentException(errors.toString());
    }
  }

  @RequestMapping("/newFolder.action")
  public int newFolder(@RequestBody Folder folderss,
      @CookieValue(value = "userID", defaultValue = "-111") String cookie) {
    cookie = "1";
    Map<String, String> errors = new HashMap<>();
    if (folderss.getFolderSuperiorId() != null && folderss.getFolderSuperiorId() >= 0) {
      if (folderss.getFolderName() != null && !"".equals(folderss.getFolderName())) {
        int i = folderService.insertFolder(folderss.getFolderSuperiorId(), folderss.getFolderName(),
            Integer.parseInt(cookie));
        if (i == 0) {
          errors.put("errorMessage", "创建失败");
          throw new IllegalArgumentException(errors.toString());
        } else {
          return i;
        }
      } else {
        errors.put("folderName", "不能为空");
        throw new IllegalArgumentException(errors.toString());
      }
    } else {
      errors.put("folder", "为空或者小于0");
      throw new IllegalArgumentException(errors.toString());
    }
  }

  @RequestMapping("deleteList.action")
  public ResponseResult<String> deleteList(@RequestBody List<Folder> folders,
      @CookieValue(value = "userID", defaultValue = "-111") String cookie) {
    cookie = "1";
    // cookie 判断，没写

    if (folders != null && folders.size() > 0) {
      List<String> resutl = new ArrayList<>();
      resutl.add(String.valueOf(folderService.deleteFolderList(folders, Integer.parseInt(cookie))));
      return new ResponseResult<>(true, null, null);
    } else {
      return new ResponseResult<>(false, null, "it is error data");
    }

  }


}

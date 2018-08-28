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

import com.dmh.dto.Folder;
import com.dmh.service.FolderService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class FolderController {

  private FolderService folderService;

  @Autowired
  public void setFolderService(FolderService folderService) {
    this.folderService = folderService;
  }

  // 获得 session cookie 和 文件夹的 id
  @RequestMapping("/folderContext.action")
  public List<Folder> getFolderContext(@RequestParam("folderId") Integer folderId,
      @CookieValue(value = "userID", defaultValue = "-111") String cookie) {
    cookie = "1";
    Map<String, String> errors = new HashMap<>();
    if (folderId != null && folderId >= 0) {
      if (cookie != null && Integer.parseInt(cookie) >= 0) {
        return folderService.getFolderByFolderId(folderId, Integer.parseInt(cookie));
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
  public int deleteFolder(@RequestParam("folderId") Integer folderId,
      @CookieValue(value = "userID", defaultValue = "-111") String cookie) {
    cookie = "1";
    Map<String, String> errors = new HashMap<>();
    if (folderId != null && folderId >= 0) {
      if (folderService.deleteFolder(folderId) == 1) {
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
  public Folder alterFolderName(@RequestParam("folderId") Integer folderId,
      @RequestParam("folderName") String folderName,
      @CookieValue(value = "userID", defaultValue = "-111") String cookie) {
    cookie = "1";
    Map<String, String> errors = new HashMap<>();
    if (folderId != null && folderId >= 0) {
      if (folderName != null && !"".equals(folderName)) {
        Folder folder = folderService
            .alterFolderName(folderId, folderName, Integer.parseInt(cookie));
        if (folder == null) {
          errors.put("errorMessage", "没有这个对应的文件");
          throw new IllegalArgumentException(errors.toString());
        } else {
          return folder;
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


}

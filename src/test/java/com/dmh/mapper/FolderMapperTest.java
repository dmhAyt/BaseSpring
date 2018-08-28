package com.dmh.mapper;

import com.dmh.dto.FileType;
import com.dmh.dto.Folder;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by deng_yt on 2018/8/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class FolderMapperTest {
  @Autowired
  private FolderMapper folderMapper;

  @Test
  public void addFolder() throws Exception {
    Folder folder = new Folder(null,FileType.FOLDER,"java design",new Date(),0,0,1,true,new  BigDecimal("-1"),1);
    System.out.println(folderMapper.addFolder(folder));
  }

  @Test
  public void deleteFolder() throws Exception {
    folderMapper.deleteFolder(22);
  }

  @Test
  public void updateFolder() throws Exception {
    Folder folder = new Folder(22,FileType.FOLDER,"java designs",new Date(),1,0,1,true,new  BigDecimal("-1")

        ,1);
    folderMapper.updateFolder(folder);
  }

  @Test
  public void findFolderById() throws Exception {
    System.out.println(folderMapper.findFolderById(22,1));
  }

  @Test
  public void findFolderByIdAndName() throws Exception {
    System.out.println(folderMapper.findFolderByIdAndName(1,"java",1));
  }

  @Test
  public void findFolderBySuperiorId() throws Exception {
    System.out.println(folderMapper.findFolderBySuperiorId(0,1));
  }

}
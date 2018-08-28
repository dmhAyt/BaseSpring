package com.dmh.mapper;

import com.dmh.dto.FileBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by deng_yt on 2018/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class FileBasesMapperTest {
  @Autowired
  private FileBasesMapper fileBasesMapper;

  @Test
  public void addFileToSystem() throws Exception {
    FileBase fileBase = new FileBase(null,"kkkk","kkkkx","kkkkk2","ZIP","kksfjksldfsf",2000.0f,new Date(),1,1,"Y");
    int i = fileBasesMapper.addFileToSystem(fileBase);
    System.out.println(i);
  }

  @Test
  public void deleteFileFrom() throws Exception {
    System.out.println(fileBasesMapper.deleteFileFrom(1));
  }

  @Test
  public void updateFileInfor() throws Exception {
    FileBase fileBase = new FileBase(1,"/kkkMain","/kkkfirst",null,"ZIP","kksfjksldfsf",2000.0f,new Date(),2,1,null);
    System.out.println(fileBasesMapper.updateFileInfor(fileBase));
  }

  @Test
  public void findFileByIdOrMd5() throws Exception {
//    System.out.println(fileBasesMapper.findFileByIdOrMd5(1,null));
//    System.out.println(fileBasesMapper.findFileByIdOrMd5(null,"kksfjksldfsf"));
    System.out.println(fileBasesMapper.findFileByIdOrMd5(null,null));
  }


  @Test
  public void findListFile() throws Exception {
    System.out.println(fileBasesMapper.findListFile(3,3,"file_id"));
  }

  @Test
  public void findListFileForUser() throws Exception {
    System.out.println(fileBasesMapper.findListFileForUser(0,3,1));
  }

  @Test
  public void findListFileForFileId() throws Exception {
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    System.out.println(fileBasesMapper.findListFileForFileId(list));
  }

}
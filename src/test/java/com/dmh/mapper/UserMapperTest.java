package com.dmh.mapper;

import com.dmh.dto.User;
import java.util.Date;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by deng_yt on 2018/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {
  @Autowired
  private UserMapper userMapper;

  @Test
  public void testFindUserByCode() throws Exception {
    User userByCode = userMapper.findUserByCodeAndPass("dmyAyt","password");
    System.out.println(userByCode);
  }

  @Test
  public void testFindUserById() throws Exception {
    User userById = userMapper.findUserById(1);
    System.out.println(userById);
  }

  @Test
  public void testAddUser() throws Exception {
    User user = new User("dmyAyt1","dmh1","password1",User.CAPACITY,0,new Date(),new Date(),User.LEGAL,null);
    userMapper.addUser(user);
  }
  @Test
  public void testFindUserCount() throws Exception {
    Map<String, Integer> userCount = userMapper.findUserCount();
    System.out.println(userCount);
  }
  @Test
  public void testUpdateUserInfor() throws Exception {
   int i =  userMapper.updateUserInfor("dmh",null,-1,-1,new Date(),3);
    System.out.println(i);
  }
  @Test
  public void testDeleteUserById() throws Exception {
   int i =  userMapper.deleteUserById(2);
    System.out.println(i);
  }

  @Test
  public void testfindAllUser() throws Exception {
    System.out.println(userMapper.findAllUser());
  }


}
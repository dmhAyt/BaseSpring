/**
 * Copyright (C), 2015-2018,
 * FileName: TestCustomerMapper
 * Author:   deng_yt
 * Date:     2018/8/14 16:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.test;

import com.dmh.dao.mapper.CustomerMapper;
import com.dmh.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/14
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestCustomerMapper {

  private CustomerMapper customerMapper;

  @Autowired
  public void setCustomerMapper(CustomerMapper customerMapper) {
    this.customerMapper = customerMapper;
  }

  @Test
  public void testFindByName(){
    Customer hello = customerMapper.findCustomerByName("hello");
    System.out.println(hello);
    hello.setName("dengmeihou");
    customerMapper.addCustomer(hello);


  }

}

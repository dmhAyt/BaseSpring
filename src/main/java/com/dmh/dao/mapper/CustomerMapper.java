/**
 * Copyright (C), 2015-2018,
 * FileName: CustomerMapper
 * Author:   deng_yt
 * Date:     2018/8/14 16:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.dao.mapper;

import com.dmh.entity.Customer;
import org.springframework.stereotype.Repository;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/14
 * @since 1.0.0
 */
@Repository
public interface CustomerMapper {

  Customer findCustomerByName(String name);

  void addCustomer(Customer cu);

}

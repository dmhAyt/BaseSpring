/**
 * Copyright (C), 2015-2018,
 * FileName: UserMapper
 * Author:   deng_yt
 * Date:     2018/8/14 16:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.mapper;
import com.dmh.dto.User;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/14
 * @since 1.0.0
 */

public interface UserMapper {

  /**
   *  通过 name 查找用户。
   * @author deng_yt
   * @date  2018/8/16 16:32
   * @param  code 用户名。
   * @param  pass 用户名。
   * @return  返回用户数据。
   */
  User findUserByCodeAndPass(@Param("code") String code,@Param("pass")String pass);

  /**
   *  描述
   * @author deng_yt
   * @date  2018/8/16 19:34
   * @param id 用户 id。
   * @return
   */
  User findUserById(Integer id);

  /**
   *  增加用户数据
   * @author deng_yt
   * @date  2018/8/16 16:34
   * @param  cu 用户数据。
   * @return  无返回值。
   */
  void addUser(User cu);

  /**
   *  查询用户数量和合法用户数量
   * @author deng_yt
   * @date  2018/8/16 19:58
   * @return
   */
  Map<String,Integer> findUserCount();

  /**
   * 更新用户信息，其中 id 为用户 id
   * @author deng_yt
   * @date  2018/8/17 15:56
   * @param userName 用户昵称，当为 null 时不进行更新
   * @param userPass 用户密码，当为 null 时不进行更新
   * @param accountCapacity 用户账号容量，当小于等于 0 时不进行更新
   * @param usedCapacity 账号已使用容量，当小于 0 时不进行更新
   * @param accountAlterDate 信息更新时间， 必须的
   * @param id 用户 id ， 必须的
   *
   * @return 1 表示更新成功，0 表示更新失败。
   */
  int updateUserInfor(@Param("userName") String userName,@Param("userPass")String userPass,@Param("accountCapacity")double accountCapacity,
      @Param("usedCapacity") double usedCapacity,@Param("accountAlterDate")Date accountAlterDate,@Param("id") Integer id);

  /**
   *  描述
   * @author deng_yt
   * @date  2018/8/17 16:15
   * @param  id 删除用户的 id
   * @return  1 表示更新成功，0 表示更新失败。
   */
  int deleteUserById(@Param("id") Integer id);

  List<User> findAllUser();
}

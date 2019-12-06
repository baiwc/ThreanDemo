package com.proxy;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户实体类〉
 *
 * @author baiwc
 * @date 2019-12-02 15:25
 * @since 2019.12.02
 */
public class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("保存用户数据信息==========！！！");
    }
}
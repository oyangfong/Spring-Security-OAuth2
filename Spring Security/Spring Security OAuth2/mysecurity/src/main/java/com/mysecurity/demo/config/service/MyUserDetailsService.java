package com.mysecurity.demo.config.service;

import com.mysecurity.demo.config.bean.MyUserDetails;
import com.mysecurity.demo.dao.UserMapper;

import com.mysecurity.demo.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

// 3-2. 用户身份验证 MyUserDetailsService

/**
 * 用户身份认证服务类
 * */
@Component("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        // 此处调用userMapper类的方法完成用户登录操作
        try {
            User user=userMapper.findByUserName(new User(username));
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            if(null!=user){
                String rolesStr=user.getRoles();  //获取用户角色
                String[] roles=rolesStr.split(",");
                for (String roleName:roles) {
                    SimpleGrantedAuthority grant = new SimpleGrantedAuthority(roleName);
                    authorities.add(grant);  // 添加用户角色至集合中
                }

                //封装自定义UserDetails类
                userDetails = new MyUserDetails(user, authorities);

            }else{
                throw new UsernameNotFoundException("该用户不存在！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        //User user = new User(username, "123456",
          //      AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return userDetails;
    }
}

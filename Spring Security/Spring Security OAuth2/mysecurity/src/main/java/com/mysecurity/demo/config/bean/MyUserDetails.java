package com.mysecurity.demo.config.bean;



import com.mysecurity.demo.pojo.User;
import org.springframework.security.core.GrantedAuthority;


import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

// 3-1. 创建UserDetails的实现类
// 为了使得我们的用户角色类能和security中的能够结合起来，需要重新建一个类MyUserDetails实现UserDetails接口。

/**
 * 自定义用户身份信息
 * */
public class MyUserDetails implements UserDetails {
    // 用户信息
    private User user;
    // 用户角色
    private Collection<? extends GrantedAuthority> authorities;

    public MyUserDetails(User user, Collection<? extends GrantedAuthority> authorities) {
        super();
        this.user = user;
        this.authorities = authorities;
    }


    private static final long serialVersionUID = 1L;
    //用户权限集合
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    //密码
    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    //用户名
    @Override
    public String getUsername() {
        return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
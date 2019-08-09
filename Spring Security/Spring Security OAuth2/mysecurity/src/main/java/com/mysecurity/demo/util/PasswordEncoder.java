package com.mysecurity.demo.util;



/**
 * @Description: 密码加密类
 */
public class PasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Util.encode((String) rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {//user Details Service验证
        return encodedPassword.equals(MD5Util.encode((String) rawPassword));
    }

}
package com.example.lab55mapstructdemo.dataobject;

import lombok.Data;

/**
 * @author LZT
 * @data 2022/7/8
 */
@Data
public class UserDO {
    /** 用户编号 **/
    private Integer id;
    /** 用户名 **/
    private String username;
    /** 密码 **/
    private String password;
}

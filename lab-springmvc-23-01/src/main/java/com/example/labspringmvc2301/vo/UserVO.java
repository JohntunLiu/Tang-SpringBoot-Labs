package com.example.labspringmvc2301.vo;

/**
 * @author LZT
 * @data 2022/7/11
 */

import lombok.Data;

/**
 * 用户 VO
 */
@Data
public class UserVO {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;
}

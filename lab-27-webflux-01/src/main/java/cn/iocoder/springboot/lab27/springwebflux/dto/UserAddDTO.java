package cn.iocoder.springboot.lab27.springwebflux.dto;

import lombok.Data;

/**
 * @author LZT
 * @data 2022/7/11
 */
@Data
public class UserAddDTO {
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}

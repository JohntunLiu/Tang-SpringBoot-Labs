package com.example.labspringmvc2301.service;

import com.example.labspringmvc2301.vo.UserVO;
import org.springframework.stereotype.Service;

/**
 * @author LZT
 * @data 2022/7/11
 */
@Service
public class UserService {
    public UserVO get(Integer id) {
        return new UserVO().setId(id).setUsername("test");
    }
}

package com.example.labspringmvc2301.controller;

import com.example.labspringmvc2301.dto.UserAddDTO;
import com.example.labspringmvc2301.dto.UserUpdateDTO;
import com.example.labspringmvc2301.service.UserService;
import com.example.labspringmvc2301.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LZT
 * @data 2022/7/11
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<UserVO> list() {
        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO().setId(1).setUsername("yudaoyuanma"));
        result.add(new UserVO().setId(2).setUsername("woshiyutou"));
        result.add(new UserVO().setId(3).setUsername("chifanshuijiao"));
        return result;
    }

    @GetMapping("/{id}")
    public UserVO get(@PathVariable("id") Integer id) {
        return new UserVO().setId(id).setUsername("username:" + id);
    }
    @GetMapping("/v2/{id}")
    public UserVO get2(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @PostMapping("")
    public Integer add(UserAddDTO userAddDTO) {
        return 1;
    }

    @PutMapping("/{id}")
    public Boolean update(@PathVariable("id") Integer id, UserUpdateDTO updateDTO) {
        updateDTO.setId(id);
        Boolean isSuccess = true;
        return isSuccess;
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        Boolean isSuccess = false;
        return isSuccess;
    }
}

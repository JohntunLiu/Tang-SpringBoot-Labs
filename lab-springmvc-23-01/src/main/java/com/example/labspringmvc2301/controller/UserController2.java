package com.example.labspringmvc2301.controller;

import com.example.labspringmvc2301.dto.UserAddDTO;
import com.example.labspringmvc2301.dto.UserUpdateDTO;
import com.example.labspringmvc2301.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author LZT
 * @data 2022/7/11
 */
@RestController
@RequestMapping("/users2")
public class UserController2 {

    @GetMapping("/list")
    public List<UserVO> list() {
        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO().setId(1).setUsername("yudaoyuanma"));
        result.add(new UserVO().setId(2).setUsername("woshiyutou"));
        result.add(new UserVO().setId(3).setUsername("chifanshuijiao"));
        return result;
    }

    @GetMapping("/get")
    public UserVO get(@RequestParam("id") Integer id) {
        return new UserVO().setId(id).setUsername("username:" + id);
    }

    @PostMapping("/add")
    public Integer add(UserAddDTO userAddDTO) {
        Integer returnId = UUID.randomUUID().hashCode();
        return returnId;
    }

    @PostMapping("/update")
    public Boolean update(UserUpdateDTO updateDTO) {
        Boolean isSuccess = true;
        return isSuccess;
    }

    @GetMapping("/delete")
    public Boolean delete(@RequestParam("id") Integer id) {
        Boolean isSuccess = false;
        return isSuccess;
    }
}

package cn.iocoder.springboot.lab23.springmvc.controller;

import cn.iocoder.springboot.lab23.springmvc.core.vo.UserVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author LZT
 * @data 2022/7/14
 */
@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*", allowCredentials = "true") // 允许所有来源，允许发送 Cookie
public class TestController {

    /**
     * 获得指定用户编号的用户
     *
     * @return 用户
     */
    @GetMapping("/get")
    @CrossOrigin(allowCredentials = "false") // 允许所有来源，不允许发送 Cookie
    public UserVO get() {
        return new UserVO().setId(1).setUsername(UUID.randomUUID().toString());
    }

}

package com.example.lab55mapstructdemo;

import com.example.lab55mapstructdemo.bo.UserBO;
import com.example.lab55mapstructdemo.convert.UserConvert;
import com.example.lab55mapstructdemo.dataobject.UserDO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lab55MapstructDemoApplicationTests {

    @Test
    void contextLoads() {
        // 创建 UserDO 对象
        UserDO userDO = new UserDO()
                .setId(1).setUsername("yudaoyuanma").setPassword("buzhidao");
        // <X> 进行转换
//        UserBO userBO = UserConvert.INSTANCE.convert(userDO);
//        System.out.println(userBO.getId());
//        System.out.println(userBO.getUsername());
//        System.out.println(userBO.getPassword());
        System.out.println("123");
    }

}

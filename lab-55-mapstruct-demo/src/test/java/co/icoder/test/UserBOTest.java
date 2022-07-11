package co.icoder.test;

import com.example.lab55mapstructdemo.bo.UserBO;
import com.example.lab55mapstructdemo.convert.UserConvert;
import com.example.lab55mapstructdemo.dataobject.UserDO;

/**
 * @author LZT
 * @data 2022/7/8
 */
public class UserBOTest {
    public static void main(String[] args) {
        // 创建 UserDO 对象
        UserDO userDO = new UserDO()
                .setId(1).setUsername("yudaoyuanma").setPassword("buzhidao");
        // <X> 进行转换
        UserBO userBO = UserConvert.INSTANCE.convert(userDO);
        System.out.println(userBO.getId());
        System.out.println(userBO.getUsername());
        System.out.println(userBO.getPassword());
    }
}

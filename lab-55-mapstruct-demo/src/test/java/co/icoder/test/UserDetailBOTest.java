package co.icoder.test;

import com.example.lab55mapstructdemo.bo.UserDetailBO;
import com.example.lab55mapstructdemo.convert.UserConvert;
import com.example.lab55mapstructdemo.dataobject.UserDO;

/**
 * @author LZT
 * @data 2022/7/8
 */
public class UserDetailBOTest {
    public static void main(String[] args) {
        // 创建 UserDO 对象
        UserDO userDO = new UserDO()
                .setId(1).setUsername("yudaoyuanma").setPassword("buzhidao");
        // 进行转换
        UserDetailBO userDetailBO = UserConvert.INSTANCE.convertDetail(userDO);
        System.out.println(userDetailBO.getUserId());
    }
}

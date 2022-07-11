package com.example.lab55mapstructdemo.convert;

import com.example.lab55mapstructdemo.bo.UserBO;
import com.example.lab55mapstructdemo.bo.UserDetailBO;
import com.example.lab55mapstructdemo.dataobject.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author LZT
 * @data 2022/7/8
 */
@Mapper // <1>
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class); // <2>

    UserBO convert(UserDO userDO);

    @Mappings({
            @Mapping(source = "id", target = "userId")
    })
    UserDetailBO convertDetail(UserDO userDO);

}
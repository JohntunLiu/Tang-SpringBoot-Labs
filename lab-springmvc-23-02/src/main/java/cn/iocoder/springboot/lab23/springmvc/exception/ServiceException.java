package cn.iocoder.springboot.lab23.springmvc.exception;

import cn.iocoder.springboot.lab23.springmvc.constants.ServiceExceptionEnum;
import lombok.Getter;

/**
 * @author LZT
 * @data 2022/7/13
 */
// ServiceException.java
@Getter
public final class ServiceException extends RuntimeException {

    /**
     * 错误码
     */
    private final Integer code;

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        // 使用父类的 message 字段
        super(serviceExceptionEnum.getMessage());
        // 设置错误码
        this.code = serviceExceptionEnum.getCode();
    }

    // ... 省略 getting 方法

}

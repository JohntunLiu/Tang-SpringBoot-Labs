package cn.iocoder.springboot.lab23.springmvc.constants;

import lombok.Getter;

/**
 * @author LZT
 * @data 2022/7/13
 */
@Getter
public enum ServiceExceptionEnum {

    // ========== 系统级别 ==========
    SUCCESS(0, "成功"),
    SYS_ERROR(2001001000, "服务端发生异常"),
    MISSING_REQUEST_PARAM_ERROR(2001001001, "参数缺失"),

    // ========== 用户模块 ==========
    USER_NOT_FOUND(1001002000, "用户不存在"),

    // ========== 订单模块 ==========

    // ========== 商品模块 ==========
    ;

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误提示
     */
    private String message;

    ServiceExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // ... 省略 getting 方法


    /**
     * 服务异常
     *
     * 参考 https://www.kancloud.cn/onebase/ob/484204 文章
     *
     * 一共 10 位，分成四段
     *
     * 第一段，1 位，类型
     *      1 - 业务级别异常
     *      2 - 系统级别异常
     * 第二段，3 位，系统类型
     *      001 - 用户系统
     *      002 - 商品系统
     *      003 - 订单系统
     *      004 - 支付系统
     *      005 - 优惠劵系统
     *      ... - ...
     * 第三段，3 位，模块
     *      不限制规则。
     *      一般建议，每个系统里面，可能有多个模块，可以再去做分段。以用户系统为例子：
     *          001 - OAuth2 模块
     *          002 - User 模块
     *          003 - MobileCode 模块
     * 第四段，3 位，错误码
     *       不限制规则。
     *       一般建议，每个模块自增。
     */
}

package tangTest.service;

import tangTest.enumClass.RoleEnum;

public class JudgeRole {
    public static void main(String[] args) {
        RoleEnum userRole = RoleEnum.ROLE_ORDER_ADMIN;

        // 一行代码搞定！之前的if/else灰飞烟灭
        System.out.println(RoleEnum.valueOf("ROLE_ORDER_ADMIN").op());
    }
}

package tangTest.service;

import tangTest.bo.User;
import tangTest.enumClass.UserRole;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class TestEnum {
    public static void main(String[] args) {
        UserRole role1 = UserRole.ROLE_ROOT_ADMIN;
        UserRole role2 = UserRole.ROLE_ORDER_ADMIN;
        UserRole role3 = UserRole.ROLE_NORMAL;
        for (UserRole value : UserRole.values()) {
            System.out.println(value);
        }

        // ordinal()方法：返回枚举常量的序数，注意从0开始
        System.out.println(role1.ordinal()); // 打印0
        System.out.println(role2.ordinal()); // 打印1
        System.out.println(role3.ordinal()); // 打印2

        // compareTo()方法：枚举常量间的比较
        System.out.println(role1.compareTo(role2)); //打印-1
        System.out.println(role2.compareTo(role3)); //打印-1
        System.out.println(role1.compareTo(role3)); //打印-2

        // name()方法：获得枚举常量的名称
        System.out.println(role1.name()); // 打印ROLE_ROOT_ADMIN
        System.out.println(role2.name()); // 打印ROLE_ORDER_ADMIN
        System.out.println(role3.name()); // 打印ROLE_NORMAL

        // valueOf()方法：返回指定名称的枚举常量
        System.out.println(UserRole.valueOf("ROLE_ROOT_ADMIN"));
        System.out.println(UserRole.valueOf("ROLE_ORDER_ADMIN"));
        System.out.println(UserRole.valueOf("ROLE_NORMAL"));

        System.out.println("================");
        UserRole userRole = UserRole.ROLE_ORDER_ADMIN;
        switch (userRole) {
            case ROLE_ROOT_ADMIN:  // 比如此处的意义就非常清晰了，比1，2，3这种数字好！
                System.out.println("这是系统管理员角色");
                break;
            case ROLE_ORDER_ADMIN:
                System.out.println("这是订单管理员角色");
                break;
            case ROLE_NORMAL:
                System.out.println("这是普通用户角色");
                break;
        }

        System.out.println(UserRole.getRoleCodeByRoleName("系统管理员"));

        System.out.println("===============");
        System.out.println(new TestEnum().isAdmin());

        Map<UserRole,Integer> userStatisticMap = new EnumMap<>(UserRole.class);

        ArrayList<User> users = new ArrayList<>();
        users.add(new User(UserRole.ROLE_NORMAL, "jack"));
        users.add(new User(UserRole.ROLE_NORMAL, "jack2"));
        users.add(new User(UserRole.ROLE_NORMAL, "jack"));
        users.add(new User(UserRole.ROLE_NORMAL, "jack"));
        users.add(new User(UserRole.ROLE_ORDER_ADMIN, "jack2"));
        users.add(new User(UserRole.ROLE_NORMAL, "jack"));
        users.add(new User(UserRole.ROLE_NORMAL, "jack"));
        for ( User user : users ) {
            Integer num = userStatisticMap.get( user.getUserRole() );
            if( null != num ) {
                userStatisticMap.put( user.getUserRole(), num+1 );
            } else {
                userStatisticMap.put( user.getUserRole(), 1 );
            }
        }
        System.out.println(userStatisticMap);

    }
    EnumSet<UserRole> userRoles = EnumSet.of(UserRole.ROLE_NORMAL, UserRole.ROLE_ORDER_ADMIN);

    Boolean isAdmin() {
        if (userRoles.contains(UserRole.ROLE_NORMAL)) {
            return true;
        }
        return false;
    }
}

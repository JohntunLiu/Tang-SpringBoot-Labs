package tangTest.enumClass;

public enum UserRole {
    ROLE_ROOT_ADMIN( "系统管理员", 000000 ),
    ROLE_ORDER_ADMIN( "订单管理员", 100000 ),
    ROLE_NORMAL( "普通用户", 200000 ),
    ;

    private  final String roleName;
    private final Integer roleCode;

    UserRole(String roleName, Integer roleCode) {
        this.roleName = roleName;
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public Integer getRoleCode() {
        return roleCode;
    }

    public static Integer getRoleCodeByRoleName( String roleName ) {
        for( UserRole enums : UserRole.values() ) {
            if( enums.getRoleName().equals( roleName ) ) {
                return enums.getRoleCode();
            }
        }
        return null;
    }
}

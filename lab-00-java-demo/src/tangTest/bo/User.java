package tangTest.bo;

import lombok.Data;
import tangTest.enumClass.UserRole;
@Data
public class User {
    private UserRole userRole;
    private String userName;

    public User(UserRole userRole, String userName) {
        this.userRole = userRole;
        this.userName = userName;
    }
}

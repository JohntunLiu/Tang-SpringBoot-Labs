package tangTest.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Major implements Serializable {
    private String majorName;
    private Long majorId;

    public Major(String majorName, Long majorId) {
        this.majorName = majorName;
        this.majorId = majorId;
    }
}

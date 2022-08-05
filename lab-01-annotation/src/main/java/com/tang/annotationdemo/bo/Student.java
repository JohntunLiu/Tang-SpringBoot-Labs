package com.tang.annotationdemo.bo;

import com.tang.annotationdemo.Length;
import lombok.Data;

@Data
public class Student {

    private String name;

    private Long id;

    @Length(min = 11,max=11, errorMsg = "wrong phone number!")
    private String phoneNum;

    public Student(String name, Long id, String phoneNum) {
        this.name = name;
        this.id = id;
        this.phoneNum = phoneNum;
    }
}

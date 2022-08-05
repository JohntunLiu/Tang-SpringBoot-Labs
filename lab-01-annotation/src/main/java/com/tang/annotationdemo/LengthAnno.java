package com.tang.annotationdemo;

import com.tang.annotationdemo.bo.Student;

import java.lang.reflect.Field;

public class LengthAnno  {

    public static String validate(Object object) throws IllegalAccessException{
        //get object fields
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            //judge @Length exist
            if (field.isAnnotationPresent(Length.class)) {
                //get @Length info
                Length len = field.getAnnotation(Length.class);
                //let us access private field
                field.setAccessible(true);
                int value = ((String) field.get(object)).length();
                if (value < len.min() || value > len.max()) {
                    return len.errorMsg();
                }

            }
        }
        return null;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Student kara = new Student("kara", 123l, "1234567890");
//        System.out.println(validate(kara));
        System.out.println(kara);
    }
}

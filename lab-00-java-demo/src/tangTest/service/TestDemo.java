package tangTest.service;


import sun.misc.Unsafe;
import tangTest.bo.Major;
import tangTest.bo.Student;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;

public class TestDemo {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        serialize();
        deserialize();
    }

    static void serialize() throws IOException {
        Major math = new Major("math", 23434l);
        Student student = new Student("jack", 12l, math);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(new File("student.txt").toPath()));
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
        System.out.println("序列化成功！已经生成student.txt文件");
        System.out.println("==============================================");
    }

    static void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(new File("student.txt").toPath()));
        Student o = (Student) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("deserialize result:");
        System.out.println(o);
    }

        static void demo02() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);
            Student student =  (Student)unsafe.allocateInstance(Student.class);
            System.out.println(student.setName("rouse").toString());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

    }
    /*
    * 深拷贝 deep copy
    * */
    static void demo01() throws CloneNotSupportedException {
        Major math = new Major("math", 23434l);
        Student student = new Student("jack", 12l, math);
        Student clone = (Student) student.clone();
        math.setMajorName("English");

        System.out.println(clone.toString());
        System.out.println(student.toString());
    }
}

package tangTest.service;


import tangTest.bo.Major;
import tangTest.bo.Student;

public class TestDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        demo01();
    }

    static void demo02() {

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

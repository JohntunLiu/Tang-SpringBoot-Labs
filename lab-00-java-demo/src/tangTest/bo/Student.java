package tangTest.bo;

import lombok.Data;

import java.io.*;

@Data
public class Student implements Serializable {
    private String name;
    private Long id;
    private Major major;

    @Override
    public Object clone() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (Student) objectInputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public Student(String name, Long id, Major major) {
        this.name = name;
        this.id = id;
        this.major = major;
    }
}

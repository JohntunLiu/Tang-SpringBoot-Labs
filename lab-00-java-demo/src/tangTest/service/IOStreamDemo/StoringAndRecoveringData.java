package tangTest.service.IOStreamDemo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StoringAndRecoveringData {

    public static void main(String[] args) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("SystemInReader.txt")));
        outputStream.writeDouble(3.1415927);
        outputStream.writeInt(5);
        outputStream.writeUTF("你好");
        outputStream.writeUTF("world");
        outputStream.close();

        DataInputStream inputStream = new DataInputStream(new BufferedInputStream(Files.newInputStream(Paths.get("SystemInReader.txt"))));
        //顺序固定的
        System.out.println(inputStream.readDouble());
        System.out.println(inputStream.readInt());
        System.out.println(inputStream.readUTF());
        System.out.println(inputStream.readUTF());
        inputStream.close();
    }
}

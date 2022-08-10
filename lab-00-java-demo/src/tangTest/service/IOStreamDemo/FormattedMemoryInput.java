package tangTest.service.IOStreamDemo;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {
    public static void main(String[] args) {
        String file = "/users/liuzongtang/IdeaProjects/Tang-SpringBoot-Labs/SystemInReader.txt";

        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.readFile(file).getBytes()));
            while(true){
                System.out.println((char) dataInputStream.readByte());
            }
        } catch (EOFException e) {
            System.out.println("end of stream, e = " + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

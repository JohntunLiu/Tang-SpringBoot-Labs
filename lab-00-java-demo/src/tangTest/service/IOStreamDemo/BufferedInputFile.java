package tangTest.service.IOStreamDemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/*
* 缓冲输入文件
* */
public class BufferedInputFile {
    public static String readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder stringBuilder = new StringBuilder();

        while ((s = reader.readLine()) != null) {
            stringBuilder.append(s);
        }
        reader.close();
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        String file = "/users/liuzongtang/IdeaProjects/Tang-SpringBoot-Labs/SystemInReader.txt";
        System.out.println(readFile(file));
    }
}

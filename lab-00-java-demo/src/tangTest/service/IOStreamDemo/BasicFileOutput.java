package tangTest.service.IOStreamDemo;


import java.io.*;

/*
* FileWriter对象可以向文件写入数据。首先创建一个FileWriter和指定的文件关联，然后使用BufferedWriter将其包装提供缓冲功能，为了提供格式化机制，它又被装饰成为PrintWriter
* */
public class BasicFileOutput {

    public static void main(String[] args) throws IOException {
        String file = "lab-00-java-demo/src/tangTest/service/IOStreamDemo/BasicFileOutput.java";
        String file1 = "lab-00-java-demo/src/tangTest/service/IOStreamDemo/BasicFileOutput.out";
        BufferedReader reader = new BufferedReader(new StringReader(BufferedInputFile.readFile(file)));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file1)));

        int lineCount = 1;
        String s;
        while ((s = reader.readLine()) != null) {
            printWriter.println(lineCount ++ + ":" + s);
        }
        printWriter.close();
        reader.close();

    }
}

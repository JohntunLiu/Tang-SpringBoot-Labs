package tangTest.service.IOStreamDemo;

import java.io.*;
import java.util.regex.Pattern;

public class IOStreamDemo {
    public static File[] getLocalFiles(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] getLocalFiles(String dir, final String regex) {
        return getLocalFiles(new File(dir), regex);
    }

    public static void main(String[] args) throws IOException {
        SystemInReader();
    }

/*
* 该程序等待会一直等待我们输入，输入啥，后面会接着输出。输入空字符串可以结束
* */
    public static void SystemInReader() throws IOException {
        String dir = "/users/liuzongtang/IdeaProjects/Tang-SpringBoot-Labs/SystemInReader.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(dir);
        PrintStream printStream = new PrintStream(fileOutputStream);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s ;
        while ((s = reader.readLine()) != null && s.length() != 0) {
            System.out.println(s);
                System.setOut(printStream);
        }
    }

    public static void directory() {
        //         Pattern pattern = Pattern.compile(".*\\.txt");
//        System.out.println(pattern.matcher(new File("long.txt").getName()).matches());
        String dir = "/users/liuzongtang/IdeaProjects/Tang-SpringBoot-Labs";
//        File file1 = new File(dir);
//        System.out.println(file1.getAbsolutePath());
        File[] files = IOStreamDemo.getLocalFiles(dir, ".*\\.txt");
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }


}

package tangTest.service.IOStreamDemo;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

public class ZipFileUtils {
    public static void compressFiles(File[] files, String zipPath) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(zipPath);
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new Adler32());
        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream);
        zipOutputStream.setComment("zip test");

        for (File file : files) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));

            int c;
            while ((c = reader.read()) != -1) {
                bufferedOutputStream.write(c);
            }
            reader.close();
            bufferedOutputStream.flush();
        }
        bufferedOutputStream.close();
    }

    public static void unCompressZip(String zipPath, String destPath) throws IOException {
        if (!destPath.endsWith(File.separator)) {
            destPath = destPath + File.separator;
            File file = new File(destPath);
            if (!file.exists()) {
                file.mkdirs();
            }
        }

        FileInputStream fileInputStream = new FileInputStream(zipPath);
        CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);

        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            System.out.println("unCompressZip.." + zipEntry);

            //write to dest file
            int size;
            byte[] buffer = new byte[1024];
            FileOutputStream fileOutputStream = new FileOutputStream(destPath + zipEntry.getName());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, buffer.length);
            while ((size = bufferedInputStream.read(buffer, 0, buffer.length)) != -1) {
                bufferedOutputStream.write(buffer, 0, size);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }
        bufferedInputStream.close();
        System.out.println("校验和：" + checkedInputStream.getChecksum().getValue());


    }


    public static void main(String[] args) throws IOException {
        //压缩文件
//        String dir = "/users/liuzongtang/IdeaProjects/Tang-SpringBoot-Labs";
//        File[] files = IOStreamDemo.getLocalFiles(dir, ".*\\.txt");
//        compressFiles(files,dir+"/lab-00-java-demo/compressFiles.zip");

        //解压文件
//        String dest = "/users/liuzongtang/IdeaProjects/Tang-SpringBoot-Labs/lab-00-java-demo";
//        String zipDir = "/users/liuzongtang/IdeaProjects/Tang-SpringBoot-Labs/lab-00-java-demo/compressFiles.zip";
//        unCompressZip(zipDir, dest);

        String zipDir = "/users/liuzongtang/IdeaProjects/Tang-SpringBoot-Labs/lab-00-java-demo/compressFiles.zip";
        ZipFile zipFile = new ZipFile(zipDir);
        Enumeration e = zipFile.entries();
        while (e.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) e.nextElement();
            System.out.println("file:"+ zipEntry);
        }



    }
}

package _01_Strumienie.pliki;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipExample {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\pliki\\example.zip");
            ZipOutputStream zos = new ZipOutputStream(fos);

            File fileToZip = new File("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\pliki\\file.txt");
            FileInputStream fis = new FileInputStream(fileToZip);

            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int len;

            while((len = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            zos.close();
            System.out.println("File zipped successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

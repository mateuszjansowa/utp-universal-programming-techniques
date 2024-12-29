package _01_Strumienie.pliki;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipExample {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\pliki\\example.zip");
            ZipInputStream zis = new ZipInputStream(fis);

            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("Unzipping: " + entry.getName());

                FileOutputStream fos = new FileOutputStream(entry.getName());
                byte[] buffer = new byte[1024];
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
            }

            zis.closeEntry();

            System.out.println("Unzip completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

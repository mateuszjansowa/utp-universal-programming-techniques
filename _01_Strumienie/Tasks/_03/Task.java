package _01_Strumienie.Tasks._03;

import java.io.*;

public class Task {
    public static void main(String[] args) {
        File file = new File("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\Tasks\\_03\\data_folder");

        try {
            if (file.exists() || file.mkdir()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists");
                return;
            }

            BufferedWriter inputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\Tasks\\_03\\data_folder\\input_utf8.txt"), "UTF-8"));
            inputWriter.write("Witaj, świecie!\n" +
                    "Kodowanie znaków w Javie.");
            inputWriter.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\Tasks\\_03\\data_folder\\input_utf8.txt"), "UTF-8"));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\Tasks\\_03\\data_folder\\output_iso.txt"), "ISO-8859-2"));

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            br.close();
            bw.close();
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

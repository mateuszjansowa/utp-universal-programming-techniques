package _01_Strumienie.Tasks._04;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class Task {
    public static void main(String[] args) {
        try {
            PipedWriter writer = new PipedWriter();
            PipedReader reader = new PipedReader(writer);

            DataProducer producer = new DataProducer(writer);
            DataCompressor compressor = new DataCompressor(reader);

            producer.start();
            compressor.start();

            producer.join();
            compressor.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DataProducer extends Thread {
    private PipedWriter writer;

    public DataProducer(PipedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                writer.write("Line " + i);
                writer.write("\n");
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error running Producer Thread: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println("Failed to close writer: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}

class DataCompressor extends Thread {
    private PipedReader reader;

    public DataCompressor(PipedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(reader);
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(new FileOutputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\Tasks\\_04\\compressed_data.gz"));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                byte[] compressedData = line.getBytes();
                gzipOutputStream.write(compressedData);
                gzipOutputStream.write("\n".getBytes());
                System.out.println("Compressed: " + line);
            }

            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("Issue while compressing file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
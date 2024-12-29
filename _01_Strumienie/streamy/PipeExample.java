package _01_Strumienie.streamy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

class Producer extends Thread {
    private PipedWriter writer;

    public Producer(PipedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                writer.write("Message " + i + "\n");
                Thread.sleep(1000);
            }
            writer.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private PipedReader reader;

    public Consumer(PipedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Consumed: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class PipeExample {
    public static void main(String[] args) throws IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader(writer);

        new Producer(writer).start();
        new Consumer(reader).start();
    }
}

package _01_Strumienie.kodowanie;

import java.io.*;

public class Convert {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Syntax: in in_enc out out_enc");
            System.exit(1);
        }

        String infile = args[0];
        String in_enc = args[1];
        String out = args[2];
        String out_enc = args[3];

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(infile), in_enc));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out), out_enc));

            String line;
            while((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

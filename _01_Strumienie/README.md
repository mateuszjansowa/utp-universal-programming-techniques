# 01 Strumienie

- **Strumień** - logiczny ciąg danych, które można pobierać lub dodawać w sposób abstrakcyjny - niezależnie od źródła / odbiornika.
- **Pakiet Java I/O**
    - [`java.io`](http://java.io) - klasy dla strumieni bajtowych i znakowych
    - `java.nio`- nwoczesne rozwiązania, takie jak kanały i bufory.

**Proces pracy ze strumieniem:**

1. Powiązanie strumienia ze źródłem / odbiornikiem
2. Otwieranie
3. Odczyt / zapis danych
4. Zamykanie

## Klasy strumieniowe

**Kierunek danych**

- wejściowe - do odczytu
- wyjściowe - do zapisu

**Rodzaj danych**

- bajtowe
- znakowe

| **Operacja** | **Bajtowe** | **Znakowe** |
| --- | --- | --- |
| Wejście | `InputStream` | `Reader` |
| Wyjście | `OutputStream` | `Writer` |

**Przykład operacji bajtowej**

- korzystamy z `FileInputStream` oraz `FileOutputStream`

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream("input.txt");
             FileOutputStream out = new FileOutputStream("output.txt")) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
    }
}
```

**Przykład opreacji na znakach**

- korzystamy z `FileReader` oraz `FileWriter`

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharOperation {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\operacje\\input.txt\"");
            FileWriter fileWriter = new FileWriter("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\operacje\\output.txt\"");

            int c;

            while((c = fileReader.read()) != -1) {
                fileWriter.write(c);
            }
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
```

## Strumieniowe Klasy Przedmiotowe

Strumienie musza być powiązane z konkretnym źródłem / odbiornikiem. Źródła w Javie:

| Źródło/Odbiornik | Znakowe Strumienie | Bajtowe Strumienie |
| --- | --- | --- |
| **Pamięć** | `CharArrayReader`, `CharArrayWriter` | `ByteArrayInputStream`, `ByteArrayOutputStream` |
| **Plik** | `FileReader`, `FileWriter` | `FileInputStream`, `FileOutputStream` |
| **Potok** | `PipedReader`, `PipedWriter` | `PipedInputStream`, `PipedOutputStream` |

## Klasy przetwarzające

Wykonują dodatkowe operacje na danych (np. buforowanie, kompresja i konwersja).

- buforowanie: `BufferedReader` i `BufferedWriter`
- kompresja: `GZIPOutputStream` i `GZIPInputStream`
- konwersja: `InputStreamReader` i `OutputStreamWriter`

Buforowanie

```java

import java.io.*;

public class BufferedExample {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\buforowanie\\log.json"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\buforowanie\\target.json")));

            String line;

            while((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```
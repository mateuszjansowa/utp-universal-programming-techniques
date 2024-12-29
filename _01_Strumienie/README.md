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

**Buforowanie**

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

## Hierarchie dziedziczenia klas strumieniowych

W Java hierarchia klas strumieniowych dzieli się na:

1. **Klasy przetwarzające** - służą do przekształcania danych (np. bufory, konwersje)
   Np. `BufferedReader`, `PrintWriter`

2. **Klasy przedmiotowe** - opierają się na konkretnych źródłach / odbiornikach danych (np. pliki, potoki, pamięci).
   Np. `FileReader`, `FileWriter` czy `ByteArrayInputStream` (dla pamięci).

Podstawowe klasy abstrakcyjne tworzące hierarchię to:

- **Strumienie bajtowe**
  - `InputStream`
  - `OutputStream`
- **Strumienie znakowe**
  - `Reader`
  - `Writer`

## Buforowanie

Znacząco przyspiesza operacje wejścia-wyjścia poprzez minimalizację odwołań do fizycznych urządzeń (np. dysku). Działa to dzięki gromadzeniu danych w buforze, który stanowi wydzielone miejsce w pamięci. Dane czytane są w większych porcjach, zamiast pojedynczo.

Np.

```java
BufferedReader br = new BufferedReader(fr);

String line;
while ((line = br.readLine()) != null) {
    System.out.println(line);
}
```

pozwala wygodnie czytać wiersz po wierszu za pomocą `readLine`.

Klasy buforujące mają metodę `flush()`, która pozwala zapisać pozostałe dane z bufora do miejsca docelowego.

## Strumienie binarne

Pozwalają na odczyt i zapis danych w formacie binarnym. Są bardziej efektywne niż tekstowe dla danych takich jak liczby, obiekty, czy dane binarne.

Opierają się na klasach:

- `DataInputStream` - odczyt danych
- `DataOutputStream` - zapis danych

… oba należy zamykać za pomocą `close()`.

Najważniejsze metody to:

- `readInt()`, `readDouble()` - odczyt liczb;
- `writeInt(int val)`, `writeDouble(double val)` - zapis do strumienia.

```java
package _01_Strumienie.strumienie_binarne;

import java.io.*;

public class BinData {
    public static void main(String[] args) {
        double[] a = {1, 2, 3, 4};
        double[] b = {5, 6};

        Obs obsA = new Obs("Dane A", a);
        Obs obsB = new Obs("Dane B", b);

        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\strumienie_binarne\\dane.bin"));
            obsA.writeTo(out);
            obsB.writeTo(out);
            out.close();

            DataInputStream in = new DataInputStream(new FileInputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\strumienie_binarne\\dane.bin"));
            new Obs().readFrom(in).show(); // strumien odczytuje dane A
            new Obs().readFrom(in).show(); // strumien odczytuje dane B (tam gdzie skonczyl poprzedni)
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```

## Kodowanie

Java używa **Unicode** jako swojego wewnętrznego systemu kodowania znaków. Unicode reprezentuje znaki jako wartości 16-bitowe (dwa bajty na znak). Aby umożliwić obsługę plików zakodowanych inaczej, strumienie znakowe automatycznie wykonują konwersję między bajtami a znakami Unicode.

- Dane bajtowe z pliku są dekodowane do UTF-8 na Unicode za pomocą `InputStreamReader` , a `BufferedReader` pozwala efektywnie odczytywać całe linie znaków.

```java
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteToChar {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("file.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // linia jako ciag znakow
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

- Jeśli plik ma inne kodowanie niż domyślne, możesz je podać w konstruktorze, np.:

```java
InputStreamReader isr = new InputStreamReader(new FileInputStream("plik.txt"), "UTF-8");
```

- Podanie kodowania podczas zapisu:

```java
OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("plik.txt"), "ISO-8859-2");
```

Program Convert służący do konwersji z jednego kodowania na drugie:

```java
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

```

## Serializacja

Serializacja w Javie umożliwia łatwe zapisywanie i odczytywanie obiektów, dzięki czemu można zachowywać ich stan między uruchomieniami programu. W praktyce używamy jej głównie do:

1. Przechowywania danych na dysku.
2. Wymiany danych w sieci (np. za pomocą `Socket`).
3. Tworzenia kopii zapasowych obiektów.

Sposób działania:

- Obiekt jest serializowany, jeśli klasa implementuje interfejs **`Serializable`**.
- **Pola `transient`** i **`static`** nie są zapisywane podczas serializacji.
- Domyślnie zapis i odczyt realizowany jest metodami:
  - `writeObject(Object o)` – zapisuje obiekt do strumienia.
  - `readObject()` – odczytuje obiekt ze strumienia.

**Przykład prostej serializacji i deserializacji**

```java
package _01_Strumienie.serializacja;

import java.io.*;

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Person{name=" + name + ", age=" + age + "}";
    }
}

public class SimplePerson {
    public static void main(String[] args) {
        Person person = new Person("Mati", 28);

        // Serializacja
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\serializacja\\person.ser"));
            oos.writeObject(person);
        } catch(IOException e) {
            e.printStackTrace();
        }

        // Deserializacja
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\serializacja\\person.ser"));
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Odczytano: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

**Zaawansowany przykład serializacji**

- poniższy program pozwala m.in. przechowywać dane o wycieczkach pomiędzy kolejnymi użyciami programu

```java
package _01_Strumienie.serializacja;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Travel implements Serializable {
    protected String destination;
    private int price;

    public Travel(String destination, int price) {
        this.destination = destination;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "destination='" + destination + '\'' +
                ", price=" + price +
                '}';
    }
}

class TravelSearcher implements Serializable {
    private List<Travel> travels = new ArrayList<>();

    public void addTravel(Travel travel) {
        travels.add(travel);
    }

    public Travel findTravel(String destination) {
        return travels.stream()
                .filter(t -> t.destination.equalsIgnoreCase(destination))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "TravelSearcher{" + "travels=" + travels + "}";
    }
}

public class TravelApp {
    public static void main(String[] args) {
        TravelSearcher searcher = new TravelSearcher();
        searcher.addTravel(new Travel("Cyprus", 1500));
        searcher.addTravel(new Travel("Crete", 1750));

        // Serializacja
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\serializacja\\travels.ser"));
            oos.writeObject(searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserializacja
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\serializacja\\travels.ser"));
            TravelSearcher deserializedSearcher = (TravelSearcher) ois.readObject();
            System.out.println("Odczytano: " + deserializedSearcher);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

```

- Pola oznaczone jako `transient` są pomijane podczas serializacji. Możesz użyć ich do przechowywania danych tymczasowych.

    ```java
    private transient int tempValue;
    ```


## Potoki (Streamy)

Potoki w Javie służą do uproszczonej komunikacji między wątkami poprzez przekazywanie danych między strumieniami. Dzięki klasom takim jak `PipedWriter` i `PipedReader` możliwa jest synchroniczna wymiana danych bez potrzeby ręcznej synchronizacji.

- **`PipedWriter` / `PipedReader`**
  - Dla znaków Unicode.
  - Używane, gdy komunikacja dotyczy tekstu.
- **`PipedOutputStream` / `PipedInputStream`**
  - Dla strumieni bajtowych.
  - Używane, gdy dane są w formacie binarnym.

**Przykład korzystania z PipedWriter i PipedReader do automatycznej synchronizacji międy wątkami**

```java
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

```

Wskazówki dot. pracy z potokami

- **Unikaj Deadlocka:** Potoki wymagają starannego zarządzania, by uniknąć sytuacji, w której pisanie/czytanie blokuje się wzajemnie.
- **Wydajność:** Korzystanie z buforowania (np. `BufferedReader`) poprawia efektywność przy dużej liczbie operacji.
- **Pamiętaj o Unicode:** Dla tekstu zaleca się `PipedWriter` i `PipedReader` zamiast bajtowych `PipedOutputStream` i `PipedInputStream`.

## Obiekty plikowe

- `java.io.File`
- Klasa `File` reprezentuje pliki i katalogi, umożliwiając operacje na systemie plikowym.
- **Wybrane metody:**
  - `createNewFile()`, `mkdir()`, `delete()`: tworzenie/usuwanie plików/katalogów.
  - `exists()`, `isFile()`, `isDirectory()`: sprawdzanie istnienia i rodzaju.
  - `length()`, `lastModified()`: informacje o pliku.
  - `list()`, `listFiles()`: zawartość katalogu.
  - `renameTo(File dest)`: zmiana nazwy.
  - `setReadOnly()`, `canRead()`, `canWrite()`: prawa dostępu.

```java
import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        File file = new File("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\pliki\\file.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists!");
            }

            System.out.println("Path: " + file.getPath());
            System.out.println("Is directory: " + file.isDirectory());
            System.out.println("Can read: " + file.canRead());
            System.out.println("Can write: " + file.canWrite());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## Pliki o dostępie swobodnym

- `RandomAccessFile`
- Pliki, które można odczytywać i zapisywać w dowolnym miejscu bez potrzeby przetwarzania od początku.
- **Konstruktory:**
  - `RandomAccessFile(String filename, String mode)`
  - `RandomAccessFile(File file, String mode)`
- **Tryby dostępu:**
  - `"r"` – tylko do odczytu.
  - `"rw"` – do odczytu i zapisu.
  - `"rws"`, `"rwd"` – z wymuszeniem synchronicznego zapisu na dysk.
- **Metody:**
  - `seek(long pos)`: ustawia wskaźnik pozycji.
  - `read...()`, `write...()`: odczyt/zapis danych.

```java
import java.io.RandomAccessFile;

public class RandomAccessExample {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\pliki\\data.txt", "rw");
            raf.writeUTF("Hello, world!");
            raf.seek(0);

            String data = raf.readUTF();
            System.out.println("Read from file: " + data);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
```

## Archiwizacja i kompresja

- `java.util.zip`
- Narzędzia do pracy z plikami ZIP oraz kompresji danych (ZLIB).
- **Wybrane klasy:**
  - `ZipOutputStream`, `ZipInputStream`: tworzenie i rozpakowywanie ZIP.
  - `DeflaterOutputStream`, `InflaterInputStream`: kompresja/dekompresja strumieni.
  - `GZIPOutputStream`, `GZIPInputStream`: kompresja/dekompresja w formacie GZIP.
  - `ZipEntry`: reprezentuje element w archiwum ZIP.
  - `ZipFile`: umożliwia odczyt elementów ZIP w dowolnej kolejności.

**Kompresja pliku**

```java
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
```

**Rozpakowywanie skompresowanego pliku**

```java
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
```

## Scanner i formatter

- **`java.util.Scanner`**

`Scanner` to elastyczne narzędzie do przetwarzania danych tekstowych, takich jak ciągi znaków, pliki, strumienie, czy kanały.

Cechy:

1. **Obsługa różnych źródeł:**
  - Ciągi (`String`), pliki (`File`), strumienie (`InputStream`), kanały (`Readable`).
2. **Wyrażenia regularne:**
  - Używa separatorów do rozdzielania danych.
  - Możliwość stosowania złożonych wyrażeń regularnych.
3. **Obsługa danych typów prostych:**
  - Parsowanie liczb (`nextInt`, `nextDouble`) i tekstów (`next`, `nextLine`).

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        String input = "John Doe/3000\nAliceSmith/4500";
        List<Employee> employees = new ArrayList<>();

        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line).useDelimiter("/");

            String name = lineScanner.next();
            double salary = lineScanner.nextDouble();

            employees.add(new Employee(name, salary));
        }

        employees.forEach(System.out::println);
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
```

- **`java.util.Formatter`**

`Formatter` umożliwia formatowanie tekstu w stylu podobnym do funkcji `printf` w języku C.

Cechy:

1. **Destynacja formatowania:**
  - Może być to plik, `String`, `OutputStream`, `Writer`, itp.
2. **Symbolika formatowania:**
  - `%s`: ciąg znaków.
  - `%d`: liczba całkowita.
  - `%f`: liczba zmiennoprzecinkowa.
  - `%t`: data/czas.

```java
import java.util.Formatter;

public class FormatterExample {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        formatter.format("Name: %s, Age: %d, Salary: %.2f", "John Doe", 30, 4500.50);
        System.out.println(formatter);
        formatter.close();
    }
}
```

**Przykład użycia z plikiem**

```java
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileFormatting {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
            writer.printf("Name: %s, Age: %d", "Bob", 40);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```
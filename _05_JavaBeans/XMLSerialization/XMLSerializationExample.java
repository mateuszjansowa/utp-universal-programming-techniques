package _05_JavaBeans.XMLSerialization;

import _05_JavaBeans.AdvancedExample.Counter;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XMLSerializationExample {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        counter.setCount(123);

        // serializacja do XML
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("D:\\coding\\Java\\UTP\\src\\_05_JavaBeans\\XMLSerialization\\counter.xml")))) {
            encoder.writeObject(counter);
        }

        // deserializacja z XML
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("D:\\coding\\Java\\UTP\\src\\_05_JavaBeans\\XMLSerialization\\counter.xml")))) {
            Counter deserializedCounter = (Counter) decoder.readObject();
            System.out.println("Wartość odczytana: " + deserializedCounter.getCount());
        }
    }
}

package _02_Kolekcje.Tasks.Lists.Task_03;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Task_03 {
    public static void main(String[] args) {
        LinkedList<String> employees = new LinkedList<>(List.of("Kowalski", "Nowak",  "Wiśniewski", "Wójcik", "Kowalczyk", "Lewandowski"));
        Iterator<String> iterator = employees.iterator();

        while(iterator.hasNext()) {
            String surname = iterator.next();
            if(surname.endsWith("ski")) {
                iterator.remove();
            }
        }

        employees.addFirst("Zieliński");
        employees.addLast("Kamiński");

        System.out.println(employees);
    }
}

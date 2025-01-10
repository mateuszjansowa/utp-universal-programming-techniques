package _04_Dynamic_Java.UniversalJsonSerializer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.lang.reflect.Field;
import java.util.List;

public class UniversalJsonSerializer<T> {
    public String serialize(List<T> objects) {
        Gson gson = new Gson();
        StringBuilder result = new StringBuilder("[");

        for (T obj : objects) {
            JsonObject json = new JsonObject();
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    json.addProperty(field.getName(), field.get(obj).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            result.append(gson.toJson(json)).append(",");
        }

        if (!result.isEmpty()) {
            result.setLength(result.length() - 1); // usuniecie ostatniego przecinka
        }
        result.append("]");

        return result.toString();
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Kowalski Jan", "1960-10-12", 2700.5),
                new Employee("Kowalska Aneta", "1995-05-12", 4300.5),
                new Employee("Nowak Michał", "1996-11-12", 1700.5)
        );

        UniversalJsonSerializer<Employee> serializer = new UniversalJsonSerializer<>();
        String json = serializer.serialize(employees);
        System.out.println(json);
    }
}

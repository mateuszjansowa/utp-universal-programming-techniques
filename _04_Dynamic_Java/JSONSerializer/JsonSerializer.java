package _04_Dynamic_Java.JSONSerializer;

import java.lang.reflect.Field;

public class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");
        Class<?> clazz = obj.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                json.append("\"").append(field.getName()).append("\": \"").append(field.get(obj)).append("\", ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // usuniecie ostatniego przecinka
        if (json.length() > 1) {
            json.setLength(json.length() - 2);
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        Product product = new Product(1, "PC");
        String json = toJson(product);
        System.out.println(json); // {"id": "1", "name": "PC"}
    }
}

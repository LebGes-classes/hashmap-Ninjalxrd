import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //--------------------------------------Тесты-------------------------------------------------------
        MyHashmap<String,Integer> hashMap = new MyHashmap<>();

        // 1 - добавление новых пар ключ-значение
        hashMap.put("Алексей",70);
        hashMap.put("Абоба",23);
        hashMap.put("Денис Ким",18);
        hashMap.put("Данилка",19);
        hashMap.put("Тигр",52);
        hashMap.put("Навальный",23);
        hashMap.put("Алексей",12); //ячейка должна перезаписаться, т.к. хэш и ключ одинаковы

        // 2 - размер (должен быть 7, т.к 7 пар)
        System.out.println(hashMap.size());

        //3 - удаление по ключу
        hashMap.remove("Навальный");

        //4 - проверка по значению/ключу
        System.out.println(hashMap.containsValue(52)); // true
        System.out.println(hashMap.containsKey("Навальный")); //false - т.к. был удален

        //5 - get
        System.out.println(hashMap.get("52")); // такого значения нет - null
        System.out.println(hashMap.get("Абоба")); //23


    }
}
package homework_01;

import java.util.*;

class MyKey {
    private int id;

    public MyKey(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public String toString() {
        return "MyKey{" +
                "id=" + id +
                '}';
    }
}


public class ExampleMap<K, V> {
    private HashMap<K, V> map;

    public ExampleMap() {
        this.map = new HashMap<>();
    }

    public V put(K key, V value) {
        return map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return map.entrySet();
    }

    public static void main(String[] args) {
        ExampleMap<MyKey, String> exampleMap = new ExampleMap<>();


        for (int i = 1; i < 15; i++) {
            MyKey key = new MyKey(i);
            exampleMap.put(key, "Some Value " + i);

//            for (Map.Entry<MyKey, String> entry : exampleMap.entrySet()) {
//                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue() + " |||| "
//                        + entry.getClass());
//            }

            Set<Map.Entry<MyKey, String>> entrySet = exampleMap.entrySet();
            Map.Entry<MyKey, String> entry = entrySet.iterator().next();

            System.out.println("Finish size = " + exampleMap.entrySet().size() + " ----- Type " + entry.getClass());
        }

    }
}
import java.util.LinkedList;
import java.util.List;

/**
 * Класс HashTable, реализующий хэш-таблицу с использованием метода цепочек.
 * Соответствует требованиям Задания 1.
 */
public class HashTable<K, V> {
    
    private static final int INITIAL_CAPACITY = 16;
    private List<Entry<K, V>>[] table; // Массив цепочек (LinkedList)
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.table = new LinkedList[INITIAL_CAPACITY];
        this.size = 0;
    }

    /** Хеш-функция, преобразует ключ в индекс массива. */
    private int hash(K key) {
        if (key == null) return 0;
        // Используем встроенный hashCode и операцию по модулю
        return Math.abs(key.hashCode() % table.length);
    }

    // --- Реализация put(key, value) ---
    public void put(K key, V value) {
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        // Поиск: если ключ найден, обновляем значение и выходим
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return; 
            }
        }

        // Если ключ не найден, добавляем новую пару
        table[index].add(new Entry<>(key, value));
        size++;
    }

    // --- Реализация get(key) ---
    public V get(K key) {
        int index = hash(key);
        List<Entry<K, V>> bucket = table[index];

        if (bucket == null) return null;

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    // --- Реализация remove(key) ---
    public V remove(K key) {
        int index = hash(key);
        List<Entry<K, V>> bucket = table[index];

        if (bucket == null) return null;

        for (int i = 0; i < bucket.size(); i++) {
            Entry<K, V> entry = bucket.get(i);
            if (entry.getKey().equals(key)) {
                V removedValue = entry.getValue();
                bucket.remove(i);
                size--;
                return removedValue;
            }
        }
        return null;
    }
    
    // --- Реализация size() и isEmpty() ---
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public static void main(String[] args) {
        HashTable<String, Integer> ht = new HashTable<>();
        System.out.println("HT пуста? " + ht.isEmpty()); // true

        ht.put("Java", 1);
        ht.put("Python", 2);
        ht.put("Java", 3); // Обновление
        
        System.out.println("Размер: " + ht.size()); // 2
        System.out.println("Значение Java: " + ht.get("Java")); // 3
        
        ht.remove("Python");
        System.out.println("Размер после удаления: " + ht.size()); // 1
        System.out.println("Значение Python: " + ht.get("Python")); // null
    }
}
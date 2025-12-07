import java.util.LinkedList;

public class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    // Внутренний класс для хранения пар
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Конструктор
    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    // Хеш-функция
    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // 1. Добавление/обновление
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    // 2. Получение значения
    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    // 3. Удаление
    public V remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            var iterator = table[index].iterator();
            while (iterator.hasNext()) {
                Entry<K, V> entry = iterator.next();
                if (entry.key.equals(key)) {
                    V value = entry.value;
                    iterator.remove();
                    size--;
                    return value;
                }
            }
        }
        return null;
    }

    // 4. Количество элементов
    public int size() {
        return size;
    }

    // 5. Проверка на пустоту
    public boolean isEmpty() {
        return size == 0;
    }
}
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> {
    
    private static final int INITIAL_CAPACITY = 16;
    private List<Entry<K, V>>[] table; // Массив цепочек LinkedList
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.table = new LinkedList[INITIAL_CAPACITY];
        this.size = 0;
    }

    private int hash(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode() % table.length);
    }

    public void put(K key, V value) {
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return; 
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;
    }

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
    
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public static void main(String[] args) {
        HashTable<String, Integer> ht = new HashTable<>();
        System.out.println("HT пуста? " + ht.isEmpty()); 

        ht.put("Java", 1);
        ht.put("Python", 2);
        ht.put("Java", 3); 
        
        System.out.println("Размер: " + ht.size()); 
        System.out.println("Значение Java: " + ht.get("Java"));
        
        ht.remove("Python");
        System.out.println("Размер после удаления: " + ht.size()); 
        System.out.println("Значение Python: " + ht.get("Python")); 
    }
}
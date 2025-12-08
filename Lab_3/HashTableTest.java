public class HashTableTest {

    // Это наш входной метод для запуска приложения
    public static void main(String[] args) {
        
        // 1. Создаем объект хеш-таблицы с емкостью 10
        System.out.println("--- Создание хеш-таблицы ---");
        HashTable<String, Integer> scores = new HashTable<>(10);
        
        // Проверяем, пуста ли она
        System.out.println("Пуста ли таблица? " + scores.isEmpty()); // Вывод: true
        
        System.out.println("\n--- Добавление элементов (put) ---");
        // 2. Добавляем элементы
        scores.put("Алиса", 95);
        scores.put("Боб", 88);
        scores.put("Чарли", 72);
        
        System.out.println("Размер таблицы: " + scores.size()); // Вывод: 3
        
        System.out.println("\n--- Обновление элемента (put) ---");
        // 3. Обновляем значение для существующего ключа
        scores.put("Алиса", 100); 
        
        System.out.println("\n--- Получение элементов (get) ---");
        // 4. Получаем значения по ключам
        System.out.println("Оценка Алисы: " + scores.get("Алиса"));   // Вывод: 100
        System.out.println("Оценка Боба: " + scores.get("Боб"));     // Вывод: 88
        System.out.println("Оценка Дианы: " + scores.get("Диана")); // Вывод: null (нет такого ключа)
        
        System.out.println("\n--- Удаление элемента (remove) ---");
        // 5. Удаляем элемент
        Integer removedScore = scores.remove("Боб");
        System.out.println("Удаленная оценка Боба: " + removedScore); // Вывод: 88
        
        // 6. Проверяем размер после удаления
        System.out.println("Новый размер таблицы: " + scores.size()); // Вывод: 2
        
        // Пытаемся получить удаленный элемент
        System.out.println("Оценка Боба после удаления: " + scores.get("Боб")); // Вывод: null
        
        System.out.println("\nПуста ли таблица? " + scores.isEmpty()); // Вывод: false
    }
}
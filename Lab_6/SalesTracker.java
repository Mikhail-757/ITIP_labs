import java.util.*;

public class SalesTracker {
    private Map<String, Integer> sales = new HashMap<>();
    
    // Добавление проданного товара
    public void addSale(String product) {
        sales.put(product, sales.getOrDefault(product, 0) + 1);
    }
    
    // Вывод списка проданных товаров
    public void printSales() {
        System.out.println("Проданные товары:");
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " шт.");
        }
    }
    
    // Подсчет общей суммы продаж
    public int getTotalSales() {
        return sales.values().stream().mapToInt(Integer::intValue).sum();
    }
    
    // Поиск наиболее популярного товара
    public String getMostPopularProduct() {
        return sales.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Нет продаж");
    }
    
    // Пример использования
    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();
        
        tracker.addSale("Яблоко");
        tracker.addSale("Банан");
        tracker.addSale("Яблоко");
        tracker.addSale("Апельсин");
        tracker.addSale("Банан");
        tracker.addSale("Яблоко");
        
        tracker.printSales();
        System.out.println("Общее количество продаж: " + tracker.getTotalSales());
        System.out.println("Самый популярный товар: " + tracker.getMostPopularProduct());
    }
}
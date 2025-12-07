import java.util.HashMap;

// Класс для хранения информации о продукте
class Product {
    private String name;
    private String description; // Добавлено поле "описание"
    private double price;
    private int quantity;
    
    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description; // Инициализация поля "описание"
        this.price = price;
        this.quantity = quantity;
    }
    
    // Геттеры и сеттеры
    public String getName() { return name; }
    public String getDescription() { return description; } // Геттер для описания
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setDescription(String description) { this.description = description; } // Сеттер для описания
    
    @Override
    public String toString() {
        return String.format("Товар: %s, Описание: %s, Цена: %.2f, Количество: %d", 
                             name, description, price, quantity);
    }
}

// Класс для управления складом с использованием HashMap
public class Warehouse {
    private HashMap<String, Product> inventory;
    
    public Warehouse() {
        inventory = new HashMap<>();
    }
    
    // Добавление/обновление товара (теперь с описанием)
    public void addProduct(String barcode, String name, String description, double price, int quantity) {
        if (inventory.containsKey(barcode)) {
            Product existing = inventory.get(barcode);
            existing.setQuantity(existing.getQuantity() + quantity);
            // Можно также обновить описание, если требуется
            existing.setDescription(description);
        } else {
            inventory.put(barcode, new Product(name, description, price, quantity));
        }
    }
    
    // Поиск товара по штрихкоду
    public Product findProduct(String barcode) {
        return inventory.get(barcode);
    }
    
    // Удаление товара
    public boolean removeProduct(String barcode) {
        return inventory.remove(barcode) != null;
    }
    
    // Получение количества товаров на складе
    public int getTotalProducts() {
        return inventory.size();
    }
    
    // Проверка на пустоту
    public boolean isEmpty() {
        return inventory.isEmpty();
    }
    
    // Пример использования
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        
        // Добавление товаров с описанием
        warehouse.addProduct("5901234123457", "Молоко", 
                            "Свежее пастеризованное молоко 3.2%", 85.50, 100);
        warehouse.addProduct("5901234123458", "Хлеб", 
                            "Ржаной хлеб на закваске", 45.00, 200);
        
        // Поиск товара
        Product milk = warehouse.findProduct("5901234123457");
        if (milk != null) {
            System.out.println("Найден: " + milk);
        }
        
        // Удаление товара
        warehouse.removeProduct("5901234123458");
        
        System.out.println("Всего товаров: " + warehouse.getTotalProducts());
        System.out.println("Склад пуст? " + warehouse.isEmpty());
    }
}
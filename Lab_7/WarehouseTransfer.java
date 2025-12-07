import java.util.*;
import java.util.concurrent.*;

public class WarehouseTransfer {
    
    // Класс Товар
    static class Product {
        int weight;
        
        Product(int weight) {
            this.weight = weight;
        }
    }
    
    // Класс Грузчик (работает в отдельном потоке)
    static class Loader extends Thread {
        private final Warehouse sourceWarehouse;
        private final Queue<Product> currentLoad = new LinkedList<>();
        private int currentWeight = 0;
        
        public Loader(String name, Warehouse sourceWarehouse) {
            super(name);
            this.sourceWarehouse = sourceWarehouse;
        }
        
        @Override
        public void run() {
            while (true) {
                Product product = sourceWarehouse.takeProduct();
                if (product == null) {
                    // Если товаров больше нет и у нас что-то есть в текущей загрузке
                    if (!currentLoad.isEmpty()) {
                        unload();
                    }
                    break;
                }
                
                if (currentWeight + product.weight <= 150) {
                    currentLoad.add(product);
                    currentWeight += product.weight;
                    System.out.println(getName() + " взял товар весом " + product.weight + 
                                     " кг. Текущий вес: " + currentWeight + " кг");
                    
                    // Если набрали ровно 150 кг
                    if (currentWeight == 150) {
                        unload();
                    }
                } else {
                    // Превысили бы лимит - сначала разгружаем, потом берем этот товар
                    unload();
                    currentLoad.add(product);
                    currentWeight = product.weight;
                    System.out.println(getName() + " взял товар весом " + product.weight + 
                                     " кг. Текущий вес: " + currentWeight + " кг");
                }
                
                // Небольшая пауза для имитации работы
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println(getName() + " завершил работу.");
        }
        
        private void unload() {
            if (currentLoad.isEmpty()) return;
            
            System.out.println(getName() + " везет на другой склад " + currentWeight + " кг товаров");
            try {
                // Имитация времени на перемещение и разгрузку
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(getName() + " разгрузил " + currentWeight + " кг товаров");
            
            currentLoad.clear();
            currentWeight = 0;
        }
    }
    
    // Класс Склад
    static class Warehouse {
        private final Queue<Product> products = new ConcurrentLinkedQueue<>();
        private volatile boolean isClosed = false;
        
        public void addProduct(Product product) {
            products.add(product);
        }
        
        public Product takeProduct() {
            if (isClosed && products.isEmpty()) {
                return null;
            }
            return products.poll();
        }
        
        public void closeWarehouse() {
            isClosed = true;
        }
        
        public boolean isEmpty() {
            return products.isEmpty();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        // Создаем склад и заполняем товарами
        Warehouse warehouse = new Warehouse();
        Random random = new Random();
        
        // Добавляем 50 товаров со случайным весом от 5 до 50 кг
        for (int i = 1; i <= 50; i++) {
            int weight = random.nextInt(46) + 5; // 5-50 кг
            warehouse.addProduct(new Product(weight));
        }
        
        System.out.println("Склад заполнен. Всего товаров: 50");
        System.out.println("Запускаем грузчиков...\n");
        
        // Создаем 3 грузчика
        Loader loader1 = new Loader("Грузчик 1", warehouse);
        Loader loader2 = new Loader("Грузчик 2", warehouse);
        Loader loader3 = new Loader("Грузчик 3", warehouse);
        
        // Запускаем грузчиков
        loader1.start();
        loader2.start();
        loader3.start();
        
        // Ждем, пока склад не опустеет
        while (!warehouse.isEmpty()) {
            Thread.sleep(1000);
        }
        
        // Закрываем склад
        warehouse.closeWarehouse();
        
        // Ждем завершения всех грузчиков
        loader1.join();
        loader2.join();
        loader3.join();
        
        System.out.println("\nВсе товары перенесены на другой склад!");
    }
}
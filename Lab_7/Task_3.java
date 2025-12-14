import java.util.*;
import java.util.concurrent.*;

public class Task_3 {
    
    static class Product {
        int weight;
        
        Product(int weight) {
            this.weight = weight;
        }
    }
    
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
                    
                    if (currentWeight == 150) {
                        unload();
                    }
                } else {
                    unload();
                    currentLoad.add(product);
                    currentWeight = product.weight;
                    System.out.println(getName() + " взял товар весом " + product.weight + 
                                     " кг. Текущий вес: " + currentWeight + " кг");
                }
                
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
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(getName() + " разгрузил " + currentWeight + " кг товаров");
            
            currentLoad.clear();
            currentWeight = 0;
        }
    }
    
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
        Warehouse warehouse = new Warehouse();
        Random random = new Random();
        
        for (int i = 1; i <= 50; i++) {
            int weight = random.nextInt(46) + 5;
            warehouse.addProduct(new Product(weight));
        }
        
        System.out.println("Склад заполнен. Всего товаров: 50");
        System.out.println("Запускаем грузчиков...\n");
        
        Loader loader1 = new Loader("Грузчик 1", warehouse);
        Loader loader2 = new Loader("Грузчик 2", warehouse);
        Loader loader3 = new Loader("Грузчик 3", warehouse);
        
        loader1.start();
        loader2.start();
        loader3.start();
        
        while (!warehouse.isEmpty()) {
            Thread.sleep(1000);
        }
        
        warehouse.closeWarehouse();
        
        loader1.join();
        loader2.join();
        loader3.join();
        
        System.out.println("\nВсе товары перенесены на другой склад!");
    }
}
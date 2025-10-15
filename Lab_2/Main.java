public class Main {
    public static void main(String[] args) {
                
        Car myCar = new Car("BMW", 250, 4, "Купе");
        Motorcycle myBike = new Motorcycle("Ducati", 280, false);
        
        System.out.println("\n--- Инкапсуляция: Чтение данных ---");
        System.out.println("Марка моего авто: " + myCar.getBrand()); 
        myBike.setBrand("Yamaha");
        System.out.println("Марка мотоцикла изменена на: " + myBike.getBrand());
        
        System.out.println("\n--- Динамический Полиморфизм ---");
        
        Vehicle v1 = myCar; 
        Vehicle v2 = myBike;
        
        v1.move();
        v2.move(); 
        
        System.out.println("\n--- Статический Полиморфизм (Перегрузка) ---");
        myCar.maintenance();              


        myCar.maintenance("Замена масла"); 
        
        System.out.println("\n--- Абстракция и Наследование ---");
        myCar.displayInfo(); 
        System.out.println("Тип кузова: " + myCar.getBodyType()); 
        
        System.out.println("\n--- Статический Счетчик ---");
        System.out.println("Общее количество созданных тс: " + Vehicle.getVehicleCount()); 
        
    }
}
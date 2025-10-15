public abstract class Vehicle {
    private String brand;     
    private int maxSpeed;      
    private int numWheels;     
    
    private static int vehicleCount = 0; 
    
    public Vehicle(String brand, int maxSpeed, int numWheels) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.numWheels = numWheels;
        Vehicle.vehicleCount++; 
    }
    public Vehicle() {
        this("Unknown", 0, 0); 
    }

    public abstract void move(); 
    
    public void displayInfo() {
        System.out.println("--- ТРАНСПОРТНОЕ СРЕДСТВО ---");
        System.out.println("Марка: " + brand);
        System.out.println("Скорость: " + maxSpeed + " км/ч");
        System.out.println("Колеса: " + numWheels);
    }
    
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    
    public static int getVehicleCount() { 
        return Vehicle.vehicleCount; 
    }

    public void maintenance() { 
        System.out.println(brand + ": Пройдено базовое техобслуживание.");
    }
    public void maintenance(String serviceType) { 
        System.out.println(brand + ": Пройдено ТО: " + serviceType);
    }
}
public class Motorcycle extends Vehicle {
    private boolean hasSideCar;

    public Motorcycle(String brand, int maxSpeed, boolean hasSideCar) {
        super(brand, maxSpeed, 2); 
        this.hasSideCar = hasSideCar;
    }

    public Motorcycle() {
        this("Harley", 180, false);
    }
    
    @Override
    public void move() {
        System.out.println(getBrand() + " мчится, наклоняясь на поворотах. Вжжж!");
    }
    
}
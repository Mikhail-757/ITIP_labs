public class Car extends Vehicle {
    private String bodyType; 
    
    public Car(String brand, int maxSpeed, int numWheels, String bodyType) {
        super(brand, maxSpeed, numWheels); 
        this.bodyType = bodyType;
    }
    
    public Car() {
        this("Toyota", 200, 4, "Седан");
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " едет по дороге, плавно разгоняясь.");
    }

    public String getBodyType() { return bodyType; }с
}
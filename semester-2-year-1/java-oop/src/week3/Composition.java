
public class Composition {
    public static void main(String[] args) {
        // Composition = Represents a part-of relationship between objects

        Car1 car = new Car1("Honda", 2026, "V6");

        System.out.println(car.engine.type);

        car.start();
    }
}

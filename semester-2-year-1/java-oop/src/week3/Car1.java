public class Car1 {

    String make;
    String model;
    int year;
    String color;
    Engine engine;

    Car1(String model, int year, String make, String color) {
        this.model = model;
        this.year = year;
        this.make = make;
        this.color = color;
    }

    void start(){
        this.engine.start();
        System.out.println("The Engine model is" + this.engine.type);
    }

    @Override
    public String toString() {
        return this.color + " " + this.model + " " + this.year + " " +this.make;
    }
}

public class Car1 {

    String make;
    String model;
    int year;
    String color;
    Engine engine;

    Car1(String model, String color) {
        this.model = model;
        this.color = color;
    }

    void drive(){
        System.out.println("Driving" + this.model + " ");
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

public class Car {

    String make = "Ford";
    String Model = "Mustan";
    int year = 2025;
    double price = 69000;
    boolean isRunning = false;

    void start(){
        System.out.println("Starting Car");
        isRunning = true;

    }

    void stop(){
        isRunning = false;
        System.out.println("Stopping Car");
    }

    void drive(){
        System.out.println("Driving Car" + Model);
    }

    void break_car(){
        System.out.println("Breaking Car" + Model);
    }

}

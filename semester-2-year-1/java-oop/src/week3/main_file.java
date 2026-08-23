public class main_file {
    public static void main(String[] args) {
        Car car = new Car();
        Bike bike = new Bike();
        Boat boat = new Boat();

        Vehical[] vehicales = {car, bike, boat};

        for(Vehical vehical : vehicales){
            vehical.go();
        }
    }
}

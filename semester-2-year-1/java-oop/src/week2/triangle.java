public class triangle {

    private double a, b, c;

    public triangle() {
        this.a = 1;
        this.b = 1;
        this.c = 1;
    }

    public static double area(double b, double h) {
        return b * h / 2;
    }

    public static double perimeter(double a, double b, double c){
        return a+b+c;
    }

    public triangle scale(double multiplier) {
        triangle copy = new triangle();
        copy.a = this.a * multiplier;
        copy.b = this.b * multiplier;
        copy.c = this.c * multiplier;
        return copy;
    }

}

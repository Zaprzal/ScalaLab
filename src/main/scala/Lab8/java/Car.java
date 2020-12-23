public class Car {
    public String car;
    public String type;
    public String fuel;
    public Integer year;



    public Car(String car , String type , String fuel , Integer year){
        this.car = car;
        this.type = type;
        this.fuel = fuel;
        this.year = year;
    }
    public Car(){

    }

    @Override
    public String toString() {
        return "Car{" +
                "car='" + car + '\'' +
                ", type='" + type + '\'' +
                ", fuel='" + fuel + '\'' +
                ", year=" + year +
                '}';
    }
}

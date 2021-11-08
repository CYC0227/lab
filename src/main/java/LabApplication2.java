import lombok.Data;

import java.util.Objects;

@Data
class Car implements Cloneable{
    int a,b;

    @Override
    public String toString() {
        return "Name{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Car car = (Car) o;
//        return a == car.a && b == car.b;
//    }

    @Override
    public boolean equals(Object o){
        Car car = (Car) o;
        if(this.a == car.a && this.b == car.b)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
public class LabApplication2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Car car = new Car();

        car.setA(10);
        car.setB(20);

        Car car2 = (Car)car.clone();

        System.out.println("car = " + car);
        System.out.println("car2 = " + car2);

    }

}

package ro.lucas.chapter4.fly;

public class SeaPlane extends Vehicle implements FastFly,Sail{

    private  int altutude;

    @Override
    public void land() {

    }

    @Override
    public void turn() {

    }

    @Override
    public void cruise() {
        System.out.print("SeaPlane::cruise currently cruise like: ");
        if (altutude > 0){
            FastFly.super.cruise();
        }else{
            Sail.super.cruise();
        }
    }

    public static void main(String[] args) {
        SeaPlane seaPlane = new SeaPlane();
        seaPlane.altutude = 3;

        seaPlane.takeOff();
        seaPlane.turn();
        seaPlane.cruise();
        seaPlane.land();

    }

    @Override
    public void takeOff() {

    }
}

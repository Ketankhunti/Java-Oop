class Bicycle {

    private int cadence;
    private int gear;
    private int speed;

    private int id;

    private static int numberOfBicycles = 0;


    public Bicycle(int startCadence,
                   int startSpeed,
                   int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
      //  numberOfBicycles = 2;
        id = ++numberOfBicycles;
    }

    public int getID() {
        return id;
    }

    public static int getNumberOfBicycles() {
        return numberOfBicycles;
    }

    public int getCadence() {
        return cadence;
    }

    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public int getGear(){
        return gear;
    }

    public void setGear(int newValue) {
        gear = newValue;
    }

    public int getSpeed() {
        return speed;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }
}

class MountainBike extends Bicycle {

    public int seatHeight;

    MountainBike(int startHeight,int cadence, int gear, int speed) {
        super(cadence, gear, speed);
        this.seatHeight = startHeight;

    }

    public void setSeatHeight(int newValue) {
        seatHeight = newValue;
    }
 /*
    public Bicycle returnAClass() {
//        Bicycle b1 = new Bicycle(seatHeight, gear, speed);
//        return b1;
        MountainBike m1 = new MountainBike(seatHeight,cadence,gear,speed);
        return m1;
    }
*/
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        MountainBike m1 = new MountainBike(1,1,1,1);

        System.out.println(Bicycle.getNumberOfBicycles());

    }
};


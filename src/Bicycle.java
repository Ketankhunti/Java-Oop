public class Bicycle {
    int speed=0;
    int cadence=0;
    int gear=0;

    void changeCadence(int cadence){
        this.cadence=cadence;
    }
    void changeGear(int gear){
        this.gear=gear;
    }
    void speedUp(int speed){
        this.speed+=speed;
    }
    void applyBrakes(int speed){
        this.speed-=speed;
    }
    void printStates() {
        System.out.println("cadence:" +
                cadence + " speed:" +
                speed + " gear:" + gear);
    }

}


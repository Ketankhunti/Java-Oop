
interface BicycleInterface {
    void changeCadence(int cadence);

    void changeGear(int gear);

    void speedUp(int speedIncrement);

    void applyBrakes(int speedDecrement);

}

public class ACMEBicycle implements BicycleInterface {

    int cadence = 0;
    int speed = 0;
    int gear = 1;

    @Override
    public void changeCadence(int cadence) {
        this.cadence = cadence;
    }

    @Override
    public void changeGear(int gear) {
         this.gear = gear;
    }

    @Override
    public void speedUp(int speedIncrement) {
        this.speed += speedIncrement;
    }

    @Override
    public void applyBrakes(int speedDecrement) {
        this.speed -= speedDecrement;
    }
}

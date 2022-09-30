package spring_task;

public class Transport {
    private int maxPassenger;
    private int number;
    private int fuel;
    private int currentSpeed;
    private int currentPassenger;

    String currentStatus;

    public int getCurrentPassenger() {
        return currentPassenger;
    }

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public int getFuel() {
        return fuel;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getNumber() {
        return number;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentPassenger(int currentPassenger) {
        this.currentPassenger = currentPassenger;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void setMaxPassenger(int maxPassenger) {
        this.maxPassenger = maxPassenger;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void serviceStart() {
        if (this.fuel >= 10)
            this.currentStatus = "운행";
        else System.out.println("주유량을 확인 후 다시 ");
    }

    public void changeSpeed(int changeValue) {
        if (fuelCheck())
            this.currentSpeed += changeValue;
    }

    public void changeStatus() {
        if (this.currentStatus == "운행")
            this.currentStatus = "차고지행";
        else this.currentStatus = "운행";
    }

    public void getOn(int passengerNum) {
        if (this.currentPassenger <= this.currentPassenger + passengerNum) {
            this.currentPassenger += passengerNum;
            System.out.println("현재 승객 : " + this.currentPassenger + ", 잔여 좌석은 : " + (this.maxPassenger - this.currentPassenger) + " 입니다.");
        } else {
            System.out.println("최대 승객 수를 초과하였습니다. ");
        }

        else
    }

    public void refuel(int amount) {
        this.fuel = this.fuel + amount;
        System.out.println("연료를 " + amount + "만큼 채웠습니다.");
    }

    public void fuelReduce(int fuel) {
        this.fuel = this.fuel - fuel;
    }

    public boolean fuelCheck() {
        if (this.fuel < 10) {
            System.out.println("현재 연료양: " + this.fuel + " , 연료량을 확인해주세요");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }

}


class Bus extends Transport{
    int currentPassenger;

    public Bus(int busNumber) {
        setFuel(100);
        setCurrentSpeed(0);
        setNumber(busNumber);
    }
}
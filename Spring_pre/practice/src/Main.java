public class Main {
    public static void main(String[] args) {
//        Bus bus1 = new Bus();
//        Bus bus2 = new Bus();
//        System.out.println("버스 1 넘버 : " + bus1.getNumber());
//        System.out.println("버스 2 넘버 : " + bus2.getNumber());
//
//        bus1.getOn(2);
//        System.out.println("버스 1 현재 탑승 승객 : " + bus1.getCurrentPassenger());
//        System.out.println("버스 1 현재 잔여 승객 : " + (bus1.getMaxPassenger() - bus1.getCurrentPassenger()));
//        System.out.println("요금 확인 : " + bus1.getFare());
//
//        bus1.fuelChange(-50);
//        System.out.println("버스 1 현재 연료량 : " + bus1.getFuel());
//
//        bus1.changeState();
//        bus1.fuelChange(10);
//        System.out.println("버스 1 현재 상태 : " + bus1.getCurrentState());
//        System.out.println("버스 1 현재 연료량 : " + bus1.getFuel());
//
//        bus1.changeState();
//        bus1.getOn(45);
//
//        bus1.getOn(5);
//        System.out.println("버스 1 현재 탑승 승객 : " + bus1.getCurrentPassenger());
//        System.out.println("버스 1 현재 잔여 승객 : " + (bus1.getMaxPassenger() - bus1.getCurrentPassenger()));
//        System.out.println("버스 1 현재 요금 : " + bus1.getFare());
//
//        bus1.fuelChange(-55);
//        System.out.println("버스 1 현재 연료량 : " + bus1.getFuel());
//        System.out.println("버스 1 현재 상태 : " + bus1.getCurrentState());
//
//        bus1.fuelCheck();

        Taxi taxi1 = new Taxi();
        Taxi taxi2 = new Taxi();
        System.out.println("택시 1 넘버 : " + taxi1.getNumber());
        System.out.println("택시 2 넘버 : " + taxi2.getNumber());

        taxi1.getOn(2);
        taxi1.setDestination("서울역");
        taxi1.setToDestinationDistance(2);
        System.out.println("택시 1 탑승 승객 수 : " + taxi1.getCurrentPassenger());
        System.out.println("택시 1 잔여 승객 수 : " + (taxi1.getMaxPassenger() - taxi1.getCurrentPassenger()));
        System.out.println("택시 1 기본 요금 : " + taxi1.getFare());
        System.out.println("택시 1 목적지 : " + taxi1.getDestination());
        System.out.println("택시 1 목적지까지 거리 : " + taxi1.getToDestinationDistance() +"km");
        System.out.println("택시 1 지불할 요금 : " + (taxi1.getFare() + (taxi1.getToDestinationDistance() - 1) * taxi1.getDistanceFare()));
        System.out.println("택시 1 상태 : " + taxi1.getCurrentState());

        taxi1.fuelChange(-80);
        taxi1.farePayment();
        System.out.println("택시 1 연료량 : " + taxi1.getFuel());
        System.out.println("택시 1 누적요금 : " + taxi1.getTotalFare());

        taxi1.getOn(5);

        taxi1.getOn(3);
        taxi1.setDestination("구로디지털단지역");
        taxi1.setToDestinationDistance(12);
        System.out.println("택시 1 탑승 승객 수 : " + taxi1.getCurrentPassenger());
        System.out.println("택시 1 잔여 승객 수 : " + (taxi1.getMaxPassenger() - taxi1.getCurrentPassenger()));
        System.out.println("택시 1 기본 요금 : " + taxi1.getFare());
        System.out.println("택시 1 목적지 : " + taxi1.getDestination());
        System.out.println("택시 1 목적지까지 거리 : " + taxi1.getToDestinationDistance() +"km");
        System.out.println("택시 1 지불할 요금 : " + (taxi1.getFare() + (taxi1.getToDestinationDistance() - 1) * taxi1.getDistanceFare()));

        taxi1.fuelChange(-20);
        taxi1.farePayment();
        System.out.println("택시 1 연료량 : " + taxi1.getFuel());
        System.out.println("택시 1 상태 : " + taxi1.getCurrentState());
        System.out.println("택시 1 누적요금 : " + taxi1.getTotalFare());

    }
}
abstract class Transport {
    private int maxPassenger;
    private int number;
    private int fuel;
    private int currentSpeed;
    private int currentPassenger;
    private int fare;

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    private String currentState;
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

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentPassenger(int currentPassenger) {
        this.currentPassenger = currentPassenger;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
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

    public abstract void serviceStart();

    public void changeSpeed(int changeValue) {
        this.currentSpeed += changeValue;
    }

    public abstract void changeState();


    public abstract void getOn(int passengerNum);


    public void fuelCheck() {
        if (this.fuel < 10)
            System.out.println("Alert!!! 주유 필요!!");
        else System.out.println("정상입니다.");
    }

    public abstract void fuelChange(int fuel);

}


class Bus extends Transport{
    static int numCount = 1;

    public Bus() {
        setFuel(100);
        setCurrentSpeed(0);
        setNumber(numCount++);
        setMaxPassenger(30);
        serviceStart();
    }

    @Override
    public void serviceStart() {
        if (getFuel() >= 10)
            setCurrentState("운행");
        else fuelCheck();
    }

    @Override
    public void changeState() {
        if (getCurrentState() == "운행") {
            setCurrentState("차고지행");
            setCurrentPassenger(0);
            setFare(0);
        }
        else setCurrentState("운행");
    }

    @Override
    public void getOn(int passengerNum) {
        if (getMaxPassenger() >= getCurrentPassenger() + passengerNum) {
            setCurrentPassenger(getCurrentPassenger() + passengerNum);
            setFare(getFare() + passengerNum * 1000);
        } else {
            System.out.println("Alert!! 최대 승객 수를 초과하였습니다. ");
        }
    }

    @Override
    public void fuelChange(int fuel) {
        setFuel(getFuel() + fuel);
        if (getFuel() < 10 && getCurrentState() == "운행") {
            changeState();
        }
    }
}

class Taxi extends Transport {
    private int defalutDistance;
    private String destination;
    static int taxiNumber = 1;
    private int toDestinationDistance;
    private int distanceFare = 1000;
    private int totalFare;

    public String getDestination() {
        return destination;
    }

    public Taxi() {
        setNumber(taxiNumber++);
        setFuel(100);
        setFare(0);
        setMaxPassenger(4);
        setFare(3000);
        setTotalFare(0);
        serviceStart();
    }


    public void setTotalFare(int totalFare) {
        this.totalFare = totalFare;
    }

    public int getTotalFare() {
        return totalFare;
    }

    @Override
    public void serviceStart() {
        if (getFuel() >= 10)
            setCurrentState("일반");
        else
            fuelCheck();
    }

    @Override
    public void changeState() {
        if (getCurrentState() == "일반")
            setCurrentState("운행 중");
        else if (getFuel() >= 10)
            setCurrentState("일반");
    }

    @Override
    public void getOn(int passengerNum) {

        if (getMaxPassenger() >= getCurrentPassenger() + passengerNum && getCurrentState() == "일반") {
            setCurrentPassenger(getCurrentPassenger() + passengerNum);
            setCurrentState("운행 중");
        }
        else if (getCurrentState() == "운행 중")
            System.out.println("탑승 불가");

        else {
            System.out.println("Alert!! 최대 승객 수를 초과하였습니다. ");
        }
    }

    @Override
    public void fuelChange(int fuel) {
        setFuel(getFuel() + fuel);
        if (getFuel() < 10) {
            setCurrentState("운행불가");
        }
    }

    public void farePayment() {
        setTotalFare(getTotalFare() + getFare() + (getToDestinationDistance() - 1) * getDistanceFare());
        if (getFuel() >= 10)
            setCurrentState("일반");
        setCurrentPassenger(0);
    }

    public void setToDestinationDistance(int toDestinationDistance) {
        this.toDestinationDistance = toDestinationDistance;
    }

    public int getDistanceFare() {
        return distanceFare;
    }

    public int getToDestinationDistance() {
        return toDestinationDistance;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
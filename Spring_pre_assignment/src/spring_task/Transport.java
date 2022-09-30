package spring_task;

import java.io.PrintStream;

public abstract class Transport {
    private int maxPassenger;
    private int number;
    private int fuel;
    private int currentSpeed;
    private int currentPassenger;
    private int fare;
    private String currentState;

    Transport() {
    }

    public int getFare() {
        return this.fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public int getCurrentPassenger() {
        return this.currentPassenger;
    }

    public int getMaxPassenger() {
        return this.maxPassenger;
    }

    public int getFuel() {
        return this.fuel;
    }

    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    public int getNumber() {
        return this.number;
    }

    public String getCurrentState() {
        return this.currentState;
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

    public abstract void getOn(int var1);

    public void fuelCheck() {
        if (this.fuel < 10) {
            System.out.println("Alert!!! 주유 필요!!");
        } else {
            System.out.println("정상입니다.");
        }

    }

    public abstract void fuelChange(int var1);

    public static void main(String[] args) {
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
        System.out.println("택시 1 목적지까지 거리 : " + taxi1.getToDestinationDistance() + "km");
        PrintStream var10000 = System.out;
        int var10001 = taxi1.getFare() + (taxi1.getToDestinationDistance() - 1) * taxi1.getDistanceFare();
        var10000.println("택시 1 지불할 요금 : " + var10001);
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
        System.out.println("택시 1 목적지까지 거리 : " + taxi1.getToDestinationDistance() + "km");
        var10000 = System.out;
        var10001 = taxi1.getFare() + (taxi1.getToDestinationDistance() - 1) * taxi1.getDistanceFare();
        var10000.println("택시 1 지불할 요금 : " + var10001);
        taxi1.fuelChange(-20);
        taxi1.farePayment();
        System.out.println("택시 1 연료량 : " + taxi1.getFuel());
        System.out.println("택시 1 상태 : " + taxi1.getCurrentState());
        System.out.println("택시 1 누적요금 : " + taxi1.getTotalFare());
    }
}

class Bus extends Transport {
    static int numCount = 1;

    public Bus() {
        this.setFuel(100);
        this.setCurrentSpeed(0);
        this.setNumber(numCount++);
        this.setMaxPassenger(30);
        this.serviceStart();
    }

    public void serviceStart() {
        if (this.getFuel() >= 10) {
            this.setCurrentState("운행");
        } else {
            this.fuelCheck();
        }

    }

    public void changeState() {
        if (this.getCurrentState() == "운행") {
            this.setCurrentState("차고지행");
            this.setCurrentPassenger(0);
            this.setFare(0);
        } else {
            this.setCurrentState("운행");
        }

    }

    public void getOn(int passengerNum) {
        if (this.getMaxPassenger() >= this.getCurrentPassenger() + passengerNum) {
            this.setCurrentPassenger(this.getCurrentPassenger() + passengerNum);
            this.setFare(this.getFare() + passengerNum * 1000);
        } else {
            System.out.println("Alert!! 최대 승객 수를 초과하였습니다. ");
        }

    }

    public void fuelChange(int fuel) {
        this.setFuel(this.getFuel() + fuel);
        if (this.getFuel() < 10 && this.getCurrentState() == "운행") {
            this.changeState();
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
        return this.destination;
    }

    public Taxi() {
        this.setNumber(taxiNumber++);
        this.setFuel(100);
        this.setFare(0);
        this.setMaxPassenger(4);
        this.setFare(3000);
        this.setTotalFare(0);
        this.serviceStart();
    }

    public void setTotalFare(int totalFare) {
        this.totalFare = totalFare;
    }

    public int getTotalFare() {
        return this.totalFare;
    }

    public void serviceStart() {
        if (this.getFuel() >= 10) {
            this.setCurrentState("일반");
        } else {
            this.fuelCheck();
        }

    }

    public void changeState() {
        if (this.getCurrentState() == "일반") {
            this.setCurrentState("운행 중");
        } else if (this.getFuel() >= 10) {
            this.setCurrentState("일반");
        }

    }

    public void getOn(int passengerNum) {
        if (this.getMaxPassenger() >= this.getCurrentPassenger() + passengerNum && this.getCurrentState() == "일반") {
            this.setCurrentPassenger(this.getCurrentPassenger() + passengerNum);
            this.setCurrentState("운행 중");
        } else if (this.getCurrentState() == "운행 중") {
            System.out.println("탑승 불가");
        } else {
            System.out.println("Alert!! 최대 승객 수를 초과하였습니다. ");
        }

    }

    public void fuelChange(int fuel) {
        this.setFuel(this.getFuel() + fuel);
        if (this.getFuel() < 10) {
            this.setCurrentState("운행불가");
        }

    }

    public void farePayment() {
        this.setTotalFare(this.getTotalFare() + this.getFare() + (this.getToDestinationDistance() - 1) * this.getDistanceFare());
        if (this.getFuel() >= 10) {
            this.setCurrentState("일반");
        }

        this.setCurrentPassenger(0);
    }

    public void setToDestinationDistance(int toDestinationDistance) {
        this.toDestinationDistance = toDestinationDistance;
    }

    public int getDistanceFare() {
        return this.distanceFare;
    }

    public int getToDestinationDistance() {
        return this.toDestinationDistance;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}

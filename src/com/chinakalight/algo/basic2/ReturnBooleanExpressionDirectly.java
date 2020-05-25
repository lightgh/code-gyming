package com.chinakalight.algo.basic2;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 5/10/2020
 */
public class ReturnBooleanExpressionDirectly {
    public static void main(String[] args) {
        if(isValidToProcess()){
            System.out.println("PROCESS");
        }else{
            System.out.println("DONT PROCESS");
        }
    }

    static boolean isValidToProcess(){
        int firstEntry = 45;
        int lastScore = 90;
        int midScore = 1;
        String resourceLocation = "Abuja";

//        return firstEntry > 100 || lastScore < midScore;

        boolean firstEntryGreaterThan100 = firstEntry > 100;
        boolean lastScoreLessThanMidScore = lastScore < midScore;
        boolean resourceLocationExist = !resourceLocation.isEmpty();

        return  (firstEntryGreaterThan100 || lastScoreLessThanMidScore) && resourceLocationExist;

//
//
//        return firstEntry < 0 && lastScore >= 5 && midScore >= 1 && !resourceLocation.isEmpty();
//
    }


    Crew crew;
    FuelTank fuelTank;
    Hull hull;
    Navigator navigator;
    OxygenTank oxygenTank;

    boolean willCrewSurvive() {
        return hull.holes == 0 &&
                hasEnoughOxygen() && hasEnoughResource();
    }

    boolean hasEnoughResource(){
        return fuelTank.fuel >= navigator.requiredFuelToEarth();
    }

    boolean hasEnoughOxygen(){
        return  oxygenTank.lastsFor(crew.size) > navigator.timeToEarth();
    }


    class Crew{ public int size; }
    class FuelTank{ int fuel = 0; }
    class Hull{ public int holes; }
    class Navigator{
        public int requiredFuelToEarth(){ return 12; }
        public int timeToEarth(){ return 10; }
    }
    class OxygenTank{
        public int lastsFor(int size){return 15; }
    }

}

package org.speakingcs.algorithms;

public class StepsNoofWays {

    static int[] countAtEachStep;

    public static void main(String[] args) {

        int noOfSteps = 4;
        countAtEachStep = new int[noOfSteps];
        int noOfWays = findNoOfWaysToReach(noOfSteps);

        System.out.printf("No of ways to reach %dth step is %d",noOfSteps, noOfWays);

    }

    private static int findNoOfWaysToReach(int noOfSteps) {

        if(noOfSteps == 1 || noOfSteps == 2 || noOfSteps == 3) {
            return noOfSteps;
        }

        if(countAtEachStep[noOfSteps-1] != 0) {
            return noOfSteps;
        }

        int noOfWays = findNoOfWaysToReach(noOfSteps -1) + findNoOfWaysToReach(noOfSteps -2);

        if(countAtEachStep[noOfSteps-1] == 0) {
            countAtEachStep[noOfSteps-1] = noOfWays;
        }


        return noOfWays;
    }


}

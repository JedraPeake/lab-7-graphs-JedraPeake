package ca.uwo.eng.se2205.lab7.mars;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

/**
 * Calculates the best location to land a rover.
 */
@ParametersAreNonnullByDefault
public class MarsPlanner {
    int[][] topology;
    List<int[]> mustVisit;
    /**
     * Initializes the planner with the topology of the land and the landing sites.
     *
     * @param topology Two dimensional set of heights
     * @param sites {@code List} of coordinates that must be visited
     */
    public MarsPlanner(int[][] topology, List<int[]> sites) {
        // DO NOT CHANGE THE METHOD SIGNATURE
        this.topology = topology;
        this.mustVisit = sites;
        //Traversing all points on the surface are not even
        //topology as a 2D int array and a set of coordinates that you need to visit
        //Each day, you must travel to one location and return back to "base."
    }

    /**
     * Calculates the best landing spot in the topology.
     *
     * @param fuelAvailable How much fuel is available daily when travelling
     * @return Coordinates for the best landing spot
     */
    public int[] bestLandingSpot(int fuelAvailable) {
        // DO NOT CHANGE THE METHOD SIGNATURE
        //Your goal is to find the best place to land the base such that you can conserve as much fuel travelling to and from the base
        //you only have a certain amount of fuel to travel from the landing spot to a location and back per day
        //This implies, the distance between the landing point and all points each must be less than the fuel limit.

        //fuel is absolute value difference of the values ...
        // find all the ponts within fuel availabilty
        List<int[]> important= new ArrayList<>();
        Map<Integer,Integer> nodesUsed = new HashMap<>();
        important = mustVisit;
        int maxCount = 0;
        int currCount = 0;
        int x =0;
        int y =0;
        for(int i =0; i<topology.length-1;i++){
            for(int j = 0; j<topology.length-1;j++){
                int start = topology[j][i];
                for(int a =0; a<topology.length-1;a++) {
                    for (int b = 0; b < topology.length-1; b++) {
                        if(a!=i && b!=j){
                            int diff = Math.abs(start - topology[b][a]);
                            if (diff <= fuelAvailable/2) {
                                currCount++;
                                nodesUsed.put(b,a);
                            }
                        }
                    }
                }
                if(currCount>maxCount){
                    boolean add = true;
                    for(int c =0; c<important.size()-1;c++){
                        int[] curr = important.get(c);
                        if(nodesUsed.get(curr[1]) != curr[0]){
                            add = false;
                        }
                    }
                    if(add){
                        maxCount = currCount;
                        x=i;
                        y=j;
                    }
                }
            }
        }
        return new int[] { x, y };
        /*
        WRONG USE BFS SHOULD DO THE TRICKLE!!!!
         */
    }
}

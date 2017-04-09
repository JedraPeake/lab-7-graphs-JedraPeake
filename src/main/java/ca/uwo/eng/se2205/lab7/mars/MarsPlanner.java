package ca.uwo.eng.se2205.lab7.mars;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

/**
 * Calculates the best location to land a rover.
 */
@ParametersAreNonnullByDefault
public class MarsPlanner {
    int[][] topology;
    int numVertices;
    List<int[]> mustVisit;
//    GraphHelper g;

    /**
     * Initializes the planner with the topology of the land and the landing sites.
     *
     * @param topology Two dimensional set of heights
     * @param sites {@code List} of coordinates that must be visited
     */
    public MarsPlanner(int[][] topology, List<int[]> sites) {
        this.topology = new int[topology.length][topology[0].length];
        this.numVertices = topology.length;
        this.mustVisit = sites;

        for (int i = 0; i<topology.length;i++){
            for(int j=0;j<topology[0].length;j++){
                this.topology[i][j] = topology[i][j];
            }
        }
    }
        // DO NOT CHANGE THE METHOD SIGNATURE
//        this.topology = topology;


        //read data into the graph
        // each point is a vertex!
        //diagonal edges????
//        this.g = new GraphHelper();
//        for(int i =0;i<topology.length; i++){
//            for(int j=0;j<topology[0].length;j++){
//
//            }
//        }
        //Traversing all points on the surface are not even
        //topology as a 2D int array and a set of coordinates that you need to visit
        //Each day, you must travel to one location and return back to "base."
    /**
     * Calculates the best landing spot in the topology.
     *
     * @param fuelAvailable How much fuel is available daily when travelling
     * @return Coordinates for the best landing spot
     */
    public int[] bestLandingSpot(int fuelAvailable) {
        //testing loading purposes...
        //y elements
        for (int source = 0; source < numVertices; source++) {
            //x elements
            for (int destination = 0; destination < numVertices; destination++) {
                System.out.print(this.topology[source][destination] + "\t");
            }
            System.out.println();
        }

        int[][] sizeStorage = new int[numVertices][numVertices];
        int[][] mustVisit = new int[numVertices][numVertices];
        int[][] visited = new int[numVertices][numVertices];

        for (int y = 0; y<numVertices;y++){
            for(int x=0;  x<numVertices;x++){
                //all false first
                    mustVisit[y][x] = -1;
            }
        }

        //now set important ones
        for(int i =0;i<this.mustVisit.size();i++){
            int[] temp = this.mustVisit.get(i);
            mustVisit[temp[0]][temp[1]] = 1;
        }

        int sizeCnt=0;
        int travel = fuelAvailable/2;
        //y = curr axis
        for (int k = 0; k < numVertices; k++) {
            //x = curr other axis
            for (int i = 0; i < numVertices; i++) {

                for (int y = 0; y<numVertices;y++){
                    for(int x=0;  x<numVertices;x++){
                        //all false first
                        visited[y][x] = 0;
                    }
                }

                sizeCnt =0;
                int curr = topology[k][i];
                for (int lower = i-1; lower>0;lower--){
                    int temp = Math.abs(curr-topology[k][lower]);
                    if( temp <= travel ){
                        sizeCnt++;
                        visited[k][lower] = 1;
                    }
                    else {break;}
                }
                for (int higher = i+1; higher<numVertices;higher++){
                    int temp = Math.abs(curr-topology[k][higher]);
                    if( temp <= travel ){
                        sizeCnt++;
                        visited[k][higher] = 1;
                    }
                    else {break;}
                }
                for (int sideL = i-1; sideL>0;sideL--){
                    int temp = Math.abs(curr-topology[sideL][i]);
                    if( temp <= travel ){
                        sizeCnt++;
                        visited[sideL][i]=1;
                    }
                    else {break;}
                }
                for (int sideG = k+1; sideG<numVertices;sideG++){
                    int temp = Math.abs(curr-topology[sideG][i]);
                    if( temp <= travel ){
                        sizeCnt++;
                        visited[sideG][i] =1;
                    }
                    else {break;}
                }
                boolean mustVistedDone = false;
                for (int a = 0; a<numVertices; a++){
                    for (int b = 0; b<numVertices; b++){
                        if(mustVisit[a][b] == 1){
                            if(visited[a][b] != 1){
                                mustVistedDone = false;
                                break;
                            }
                        }
                    }
                    mustVistedDone = true;
                }
                if(mustVistedDone == true){
                    sizeStorage[k][i] = sizeCnt;
                }
            }
        }

        System.out.println();
        for (int source = 0; source < numVertices; source++) {
            //x elements
            for (int destination = 0; destination < numVertices; destination++) {
                System.out.print(sizeStorage[source][destination] + "\t");
            }
            System.out.println();
        }

        int largest =0;
        int[] large = new int[2];
        for (int source = 0; source < numVertices; source++) {
            for (int destination = 0; destination < numVertices; destination++) {
                int curr = sizeStorage[source][destination];
                if(curr>largest){
                    largest = curr;
                    large[1] = source;
                    large[0] = destination;
                }
            }
            System.out.println();
        }

        // DO NOT CHANGE THE METHOD SIGNATURE
        //Your goal is to find the best place to land the base such that you can conserve as much fuel travelling to and from the base
        //you only have a certain amount of fuel to travel from the landing spot to a location and back per day
        //This implies, the distance between the landing point and all points each must be less than the fuel limit.

        //fuel is absolute value difference of the values ...
        // find all the ponts within fuel availabilty
//        List<int[]> important= new ArrayList<>();
//        Map<Integer,Integer> nodesUsed = new HashMap<>();
//        important = mustVisit;
//        int maxCount = 0;
//        int currCount = 0;
//        int x =0;
//        int y =0;
//        for(int i =0; i<topology.length-1;i++){
//            for(int j = 0; j<topology.length-1;j++){
//                int start = topology[j][i];
//                for(int a =0; a<topology.length-1;a++) {
//                    for (int b = 0; b < topology.length-1; b++) {
//                        if(a!=i && b!=j){
//                            int diff = Math.abs(start - topology[b][a]);
//                            if (diff <= fuelAvailable/2) {
//                                currCount++;
//                                nodesUsed.put(b,a);
//                            }
//                        }
//                    }
//                }
//                if(currCount>maxCount){
//                    boolean add = true;
//                    for(int c =0; c<important.size()-1;c++){
//                        int[] curr = important.get(c);
//                        if(nodesUsed.get(curr[1]) != curr[0]){
//                            add = false;
//                        }
//                    }
//                    if(add){
//                        maxCount = currCount;
//                        x=i;
//                        y=j;
//                    }
//                }
//            }
//        }
//        return new int[] { x, y };
        /*
        WRONG USE BFS SHOULD DO THE TRICKLE!!!!
         */
        if(largest != 0){
            return large;
        }
        return null;
    }
}

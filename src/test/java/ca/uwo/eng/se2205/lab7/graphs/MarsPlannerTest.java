package ca.uwo.eng.se2205.lab7.graphs;

import ca.uwo.eng.se2205.lab7.mars.MarsPlanner;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Created by PeakeAndSons on 2017-04-06.
 */
public class MarsPlannerTest {
    @Nested
    class Small {                   // x: 0  1  2         y
        int[][] topology = new int[][] { {6, 4, 3},    // 0
                                        {4, 12, 2},   // 1
                                        {8, 10, 3} }; // 2

        MarsPlanner underTest = new MarsPlanner(topology,
                Arrays.asList(new int[]{ 1, 0 }, new int[]{ 2, 2 }));

        @Test
        void check() {
            int[] coords = underTest.bestLandingSpot(4);
            assertArrayEquals(new int[]{ 2, 0 }, coords, "Invalid coords");
        }
    }

    @Nested
    class Big {                   // x: 0  1  2 ........        y
        int[][] topology = new int[][] { {8,10,16,14,10,6,3,0,1,1},
                                        {12,14,20,16,12,8,4,0,2,1},
                                        {14,18,24,18,16,10,0,1,3,1},
                                        {14,26,26,23,20,8,0,3,2,0},
                                        {18,25,28,25,20,8,0,2,0,3},
                                        {13,24,26,26,14,0,0,0,2,6},
                                        {8,16,24,13,3,1,1,2,6,8},
                                        {4,10,3,3,0,0,5,6,8,13},
                                         {4,4,2,0,0,4,9,15,16,20},
                                        {2,2,2,1,0,10,14,18,23,24},}; // 2

        MarsPlanner underTest = new MarsPlanner(topology,
                Arrays.asList(new int[]{ 1, 0 }, new int[]{ 2, 2 }));

        @Test
        void check() {
            int[] coords = underTest.bestLandingSpot(4);
            assertArrayEquals(new int[]{ 7, 2 }, coords, "Invalid coords");
        }
    }
}

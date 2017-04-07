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
}

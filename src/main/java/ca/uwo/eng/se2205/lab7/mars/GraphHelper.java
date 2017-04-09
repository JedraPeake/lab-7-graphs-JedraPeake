package ca.uwo.eng.se2205.lab7.mars;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by PeakeAndSons on 2017-04-09.
 */
public class GraphHelper {
    Map<Integer, Set<Integer>> edgeTo;

    GraphHelper() {
        this.edgeTo = new HashMap<Integer, Set<Integer>>();
    }

    public int size() {
        return edgeTo.size();
    }

    public void addEdge(int v1, int v2) {
        add(v1, v2);
        add(v2, v1);
    }

    public void add(int from, int to) {
        if (!edgeTo.containsKey(from)) {
            Set<Integer> s = new HashSet<Integer>();
            s.add(to);
            edgeTo.put(from, s);
        } else {
            edgeTo.get(from).add(to);
        }
    }

    public Set<Integer> adj(int v) {
        return edgeTo.get(v);
    }
}

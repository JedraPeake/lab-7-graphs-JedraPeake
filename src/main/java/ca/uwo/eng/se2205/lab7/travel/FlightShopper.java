package ca.uwo.eng.se2205.lab7.travel;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

/**
 * Optimized utility for shopping for flights.
 */
@ParametersAreNonnullByDefault
public final class FlightShopper {

    public DirectedG<Airport,Flight> map;
    int num;
    //Basically, this is a matter of traversing a graph, where each departure or arrival will be a node, and each flight an edge.
    //You'll typically apply costs to the edges
    // An arrival and departure at the same airport will be connected by an edge whose cost is the layover time (and from a price viewpoint, that edge will normally have a cost of zero).


    /**
     * Builds a {@code FlightShopper} via a {@link Set} of {@link Airport}s and {@link Flight}s.
     *
     * @param airports The available airports
     * @param flights All available flights
     */
    public FlightShopper(Collection<? extends Airport> airports, Collection<? extends Flight> flights) {
        // DO NOT CHANGE THE METHOD SIGNATURE
        // Initialize your shopper
        AbstractList<Airport> airportList = (AbstractList<Airport>) airports;
        AbstractList<Flight> flightsList = (AbstractList<Flight>) flights;
        List<Flight> flightLi = new ArrayList<>(flights);
        map = new DirectedG<>();
        num = airports.size();
        for(int i =0; i<airports.size();i++){
            map.newVertex(airportList.get(i));
        }
        for (Flight flight: flights) {
            map.newEdge(map.newVertex(flight.getDeparture()), map.newVertex(flight.getArrival()), flight.getCost());
        }

        for(int i =0; i<num;i++){
            for(int j =0; j<num;j++){
                for(int k =0; k<num;k++){

                }
            }
        }

//        for(int i =0; i<airports.size();i++){
//            Flight curr = flightsList.get(i);
//            Airport fromVer = curr.getDeparture();
//        }


//        for(int i =0; i<airports.size();i++){
//            Flight curr = flightsList.get(i);
//            Airport from = curr.getDeparture();
//            Airport to = curr.getArrival();
//            double weight = curr.getCost();
//            map.newEdge(from,to,weight);
//        }
//        for(int i =0; i<flightsList.size();i++){
//            Flight curr = flightsList.get(i);
//            String code  = curr.getDeparture().getCode();
//            graph.newEdgeFs(curr.getDeparture(),curr.getArrival(),curr.getCost());
//        }

    }

    /**
     * Finds the cheapest flight from two {@link Airport}s.
     * @param from Starting airport
     * @param to Ending airport
     * @return Cheapest {@code Itinerary} to fly between {@code from} and {@code to}
     */
    public Itinerary price(Airport from, Airport to) {

//        Deque<Airport> q = new ArrayDeque<>();
//        q.addLast(from);
//        Map<Airport,Double> cost = new HashMap<>();
//        cost.put(from,0.0);
//        Set<Airport> visited = new HashSet<>();
//        while (!q.isEmpty()){
//            Airport dept = q.pop();
//            if(!visited.contains(dept)) {
//                List<Flight> outgoing = getOutgoing(from);
//                double costtoD = cost.get(dept);
//                for(Flight f: outgoing){
//                    double costToA = cost.computeIfAbsent(f.getArrival(),);
//                }
////                if(costtoD + f )
////                q.addLast();
//            }
//            visited.add(dept);
//        }
        return null;
    }

//    private List<Flight> getOutgoing(Airport a){
//        List<Flight> out = new ArrayList<>();
////        for(Flight f : flights){
////            if(f.getDeparture().equals(a)){
////                out.add(f);
////            }
////        }
////        return out;
//        return null;
//    }

}

package ca.uwo.eng.se2205.lab7.graphs;

import ca.uwo.eng.se2205.lab7.travel.Airport;
import ca.uwo.eng.se2205.lab7.travel.Flight;
import ca.uwo.eng.se2205.lab7.travel.FlightShopper;
import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by PeakeAndSons on 2017-04-08.
 */
public class FlightShopperTest {
    @Test
    void Load(){
        Airport ATL = new Airport("ATL",-84.4281006,33.6366997);
        Airport HND = new Airport("HND",139.7799988,35.5522995);
        Airport LHR = new Airport("LHR",-0.461941,51.4706001);
        Airport ORD = new Airport("ORD",-87.9048004,41.9785996);
        Airport PEK = new Airport("PEK",116.5849991,40.080101);
        Airport PVG = new Airport("PVG",121.8050003,31.1434002);
        Airport YYZ = new Airport("YYZ",-79.6306,43.6772003);

        AbstractList<Airport> airportList = new ArrayList<>();
        airportList.add(ATL);
        airportList.add(LHR);
        airportList.add(ORD);
        airportList.add(YYZ);
        airportList.add(HND);
        airportList.add(PVG);
        airportList.add(PEK);

        Flight one = new Flight(ATL,LHR,1029);
        Flight two = new Flight(ATL,ORD,94);
        Flight three = new Flight(ATL,YYZ,263);

        Flight four = new Flight(HND,LHR,635);
        Flight five = new Flight(HND,ORD,935);
        Flight six = new Flight(HND,PVG,433);

        Flight seven = new Flight(LHR,ATL,796);
        Flight eight = new Flight(LHR,PVG,530);
        Flight nine = new Flight(LHR,YYZ,599);

        Flight ten = new Flight(ORD,ATL,109);
        Flight eleven = new Flight(ORD,HND,971);
        Flight twelve = new Flight(ORD,PEK,748);

        Flight thirteen = new Flight(PEK,HND,300);
        Flight fourteen = new Flight(PEK,LHR,324);
        Flight fifteen = new Flight(PEK,PVG,230);
        Flight sixteen = new Flight(PEK,YYZ,803);

        Flight seventeen = new Flight(PVG,PEK,230);

        Flight eighteen = new Flight(YYZ,ATL,265);
        Flight nineteen = new Flight(YYZ,LHR,567);
        Flight twenty = new Flight(YYZ,ORD,172);

        AbstractList<Flight> flightList = new ArrayList<>();
        flightList.add(one);
        flightList.add(two);
        flightList.add(three);
        flightList.add(four);
        flightList.add(five);
        flightList.add(six);
        flightList.add(seven);
        flightList.add(eight);
        flightList.add(nine);
        flightList.add(ten);
        flightList.add(eleven);
        flightList.add(twelve);
        flightList.add(thirteen);
        flightList.add(fourteen);
        flightList.add(fifteen);
        flightList.add(sixteen);
        flightList.add(seventeen);
        flightList.add(eighteen);
        flightList.add(nineteen);
        flightList.add(twenty);

        FlightShopper test = new FlightShopper(airportList,flightList);

        //WORKS DEBUG TO CHECK IT.....
//        for(int i =0; i< flightList.size();i++){
//            Airport curr = airportList.get(i);
//            assertEquals(true, test.map.vertices.contains(curr));
//        }
    }
}

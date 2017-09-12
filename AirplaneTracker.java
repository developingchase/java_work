/*
 * Title: AirplaneTracker.java
 * Purpose: To track an airplane as it flies
 * Authoer: Chase
 * Date: 2017JUN17
 * Class: Intro to Java 
*/

public class AirplaneTracker { //open class
    public static void main(String[] args){//open main
        //Build the instances
        Airplane flightUno = new Airplane("dl1234", 10000.0, 105);
        
        //event occurs
        System.out.println("------ Status Update -----");
        System.out.println("From the cabin: We are cleared for takeoff.");
        //check our status
        System.out.println(flightUno.printFlightStatus());        

        //event occurs
        System.out.println("------ Status Update Take off +1 hour -----");
        System.out.println("From the cabin: One hour of flight time has elapsed.");
        //fly an hour
        flightUno.getFlightRemainingRange(1.0);
        
        //check our status
        System.out.println(flightUno.printFlightStatus());        
        
        //event occurs
        System.out.println("------ Status Update Take off +1 hour-----");
        System.out.println("Disgruntled with the peanut selection, 30 passengers deplane mid-air with their baggage. Recalculating flight numbers...");
        
        //deplane the 30 passengers
        flightUno.setPassengerLoad(75);
        
        //check our status
        System.out.println(flightUno.printFlightStatus());
        //event occurs
        System.out.println("------ Status Update Take off +1.5 hours-----");
        System.out.println("From the cabin: For our remaining passengers, we have landed. Welcome to...");
        //fly 30 minutes
        flightUno.getFlightRemainingRange(0.5);
        
        //check our status
        System.out.println(flightUno.printFlightStatus());
    }//close main
}//close class

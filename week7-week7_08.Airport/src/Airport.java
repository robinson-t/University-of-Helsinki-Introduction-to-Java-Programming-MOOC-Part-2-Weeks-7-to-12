/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
import java.util.*;
public class Airport {
    private ArrayList<Airplane> planes;
    private ArrayList<Flight> flights;
    private Scanner reader;

    public Airport(Scanner reader) {
        this.reader = reader;
        this.flights = new ArrayList<Flight>();
        this.planes = new ArrayList<Airplane>();
    }
    
    
    
    
    public void start() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            String input = this.reader.nextLine();
            if (input.equals("1")) {
                System.out.println("Give plane ID: ");
                String id = reader.nextLine();
                System.out.println("Give plane capacity:");
                int capacity = Integer.parseInt(reader.nextLine());
                
                Airplane plane = new Airplane(id , capacity);
                this.planes.add(plane);
            } else if (input.equals("2")) {
                System.out.println("Give plane ID: ");
                String planeID = reader.nextLine();
                for (Airplane p : this.planes) {
                   if (p.getId().equals(planeID)) {
                       System.out.println("Give departure airport code: ");
                       String depart = reader.nextLine();
                       System.out.println("Give destination airport code: ");
                       String arrive = reader.nextLine();
                       Flight flight = new Flight(p , depart , arrive);
                       this.flights.add(flight);
                   } 
                }
            } else if (input.equals("x")) {
                break;
            }
            
        }
        flightService();
                
    }
    
    public void flightService() {
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            
            String input = reader.nextLine();
            if (input.equals("1")) {
                for (Airplane p : this.planes) {
                    System.out.println(p);
                }
            } else if (input.equals("2")) {
                for (Flight f : this.flights) {
                    System.out.println(f);
                }
            } else if (input.equals("3")) {
                System.out.println("Give plane ID: ");
                String planeID = reader.nextLine();
                for (Airplane p : this.planes) {
                   if (p.getId().equals(planeID)) {
                       System.out.println(p);
                   } 
                }

            } else if (input.equals("x")) {
                break;
            } 
        }
    }
        
}

package com.walmart.homework.theatre;

import java.util.*;

/**
 * Created by Krishna Ghatia on 4/29/2016.
 */
public class TheatreTicketServiceMain {

    public static void main(String[] args) {

        TheatreTicketService theatreTicketService = new TheatreTicketService();

        System.out.println("*****  Welcome to the ticket service.  *****");

        loop: while (true) {

            System.out.println("");
            System.out.println("");
            System.out.println("Please choose from the choices below.");
            System.out.println("1. Find the number of seats available.");
            System.out.println("2. Find and hold seats in the theater.");
            System.out.println("3. Reserve seats.");
            System.out.println("4. Wait for a while.");
            System.out.println("5. Display the number of seats available with every level.");
            System.out.println("6. Exit from the system.");
            System.out.println();
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            int input;
            try{
                input = scanner.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Please enter an integer value within the range.");
                break;
            }
            int firstLevelNumber = VenueLevel.values()[0].getLevel();
            int lastIndexValues = VenueLevel.values().length - 1;
            int lastLevelNumber = VenueLevel.values()[lastIndexValues].getLevel();

            switch (input) {


                case (1): {

                    System.out.println("Please enter the level you would like to check. Enter a variable between "+ firstLevelNumber +" and "+ lastLevelNumber +".");
                    Scanner scanner1 = new Scanner(System.in);
                    String venueLevelString = scanner1.nextLine();
                    Integer venueLevelInt;
                    try{
                        venueLevelInt = Integer.parseInt(venueLevelString);
                    }
                    catch (java.lang.NumberFormatException e){
                        venueLevelInt = null;
                    }
                    if ((venueLevelInt == null) || (firstLevelNumber <= venueLevelInt && venueLevelInt <= lastLevelNumber)){
                        Optional<Integer> venueLevel = Optional.ofNullable(venueLevelInt);
                        int numSeatsAvailable = theatreTicketService.numSeatsAvailable(venueLevel);
                        if(venueLevel.isPresent()){
                            System.out.println("There are "+numSeatsAvailable+ " available in the level.");
                        }
                        else {
                            System.out.println("There are "+numSeatsAvailable+ " tickets available in the theatre.");
                        }
                    }
                    else {
                        System.out.println("Number not in range");
                    }

                    break;
                }


                case 2: {
                    System.out.println("Please enter the number of seats you would like to reserve.");
                    Scanner scanner1 = new Scanner(System.in);
                    Integer numSeats;
                    try {
                        numSeats = scanner1.nextInt();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Please enter an integer value.");
                        break;
                    }
                    System.out.println();
                    System.out.println("Please enter the minimum level you would like to reserve seats in. Enter a variable between " + firstLevelNumber + " and " + lastLevelNumber + ".");
                    String minVenueLevelString = scanner1.nextLine();
                    Integer minVenueLevelInt;
                    try {
                        minVenueLevelInt = Integer.parseInt(minVenueLevelString);
                    } catch (java.lang.NumberFormatException e) {
                        minVenueLevelInt = null;
                    }
                    Optional<Integer> minVenueLevel;
                    if ((minVenueLevelInt == null) || (firstLevelNumber <= minVenueLevelInt && minVenueLevelInt <= lastLevelNumber)) {
                        minVenueLevel = Optional.ofNullable(minVenueLevelInt);
                        if (minVenueLevel == null) {
                            minVenueLevel = Optional.of(firstLevelNumber);
                        }
                    } else {
                        System.out.println("Number not in range");
                        break;
                    }

                    System.out.println();
                    System.out.println("Please enter the minimum level you would like to reserve seats in. Enter a variable between " + firstLevelNumber + " and " + lastLevelNumber + ".");
                    String maxVenueLevelString = scanner1.nextLine();
                    Integer maxVenueLevelInt;
                    try {
                        maxVenueLevelInt = Integer.parseInt(maxVenueLevelString);
                    } catch (java.lang.NumberFormatException e) {
                        maxVenueLevelInt = null;
                    }
                    Optional<Integer> maxVenueLevel;
                    if ((maxVenueLevelInt == null) || (firstLevelNumber <= maxVenueLevelInt && maxVenueLevelInt <= lastLevelNumber)) {
                        maxVenueLevel = Optional.ofNullable(maxVenueLevelInt);
                        if (maxVenueLevel == null) {
                            maxVenueLevel = Optional.of(lastLevelNumber);
                        }
                    } else {
                        System.out.println("Number not in range");
                        break;
                    }

                    System.out.println();
                    System.out.println("Please enter the email id of the customer");
                    String customerEmail = scanner1.nextLine();

                    SeatHold seatHold = theatreTicketService.findAndHoldSeats(numSeats, minVenueLevel, maxVenueLevel, customerEmail);

                    theatreTicketService.displaySeatsInAllLevels();

                    break;
                }


                case (3): {

                    System.out.println("This method cannot be run using command line because the seatHoldId's are randomly generated and therefore can't be entered.");
                    break ;
                }

                case (4): {
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    break ;
                }

                case (5): {
                    theatreTicketService.displaySeatsInAllLevels();
                    break;
                }

                case (6): {
                    System.exit(0);
                }

                default: {
                    System.out.println("Wrong input. Please try again between the given values.");
                }

            }
            // ...
        }

    }

}

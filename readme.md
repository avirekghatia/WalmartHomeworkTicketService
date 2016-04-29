@author - Avirek Ghatia, ag4682@nyu.edu, 5519985147

#Walmart Ticket Service Homework
A ticket service management for a theatre.

##Input/Output
Input and output using command line. The program interacts with the user taking inputs and displays output.

##Testing
The program has been tested in the following environment:
1. Windows 8 operating system, version 6.2, AMD 64 bit architecture
2. Java - JDK 1.8.0.65
3. Maven - 3.3.1

##Running the application
In order to run the application, please extract the contents of the folder.
"Walmart-ticket-service.jar" contained in the folder is the executable jar file.
Open the command line terminal change directory to locate pom.xml.
The jar file is an executable file which can be run using command "**java -jar Walmart-ticket-service.jar**"
You can also perform the following steps in order to build the project:
1. mvn clean
2. mvn package
After step 2, a "Walmart-ticket-service.jar" file will be created in the target directory
3. Change the directory to target folder
4. run the jar file using command "**java -jar Walmart-ticket-service.jar**"
5. This should start running the main class in the project.

###Seats
Seats are allocated an initial state - Available to be reserved - which may later be changed depending on the reservations.

###VenueLevels
VenueLevels have been declared as Enum type.

###Seat hold time threshold
A seat is automatically released after a threshold value. The threshold values has been kept to be 30 seconds to make it easy to test the program.
A seat must be reserved before 30 seconds otherwise the hold is released.

###Seating algorithm
The seats are allocated based on first come first serve basis at a level within the venue.
The seats are allocated based on the availability at the levels requested. No preference is given for the seats within a particular level.
The first person to hold seats in a level is allocated seats in the first row of the level.

##Assumptions
1. A seat can be reserved only after if it is currently held.
2. As long as the reserve operation has been started on a seat, it does not matter even if the hold was removed from the seat.

##Dependencies
1. Java 1.8
2. Maven
3. JUnit




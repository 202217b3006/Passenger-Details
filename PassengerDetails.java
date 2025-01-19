import java.util.*;

class Passenger implements Comparable<Passenger> {
    String name,ticketClass,adharID,StartPlace,destination,SeatNumber;
    int age;
    
    public void  getpassengerdata(Scanner rd){
            System.out.print("Name: ");
            name = rd.nextLine();
            System.out.print("Aadhar ID: ");
            adharID = rd.nextLine();
            System.out.print("Age: ");
            age = rd.nextInt();
            rd.nextLine(); 
            System.out.print("Ticket Class (Economy/Business/First): ");
            ticketClass = rd.nextLine();
            System.out.print("Start Place: ");
            StartPlace = rd.nextLine();
            System.out.print("Destination: ");
            destination = rd.nextLine();
            System.out.print("Seat Number: ");
            SeatNumber = rd.nextLine();

    }

    public String getadharID() {
        return adharID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTicketClass() {
        return ticketClass;
    }
    public String getStartPlace() {
		return StartPlace;
	}

    public String getDestination() {
        return destination;
    }
    public String getSeatNumber() {
        return SeatNumber;
    }

    public void displaypassengerdata() {
        System.out.printf("%-15s %-15s %-5s %-15s %-15s %-15s %-10s\n",name,adharID,age,ticketClass,StartPlace,destination,SeatNumber);
    }
    public int compareTo(Passenger other) {
        return this.name.compareTo(other.name);
    }
}

class SortByadhar implements Comparator<Passenger> {
    @Override
    public int compare(Passenger p1, Passenger p2) {
        return p1.getadharID().compareTo(p2.getadharID());
    }
}

class SortByAge implements Comparator<Passenger> {
    @Override
    public int compare(Passenger p1, Passenger p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}

class SortByClass implements Comparator<Passenger> {
    @Override
    public int compare(Passenger p1, Passenger p2) {
        return p1.getTicketClass().compareTo(p2.getTicketClass());
    }
}

class SortByend implements Comparator<Passenger> {
    @Override
    public int compare(Passenger p1, Passenger p2) {
        return p1.getDestination().compareTo(p2.getDestination());
    }
}

public class PassengerDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Passenger> passengers = new ArrayList<>();
        Set<String> adharid = new HashSet<>();
         

        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter details for passenger " + i + ":");
            Passenger p = new Passenger();
            p.getpassengerdata(sc);
            if (!adharid.add(p.getadharID())) {
                System.out.println("Duplicate Adhar id found");
                continue;
            }
             
            passengers.add(p);
        
    }
        System.out.println("\nPassenger Details:");
        System.out.printf("%-15s %-10s %-10s %-15s %-15s %-15s %-10s\n","Name", "Adhar ID", "Age", "Class", "Start Place", "Destination", "Seat No.");
        for (Passenger pp : passengers) {
            pp.displaypassengerdata();
        }

        // Sorting
            System.out.println("\nSort by:");
            System.out.println("1. Name");
            System.out.println("2. Adhar ID");
            System.out.println("3. Age");
            System.out.println("4. Ticket Class");
            System.out.println("5. Destination");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    Collections.sort(passengers);
                    break;
                case 2:
                    passengers.sort(new SortByadhar());
                    break;
                case 3:
                    passengers.sort(new SortByAge());
                    break;
                case 4:
                    passengers.sort(new SortByClass());
                    break;
                case 5:
                    passengers.sort(new SortByend());
                    break;
                default:
                    System.out.println("Invalid choice.");
                    
            }

            //sorted data
            System.out.println("\nSorted Passenger Details:");
            System.out.printf("%-15s %-10s %-10s %-15s %-15s %-15s %-10s\n","Name", "Adhar ID", "Age", "Class", "Start Place", "Destination", "Seat No.");
            for (Passenger pp : passengers) {
                pp.displaypassengerdata();
            }
        
    }
}


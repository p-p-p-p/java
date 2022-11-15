// Simulation of a flight reservation system.
// The system has to take input like flight type, 
// the number of seats, the cost of each seat, total luggage load, 
// individual bags allowed per ticket,etc.
// To create a reservation system wherein you will show a list of available seats and take
// reservation request and process it. You can add further capabilities such as canceling a
// reserved seat, refund, bulk booking, etc. It will also help find the availability of seats and
//  find the booking information. You can use simple file handling. Apart from this, a feature wherein 
//  each user has an account that categorizes them as frequent flyer and regular. The former category 
//  gets a flat 30% disvount on the total amount and the latter category has no discount.

// Path: air.java
import java.io.*;  
import java.util.Scanner;
import java.util.UUID;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


interface GlobalConstants
    {
        //total sit available in each class
        int[] totalSit = {100, 50, 20};
        // source and destination array
        String[] source = {"Delhi", "Mumbai", "Kolkata", "Chennai", "Bangalore"};
        String[] destination = {"London", "New York", "Dubai", "Singapore", "Paris"};
        // flight type array
        String[] flightType = {"Economy", "Business", "First Class"};
        //flight time exact time
        String[] flightTime = {"10:00 AM", "12:00 PM", "2:00 PM", "4:00 PM", "6:00 PM"};
        //flight date array
        String[] flightDate = {"1/1/2021", "2/1/2021", "3/1/2021", "4/1/2021", "5/1/2021"};
        //flight price array
        int[] flightPrice = {10000, 20000, 30000};
        int firstClassSeat = 0;
        int businessClassSeat = 0;
        int economyClassSeat = 0;

    }
class air implements  GlobalConstants

{
    
     


    public static int  BookTicket() 
    {   
            Scanner sc = new Scanner(System.in);
            //total sit available in each class
            // int[] totalSit = {100, 50, 20};
            //max lagguage weight in each class
            int[] maxLagguage = {20, 15, 10};
            //max lagguage per person in each class
            int[] maxLagguagePerPerson = {5, 3, 2};
            int totalLagguageWeight = 0;
            // source and destination array
            // String[] source = {"Delhi", "Mumbai", "Kolkata", "Chennai", "Bangalore"};
            // String[] destination = {"London", "New York", "Dubai", "Singapore", "Paris"};
            // flight type array
            // String[] flightType = {"Economy", "Business", "First Class"};
            //flight time exact time
            // String[] flightTime = {"10:00 AM", "12:00 PM", "2:00 PM", "4:00 PM", "6:00 PM"};
            //flight date array
            // String[] flightDate = {"1/1/2021", "2/1/2021", "3/1/2021", "4/1/2021", "5/1/2021"};
            

            // luggage array
            String[] luggage = {"Yes", "No"};
      
            
            // seat array
            String[] seat = {"Window", "Middle", "Aisle"};
            // age array
            String[] age = {"Adult", "Child", "Infant"};
            // meal array
            String[] meal = {"Veg", "Non-Veg", "No Meal"};
            // payment array
            String[] payment = {"Credit Card", "Debit Card", "Net Banking", "UPI", "Cash"};
            System.out.println("Choose your source");
            for(int i = 0; i < source.length; i++)
            {
                System.out.println(i+1 + ". " + source[i]);
            }
            int sourceChoice = sc.nextInt();
            System.out.println("Choose your destination");
            for(int i = 0; i < destination.length; i++)
            {
                System.out.println(i+1 + ". " + destination[i]);
            }
            int destinationChoice = sc.nextInt();

            System.out.println("Choose your flight date");
            for(int i = 0; i < flightDate.length; i++)
            {
                System.out.println(i+1 + ". " + flightDate[i]);
            }
            int flightDateChoice = sc.nextInt();



            System.out.println("Choose your flight time");
            for(int i = 0; i < flightTime.length; i++)
            {
                System.out.println(i+1 + ". " + flightTime[i]);
            }
            int flightTimeChoice = sc.nextInt();
            System.out.println("Choose your flight type");
            for(int i = 0; i < flightType.length; i++)
            {
                System.out.println(i+1 + ". " + flightType[i]);
            }
            int flightTypeChoice =sc.nextInt();

            System.out.println("Enter your name");
            String name = sc.nextLine();

            System.out.println("Choose your age");
            for(int i = 0; i < age.length; i++)
            {
                System.out.println(i+1 + ". " + age[i]);
            }
            int ageChoice = sc.nextInt();

            System.out.println("Choose your seat");
            for(int i = 0; i < seat.length; i++)
            {
                System.out.println(i+1 + ". " + seat[i]);
            }
            int seatChoice = sc.nextInt();

            System.out.println("How many tickets you want to book");
            int numberOfTicket = sc.nextInt();
            if (numberOfTicket > totalSit[flightTypeChoice-1])
            {
                System.out.println("Sorry, we don't have that much seats");
                return 0;
            }
            


            System.out.println("Choose your meal");
            for(int i = 0; i < meal.length; i++)
            {
                System.out.println(i+1 + ". " + meal[i]);
            }
            int mealChoice = sc.nextInt();
            System.out.println("Choose your payment");
            for(int i = 0; i < payment.length; i++)
            {
                System.out.println(i+1 + ". " + payment[i]);
            }
            int paymentChoice = sc.nextInt();
            System.out.println("Do you want to carry luggage");
            for(int i = 0; i < luggage.length; i++)
            {
                System.out.println(i+1 + ". " + luggage[i]);
            }
            int luggageChoice = sc.nextInt();
            if(luggageChoice == 1)
            {
                System.out.println("Enter the total weight of your luggage");
                int totalLagguage = sc.nextInt();
                if(totalLagguage > maxLagguage[flightTypeChoice-1])
                {
                    System.out.println("Sorry, you can't carry this much luggage");
                }
                else
                {
                    System.out.println("Enter the weight of each luggage");
                    int[] lagguageWeight = new int[numberOfTicket];
                    

                    for(int i = 0; i < numberOfTicket; i++)
                    {
                        lagguageWeight[i] = sc.nextInt();
                        totalLagguageWeight += lagguageWeight[i];
                        if(lagguageWeight[i] > maxLagguagePerPerson[flightTypeChoice-1])
                        {
                            System.out.println("Sorry, you can't carry this much luggage");
                        }
                    }
                }
            
            
            int totalbill = 0;
            if(flightTypeChoice == 1)
            {
                totalbill = flightPrice[flightTypeChoice-1] * numberOfTicket;
            }
            else if(flightTypeChoice == 2)
            {
                totalbill =  flightPrice[flightTypeChoice-1] * numberOfTicket;
            }
            else if(flightTypeChoice == 3)
            {
                // if flightTypeChoice is first class then 30% discount
                totalbill = flightPrice[flightTypeChoice-1] * numberOfTicket;
                totalbill = totalbill - (totalbill * 30)/100;
            }
            System.out.println("Your ticket has been booked");
            System.out.println("Your ticket details are as follows");
            System.out.println("Source: " + source[sourceChoice-1]);
            System.out.println("Destination: " + destination[destinationChoice-1]);
            System.out.println("Flight Date: " + flightDate[flightDateChoice-1]);
            System.out.println("Flight Time: " + flightTime[flightTimeChoice-1]);
            System.out.println("Flight Type: " + flightType[flightTypeChoice-1]);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age[ageChoice-1]);
            System.out.println("Seat: " + seat[seatChoice-1]);
            System.out.println("Total seats booked: " + numberOfTicket);
            System.out.println("Meal: " + meal[mealChoice-1]);
            System.out.println("Payment: " + payment[paymentChoice-1]);
            System.out.println("Luggage: " + luggage[luggageChoice-1]);
            System.out.println("Total luggage weight: " + totalLagguageWeight);
            UUID uniqueKey = UUID.randomUUID();
            System.out.println("Total bill: " + totalbill);
            // store first 5 charater from uniqueKey
            String ticketId = uniqueKey.toString().substring(0, 5);
            System.out.println ("Your unique key to cancel your ticket or check status is: " + ticketId);

            //store all the data in a json file using gson where ticketId is the key and all the data is the value
            
            // 
            String userJson= "{'ticketId':'"+ticketId+"','source':'"+source[sourceChoice-1]+"','destination':'"+destination[destinationChoice-1]+
            "','flightDate':'"+flightDate[flightDateChoice-1]+"','flightTime':'"+flightTime[flightTimeChoice-1]+
            "','flightType':"+flightType[flightTypeChoice-1]+",'name':'"+name+"','age':"+age[ageChoice-1]+
            "','seat':"+seat[seatChoice-1]+",'numberOfTicket':"+numberOfTicket+",'meal':'"+meal[mealChoice-1]+
            "','payment':'"+payment[paymentChoice-1]+"','luggage':"+luggage[luggageChoice-1]+
            ",'totalLagguageWeight':"+totalLagguageWeight+",'totalbill':"+totalbill+"}\n";



          
            //append  the data to old json file wich is already present
            try {
                FileWriter file = new FileWriter("./data.json", true);
                file.write(userJson);
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            


            



            return 1; 

        }
        return 0;
                

        


    }

    public static void  CheckTicket()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your ticket id");
        String ticketId = sc.nextLine();
        // read the data.json file and display the data using gson
        try {
            File myObj = new File("./data.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String jsonString = myReader.nextLine();
                JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
                System.out.println(jsonObject);
                // System.out.println(jsonObject.get("ticketId").getAsString());
                // System.out.println(jsonObject.get("ticketId").getAsString()==ticketId);
                //check if the ticketId is present in the json file
                if(jsonObject.get("ticketId").getAsString().equals(ticketId))
                {
                    System.out.println("Your ticket details are as follows");
                    System.out.println("Unique key: " + jsonObject.get("ticketId").getAsString());
                    System.out.println("Source: " + jsonObject.get("source").getAsString());
                    System.out.println("Destination: " + jsonObject.get("destination").getAsString());
                    System.out.println("Flight Date: " + jsonObject.get("flightDate").getAsString());
                    System.out.println("Flight Time: " + jsonObject.get("flightTime").getAsString());
                    System.out.println("Flight Type: " + jsonObject.get("flightType").getAsString());
                    System.out.println("Name: " + jsonObject.get("name").getAsString());
                    System.out.println("Age: " + jsonObject.get("age").getAsString());
                    System.out.println("Seat: " + jsonObject.get("seat").getAsString());
                    System.out.println("Total seats booked: " + jsonObject.get("numberOfTicket").getAsString());
                    System.out.println("Meal: " + jsonObject.get("meal").getAsString());
                    System.out.println("Payment: " + jsonObject.get("payment").getAsString());
                    System.out.println("Luggage: " + jsonObject.get("luggage").getAsString());
                    System.out.println("Total luggage weight: " + jsonObject.get("totalLagguageWeight").getAsString());
                    System.out.println("Total bill: " + jsonObject.get("totalbill").getAsString());
                    break;
                }
                
                
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }



    public static void  CancelTicket()
    {
        System.out.println("Enter your ticket id");
        Scanner sc = new Scanner(System.in);
        String ticketId = sc.nextLine();
        // read the data.json file and display the data using gson
        try
        {
            File myObj = new File("./data.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String jsonString = myReader.nextLine();
                JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
                // System.out.println(jsonObject);
                // System.out.println(jsonObject.get("ticketId").getAsString());
                // System.out.println(jsonObject.get("ticketId").getAsString()==ticketId);
                //check if the ticketId is present in the json file
                if(jsonObject.get("ticketId").getAsString().equals(ticketId))
                {
                    System.out.println("Your ticket details are as follows");
                    System.out.println("Unique key: " + jsonObject.get("ticketId").getAsString());
                    System.out.println("Source: " + jsonObject.get("source").getAsString());
                    System.out.println("Destination: " + jsonObject.get("destination").getAsString());
                    System.out.println("Flight Date: " + jsonObject.get("flightDate").getAsString());
                    System.out.println("Flight Time: " + jsonObject.get("flightTime").getAsString());
                    System.out.println("Flight Type: " + jsonObject.get("flightType").getAsString());
                    System.out.println("Name: " + jsonObject.get("name").getAsString());
                    System.out.println("Age: " + jsonObject.get("age").getAsString());
                    System.out.println("Seat: " + jsonObject.get("seat").getAsString());
                    System.out.println("Total seats booked: " + jsonObject.get("numberOfTicket").getAsString());
                    System.out.println("Meal: " + jsonObject.get("meal").getAsString());
                    System.out.println("Payment: " + jsonObject.get("payment").getAsString());
                    System.out.println("Luggage: " + jsonObject.get("luggage").getAsString());
                    System.out.println("Total luggage weight: " + jsonObject.get("totalLagguageWeight").getAsString());
                    System.out.println("Total bill: " + jsonObject.get("totalbill").getAsString());
                    System.out.println("Do you want to cancel your ticket? (y/n)");
                    String choice = sc.nextLine();
                    if(choice.equals("y"))
                    {
                        System.out.println("Your ticket has been cancelled");
                        //delete the data from the json file
                        //create a new json file and copy all the data except the data which is to be deleted
                        //delete the old json file and rename the new json file to old json file
                        try {
                            File myObj1 = new File("./data.json");
                            Scanner myReader1 = new Scanner(myObj1);
                            while (myReader1.hasNextLine()) {
                                String jsonString1 = myReader1.nextLine();
                                JsonObject jsonObject1 = new JsonParser().parse(jsonString1).getAsJsonObject();
                                if(jsonObject1.get("ticketId").getAsString().equals(ticketId))
                                {
                                    continue;
                                }
                                else
                                {
                                    try {
                                        FileWriter file = new FileWriter("./data1.json", true);
                                        file.write(jsonString1+"\n");
                                        file.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                
                            }
                            myReader1.close();
                            File file = new File("./data.json");
                            file.delete();
                            File file1 = new File("./data1.json");
                            file1.renameTo(new File("./data.json"));
                        



        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
                    }
                    else
                    {
                        System.out.println("Your ticket is not cancelled");
                    }
                    break;
                }
                
                
            }
            myReader.close();
            } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }

                      



    }




    
    public static void  Passanger() {
        {
            int choice;

            System.out.println("1.Book Ticket");
            System.out.println("2.Check Ticket");
            System.out.println("3.Cancel Ticket");
            System.out.println("4.Exit");
            System.out.println("Enter your choice");
            choice=Integer.parseInt(System.console().readLine());
       
            switch(choice) {
                case 1:
                    //  call BookTicket() method using object
                    BookTicket();
                
                    break;
                case 2:
                    CheckTicket();
                    break;
                case 3:
                    CancelTicket();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }




    }


    



    public static void  available_seat() throws FileNotFoundException
    {

        System.out.println("Choose the flight date");
        // access GlobalConstants flightDate
        int length=GlobalConstants.flightDate.length;
        for(int i=0;i<length;i++)
        {
            System.out.println((i+1)+". "+GlobalConstants.flightDate[i]);
        }
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        String flightDate = GlobalConstants.flightDate[choice-1];
        System.out.println("Choose the flight time");
        // access GlobalConstants flightTime
        // Read data.json file and 
        // display the available sit
        // display the booked sit
        // display the total sit
        // display the total available sit
        // display the total booked sit
        // display the total sit in every class
        // display the total available sit in every class
        // display the total booked sit in every class

        File myObj = new File("./data.json");
       
        int booked_seat_in_first_class=0;
        int booked_seat_in_business_class=0;
        int booked_seat_in_economy_class=0;

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String jsonString = myReader.nextLine();
                JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
                // System.out.println(jsonObject);
                // calculate how many sit available in every class and how may 
                // sit are booked
                // calculate how many sit available and how may sit are booked
                

                if (jsonObject.get("flightDate").getAsString().equals(flightDate)) {
                    if(jsonObject.get("seat").getAsString().equals(flightType[0]))
                    {
                        booked_seat_in_first_class+=jsonObject.get("numberOfTicket").getAsInt();
                    }
                    else if(jsonObject.get("seat").getAsString().equals(flightType[1]))
                    {
                        booked_seat_in_business_class+=jsonObject.get("numberOfTicket").getAsInt();
                    }
                    else if(jsonObject.get("seat").getAsString().equals(flightType[2]))
                    {
                        booked_seat_in_economy_class+=jsonObject.get("numberOfTicket").getAsInt();
                    }
                }
                
            }
        } catch (JsonSyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int total_seat_in_first_class=GlobalConstants.totalSit[0];
                int total_seat_in_business_class=GlobalConstants.totalSit[1];
                int total_seat_in_economy_class=GlobalConstants.totalSit[2];
                int total_seat=total_seat_in_first_class+total_seat_in_business_class+total_seat_in_economy_class;
                int available_seat_in_first_class=total_seat_in_first_class-booked_seat_in_first_class;
                int available_seat_in_business_class=total_seat_in_business_class-booked_seat_in_business_class;
                int available_seat_in_economy_class=total_seat_in_economy_class-booked_seat_in_economy_class;
                int available_seat=total_seat-booked_seat_in_first_class-booked_seat_in_business_class-booked_seat_in_economy_class;
              

                System.out.println("Total seat in first class: "+total_seat_in_first_class);
                System.out.println("Total seat in business class: "+total_seat_in_business_class);
                System.out.println("Total seat in economy class: "+total_seat_in_economy_class);
                System.out.println("Total seat: "+total_seat);
                System.out.println("Available seat in first class: "+available_seat_in_first_class);
                System.out.println("Available seat in business class: "+available_seat_in_business_class);
                System.out.println("Available seat in economy class: "+available_seat_in_economy_class);
                System.out.println("Total seat you can book now: "+available_seat);
                System.out.println("Booked seat in first class: "+booked_seat_in_first_class);
                System.out.println("Booked seat in business class: "+booked_seat_in_business_class);
                System.out.println("Booked seat in economy class: "+booked_seat_in_economy_class);
                System.out.println("Total Booked seat: "+booked_seat_in_first_class+booked_seat_in_business_class+booked_seat_in_economy_class);

        

        



    }

    public static void  Admin()
    {
        int choice;

        System.out.println("1.Display Details");
        System.out.println("2.Exit");
        System.out.println("Enter your choice");
        choice=Integer.parseInt(System.console().readLine());
   
        switch(choice) {
            case 1:
                //  call BookTicket() method using object
                try {
                    available_seat();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;

            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }

    public static void main(String args[])throws IOException
    {
    //    create a switch case where option is 1.admin 2.passanger 3.exit and it run in infinite loop until press 3
    //    in admin option it will ask for password and if password is correct then it will show the menu
    //    in passanger option it will show the menu
    //    in exit option it will exit the program
    //    in menu it will show the option like 1.book ticket 2.cancel ticket 3.check ticket 4.exit
    //    in book ticket it will ask for the number of ticket and then it will ask for the seat number and then it will ask for the luggage and then it will ask for the name and then it will ask for the age and then it will ask
    
    // create a global array for availave seat and booked seat
    

    int choice= 0;


    do
    {
        System.out.println("Welcome to Airline Reservation System");
        System.out.println("1.Passanger");
        System.out.println("2.Admin");
        System.out.println("3.Exit");
        System.out.print("Enter Your Choice : ");
        choice = Integer.parseInt(System.console().readLine());
        switch(choice)
        {
            case 1:
            {
                // call Passanger() method using object
                Passanger();
                break;
            }
            case 2:
            {
                Admin();
                break;
            }
            case 3:
            {
                System.out.println("Thank You For Using Our System");
                break;
            }
            default:
            {
                System.out.println("Invalid Choice");
                break;
            }
                      
        }
    }
    while(choice!=10);
    }



}
    




      

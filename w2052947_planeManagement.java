import java.util.Scanner;
import java.util.InputMismatchException;


public class w2052947_planeManagement{

    static int[][]seat = seatArray() ; //  define the seat array outside the main method (otherwise second round X again replace to O)
    static Ticket[] ticketsSold = new Ticket[100] ; 
    static int ticketCount = 0 ; 

    public static void main(String[] args) {

        String userAnswer = "y" ;
        int UserInput = 0 ;
        Scanner scanner = new Scanner(System.in) ; // get scanner for inputs

        try 
        {
        System.out.println("\n\n\n                                             ~~~~ WELCOME TO THE PLANE MANAGEMENT APLICATION ~~~~") ;

        while (true) 
        {
            if (userAnswer.equals("y")) {

        System.out.println("\n\n       *************************************************************************************************************************************");
        System.out.println("       *                                                        MENU OPTIONS                                                               *");
        System.out.println("       *************************************************************************************************************************************");
        System.out.println("\n            1)  Buy a seat                                                                                                             ");
        System.out.println("\n            2)  Cancel a seat                                                                                                          ");
        System.out.println("\n            3)  Find first avaliable seat                                                                                              ");
        System.out.println("\n            4)  Show seating plan                                                                                                      ");
        System.out.println("\n            5)  Print tickets information and total sales                                                                              ");
        System.out.println("\n            6)  Search tiket                                                                                                           ");
        System.out.println("\n            0)  Quit                                                                                                                   ");
        System.out.println("\n       *************************************************************************************************************************************") ;

        do
        { System.out.print("\n\nPlease select an option : ") ;
        UserInput = scanner.nextInt();  }

        while(UserInput != 0 && UserInput != 1 && UserInput != 2 && UserInput != 3 && UserInput != 4 && UserInput != 5 && UserInput != 6 );


        if (UserInput == 1) {   
            buy_seat(seat,scanner);
            System.out.print("\nDo you want to exit or cotinue (y or n): ");
            userAnswer = scanner.next();
        }
        else if (UserInput == 2) {
            cancel_seat(seat, scanner );
            System.out.print("\nDo you want to exit or continue (y r n): ");
            userAnswer = scanner.next();
        }
        else if (UserInput == 3) {
            find_first_available(seat) ;
            System.out.print("\nDo you want to exit or cotinue (y or n): ");
            userAnswer = scanner.next();
        }
        else if (UserInput == 4) {
            show_Seating_Plan(seat) ;
            System.out.print("\nDo you want to exit or cotinue (y or n): ");
            userAnswer = scanner.next();
        }
        else if (UserInput == 5) {
            print_ticket_info(seat ) ;
            System.out.print("\nDo you want to exit or cotinue (y or n): ");
            userAnswer = scanner.next();
        }
        else if (UserInput == 6) {
            search_ticket(seat , scanner) ;
            System.out.print("\nDo you want to exit or cotinue (y or n): ");
            userAnswer = scanner.next();
        }
        else if (UserInput == 0) {
            System.out.println("\n** Big thanks for choosing us! **\n");
            break ;
        }

    } else if (userAnswer.equals("n") ){
        System.out.println("\n** Big thanks for choosing us! **\n"); 
        break ;

    } else {
        System.out.print("\npleace enater correct answer ! \nDo you want to exit or cotinue (y or n): ");
        userAnswer = scanner.next();
    }

    }
         
    } catch (InputMismatchException e) 
    {System.out.print("Enter correct number and Try again !") ; }
        
    }


    public static int[][] seatArray(){  // create 2D array for seat structure

        int[][] seat ;
        seat = new int[][]
        { 
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0}, 
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };

        return seat ;
    };


    public static void buy_seat(int[][] seat, Scanner scanner) {  // create new method name called buySeat
        
        System.out.println("\n\nThis is the seat structure\n\n1 = Sold seats\n0 = Avaliable seats") ;
        System.out.println(); 

        char rawLabel = 'A' ;  // delclair raw name


        for (int i = 0 ; i < seat.length ; i++ ) // go through row ( i < 5 ) **seat.length** = means length of rows
        {
            System.out.print(rawLabel + "    "); // print labe a raw
            for (int j = 0 ; j < seat[i].length ; j++) // go through column ( j < 14) **seat[i].length** = means 1st raw length 
            {
                System.out.print(seat[i][j] + " ") ; // print row and column 
            }
            System.out.println(); // move to the next line after one row
            rawLabel ++ ;
        }
        
        // get inputs for person class

        System.out.print("\nEnter name : "); // gat name
        String name = scanner.next() ;

        System.out.print("Enter surname : "); // get surname
        String surname = scanner.next();

        System.out.print("Enter email : "); // get email
        String email = scanner.next() ;
        

        String seatPosition = "";
        boolean input = false ;

        while (!input) {
            try {
                System.out.print("\nEnter the row letter and column number of the seat you want to book (Ex. A5): ") ; // get seat position from user
                seatPosition = scanner.next() ; 

                char letterInput = seatPosition.charAt(0) ;
                int numberInput = Integer.parseInt(seatPosition.substring(1)) ;

                if ( (letterInput == 'A' && numberInput <= 14) ||
                (letterInput =='D' && numberInput <= 14) ||
                (letterInput == 'B' && numberInput <= 12) ||
                (letterInput == 'C' && numberInput <= 12 ))
                 {

                    input = true ;
                }
                else {
                    System.out.println("Incorrect value ! pleace try again.....");
                }


        }catch(InputMismatchException e ) {
            System.out.println("Incorrect value ! pleace try again.....");
        } catch(NumberFormatException e) {
            System.out.println("Incorrect value ! pleace try again.....");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect value ! pleace try again.....");
        }
    }


        char letterInput = seatPosition.charAt(0) ; // exract letter in the user input
        int numberInput = Integer.parseInt(seatPosition.substring(1)) ; // exract number in the user input 
        int charPosition = letterInput - 65  ; // A means 65 so then we have to substract 65 to access 1st element 

        int x = seat[charPosition][numberInput -1 ] ; // < -1 > -- couse 0 is the 1st element , 1 is the 2nd element 

        if ( x == 1) {
            System.out.println("\nSorry that seat is already booked ! Try another seat... ") ;
        }

        if (x == 0 ) {
        // get values for ticket class (from input)
        String row = seatPosition.substring(0,1) ;  // extract letter from input 
        int seat1 = numberInput ;

        double price = 0 ;

        // set the price according to the seat position 
        if (numberInput <= 5) {
            price = 200 ;
        }
        else if (numberInput < 10) {
            price = 150 ;
        }
        else if (numberInput <= 14) {
            price = 180 ;
        }
        
        // create person and ticket objects
        Person person = new Person(name, surname, email);
        Ticket ticket = new Ticket(row , seat1 , price , person) ;

        ticketsSold[ticketCount] = ticket ; // add the tickets to the ticketsSold array
        ticketCount ++ ;

        // print ticket and personal infomation
        ticket.ticketinfo();

        seat[charPosition][numberInput -1] = 1 ; // replace  0 to 1 ** reason to use -1 for index 3 means 4th element 
        System.out.println("\n*** seat " + seatPosition + " has been booked ***");

        ticket.save(seatPosition); } // save the ticket 
    }


    public static void cancel_seat( int[][] seat, Scanner scanner){ // create cancel_seat method

        String seatPosition1 = "";
        boolean input = false ;

        while (!input) {
            try {
 
            System.out.print("\nEnter the row letter and column number of the seat you want to cancel (Ex. A5): "); // get input from user
            seatPosition1 = scanner.next();

            char letterInput1 = seatPosition1.charAt(0) ;
                int numberInput1 = Integer.parseInt(seatPosition1.substring(1)) ;

                if ( (letterInput1 == 'A' && numberInput1 <= 14) ||
                (letterInput1 =='D' && numberInput1 <= 14) ||
                (letterInput1 == 'B' && numberInput1 <= 12) ||
                (letterInput1 == 'C' && numberInput1 <= 12 ))
                 {

                    input = true ;
                }
                else {
                    System.out.println("Incorrect value ! pleace try again.....");
                }


        }catch(InputMismatchException e ) {
            System.out.println("Incorrect value ! pleace try again.....");
        } catch(NumberFormatException e) {
            System.out.println("Incorrect value ! pleace try again.....");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect value ! pleace try again.....");
        }
    }

        char letterInput1 = seatPosition1.charAt(0) ; // get letter from input (row)
        int numberInput1 = Integer.parseInt(seatPosition1.substring(1)) ; // get number from input (colomn)
        int charPosition1 = letterInput1 - 65 ; // A means 65 so then we have to substract 65 to access 1st element

        int y = seat[charPosition1][numberInput1-1] ; // < -1 > -- couse 0 is the 1st element , 1 is the 2nd element 
        
        if (y == 0) {
            System.out.println("That seat is already free ! Enter correct seat number....");
        }

        else if(y == 1) 
        {
            for ( int i = 0 ; i < ticketCount; i++)
            { 
                Ticket ticket = ticketsSold[i];
                if (ticket.getRow().equals(Character.toString(letterInput1)) && ticket.getSeat1()==numberInput1) 
                { 
                    for (int j = i ; j  < ticketCount - 1 ; j++ ) 
                    {
                        ticketsSold[j] = ticketsSold[j + 1] ; // it shift all the tickets after it in list to the left ( if i 1st element remove it Assign the second one to the first one. "1 <-- 2" )
                    }
                    ticketCount -- ; // to decrement the ticket count (if cancel then that ticket count should remove)
                    System.out.println("\n  Ticket removed succssesfully !");
                }           
            }
            seat[charPosition1][numberInput1-1] = 0 ;  // replace  1 to 0 ** reason to use -1 for index 3 means 4th element
            System.out.println("\n*** Seat " + seatPosition1 + " has been canceld. ! *** ") ; 
        }
    }


    public static void find_first_available(int[][] seat) { // create find_first_available method

        int searchValue = 0 ;
        boolean ifseatfound = false ;

        for (int i = 0 ; i < seat.length ; i++ ) // go through row ( i < 5 ) **seat.length** = means length of rows
        {  
            for (int j = 0 ; j < seat[i].length; j++ ) // go through column ( j < 14) **seat[i].length** = means 1st raw length 
            {
                if (seat[i][j] == searchValue) 
                {
                    char rowLetter = (char) (65 + i) ; // convert letter 1 to A 
                    String seatposition = rowLetter + Integer.toString(j+1) ;
                    System.out.println("\nFree seat found at " + seatposition);
                    ifseatfound = true ;
                    break ;

                }
            }
                if (ifseatfound)
                {
                    break ;
                }    
        }

        if (!ifseatfound) {
            System.out.println("Sorry! all seats are already booked...");
        }
    }


    public static void show_Seating_Plan(int[][] seat) { // create show_seating_plan method

        char rowLabel = 'A' ;  // declare raw name

        System.out.println();
        System.out.println("This is the seating plan\n   \nO - avaliable seats\nX - sold seats");
        System.out.println();

        for ( int i = 0 ; i < seat.length; i++) // go through row ( i < 5 ) **seat.length** = means length of rows
        {
            System.out.print(rowLabel + "  ") ; // display row label 
            for (int j = 0; j< seat[i].length ; j++) // go through column ( j < 14) **seat[i].length** = means 1st raw length
            {
                if (seat[i][j] == 1)
                {
                    System.out.print("X "); // display 1 as a X
                }

                else {
                    System.out.print("O "); // display 0 as a O
                }
            }
            System.out.println();
            System.out.println();
            rowLabel ++ ;
        }

    }


    public static void print_ticket_info(int[][] seat ) { // create print_ticket_info method 

        double totalBillAmount = 0 ;
        StringBuilder ticketDetails = new StringBuilder() ; // in this i use stringBuilder for this couse stringBuffer can insert , append , delet or replace characters
        
        for (int i = 0 ; i < ticketCount ; i++ ) 
        {
            Ticket ticket = ticketsSold[i] ;
            System.out.println();
            System.out.println("*** Ticket " + (i + 1) + " ***" );
            System.out.println("Row : " + ticket.getRow());
            System.out.println("Seat No : " + ticket.getSeat1());
            System.out.println("price : $" + ticket.getPrice());
            System.out.println("Passenger Name : " + ticket.getPerson().getName() + " " + ticket.getPerson().getSurname());
            System.out.println("Email : " + ticket.getPerson().getEmail());
           
            totalBillAmount += ticket.getPrice() ;
            ticketDetails.append(ticket.getRow()).append(ticket.getSeat1()).append(" = ").append(ticket.getPrice()).append(" + ") ; // append the raw , seat and price to the stringBuilder ticketdetail variable
        }

        if(ticketDetails.length() > 0)
        {
            ticketDetails.setLength(ticketDetails.length()-2) ; // set currant length to new length to remove last 2 elements (" + " in this last spase and + sign)
        }  

        System.out.println();
        System.out.println("Total bill amount : " + totalBillAmount + " ( " + ticketDetails.toString() + " ) " ); // ticketDetails.toString()  stringBuilder convert to the string
    }


    public static void search_ticket(int[][] seat , Scanner scanner) { // create search_ticket method 

        String seatPosition2 = "";
        boolean input = false ;

        while (!input) {
            try {
                System.out.print("\nEnter the row letter and column number of the seat you want to search (Ex. A5): ");
                seatPosition2 = scanner.next();

                char letterInput = seatPosition2.charAt(0) ;
                int numberInput = Integer.parseInt(seatPosition2.substring(1)) ;

                if ( (letterInput == 'A' && numberInput <= 14) ||
                (letterInput =='D' && numberInput <= 14) ||
                (letterInput == 'B' && numberInput <= 12) ||
                (letterInput == 'C' && numberInput <= 12 ))
                 {

                    input = true ;
                }
                else {
                    System.out.println("Incorrect value ! pleace try again.....");
                }


        }catch(InputMismatchException e ) {
            System.out.println("Incorrect value ! pleace try again.....");
        } catch(NumberFormatException e) {
            System.out.println("Incorrect value ! pleace try again.....");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect value ! pleace try again.....");
        }
    }

        char letterInput2 = seatPosition2.charAt(0) ; // get letter from input (row)
        int numberInput2 = Integer.parseInt(seatPosition2.substring(1)) ; // get number from input (colomn)

        boolean ticketAvaliable = false ;

        for (int i = 0 ; i < ticketCount ; i++) 
        {
            Ticket ticket = ticketsSold[i] ;
            if(ticket.getRow().equals(Character.toString(letterInput2)) && ticket.getSeat1() == numberInput2 ) 
            {
            ticket.ticketinfo(); 
            ticketAvaliable = true ;  
            }
        }
        if(!ticketAvaliable)
        {
            System.out.println("** That seat is already free. Please check and try next time ! **");
        }
    }
    
}

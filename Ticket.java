import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Ticket {

    private String row ;
    private int seat1 ;
    private double price ;
    private Person person ;

    // constructor //https://www.youtube.com/watch?v=JiW5UO35E0A //https://www.youtube.com/watch?v=pHOnYI-qJTA
    public Ticket(String row , int seat1 , double price , Person person ) {
        this.row = row ;
        this.seat1 = seat1;
        this.price = price ;
        this.person = person ;
    }

    // setters 
    public void setRow(String row) { // row setter
        this.row = row ;
    }
    public void setSeat1(int seat1) { // seat setter
        this.seat1 = seat1 ;
    }
    public void setPrice(double price) { // price setter
        this.price = price ;
    }
    public void setPerson(Person person) { // person setter
        this.person = person ;
    }


    // getters
    public String getRow() { // row getter
        return row ;
    }
    public int getSeat1() { // seat getter
        return seat1 ;
    }
    public double getPrice() { // price getter
        return price ;
    }
    public Person getPerson() { // person gettor
        return person ;
    }


    public void ticketinfo(){
        System.out.println("\n** Ticket details **\n");
        System.out.println("Row : " + row );
        System.out.println("Seat : " + seat1);
        System.out.println("Price : " + price);
        System.out.println("\n** Person details **\n");
        person.personinfo() ;
    }
    
    
    public void save (String seatPosition ) {
        try{
        String filename = seatPosition + ".txt" ;    
        File myfile = new File(filename) ;
        
        FileWriter myWriter = new FileWriter(myfile) ;
        myWriter.write("***Ticket infomations ***\n");
        myWriter.write("row : " + row + "\n");
        myWriter.write("Seat : " + seat1 + "\n");
        myWriter.write("Price : " + price + "\n");
        myWriter.write("\n*** Person Infomations *** \n");
        myWriter.write("Name : " + person.getName() + "\n" );
        myWriter.write("Surname : " + person.getSurname() + "\n" );
        myWriter.write("Email : " + person.getEmail() );

        myWriter.close(); } 

        catch(IOException e) {
            System.out.println(" error occurred. " );
            e.printStackTrace();
        }
    }
}
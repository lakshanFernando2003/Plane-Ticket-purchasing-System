import java.io.FileWriter;
import java.io.IOException;

public class Ticket {

    private  String Row;
    private  int Seat;
    private int  Price;
    private final Person person;

    public Ticket(String row , int seat, Person person,int price){
        this.person = person;
        this.Row = row;
        this.Seat = seat;
        this.Price = price;
    }

    public void setRow(String row) {
        Row = row;
    }

    public void setSeat(int seat) {
        Seat = seat;
    }
    public void setPrice(int price) {
        Price = price;
    }
    public String getRow() {
        return Row;
    }
    public int getSeat() {
        return Seat;
    }
    public int getPrice(){
        return Price;
    }

    public void ShowInfo(){
        person.PrintDetails();
        System.out.println("Seat: "+getRow()+getSeat()+"\n"+"Seat Price: €"+getPrice());

    }

    public void Save_ticket_info(String ticket_s){
        try {
                FileWriter saver = new FileWriter(ticket_s+".txt",false);
                saver.write("Customer information of Ticket :"+ticket_s+"\n");
                saver.write("Name: "+person.GetName()+"\n"+"Surname: "+person.GetSurname()+"\n"+"Email: "+person.GetEmail()+"\n"+"Seat: "+getRow()+getSeat()+"\n"+"Seat Price: €"+getPrice());
                saver.close();
        } catch (IOException ex) {
            System.out.println("ERROR : File could not be created");
        }
    }
}


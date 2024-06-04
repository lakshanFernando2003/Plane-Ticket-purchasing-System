public class Person {

    private  String name;
    private  String Surname;
    private  String Email;



    public Person(String name , String surname , String Email){
        this.name = name;
        this.Surname = surname;
        this.Email=Email;
    }

    public void SetName(String name){
        this.name = name;
    }

    public void SetSurname(String surname){
        this.Surname = surname;
    }

    public void SetEmail(String Email){
        this.Email=Email;
    }

    public String GetName(){
        return name;
    }

    public String GetSurname(){
        return Surname;
    }

    public String GetEmail(){
        return Email;
    }

    public void  PrintDetails(){
        System.out.println("Name: "+GetName()+"\n"+"Surname: "+GetSurname()+"\n"+"Email: "+GetEmail());
    }
}

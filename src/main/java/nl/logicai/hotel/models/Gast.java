package nl.logicai.hotel.models;

public class Gast {
    private String name;
    private String email;
    private int telefoonNummer;




    public Gast(String name, String email, int telefoonNummer) {
        this.name = name;
        this.email = email;
        this.telefoonNummer = telefoonNummer;



    }


    public String getName(){
        return name;
    }


    public String getEmail(){
        return email;
    }

   public int getTelefoonNummer(){
        return telefoonNummer;
   }


}

import java.util.ArrayList;

public class Lawyer {
    private String name;
    private String address;
    private ArrayList<String> email;
    private ArrayList<String> phones;

    public Lawyer(String name){
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addEmail(String email) {
        this.email.add(email);
    }

    public void addPhone(String phone) {
        this.phones.add(phone);
    }

    @Override
    public String toString() {
       StringBuilder result = new StringBuilder();
       result.append("Name: ").append(this.name).append("\n");
       result.append("Address: ").append(address);

       return result.toString();
    }

}

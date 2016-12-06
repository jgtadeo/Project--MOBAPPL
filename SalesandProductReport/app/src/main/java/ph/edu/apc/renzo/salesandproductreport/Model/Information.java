package ph.edu.apc.renzo.salesandproductreport.Model;


/**
 * Created by Renzo on 06/11/2016.
 */

public class Information {

    String name, username, password, email;

    public Information() {

    }

    ////////////////////////////////////////////////////////////////////////
    //////////////////////////SIGN UP///////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

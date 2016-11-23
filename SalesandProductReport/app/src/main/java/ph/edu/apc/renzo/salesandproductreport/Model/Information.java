package ph.edu.apc.renzo.salesandproductreport.Model;


/**
 * Created by Renzo on 06/11/2016.
 */

public class Information {

    String name, username, password, email, date;
    int gross, bread, grocery, eload, smart, globe, sun;

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

    /////////////////////////////////////////////////////////////////////
    ///////////////////////////////SALES/////////////////////////////////
    /////////////////////////////////////////////////////////////////////

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getGross() {
        return gross;
    }

    public void setGross(int gross) {
        this.gross = gross;
    }

    public int getBread() {
        return bread;
    }

    public void setBread(int bread) {
        this.bread = bread;
    }

    public int getGrocery() {
        return grocery;
    }

    public void setGrocery(int grocery) {
        this.grocery = grocery;
    }

    public int getEload() {
        return eload;
    }

    public void setEload(int eload) {
        this.eload = eload;
    }

    public int getSmart() {
        return smart;
    }

    public void setSmart(int smart) {
        this.smart = smart;
    }

    public int getGlobe() {
        return globe;
    }

    public void setGlobe(int globe) {
        this.globe = globe;
    }

    public int getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun = sun;
    }
}

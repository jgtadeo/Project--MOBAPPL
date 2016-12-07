package ph.edu.apc.renzo.salesandproductreport.Model;

/**
 * Created by Renzo on 04/12/2016.
 */

public class Sales {

    String date;
    double gross, bread, grocery, eload, smart, globe, sun;

    public Sales(String date, double gross, double grocery, double bread, double eload, double smart, double globe, double sun) {
        this.date = date;
        this.gross = gross;
        this.grocery = grocery;
        this.bread = bread;
        this.eload = eload;
        this.smart = smart;
        this.globe = globe;
        this.sun = sun;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public double getBread() {
        return bread;
    }

    public void setBread(double bread) {
        this.bread = bread;
    }

    public double getGrocery() {
        return grocery;
    }

    public void setGrocery(double grocery) {
        this.grocery = grocery;
    }

    public double getEload() {
        return eload;
    }

    public void setEload(double eload) {
        this.eload = eload;
    }

    public double getSmart() {
        return smart;
    }

    public void setSmart(double smart) {
        this.smart = smart;
    }

    public double getGlobe() {
        return globe;
    }

    public void setGlobe(double globe) {
        this.globe = globe;
    }

    public double getSun() {
        return sun;
    }

    public void setSun(double sun) {
        this.sun = sun;
    }
}

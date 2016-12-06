package ph.edu.apc.renzo.salesandproductreport.Model;

/**
 * Created by Renzo on 04/12/2016.
 */

public class Sales {

    String salesDate;
    double salesGross, salesBread, salesGrocery, salesEload, salesSmart, salesGlobe, salesSun;

    public Sales(String salesDate, Double salesGross, Double salesBread, Double salesGrocery, Double salesSmart, Double salesEload, Double salesGlobe, Double salesSun) {
        this.salesDate = salesDate;
        this.salesGross = Double.parseDouble(String.valueOf(salesGross));
        this.salesBread = Double.parseDouble(String.valueOf(salesBread));
        this.salesGrocery = Double.parseDouble(String.valueOf(salesGrocery));
        this.salesSmart = Double.parseDouble(String.valueOf(salesSmart));
        this.salesEload = Double.parseDouble(String.valueOf(salesEload));
        this.salesGlobe = Double.parseDouble(String.valueOf(salesGlobe));
        this.salesSun = Double.parseDouble(String.valueOf(salesSun));
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    public double getSalesGross() {
        return salesGross;
    }

    public void setSalesGross(float salesGross) {
        this.salesGross = salesGross;
    }

    public double getSalesBread() {
        return salesBread;
    }

    public void setSalesBread(float salesBread) {
        this.salesBread = salesBread;
    }

    public double getSalesGrocery() {
        return salesGrocery;
    }

    public void setSalesGrocery(float salesGrocery) {
        this.salesGrocery = salesGrocery;
    }

    public double getSalesEload() {
        return salesEload;
    }

    public void setSalesEload(int salesEload) {
        this.salesEload = salesEload;
    }

    public double getSalesSmart() {
        return salesSmart;
    }

    public void setSalesSmart(int salesSmart) {
        this.salesSmart = salesSmart;
    }

    public double getSalesGlobe() {
        return salesGlobe;
    }

    public void setSalesGlobe(int salesGlobe) {
        this.salesGlobe = salesGlobe;
    }

    public double getSalesSun() {
        return salesSun;
    }

    public void setSalesSun(int salesSun) {
        this.salesSun = salesSun;
    }
}

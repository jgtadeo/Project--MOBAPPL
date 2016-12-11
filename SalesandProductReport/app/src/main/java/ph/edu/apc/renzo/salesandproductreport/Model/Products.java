package ph.edu.apc.renzo.salesandproductreport.Model;

/**
 * Created by Renzo on 04/12/2016.
 */

public class Products {

    String expiration_date, product_name, category;
    double cost, price, quantity, weight;

    public Products() {

    }

    public Products(String expiration_date, String product_name, String category, double cost, double price, double quantity, double weight) {
        this.expiration_date = expiration_date;
        this.product_name = product_name;
        this.category = category;
        this.cost = cost;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

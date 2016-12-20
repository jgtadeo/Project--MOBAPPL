package ph.edu.apc.renzo.salesandproductreport.Model;

/**
 * Created by Renzo on 15/12/2016.
 */

public class Expenses {

    String date, expense_name;
    double expense_cost;

    public Expenses() {

    }

    public Expenses(String date, String expense_name, double expense_cost) {
        this.date = date;
        this.expense_name = expense_name;
        this.expense_cost = expense_cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExpense_name() {
        return expense_name;
    }

    public void setExpense_name(String expense_name) {
        this.expense_name = expense_name;
    }

    public double getExpense_cost() {
        return expense_cost;
    }

    public void setExpense_cost(double expense_cost) {
        this.expense_cost = expense_cost;
    }
}

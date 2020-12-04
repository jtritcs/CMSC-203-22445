import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Order implements Comparable<Order>, OrderInterface {

    private int number;
    private int time;
    private DAY day;
    private Customer customer;
    private ArrayList<Beverage> beverages = new ArrayList<>();

    public Order(int time, DAY day, Customer customer) {
        this.number = rand(); // can't find documentation on instantiating number
        this.time = time;
        this.day = day;
        this.customer = customer;
    }

    public int getOrderNo() { return number; }

    public void setOrderNo(int number) { this.number = number; }

    public int getOrderTime() { return time; }

    public int setOrderTime() { return time; }

    public DAY getOrderDay() { return day; }

    public void setOrderDay(DAY day) { this.day = day; }

    public Customer getCustomer() { return new Customer(customer); }

    public void setCustomer(Customer customer) { this.customer = customer; }

    public ArrayList<Beverage> getBeverages() { return beverages; }

    public void setBeverages(ArrayList<Beverage> beverages) { this.beverages = beverages; }

    public int getTotalItems() {
        return beverages.size();
    }

    @Override
    public boolean isWeekend() {
        return getOrderDay().equals(DAY.SATURDAY) || getOrderDay().equals(DAY.SUNDAY);
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        return beverages.get(itemNo);
    }

    @Override
    public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    @Override
    public void addNewBeverage(String bevName, SIZE size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    @Override
    public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addPRotien));
    }

    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage beverage : beverages)
            total += beverage.calcPrice();
        return total;
    }

    @Override
    public int findNumOfBeveType(TYPE type) {
        int count = 0;
        for (Beverage beverage : beverages)
            if (beverage.getType() == type) count++;
        return count;
    }

    @Override
    public int compareTo(Order o) {
        return Integer.compare(getOrderNo(), o.getOrderNo());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #").append(getOrderNo()).append(", ")
                .append("Day: ").append(getOrderDay()).append(", ")
                .append("Name: ").append(getCustomer().getName()).append(", ")
                .append("Age: ").append(getCustomer().getAge());
        sb.append("\n");

        for (Beverage beverage : beverages)
            sb.append(beverage).append("\n");

        return sb.toString();
    }

    public static int rand() {
        // Opted for ThreadLocalRandom to fit modern standardization
        return ThreadLocalRandom.current().nextInt(10000, 90000);
    }

}

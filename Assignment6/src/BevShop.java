import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;

public class BevShop implements BevShopInterfce {

    private int numOfAlcohol;
    private Order currentOrder;
    private ArrayList<Order> orders = new ArrayList<>();

    @Override
    public boolean validTime(int time) {
        return time >= getMinHour() && time <= getMaxHour();
    }

    @Override
    public boolean eligibleForMore() {
        return numOfAlcohol < getMaxOrderForAlcohol();
    }

    @Override
    public boolean validAge(int age) {
        return age >= getMinAgeForAlcohol();
    }

    @Override
    public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
        Order order = new Order(time, day, new Customer(customerName, customerAge));
        setCurrentOrder(order);
        orders.add(order);
    }

    @Override
    public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, SIZE size) {
        getCurrentOrder().addNewBeverage(bevName, size);
    }

    @Override
    public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
        getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtien);
    }

    @Override
    public int findOrder(int orderNo) {
        int pos = -1;
        for (int i = 0; i < orders.size(); i++) {
            Order order = getOrderAtIndex(i);
            if (orderNo == order.getOrderNo()) pos = i;
        }
        return pos;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        double price = 0;
        for (Order order : orders) {
            if (orderNo == order.getOrderNo()) {
                price = order.calcOrderTotal();
            }
        }
        return price;
    }

    @Override
    public double totalMonthlySale() {
        double price = 0;
        for (Order order : orders) {
            price += order.calcOrderTotal();
        }
        return price;
    }

    @Override
    public void sortOrders() {
        for (int i = 0; i < orders.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < orders.size(); j++)
                if (getOrderAtIndex(j).compareTo(getOrderAtIndex(minIndex)) < 0) minIndex = j;

            if (minIndex != i) {
                Order heldOrder = getOrderAtIndex(i);
                orders.set(i, getOrderAtIndex(minIndex));
                orders.set(minIndex, heldOrder);
            }
        }

    }

    @Override
    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    @Override
    public String toString() {
        double monthlySale = 0;
        StringBuilder sb = new StringBuilder();
        for (Order order : getOrders()) {
            sb.append(order.toString());
            double orderTotal = order.calcOrderTotal();
            sb.append("Total: ").append(orderTotal);
            sb.append("\n\n");

            monthlySale += orderTotal;
        }

        sb.append("Monthly Sale: $").append(monthlySale);
        return sb.toString();
    }

    public int getNumOfAlcoholDrink() { return numOfAlcohol; }

    public void setNumOfAlcoholDrink(int numOfAlcohol) { this.numOfAlcohol = numOfAlcohol; }

    public Order getCurrentOrder() { return currentOrder; }

    public void setCurrentOrder(Order currentOrder) { this.currentOrder = currentOrder; }

    public ArrayList<Order> getOrders() { return orders; }

    public void setOrders(ArrayList<Order> orders) { this.orders = orders; }

    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    public static int getMinAgeForAlcohol() { return MIN_AGE_FOR_ALCOHOL; }

    public static int getMaxOrderForAlcohol() { return MAX_ORDER_FOR_ALCOHOL; }

    public static int getMinHour() { return MIN_TIME; }

    public static int getMaxHour() { return MAX_TIME; }

    public boolean isMaxFruit(int num) { return num >= MAX_FRUIT; }
}

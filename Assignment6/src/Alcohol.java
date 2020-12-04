public class Alcohol extends Beverage {

    private boolean isOfferedOnWeekend;

    private final static double WEEKEND_PRICE = .60;

    public Alcohol(String name, SIZE size, boolean isOfferedOnWeekend) {
        super(name, TYPE.ALCOHOL, size);
        this.isOfferedOnWeekend = isOfferedOnWeekend;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        if (isOfferedOnWeekend()) sb.append(", offered on the weekend");
        sb.append(", $").append(calcPrice());
        return sb.toString();
    }

    @Override
    double calcPrice() {
        return BASE_PRICE + (SIZE_PRICE * SIZE.getSizeMultiplier(this.getSize()))
                + (isOfferedOnWeekend() ? WEEKEND_PRICE : 0);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o)
                && o instanceof Alcohol
                && ((Alcohol) o).isOfferedOnWeekend() == isOfferedOnWeekend();
    }

    public boolean isOfferedOnWeekend() { return isOfferedOnWeekend; }

    public void setOfferedOnWeekend(boolean offeredOnWeekend) { isOfferedOnWeekend = offeredOnWeekend; }

    public static double getWeekendPrice() {
        return WEEKEND_PRICE;
    }
}

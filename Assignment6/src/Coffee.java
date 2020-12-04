public class Coffee extends Beverage {

    private boolean containsExtraShot;
    private boolean containsExtraSyrup;

    private static final double EXTRA_PRICE = .50;

    public Coffee(String name, SIZE size, boolean containsExtraShot, boolean containsExtraSyrup) {
        super(name, TYPE.COFFEE, size);
        this.containsExtraShot = containsExtraShot;
        this.containsExtraSyrup = containsExtraSyrup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        if (getExtraSyrup()) sb.append(", Extra Shot");
        if (getExtraShot()) sb.append(", Extra Syrup");
        sb.append(", $").append(calcPrice());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o)
                && o instanceof Coffee
                && ((Coffee) o).getExtraSyrup() == getExtraSyrup()
                && ((Coffee) o).getExtraShot() == getExtraShot();
    }

    @Override
    double calcPrice() {
        return BASE_PRICE + (SIZE_PRICE * SIZE.getSizeMultiplier(this.getSize()))
                + (getExtraShot() ? EXTRA_PRICE : 0)
                + (getExtraSyrup() ? EXTRA_PRICE : 0);
    }

    public boolean getExtraShot() { return containsExtraShot; }

    public void setExtraShot(boolean containsExtraShot) { this.containsExtraShot = containsExtraShot; }

    public boolean getExtraSyrup() { return containsExtraSyrup; }

    public void setExtraSyrup(boolean containsExtraSyrup) { this.containsExtraSyrup = containsExtraSyrup; }

    public static double getExtraPrice() { return EXTRA_PRICE; }
}

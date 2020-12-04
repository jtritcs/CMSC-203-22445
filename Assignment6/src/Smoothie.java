public class Smoothie extends Beverage {

    private boolean containsProteinPower;
    private int numberOfFruit;

    private static final double PROTEIN_PRICE = 1.50;
    private static final double FRUIT_PRICE = .50;

    public Smoothie(String name, SIZE size, int numberOfFruit, boolean containsProteinPower) {
        super(name, TYPE.SMOOTHIE, size);
        this.containsProteinPower = containsProteinPower;
        this.numberOfFruit = numberOfFruit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        if (getAddProtien()) sb.append(", Protein Powder");
        if (getNumOfFruits() > 0) sb.append(", ").append(getNumOfFruits()).append(" Fruit");
        sb.append(", $").append(calcPrice());
        return sb.toString();
    }

    @Override
    double calcPrice() {
        return BASE_PRICE + (SIZE_PRICE * SIZE.getSizeMultiplier(this.getSize()))
                + (getAddProtien() ? PROTEIN_PRICE : 0)
                + (getNumOfFruits() * FRUIT_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o)
            && o instanceof Smoothie
            && ((Smoothie) o).getAddProtien() == getAddProtien()
            && ((Smoothie) o).getNumOfFruits() == getNumOfFruits();
    }

    public boolean getAddProtien() {
        return containsProteinPower;
    }

    public void setAddProtein(boolean containsProteinPower) {
        this.containsProteinPower = containsProteinPower;
    }

    public int getNumOfFruits() {
        return numberOfFruit;
    }

    public void setNumOfFruits(int numberOfFruit) {
        this.numberOfFruit = numberOfFruit;
    }

    public static double getProteinPrice() { return PROTEIN_PRICE; }

    public static double getFruitPrice() { return FRUIT_PRICE; }
}

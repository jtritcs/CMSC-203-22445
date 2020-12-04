public abstract class Beverage {
    private String name;
    private TYPE type;
    private SIZE size;
    public static final double BASE_PRICE = 2.0;
    public static final double SIZE_PRICE = 1.0;

    public Beverage(String name, TYPE type, SIZE size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    @Override
    public String toString() {
        return name + ", " + size;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Beverage
                && ((Beverage) o).name.equals(getBevName())
                && ((Beverage) o).type == getType()
                && ((Beverage) o).size == getSize();
    }

    abstract double calcPrice();

    public String getBevName() { return name; }

    public void setBevName(String name) { this.name = name; }

    public TYPE getType() { return type; }

    public void setType(TYPE type) { this.type = type; }

    public SIZE getSize() { return size; }

    public void setSize(SIZE size) { this.size = size; }

    public static double getBasePrice() { return BASE_PRICE; }

    public static double getSizePrice() { return SIZE_PRICE; }
}

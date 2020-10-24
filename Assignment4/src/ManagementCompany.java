/**
 * Manages companies storing plot and property data.
 * @author Justin Tritinger
 */
public class ManagementCompany {
    private final int MAX_PROPERTY = 5;
    private final int MGMT_WIDTH = 10;
    private final int MGMT_DEPTH = 10;

    private String name;
    private String taxID;
    private double mgmFeePer;
    private Plot plot;
    private Property[] properties;

    public int getMGMT_WIDTH() {
        return MGMT_WIDTH;
    }

    public int getMGMT_DEPTH() {
        return MGMT_DEPTH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public double getMgmFeePer() {
        return mgmFeePer;
    }

    public void setMgmFeePer(double mgmFeePer) {
        this.mgmFeePer = mgmFeePer;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public Property[] getProperties() {
        return properties;
    }

    public void setProperties(Property[] properties) {
        this.properties = properties;
    }

    public int getMAX_PROPERTY() { return MAX_PROPERTY; }

    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.plot = new Plot(0, 0, 10, 10);
        this.properties = new Property[getMAX_PROPERTY()];
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(0, 0, 10, 10);
        this.properties = new Property[getMAX_PROPERTY()];
        System.out.println("Leggfd " + getPropertiesSize());
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y , int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[getMAX_PROPERTY()];
    }

    public ManagementCompany(ManagementCompany company) {
        this.name = company.name;
        this.taxID = company.taxID;
        this.mgmFeePer = company.mgmFeePer;
        this.plot = company.plot;
        this.properties = company.getProperties();
    }

    /**
     * Retrieve size of properties array.
     * @return size of properties array.
     */
    private int getPropertiesSize() {
        int i = 0;
        for (Property property : properties) {
            if (property != null) i++;
        }
        return i;
    }

    public int addProperty(Property property) {
        if (getPropertiesSize() == getMAX_PROPERTY()) return -1;
        else if (property == null) return -2;
        else if (!property.getPlot().encompasses(this.plot)) return -3;
        else if (overlapsProperties(property.getPlot())) return -4;
        else {
            int index = getPropertiesSize() > 0 ? properties.length - 1 : 0;
            properties[index] = property;
            return index;
        }
    }

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    private String displayPropertyAtIndex(int i) {
        return properties[i].toString();
    }

    private int maxRentPropertyIndex() {
        double highestRent = 0;
        int highestPosition = 0;
        for (int i = 0; i < getPropertiesSize(); i++) {
            Property property = properties[i];
            if (property != null && property.getRentAmount() > highestRent) {
                highestRent = property.getRentAmount();
                highestPosition = i;
            }
        }
        return highestPosition;
    }

    public double maxRentProp() {
        int index = maxRentPropertyIndex();
        return properties[index].getRentAmount();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of properties for ").append(this.name).append(", taxID: ").append(this.taxID).append("\n");
        for (Property property : properties) {
            if (property == null) continue;
            sb.append("Property Name: ").append(property.getPropertyName()).append("\n");
            sb.append("Located in: ").append(property.getCity()).append("\n");
            sb.append("Belonging to: ").append(property.getOwner()).append("\n");
            sb.append("Rent Amount: ").append(property.getRentAmount()).append("\n");
        }
        sb.append("total management Fee: ").append(String.format("%.2f", getMgmFeePer())).append("\n");
        return sb.toString();
    }

    public double totalRent() {
        double totalRent = 0;
        for (Property property : properties) {
            if (property != null)
                totalRent += property.getRentAmount();
        }
        return totalRent;
    }

    /**
     * Determines whether given plot overlaps any other company properties.
     * @param plot plot to check against.
     * @return true if overlapping another property's plot.
     */
    private boolean overlapsProperties(Plot plot) {
        for (Property property : properties) {
            if (property != null)
                if (plot.overlaps(property.getPlot())) return true;

        }
        return false;
    }


}

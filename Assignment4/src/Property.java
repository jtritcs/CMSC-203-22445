import java.text.DecimalFormat;
/**
 * Manages property data containing plots and their owners/location.
 * @author Justin Tritinger
 */
public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    public Property() {
        propertyName = "";
        city = "";
        owner = "";
        rentAmount = 0;
        plot = new Plot();
    }

    public Property(Property property) {
        this.propertyName = property.getPropertyName();
        this.city = property.getCity();
        this.rentAmount = property.getRentAmount();
        this.owner = property.getOwner();
        this.plot = property.getPlot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();
    }


    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }


    public String getPropertyName() { return propertyName; }

    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public double getRentAmount() { return rentAmount; }

    public void setRentAmount(double rentAmount) { this.rentAmount = rentAmount; }

    public String getOwner() { return owner; }

    public void setOwner(String owner) { this.owner = owner; }

    public Plot getPlot() { return plot; }

    public void setPlot(Plot plot) { this.plot = plot; }

    @Override
    public String toString() {
        String rentFiltered = String.format("%.2f", getRentAmount());
        return "Property Name: " + getPropertyName() + "\n"
                + "Located in " + getCity() + "\n"
                + "Belonging to " + getOwner() + "\n"
                + "Rent Amount: " + rentFiltered;
    }
}

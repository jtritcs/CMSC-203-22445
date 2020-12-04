public class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer(Customer customer) {
        this.name = customer.getName();
        this.age = customer.getAge();
    }

    @Override
    public String toString() {
        return getName() + ", " + getAge();
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }
}

package coffee.shop.model;

public class CoffeeTable {
    private int id;
    private String name;
    private String status;

    @Override
    public String toString() {
        return "CoffeeTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    // Constructors, getters, setters
    public CoffeeTable() {}

    public CoffeeTable(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


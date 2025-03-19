package coffee.shop.model;

public class OrderItem {
    private int idOrder;
    private int idItem;
    private int quantity;
    private long foodPrice;
    private String note;

    // Constructors, getters, setters
    public OrderItem() {}

    public OrderItem(int idOrder, int idItem, int quantity, long foodPrice, String note) {
        this.idOrder = idOrder;
        this.idItem = idItem;
        this.quantity = quantity;
        this.foodPrice = foodPrice;
        this.note = note;
    }

    // Getters and Setters
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(long foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}


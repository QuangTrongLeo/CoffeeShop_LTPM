package coffee.shop.model;

public class Item {
    private int id;
    private String name;
    private String urlImage;
    private long unitPrice;
    private int categoryId;

    // Constructors, getters, setters
    public Item() {}

    public Item(int id, String name, String urlImage, long unitPrice, int categoryId) {
        this.id = id;
        this.name = name;
        this.urlImage = urlImage;
        this.unitPrice = unitPrice;
        this.categoryId = categoryId;
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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}


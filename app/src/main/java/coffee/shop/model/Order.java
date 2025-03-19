package coffee.shop.model;

import java.sql.Timestamp;

public class Order {
    private int id;
    private int idEmployee;
    private int idTable;
    private String status;
    private Timestamp orderDate;
    private Timestamp payDate;
    private long paidAmount;
    private long totalAmount;
    private long changeAmount;
    private int discount;

    // Constructors, getters, setters
    public Order() {}

    public Order(int id, int idEmployee, int idTable, String status, Timestamp orderDate,
                 Timestamp payDate, long paidAmount, long totalAmount, long changeAmount, int discount) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.idTable = idTable;
        this.status = status;
        this.orderDate = orderDate;
        this.payDate = payDate;
        this.paidAmount = paidAmount;
        this.totalAmount = totalAmount;
        this.changeAmount = changeAmount;
        this.discount = discount;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getPayDate() {
        return payDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }

    public long getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(long paidAmount) {
        this.paidAmount = paidAmount;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(long changeAmount) {
        this.changeAmount = changeAmount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}


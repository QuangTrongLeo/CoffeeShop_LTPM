package coffee.shop.model;

import java.sql.Timestamp;

public class User {
    private int id;
    private int roleId;
    private String username;
    private String password;
    private String fullname;
    private String phoneNumber;
    private Timestamp startDate;
    private int salary;

    public User(int id, int salary, Timestamp startDate, String phoneNumber, String fullname, String password, String username, int roleId) {
        this.id = id;
        this.salary = salary;
        this.startDate = startDate;
        this.phoneNumber = phoneNumber;
        this.fullname = fullname;
        this.password = password;
        this.username = username;
        this.roleId = roleId;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", startDate=" + startDate +
                ", salary=" + salary +
                '}';
    }
}

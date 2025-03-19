package coffee.shop.model;

import java.sql.Timestamp;

public class Session {
    private int id;
    private int idEmployee;
    private Timestamp startTime;
    private Timestamp endTime;
    private String message;

    // Constructors, getters, setters
    public Session() {}

    public Session(int id, int idEmployee, Timestamp startTime, Timestamp endTime, String message) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.startTime = startTime;
        this.endTime = endTime;
        this.message = message;
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

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


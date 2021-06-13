package com.example.quickapp.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class MachineData implements Serializable {
    private Double data;
    private Timestamp timestamp;

    public Double getData() {
        return data;
    }

    public void setData(Double data) {
        this.data = data;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}

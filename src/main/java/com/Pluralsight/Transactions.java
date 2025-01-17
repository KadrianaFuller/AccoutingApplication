package com.Pluralsight;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "transactions") // Specify the table name
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate ID
    private Long id;

    @Column(nullable = false) // Field cannot be null
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String vendor;

    @Column(nullable = false)
    private double amount;

    // all fields will be passed through the constructors
    public Transactions(String date, String time, String description, String vendor, Double amount) {

        this.date = LocalDate.parse(date);
        this.time = LocalTime.parse(time);
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // Default constructor (required by Hibernate)
    public Transactions() {
    }

    public Transactions (String line){
        String[] lineArr = line.split("\\|");
        this.date = Utilities.getDate(lineArr[0]);
        this.time = Utilities.getTime(lineArr[1]);
        this.description = lineArr[2];
        this.vendor = lineArr[3];
        this.amount = Utilities.getDoubleValue(lineArr[4]);

    }

    public Transactions(String description, String vendor, double amount) {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // Getters return a value. Setters allows you to set the value
    public String getDate() {
        return date.toString();
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date);
    }

    public String getTime() {
        return time.toString();
    }

    public void setTime(String time) {
        this.time = LocalTime.parse(time);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void add(Transactions actions) {
        return;
    }

    @Override
    public String toString() {
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
    }


}

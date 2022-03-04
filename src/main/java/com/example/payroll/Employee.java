package com.example.payroll;

public class Employee {

    private String name;
    private String first_name;
    private String last_name;
    private String address;

    public Employee(String first_name, String last_name, String address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Need to define getter funtions for Jackson JSON to recognize keys.
    public String getName() {
        return name;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public String printEmployee() {
        return String.format("Name: %s\nAddress: %s", name, address);
    }

    public String printFullName() {
        return String.format("%s %s", first_name, last_name);
    }
}
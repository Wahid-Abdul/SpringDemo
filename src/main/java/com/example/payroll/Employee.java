package com.example.payroll;

public class Employee {

    private String name;
    private String address;

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String printEmployee() {
        return String.format("Name: %s\nAddress: %s", name, address);
    }
}
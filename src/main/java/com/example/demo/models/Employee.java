package com.example.demo.models;

import java.util.Date;

public class Employee {
    private int id;
    private String employeeName;
    private String job;
    private int manager;
    private Date date;
    private int salary;
    private int commision;
    private int departmentnumber;

    public Employee(int id, String employeeName, String job, int manager, Date date, int salary, int commision, int departmentnumber) {
        this.id = id;
        this.employeeName = employeeName;
        this.job=job;
        this.manager= manager;
        this.date=date;
        this.salary=salary;
        this.commision=commision;
        this.departmentnumber=departmentnumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setCommision(int commision) {
        this.commision = commision;
    }

    public void setDepartmentnumber(int departmentnumber) {
        this.departmentnumber = departmentnumber;
    }

    public int getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getJob() {
        return job;
    }

    public int getManager() {
        return manager;
    }

    public Date getDate() {
        return date;
    }

    public int getSalary() {
        return salary;
    }

    public int getCommision() {
        return commision;
    }

    public int getDepartmentnumber() {
        return departmentnumber;
    }

    @Override
    public String toString() {
        return
                "Id =" + id +
                ", EmployeeName = " + employeeName + '\'' +
                ", Manager = " + manager +
                ", Date = " + date +
                ", Salary = " + salary +
                ", Commision = " + commision +
                ", Departmentnumber = " + departmentnumber;
    }
}

package com.example.demo.repositories;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements CRUDInterface <Employee>{
    /*
    public ArrayList<Employee> getEmployeesFromDatabase() {

        DatabaseConnectionManager.getConnection();

        ArrayList<Employee> list = new ArrayList<>();
        {
            try {
                sqlString = "SELECT * FROM `employees`";
                stmt = con.prepareStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(sqlString);

                while (rs.next()) {
                    list.add(new Employee(rs.getString("employee")));

                    System.out.println(list);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return list;

      }


    }*/

    @Override
    public boolean create(Employee entity) {
       Connection con = DatabaseConnectionManager.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO employees VALUES (?,?,?,?,?,?,?,?)");
            pstmt.setInt(1,entity.getId());
            pstmt.setString(2,entity.getEmployeeName());
            pstmt.setString(3,entity.getJob());
            pstmt.setInt(4,entity.getManager());
            pstmt.setDate(5, (Date) entity.getDate());
            pstmt.setInt(6,entity.getSalary());
            pstmt.setInt(7,entity.getCommision());
            pstmt.setInt(8,entity.getDepartmentnumber());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Employee getSingleEntityById(int id) {

        Employee employee = null;

        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees WHERE id =?");
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();

            rs.next();

            int employid = rs.getInt("id");
            String employeeName = rs.getString("employee_name");
            String job = rs.getString("job");
            int manager = rs.getInt("manager");
            Date date = rs.getDate("hiredate");
            int salary = rs.getInt("salary");
            int commision = rs.getInt("commission");
            int departmentnumber = rs.getInt("department_number");

            employee = new Employee(employid, employeeName, job,manager, date, salary, commision, departmentnumber);




        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("something went wrong");
        }


        return employee;
    }

    @Override
    public List<Employee> getAllEntities() {

        ArrayList<Employee> list = new ArrayList<>();
            try {
                Connection conn = DatabaseConnectionManager.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees;");
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String employeeName = rs.getString("employee_name");
                    String job = rs.getString("job");
                    int manager = rs.getInt("manager");
                    Date date = rs.getDate("hiredate");
                    int salary = rs.getInt("salary");
                    int commision = rs.getInt("commission");
                    int departmentnumber = rs.getInt("department_number");



                    Employee emp = new Employee(id, employeeName,job,manager,date, salary,commision,departmentnumber);
                        list.add(emp);


                    //Indsætte i en liste
                }
                System.out.println(list);
            }
            catch(SQLException e){
                e.printStackTrace();
                System.out.println("Something wrong with database");
            }
            return list;
        }

    @Override
    public boolean update(Employee entity) {
        PreparedStatement preStatement;
        try {
            preStatement.setInt(1, entity.getId());
            preStatement.setString(2, entity.getEmployeeName());
            preStatement.setString(3, entity.getJob());
            preStatement.setInt(4, entity.getManager());
            preStatement.setInt(5,entity.getSalary());
            preStatement.setInt(6,entity.getCommision());
            preStatement.setInt(7,entity.getDepartmentnumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}

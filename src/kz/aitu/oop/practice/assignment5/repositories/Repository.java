package kz.aitu.oop.practice.assignment5.repositories;

import kz.aitu.oop.practice.assignment5.data.IDBManager;
import kz.aitu.oop.practice.assignment5.entities.BackendDeveloper.BackendDeveloper;
import kz.aitu.oop.practice.assignment5.entities.FrontendDeveloper.FrontendDeveloper;
import kz.aitu.oop.practice.assignment5.entities.superclass.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Repository implements IRepository {
    private final IDBManager idbManager;

    public Repository(IDBManager idbManager) {
        this.idbManager = idbManager;
    }

    @Override
    public ArrayList<FrontendDeveloper> SearchEmployeeByNameFrontend(String name) {
        Connection connection;

        try {
            connection = idbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE department ='FrontendDeveloper'AND name LIKE '%" + name + "%'"); // sql statement to find the employee's name that works in FrontendDeveloper
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<FrontendDeveloper> frontendDevelopers = new ArrayList<>();
            while (resultSet.next()) {
                FrontendDeveloper frontendDeveloper = new FrontendDeveloper(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getDate("start_date").toLocalDate(),
                        resultSet.getInt("salary"),
                        resultSet.getString("department")
                );
                frontendDevelopers.add(frontendDeveloper);
            }
            return frontendDevelopers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Employee getEmployeeByID(int id) {
        Connection connection;
        try {
            connection = idbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id =" + id); // sql statement to find the employee by ID
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = new Employee();
            if (resultSet.next()) {
                employee = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getDate("start_date").toLocalDate(),
                        resultSet.getInt("salary"),
                        resultSet.getString("department")
                );
            }
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addFrontend(FrontendDeveloper frontendDeveloper) {
        Connection connection;
        try {
            connection = idbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee(name, surname, age,start_date,salary,department) VALUES (?,?,?,?,?,'FrontendDeveloper')"); // sql statement to add  the employee
            preparedStatement.setString(1, frontendDeveloper.getName());
            preparedStatement.setString(2, frontendDeveloper.getSurname());
            preparedStatement.setInt(3, frontendDeveloper.getAge());
            preparedStatement.setDate(4, Date.valueOf(frontendDeveloper.getStart_date()));
            preparedStatement.setInt(5, frontendDeveloper.getSalary());


            preparedStatement.execute();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeEmployeeByID(int id) {
        Connection connection;
        try {
            connection = idbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE * FROM employee where id = " + id); // sql statement to remove employee by ID
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<FrontendDeveloper> ShowAllFrontend() {
        Connection connection;

        try {
            connection = idbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee where department = 'FrontendDeveloper'"); // sql statement to show all employees that work in FrontendDeveloper
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<FrontendDeveloper> frontendDevelopers = new ArrayList<>();
            while (resultSet.next()) {
                FrontendDeveloper frontendDeveloper = new FrontendDeveloper(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getDate("start_date").toLocalDate(),
                        resultSet.getInt("salary"),
                        resultSet.getString("department")
                );
                frontendDevelopers.add(frontendDeveloper);
            }
            return frontendDevelopers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<BackendDeveloper> SearchEmployeeByNameBackend(String name) {
        Connection connection;

        try {
            connection = idbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee where department = 'BackendDeveloper' AND name LIKE '%" + name + "%'");// sql statement to find the employee's name that works in BackendDeveloper
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<BackendDeveloper> backendDevelopers = new ArrayList<>();
            while (resultSet.next()) {
                BackendDeveloper backendDeveloper = new BackendDeveloper(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getDate("start_date").toLocalDate(),
                        resultSet.getInt("salary"),
                        resultSet.getString("department")
                );
                backendDevelopers.add(backendDeveloper);
            }
            return backendDevelopers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean addBackend(BackendDeveloper backendDeveloper) {
        Connection connection;
        try {
            connection = idbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee(name, surname, age,start_date,salary,department) VALUES (?,?,?,?,?,'BackendDeveloper')"); // sql statement to add  the employee
            preparedStatement.setString(1, backendDeveloper.getName());
            preparedStatement.setString(2, backendDeveloper.getSurname());
            preparedStatement.setInt(3, backendDeveloper.getAge());
            preparedStatement.setDate(4, Date.valueOf(backendDeveloper.getStart_date()));
            preparedStatement.setInt(5, backendDeveloper.getSalary());


            preparedStatement.execute();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public ArrayList<BackendDeveloper> ShowAllBackend() {
        Connection connection;

        try {
            connection = idbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee where department = 'BackendDeveloper'"); // sql statement to show all employees that work in BackendDeveloper
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<BackendDeveloper> backendDevelopers = new ArrayList<>();
            while (resultSet.next()) {
                BackendDeveloper backendDeveloper = new BackendDeveloper(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getDate("start_date").toLocalDate(),
                        resultSet.getInt("salary"),
                        resultSet.getString("department")
                );
                backendDevelopers.add(backendDeveloper);
            }
            return backendDevelopers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int ShowSumSalaryBackendDeveloper() {
        Connection connection = null;
        try {
            connection = idbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(" SELECT SUM(salary) FROM employee where department='BackendDeveloper'" );
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){

            }
            return resultSet.getInt("sum");}
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int ShowSumSalaryFrontendDeveloper() {
        Connection connection = null;
        try {
            connection = idbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(" SELECT SUM(salary) FROM employee where department='FrontendDeveloper'" );
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){

            }
            return resultSet.getInt("sum");}
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

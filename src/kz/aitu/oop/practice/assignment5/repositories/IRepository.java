package kz.aitu.oop.practice.assignment5.repositories;

import kz.aitu.oop.practice.assignment5.entities.BackendDeveloper.BackendDeveloper;
import kz.aitu.oop.practice.assignment5.entities.FrontendDeveloper.FrontendDeveloper;
import kz.aitu.oop.practice.assignment5.entities.superclass.Employee;

import java.util.ArrayList;

public interface IRepository {
    public Employee getEmployeeByID(int id);
    public boolean removeEmployeeByID(int id);

    public ArrayList<FrontendDeveloper> SearchEmployeeByNameFrontend(String name);
    public boolean addFrontend(FrontendDeveloper frontendDeveloper);
    public ArrayList<FrontendDeveloper> ShowAllFrontend();

    public ArrayList<BackendDeveloper> SearchEmployeeByNameBackend(String name);
    public boolean addBackend(BackendDeveloper backendDeveloper);
    public ArrayList<BackendDeveloper> ShowAllBackend();
    public int ShowSumSalaryBackendDeveloper();
    public int ShowSumSalaryFrontendDeveloper();
}

package kz.aitu.oop.practice.assignment5.controller;

import kz.aitu.oop.practice.assignment5.entities.BackendDeveloper.BackendDeveloper;
import kz.aitu.oop.practice.assignment5.entities.FrontendDeveloper.FrontendDeveloper;
import kz.aitu.oop.practice.assignment5.repositories.IRepository;

import java.time.LocalDate;

public class Controller {
    private final IRepository iRepository;

    public Controller(IRepository iMedRepository) {
        this.iRepository = iMedRepository;
    }

    public String searchFrontendByName(String name){
        String res = iRepository.SearchEmployeeByNameFrontend(name).toString();

        return  res;
    }
    public String searchBackendByName(String name){
        String res = iRepository.SearchEmployeeByNameBackend(name).toString();

        return  res;
    }

    public String searchEmployeeByID(int id){
        String res = iRepository.getEmployeeByID(id).toString();

        return res;
    }
    public String AddFrontend(String name, String surname, int age, LocalDate start_date,  int salary){

        boolean res = iRepository.addFrontend(new FrontendDeveloper(name, surname, age, start_date,  salary));

        if(res){
            return "Employee was added";
        }else{
            return "Error";
        }

    }
    public String AddBackend(String name, String surname, int age, LocalDate start_date,  int salary){

        boolean res = iRepository.addBackend(new BackendDeveloper(name, surname, age, start_date,  salary));

        if(res){
            return "Employee was added";
        }else{
            return "Error";
        }

    }
    public String RemoveMedByID(int id){

        boolean res = iRepository.removeEmployeeByID(id);

        if(res){
            return "Employee was removed";
        }else{
            return "Error";
        }

    }
    public String ShowAllFrontend(){
        String res = iRepository.ShowAllFrontend().toString();
        return  res;
    }
    public String ShowAllBackend(){
        String res = iRepository.ShowAllBackend().toString();
        return  res;
    }
    public String ShowSumMoneyBackend(){
        String res = String.valueOf(iRepository.ShowSumSalaryBackendDeveloper());
        return res;
    }
    public String ShowSumMoneyFrontend(){
        String res = String.valueOf(iRepository.ShowSumSalaryFrontendDeveloper());
        return res;
    }

}

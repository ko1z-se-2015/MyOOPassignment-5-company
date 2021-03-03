package kz.aitu.oop.practice.assignment5;

import kz.aitu.oop.practice.assignment5.controller.Controller;
import kz.aitu.oop.practice.assignment5.data.DBManager;
import kz.aitu.oop.practice.assignment5.data.IDBManager;
import kz.aitu.oop.practice.assignment5.repositories.IRepository;
import kz.aitu.oop.practice.assignment5.repositories.Repository;

public class Main {

    public static void main(String[] args) {
        IDBManager iManager = new DBManager();
        IRepository iMedRepository = new Repository(iManager);
        Controller controller = new Controller(iMedRepository);
        MyApplication myApplication = new MyApplication(controller);
        myApplication.Start();

    }

}


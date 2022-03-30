

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Casper
 */
public class Officer implements EmployeeInterface {
    private String name;
    private int salary;

    public Officer(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int calculateCost() {
        return getSalary();
    }

    @Override
    public void showWorkers(String str) {
        System.out.println(str + getName());
    }

    @Override
    public EmployeeInterface getEmp(String empName) {
        if(name.contains(empName)){
            return this;
        }
        return null; 
    }


}


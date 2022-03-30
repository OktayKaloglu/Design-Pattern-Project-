

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Casper
 */
import com.sun.source.tree.WhileLoopTree;

import java.sql.Driver;

public class Director implements EmployeeInterface {
    private String name;
    private int salary;
    private ArrayContainer workers; 
    private int totalCost;


    public Director(String name, int salary) {
        this.name = name;
        this.salary = salary;
        workers= new ArrayContainer();
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public String getName() {
        return name;
    }

    public void  add (EmployeeInterface emp){
        workers.add(emp);
    }

    public void remove (EmployeeInterface emp){
        workers.remove(emp);
    }
    
    // Director ve altında çalışanların şirkete maaliyetini recursive bir şekilde hesaplayarak döndürür.
    @Override
    public int calculateCost() {
        totalCost=0;
        Iterator iter=workers.getIterator();

        while (iter.hasNext()){
            EmployeeInterface obj=((EmployeeInterface)iter.next());
            if(obj!=null){
                totalCost+= obj.calculateCost();
            }
        }
        return totalCost+getSalary();
    }
    
    // Aranılan isimdeki çalışanı geri döndürür.
    public EmployeeInterface getEmp(String empNa){
        if(name.contains(empNa)){

            return this;
        }

        Iterator iter= workers.getIterator();

        while (iter.hasNext()){
            EmployeeInterface obj=(EmployeeInterface)iter.next();
            if(obj!=null && (obj.getClass().getName()).contains("Director") ){
                EmployeeInterface state = ((Director)obj).getEmp(empNa);
                if (state!=null){
                    return state;
                }
            }
        }
        return null;
    }
    
    @Override
    public void showWorkers(String str){
        // Recursive bir şekilde başına boşluklar koyarak hiyerarşik bir şekilde çalışanların yazdırılması.
        
        String blanks="    ";
        System.out.println(str+getName());
        Iterator iter=workers.getIterator();
        while (iter.hasNext()){
            EmployeeInterface obj=((EmployeeInterface)iter.next());
            if(obj!=null){
                obj.showWorkers(str+blanks);
            }

        }

    }


    // Director geze geze composite yapıyı oluşturur.
    // Ekleme yaparsa true döndürür, yapamazsa false döndürür.
    public boolean treversal(String direc,EmployeeInterface emp){
        if(name.contains(direc)){ 
            add(emp);
            return true;
        }

        Iterator iter= workers.getIterator();

        while (iter.hasNext()){
            EmployeeInterface obj=(EmployeeInterface)iter.next();
            if(obj!=null && (obj.getClass().getName()).contains("Director") ){
                boolean state = ((Director)obj).treversal(direc, emp);

                if (state == true) {
                    return true;
                }
            }
        }
        return false; 
    }
    
    



}


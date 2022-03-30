

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Casper
 */
public class PersonBuilder {
    public Director directorBuilder(String str,int salary){
        return new Director(str,salary);
    }

    public Officer officerBuilder(String str,int salary){
        return new Officer(str,salary);
    }
}


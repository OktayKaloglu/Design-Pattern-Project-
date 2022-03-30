

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Casper
 */
public interface Iterator {
    public boolean hasNext();
    public Object next();
    public void reset();
    public boolean add(Object obj);
    public boolean remove(Object obj);
}

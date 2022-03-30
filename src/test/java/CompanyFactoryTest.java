/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Casper
 */
public class CompanyFactoryTest {
    
    public CompanyFactoryTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws IOException {

        String[] cls = new String[] {"cmd.exe", "/c", "cls"};
        System.out.println("Cleaning the screen...");
        if (System.getProperty("os.name").startsWith("Window"))
            Runtime.getRuntime().exec(cls);
        else
            try {
                Runtime.getRuntime().exec("clear");
            } catch (IOException ex) {
                Logger.getLogger(CompanyFactory.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

    @AfterAll
    public static void tearDownClass() {

        Runtime r=Runtime.getRuntime();
        System.out.println("Collecting the garbage....");
        r.gc();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    Director Company(){
        CompanyFactory company = new CompanyFactory("girdi.txt");
        return company.getDirector();
    }

    @Test
    public void testCompany(){
        Director dir = Company();
        assertNotNull(dir,"Company is created");

    }
    @Test
    public void testWorkers(){

        Director dir=Company();
        assertEquals(dir.getName(),"Mustafa Turksever","Doğru root");
        assertNotNull(dir.getEmp("Mustafa" ),"Mustafa var");
        assertNotNull(dir.getEmp("Oguz" ),"Oguz var");
        assertNotNull(dir.getEmp("Sedat" ),"Sedat var");
        assertNotNull(dir.getEmp("Ugur"  ),"Ugur var");
        assertNotNull(dir.getEmp("Halil" ),"Halil var");
        assertNotNull(dir.getEmp("Bahar" ),"Bahar var");
        assertNull(dir.getEmp("herhangi" ),"herhangi aslında yok");

    }

    @Test
    public void testCalculateCost(){
        Director dir=Company();
        assertEquals(dir.calculateCost(),24000,"Doğru masraf");
    }
    @Test
    public void testCalculateCost2(){
        Director dir=Company();
        assertEquals(dir.getEmp("Oguz").calculateCost(),4600,"Doğru masraf");
    }
    @Test
    public void testAdd(){
        Director dir=Company();
        dir= (Director) dir.getEmp("Bahar");
        Director emp = new Director("ss",1);
        for (int i=0;i<15;i++){
            dir.add(emp);
        }

        assertEquals(dir.calculateCost(),3515,"Doğru çalışan sayısı");
        //Burada en aşağıda yazdığımız testAdd() testi ile kontrol etmek istediğimiz şey 
        //aslında çalışan sayısı ve bahar directorunun collectionunun limitinden fazla çalışan 
        //eklediğimizde yeni bir collection oluşturup oluşturmadığının kontrolü. 
        //“Bahar” isimli çalışanın altında kimsenin çalışmadığını bildiğimiz için 
        //eklenen employee sayısı kadar 1 birim fiyattan çalışan tanımladığımızda 
        //ve bunu calculateCost ile çağırdığımızda “Bahar” isimli çalışanın maaşı + 
        //çalışanların maaşları toplanmış olacak. Ve bu sayede “Bahar” isimli 
        //çalışanın altında kimse çalışmadığından, maaşı + çalışan sayısından bulmuş olacağız 
        //bu değer de 3500 + 15 ‘ten 3515 olmuş olacak. 15 kişi hatasız eklenmiştir.
    }
    
}

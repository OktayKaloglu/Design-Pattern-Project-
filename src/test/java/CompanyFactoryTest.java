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
        assertEquals(dir.getName(),"Mustafa Turksever","Do??ru root");
        assertNotNull(dir.getEmp("Mustafa" ),"Mustafa var");
        assertNotNull(dir.getEmp("Oguz" ),"Oguz var");
        assertNotNull(dir.getEmp("Sedat" ),"Sedat var");
        assertNotNull(dir.getEmp("Ugur"  ),"Ugur var");
        assertNotNull(dir.getEmp("Halil" ),"Halil var");
        assertNotNull(dir.getEmp("Bahar" ),"Bahar var");
        assertNull(dir.getEmp("herhangi" ),"herhangi asl??nda yok");

    }

    @Test
    public void testCalculateCost(){
        Director dir=Company();
        assertEquals(dir.calculateCost(),24000,"Do??ru masraf");
    }
    @Test
    public void testCalculateCost2(){
        Director dir=Company();
        assertEquals(dir.getEmp("Oguz").calculateCost(),4600,"Do??ru masraf");
    }
    @Test
    public void testAdd(){
        Director dir=Company();
        dir= (Director) dir.getEmp("Bahar");
        Director emp = new Director("ss",1);
        for (int i=0;i<15;i++){
            dir.add(emp);
        }

        assertEquals(dir.calculateCost(),3515,"Do??ru ??al????an say??s??");
        //Burada en a??a????da yazd??????m??z testAdd() testi ile kontrol etmek istedi??imiz ??ey 
        //asl??nda ??al????an say??s?? ve bahar directorunun collectionunun limitinden fazla ??al????an 
        //ekledi??imizde yeni bir collection olu??turup olu??turmad??????n??n kontrol??. 
        //???Bahar??? isimli ??al????an??n alt??nda kimsenin ??al????mad??????n?? bildi??imiz i??in 
        //eklenen employee say??s?? kadar 1 birim fiyattan ??al????an tan??mlad??????m??zda 
        //ve bunu calculateCost ile ??a????rd??????m??zda ???Bahar??? isimli ??al????an??n maa???? + 
        //??al????anlar??n maa??lar?? toplanm???? olacak. Ve bu sayede ???Bahar??? isimli 
        //??al????an??n alt??nda kimse ??al????mad??????ndan, maa???? + ??al????an say??s??ndan bulmu?? olaca????z 
        //bu de??er de 3500 + 15 ???ten 3515 olmu?? olacak. 15 ki??i hatas??z eklenmi??tir.
    }
    
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Casper
 */

public class Client {

    public static void main(String[] args){
        // Company oluşturmak için gereken dosyanın konumu veya proje içindeki adı verilir.
        CompanyFactory company=new CompanyFactory("girdi.txt");
        
        // Eğer dosya bulunursa ve dosya nesne üretebilecek bilgilere sahipse;
        if (company.getDirector() != null){
            // Root'un şirkete maliyeti ve çalışanların hiyerarşik yapıda yazdırılması
            System.out.println(company.getDirector().calculateCost());
            company.getDirector().showWorkers("");
            
            // Oğuz'un şirkete maliyeti ve çalışanların hiyerarşik yapıda yazdırılması
            Director oguz = (Director) company.getDirector().getEmp("Oguz");
            System.out.println(oguz.calculateCost());
            oguz.showWorkers("");
        }
        
        // Dosya okunamadı veya gerekli bilgiye sahip değil.
        else{
            System.out.println("Girilen dosya bulunamadı!");
        }
        
    }

}


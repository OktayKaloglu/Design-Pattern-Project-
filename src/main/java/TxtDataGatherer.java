

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Casper
 */
import java.io.*;
import java.util.Scanner;

public class TxtDataGatherer implements DataGatherer {
    private FileInputStream file;
    private Scanner fileLnScanner;
    
    public TxtDataGatherer(String directory) {

        // dosya işlemlerindeki hatayı yakalar
        // hata yoksa eğer dosyayı açar
        try {
            this.file=new FileInputStream(directory);
            this.fileLnScanner= new Scanner(file);

        } catch (FileNotFoundException e) {
            System.out.println(e.toString()+" hatalı dosya adı tekrar deneyiniz");
            this.fileLnScanner = null;
        }

    }

    public Scanner getScanner(){
        return fileLnScanner;
    }

    @Override
    public String getData() {
        // dosyadan line by line dataları çeker
        if (fileLnScanner.hasNextLine()){
            String line = fileLnScanner.nextLine();
            return line;
        }

        return "-1";
    }

    public void close(){
        // dosyayı kapatır
        fileLnScanner.close();
    }
}




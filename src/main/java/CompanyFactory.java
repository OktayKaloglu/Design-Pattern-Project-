

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Casper
 */
public class CompanyFactory {
    private Director root;

    public CompanyFactory(String directory) {
        // Burada file bize txt olarak verildiği için TxtAdapter'ü kullandık
        // Eğer başka bir uzantı ile veriliyor olsaydı gatherer'ı uygun 
        // farklı bir adapterü if else ile atardık.
        TxtDataGatherer gatherer=new TxtDataGatherer(directory);
        if (gatherer.getScanner() != null){
            createCompany(gatherer);
        }
        else{
            System.out.println("Hatalı dosya adı!");
        }
    }
    public Director getDirector(){
        return root;
    }

    public void createCompany(DataGatherer gatherer){
        PersonBuilder hr=new PersonBuilder();
        InList[] waitingQueue =new InList[100]; //InList dizisi director,çalışan olarak waitingQueue'yu oluşturmaktadır.
        int index=0;
        String line=gatherer.getData();
        while (line!="-1"){ // line by line çalışanların üretilmesi 
            // ve waiting queue'ya eklenmesi 
            // burada waiting queue kullanmamızı sebebi çalışanlar 
            // composite yapının destekleyeceği düzenli sırada verilmemiş olabilir
            // bu yüzden onları bir waiting queue'ya aktarıyoruz
            String[] strArr=line.split(",");
            if(strArr[0].equalsIgnoreCase("d")){
                waitingQueue[index++]=  new InList(strArr[3],hr.directorBuilder(strArr[1],Integer.parseInt(strArr[2])));
            } else if (strArr[0].equalsIgnoreCase("m")) {
                waitingQueue[index++]=  new InList(strArr[3],hr.officerBuilder(strArr[1],Integer.parseInt(strArr[2])));
            }else {
                System.out.println("Tanımlanamayan tanımlayıcı karakter(d/m değil)");
            }
            line=gatherer.getData();
            if (index==waitingQueue.length){ // Waiting queue dolmuş olabilir
                // length'i 100 artırıp farklı bir diziye deep copy liyoruz.
                InList[] temp = new InList[waitingQueue.length+100];
                for (int j = 0;j<waitingQueue.length;j++){
                    temp[j]=waitingQueue[j];
                }
                waitingQueue=temp;

            }
        }
        
        root=(Director) waitingQueue[0].emp;
        boolean isAdded=true;
        // isAdded bizim eklenip eklemediğimizi kontrol ediyor?
        while (isAdded){ // isAdded false kalana kadar liste dönülecek.
            isAdded=false; 
            // for döngüsü içerisinde herhangi bir ekleme yapıldıysa
            // listenin tekrardan baştan dönülmesi gerekmekte çünkü
            // eklenen kişi bir director olabilir ve
            // onun çalışanları hala listede bekliyor olabilir.
            for(int i =1 ;i<waitingQueue.length;i++){
                if(waitingQueue[i]!=null){
                    isAdded=root.treversal(waitingQueue[i].director,waitingQueue[i].emp);
                    if (isAdded==true){ // eklenme olduysa artık waitingQueue'dan çıkarılabilir.
                        waitingQueue[i]=null;
                    }
                }
            }
        }
        
        // WaitingQueue'da kalan eklenememiş çalışanları listelemek için kullanıyoruz. 
        for (int k = 1 ;k<waitingQueue.length;k++){
            if(waitingQueue[k]!=null){
                System.out.println("Eklenemeyenler : "+waitingQueue[k].emp.getName()+"\n");
            }
        }



    }
    // waitingQueue'da oluşturulmuş çalışanların nereye ekleneceğini ve
    // çalışanları aynı anda tutmak için oluşturduğumuz class

    class InList{
        public String director;
        public EmployeeInterface emp;

        public InList(String director, EmployeeInterface emp) {
            this.director = director;
            this.emp = emp;
        }
    }
}


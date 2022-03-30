

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Casper
 */


public class ArrayContainer implements Container {

    public Object[] items = new Object[10];

    @Override
    public Iterator getIterator() {
        return new ArrayIterator(items);
    }

    @Override
    public void add(Object obj) {
       Iterator iter = getIterator();
        // Eğer iter.add false döndürürse listede boş alan yok demek ve daha büyük bir listeye ihtiyaç duyuyoruz demek.
        // Eğer iter.add true döndürürse ekleme işlemi başarılı bir şekilde gerçekleştirildi demek.
        // Deep copy yapıp yenisini ekliyoruz.
        if(iter.add(obj)==false) {
            iter.reset();
            Object[] tempArray=new Object[items.length+10];
            int i=0;
            while (iter.hasNext()) {
                tempArray[i]=(iter.next());
                i++;
            }
            this.items=tempArray;
            add(obj);
       }

    }

    @Override
    public boolean remove(Object obj) {
        Iterator iter = getIterator();
        if(iter.remove(obj)){
            return true;
        }
        return false;
    }



}

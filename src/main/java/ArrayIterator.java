

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Casper
 */
public class ArrayIterator implements Iterator{
    private Object[] items;
    private int index;
    public ArrayIterator(Object[] items){
        this.items=items;
    }

    @Override
    public boolean hasNext() {
        // indexin listenin sonunda olup olmadığını kontrol eder yani bir sonraki var mı yok mu.
        if(index < items.length){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        // eğer index listenin içinde bir değeri gösteriyorsa listede indexin gösterdiği objeyi döndürür, 
        //  ve döndürdükten sonra kendisini bir artırır ve bir sonraki itemı gösterir. 
        if(this.hasNext()){
            return items[index++];
        }
        return null;
    }

    @Override
    public void reset() { // iter'i resetlemek için kullanılır.
        index=0;
    }
    
    // dizideki ilk null olan indexe ekleme yapılır.
    @Override
    public boolean add(Object obj) {
        reset();
        while (hasNext()){
            if(next()==null){
                items[index-1]=obj;
                return true;
            }
        }
        return false;
    }
    
    // dizide ilk karşılaşılan aranan objeyi diziden kaldırır.
    @Override
    public boolean remove(Object obj) {
        reset();
        while (hasNext()){
            if(next()==obj){
                items[index]=null;
                return true;
            }
        }
        return false;


    }


}


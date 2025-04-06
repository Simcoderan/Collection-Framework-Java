package Map.Hashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

 private int capacity;

public LRUCache(int capacity){
    super(capacity,0.75f,true);
    this.capacity=capacity;
}
@Override
protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
    return size()>capacity;

}



    public static void main(String[] args) {
        //3 entries
        //4th enters..then the least recent get removed and 4th get added
        LRUCache<String,Integer> studentMap= new LRUCache<>(3);
        studentMap.put("Bob",99);
        studentMap.put("Ram",89 );
        studentMap.put("Shreya",50 );
        studentMap.put("Rohit",78 );
        System.out.println(studentMap);

    }
    
}

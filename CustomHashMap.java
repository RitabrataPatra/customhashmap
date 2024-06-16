import java.util.ArrayList;
import java.util.List;

public class CustomHashMap<K ,V>{
    List<OurHashMap<K ,V>> bucketArray;
    int capacity;
    int size;
     public CustomHashMap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.bucketArray = new ArrayList<>();


        for(int i =0 ; i< capacity ; i++){
            bucketArray.add(null);
        }
     }

     static class OurHashMap<K ,V>{
        K key;
        V value;
        OurHashMap<K ,V> next;//for handling collision

        public OurHashMap(K key , V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
     }

     //hash function that will generate hashcode and index
     public int gethash(K key){
        int hashcode = key.hashCode();
        return hashcode % capacity;
     }
     //fucntion to put th keyvalue pair in this index
     public void put(K key , V value){
        int index = gethash(key);
        OurHashMap<K ,V> head = bucketArray.get(index);
        while (head!=null) {
            if (head.key.equals(key)) {
                head.value=value;
                return;
            }
            else{
                head=head.next;
            }
        }
        //new entry
        head = bucketArray.get(index);
        OurHashMap<K ,V> newOurHashMap = new OurHashMap<>(key, value);
        newOurHashMap.next= head;
        bucketArray.set(index, newOurHashMap);
        size++;
     }  
     public V get(K key){
        int index= gethash(key);
        OurHashMap<K ,V> head = bucketArray.get(index);

        while (head!=null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            else{
                head = head.next;
            }
        }
        return null;
     }

     public void remove(K key){
        int index = gethash(key);
        OurHashMap<K ,V> head= bucketArray.get(index);
        OurHashMap<K ,V> prev =null;
        while (head !=null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    bucketArray.set(index, head.next);
                }
                else{
                    prev.next = head.next;
                }
                size--;
                return;
            }
            prev=head;
            head=head.next;
        }
        
     }

     public int size(){
        return size;
     }
     public boolean isEntry(){ //to check if hashmap is empty or not
        return size==0;
     }

     public void printHashmap(){
        for(OurHashMap<K ,V> entry : bucketArray){
            OurHashMap<K ,V> current = entry;
            while (current!=null) {
                System.out.println("Key: " + current.key + ", Value: " + current.value);
                current=current.next;
            }
        }
     }

     public static void main(String[] args) {
        CustomHashMap<String, Integer> customMap = new CustomHashMap<>(10);
        
        customMap.put("Sigma", 24);
        customMap.put("Beta", 12);
        customMap.put("Alpha", 10);

        System.out.println(customMap.get("Beta")); // Output: 2
        
        customMap.remove("Alpha");
        
        System.out.println(customMap.get("Alpha")); // Output: null
        
        customMap.printHashmap();
    }
}

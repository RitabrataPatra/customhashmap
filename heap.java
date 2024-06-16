
import java.util.PriorityQueue;
public class heap {
    public static void main(String[] args) {
        //creating a new Priority Queue object
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        //lets add numbers
        minheap.add(3);
        minheap.add(1);
        minheap.add(2);

        System.out.println(minheap.poll()); //output 1 since 1 is the smallest here

        System.out.println(minheap.peek()); // after 1 is removed 2 is th smallest
        System.out.println(minheap);
    }
}

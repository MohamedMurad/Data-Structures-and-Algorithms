package eg.edu.alexu.csd.datastructure.queue.cs72;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * @author murad.
 *this is an implementaion using array.
 */
public class MyQueue implements IQueue, IArrayBased {

    /**
     * this is an array of queue.
     */
    private Object[] q;
    /**
     * n is the size of the queue.
     */
    private int n;

    /**
     * @param m for constructor.
     */
    public MyQueue(final int m) {
        n = m + 1;
        q = new Object[n];
    }

    /**
     * front and rear.
     */
    private int f = 0, r = 0;


    @Override
    public void enqueue(final Object item) {
        // TODO Auto-generated method stub
        if (size() == n - 1) {
            throw new RuntimeException();
        }
        q[r] = item;
        r = (r + 1) % n;
    }

    @Override
    public Object dequeue() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new RuntimeException();
        }
        Object temp = q[f];
        q[f] = null;
        f = (f + 1) % n;
        return temp;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        if (f == r) {
            return true;
        }
        return false;
    }

    @Override
    public final int size() {
        // TODO Auto-generated method stub
        return (n - f + r) % n;
    }

    // public static void main(String[] args) {
    // MyQueue mQ = new MyQueue(5);
    // mQ.enqueue(1);
    // mQ.enqueue(2);
    // mQ.enqueue(3);
    // mQ.enqueue(4);
    // System.out.println(mQ.dequeue());
    // System.out.println(mQ.dequeue());
    // System.out.println(mQ.dequeue());
    // System.out.println(mQ.dequeue());
    // mQ.enqueue(1);
    // mQ.enqueue(2);
    // mQ.enqueue(3);
    // System.out.println(mQ.dequeue());
    // System.out.println(mQ.dequeue());
    // mQ.enqueue(4);
    // mQ.enqueue(5);
    // System.out.println(mQ.dequeue());
    // System.out.println(mQ.dequeue());
    // System.out.println(mQ.size());
    // System.out.println(mQ.isEmpty());
    // System.out.println(mQ.size());
    // System.out.println(mQ.size());
    //
    // }

}

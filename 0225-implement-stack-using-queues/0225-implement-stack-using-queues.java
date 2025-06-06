import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {
    }
    
    public void push(int x) {
        q2.offer(x); // Push to q2

        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        return q1.isEmpty() ? -1 : q1.poll(); // Remove and return top
    }
    
    public int top() {
        return q1.isEmpty() ? -1 : q1.peek(); // Return top without removing
    }
    
    public boolean empty() {
        return q1.isEmpty(); // Return true if empty
    }
}
import java.util.Stack;

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
    }
    
    // Push element to the back of queue
    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    
    // Removes the element from in front of queue and returns it
    public int pop() {
        if (s1.isEmpty()) return -1;
        return s1.pop();
    }
    
    // Get the front element
    public int peek() {
        if (s1.isEmpty()) return -1;
        return s1.peek();
    }
    
    // Return whether the queue is empty
    public boolean empty() {
        return s1.isEmpty();
    }
}
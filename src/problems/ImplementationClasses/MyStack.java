package problems.ImplementationClasses;

import java.util.LinkedList;
import java.util.Queue;

// Implementing stack using queue
public class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        int s = q.size();
        q.add(x);

        // adding all the element before x
        for (int i = 0; i < s; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
       return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        if(q.isEmpty()){
            return true;
        }

        return false;
    }
}

class MyStack {
     private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
         q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
         q1.offer(x);
        
    }
    
    public int pop() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int topElement = q1.poll();
        swapQueues();
        return topElement;
    }
    
    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int topElement = q1.peek();
        q2.offer(q1.poll());
        swapQueues();
        return topElement;
        
    }
    
    public boolean empty() {
        return q1.isEmpty();
        
    }
    private void swapQueues() {
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
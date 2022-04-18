public class main0716 {
    public static void main(String[] args) {
        MaxStack stk = new MaxStack();
        stk.push(5);   // [5] the top of the stack and the maximum number is 5.
        stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
        stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
        stk.top();     // return 5, [5, 1, 5] the stack did not change.
        stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
        stk.top();     // return 1, [5, 1] the stack did not change.
        stk.peekMax(); // return 5, [5, 1] the stack did not change.
        stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
        stk.top();     // return 5, [5] the stack did not change.        
    }

}


class MaxStack {
    Deque<Integer> stack;
    Deque<Integer> maxStack;

    public MaxStack() {
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peekLast();
        maxStack.offerLast(max > x ? max : x);
        stack.offerLast(x);
    }

    public int pop() {
        maxStack.pollLast();
        return stack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int peekMax() {
        return maxStack.peekLast();
    }

    public int popMax() {
        int max = peekMax();
        Deque<Integer> buffer = new ArrayDeque();
        while (top() != max) buffer.offerLast(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pollLast());
        return max;
    }
}
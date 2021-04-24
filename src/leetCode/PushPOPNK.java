package leetCode;

import java.util.Stack;

public class PushPOPNK {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }

    public static void main(String[] args) {
        PushPOPNK pushPOPNK = new PushPOPNK();
        pushPOPNK.push(1);
        pushPOPNK.push(2);
        pushPOPNK.push(3);
        pushPOPNK.pop();
        pushPOPNK.pop();
        pushPOPNK.push(4);
        pushPOPNK.pop();
        pushPOPNK.push(5);
        pushPOPNK.pop();
        pushPOPNK.pop();
    }
}

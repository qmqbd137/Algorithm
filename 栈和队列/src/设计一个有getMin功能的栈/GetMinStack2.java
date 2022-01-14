package 设计一个有getMin功能的栈;

import java.util.Stack;

/**
 * @author QMQ_bd137
 * @create_time is 2021-05-21 16:36
 */
public class GetMinStack2 {
    private Stack<Integer> values;
    private Stack<Integer> helper;

    public GetMinStack2() {
        this.values = new Stack<Integer>();
        this.helper = new Stack<Integer>();
    }
    public void push(int newvalue){
        if (this.helper.isEmpty() || newvalue < this.helper.peek()){
            this.helper.push(newvalue);
        }
        else if(newvalue > this.helper.peek()){
            int newMin = this.helper.peek();
            this.helper.push(newMin);
        }
        this.values.push(newvalue);
    }

    public int pop(){
        if (this.values.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        this.helper.pop();
        return this.values.pop();
    }
    public int getMin(){
        if (this.helper.isEmpty()){
        throw new RuntimeException("Your stack is empty!");
        }
        return this.helper.peek();
    }
}

package 设计一个有getMin功能的栈;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author QMQ_bd137
 * @create_time is 2021-05-21 15:51
 */
public class GetMinStack1 {
    private Stack<Integer> values;
    private Stack<Integer> helpers;

    public GetMinStack1(){
        values = new Stack<Integer>();
        helpers = new Stack<Integer>();
    }
    public int getMin(){
        if (this.helpers.isEmpty()){
            throw new RuntimeException("Min stack is empty");
        }
        return this.helpers.peek();
    }
   public int Pop(){
        if (this.values.isEmpty()){
            throw new RuntimeException("value Stack is empty");
        }
        int  cur = this.values.pop();
        if (cur == this.getMin()){
            this.helpers.pop();
        }
        return cur;
   }
   public void push(int value){
        if (this.helpers.isEmpty() || value < this.getMin()){
            this.helpers.push(value);
        }
        this.values.push(value);
        }
}


package 栈和队列.单调栈结构;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author QMQ_bd137
 * @create_time is 2022-01-12 17:10
 */
public class getNearLess {
    public static int[][] solution(int[] nums){
        Stack<List<Integer>> stack = new Stack<>();
        int[][] res = new int[nums.length][2];
        for (int i = 0; i < nums.length ; i++) {
            while (!stack.isEmpty() && nums[stack.peek().get(0)]>nums[i]){
                List<Integer> popIndexList = stack.pop();
                int leftLessIndex = stack.isEmpty()?-1 : stack.peek().get(stack.peek().size()-1);
                for (int popIndex: popIndexList) {
                    res[popIndex][0] = leftLessIndex;
                    res[popIndex][1] = i;
                }
            }
            if(!stack.isEmpty() && nums[stack.peek().get(0)] == nums[i]){
                stack.peek().add(i);
            }else{
                ArrayList<Integer> newlist= new ArrayList<>() ;
                newlist.add(Integer.valueOf(i));
                stack.push(newlist);
            }
        }
        while (!stack.isEmpty()){
            List<Integer> popIndexList = stack.pop();
            for (int popIndex: popIndexList) {
                res[popIndex][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                res[popIndex][1] = -1;
            }
        }
        return res;
    }
}

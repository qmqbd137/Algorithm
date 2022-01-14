package 单调栈结构;

import java.util.Stack;

/**
 * @author QMQ_bd137
 * @create_time is 2022-01-12 15:50
 */
public class getNearLessNoRepeat {
    public static int[][] soulution(int[] nums){
        if(nums==null){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        int[][] res = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                int popIndex = stack.pop();
                res[popIndex][0] = stack.isEmpty()?-1:stack.peek();
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int popIndex = stack.pop();
            res[popIndex][0] = stack.isEmpty()?-1:stack.peek();
            res[popIndex][1] = -1;
        }
        return res;
    }
}

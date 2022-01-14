package 求最大子矩阵的大小;

import 单调栈结构.getNearLess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author QMQ_bd137
 * @create_time is 2022-01-14 15:49
 */
public class getMaxSubMartixValue {
    public static int solution(int[][] nums){
        if (nums == null){
            return 0;
        }
        int row = nums.length;
        int col = nums[0].length;
        int maxSubMartixValue = 0;
        int[] height = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int tempH = i > 0 ? (nums[i][j] == 1 ? height[j] + 1 : 0) : nums[i][j];
                height[j] = tempH;
            }
            maxSubMartixValue = Math.max(getOneRowMaxSubMartixValue(height),maxSubMartixValue);
        }
        return maxSubMartixValue;
    }
    private static int getOneRowMaxSubMartixValue(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int maxMartixS = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1: stack.peek();
                maxMartixS = Math.max(maxMartixS,nums[j] *(i-k-1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int curIndex = stack.pop();
            int k =stack.isEmpty()? -1 : stack.peek();
            maxMartixS = Math.max(maxMartixS,(n-k -1) * nums[curIndex]);
        }
        return maxMartixS;
    }
}

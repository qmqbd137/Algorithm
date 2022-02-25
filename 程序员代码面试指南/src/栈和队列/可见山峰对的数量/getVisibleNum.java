package 栈和队列.可见山峰对的数量;

import java.util.Stack;

/**
 * @author QMQ_bd137
 * @create_time is 2022-02-22 16:32
 */
public class getVisibleNum {
    public static int soulution(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        Stack<Recoder> stack = new Stack<>();
        int maxIndex = 0;
        //从最大的山峰开始寻找，这是由于最后清算的时候都可以满足“小找大”的原则
        for (int i = 0; i < arr.length; i++) {
           maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        stack.push(new Recoder(arr[maxIndex]));
        //因为使用数组模拟环形山，因此需要获取下一个位置
        int index = nextIndex(maxIndex,arr.length);
        //可见山峰对的数量
        int res = 0;
        while (index != maxIndex){

            while (arr[index] > stack.peek().getValue()){
                Recoder temp = stack.pop();
                int k = temp.getTimes();
                res += 2*k + getInternalSum(k);
            }

            if (stack.peek().getValue() == arr[index]){
                Recoder temp = stack.peek();
                stack.peek().setTimes(temp.getTimes()+1);
            }else {
                stack.push(new Recoder(arr[index]));
            }
            index = nextIndex(index,arr.length);
        }
        while (stack.size() > 2){
            int k = stack.pop().getTimes();
            res += 2*k + getInternalSum(k);
        }
        if(stack.size() == 2){
            int k = stack.pop().getTimes();
            res += stack.peek().getTimes() > 1 ? (2*k + getInternalSum(k)) : (k + getInternalSum(k));
        }
        int k = stack.pop().getTimes();
        res += getInternalSum(k);
        return res;
    }
    private static int getInternalSum(int k){
        return k == 1 ? 0 : (k*(k-1)/2);
    }
//    获取下一个位置
    private static int nextIndex(int startindex,int size){
        return startindex < size -1 ? startindex + 1 : 0;
    }
}

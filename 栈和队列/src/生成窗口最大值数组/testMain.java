package 生成窗口最大值数组;

/**
 * @author QMQ_bd137
 * @create_time is 2022-01-12 14:29
 */
public class testMain {
    public static void main(String[] args) {
        int[] nums = {4,3,5,4,3,3,6,7};
        int kernel = 2;
        int[] res = new getKernelMaxValue().soulution(nums, kernel);
        for(int i:res){
            System.out.println(i);
        }

    }
}

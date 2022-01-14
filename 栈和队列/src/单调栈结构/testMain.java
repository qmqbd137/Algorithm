package 单调栈结构;

/**
 * @author QMQ_bd137
 * @create_time is 2022-01-12 16:03
 */
public class testMain {
    public static void main(String[] args) {
//        int[] nums = {3,4,1,5,6,2,7};
        int[] nums = {3,1,3,4,3,5,3,2,2};
//        int[][] res = getNearLessNoRepeat.soulution(nums);
        int[][] res = getNearLess.solution(nums);
        for(int[] i:res){
            for (int j :i){
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}

package 链表问题.回文链表;

import 链表问题.BaseNode;

/**
 * @author QMQ_bd137
 * @create_time is 2022-04-18 15:12
 */
public class testMain {
    public static void main(String[] args) {
        BaseNode head = new BaseNode(1);
        head.add(1);
        head.add(2);
        head.add(2);
        head.add(1);
        head.add(1);

        System.out.println(isPalindrome.soulution3(head));
    }
}

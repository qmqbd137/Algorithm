package 链表问题.单向链表根据某值划分;

import 链表问题.BaseNode;

/**
 * @author QMQ_bd137
 * @create_time is 2022-05-06 16:57
 */
public class testMain {
    public static void main(String[] args) {
        BaseNode head = new BaseNode(4);
        head.add(5);
        head.add(1);
        head.add(7);
        head.add(9);
        head.add(3);
        BaseNode res = listPartition.solution2(head,10);
        res.printNode();
    }
}

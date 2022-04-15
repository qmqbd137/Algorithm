package 链表问题.反转部分单向链表;

import 链表问题.BaseNode;

/**
 * @author QMQ_bd137
 * @create_time is 2022-04-15 9:16
 */
public class testMain {
    public static void main(String[] args) {
        BaseNode head = new BaseNode(4);
        head.add(5);
        head.add(6);
        head.add(7);
        head.add(8);
        BaseNode node1 = ReversePartNode.solution(head,2,4);
        node1.printNode();
    }
}


package 链表问题.两个单链表生成相加链表;

import 链表问题.BaseNode;

/**
 * @author QMQ_bd137
 * @create_time is 2022-05-13 14:37
 */
public class testMain {
    public static void main(String[] args) {
        BaseNode l1 = new BaseNode(3);
        l1.add(6);
        l1.add(0);
        BaseNode l2 = new BaseNode(6);
        l2.add(3);
        l2.add(1);
        addLists.solution2(l1,l2).printNode();
    }
}

package 链表问题.环形单链表的约瑟夫问题;

import 链表问题.BaseNode;
import 链表问题.Node;

/**
 * @author QMQ_bd137
 * @create_time is 2022-04-15 11:18
 */
public class testMain {
    public static void main(String[] args) {
        BaseNode head = new BaseNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        head.add(6);
        head.add(7);
        head.add(8);
        BaseNode last = new BaseNode(9,head);
        while (head.next!=null){
            head = head.next;
        }
        head.next = last;
        head = head.next;
        head = head.next;
//        head.printNode();
        BaseNode res = JosephUSKill1.solution2(head,3);
        res.printNode();
    }
}

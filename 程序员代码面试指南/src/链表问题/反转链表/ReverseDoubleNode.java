package 链表问题.反转链表;

import 链表问题.BaseDoubleNode;

/**
 * @author QMQ_bd137
 * @create_time is 2022-04-07 15:19
 */
public class ReverseDoubleNode {
    public static BaseDoubleNode solution(BaseDoubleNode head) {
        if (head == null) {
            return head;
        }
        BaseDoubleNode pre = null;
        BaseDoubleNode next = null;
        while (head != null) {
//            反转操作
            next = head.next;
            head.next = pre;
            head.last = next;
            //移动节点，为下一次反转准备
            pre = head;
            head = next;
        }
        return pre;
    }
}

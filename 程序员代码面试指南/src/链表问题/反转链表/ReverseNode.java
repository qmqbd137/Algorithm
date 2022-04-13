package 链表问题.反转链表;

import 链表问题.BaseNode;
import 链表问题.Node;

/**
 * @author QMQ_bd137
 * @create_time is 2022-03-29 20:07
 */
public class ReverseNode {
    public static BaseNode solution(BaseNode head){
        BaseNode pre = null;
        BaseNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

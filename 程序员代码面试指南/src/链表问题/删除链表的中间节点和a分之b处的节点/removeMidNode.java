package 链表问题.删除链表的中间节点和a分之b处的节点;

import 链表问题.Node;

/**
 * @author QMQ_bd137
 * @create_time is 2022-03-25 16:35
 */
public class removeMidNode<T> {
    public Node<T> solution(Node<T> head){
        if(head == null){
            return head;
        }
        int lenth = head.length;
        int mid = lenth/2;
        Node cur = head;
        if(mid < 1){
            return head;
        }
        if (lenth%2 == 0){
            mid --;
        }
        while (mid !=1){
            mid --;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}

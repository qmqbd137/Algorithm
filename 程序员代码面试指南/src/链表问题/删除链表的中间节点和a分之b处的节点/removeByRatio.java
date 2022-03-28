package 链表问题.删除链表的中间节点和a分之b处的节点;

import 链表问题.Node;

/**
 * @author QMQ_bd137
 * @create_time is 2022-03-28 9:36
 */
public class removeByRatio<T> {
    public Node<T> solution(Node<T> head,int a,int b){
        if ( head == null || a>b || a < 1){
            return head;
        }
        Node cur = head;
        int delectIndex = (int) Math.ceil( (double) (a*head.length)/ (double) b);
        if(delectIndex == 1){
            head = head.next;
        }
        while (--delectIndex != 1){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}

package 链表问题.在单链表和双链表中删除倒数第K个节点;

import 链表问题.DoubleNode;

/**
 * @author QMQ_bd137
 * @create_time is 2022-03-25 15:31
 */
public class removeLastKthDoubleDoubleNode<T> {
    //通过两次遍历 第一次全链表遍历，每走一步 k值减一。
    //k有三种状态 大于0（没有第K个节点） 等于0（删除头结点） 小于0（删除其他节点）
    public DoubleNode<T> soulution(DoubleNode<T> head, int lastKth) {
        if(head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null){
            cur = cur.next;
            lastKth -- ;
        }
        if (lastKth == 0 ){
            head = head.next;
        }
        if(lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            DoubleNode temp = cur.next.next;
            cur.next = temp;
            if(temp != null){
                temp.last = cur;
            }
        }
        return head;
    }
}

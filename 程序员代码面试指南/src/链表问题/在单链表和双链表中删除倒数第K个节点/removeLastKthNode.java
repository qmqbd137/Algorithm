package 链表问题.在单链表和双链表中删除倒数第K个节点;

import 链表问题.Node;

/**
 * @author QMQ_bd137
 * @create_time is 2022-03-25 10:37
 */
public class removeLastKthNode<T> {
    //快慢指针法，倒数第K个节点可以通过让快指针先走K步。
    // 然后快慢指针同时移动，当快指针移动到链表末尾时，慢指针此时指向的就是倒数第k个节点的前一节点
    public Node<T> soulution(Node<T> node, int lastKth){
        if (node == null || lastKth < 1 || node.length < lastKth){
            return node;
        }
        if(node.length == lastKth){
            return node.next;
        }
        Node<T> quickIndex = node;
        Node<T> slowIndex = node;
        Node<T> res = slowIndex;//需要记录头结点，返回的链表才会正确。
        for (int i = 0; i < lastKth; i++) {
            quickIndex = quickIndex.next;
        }
        while (quickIndex.next !=null){
            quickIndex = quickIndex.next;
            slowIndex = slowIndex.next;
        }
        if (slowIndex.next ==null) {
            return node;
        }else if(slowIndex.next.next == null){
            slowIndex.next = null;
        }else {
            slowIndex.next = slowIndex.next.next;
        }
        return res;
    }

    //通过两次遍历 第一次全链表遍历，每走一步 k值减一。
    //k有三种状态 大于0（没有第K个节点） 等于0（删除头结点） 小于0（删除其他节点）
    public Node<T> soulution1(Node<T> node, int lastKth) {
        if(node == null || lastKth < 1){
            return node;
        }
        Node cur = node;
        while (cur != null){
            cur = cur.next;
            lastKth -- ;
        }
        if (lastKth == 0 ){
            node = node.next;
        }
        if(lastKth < 0) {
            cur = node;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return node;
    }
}

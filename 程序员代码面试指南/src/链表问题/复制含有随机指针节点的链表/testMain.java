package 链表问题.复制含有随机指针节点的链表;

import 链表问题.RandomNode;

/**
 * @author QMQ_bd137
 * @create_time is 2022-05-11 9:53
 */
public class testMain {
    public static void main(String[] args) {
        RandomNode head = new RandomNode(4);
        RandomNode n1 = new RandomNode(5);
        RandomNode n2 = new RandomNode(6);
        RandomNode n3 = new RandomNode(7);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        head.rand = n3;
        n3.rand = n2;
        n2.rand = n1;
        RandomNode cur = head;
        while (cur != null){
            System.out.println(cur.value);
            int randValue = cur.rand != null? cur.rand.value : Integer.MIN_VALUE;
            System.out.println("rand's value’" + randValue );
            cur = cur.next;
        }
        RandomNode copyNode = CloneRandomNodeList.solution2(head);
        cur = copyNode;
        System.out.println("copy Node Println");
        while (cur != null){
            System.out.println(cur.value);
            int randValue = cur.rand != null? cur.rand.value : Integer.MIN_VALUE;
            System.out.println("copy rand's value’" + randValue);
            cur = cur.next;
        }
    }
}

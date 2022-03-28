package 链表问题.打印两个有序链表的公共部分;

import 链表问题.Node;

/**
 * @author QMQ_bd137
 * @create_time is 2022-02-28 17:00
 */
public class testMain {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        node.next=new Node<>(3);
        node.next.next = new Node<>(5);
        node.next.next.next = new Node<>(7);
        Node<Integer> node2 = new Node<>(1);
        node2.next = new Node<>(4);
        node2.next.next =new Node<>(6);
        node2.next.next.next = new Node<>(7);
        Integer[] arr = {1, 5, 6, 6, 7, 8, 9};
        Node<Integer> node3 = new Node<>(arr[0]);
        for (int i = 1; i <arr.length; i++) {
            node3.add(new Node<>(arr[i]));
        }

        node3.printNode();
        printCommonPart.Soulution(node,node3);
        System.out.println(node3.length);
    }
}

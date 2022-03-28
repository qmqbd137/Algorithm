package 链表问题.在单链表和双链表中删除倒数第K个节点;

import 链表问题.Node;

/**
 * @author QMQ_bd137
 * @create_time is 2022-03-25 14:26
 */
public class testMain {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(0);
        node.add(new Node<>(5));
        node.add(new Node<>(3));
        node.add(new Node<>(5));
        node.add(new Node<>(7));
        node.add(new Node<>(9));
//        Node<Integer> node1 = new removeLastKthNode<Integer>().soulution(node,3);
        Node<Integer> node2 = new removeLastKthNode<Integer>().soulution1(node,3);
//        node1.printNode();
        node2.printNode();
    }
}

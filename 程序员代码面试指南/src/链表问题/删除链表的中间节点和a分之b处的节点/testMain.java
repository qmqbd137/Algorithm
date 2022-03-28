package 链表问题.删除链表的中间节点和a分之b处的节点;

import 链表问题.Node;

/**
 * @author QMQ_bd137
 * @create_time is 2022-03-28 9:22
 */
public class testMain {
    public static void main(String[] args) {
        Node<Integer> testNode = new Node<>(0);
        testNode.add(new Node<>(1));
        testNode.add(new Node<>(2));
        testNode.add(new Node<>(3));
        testNode.add(new Node<>(4));
        new removeByRatio<Integer>().solution(testNode,3,7).printNode();
//        new removeMidNode<Integer>().solution(testNode).printNode();
    }
}

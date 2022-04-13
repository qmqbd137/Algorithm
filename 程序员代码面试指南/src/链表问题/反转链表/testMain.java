package 链表问题.反转链表;

import 链表问题.BaseNode;
import 链表问题.Node;

/**
 * @author QMQ_bd137
 * @create_time is 2022-03-29 20:41
 */
public class testMain {
    public static void main(String[] args) {
        BaseNode testNode = new BaseNode(1);
        testNode.add(5);
        testNode.add(6);
        testNode.add(7);
        BaseNode node  = ReverseNode.solution(testNode);
        node.printNode();

    }
}
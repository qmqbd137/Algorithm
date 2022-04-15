package 链表问题.反转部分单向链表;

import 链表问题.BaseNode;

/**
 * @author QMQ_bd137
 * @create_time is 2022-04-13 9:33
 */
public class ReversePartNode {
    public static BaseNode solution(BaseNode head,int from ,int to){
        if (head == null || from > to || from < 1 || to > head.length){
            return head;
        }
        int cur = 0;
        BaseNode node1 = head;
        BaseNode fPre = null;//前置节点
        BaseNode fPos = null;//后置节点
        while (node1 !=null){
            cur ++;
            fPre = cur == from -1? node1: fPre;//找到反转部分前一节点
            fPos = cur == to+1? node1:fPos;//找到反转部分后一节点
            node1 = node1.next;
        }
        node1 = fPre == null? head : fPre.next;
        BaseNode node2 = node1.next;
        node1.next = fPos; //node1
        BaseNode next = null;
        while (node2 != fPos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        //若反转链表不包括头结点则正常返回旧的head头结点即可，若包含则需要返回反转之后的最后一个节点，即node1；
        if(fPre!=null){
            fPre.next = node1;
            return head;
        }
        return node1;
    }
}

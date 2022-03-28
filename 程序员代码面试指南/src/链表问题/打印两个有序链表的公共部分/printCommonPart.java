package 链表问题.打印两个有序链表的公共部分;

import 链表问题.Node;

/**
 * @author QMQ_bd137
 * @create_time is 2022-02-28 16:23
 */
public class printCommonPart {
    public static void Soulution(Node<Integer> node1,Node<Integer> node2){
        System.out.println("Common Part:");
        while (node1 != null && node2 != null){
            if (node1.value.compareTo(node2.value)== 0){
                System.out.println(node1.value);
                node1 = node1.next;
                node2 = node2.next;
            }
            else if (node1.value.compareTo(node2.value) < 0){
                node1 = node1.next;
            }
            else  {
                node2 = node2.next;
            }
        }
    }
}

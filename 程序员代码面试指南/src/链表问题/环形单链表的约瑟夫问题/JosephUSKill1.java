package 链表问题.环形单链表的约瑟夫问题;

import 链表问题.BaseNode;

/**
 * @author QMQ_bd137
 * @create_time is 2022-04-15 9:48
 * @Todo 41人围成一个圈 设定一个固定数值，👉第一个人开始从1报数，报数到m的人自杀。然后重复此过程直到剩下最后一个人。
 * 输入：一个环形单向链表的头结点head和固定报数值m
 * 返回：最后生存下来的节点，且该节点与自己形成环形单向链表
 * 进阶问题：如果链表节点数为N，想在时间复杂度为O（N）时完成原问题的要求，如何实现？
 */
//没删除一个节点都要遍历m次 共需删除n-1个节点 故 时间复杂度o（n*m）
public class JosephUSKill1 {
    public static BaseNode solution(BaseNode head,int m){
        if(head == null || head == head.next || m<1){
            return head;
        }
        int index = 1;
        while (head != head.next){
            index ++;
            if (index == m){
                head.next = head.next.next;
                index = 1 ;
            }
            head = head.next;
        }
        return head;
    }
    public static BaseNode solution2(BaseNode head,int m) {
        if (head == null || head == head.next || m < 1) {
            return head;
        }
        BaseNode cur = head.next;
        int temp = 1;
        while (cur != head) {
            temp++;
            cur = cur.next;
        }
        temp = getLive(temp,m);
        while (--temp !=0)
        {
            head = head.next;
        }
        head.next = head;
        return head;
    }
    private static int getLive(int i,int m){
        if (i==1) {
            return 1;
        }
        return (getLive( i-1, m) + m -1) % i + 1;
    }
}
package 链表问题.复制含有随机指针节点的链表;

import com.sun.nio.sctp.PeerAddressChangeNotification;
import 链表问题.BaseNode;
import 链表问题.RandomNode;

import java.util.HashMap;

/**
 * @author QMQ_bd137
 * @create_time is 2022-05-09 18:18
 */
public class CloneRandomNodeList {
//    基础解法 时间复杂度o（N） 空间复杂度o（N）
    public static RandomNode soulution(RandomNode head) {
//        第一步 将源节点和复制节点 按 key-value的对应关系放置于hashMap中 复制节点next和rand都只指向null
        if (head == null) {
            return head;
        }
        HashMap<RandomNode, RandomNode> hashMap = new HashMap<>();
        RandomNode cur = head;
        while (cur != null) {
            hashMap.put(cur, new RandomNode(cur.value));
            cur = cur.next;
        }
//        第二步： 对hashmap中克隆节点的next 和rand 一一设置
        cur = head;
        while (cur != null) {
            hashMap.get(cur).next = hashMap.get(cur.next);
            hashMap.get(cur).rand = hashMap.get(cur.rand);
            cur = cur.next;
        }
//        返回克隆链表头结点
        return hashMap.get(head);
    }
//    进阶： 不使用额外的数据结构，只用有限的几个变量，且在时间复杂度为O（N）内完成
    public static RandomNode solution2(RandomNode head) {
        if(head == null){
            return null;
        }
        RandomNode cur = head;
        RandomNode next = null;
        while (cur != null){
            next = cur.next;
            RandomNode temp = new RandomNode(cur.value);
            cur.next = temp;
            temp.next = next;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null){
            cur.next.rand = cur.rand != null ? cur.rand.next : null;
            cur = cur.next.next;
        }
//        拆分链表 将克隆节点从原链表总剥离
        cur = head;
        RandomNode cloneList = head.next;
        RandomNode curCopy = null;
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return cloneList;
    }
}

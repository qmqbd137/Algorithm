package 链表问题.回文链表;

import 链表问题.BaseNode;

import java.util.Stack;

/**
 * @author QMQ_bd137
 * @create_time is 2022-04-18 15:02
 */
public class isPalindrome {
//    解法1 利用栈的先入后出规则
    public static boolean soulution1(BaseNode head){
//        int length = 0;
        BaseNode cur = head;
        Stack<Integer> tempstack = new Stack<>();
        while (cur!= null){
//            length ++;
            tempstack.push(cur.value);
            cur = cur.next;
        }
        while (!tempstack.isEmpty()){
            if (tempstack.pop() != head.value){
                return false;
            }
            head = head.next;
        }

        return true;
    }
    //    解法2 与一相似，但只需要压入一半的节点，使用快慢指针发找到中间起始节点
    public static boolean soulution2(BaseNode head){
        BaseNode quick = head;
        BaseNode slow = head.next;
        while (quick.next !=null && quick.next.next !=null){
            slow = slow.next;
            quick = quick.next.next;
        }
        Stack<Integer> tempStack = new Stack<>();
        while (slow!=null){
            tempStack.push(slow.value);
            slow = slow.next;
        }
        while (!tempStack.isEmpty()){
            if(tempStack.pop() != head.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }
    //    解法3  改变链表本身结构，使左半部分 和右半部分都指向中间节点，判断完成后需要重新复原链表。时间复杂度O（N），空间复杂度O（1）
    public static boolean soulution3(BaseNode head){
        if(head == null || head.next == null){
            return true;
        }
        boolean PalindromeFlag = true;
//      步骤一找到链表右半段起始节点，准备翻转步骤
        BaseNode end = head;//工件节点,仅为找到右半段起始节点使用
        BaseNode rightHalf = head.next; //右半段起始节点
        BaseNode left = head;
        while (end.next !=null && end.next.next !=null){
            rightHalf = rightHalf.next;//右半段起始节点
            end = end.next.next;//结尾节点
        }

//      反转右半部分节点  right 右边第一个节点  此时翻转链表结束后 rightReverse的下个节点将为null head节点只留下右半段的第一个节点。
//      渐变为这种结构  O->O->O->O<-O<-O
        BaseNode rigthReverse = rightHalf.next;
        rightHalf.next = null;
        BaseNode rNext = null;
        while (rigthReverse!=null) {
            rNext = rigthReverse.next;
            rigthReverse.next = rightHalf;
//          移动节点到下一位置,以便后续循环翻转下一个节点
            rightHalf = rigthReverse;
            rigthReverse = rNext;
        }
        rigthReverse = rightHalf;//留存翻转后列表的第一个节点,后面恢复翻转结构。
        while (rightHalf!=null){
            if (rightHalf.value != left.value){
                PalindromeFlag = false;
//                break;
            }
            rightHalf = rightHalf.next;
            left = left.next;
        }
        rightHalf = rigthReverse;
        rigthReverse = rightHalf.next;
        rightHalf.next = null;
        rNext = null;
        while (rigthReverse != null){
            rNext = rigthReverse.next;
            rigthReverse.next = rightHalf;
            rightHalf = rigthReverse;
            rigthReverse = rNext;
        }

        while (head!=null){
            System.out.println(head.value);
            head = head.next;
        }
        return PalindromeFlag;
    }
}

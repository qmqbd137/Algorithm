package 链表问题.两个单链表生成相加链表;

import 链表问题.BaseNode;

import java.util.Stack;

/**
 * @author QMQ_bd137
 * @create_time is 2022-05-12 16:25
 */
public class addLists {
/**
 * 方法1：时间复杂度 o(N) 空间复杂度O（N）
 * 借由堆栈 先进后出 对链表进行倒序 再从低位数字开始相加
 */

    public static BaseNode solution(BaseNode l1,BaseNode l2){
        if (l1 == null && l2 == null){
            return new BaseNode(0);
        }
        Stack<BaseNode> l1stack = new Stack<>();
        Stack<BaseNode> l2stack = new Stack<>();
        BaseNode res = null;
        while (l1 != null || l2 != null){
            l1stack.push(l1 != null? l1 : new BaseNode(0));
            l2stack.push(l2 != null? l2 : new BaseNode(0));
            l1 = l1.next;
            l2 = l2.next;
        }
        int flag = 0;//进位
        while (!(l1stack.isEmpty() && flag == 0)){
            int l1Value = l1stack.isEmpty()? 0 : l1stack.pop().value;
            int l2Value = l2stack.isEmpty()? 0 : l2stack.pop().value;
            int tempAddValue = l1Value + l2Value +flag;
            if (tempAddValue > 9){
                if(res == null){
                    res = new BaseNode(tempAddValue % 10);
                }else{
                    res = res.addReverse(tempAddValue % 10);
                }
                flag = tempAddValue / 10;
            }else{
                if (res == null){
                    res = new BaseNode(tempAddValue);
                }else {
                    res = res.addReverse(tempAddValue);
                }
                flag = 0;
            }
        }
        return res;
    }
    /**
     *
     * @param l1 链表1
     * @param l2 链表2
     * @TODO: 2022/5/19    链表相加
     * @return 相加链表
     * @deprecated 链表相加方法二： 先将链表逆序 然后逐步相加 生成相加链表
     */
        public static BaseNode solution2(BaseNode l1,BaseNode l2) {
            BaseNode l1Reverse = nodeReverse(l1);
            BaseNode l2Reverse = nodeReverse(l2);

            BaseNode l1ReverseCopy = l1Reverse;
            BaseNode l2ReverseCopy = l2Reverse;
//            l1Reverse.printNode();
//            l2Reverse.printNode();
            int flag = 0;
            BaseNode res = null;
            while (l1Reverse != null && l2Reverse != null){
                int l1ReverseValue = l1Reverse == null? 0: l1Reverse.value;
                int l2ReverseValue = l2Reverse == null? 0: l2Reverse.value;
                int tempValue = l1ReverseValue + l2ReverseValue + flag;
                if (tempValue > 9){
                    if (res == null){
                        res = new BaseNode(tempValue % 10);
                    }else {
                        res = res.addReverse(tempValue % 10);
                    }
                }else{
                    if (res == null){
                        res = new BaseNode(tempValue);
                    }else {
                        res = res.addReverse(tempValue);
                    }
                }
                flag = tempValue / 10;
                l1Reverse = l1Reverse.next;
                l2Reverse = l2Reverse.next;
            }
            l1 = nodeReverse(l1ReverseCopy);
            l2 = nodeReverse(l2ReverseCopy);
            l1.printNode();
            l2.printNode();
            return res;
        }
        private static BaseNode nodeReverse(BaseNode head){
            BaseNode pre = null;
            BaseNode next = null;
            while (head != null){
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }

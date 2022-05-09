package 链表问题.单向链表根据某值划分;

import 链表问题.BaseNode;
import 链表问题.Node;

/**
 * @author QMQ_bd137
 * @create_time is 2022-05-06 10:43
 */
public class listPartition {
    public static BaseNode solution(BaseNode head,int pivot){
        if(head == null){
            return head;
        }
        BaseNode cur = head;
        int i = 0;
        while (cur != null){
            i++;
            cur = cur.next;
        }
        BaseNode[] nodeArr = new BaseNode[i];
        cur = head;
        i = 0;
        for (i = 0; i != nodeArr.length; i++){
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr,pivot);
        i = 1;
        while (i != nodeArr.length){
            nodeArr[i-1].next = nodeArr[i++];
        }
        nodeArr[i-1].next = null;//先前链表仍会连接 形成闭环
        return nodeArr[0];
    }
    /*
    * 进阶：划分后每一部分的节点顺序仍按原链表排序
    * 时间复杂度0（N） 空间复杂度O（1）
    * */
    public static BaseNode solution2(BaseNode head,int pivot){
        BaseNode sH = null;
        BaseNode sE = null;
        BaseNode mH = null;
        BaseNode mE = null;
        BaseNode bH = null;
        BaseNode bE = null;
        BaseNode next = null;
        while (head != null){
            next = head.next;
            head.next = null;
            if (head.value < pivot){
                if(sH == null){
                    sH = head;
                    sE = head;
                }
                else{
                    sE.next = head;
                    sE = head;
                }
            }
            else if (head.value == pivot){
                if (mH == null){
                    mH = head;
                    mE = head;
                }
                else{
                    mE.next = head;
                    mE = head;
                }
            }
            else{
                if (bH == null){
                    bH = head;
                    bE = head;
                }
                else {
                    bE.next = head;
                    bE = head;
                }
            }
            head = next;
        }
        if(sH == null){
            if (mH == null){
                return bH;
            }else{
                mE.next = bH;
                return mH;
            }
        }else {
            if (mH == null){
                return sH;
            }else{
                sE.next = mH;
                mE.next = bH;
            }
            return sH;
        }
    }
    private static void arrPartition(BaseNode[] arrNodes, int pivot){
        int start = -1;
        int end = arrNodes.length;
        int index = 0;
        while (index != end){
            if (arrNodes[index].value < pivot){
                swap(arrNodes,index++,++start);
            }
            else if(arrNodes[index].value == pivot){
                index ++;
            }
            else {
                swap(arrNodes,index,--end);//此处不对index操作的原因是 直接换过来的index后面的节点，未进行过判断。若直接index++则会漏过
            }
        }
    }
    private static void swap(BaseNode[] arrNodes, int i, int j){
        BaseNode temp = arrNodes[i];
        arrNodes[i] = arrNodes[j];
        arrNodes[j] = temp;
    }
}

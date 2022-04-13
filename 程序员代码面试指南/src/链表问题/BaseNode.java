package 链表问题;

/**
 * @author QMQ_bd137
 * @create_time is 2022-03-29 20:23
 */
public class BaseNode {
    public int value = 0;
    public BaseNode next;
    public int length = 1;

    public BaseNode(BaseNode nextNode){
        this.next = nextNode;
    }

    public BaseNode(int data){
        this.value = data;
    }

    public BaseNode(int data, BaseNode next) {
        this.next = next;
        this.value = data;
    }


    //头插法，倒序
    public void addReverse(int value) {
        BaseNode node = new BaseNode(value);
        if (this.next == null) {
            this.next = node;
            length += 1;
            return;
        }
        BaseNode temp = this.next;
        this.next = node;
        node.next = temp;
        length += 1;
    }

    //尾插法
    public void add(int value) {
        BaseNode node = new BaseNode(value);
        if (this.next == null) {
            this.next = node;
            length += 1;
            return;
        }
        BaseNode temp = this.next;
        //第一次写的时候写成了 temp！=null的条件 导致插入失效。原因：如果temp 为null时作为循环停止条件，那么temp=temp.next就会为null永远不会形成链表。
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        length += 1;
    }

    public void printNode(){
        System.out.println("print Node[start]:");
        BaseNode temp = this;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("print Node[end]:");

    }
}

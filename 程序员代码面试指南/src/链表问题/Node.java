package 链表问题;

/**
 * @author QMQ_bd137
 * @create_time is 2022-02-28 16:17
 */
public class Node<T> {
    public T value;
    public Node<T> next;
    public int length = 1;

    public Node(T data){
        this.value = data;
    }

    //头插法，倒序
    public void addReverse(Node<T> node){
        if (this.next == null){
            this.next = node;
            length += 1;
            return;
        }
        Node<T> temp = this.next;
        this.next = node;
        node.next = temp;
        length += 1;
    }
    //尾插法
    public void add(Node<T> node){
        if (this.next == null){
            this.next = node;
            length += 1;
            return;
        }
        Node<T> temp = this.next;
        //第一次写的时候写成了 temp！=null的条件 导致插入失效。原因：如果temp 为null时作为循环停止条件，那么temp=temp.next就会为null永远不会形成链表。
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        length += 1;
    }

    public void printNode(){
        System.out.println("print Node[start]:");
        Node temp = this;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("print Node[end]:");

    }
}

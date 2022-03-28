package 链表问题;

/**
 * @author QMQ_bd137
 * @create_time is 2022-03-25 15:22
 */
public class DoubleNode<T> {
    public T value;
    public DoubleNode<T> last;
    public DoubleNode<T> next;

    public DoubleNode(T data){
        this.value = data;
    }
}

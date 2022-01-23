package 栈和队列.设计一个有getMin功能的栈;


/**
 * @author QMQ_bd137
 * @create_time is 2021-05-21 16:27
 */
public class main {
    public static void main(String[] args) {
        System.out.println("下面开始第一种栈的测试");
        GetMinStack1 getMinStack1 = new GetMinStack1();
        getMinStack1.push(3);
        System.out.println(getMinStack1.getMin());
        getMinStack1.push(1);
        System.out.println(getMinStack1.getMin());
        System.out.println(getMinStack1.Pop());
        System.out.println(getMinStack1.Pop());
        getMinStack1.push(5);
        getMinStack1.push(6);
        System.out.println(getMinStack1.getMin());
        getMinStack1.push(8);
        getMinStack1.push(0);
        System.out.println(getMinStack1.getMin());
        System.out.println("下面开始第二种栈的测试");
        GetMinStack2 getMinStack2 = new GetMinStack2();
        getMinStack2.push(3);
        System.out.println(getMinStack2.getMin());
        getMinStack2.push(1);
        System.out.println(getMinStack2.getMin());
        System.out.println(getMinStack2.pop());
        System.out.println(getMinStack2.pop());
        getMinStack2.push(5);
        getMinStack2.push(6);
        System.out.println(getMinStack2.getMin());
        getMinStack2.push(8);
        getMinStack2.push(0);
        System.out.println(getMinStack2.getMin());
    }

}

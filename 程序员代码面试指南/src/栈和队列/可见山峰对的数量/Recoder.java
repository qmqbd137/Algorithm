package 栈和队列.可见山峰对的数量;

/**
 * @author QMQ_bd137
 * @create_time is 2022-02-25 15:32
 */

public class Recoder {
    private int value;
    private int times;

    public Recoder(int value){
        this.value = value;
        this.times = 1;
    }

    public int getValue(){
        return this.value;
    }
    public int getTimes(){
        return this.times;
    }
    public void setValue(int value){
        this.value = value;
    }
    public void setTimes(int times){
        this.times = times;
    }
}

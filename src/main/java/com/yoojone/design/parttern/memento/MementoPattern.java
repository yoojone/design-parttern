package com.yoojone.design.parttern.memento;

/**
 * @author yuqiang.zhang
 * @date 2021/9/14
 * description: 备忘录 模式
 *  将中间数据暂存之后再恢复
 */
public class MementoPattern {

    /**
     * 系统会产生一份中间数据，这份数据 要么没法一直留在内存中，要么可能被修改
     * 所以要通过备忘录模式，将中间数据暂存一份
     * 在一堆操作之后，可能之前的内存中的中间数据都弄丢了，或者被修改了
     * 接下来，我们需要从备忘录中恢复我们的中间数据
     * 基于恢复后的数据，再次执行后面的操作
     *
     */
    public static void main(String[] args) {
        Originator originator = new Originator();

        // 准备好了中间数据
        originator.prepare();
        // 将中间数据保存到备忘录中去
        Memento memento = originator.createMemento();
        // 将备忘录保存到备忘录管理器中去
        Caretaker caretaker = new Caretaker();
        caretaker.saveMemento(memento);
        // 基于中间数据执行了A方法，但是此时中间数据已经改变了
        originator.executeA();
        // 从备忘录管理器中获取备忘录
        memento = caretaker.retriveMemento();
        // 将备忘录中保存好的中间数据重新设置到原发器中去，就将中间数据恢复成了之前备忘的状态
        originator.setMemento(memento);
        // 接着再次执行方法B
        originator.executeB();


    }

    public interface Memento {

    }
    public static class Originator {

        private String state;

        public void prepare() {
            this.state = "中间数据";
        }

        public void executeA() {
            System.out.println("基于中间数据【" + state +"】进行了A方法的执行");
            state += "，A方法的结果数据";
        }

        public void executeB() {
            System.out.println("基于中间数据【" + state +"】进行了A方法的执行");
            state += "，B方法的结果数据";
        }

        public Memento createMemento() {
            return new MementoImpl(state);
        }

        public void setMemento(Memento memento) {
            MementoImpl mementoImpl = (MementoImpl)memento;
            this.state = mementoImpl.getState();
        }


    }
    private static class MementoImpl implements Memento {

        private String state;

        public MementoImpl(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

    }
    private static class Caretaker {

        private Memento memento;

        public void saveMemento(Memento memento) {
            this.memento = memento;
        }

        public Memento retriveMemento() {
            return this.memento;
        }

    }



}

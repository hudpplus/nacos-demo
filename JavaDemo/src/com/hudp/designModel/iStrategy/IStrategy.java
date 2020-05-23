package com.hudp.designModel.iStrategy;

/**
 * 策略模式
 */
public class IStrategy {

    public static void main(String[] args) {
        Context context;
        System.out.println("-----执行策略1-----");
        context = new Context(new ConcreteStrategy1());
        context.execute();

        System.out.println("-----执行策略2-----");
        context = new Context(new ConcreteStrategy2());
        context.execute();
    }
}
interface IStrategyInter{
    public void doSomething();
}
class ConcreteStrategy1 implements IStrategyInter {
    public void doSomething() {
        System.out.println("具体策略1");
    }
}
class ConcreteStrategy2 implements IStrategyInter {
    public void doSomething() {
        System.out.println("具体策略2");
    }
}
class Context{
    private IStrategyInter iStrategy;
    public Context(IStrategyInter iStrategy){
        this.iStrategy=iStrategy;
    }
    public void execute(){
        iStrategy.doSomething();
    }
}

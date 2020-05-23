package com.hudp.designModel.observer;

import java.util.Vector;

/**
 * 观察者模式
 */
public class ObserverType{
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        subject.addObserver(new ConcreteObserver1());
        subject.addObserver(new ConcreteObserver2());
        subject.doSomeThing();
    }

}
abstract class Subject {

    private Vector<Observer> vobs = new Vector();

    public void addObserver(Observer obs){
        vobs.add(obs);
    }
    public void delObserver(Observer obs){
        vobs.remove(obs);
    }
    protected void notice(){
        for(Observer o:vobs){
            o.update();
        }
    }
    public abstract void doSomeThing();
}

class ConcreteSubject extends Subject{


    @Override
    public void doSomeThing() {
        System.out.println("被观察者干了某件事。。。");
        this.notice();
    }
}

interface Observer{

    void update();
}
class ConcreteObserver1 implements Observer{

    @Override
    public void update() {
        System.out.println("ConcreteObserver1 收到信息，并进行处理。....");
    }
}
class ConcreteObserver2 implements Observer{

    @Override
    public void update() {
        System.out.println("ConcreteObserver2 收到信息，并进行处理。....");
    }
}

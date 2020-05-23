package com.hudp.designModel.zhongJieZhe;

/**
 * 中介者模式
 * 解决同事类之间的关系
 */
public class ColleagueMediator {

    public static void main(String[] args) {
        AbstractColleague a = new ColleagueA();
        AbstractColleague b = new ColleagueB();
        AbstractMediator am = new Mediator(a, b);


        System.out.println("==========通过设置A影响B==========");
        a.setNumber(1000, am);
        System.out.println("collA的number值为："+a.getNumber());
        System.out.println("collB的number值为A的10倍："+b.getNumber());

        System.out.println("==========通过设置B影响A==========");
        b.setNumber(1000, am);
        System.out.println("collB的number值为："+b.getNumber());
        System.out.println("collA的number值为B的0.1倍："+a.getNumber());
    }


}
abstract class AbstractMediator {

    AbstractColleague a;
    AbstractColleague b;
    AbstractMediator (AbstractColleague a,AbstractColleague b){
        this.a=a;
        this.b=b;
    }
    abstract void AeffactB();
    abstract void BeffactA();

}
class Mediator extends AbstractMediator {

    Mediator(AbstractColleague a,AbstractColleague b){
        super(a,b);
    }

    @Override
    void AeffactB() {
        int number = a.getNumber();
        b.setNumber(number*100);
    }

    @Override
    void BeffactA() {
        int number = b.getNumber();
        a.setNumber(number/100);
    }
}

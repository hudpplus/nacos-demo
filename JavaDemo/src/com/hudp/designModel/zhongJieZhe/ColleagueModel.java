package com.hudp.designModel.zhongJieZhe;

/**
 * 同事类之间的关系
 */
public class ColleagueModel {

    public static void main(String[] args){

        AbstractColleague collA = new ColleagueA();
        AbstractColleague collB = new ColleagueB();

        System.out.println("==========设置A影响B==========");
        //collA.setNumber(1288, collB);
        System.out.println("collA的number值："+collA.getNumber());
        System.out.println("collB的number值："+collB.getNumber());

        System.out.println("==========设置B影响A==========");
        //collB.setNumber(87635, collA);
        System.out.println("collB的number值："+collB.getNumber());
        System.out.println("collA的number值："+collA.getNumber());
    }
}

abstract class AbstractColleague{
    int number;
    //public abstract void setNumber(int num,Colleague coll);
    public abstract void setNumber(int number,AbstractMediator am); //使用中介者模式

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

class ColleagueA extends AbstractColleague{

    /*@Override
    public void setNumber(int number, Colleague coll) {
        this.number = number;
        coll.setNumber(number*100);
    }*/

    @Override
    public void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.AeffactB();
    }
}
class ColleagueB extends AbstractColleague{

    /*@Override
    public void setNumber(int number, Colleague coll) {
        this.number = number;
        coll.setNumber(number/100);
    }*/

    @Override
    public void setNumber(int number, AbstractMediator am) {
        this.number=number;
        am.BeffactA();
    }
}

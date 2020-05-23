package com.hudp.jdk8.lambda;

import com.hudp.jdk8.lambda.interfacces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

public class TestLambda {

    public static void main(String[] args) {

        NoReturnNoParam noReturnNoParam = ()->{
            System.out.println("NoReturnNoParam..");
        };
        noReturnNoParam.method();

        /**简化参数小括号，如果只有一个参数则可以省略参数小括号， 如  a->{}  */
        NoReturnOneParam noReturnOneParam = (int a)->{
            System.out.println("NoReturnOneParam.."+a);
        };
        /**   NoReturnOneParam noReturnOneParam1 =  a->{};   可以   */
        /**  NoReturnOneParam noReturnOneParam1 = int a->{}; 不行    */
        noReturnOneParam.method(0);

        /**简化参数类型，可以不写参数类型，但是必须所有参数都不写  如   (a,b)*/
        NoReturnMultiParam noReturnMultiParam = (int a,int b)->{
            System.out.println("NoReturnMultiParam..a*b = "+a*b);
        };
        noReturnMultiParam.method(2,3);


        ReturnNoParam returnNoParam = ()->{
            System.out.println("ReturnNoParam..");
            return 0;
        };
        System.out.println("ReturnNoParam.."+returnNoParam.method());
        ReturnOneParam returnOneParam = (int a)->{
            System.out.println("ReturnOneParam.."+a);
            return a;
        };
        System.out.println("ReturnOneParam.."+returnOneParam.method(8));
        ReturnMultiParam returnMultiParam = (int a,int b)->{
            System.out.println("ReturnMultiParam..a*b= "+a*b);
            return a*b;
        };
        System.out.println("ReturnMultiParam..a*b= "+returnMultiParam.method(1,68));

        System.out.println();
        System.out.println();
        System.out.println("方法的引用 ： ==============================================================================================");

        /**
         * 方法的引用 ：
         * 有时候我们不是必须要自己重写某个匿名内部类的方法
         * 我们可以利用 lambda 表达式的接口快速指向一个已经被实现的方法
         */
        ReturnOneParam returnOneParam1 = a->doubleNum(a);
        System.out.println(returnOneParam1.method(3));


        System.out.println();
        System.out.println();
        System.out.println("构造方法的引用 ： ==============================================================================================");

        /**
         * 构造方法的引用 ：
         *
         *
         */

        System.out.println();
        System.out.println("lambda 表达式创建线程 : ==============================================================================================");

        /**
         *  lambda 表达式创建线程
         */
        Thread t = new Thread(()->{
            System.out.println("test lambda 表达式创建线程");
        });
        t.start();

        System.out.println();
        System.out.println("lambda 集合操作 : ==============================================================================================");

        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5);
        /** lambda 表达式, 方法的引用 */
        list.forEach(System.out::println);
        list.forEach(element->{
            if(element%2==0){
                System.out.println(element);
            }
        });

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(11,"小牙刷",12.05));
        items.add(new Item(5,"日本马桶盖",999.05));
        items.add(new Item(7,"格力空调",888.88));
        items.add(new Item(17,"肥皂",2.05));
        items.add(new Item(9,"冰箱",4200.05));

        items.forEach(item->{
            System.out.println(item.toString());
        });
        items.removeIf(item->item.getId()==7);
        System.out.println("items after remove : ");
        items.forEach(System.out::println);

        /*items.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getId()-o2.getId();
            }
        });*/
        System.out.println("items after sort : ");
        items.forEach(System.out::println);
        System.out.println("items after sort by lambda : ");
        items.sort(((o1, o2) -> {return o1.getId()-o2.getId();}));
        System.out.println(items);


        /**
         * Lambda 表达式中的闭包问题
         * 这问题在我们匿名内部类中也会存在，如果我们把注释放开会报错，告诉我们 num 值是 final 不能被改变。
         * 这里我们虽然没有标识 num 类型为 final，
         * 但是在编译期间虚拟机会帮我们加上 final 修饰关键字。
         */
        int num = 10;
        Consumer<String> consumer = ele->{
            System.out.println(num);
        };
        //num = num +2;
        consumer.accept("hello");


    }

    /**
     * 要求 ：
     * 1.参数数量和类型要与接口中定义的一致
     * 2.返回值类型要与接口中定义的一致
     * @param a
     * @return
     */
    private static int doubleNum(int a) {
        return a*2;
    }

}

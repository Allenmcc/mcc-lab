package inner;

/**
 * Created by chunchen.meng on 2018/10/30.
 */

/**
 * @author longe
 *    内部类作用：
 *        1.每个内部类都能独立的继承一个接口的实现，所以无论外部类是否已经继承了某个(接口的)实现，对于内部类都没有影响。内部类使得多继承的解决方案变得完整，
 *        2.方便将存在一定逻辑关系的类组织在一起，又可以对外界隐藏。
 *        3.方便编写事件驱动程序
 *        4.方便编写线程代码
 *        内部类的存在使得Java的多继承机制变得更加完善。
 *
 */

public class Test {

        private int a = 1;

        public static void main(String[] args) {
            Test test = new Test();
            test.print();
//        成员内部类的创建，依赖于外部类对象，即必须先创建外部类对象，再通过该对象引用来创建成员内部类
            Test.T testT = test.new T();
            testT.print();
//        静态内部类的创建
            Test.TT testTT = new Test.TT();
            testTT.print();

//            TestIF teIf = new TestIF() {
//                /* (non-Javadoc)
//                 *     匿名内部类，常用于时间监听调用
//                 */
//                @Override
//                public void print() {
//                    System.out.println("anonymity inner class -  " + 5);
//                }
//            };
//            teIf.print();
        }

        /**
         *    局部内部类，作用范围在方法内部
         */
        public void print() {
            class T {
                private int a = 4;
            }
            T t = new T();
            System.out.println("method inner class -  " + t.a);
        }

        /**
         * @author longe
         *    成员内部类，可以随意访问外部类变量和方法
         *    当内部类成员变量与外部类重复时，注意引用方式
         */
        class T {
            private int a = 2;
            public void print() {
                System.out.println("member inner class -  " + this.a);
//            引用外部类成员变量
                System.out.println("member inner class -  " + Test.this.a);
            }
        }

        /**
         * @author longe
         *    静态内部类，可以随意访问外部类变量和方法
         */
        static class TT {
            private int a = 3;

            public void print() {
                System.out.println("static inner class -  " + this.a);
            }
        }

}

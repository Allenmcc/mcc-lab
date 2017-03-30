/**
 * Created by danny on 2017/1/12.
 */
public class QuestionMain implements ITest{
    public static void main(String[] args) {
        ITest.TestInternal.test(new QuestionMain());
    }

    @Override
    public void print() {
        System.out.println("真正实现方法");
    }
}

interface ITest {

    void print();

    public static class TestInternal {
        public static void test(ITest test) {
            test.print();
        }
    }
}
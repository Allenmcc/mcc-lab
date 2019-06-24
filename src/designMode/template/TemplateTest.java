package designMode.template;

/**
 * Created by chunchen.meng on 2019/6/21.
 * 模版模式应用
 * 最经典的就是JUC包下的AQS(AbstractQueuedSynchronizer)
 * acquire()相当于模板方法，tryAcquire(arg)相当于基本方法。
 */
public class TemplateTest {
    public static void main(String[] args) {

        WriteArticle java3ywriteArticle = new Java3yWriteArticle();
        java3ywriteArticle.writeAnCompleteArticle();

        WriteArticle java3yGFWriteArticle = new Java3yGFWriteArticle();
        java3yGFWriteArticle.writeAnCompleteArticle();

    }
}

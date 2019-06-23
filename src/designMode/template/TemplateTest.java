package designMode.template;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
public class TemplateTest {
    public static void main(String[] args) {

        WriteArticle java3ywriteArticle = new Java3yWriteArticle();
        java3ywriteArticle.writeAnCompleteArticle();

        WriteArticle java3yGFWriteArticle = new Java3yGFWriteArticle();
        java3yGFWriteArticle.writeAnCompleteArticle();

    }
}

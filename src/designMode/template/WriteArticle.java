package designMode.template;

/**
 * Created by chunchen.meng on 2019/6/21.
 * https://segmentfault.com/a/1190000017755960
 */
//通用模版
public abstract class WriteArticle {
    //基本方法，子类实现 每个人的“前言”都不一样，所以抽象(abstract)
    protected abstract void introduction();

    // 每个人的“最后”都不一样，所以抽象(abstract)
    protected abstract void theLast();


    // 实际要写的内容，每个人的“实际内容”都不一样，所以抽象(abstract)
    protected abstract void actualContent();


    /**
     *
     * 把公共的代码抽取出来，如果该功能是不确定的，那我们将其修饰成抽象方法。
       将几个固定步骤的功能封装到一个方法中，对外暴露这个方法，就可以非常方便调用了。
     */
    // 模版方法 写一篇完整的文章(为了方便调用，我们将这几个步骤分装成一个方法)
    public final void writeAnCompleteArticle() {

        // 前言
        introduction();

        // 实际内容
        actualContent();

        // 最后
        theLast();
    }
}

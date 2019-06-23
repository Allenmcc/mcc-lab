package designMode.template;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
// 3y女朋友的文章模板
public class Java3yGFWriteArticle extends WriteArticle{

    // 前言 实现基本方法
    @Override
    public void introduction() {
        System.out.println("balabalabalalabalablablalab");
    }

    // 最后
    @Override
    public void theLast() {
        System.out.println("balabalabalalabalablablalab");

    }

    @Override
    protected void actualContent() {
        System.out.println("3y是傻子，不用管他");
    }

}

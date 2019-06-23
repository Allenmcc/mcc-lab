package designMode.template;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
// 3y的文章模板
public class Java3yWriteArticle extends WriteArticle {

    // 前言
    @Override
    public void introduction() {
        System.out.println("只有光头才能变强");
    }

    // 最后
    @Override
    public void theLast() {
        System.out.println("关注我的公众号：Java3y");

    }
    @Override
    protected void actualContent() {
        System.out.println("大家好，我是3y，今天来给大家分享我写的模板方法模式");
    }

}

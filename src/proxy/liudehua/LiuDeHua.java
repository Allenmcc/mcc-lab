package proxy.liudehua;

/**
 * Created by chunchen.meng on 2018/10/12.
 */
public class LiuDeHua implements Person {

    @Override
    public String sing(String name){
        System.out.println("刘德华唱"+name+"歌！！");
        return "歌唱完了，谢谢大家！";
    }

    @Override
    public String dance(String name){
        System.out.println("刘德华跳"+name+"舞！！");
        return "舞跳完了，多谢各位观众！";
    }
}

package designMode.atguigu.state.money;

/**
 *
 * @author Administrator
 *
 */
public enum StateEnum {

	 //通用
    GENERATE(1, "GENERATE"),

    //REVIEWED
    REVIEWED(2, "REVIEWED"),

    //发布
    PUBLISHED(3, "PUBLISHED"),

    //未付款
    NOT_PAY(4, "NOT_PAY"),

    //付款
    PAID(5, "PAID"),

    //反馈
    FEED_BACKED(6, "FEED_BACKED");

    private int key;
    private String value;

    StateEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
    public int getKey() {return key;}
    public String getValue() {return value;}
}

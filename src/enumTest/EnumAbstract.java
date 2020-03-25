package enumTest;

/**
 * https://cloud.tencent.com/developer/article/1483090
 *
 * 本次需求中，已经定了几个固定的常量值，每个常量值都有相同的行为，但是具体的实现细节不同。
 * 建议使用枚举抽象方法，好处：结构清晰，便于扩展。
 *
 * 代码中的访问修饰符可根据需要修改。上述代码仅用于演示。
 * 该代码对外封装细节，仅提供了打印方法，使用此方法需要知道枚举常量对应的key值。
 * 如果知道枚举值，可直接调用打印方法。workDays.print();
 */
public class EnumAbstract {
    //对外提供方法
    public void print(int key) {
        keyOf(key).print();
    }

    public void print(WorkDays workDays){
        workDays.print();
    }

    //获取Key对应的实例
    private WorkDays keyOf(int key) {
        switch (key) {
            case 1:
                return WorkDays.MONDAY;
            case 2:
                return WorkDays.TUESDAY;
            case 3:
                return WorkDays.WEDNESDAY;
            case 4:
                return WorkDays.THURSDAY;
            case 5:
                return WorkDays.FRIDAY;
            case 6:
                return WorkDays.SUNDAY;
            case 7:
                return WorkDays.SATURDAY;
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        EnumAbstract enumAbstract = new EnumAbstract();
        enumAbstract.print(enumAbstract.keyOf(2));
        enumAbstract.print(2);
    }
}

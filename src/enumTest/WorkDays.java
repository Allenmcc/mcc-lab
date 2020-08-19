package enumTest;


/**
 * 每个常量值都有相同的行为，但是具体的实现细节不同。
 * 建议使用枚举抽象方法，好处：结构清晰，便于扩展。
 */
public enum WorkDays {
    MONDAY(1) {
        @Override
        protected void print() {
            System.out.println(getKey()+" : 消息1");
        }
    }, TUESDAY(2) {
        @Override
        protected void print() {
            System.out.println(getKey()+" : 消息2");
        }
    }, WEDNESDAY(3) {
        @Override
        protected void print() {
            System.out.println(getKey()+": 消息3");
        }
    }, THURSDAY(4) {
        @Override
        protected void print() {
            System.out.println(getKey()+" : 消息4");
        }
    }, FRIDAY(5) {
        @Override
        protected void print() {
            System.out.println(getKey()+" : 消息5");

        }
    }, SATURDAY(6) {
        @Override
        protected void print() {
            System.out.println(getKey()+" : 消息6");
        }
    }, SUNDAY(7) {
        @Override
        protected void print() {
            System.out.println(getKey()+" : 消息7");
        }
    };

    private int key;

    //私有化构造方法
    private WorkDays(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    //抽象方法
    protected abstract void print();
}

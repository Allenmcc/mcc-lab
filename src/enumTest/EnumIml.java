package enumTest;

/**
 * 枚举实现接口
 * 枚举的常量值本质就是枚举对象
 * 为了呈现不同的 Paint，枚举可以让其每个枚举值实现接口。
 */
public class EnumIml {
    public static void main(String[] args) {
        for (Color color : Color.values()) {
            color.setColor();
            color.setType();
        }
    }

    interface Paint {
        public void setColor();

        public void setType();
    }

    public enum Color implements Paint {
        RED("red color", 0) {
            @Override
            public void setColor() {
                System.out.println("Current paint color: " + RED._name);
            }

            @Override
            public void setType() {
                System.out.println("Current paint type: " + "5");
            }
        },
        GREEN("green color", 1) {
            @Override
            public void setColor() {
                System.out.println("Current paint color: " + GREEN._name);
            }

            @Override
            public void setType() {
                System.out.println("Current paint type: " + "1");
            }
        },

        BLUE("blue color", 2) {
            @Override
            public void setColor() {
                System.out.println("Current paint color: " + BLUE._name);
            }

            @Override
            public void setType() {
                System.out.println("Current paint type: " + "12");
            }
        },
        YELLOW("yellow color", 3) {
            @Override
            public void setColor() {
                System.out.println("Current paint color: " + YELLOW._name);
            }

            @Override
            public void setType() {
                System.out.println("Current paint type: " + "80");
            }
        };

        Color(String name, int id) {
            _name = name;
            _id = id;
        }

        private String _name;
        private int _id;

        public String getName() {
            return _name;
        }

        public int getId() {
            return _id;
        }
    }
}

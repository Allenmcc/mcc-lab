package enumTest;

/**
 * Created by danny on 15/12/17.
 */
public class testEnum {
    public enum Color {
        RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
        // 成员变量
        private String name;
        private int index;

        // 构造方法
        private Color(String name, int index) {
            this.name = name;
            this.index = index;
        }
        public int getIndex(){
            return index;
        }

        public String getName(){
            return name;
        }


        private static Color getColorByIndex(int index){
            for (Color color:values()){
                if(color.getIndex() == index){
                    return color;
                }

            }
            return null;
        }

        // 覆盖方法
        @Override
        public String toString() {
            return this.index + "_" + this.name;
        }
    }

    public static void main(String[] args) {
        System.out.println(Color.RED.toString());
        System.out.println(Color.getColorByIndex(3));
    }
}

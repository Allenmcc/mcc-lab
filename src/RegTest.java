import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by danny on 16/1/5.
 */
public class RegTest {
    public static void main(String arg[]){
//         按指定模式在字符串查找
//        String line = "This order w312as placed for QT30001! OK?";
////        String line = "This order w3as placed for ! OK?";
//        String pattern = "(.*)(\\d+)(.*)";
//
//        // 创建 Pattern 对象
//        Pattern r = Pattern.compile(pattern);
//
//        // 现在创建 matcher 对象
//        Matcher m = r.matcher(line);
//        if (m.find( )) {
//            System.out.println("Found value: " + m.group(0) );
//            System.out.println("Found value: " + m.group(1) );
//            System.out.println("Found value: " + m.group(2) );
//            System.out.println("Found value: " + m.group(3) );
//        } else {
//            System.out.println("NO MATCH");
//        }
        Pattern pattern = Pattern.compile("^\\d+\\s*(\\s*,?\\s*\\d+)*,?\\s*$");
        Pattern pattern2 = Pattern.compile("^\\d+\\s*(\\s*,?\\s*\\d+)*,?\\s*$");
//        Pattern pattern = Pattern.compile("^\\d+\\s*(\\s*,\\s*\\d+)*,?$");

        Matcher matcher = pattern.matcher("2396591 44010008, 33");
//        System.out.println(matcher.matches());
        System.out.println(pattern.matches("b*g","bbg"));
        System.out.println(pattern.matches("^(/diff\\.jsp).*","/menus/home"));
        System.out.println(pattern.matches("^\\D*/static/\\D*$","/menus/static/head.js"));
//        System.out.println(pattern.matches("[0-9]{6}"));

    }
}

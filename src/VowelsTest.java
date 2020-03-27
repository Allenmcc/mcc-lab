//import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
//
///**
// * Created by danny on 16/4/23.
// */
//public class VowelsTest {
//
//    public static void main(String arg[]){
//
//        System.out.println(reverseVowels("hello"));
//
//    }
//    public static String reverseVowels(String s) {
//
//        char[] chars = s.toCharArray();
//        int l = 0, r = chars.length-1;
//        while (l < r) {
//            while (l < r && !isInVowelStr(chars[l])) {
//                l++;
//            }
//            while (l < r && !isInVowelStr(chars[r])) {
//                r--;
//            }
//            char tmp = chars[l];
//            chars[l++] = chars[r];
//            chars[r--] = tmp;
//        }
//        return new String(chars);
//
//
//    }
//
//    public static boolean isInVowelStr(char a){
//        char[] vowelStr = {'a','e','i','o','u'};
//        for(int i=0;i<vowelStr.length;i++){
//            if(vowelStr[i]==a)
//                return true;
//        }
//        return false;
//
//    }
//}

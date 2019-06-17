package aes;

/**
 * Created by chunchen.meng on 2019/4/10.
 */
public class Checker {
    public static void main(String[] args) throws Exception {
        // 创建加解密
        AESencrp aes = new AESencrp();
        // 要进行加密的密码
        String password = "password^*(&( 09-8ADF";
        // 进行加密后的字符串
        String passwordEnc = aes.encrypt(password);
        String passwordDec = aes.decrypt(passwordEnc);
        System.out.println("原来的密码 : " + password);
        System.out.println("加密后的密码 : " + passwordEnc);
        System.out.println("解密后的原密码 : " + passwordDec);
    }
}

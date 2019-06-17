package aes;

/**
 * Created by chunchen.meng on 2019/4/10.
 */

        import javax.crypto.Cipher;
        import javax.crypto.spec.IvParameterSpec;
        import javax.crypto.spec.SecretKeySpec;

        import sun.misc.BASE64Decoder;
        import sun.misc.BASE64Encoder;

/**
 * 实现AES加密解密
 * cg882
 * 2016-11-16
 */
public class AESencrp {

    // 加密算法
    private String ALGO = "AES";
    private String ALGO_MODE = "AES/CBC/NoPadding";
    private String akey = "1234567890123456";   //16bit
    private String aiv = "1234567890123456";      //16bit


    /**
     * 用来进行加密的操作
     *
     * @param Data
     * @return
     * @throws Exception
     */
    public String encrypt(String Data) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(ALGO_MODE);
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = Data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

            SecretKeySpec keyspec = new SecretKeySpec(akey.getBytes("utf-8"), ALGO);
            IvParameterSpec ivspec = new IvParameterSpec(aiv.getBytes("utf-8"));
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            String EncStr = new sun.misc.BASE64Encoder().encode(encrypted);
            return EncStr ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 用来进行解密的操作
     *
     * @param encryptedData
     * @return
     * @throws Exception
     */
    public String decrypt(String encryptedData) throws Exception {
        try {
            byte[] encrypted1 = new sun.misc.BASE64Decoder().decodeBuffer(encryptedData);

            Cipher cipher = Cipher.getInstance(ALGO_MODE);
            SecretKeySpec keyspec = new SecretKeySpec(akey.getBytes("utf-8"), ALGO);
            IvParameterSpec ivspec = new IvParameterSpec(aiv.getBytes("utf-8"));

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

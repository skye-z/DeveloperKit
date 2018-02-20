package cc.stacks.developer;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * 安全工具
 *
 * @author sKai-Zhang <skai-zhang@hotmail.com>
 * @copyright CopyRight 2015-2018 sKai-Zhang All Rights Reserved.
 * @license ZPL
 */
@SuppressWarnings("all")
public class Security {

    // Base64 编码
    public static String Base64Encode(String Message) {
        byte[] EncodeBytes = Base64.getEncoder().encode(Message.getBytes());
        return new String(EncodeBytes);
    }

    // Base64 解码
    public static String Base64Decode(String Message) {
        byte[] DecodeBytes = Base64.getDecoder().decode(Message.getBytes());
        return new String(DecodeBytes);
    }

    // MD5 加密
    public static String MD5Encode(String Message) {
        return DigestUtils.md5Hex(Message);
    }

    // SHA 加密
    public static String SHAEncode(String Message) {
        return DigestUtils.sha256Hex(Message);
    }

    // 密钥生成器
    public static String KeyGenerator(String Type, int Long) {
        try {
            // 创建密钥生成器对象
            KeyGenerator keyGenerator = KeyGenerator.getInstance(Type);
            // 指定密钥长度
            keyGenerator.init(Long);
            // 生成密钥
            SecretKey SecretKey = keyGenerator.generateKey();
            // 转换16进制
            return Hex.encodeHexString(SecretKey.getEncoded());
        } catch (Exception e) {
            return null;
        }
    }

    // 对称算法加密
    public static String SymmetricEncode(String Type, String Message, String Key) {
        try {
            // 创建加密对象
            Cipher cipher = Cipher.getInstance(Type + "/ECB/PKCS5Padding");
            if (Type.equals("DES")) {
                // 创建密钥工厂
                SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(Type);
                // 创建密钥转换器
                DESKeySpec DesKeySpec = new DESKeySpec(Hex.decodeHex(Key.toCharArray()));
                // 初始化加密对象
                cipher.init(Cipher.ENCRYPT_MODE, secretKeyFactory.generateSecret(DesKeySpec));
            } else if (Type.equals("AES")) {
                // 初始化加密对象
                cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(Hex.decodeHex(Key.toCharArray()), "AES"));
            }
            // 执行加密操作
            byte[] resultBytes = cipher.doFinal(Message.getBytes());
            // 转换16进制
            return Hex.encodeHexString(resultBytes);
        } catch (Exception e) {
            return null;
        }
    }

    // 对称算法解密
    public static String SymmetricDecode(String Type, String Message, String Key) {
        try {
            // 创建解密对象
            Cipher cipher = Cipher.getInstance(Type + "/ECB/PKCS5Padding");
            if (Type.equals("DES")) {
                // 创建密钥转换器
                DESKeySpec DesKeySpec = new DESKeySpec(Hex.decodeHex(Key.toCharArray()));
                // 创建密钥工厂
                SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(Type);
                // 初始化解密对象
                cipher.init(Cipher.DECRYPT_MODE, secretKeyFactory.generateSecret(DesKeySpec));
            } else if (Type.equals("AES")) {
                // 初始化加密对象
                cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(Hex.decodeHex(Key.toCharArray()), "AES"));
            }
            // 还原进制
            byte[] result = Hex.decodeHex(Message.toCharArray());
            // 执行解密操作
            return new String(cipher.doFinal(result));
        } catch (Exception e) {
            return null;
        }
    }


    public static void main(String[] args) {
        long StartTime = System.currentTimeMillis();
        String Base64Test = Base64Encode("这是一段测试内容");
        System.out.println("Base64编码: " + Base64Test);
        System.out.println("Base64解码: " + Base64Decode(Base64Test));
        long EndTime = System.currentTimeMillis();
        System.out.println("Base64耗时: " + (EndTime - StartTime) + "毫秒" + "\n");

        StartTime = System.currentTimeMillis();
        System.out.println("MD5加密: " + MD5Encode("这是一段测试内容"));
        EndTime = System.currentTimeMillis();
        System.out.println("MD5耗时: " + (EndTime - StartTime) + "毫秒" + "\n");

        StartTime = System.currentTimeMillis();
        System.out.println("SHA加密: " + SHAEncode("这是一段测试内容"));
        EndTime = System.currentTimeMillis();
        System.out.println("SHA耗时: " + (EndTime - StartTime) + "毫秒" + "\n");

        StartTime = System.currentTimeMillis();
        String DESKey = KeyGenerator("DES", 56);
        String DESTest = SymmetricEncode("DES", "这是一段测试内容", DESKey);
        System.out.println("DES密钥: " + DESKey);
        System.out.println("DES加密: " + DESTest);
        System.out.println("DES解密: " + SymmetricDecode("DES", DESTest, DESKey));
        EndTime = System.currentTimeMillis();
        System.out.println("DES耗时: " + (EndTime - StartTime) + "毫秒" + "\n");

        StartTime = System.currentTimeMillis();
        String AESKey = KeyGenerator("AES", 128);
        String AESTest = SymmetricEncode("AES", "这是一段这是一段测试内容测试内容", AESKey);
        System.out.println("AES密钥: " + AESKey);
        System.out.println("AES加密: " + AESTest);
        System.out.println("AES解密: " + SymmetricDecode("AES", AESTest, AESKey));
        EndTime = System.currentTimeMillis();
        System.out.println("AES耗时: " + (EndTime - StartTime) + "毫秒" + "\n");

    }

}

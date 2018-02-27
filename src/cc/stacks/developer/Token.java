package cc.stacks.developer;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * 身份令牌工具
 *
 * @author sKai-Zhang <skai-zhang@hotmail.com>
 * @copyright CopyRight 2015-2018 sKai-Zhang All Rights Reserved.
 * @license ZPL
 */
@SuppressWarnings("all")
public class Token {

    // 账户信息
    private Map<String, String> Account;

    // 授权地址
    private String Ip;

    // 签发单位
    private Issuer Issuer;

    public Token(){}

    public Token(Map<String, String> Account, String Ip, String Name, int Term) {
        this.Account = Account;
        this.Ip = Ip;
        this.Issuer = new Issuer(Name, Term);
    }

    // 构建
    public String Bulid(String Key) {
        try {
            // 构建JSON解析对象
            Gson gson = new Gson();
            // 加密数据
            String AESCode = Security.SymmetricEncode("AES", gson.toJson(this), Key);
            // 混淆密文
            return Security.Base64Encode(AESCode + "." + Security.MD5Encode(AESCode));
        } catch (Exception e) {
            return null;
        }
    }

    // 解析
    public Token Analysis(String Code, String Key) {
        try {
            // 构建JSON解析对象
            Gson gson = new Gson();
            // Base64解码
            String Base64Code = Security.Base64Decode(Code);
            // 分割AES密码
            String AESCode = Base64Code.substring(0, Base64Code.indexOf("."));
            // 分割MD5值
            String Md5Code = Base64Code.substring(Base64Code.indexOf(".") + 1, Base64Code.length());
            // 判断数据是否正确
            if (Security.MD5Encode(AESCode).equals(Md5Code)) {
                // 解密数据
                return gson.fromJson(Security.SymmetricDecode("AES", AESCode, Key),Token.class);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String AESKey = Security.KeyGenerator("AES", 128);
        Map<String, String> Account = new HashMap<>();
        Account.put("Id", "1");
        Account.put("Name", "Name");
        Account.put("Identity", "2");
        Token token = new Token(Account, "192.168.0.1", "Stacks.CC", 86400);
        String TokenCode = token.Bulid(AESKey);
        token = token.Analysis(TokenCode,AESKey);
        System.out.println(token);
        System.out.println(TokenCode);
    }

}

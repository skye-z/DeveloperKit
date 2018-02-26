package cc.stacks.developer;

import java.util.Random;

/**
 * 字符串处理工具
 *
 * @author sKai-Zhang <skai-zhang@hotmail.com>
 * @copyright CopyRight 2015-2018 sKai-Zhang All Rights Reserved.
 * @license ZPL
 */
@SuppressWarnings("all")
public class StringManipulation {

    public static String RandomBulid(int StringLength) {
        // 创建字符串构建对象
        StringBuffer Bulid = new StringBuffer();
        // 创建字符串种子
        String Seed = "abcdefghijklmnopqrstuvwxyz1234567890";
        // 获取种子长度
        int Length = Seed.length();
        // 遍历获取随机字符串
        for (int i = 0; i < StringLength; i++) {
            // 构建字符串
            Bulid.append(Seed.charAt((int)Math.round(Math.random() * (Length - 1))));
        }
        // 返回随机字符串
        return Bulid.toString();
    }

}

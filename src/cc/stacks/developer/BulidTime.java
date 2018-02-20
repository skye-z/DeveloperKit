package cc.stacks.developer;

/**
 * 时间构建工具
 *
 * @author sKai-Zhang <skai-zhang@hotmail.com>
 * @copyright CopyRight 2015-2018 sKai-Zhang All Rights Reserved.
 * @license ZPL
 */
@SuppressWarnings("all")
public class BulidTime {

    public static String TimeStamp(int Length) {
        String Time = String.valueOf(System.currentTimeMillis());
        if (Length < Time.length()) {
            return Time.substring(0, Length);
        } else {
            return null;
        }
    }

    public static String TimeStamp() {
        return String.valueOf(System.currentTimeMillis());
    }

}

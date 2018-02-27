package cc.stacks.developer;

/**
 * 签发单位数据模型
 *
 * @author sKai-Zhang <skai-zhang@hotmail.com>
 * @copyright CopyRight 2015-2018 sKai-Zhang All Rights Reserved.
 * @license ZPL
 */
@SuppressWarnings("all")
public class Issuer {

    // 签发单位名称
    private String Name;

    // 签发时间
    private long Time;

    // 有效期限
    private int Term;

    public Issuer(String Name,int Term){
        this.Name = Name;
        this.Time = System.currentTimeMillis();
        this.Term = Term;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getTime() {
        return Time;
    }

    public void setTime(long time) {
        Time = time;
    }

    public int getTerm() {
        return Term;
    }

    public void setTerm(int term) {
        Term = term;
    }
}

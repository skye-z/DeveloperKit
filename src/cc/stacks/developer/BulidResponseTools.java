package cc.stacks.developer;

import java.io.Serializable;

// 响应构建工具
@SuppressWarnings("all")
public class BulidResponseTools<T> implements Serializable {

    // 响应状态
    private boolean State;

    // 响应信息
    private String Message;

    // 响应数据
    private T Data;

    // 响应时间
    private String Time;

    // 只有响应状态的构造方法
    BulidResponseTools(boolean State) {
        this.State = State;
        this.Time = String.valueOf(System.currentTimeMillis());
    }

    // 有响应状态和信息的构造方法
    BulidResponseTools(boolean State, String Message) {
        this.State = State;
        this.Message = Message;
        this.Time = String.valueOf(System.currentTimeMillis());
    }

    // 有响应状态和数据的构造方法
    BulidResponseTools(boolean State, T Data) {
        this.State = State;
        this.Data = Data;
        this.Time = String.valueOf(System.currentTimeMillis());
    }

    // 有响应状态,信息和数据的构造方法
    BulidResponseTools(boolean State, String Message, T Data) {
        this.State = State;
        this.Data = Data;
        this.Message = Message;
        this.Time = String.valueOf(System.currentTimeMillis());
    }

    // 构造成功简单响应
    public static <T> BulidResponseTools<T> Success() {
        return new BulidResponseTools<T>(true);
    }

    // 构造附带信息的成功响应
    public static <T> BulidResponseTools<T> Success(String Message) {
        return new BulidResponseTools<T>(true, Message);
    }

    // 构造附带数据的成功响应
    public static <T> BulidResponseTools<T> Success(T Data) {
        return new BulidResponseTools<T>(true, Data);
    }

    // 构造附带信息和数据的成功响应
    public static <T> BulidResponseTools<T> Success(String Message, T Data) {
        return new BulidResponseTools<T>(true, Message, Data);
    }

    // 构造成功简单响应
    public static <T> BulidResponseTools<T> Error() {
        return new BulidResponseTools<T>(false);
    }

    // 构造附带信息的成功响应
    public static <T> BulidResponseTools<T> Error(String Message) {
        return new BulidResponseTools<T>(false, Message);
    }

    // 构造附带数据的成功响应
    public static <T> BulidResponseTools<T> Error(T Data) {
        return new BulidResponseTools<T>(false, Data);
    }

    // 构造附带信息和数据的成功响应
    public static <T> BulidResponseTools<T> Error(String Message, T Data) {
        return new BulidResponseTools<T>(false, Message, Data);
    }


}

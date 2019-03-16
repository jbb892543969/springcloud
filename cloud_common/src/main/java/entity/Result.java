package entity;

/**
 * 结果集实体
 *
 * @author jbb
 * @date 2019/3/16
 */
public class Result<T> {
    /** 是否返回成功 */
    private boolean flag;
    /** 返回状态码 */
    private Integer code;
    /** 返回消息 */
    private String message;
    /** 返回数据 */
    private T data;

    public Result(boolean flag, Integer code, String message, T data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Result() {}

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

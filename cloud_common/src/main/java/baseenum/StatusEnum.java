package baseenum;

/**
 * 状态码枚举
 *
 * @author jbb
 * @date 2019/3/16
 */
public enum StatusEnum {
    /** 成功状态码 */
    SUCCESS(20000,"成功"),
    /** 失败状态码 */
    ERROR(20001,"失败"),
    /** 登录错误状态码 */
    LOGINERROR(20002,"用户名密码错误"),
    /** 权限不足状态码 */
    ACCESSERROR(20003,"权限不足"),
    /** 服务调用失败状态码 */
    REMOTERROR(20004,"服务调用失败"),
    /** 操作重复状态码 */
    REERROR(20005, "重复操作"),
    /**
     * 异常状态码
     */
    INNERERROR(20006, "服务器内部代码错误");
    private Integer code;
    private String desc;
    private StatusEnum(Integer code,String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}

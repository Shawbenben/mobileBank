package ccnu.intern.mobilebanktest01.pojo;

public class ResponseBean<T> {
    private T data;
    // 数据状态码
    private Integer code;
    // 数据状态信息提示
    private String msg;
    public ResponseBean() {
        super();
        // TODO Auto-generated constructor stub
    }
    // 数据正常封装
    public ResponseBean(T data) {
        super();
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }
    //  数据异常状态封装
    public ResponseBean(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }


}

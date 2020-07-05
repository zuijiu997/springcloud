package zuijiu997.template.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;


public class GeneralResponse<T>  implements Serializable {
    @JSONField(name = "message")
    private String message;

    @JSONField(name = "code")
    private String code;

    public String getMessage() {
        return message;
    }

    private T data;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

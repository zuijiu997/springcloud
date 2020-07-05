package zuijiu997.springcloud.exceptions;



import org.apache.commons.lang.exception.ExceptionUtils;

import java.text.MessageFormat;

/**
 * Created by ezhnlxx on 2019/4/15.
 */
public class OSGWException extends Exception {
    private String errorCode = "ERROR";

    // 默认http状态码为500内部错误
    protected int statusCode = 500;

    private String detailMessage = "ERROR";

    public OSGWException() {

    }


    public OSGWException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.detailMessage = message;
        this.errorCode = errorCode;
    }

    public OSGWException(String errorCode, String message) {
        super(message);
        this.detailMessage = message;
        this.errorCode = errorCode;
    }

    public OSGWException(int statusCode, String message) {
        super(message);
        this.detailMessage = message;
        this.statusCode = statusCode;
    }

    public OSGWException(String code, Object[] args) {
        super(MessageFormat.format("[EXCEPTION_CODE=" + code + "] ", args));
        errorCode = code;
    }

    public OSGWException(String errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public OSGWException(int statusCode, Throwable cause) {
        super(cause);
        this.statusCode = statusCode;
    }

    public OSGWException(String message) {
        super(message);
        this.detailMessage = message;
    }

    public OSGWException(Throwable cause) {
        super(cause);
    }

    public OSGWException(int statusCode, String errorCode, String message) {
        super(message);
        this.detailMessage = message;
        this.statusCode = statusCode;
        this.errorCode = errorCode;

    }

    public OSGWException(int statusCode, String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.detailMessage = message;
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    public String printStackTraceStr() {
        if (this.getCause() == null) {
            return "";
        }
        return ExceptionUtils.getFullStackTrace(this.getCause());
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }
}

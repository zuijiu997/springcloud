package zuijiu997.springcloud.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import zuijiu997.springcloud.constant.Code;
import zuijiu997.springcloud.constant.HttpStatusCode;
import zuijiu997.template.pojo.GeneralResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> runingtimeException(Exception e) {
        GeneralResponse<String> generalResponse = new GeneralResponse<>();
        generalResponse.setData("");
        generalResponse.setMessage(e.getMessage());
        generalResponse.setCode(String.valueOf(HttpStatusCode.INTERNAL_SERVER_ERROR));
        return new ResponseEntity<>(generalResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package vn.hoidanit.jobhunter.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import vn.hoidanit.jobhunter.domain.RestResponse;

@RestControllerAdvice
// giup xu ly ngoai le mot cach tap trung
public class GlobalException {
    @ExceptionHandler(value = IdInvalidException.class)
    // khi nào có exception thuộc value được gọi thực hiện hàm dưới
    public ResponseEntity<RestResponse<Object>> handleIdException(IdInvalidException idInvalidException) {
        RestResponse<Object> res = new RestResponse<Object>();
        res.setStatusCode(HttpStatus.BAD_REQUEST.value());
        res.setError(idInvalidException.getMessage());
        res.setMessage("error");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

}

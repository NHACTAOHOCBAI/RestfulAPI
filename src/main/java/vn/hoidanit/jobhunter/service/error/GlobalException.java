package vn.hoidanit.jobhunter.service.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// giup xu ly ngoai le mot cach tap trung
public class GlobalException {
    @ExceptionHandler(value = IdInvalidException.class)
    // khi nào có exception thuộc value được gọi thực hiện hàm dưới
    public ResponseEntity<String> handleIdException(IdInvalidException idInvalidException) {
        return ResponseEntity.badRequest().body(idInvalidException.getMessage());
    }

}

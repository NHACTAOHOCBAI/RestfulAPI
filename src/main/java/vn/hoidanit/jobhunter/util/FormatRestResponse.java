package vn.hoidanit.jobhunter.util;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import jakarta.servlet.http.HttpServletResponse;

import vn.hoidanit.jobhunter.domain.RestResponse;

@ControllerAdvice
// @ControllerAdvice: Giúp lớp này tác động lên tất cả controller trong ứng
// dụng.
// ResponseBodyAdvice: Cho phép thay đổi dữ liệu phản hồi (response body) trước
// khi gửi về client.

public class FormatRestResponse implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    // kiem tra khi nao can thiep doi voi response
    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response) {
        HttpServletResponse servletResponse = ((ServletServerHttpResponse) response).getServletResponse();
        int status = servletResponse.getStatus();
        // lay trang thai cua phan hoi
        if (body instanceof String)
            return body;
        if (status >= 400) {
            return body;
            // neu sai tra ve body
        } else {
            RestResponse<Object> res = new RestResponse<Object>();
            res.setStatusCode(status);
            res.setData(body);
            res.setMessage("Call  API Success");
            return res;
            // neu hop ly thi format
        }
    }

}

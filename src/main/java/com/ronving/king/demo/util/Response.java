package com.ronving.king.demo.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Data
public class Response<T> implements Serializable {

    @Setter(AccessLevel.NONE)
    private Status status;
    private T body;
    private String message;
    private LocalDateTime dateTime;

    public Response(Status status, String message) {
        this(status, null, message);
    }

    public Response(Status status, T body, String message) {
        setStatus(status);
        this.body = body;
        this.message = message;
        this.dateTime = LocalDateTime.now(ZoneOffset.UTC);
    }


    public void setStatus(Status status) {
        this.status = status;
        HttpServletResponse httpServletResponse = getHttpServletResponse();
        if (httpServletResponse != null) {
            httpServletResponse.setStatus(status.value());
        }
    }

    private HttpServletResponse getHttpServletResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        }
        return requestAttributes.getResponse();
    }

}

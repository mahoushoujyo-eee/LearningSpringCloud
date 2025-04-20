package org.eee.order.param;

import lombok.Data;

@Data
public class Response<T>
{
    private Integer code;
    private String message;
    private T data;

    public static <T> Response<T> success(T data)
    {
        Response<T> response = new Response<>();
        response.setCode(0);
        response.setMessage("成功");
        response.setData(data);
        return response;
    }

    public static <T> Response<T> fail(Integer code, String message)
    {
        Response<T> response = new Response<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}

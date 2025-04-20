package org.eee.order.handler;


import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eee.order.param.Response;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

@Component
public class ExceptionHandler implements BlockExceptionHandler
{
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String s, BlockException e) throws Exception
    {
        httpServletResponse.setContentType("application/json;charset=UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        PrintWriter printWriter = httpServletResponse.getWriter();

        Response<Boolean> response = Response.fail(500, "服务降级");

        printWriter.write(objectMapper.writeValueAsString(response));
        printWriter.flush();
    }
}

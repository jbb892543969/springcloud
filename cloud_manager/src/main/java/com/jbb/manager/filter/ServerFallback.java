package com.jbb.manager.filter;

import baseenum.StatusEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Result;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 路由故障回退
 *
 * @author jbb
 * @date 2019/3/25
 */
@Component
public class ServerFallback implements FallbackProvider {
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders;
            }

            @Override
            public InputStream getBody() throws IOException {
                Result result = new Result(false, StatusEnum.REMOTERROR.getCode(), "服务调用失败");
                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(result);
                return new ByteArrayInputStream(json.getBytes("UTF-8"));
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }
        };
    }
}

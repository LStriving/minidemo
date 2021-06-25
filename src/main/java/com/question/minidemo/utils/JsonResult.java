package com.question.minidemo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult<T> {
    private String status;//返回的事件消息；如10000：成功，20000：失败
    private T data;
}

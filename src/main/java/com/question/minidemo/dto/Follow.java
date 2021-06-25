package com.question.minidemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Follow {
    private String uid;
    private String pid;
    private String time;
}

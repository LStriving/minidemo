package com.question.minidemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
public class Answer {
    private String aid;
    private String content;
    private String pid;
    private String uid;
    private int like=0;
    private String time;
    public Answer(String aid,String content,String pid,String uid){
        setAid(aid);
        setContent(content);
        setPid(pid);
        setUid(uid);
        setLike(0);
        //set Time
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        setTime(ft.format(new Date()));
    }

}

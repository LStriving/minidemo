package com.question.minidemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
public class Comment {
    private String pid;
    private String uid;
    private String cid;
    private String cid_p;
    private String time;
    private String content;
    public Comment(String cid, String content, String pid, String uid, String cid_p){
        setCid(cid);
        setContent(content);
        setCid_p(cid_p);
        setPid(pid);
        setUid(uid);
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        setTime(ft.format(new Date()));
    }
}

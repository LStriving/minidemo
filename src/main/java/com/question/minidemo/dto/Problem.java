package com.question.minidemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
public class Problem {
    private String uid;
    private String pid;
    private int status=0;
    private String content;
    private String tag;
    private int bill;//悬赏学币额度
    private int ans_num=0;
    private String title;
    private String time;
    //related problem 怎么处理？？
    public void publishPro(String pid,String uid,String content,int bill,String tag,String title){
        setPid(pid);
        setTag(tag);
        setUid(uid);
        setBill(bill);
        setContent(content);
        setTitle(title);
        //set time
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        setTime(ft.format(new Date()));
    }
}

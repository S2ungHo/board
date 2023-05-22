package com.study.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController{
    @GetMapping("/board/write")//어떤 url로 접근할건지에 대해 지정해주는 어노테이션 (localhost:8080/board/write 접속)
    public String boardWriteForm(){

        return "boardwrite"; //boardwrite로 보내줌 (어떤 뷰 파일로 보내줄지)
    }
}
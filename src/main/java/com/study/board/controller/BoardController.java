package com.study.board.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController{

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")//어떤 url로 접근할건지에 대해 지정해주는 어노테이션 (localhost:8080/board/write 접속)
    public String boardWriteForm(){

        return "boardwrite"; //boardwrite로 보내줌 (어떤 뷰 파일로 보내줄지)
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board){

        boardService.write(board);

        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){

        model.addAttribute("list",boardService.boardList());
        return "boardlist";
    }

    //localhost:8080/board/view?id=1
    @GetMapping("/board/view")
    public String boardView(Model model, Integer id){

        model.addAttribute("board", boardService.boardView(id));

        return "boardview";
    }

    //특정게시글 삭제
    @GetMapping("/board/delete")
    public String boardDelete(Integer id){
        boardService.boardDelete(id);

        return "redirect:/board/list"; //삭제하고 가지는 페이지 리턴 값으로 설정
    }

}
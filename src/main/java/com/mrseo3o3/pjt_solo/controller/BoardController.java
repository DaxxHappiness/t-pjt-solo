package com.mrseo3o3.pjt_solo.controller;

import com.mrseo3o3.pjt_solo.domain.dto.BoardDto;
import com.mrseo3o3.pjt_solo.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardServiceImpl boardService;

    @GetMapping("/list")
    public String getBoardList(Model model) {
        List<BoardDto> boardList = this.boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "board/boardList";
    }

}

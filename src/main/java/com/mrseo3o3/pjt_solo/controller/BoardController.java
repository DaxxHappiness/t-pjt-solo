package com.mrseo3o3.pjt_solo.controller;

import com.mrseo3o3.pjt_solo.domain.dto.BoardDto;
import com.mrseo3o3.pjt_solo.domain.dto.Pagination;
import com.mrseo3o3.pjt_solo.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardServiceImpl boardService;

    @GetMapping("/list")
    public String getBoardList(Integer page, Integer pageSize, Model model) {
        if (page==null) page = 1;
        if (pageSize==null) pageSize = 10;

        int totalCnt = boardService.getCount();
        Pagination paging = new Pagination(totalCnt, page, pageSize);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("offset", (page-1) * pageSize);
        map.put("pageSize", pageSize);
        List<BoardDto> boardList = this.boardService.getBoardList(map);
        model.addAttribute("boardList", boardList);
        model.addAttribute("paging", paging);
        return "board/boardList";
    }

    @GetMapping("/write")
    public String boardWriteForm() {
        return "board/boardWrite";
    }

    @PostMapping("/write")
    public String addBoard(BoardDto boardDto, Model model) {
        if (boardDto == null) {
            model.addAttribute("boardDto", boardDto);
            return "redirect:/board/write";
        }
        return "redirect:/board/list";
    }

    @GetMapping("/read")
    public String boardRead(Long bno, Model model) {
        System.out.println("boardRead()");
        BoardDto boardDto = boardService.getBoardOne(bno);
        model.addAttribute("boardDto", boardDto);
        return "board/board";
    }

}

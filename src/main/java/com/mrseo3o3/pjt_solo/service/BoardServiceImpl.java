package com.mrseo3o3.pjt_solo.service;

import com.mrseo3o3.pjt_solo.domain.dto.BoardDto;
import com.mrseo3o3.pjt_solo.repository.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl {

    private final BoardDao boardDao;

    @Autowired
    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public List<BoardDto> getBoardList() {
        List<BoardDto> list = this.boardDao.getList();
        System.out.println("list: "+list);
        return list;
    }


}

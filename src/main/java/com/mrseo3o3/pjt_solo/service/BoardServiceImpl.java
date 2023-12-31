package com.mrseo3o3.pjt_solo.service;

import com.mrseo3o3.pjt_solo.domain.dto.BoardDto;
import com.mrseo3o3.pjt_solo.repository.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl {

    private final BoardDao boardDao;

    @Autowired
    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public int getCount() {
        return this.boardDao.count();
    }

    public List<BoardDto> getList() {
        List<BoardDto> list = this.boardDao.getList();
        System.out.println("list: "+list);
        return list;
    }

    public List<BoardDto> getBoardList(Map map) {
        List<BoardDto> list = this.boardDao.getBoardList(map);
        System.out.println("list: "+list);
        return list;
    }

    public BoardDto getBoardOne(Long bno) {
        System.out.println("getBoard: "+this.boardDao.getBoard(bno));
        return this.boardDao.getBoard(bno);
    }


}

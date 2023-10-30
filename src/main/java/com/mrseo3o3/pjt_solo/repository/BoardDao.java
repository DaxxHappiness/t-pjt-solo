package com.mrseo3o3.pjt_solo.repository;

import com.mrseo3o3.pjt_solo.domain.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardDao {

    @Delete("truncate TABLE board")
    void deleteAllBoard();

    @Select("select * from board")
    List<BoardDto> getList();

    @Insert("INSERT INTO board " +
            "(`subject`,`content`,`author`,`reg_date`) " +
            "VALUES " +
            "(#{board.subject}, #{board.content}, #{board.author}, now())")
    int addBoard(@Param("board") BoardDto boardDto);
}

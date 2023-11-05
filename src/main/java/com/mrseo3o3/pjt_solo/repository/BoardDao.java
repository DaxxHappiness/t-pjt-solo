package com.mrseo3o3.pjt_solo.repository;

import com.mrseo3o3.pjt_solo.domain.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardDao {

    @Delete("truncate TABLE board")
    void deleteAllBoard();

    @Select("select count(*) from board")
    int count();

    @Select("select * from board order by bno desc")
    List<BoardDto> getList();

    @Select("select * from board order by bno desc limit #{map.offset}, #{map.pageSize}")
    List<BoardDto> getBoardList(@Param("map") Map map);

    @Insert("INSERT INTO board " +
            "(`subject`,`content`,`author`,`reg_date`) " +
            "VALUES " +
            "(#{board.subject}, #{board.content}, #{board.author}, now())")
    int addBoard(@Param("board") BoardDto boardDto);

    @Select("select * from board where bno = #{bno}")
    BoardDto getBoard(Long bno);
}

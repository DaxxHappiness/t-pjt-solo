package com.mrseo3o3.pjt_solo;

import com.mrseo3o3.pjt_solo.domain.dto.BoardDto;
import com.mrseo3o3.pjt_solo.repository.BoardDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
class PjtSoloApplicationTests {

    @Autowired
    BoardDao boardDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void insertTestData() {
        boardDao.deleteAllBoard();
        for (int i=1; i<=220; i++) {
            BoardDto boardDto = new BoardDto("test" + i, "test content" + i, "testman" + i);
            boardDao.addBoard(boardDto);
        }
    }

}

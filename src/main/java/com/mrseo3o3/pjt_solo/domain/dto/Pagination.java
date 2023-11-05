package com.mrseo3o3.pjt_solo.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pagination {
    private int totalBoardCnt;
    private int pageSize;
    private int naviSize = 10;
    private int totalPageCnt;
    private int page;
    private int beginPage;
    private int endPage;
    private boolean showPrev;
    private boolean showNext;

    public Pagination(int totalBoardCnt, int page) {
        this(totalBoardCnt, page, 10);
    }

    public Pagination(int totalBoardCnt, int page, int pageSize) {
        this.totalBoardCnt = totalBoardCnt;
        this.pageSize = pageSize;
        this.page = page;

        totalPageCnt = (int)Math.ceil((double)totalBoardCnt / pageSize);
        beginPage = (page - 1) / 10 * 10 + 1;
        endPage = Math.min(beginPage + 10 - 1, totalPageCnt);
        showPrev = beginPage != 1;
        showNext = endPage != totalPageCnt;
    }

    void print() {
        System.out.println("page: "+page);
        System.out.print(showPrev ? "< " : "");
        for (int i = beginPage; i<=endPage; i++) {
            System.out.print(i+" ");
        }
        System.out.println(showNext ? ">" : "");

    }
}

package io.ahakim.crud.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
@NoArgsConstructor
public class PageMaker {

    private int total;
    private int totalPage;

    private int pageRange;
    private int rangeStart, rangeEnd;
    private boolean prev, next;

    private Criteria criteria;

    public PageMaker(int total, Criteria criteria) {
        this.total = total;
        this.criteria = criteria;
        
        calculate(criteria.getPage(), criteria.getRowSize());
    }

    private void calculate(int page, int rowSize) {
        this.totalPage = (int) Math.ceil((double) total / criteria.getRowSize());
        this.pageRange = Math.max(5, pageRange);
        this.rangeStart = Math.floorDiv((page - 1), pageRange) * pageRange + 1;
        this.rangeEnd = Math.min((rangeStart + (pageRange - 1)), totalPage);
        this.prev = rangeStart > 1;
        this.next = rangeEnd != totalPage;
    }
}

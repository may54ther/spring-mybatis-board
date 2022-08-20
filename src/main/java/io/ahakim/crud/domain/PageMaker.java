package io.ahakim.crud.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PageMaker {

    private int total;
    private int totalPage;

    private int pageRange;
    private int rangeStart, rangeEnd;
    private boolean prev, next;

    private Criteria criteria;

    public PageMaker(int total, Criteria criteria) {
        this(total, 5, criteria);
    }

    public PageMaker(int total, int pageRange, Criteria criteria) {
        this.total = total;
        this.criteria = criteria;
        this.pageRange = 5;

        calculate(criteria.getPage(), criteria.getRowSize());
    }

    private void calculate(int page, int rowSize) {
        this.totalPage = (int) Math.ceil((double) total / rowSize);
        this.rangeStart = Math.floorDiv((page - 1), pageRange) * pageRange + 1;
        this.rangeEnd = Math.min((rangeStart + (pageRange - 1)), totalPage);
        this.prev = rangeStart > 1;
        this.next = rangeEnd != totalPage;
    }
}

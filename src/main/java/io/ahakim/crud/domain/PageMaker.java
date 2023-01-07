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

    private int rangeStart;

    private int rangeEnd;

    private boolean prev;

    private boolean next;

    private Criteria criteria;

    public PageMaker(int total, Criteria criteria) {
        this.total = total;
        this.criteria = criteria;

        calculate();
    }

    private void calculate() {
        this.totalPage = (int) Math.ceil((double) total / criteria.getSize());
        this.pageRange = Math.max(5, pageRange);
        this.rangeStart = Math.floorDiv((criteria.getPage() - 1), pageRange) * pageRange + 1;
        this.rangeEnd = Math.min((rangeStart + (pageRange - 1)), totalPage);
        this.prev = rangeStart > 1;
        this.next = rangeEnd != totalPage;
    }
}

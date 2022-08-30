package io.ahakim.crud.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {

    private int page;
    private int rowSize;

    public Criteria() {
        this(1, 10);
    }

    public Criteria(int page, int rowSize) {
        this.page = page > 0 ? page : 1;
        this.rowSize = Math.max(rowSize, 10);
    }

    public int getStartRow() {
        return (this.page - 1) * this.rowSize;
    }
}

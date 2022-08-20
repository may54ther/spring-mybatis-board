package io.ahakim.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Criteria {

    private int page;
    private int rowSize;

    public Criteria() {
        this(1, 10);
    }

    public void setPage(int page) {
        this.page = page > 0 ? page : 1;
    }

    public void setRowSize(int rowSize) {
        this.rowSize = Math.max(rowSize, 10);
    }

    public int getStartRow() {
        return (this.page - 1) * this.rowSize;
    }
}

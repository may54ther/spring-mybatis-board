package io.ahakim.crud.domain;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Criteria {

    private int page;
    private int size;

    public Criteria() {
        this(1, 10);
    }

    public Criteria(int page, int size) {
        this.page = page > 0 ? page : 1;
        this.size = Math.max(size, 10);
    }

    public int getStartRow() {
        return (this.page - 1) * this.size;
    }

}

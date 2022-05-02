package net.skhu.dto;

import lombok.Data;

@Data
public class Pagination {
    int pg = 1;        // 현재 페이지. 디폴트 값은 1
    int sz = 15;       // 페이지 당 레코드 수. 디폴트 값은 15
    int recordCount;   // 전체 레코드 수

    public String getQueryString() {
        return String.format("pg=%d&sz=%d", pg, sz);
    }
}

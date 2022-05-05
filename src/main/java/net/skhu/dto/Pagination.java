package net.skhu.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import lombok.Data;

@Data
public class Pagination {

    int pg = 1;        // 현재 페이지. 디폴트 값은 1
    int sz = 15;       // 페이지 당 레코드 수. 디폴트 값은 15
    int si = 0;        // 검색 조건
    int od = 0;        // 정렬 순서
    int bd = 0;        // 게시판ID
    String st = "";    // 검색 키워드
    int recordCount;   // 전체 레코드 수

    public String getQueryString() {

        try {
            return String.format("pg=%d&sz=%d&si=%d&od=%d&bd=%d&st=%s", pg, sz, si, od, bd,
                    URLEncoder.encode(st, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;

    }

}

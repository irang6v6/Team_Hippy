package net.skhu.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import lombok.Data;

@Data
public class Pagination {
    int pg = 1;        // 현재 페이지
    int sz = 15;       // 페이지 당 레코드 수
    int si = 0;        // 검색 조건
    int od = 0;        // 정렬 순서
    int bd = 0;        // 게시판ID
    String st = "";
    int di = 0;        // locationId
    int ti = 0;        // tagId
    int mi = 0;        // moodId
    int pi = 0;        // partyId
    int recordCount;   // 전체 레코드 수


    public String getQueryString() {
        try {
            return String.format("pg=%d&sz=%d&di=%d&ti=%d&mi=%d&pi=%d&si=%d&od=%d&bd=%d&st=%s", pg, sz, di, ti, mi, pi, si, od, bd,
                    URLEncoder.encode(st, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}


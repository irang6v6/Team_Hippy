package net.skhu.model;

import java.util.Date;

import lombok.Data;

@Data
public class TravelsDto {
    int id;
    int no;
    String title;
    String userId;
    Date travels_regdate;
    String travels_content;
}

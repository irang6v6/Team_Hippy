package net.skhu.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TravelsDto {
    int id;
    int no;
    String title;
    String userName;
    Date modifiedTime;
    String body;
}


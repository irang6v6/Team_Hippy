package net.skhu.model;

import java.util.Date;

import lombok.Data;

@Data
public class ArticleDto {
    int id;
    int no;
    String title;
    String userName;
    String userNickName;
    Date modifiedTime;
    String body;
    int locationId;
    int tagId;
    int moodId;
    int partyId;
}


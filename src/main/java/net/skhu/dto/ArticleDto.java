package net.skhu.dto;

import java.util.Date;
import lombok.Data;

@Data
public class ArticleDto {
	
	int id;
	int no;
	String title;
	Date modifiedTime;
	String body;
	
}

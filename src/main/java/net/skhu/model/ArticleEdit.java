package net.skhu.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ArticleEdit {
    int id;
    int boardId;

    @NotEmpty(message="제목을 입력하세요")
    @Size(min=1, max=200)
    String title;

    @NotEmpty(message="본문을 입력하세요")
    String body;
}

package net.skhu.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>  {

    Page<Article> findByBoardId(int boardId, Pageable pageable);
    Page<Article> findByBoardIdAndUserNameStartsWith(int boardId, String userName, Pageable pageable);
    Page<Article> findByBoardIdAndTitleContains(int boardId, String title, Pageable pageable);
}


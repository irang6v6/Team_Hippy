package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.dto.Pagination;
import net.skhu.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>  {

    public default List<Article> findAll(Pagination pagination){
    	
    	Page<Article> page = this.findAll(PageRequest.of(pagination.getPg() - 1,
    								pagination.getSz(), Sort.Direction.ASC, "id"));
    	pagination.setRecordCount((int)page.getTotalElements());
    	
    	return page.getContent();
    }
}

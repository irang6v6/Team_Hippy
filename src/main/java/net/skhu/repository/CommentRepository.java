package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Comment;
import net.skhu.model.Pagination;

public interface CommentRepository extends JpaRepository<Comment, Integer>  {
	 Page<Comment> findByArticleId(int articleId, Pageable pageable);


	    public default List<Comment> findByArticleId(int id,Pagination pagination) {
	        Page<Comment> page = this.findByArticleId(id,PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
	                                           Sort.Direction.ASC, "id"));
	        pagination.setRecordCount((int)page.getTotalElements());
	        return page.getContent();
	    }
}


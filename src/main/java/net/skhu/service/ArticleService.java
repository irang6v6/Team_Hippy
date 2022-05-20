package net.skhu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.skhu.config.ModelMapperConfig.MyModelMapper;
import net.skhu.entity.Article;
import net.skhu.entity.Board;
import net.skhu.model.ArticleDto;
import net.skhu.model.ArticleEdit;
import net.skhu.model.Pagination;
import net.skhu.repository.ArticleRepository;
import net.skhu.repository.BoardRepository;

@Service
public class ArticleService {

    @Autowired UserService userService;
    @Autowired ArticleRepository articleRepository;
    @Autowired BoardRepository boardRepository;
    @Autowired MyModelMapper modelMapper;

    private static Sort orderBy = Sort.by(Sort.Direction.DESC, "id");

    public ArticleDto findById(int id) {
        var article = articleRepository.findById(id).get();
        return modelMapper.map(article, ArticleDto.class);
    }

    public ArticleEdit findById2(int id) {
        var article = articleRepository.findById(id).get();
        return modelMapper.map(article, ArticleEdit.class);
    }

    public List<ArticleDto> findAll(Pagination pagination) {
        int pg = pagination.getPg() - 1, sz = pagination.getSz(),
            si = pagination.getSi(), bd = pagination.getBd();
        String st = pagination.getSt();
        var pageRequest = PageRequest.of(pg, sz, orderBy);
        Page<Article> page = null;
        if (si == 1 && pagination.getDi() == 0)
            page = articleRepository.findByBoardIdAndTitleContains(bd, st, pageRequest);
        else if (si == 2 && pagination.getDi() == 0)
            page = articleRepository.findByBoardIdAndUserNameStartsWith(bd, st, pageRequest);
        else if (pagination.getDi() != 0)
        	page = articleRepository. findByLocationIdAndTitleContains(pagination.getDi(),st, pageRequest);
        else
            page = articleRepository.findByBoardId(bd, pageRequest);
        pagination.setRecordCount((int)page.getTotalElements());
        List<Article> articleEntities = page.getContent();
        List<ArticleDto> articleDtos = modelMapper.mapList(articleEntities, ArticleDto.class);
        for (int i = 0; i < articleDtos.size(); ++i) {
            Article article = articleEntities.get(i);
            ArticleDto articleDto = articleDtos.get(i);
            articleDto.setUserName(article.getUser().getName());
        }
        return articleDtos;
    }

    @Transactional
    public int insert(int boardId, ArticleEdit articleEdit) {
        Board board = boardRepository.findById(boardId).get();
        int no = board.getArticleNo() + 1;
        board.setArticleNo(no);
        boardRepository.save(board);

        Article article;
        article = modelMapper.map(articleEdit, Article.class);
        article.setNo(no);
        article.setBoardId(boardId);
        article.setUser(userService.getCurrentUser());
        article.setModifiedTime(new Date());
        articleRepository.save(article);
        return article.getId();
    }

    @Transactional
    public void update(ArticleEdit articleEdit) {
        Article article;
        article = articleRepository.findById(articleEdit.getId()).get();
        article.setTitle(articleEdit.getTitle());
        article.setBody(articleEdit.getBody());
        article.setModifiedTime(new Date());
        articleRepository.save(article);
    }

    public void deleteById(int id) {
        articleRepository.deleteById(id);
    }
}


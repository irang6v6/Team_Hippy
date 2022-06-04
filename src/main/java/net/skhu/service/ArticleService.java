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
import net.skhu.model.Permission;
import net.skhu.repository.ArticleRepository;
import net.skhu.repository.BoardRepository;

@Service
public class ArticleService {

    @Autowired UserService userService;
    @Autowired ArticleRepository articleRepository;
    @Autowired BoardRepository boardRepository;
    @Autowired MyModelMapper modelMapper;

    private static Sort orderBy = Sort.by(Sort.Direction.DESC, "id");
    private static Sort reverseBy = Sort.by(Sort.Direction.ASC, "id");

    public ArticleDto findById(int id) {
        var article = articleRepository.findById(id).get();
        return modelMapper.map(article, ArticleDto.class);
    }


    public ArticleEdit findByIdToEdit(int id)  {
        var article = articleRepository.findById(id).get();
        return modelMapper.map(article, ArticleEdit.class);
    }

    public Permission getCurrentUserPermission() {
        return getCurrentUserPermission(0);
    }

    public Permission getCurrentUserPermission(int articleId) {
        var permission = new Permission();
        permission.setReadGranted(true);
        permission.setCreateGranted(userService.getCurrentUser() != null);

        var article = articleRepository.findById(articleId).orElse(null);
        if (article != null) {
            permission.setUpdateGranted(isCurrentUserAuthor(article));
            permission.setDeleteGranted(userService.isCurrentUserAdmin() || isCurrentUserAuthor(article));
        }
        return permission;
    }

    public boolean isCurrentUserAuthor(Article article) {
        return userService.getCurrentUser() != null &&
               article.getUser().getId() == userService.getCurrentUser().getId();
    }


    public List<ArticleDto> findAll(Pagination pagination) {
        int pg = pagination.getPg() - 1, sz = pagination.getSz(),
            si = pagination.getSi(), bd = pagination.getBd(),
            di = pagination.getDi(), ti = pagination.getTi(),
            mi = pagination.getMi(), pi = pagination.getPi();
        String st = pagination.getSt();
        var pageRequest = PageRequest.of(pg, sz, orderBy);
        Page<Article> page = null;
        if (si == 1 && di == 0 && ti == 0 && mi == 0 && pi == 0)
            page = articleRepository.findByBoardIdAndTitleContains(bd, st, pageRequest);
        else if (si == 1 && di != 0 && ti == 0 && mi == 0 && pi == 0)
        	page = articleRepository. findByLocationIdAndTitleContains(di,st, pageRequest);
        else if (si == 1 && di == 0 && ti != 0 && mi == 0 && pi == 0)
        	page = articleRepository. findByTagIdAndTitleContains(ti,st, pageRequest);
        else if (si == 1 && di == 0 && ti == 0 && mi != 0 && pi == 0)
        	page = articleRepository. findByMoodIdAndTitleContains(mi,st, pageRequest);
        else if (si == 1 && di == 0 && ti == 0 && mi == 0 && pi != 0)
        	page = articleRepository. findByPartyIdAndTitleContains(pi,st, pageRequest);
        else if (si == 1 && di != 0 && ti != 0 && mi == 0 && pi == 0)
        	page = articleRepository. findByLocationIdAndTagIdAndTitleContains(di, ti, st, pageRequest);
        else if (si == 1 && di != 0 && ti == 0 && mi != 0 && pi == 0)
        	page = articleRepository. findByLocationIdAndMoodIdAndTitleContains(di, mi, st, pageRequest);
        else if (si == 1 && di != 0 && ti == 0 && mi == 0 && pi != 0)
        	page = articleRepository. findByLocationIdAndPartyIdAndTitleContains(di, pi, st, pageRequest);
        else if (si == 1 && di != 0 && ti != 0 && mi != 0 && pi == 0)
        	page = articleRepository. findByLocationIdAndTagIdAndMoodIdAndTitleContains(di, ti, mi, st, pageRequest);
        else if (si == 1 && di != 0 && ti != 0 && mi == 0 && pi != 0)
        	page = articleRepository. findByLocationIdAndTagIdAndPartyIdAndTitleContains(di, ti, pi, st, pageRequest);
        else if (si == 1 && di != 0 && ti == 0 && mi != 0 && pi != 0)
        	page = articleRepository. findByLocationIdAndMoodIdAndPartyIdAndTitleContains(di, mi, pi, st, pageRequest);
        else if (si == 1 && di == 0 && ti != 0 && mi != 0 && pi != 0)
        	page = articleRepository. findByTagIdAndMoodIdAndPartyIdAndTitleContains(ti, mi, pi, st, pageRequest);
        else if (si == 1 && di != 0 && ti != 0 && mi != 0 && pi != 0)
        	page = articleRepository. findByLocationIdAndTagIdAndMoodIdAndPartyIdAndTitleContains(di, ti, mi, pi, st, pageRequest);

        else if (si == 2 && di == 0 && ti == 0 && mi == 0 && pi == 0)
            page = articleRepository.findByBoardIdAndUserNameStartsWith(bd, st, pageRequest);
        else if (si == 2 && di != 0 && ti == 0 && mi == 0 && pi == 0)
        	page = articleRepository.findByLocationIdAndUserNameStartsWith(di, st, pageRequest);
        else if (si == 2 && di == 0 && ti != 0 && mi == 0 && pi == 0)
        	page = articleRepository.findByTagIdAndUserNameStartsWith(ti, st, pageRequest);
        else if (si == 2 && di == 0 && ti == 0 && mi != 0 && pi == 0)
        	page = articleRepository.findByMoodIdAndUserNameStartsWith(mi, st, pageRequest);
        else if (si == 2 && di == 0 && ti == 0 && mi == 0 && pi != 0)
        	page = articleRepository.findByMoodIdAndUserNameStartsWith(pi, st, pageRequest);
        else if (si == 2 && di != 0 && ti != 0 && mi == 0 && pi == 0)
        	page = articleRepository.findByLocationIdAndTagIdAndUserNameStartsWith(di, ti, st, pageRequest);
        else if (si == 2 && di != 0 && ti == 0 && mi != 0 && pi == 0)
        	page = articleRepository.findByLocationIdAndMoodIdAndUserNameStartsWith(di, mi, st, pageRequest);
        else if (si == 2 && di != 0 && ti == 0 && mi == 0 && pi != 0)
        	page = articleRepository.findByLocationIdAndPartyIdAndUserNameStartsWith(di, pi, st, pageRequest);
        else if (si == 2 && di != 0 && ti != 0 && mi != 0 && pi == 0)
        	page = articleRepository.findByLocationIdAndTagIdAndMoodIdAndUserNameStartsWith(di, ti, mi, st, pageRequest);
        else if (si == 2 && di != 0 && ti != 0 && mi == 0 && pi != 0)
        	page = articleRepository.findByLocationIdAndTagIdAndPartyIdAndUserNameStartsWith(di, ti, pi, st, pageRequest);
        else if (si == 2 && di != 0 && ti == 0 && mi != 0 && pi != 0)
        	page = articleRepository.findByLocationIdAndMoodIdAndPartyIdAndUserNameStartsWith(di, mi, pi, st, pageRequest);
        else if (si == 2 && di == 0 && ti != 0 && mi != 0 && pi != 0)
        	page = articleRepository.findByTagIdAndMoodIdAndPartyIdAndUserNameStartsWith(ti, mi, pi, st, pageRequest);
        else if (si == 2 && di != 0 && ti != 0 && mi != 0 && pi != 0)
        	page = articleRepository.findByLocationIdAndTagIdAndMoodIdAndPartyIdAndUserNameStartsWith(di, ti, mi, pi, st, pageRequest);

        else if (si == 0 && di != 0 && ti == 0 && mi == 0 && pi == 0)
          	page = articleRepository. findByLocationId(di, pageRequest);
        else if (si == 0 && di == 0 && ti != 0 && mi == 0 && pi == 0)
          	page = articleRepository. findByTagId(ti, pageRequest);
        else if (si == 0 && di == 0 && ti == 0 && mi != 0 && pi == 0)
          	page = articleRepository. findByMoodId(mi, pageRequest);
        else if (si == 0 && di == 0 && ti == 0 && mi == 0 && pi != 0)
          	page = articleRepository. findByPartyId(pi, pageRequest);

        else if (si == 0 && di != 0 && ti != 0 && mi == 0 && pi == 0)
          	page = articleRepository. findByLocationIdAndTagId(di, ti, pageRequest);
        else if (si == 0 && di != 0 && ti == 0 && mi != 0 && pi == 0)
          	page = articleRepository. findByLocationIdAndMoodId(di, mi, pageRequest);
        else if (si == 0 && di != 0 && ti == 0 && mi == 0 && pi != 0)
          	page = articleRepository. findByLocationIdAndPartyId(di, pi, pageRequest);

        else if (si == 0 && di != 0 && ti != 0 && mi != 0 && pi == 0)
          	page = articleRepository. findByLocationIdAndTagIdAndMoodId(di, ti, mi, pageRequest);
        else if (si == 0 && di != 0 && ti != 0 && mi == 0 && pi != 0)
          	page = articleRepository. findByLocationIdAndTagIdAndPartyId(di, ti, pi, pageRequest);
        else if (si == 0 && di != 0 && ti == 0 && mi != 0 && pi != 0)
          	page = articleRepository. findByLocationIdAndMoodIdAndPartyId(di, mi, pi, pageRequest);
        else if (si == 0 && di == 0 && ti != 0 && mi != 0 && pi != 0)
          	page = articleRepository. findByTagIdAndMoodIdAndPartyId(ti, mi, pi, pageRequest);
        else if (si == 0 && di != 0 && ti != 0 && mi != 0 && pi != 0)
          	page = articleRepository. findByLocationIdAndTagIdAndMoodIdAndPartyId(di, ti, mi, pi, pageRequest);
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

    public List<ArticleDto> findAll2(Pagination pagination) {
        int pg = pagination.getPg() - 1, sz = pagination.getSz();
        var pageRequest = PageRequest.of(pg, sz, reverseBy);
        Page<Article> page = null;
            page = articleRepository.findByBoardId(1, pageRequest);
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

    public List<ArticleDto> findAll3(Pagination pagination) {
        int pg = pagination.getPg() - 1, sz = pagination.getSz();
        var pageRequest = PageRequest.of(pg, sz, reverseBy);
        Page<Article> page = null;
            page = articleRepository.findByBoardId(2, pageRequest);
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


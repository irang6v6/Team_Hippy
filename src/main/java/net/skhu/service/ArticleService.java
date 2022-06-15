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
        	page = articleRepository. findByLocationIdAndBoardIdAndTitleContains(di, bd ,st, pageRequest);
        else if (si == 1 && di == 0 && ti != 0 && mi == 0 && pi == 0)
        	page = articleRepository. findByTagIdAndBoardIdAndTitleContains(ti, bd ,st, pageRequest);
        else if (si == 1 && di == 0 && ti == 0 && mi != 0 && pi == 0)
        	page = articleRepository. findByMoodIdAndBoardIdAndTitleContains(mi, bd ,st, pageRequest);
        else if (si == 1 && di == 0 && ti == 0 && mi == 0 && pi != 0)
        	page = articleRepository. findByPartyIdAndBoardIdAndTitleContains(pi, bd ,st, pageRequest);
        else if (si == 1 && di != 0 && ti != 0 && mi == 0 && pi == 0)
        	page = articleRepository. findByLocationIdAndTagIdAndBoardIdAndTitleContains(di, ti, bd ,st, pageRequest);
        else if (si == 1 && di != 0 && ti == 0 && mi != 0 && pi == 0)
        	page = articleRepository. findByLocationIdAndMoodIdAndBoardIdAndTitleContains(di, mi, bd ,st, pageRequest);
        else if (si == 1 && di != 0 && ti == 0 && mi == 0 && pi != 0)
        	page = articleRepository. findByLocationIdAndPartyIdAndBoardIdAndTitleContains(di, pi, bd ,st, pageRequest);
        else if (si == 1 && di == 0 && ti != 0 && mi != 0 && pi == 0)
        	page = articleRepository. findByTagIdAndMoodIdAndBoardIdAndTitleContains(ti, mi, bd ,st, pageRequest);
        else if (si == 1 && di == 0 && ti == 0 && mi != 0 && pi != 0)
        	page = articleRepository. findByMoodIdAndPartyIdAndBoardIdAndTitleContains(mi, pi, bd ,st, pageRequest);
        else if (si == 1 && di == 0 && ti != 0 && mi == 0 && pi != 0)
        	page = articleRepository. findByTagIdAndPartyIdAndBoardIdAndTitleContains(ti, pi, bd ,st, pageRequest);
        else if (si == 1 && di != 0 && ti != 0 && mi != 0 && pi == 0)
        	page = articleRepository. findByLocationIdAndTagIdAndMoodIdAndBoardIdAndTitleContains(di, ti, mi, bd ,st, pageRequest);
        else if (si == 1 && di != 0 && ti != 0 && mi == 0 && pi != 0)
        	page = articleRepository. findByLocationIdAndTagIdAndPartyIdAndBoardIdAndTitleContains(di, ti, pi, bd ,st, pageRequest);
        else if (si == 1 && di != 0 && ti == 0 && mi != 0 && pi != 0)
        	page = articleRepository. findByLocationIdAndMoodIdAndPartyIdAndBoardIdAndTitleContains(di, mi, pi, bd ,st, pageRequest);
        else if (si == 1 && di == 0 && ti != 0 && mi != 0 && pi != 0)
        	page = articleRepository. findByTagIdAndMoodIdAndPartyIdAndBoardIdAndTitleContains(ti, mi, pi, bd ,st, pageRequest);
        else if (si == 1 && di != 0 && ti != 0 && mi != 0 && pi != 0)
        	page = articleRepository. findByLocationIdAndTagIdAndMoodIdAndPartyIdAndBoardIdAndTitleContains(di, ti, mi, pi, bd ,st, pageRequest);

        else if (si == 2 && di == 0 && ti == 0 && mi == 0 && pi == 0)
            page = articleRepository.findByBoardIdAndUserNickNameStartsWith(bd, st, pageRequest);
        else if (si == 2 && di != 0 && ti == 0 && mi == 0 && pi == 0)
        	page = articleRepository.findByLocationIdAndBoardIdAndUserNickNameStartsWith(di, bd,st, pageRequest);
        else if (si == 2 && di == 0 && ti != 0 && mi == 0 && pi == 0)
        	page = articleRepository.findByTagIdAndBoardIdAndUserNickNameStartsWith(ti, bd ,st, pageRequest);
        else if (si == 2 && di == 0 && ti == 0 && mi != 0 && pi == 0)
        	page = articleRepository.findByMoodIdAndBoardIdAndUserNickNameStartsWith(mi, bd,st, pageRequest);
        else if (si == 2 && di == 0 && ti == 0 && mi == 0 && pi != 0)
        	page = articleRepository.findByPartyIdAndBoardIdAndUserNickNameStartsWith(pi, bd,st, pageRequest);
        else if (si == 2 && di != 0 && ti != 0 && mi == 0 && pi == 0)
        	page = articleRepository.findByLocationIdAndTagIdAndBoardIdAndUserNickNameStartsWith(di, ti, bd ,st, pageRequest);
        else if (si == 2 && di != 0 && ti == 0 && mi != 0 && pi == 0)
        	page = articleRepository.findByLocationIdAndMoodIdAndBoardIdAndUserNickNameStartsWith(di, mi, bd ,st, pageRequest);
        else if (si == 2 && di != 0 && ti == 0 && mi == 0 && pi != 0)
        	page = articleRepository.findByLocationIdAndPartyIdAndBoardIdAndUserNickNameStartsWith(di, pi, bd ,st, pageRequest);
        else if (si == 2 && di == 0 && ti != 0 && mi != 0 && pi == 0)
        	page = articleRepository.findByTagIdAndMoodIdAndBoardIdAndUserNickNameStartsWith(ti, mi, bd ,st, pageRequest);
        else if (si == 2 && di == 0 && ti == 0 && mi != 0 && pi != 0)
        	page = articleRepository.findByMoodIdAndPartyIdAndBoardIdAndUserNickNameStartsWith(mi, pi, bd ,st, pageRequest);
        else if (si == 2 && di == 0 && ti != 0 && mi == 0 && pi != 0)
        	page = articleRepository.findByTagIdAndPartyIdAndBoardIdAndUserNickNameStartsWith(ti, pi, bd ,st, pageRequest);
        else if (si == 2 && di != 0 && ti != 0 && mi != 0 && pi == 0)
        	page = articleRepository.findByLocationIdAndTagIdAndMoodIdAndBoardIdAndUserNickNameStartsWith(di, ti, mi, bd ,st, pageRequest);
        else if (si == 2 && di != 0 && ti != 0 && mi == 0 && pi != 0)
        	page = articleRepository.findByLocationIdAndTagIdAndPartyIdAndBoardIdAndUserNickNameStartsWith(di, ti, pi, bd ,st, pageRequest);
        else if (si == 2 && di != 0 && ti == 0 && mi != 0 && pi != 0)
        	page = articleRepository.findByLocationIdAndMoodIdAndPartyIdAndBoardIdAndUserNickNameStartsWith(di, mi, pi, bd ,st, pageRequest);
        else if (si == 2 && di == 0 && ti != 0 && mi != 0 && pi != 0)
        	page = articleRepository.findByTagIdAndMoodIdAndPartyIdAndBoardIdAndUserNickNameStartsWith(ti, mi, pi, bd ,st, pageRequest);
        else if (si == 2 && di != 0 && ti != 0 && mi != 0 && pi != 0)
        	page = articleRepository.findByLocationIdAndTagIdAndMoodIdAndPartyIdAndBoardIdAndUserNickNameStartsWith(di, ti, mi, pi, bd ,st, pageRequest);

        else if (si == 0 && di != 0 && ti == 0 && mi == 0 && pi == 0)
          	page = articleRepository. findByLocationIdAndBoardId(di, bd, pageRequest);
        else if (si == 0 && di == 0 && ti != 0 && mi == 0 && pi == 0)
          	page = articleRepository. findByTagIdAndBoardId(ti, bd , pageRequest);
        else if (si == 0 && di == 0 && ti == 0 && mi != 0 && pi == 0)
          	page = articleRepository. findByMoodIdAndBoardId(mi, bd ,pageRequest);
        else if (si == 0 && di == 0 && ti == 0 && mi == 0 && pi != 0)
          	page = articleRepository. findByPartyIdAndBoardId(pi, bd ,pageRequest);

        else if (si == 0 && di != 0 && ti != 0 && mi == 0 && pi == 0)
          	page = articleRepository. findByLocationIdAndTagIdAndBoardId(di, ti, bd ,pageRequest);
        else if (si == 0 && di != 0 && ti == 0 && mi != 0 && pi == 0)
          	page = articleRepository. findByLocationIdAndMoodIdAndBoardId(di, mi, bd ,pageRequest);
        else if (si == 0 && di != 0 && ti == 0 && mi == 0 && pi != 0)
          	page = articleRepository. findByLocationIdAndPartyIdAndBoardId(di, pi, bd ,pageRequest);
        else if (si == 0 && di == 0 && ti != 0 && mi != 0 && pi == 0)
          	page = articleRepository. findByTagIdAndMoodIdAndBoardId(ti, mi, bd ,pageRequest);
        else if (si == 0 && di == 0 && ti != 0 && mi == 0 && pi != 0)
          	page = articleRepository. findByTagIdAndPartyIdAndBoardId(ti, pi, bd ,pageRequest);
        else if (si == 0 && di == 0 && ti == 0 && mi != 0 && pi != 0)
          	page = articleRepository. findByMoodIdAndPartyIdAndBoardId(mi, pi, bd ,pageRequest);

        else if (si == 0 && di != 0 && ti != 0 && mi != 0 && pi == 0)
          	page = articleRepository. findByLocationIdAndTagIdAndMoodIdAndBoardId(di, ti, mi, bd ,pageRequest);
        else if (si == 0 && di != 0 && ti != 0 && mi == 0 && pi != 0)
          	page = articleRepository. findByLocationIdAndTagIdAndPartyIdAndBoardId(di, ti, pi, bd ,pageRequest);
        else if (si == 0 && di != 0 && ti == 0 && mi != 0 && pi != 0)
          	page = articleRepository. findByLocationIdAndMoodIdAndPartyIdAndBoardId(di, mi, pi, bd ,pageRequest);
        else if (si == 0 && di == 0 && ti != 0 && mi != 0 && pi != 0)
          	page = articleRepository. findByTagIdAndMoodIdAndPartyIdAndBoardId(ti, mi, pi, bd ,pageRequest);
        else if (si == 0 && di != 0 && ti != 0 && mi != 0 && pi != 0)
          	page = articleRepository. findByLocationIdAndTagIdAndMoodIdAndPartyIdAndBoardId(di, ti, mi, pi, bd,pageRequest);
        else
            page = articleRepository.findByBoardId(bd, pageRequest);
        pagination.setRecordCount((int)page.getTotalElements());
        List<Article> articleEntities = page.getContent();
        List<ArticleDto> articleDtos = modelMapper.mapList(articleEntities, ArticleDto.class);
        for (int i = 0; i < articleDtos.size(); ++i) {
            Article article = articleEntities.get(i);
            ArticleDto articleDto = articleDtos.get(i);
            articleDto.setUserName(article.getUser().getNickName());
        }
        return articleDtos;
    }

    public List<ArticleDto> findAll2(Pagination pagination) {
        int pg = pagination.getPg() - 1, sz = pagination.getSz();
        var pageRequest = PageRequest.of(pg, sz, orderBy);
        Page<Article> page = null;
            page = articleRepository.findByBoardId(1, pageRequest);
        pagination.setRecordCount((int)page.getTotalElements());
        List<Article> articleEntities = page.getContent();
        List<ArticleDto> articleDtos = modelMapper.mapList(articleEntities, ArticleDto.class);
        for (int i = 0; i < articleDtos.size(); ++i) {
            Article article = articleEntities.get(i);
            ArticleDto articleDto = articleDtos.get(i);
            articleDto.setUserName(article.getUser().getNickName());
        }
        return articleDtos;
    }

    public List<ArticleDto> findAll3(Pagination pagination) {
        int pg = pagination.getPg() - 1, sz = pagination.getSz();
        var pageRequest = PageRequest.of(pg, sz, orderBy);
        Page<Article> page = null;
            page = articleRepository.findByBoardId(2, pageRequest);
        pagination.setRecordCount((int)page.getTotalElements());
        List<Article> articleEntities = page.getContent();
        List<ArticleDto> articleDtos = modelMapper.mapList(articleEntities, ArticleDto.class);
        for (int i = 0; i < articleDtos.size(); ++i) {
            Article article = articleEntities.get(i);
            ArticleDto articleDto = articleDtos.get(i);
            articleDto.setUserName(article.getUser().getNickName());
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


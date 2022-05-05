package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.skhu.config.ModelMapperConfig.MyModelMapper;
import net.skhu.dto.ArticleDto;
import net.skhu.dto.Pagination;
import net.skhu.entity.Article;
import net.skhu.repository.ArticleRepository;

@Service
public class ArticleService {

    @Autowired ArticleRepository articleRepository;
    @Autowired MyModelMapper modelMapper;

    private static Sort orderBy = Sort.by(Sort.Direction.DESC, "id");

    public ArticleDto findById(int id) {

        var article = articleRepository.findById(id).get();
        return modelMapper.map(article, ArticleDto.class);

    }

    public List<ArticleDto> findAll(Pagination pagination) {

        int pg = pagination.getPg() - 1, sz = pagination.getSz(),
            si = pagination.getSi(), bd = pagination.getBd();
        String st = pagination.getSt();
        var pageRequest = PageRequest.of(pg, sz, orderBy);
        Page<Article> page = null;
        if (si == 1)
            page = articleRepository.findByBoardIdAndTitleContains(bd, st, pageRequest);
        else
            page = articleRepository.findByBoardId(bd, pageRequest);

        pagination.setRecordCount((int)page.getTotalElements());
        List<Article> articleEntities = page.getContent();
        List<ArticleDto> articleDtos = modelMapper.mapList(articleEntities, ArticleDto.class);

        return articleDtos;
    }

    /*
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public int insert(int boardid, ArticleEdit articleEdit) {
    	return article.getId();
    }
    */




}

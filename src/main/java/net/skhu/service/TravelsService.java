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
import net.skhu.entity.Board;
import net.skhu.entity.Travels;
import net.skhu.model.Pagination;
import net.skhu.model.TravelsDto;
import net.skhu.model.TravelsEdit;
import net.skhu.repository.BoardRepository;
import net.skhu.repository.TravelsRepository;

@Service
public class TravelsService {

    @Autowired UserService userService;
    @Autowired TravelsRepository travelsRepository;
    @Autowired BoardRepository boardRepository;
    @Autowired MyModelMapper modelMapper;

    private static Sort orderBy = Sort.by(Sort.Direction.DESC, "id");

    public TravelsDto findById(int id) {
        var travels = travelsRepository.findById(id).get();
        return modelMapper.map(travels, TravelsDto.class);
    }

    public List<TravelsDto> findAll(Pagination pagination) {
        int pg = pagination.getPg() - 1, sz = pagination.getSz(),
            si = pagination.getSi(), bd = pagination.getBd();
        String st = pagination.getSt();
        var pageRequest = PageRequest.of(pg, sz, orderBy);
        Page<Travels> page = null;
        if (si == 1)
            page = travelsRepository.findByBoardIdAndTitleContains(bd, st, pageRequest);
        else if (si == 2)
            page = travelsRepository.findByBoardIdAndUserIdStartsWith(bd, st, pageRequest);
        else
            page = travelsRepository.findByBoardId(bd, pageRequest);
        pagination.setRecordCount((int)page.getTotalElements());
        List<Travels> travelsEntities = page.getContent();
        List<TravelsDto> travelsDtos = modelMapper.mapList(travelsEntities, TravelsDto.class);
        for (int i = 0; i < travelsDtos.size(); ++i) {
            Travels travels = travelsEntities.get(i);
            TravelsDto travelsDto = travelsDtos.get(i);
            travelsDto.setUserId(travels.getUser().getName());
        }
        return travelsDtos;
    }

    @Transactional
    public int insert(int boardId, TravelsEdit travelsEdit) {
        Board board = boardRepository.findById(boardId).get();
        int no = board.getArticleNo() + 1;
        board.setArticleNo(no);
        boardRepository.save(board);

        Travels travels;
        travels = modelMapper.map(travelsEdit, Travels.class);
        travels.setNo(no);
        travels.setBoardId(boardId);
        travels.setUser(userService.getCurrentUser());
        travels.setTravels_regdate(new Date());
        travelsRepository.save(travels);
        return travels.getId();
    }

}

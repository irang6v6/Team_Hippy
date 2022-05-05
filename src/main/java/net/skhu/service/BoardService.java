package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.entity.Board;
import net.skhu.repository.BoardRepository;

@Service
public class BoardService {

    @Autowired BoardRepository boardRepository;

    public Board findById(int id) {
        return boardRepository.findById(id).get();
    }

}

package net.skhu.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Travels;

public interface TravelsRepository extends JpaRepository<Travels, Integer>  {

    Page<Travels> findByBoardId(int boardId, Pageable pageable);
    Page<Travels> findByBoardIdAndUserNameStartsWith(int boardId, String userName, Pageable pageable);
    Page<Travels> findByBoardIdAndTitleContains(int boardId, String title, Pageable pageable);
}


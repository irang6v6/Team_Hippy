package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>  {

}


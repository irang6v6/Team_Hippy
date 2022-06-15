package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Tag;

public interface TagRepository  extends JpaRepository<Tag, Integer> {

}


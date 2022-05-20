package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Mood;

public interface MoodRepository  extends JpaRepository<Mood, Integer> {

}


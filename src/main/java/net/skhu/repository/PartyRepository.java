package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Party;

public interface PartyRepository  extends JpaRepository<Party, Integer> {

}


package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Location;

public interface LocationRepository  extends JpaRepository<Location, Integer> {

}


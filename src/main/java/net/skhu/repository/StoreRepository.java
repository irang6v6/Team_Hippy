package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Store;
import net.skhu.model.Pagination;

public interface StoreRepository  extends JpaRepository<Store, Integer> {

    public default List<Store> findAll(Pagination pagination) {
        Page<Store> page = this.findAll(PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    Page<Store> findByLocationIdAndTagId(int locationId, int tagId,Pageable pageable);
    Page<Store> findByLocationId(int locationId, Pageable pageable);
    Page<Store> findByTagId(int tagId, Pageable pageable);

    public default List<Store> findByTagId(Pagination pagination) {
        Page<Store> page = this.findByTagId(pagination.getTi(),PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    public default List<Store> findByLocationId(Pagination pagination) {
        Page<Store> page = this.findByLocationId(pagination.getDi(),PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    public default List<Store> findByLocationIdAndTagId(Pagination pagination) {
        if (pagination.getDi() == 0 && pagination.getTi() == 0) return findAll(pagination);
        else if(pagination.getDi() != 0 && pagination.getTi() == 0) return findByLocationId(pagination);
        else if(pagination.getDi() == 0 && pagination.getTi() != 0) return findByTagId(pagination);
        Page<Store> page = this.findByLocationIdAndTagId(pagination.getDi(),pagination.getTi(),
                PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

}


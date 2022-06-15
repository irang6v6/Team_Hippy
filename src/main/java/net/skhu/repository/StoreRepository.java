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
                                           Sort.Direction.DESC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    Page<Store> findByLocationId(int locationId, Pageable pageable);
    Page<Store> findByTagId(int tagId, Pageable pageable);
    Page<Store> findByMoodId(int moodId, Pageable pageable);
    Page<Store> findByPartyId(int partyId, Pageable pageable);

    Page<Store> findByLocationIdAndTagId(int locationId, int tagId,Pageable pageable);
    Page<Store> findByLocationIdAndMoodId(int locationId, int moodId,Pageable pageable);
    Page<Store> findByLocationIdAndPartyId(int locationId, int partyId,Pageable pageable);
    Page<Store> findByTagIdAndMoodId(int tagId, int moodId,Pageable pageable);
    Page<Store> findByTagIdAndPartyId(int tagId, int partyId,Pageable pageable);
    Page<Store> findByMoodIdAndPartyId(int moodId, int partyId,Pageable pageable);

    Page<Store> findByLocationIdAndTagIdAndMoodId(int locationId, int tagId, int moodId,Pageable pageable);
    Page<Store> findByTagIdAndMoodIdAndPartyId(int tagId, int moodId, int partyId,Pageable pageable);
    Page<Store> findByLocationIdAndMoodIdAndPartyId(int locationId, int moodId, int partyId,Pageable pageable);

    Page<Store> findByLocationIdAndTagIdAndMoodIdAndPartyId(int locationId, int tagId, int moodId, int partyId,Pageable pageable);







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

    public default List<Store> findByMoodId(Pagination pagination) {
        Page<Store> page = this.findByMoodId(pagination.getMi(),PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    public default List<Store> findByPartyId(Pagination pagination) {
        Page<Store> page = this.findByPartyId(pagination.getPi(),PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    public default List<Store> findByLocationIdAndMoodId(Pagination pagination) {
    	   Page<Store> page = this.findByLocationIdAndMoodId(pagination.getDi(),pagination.getMi(),
                   PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
           pagination.setRecordCount((int)page.getTotalElements());
           return page.getContent();
    }

    public default List<Store> findByLocationIdAndPartyId(Pagination pagination) {
 	   Page<Store> page = this.findByLocationIdAndPartyId(pagination.getDi(),pagination.getPi(),
                PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
 }

    public default List<Store> findByTagIdAndMoodId(Pagination pagination) {
   	   Page<Store> page = this.findByTagIdAndMoodId(pagination.getTi(),pagination.getMi(),
                  PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
          pagination.setRecordCount((int)page.getTotalElements());
          return page.getContent();
   }

    public default List<Store> findByTagIdAndPartyId(Pagination pagination) {
   	   Page<Store> page = this.findByTagIdAndPartyId(pagination.getTi(),pagination.getPi(),
                  PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
          pagination.setRecordCount((int)page.getTotalElements());
          return page.getContent();
   }

    public default List<Store> findByMoodIdAndPartyId(Pagination pagination) {
    	   Page<Store> page = this.findByMoodIdAndPartyId(pagination.getMi(),pagination.getPi(),
                   PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
           pagination.setRecordCount((int)page.getTotalElements());
           return page.getContent();
    }

    public default List<Store> findByLocationIdAndTagIdAndMoodId(Pagination pagination) {
 	   Page<Store> page = this.findByLocationIdAndTagIdAndMoodId(pagination.getDi(),pagination.getTi(),pagination.getMi(),
                PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
 }

    public default List<Store> findByTagIdAndMoodIdAndPartyId(Pagination pagination) {
  	   Page<Store> page = this.findByTagIdAndMoodIdAndPartyId(pagination.getTi(),pagination.getMi(),pagination.getPi(),
                 PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
         pagination.setRecordCount((int)page.getTotalElements());
         return page.getContent();
  }

    public default List<Store> findByLocationIdAndMoodIdAndPartyId(Pagination pagination) {
   	   Page<Store> page = this.findByLocationIdAndMoodIdAndPartyId(pagination.getDi(),pagination.getMi(),pagination.getPi(),
                  PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
          pagination.setRecordCount((int)page.getTotalElements());
          return page.getContent();
   }

    public default List<Store> findByLocationIdAndTagIdAndMoodIdAndPartyId(Pagination pagination) {
    	   Page<Store> page = this.findByLocationIdAndTagIdAndMoodIdAndPartyId(pagination.getDi(),pagination.getTi(),pagination.getMi(),pagination.getPi(),
                   PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
           pagination.setRecordCount((int)page.getTotalElements());
           return page.getContent();
    }







    public default List<Store> findByLocationIdAndTagId(Pagination pagination) {
        if (pagination.getDi() == 0 && pagination.getTi() == 0 && pagination.getMi() == 0 && pagination.getPi() == 0) return findAll(pagination);
        else if(pagination.getDi() != 0 && pagination.getTi() == 0 && pagination.getMi() == 0 && pagination.getPi() == 0) return findByLocationId(pagination);
        else if(pagination.getDi() == 0 && pagination.getTi() != 0 && pagination.getMi() == 0 && pagination.getPi() == 0) return findByTagId(pagination);
        else if(pagination.getDi() == 0 && pagination.getTi() == 0 && pagination.getMi() != 0 && pagination.getPi() == 0) return findByMoodId(pagination);
        else if(pagination.getDi() == 0 && pagination.getTi() == 0 && pagination.getMi() == 0 && pagination.getPi() != 0) return findByPartyId(pagination);
        else if(pagination.getDi() != 0 && pagination.getTi() == 0 && pagination.getMi() != 0 && pagination.getPi() == 0) return findByLocationIdAndMoodId(pagination);
        else if(pagination.getDi() != 0 && pagination.getTi() == 0 && pagination.getMi() == 0 && pagination.getPi() != 0) return findByLocationIdAndPartyId(pagination);
        else if(pagination.getDi() == 0 && pagination.getTi() != 0 && pagination.getMi() != 0 && pagination.getPi() == 0) return findByTagIdAndMoodId(pagination);
        else if(pagination.getDi() == 0 && pagination.getTi() != 0 && pagination.getMi() == 0 && pagination.getPi() != 0) return findByTagIdAndPartyId(pagination);
        else if(pagination.getDi() == 0 && pagination.getTi() == 0 && pagination.getMi() != 0 && pagination.getPi() != 0) return findByMoodIdAndPartyId(pagination);
        else if(pagination.getDi() != 0 && pagination.getTi() != 0 && pagination.getMi() != 0 && pagination.getPi() == 0) return findByLocationIdAndTagIdAndMoodId(pagination);
        else if(pagination.getDi() == 0 && pagination.getTi() != 0 && pagination.getMi() != 0 && pagination.getPi() != 0) return findByTagIdAndMoodIdAndPartyId(pagination);
        else if(pagination.getDi() != 0 && pagination.getTi() == 0 && pagination.getMi() != 0 && pagination.getPi() != 0) return findByLocationIdAndMoodIdAndPartyId(pagination);
        else if(pagination.getDi() != 0 && pagination.getTi() != 0 && pagination.getMi() != 0 && pagination.getPi() != 0) return findByLocationIdAndTagIdAndMoodIdAndPartyId(pagination);
        Page<Store> page = this.findByLocationIdAndTagId(pagination.getDi(),pagination.getTi(),
                PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }


}

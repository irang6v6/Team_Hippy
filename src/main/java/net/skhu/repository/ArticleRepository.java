package net.skhu.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>  {

    Page<Article> findByBoardId(int boardId, Pageable pageable);

    Page<Article> findByLocationId(int locationId, Pageable pageable);
    Page<Article> findByTagId(int tagId, Pageable pageable);
    Page<Article> findByMoodId(int moodId, Pageable pageable);
    Page<Article> findByPartyId(int partyId, Pageable pageable);

    Page<Article> findByBoardIdAndUserNameStartsWith(int boardId, String userName, Pageable pageable);
    Page<Article> findByBoardIdAndTitleContains(int boardId, String title, Pageable pageable);
    Page<Article> findByLocationIdAndUserNameStartsWith(int locationId, String userName, Pageable pageable);
    Page<Article> findByLocationIdAndTitleContains(int locationId, String title, Pageable pageable);
    Page<Article> findByTagIdAndUserNameStartsWith(int tagId, String userName, Pageable pageable);
    Page<Article> findByTagIdAndTitleContains(int tagId, String title, Pageable pageable);
    Page<Article> findByMoodIdAndTitleContains(int moodId, String title, Pageable pageable);
    Page<Article> findByMoodIdAndUserNameStartsWith(int moodId, String userName, Pageable pageable);
    Page<Article> findByPartyIdAndTitleContains(int partyId, String title, Pageable pageable);
    Page<Article> findByPartyIdAndUserNameStartsWith(int partyId, String userName, Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndTitleContains(int locationId, int tagId, String title, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndUserNameStartsWith(int locationId, int tagId, String userName, Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndTitleContains(int locationId, int moodId, String title, Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndUserNameStartsWith(int locationId, int moodId, String userName, Pageable pageable);
    Page<Article> findByLocationIdAndPartyIdAndTitleContains(int locationId, int partyId, String title, Pageable pageable);
    Page<Article> findByLocationIdAndPartyIdAndUserNameStartsWith(int locationId, int partyId, String userName, Pageable pageable);

    Page<Article> findByLocationIdAndTagId(int locationId, int tagId, Pageable pageable);
    Page<Article> findByLocationIdAndMoodId(int locationId, int moodId, Pageable pageable);
    Page<Article> findByLocationIdAndPartyId(int locationId, int partyId, Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndMoodId(int locationId, int tagId, int moodId, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndPartyId(int locationId, int tagId, int partyId, Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndPartyId(int locationId, int moodId, int partyId, Pageable pageable);
    Page<Article> findByTagIdAndMoodIdAndPartyId(int tagId, int moodId, int partyId, Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndMoodIdAndTitleContains(int locationId, int tagId, int moodId,String title, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndMoodIdAndUserNameStartsWith(int locationId, int tagId, int moodId,String userName, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndPartyIdAndTitleContains(int locationId, int tagId, int partyId,String title, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndPartyIdAndUserNameStartsWith(int locationId, int tagId, int partyId,String userName, Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndPartyIdAndTitleContains(int locationId, int moodId, int partyId,String title, Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndPartyIdAndUserNameStartsWith(int locationId, int moodId, int partyId,String userName, Pageable pageable);
    Page<Article> findByTagIdAndMoodIdAndPartyIdAndTitleContains(int tagId, int moodId, int partyId,String title, Pageable pageable);
    Page<Article> findByTagIdAndMoodIdAndPartyIdAndUserNameStartsWith(int tagId, int moodId, int partyId,String userName, Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndMoodIdAndPartyId(int locationId, int tagId, int moodId, int partyId, Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndMoodIdAndPartyIdAndTitleContains(int locationId, int tagId, int moodId, int partyId,String title, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndMoodIdAndPartyIdAndUserNameStartsWith(int locationId, int tagId, int moodId, int partyId,String userName, Pageable pageable);
}


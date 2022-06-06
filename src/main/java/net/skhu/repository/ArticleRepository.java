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

    Page<Article> findByBoardIdAndUserNickNameStartsWith(int boardId, String userNickName, Pageable pageable);
    Page<Article> findByBoardIdAndTitleContains(int boardId, String title, Pageable pageable);
    Page<Article> findByLocationIdAndUserNickNameStartsWith(int locationId, String userNickName, Pageable pageable);
    Page<Article> findByLocationIdAndTitleContains(int locationId, String title, Pageable pageable);
    Page<Article> findByTagIdAndUserNickNameStartsWith(int tagId, String userNickName, Pageable pageable);
    Page<Article> findByTagIdAndTitleContains(int tagId, String title, Pageable pageable);
    Page<Article> findByMoodIdAndTitleContains(int moodId, String title, Pageable pageable);
    Page<Article> findByMoodIdAndUserNickNameStartsWith(int moodId, String userNickName, Pageable pageable);
    Page<Article> findByPartyIdAndTitleContains(int partyId, String title, Pageable pageable);
    Page<Article> findByPartyIdAndUserNickNameStartsWith(int partyId, String userNickName, Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndTitleContains(int locationId, int tagId, String title, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndUserNickNameStartsWith(int locationId, int tagId, String userNickName, Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndTitleContains(int locationId, int moodId, String title, Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndUserNickNameStartsWith(int locationId, int moodId, String userNickName, Pageable pageable);
    Page<Article> findByLocationIdAndPartyIdAndTitleContains(int locationId, int partyId, String title, Pageable pageable);
    Page<Article> findByLocationIdAndPartyIdAndUserNickNameStartsWith(int locationId, int partyId, String userNickName, Pageable pageable);
    Page<Article> findByTagIdAndMoodIdAndTitleContains(int tagId, int moodId, String title, Pageable pageable);
    Page<Article> findByTagIdAndMoodIdAndUserNickNameStartsWith(int tagId, int MoodId, String userNickName, Pageable pageable);
    Page<Article> findByMoodIdAndPartyIdAndTitleContains(int moodId, int partyId, String title, Pageable pageable);
    Page<Article> findByMoodIdAndPartyIdAndUserNickNameStartsWith(int moodId, int partyId, String userNickName, Pageable pageable);
    Page<Article> findByTagIdAndPartyIdAndTitleContains(int tagId, int partyId, String title, Pageable pageable);
    Page<Article> findByTagIdAndPartyIdAndUserNickNameStartsWith(int tagId, int partyId, String userNickName, Pageable pageable);

    Page<Article> findByLocationIdAndTagId(int locationId, int tagId, Pageable pageable);
    Page<Article> findByLocationIdAndMoodId(int locationId, int moodId, Pageable pageable);
    Page<Article> findByLocationIdAndPartyId(int locationId, int partyId, Pageable pageable);

    Page<Article> findByTagIdAndMoodId(int tagId, int moodId, Pageable pageable);
    Page<Article> findByTagIdAndPartyId(int tagId, int partyId, Pageable pageable);

    Page<Article> findByMoodIdAndPartyId(int moodId, int partyId, Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndMoodId(int locationId, int tagId, int moodId, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndPartyId(int locationId, int tagId, int partyId, Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndPartyId(int locationId, int moodId, int partyId, Pageable pageable);
    Page<Article> findByTagIdAndMoodIdAndPartyId(int tagId, int moodId, int partyId, Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndMoodIdAndTitleContains(int locationId, int tagId, int moodId,String title, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndMoodIdAndUserNickNameStartsWith(int locationId, int tagId, int moodId,String userNickName, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndPartyIdAndTitleContains(int locationId, int tagId, int partyId,String title, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndPartyIdAndUserNickNameStartsWith(int locationId, int tagId, int partyId,String userNickName, Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndPartyIdAndTitleContains(int locationId, int moodId, int partyId,String title, Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndPartyIdAndUserNickNameStartsWith(int locationId, int moodId, int partyId,String userNickName, Pageable pageable);
    Page<Article> findByTagIdAndMoodIdAndPartyIdAndTitleContains(int tagId, int moodId, int partyId,String title, Pageable pageable);
    Page<Article> findByTagIdAndMoodIdAndPartyIdAndUserNickNameStartsWith(int tagId, int moodId, int partyId,String userNickName, Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndMoodIdAndPartyId(int locationId, int tagId, int moodId, int partyId, Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndMoodIdAndPartyIdAndTitleContains(int locationId, int tagId, int moodId, int partyId,String title, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndMoodIdAndPartyIdAndUserNickNameStartsWith(int locationId, int tagId, int moodId, int partyId,String userNickName, Pageable pageable);
}


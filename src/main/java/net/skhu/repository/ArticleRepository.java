package net.skhu.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>  {

    Page<Article> findByBoardId(int boardId, Pageable pageable);

    Page<Article> findByLocationIdAndBoardId(int locationId,int boardId, Pageable pageable);
    Page<Article> findByTagIdAndBoardId(int tagId, int boardId , Pageable pageable);
    Page<Article> findByMoodIdAndBoardId(int moodId, int boardId ,Pageable pageable);
    Page<Article> findByPartyIdAndBoardId(int partyId, int boardId,Pageable pageable);

    Page<Article> findByBoardIdAndUserNickNameStartsWith(int boardId, String userNickName, Pageable pageable);
    Page<Article> findByBoardIdAndTitleContains(int boardId, String title, Pageable pageable);
    Page<Article> findByLocationIdAndBoardIdAndUserNickNameStartsWith(int locationId, int boadrId,String userNickName, Pageable pageable);
    Page<Article> findByLocationIdAndBoardIdAndTitleContains(int locationId, int boardId,String title, Pageable pageable);
    Page<Article> findByTagIdAndBoardIdAndUserNickNameStartsWith(int tagId, int boardId,String userNickName, Pageable pageable);
    Page<Article> findByTagIdAndBoardIdAndTitleContains(int tagId, int boardId,String title, Pageable pageable);
    Page<Article> findByMoodIdAndBoardIdAndTitleContains(int moodId, int boardId,String title, Pageable pageable);
    Page<Article> findByMoodIdAndBoardIdAndUserNickNameStartsWith(int moodId, int boardId,String userNickName, Pageable pageable);
    Page<Article> findByPartyIdAndBoardIdAndTitleContains(int partyId, int boardId,String title, Pageable pageable);
    Page<Article> findByPartyIdAndBoardIdAndUserNickNameStartsWith(int partyId, int boardId,String userNickName, Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndBoardIdAndTitleContains(int locationId, int tagId, int boardId,String title, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndBoardIdAndUserNickNameStartsWith(int locationId, int tagId, int boardId,String userNickName, Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndBoardIdAndTitleContains(int locationId, int moodId, int boardId,String title, Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndBoardIdAndUserNickNameStartsWith(int locationId, int moodId, int boardId,String userNickName, Pageable pageable);
    Page<Article> findByLocationIdAndPartyIdAndBoardIdAndTitleContains(int locationId, int partyId, int boardId ,String title, Pageable pageable);
    Page<Article> findByLocationIdAndPartyIdAndBoardIdAndUserNickNameStartsWith(int locationId, int partyId, int boardId,String userNickName, Pageable pageable);
    Page<Article> findByTagIdAndMoodIdAndBoardIdAndTitleContains(int tagId, int moodId, int boardId,String title, Pageable pageable);
    Page<Article> findByTagIdAndMoodIdAndBoardIdAndUserNickNameStartsWith(int tagId, int MoodId, int boardId,String userNickName, Pageable pageable);
    Page<Article> findByMoodIdAndPartyIdAndBoardIdAndTitleContains(int moodId, int partyId, int boardId,String title, Pageable pageable);
    Page<Article> findByMoodIdAndPartyIdAndBoardIdAndUserNickNameStartsWith(int moodId, int partyId, int boardId,String userNickName, Pageable pageable);
    Page<Article> findByTagIdAndPartyIdAndBoardIdAndTitleContains(int tagId, int partyId, int boardId,String title, Pageable pageable);
    Page<Article> findByTagIdAndPartyIdAndBoardIdAndUserNickNameStartsWith(int tagId, int partyId, int boardId,String userNickName, Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndBoardId(int locationId, int tagId, int boardId,Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndBoardId(int locationId, int moodId, int boardId,Pageable pageable);
    Page<Article> findByLocationIdAndPartyIdAndBoardId(int locationId, int partyId, int boardId,Pageable pageable);

    Page<Article> findByTagIdAndMoodIdAndBoardId(int tagId, int moodId, int boardId,Pageable pageable);
    Page<Article> findByTagIdAndPartyIdAndBoardId(int tagId, int partyId, int boardId,Pageable pageable);

    Page<Article> findByMoodIdAndPartyIdAndBoardId(int moodId, int partyId, int boardId,Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndMoodIdAndBoardId(int locationId, int tagId, int moodId, int boardId,Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndPartyIdAndBoardId(int locationId, int tagId, int partyId, int boardId,Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndPartyIdAndBoardId(int locationId, int moodId, int partyId, int boardId,Pageable pageable);
    Page<Article> findByTagIdAndMoodIdAndPartyIdAndBoardId(int tagId, int moodId, int partyId, int boardId ,Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndMoodIdAndBoardIdAndTitleContains(int locationId, int tagId, int moodId,int boardId,String title, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndMoodIdAndBoardIdAndUserNickNameStartsWith(int locationId, int tagId, int moodId,int boardId,String userNickName, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndPartyIdAndBoardIdAndTitleContains(int locationId, int tagId, int partyId,int boardId,String title, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndPartyIdAndBoardIdAndUserNickNameStartsWith(int locationId, int tagId, int partyId,int boardId,String userNickName, Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndPartyIdAndBoardIdAndTitleContains(int locationId, int moodId, int partyId,int boardId,String title, Pageable pageable);
    Page<Article> findByLocationIdAndMoodIdAndPartyIdAndBoardIdAndUserNickNameStartsWith(int locationId, int moodId, int partyId,int boardId,String userNickName, Pageable pageable);
    Page<Article> findByTagIdAndMoodIdAndPartyIdAndBoardIdAndTitleContains(int tagId, int moodId, int partyId,int boardId,String title, Pageable pageable);
    Page<Article> findByTagIdAndMoodIdAndPartyIdAndBoardIdAndUserNickNameStartsWith(int tagId, int moodId, int partyId,int boardId,String userNickName, Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndMoodIdAndPartyIdAndBoardId(int locationId, int tagId, int moodId, int partyId, int boardId,Pageable pageable);

    Page<Article> findByLocationIdAndTagIdAndMoodIdAndPartyIdAndBoardIdAndTitleContains(int locationId, int tagId, int moodId, int partyId,int boardId,String title, Pageable pageable);
    Page<Article> findByLocationIdAndTagIdAndMoodIdAndPartyIdAndBoardIdAndUserNickNameStartsWith(int locationId, int tagId, int moodId, int partyId,int boardId,String userNickName, Pageable pageable);
}


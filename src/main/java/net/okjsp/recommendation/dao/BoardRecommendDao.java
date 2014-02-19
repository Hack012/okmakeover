package net.okjsp.recommendation.dao;

import net.okjsp.recommendation.model.BoardRecommend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 추천/반대/신고 Dao.
 *
 * @author yjc0703
 */
@Repository
public interface BoardRecommendDao {

    /**
     * 게시글(또는 댓글)에 대한 추천 / 반대 / 신고 (단일항목. 중복체크 용도)
     * @param boardRecommend 추천
     * @return
     */
    List<BoardRecommend> selectOne(BoardRecommend boardRecommend);

    /**
     * 게시글에 대한 추천/반대/신고 리스트
     *
     * @param boardId 게시판 id
     * @param writeNo 게시글 no
     * @param commentId 댓글 id
     * @return
     */
    public List<BoardRecommend> selectRecommendations(@Param("boardId") int boardId,
                                                      @Param("writeNo") int writeNo,
                                                      @Param("commentId") int commentId);

    /**
     * 게시글에 대한 추천/반대/신고 리스트(구분별)
     *
     * @param boardId 게시판 id
     * @param writeNo 게시글 no
     * @param commentId 댓글 id
     * @param guboonId 구분 id (1 : 추천, 2 : 반대, 3 : 신고)
     * @return
     */
    public List<BoardRecommend> selectRecommendationsByGuboon(@Param("boardId") int boardId,
                                                              @Param("writeNo") int writeNo,
                                                              @Param("commentId") int commentId,
                                                              @Param("guboonId") String guboonId);

    /**
     * 유저별 전체 추천/반대/신고 리스트
     * 추후 개인화 작업에서 활용 (내가 추천한 글, 내가 반대한 글, 내가 신고한 글)
     *
     * @param userId 사용자 id
     * @return
     */
    public List<BoardRecommend> selectRecommendationsByUser(@Param("userId") int userId);

    /**
     * 게시물에 대한 구분 별 count
     *
     * @param boardId 게시판 id
     * @param writeNo 게시글 no
     * @param commentId 댓글 id
     * @param guboonId 구분 id (1 : 추천, 2 : 반대, 3 : 신고)
     * @return
     */
    public Integer selectCountByGuboon(@Param("boardId") int boardId,
                                       @Param("writeNo") int writeNo,
                                       @Param("commentId") int commentId,
                                       @Param("guboonId") String guboonId);

    /**
     * 추천, 반대, 신고 등록
     *
     * @param boardRecommend 추천/반대/신고
     * @return
     */
    public Integer insert(BoardRecommend boardRecommend);

    /**
     * 추천, 반대, 신고 삭제
     *
     * @param boardId 게시판 id
     * @param writeNo 게시글 no
     * @param commentId 댓글 id
     * @param guboonId 구분 id (1 : 추천, 2 : 반대, 3 : 신고)
     * @param userId 사용자 id
     * @return
     */
    public Integer delete(@Param("boardId") int boardId,
                          @Param("writeNo") int writeNo,
                          @Param("commentId") int commentId,
                          @Param("guboonId") String guboonId,
                          @Param("userId") int userId);

}

package lagom.demo.board.mapper;

import lagom.demo.board.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
    /* 게시글 조회 
    * @Param으로 식별자 적용 
    * - @Param을 붙여서 적용하지 않으면 프레임워크가 인식하지 못함*/
    public List<BoardDTO.Response> findAll(@Param("request") BoardDTO.Request req);

    /* 게시글 단건 조회*/
    public BoardDTO.Response findById(@Param("boardId") String boardId);

    /* 게시글 저장 */
    public int save(@Param("request") BoardDTO.RequestSave req);

    /* 게시글 수정 */
    public int updateById(@Param("request") BoardDTO.RequestSave req, @Param("boardId") String boardId);

    /* 게시글 삭제 */
    public int deleteById(@Param("boardId")String boardId);
}

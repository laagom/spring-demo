package lagom.demo.board.controller;

import lagom.demo.board.dto.BoardDTO;
import lagom.demo.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;
    
    /* 게시글 조회 */
    @GetMapping
    public List<BoardDTO.Response> getBoards(BoardDTO.Request req){
        return boardService.getBoards(req);
    }

    /* 게시글 단건 조회 */
    @GetMapping("/{boardId}")
    public BoardDTO.Response getBoard(@PathVariable("boardId") String boardId){
        return boardService.getBoard(boardId);
    }

    /* 게시글 저장 */
    @PostMapping
    public int saveBoard(@RequestBody BoardDTO.RequestSave req){
        return boardService.saveBoard(req);
    }

    /* 게시글 수정 */
    @PutMapping("/{boardId}")
    public int updateBoard(@RequestBody BoardDTO.RequestSave req,@PathVariable("boardId") String boardId) {
        return boardService.updateBoard(req, boardId);
    }

    /* 게시글 삭제 */
    @DeleteMapping("/{boardId}")
    public int deleteBoard(@PathVariable("boardId") String boardId){
        return boardService.deleteBoard(boardId);
    }
}

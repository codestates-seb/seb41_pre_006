package pre006.stackoverflow.domain.answer.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Validated
public class AnswerController {

    @PostMapping // 답변 추가
    public ResponseEntity postAnswer() {
        return ResponseEntity.ok(null);
    }

    @PatchMapping // 답변 수정
    public ResponseEntity patchAnswer() {
        return ResponseEntity.ok(null);
    }

    @GetMapping // 답변 검색
    public ResponseEntity getAnswer() {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping // 답변 삭제
    public ResponseEntity deleteAnswer() {
        return ResponseEntity.ok(null);
    }
}

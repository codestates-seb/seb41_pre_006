package pre006.stackoverflow.testdata;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pre006.stackoverflow.domain.answer.controller.AnswerController;
import pre006.stackoverflow.domain.answer.dto.AnswerPostDto;
import pre006.stackoverflow.domain.comment.controller.CommentController;
import pre006.stackoverflow.domain.comment.dto.CommentPostDto;
import pre006.stackoverflow.domain.question.controller.QuestionController;
import pre006.stackoverflow.domain.question.dto.QuestionDto;
import pre006.stackoverflow.domain.user.controller.UserController;
import pre006.stackoverflow.domain.user.dto.UserPostDto;

@Slf4j
@RequiredArgsConstructor
@Component
@Profile("ssh")
public class TestDataInit {
    private final UserController userController;
    private final QuestionController questionController;
    private final AnswerController answerController;
    private final CommentController commentController;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        log.info("test data init");
        // 유저 3명 등록
        userController.post(new UserPostDto("hgd@gmail.com", "홍길동", "1111",
                "저는 홍길동 입니다.", "서울"));
        userController.post(new UserPostDto("hgd2@gmail.com", "김코딩", "2222",
                "저는 김코딩 입니다.", "부산"));
        userController.post(new UserPostDto("hgd3@gmail.com", "박자바", "3333",
                "저는 박자바 입니다.", "고양"));

        // 질문 등록
        questionController.postQuestion(new QuestionDto.QuestionPostDto
                (1L, "홍길동의 첫번째 질문입니다.", "질문 내용입니다."));
        questionController.postQuestion(new QuestionDto.QuestionPostDto
                (1L, "홍길동의 두번째 질문입니다.", "두번째 질문 내용입니다."));
        questionController.postQuestion(new QuestionDto.QuestionPostDto
                (2L, "김코딩의 질문입니다.", "질문 내용입니다."));
        questionController.postQuestion(new QuestionDto.QuestionPostDto
                (3L, "박자바의 질문입니다.", "질문 내용입니다."));

        // 답변 등록
        answerController.postAnswer(1L, 2L,
                new AnswerPostDto("홍길동의 1번째 질문에 대한 답변입니다."));
        answerController.postAnswer(1L, 3L,
                new AnswerPostDto("홍길동의 1번째 질문에 대한 2번째 답변입니다."));
        answerController.postAnswer(2L, 2L,
                new AnswerPostDto("홍길동의 2번째 질문에 대한 답변입니다."));
        answerController.postAnswer(3L, 1L,
                new AnswerPostDto("김코딩의 질문에 대한 답변입니다."));
        answerController.postAnswer(3L, 3L,
                new AnswerPostDto("김코딩의 질문에 대한 2번째 답변입니다."));
        answerController.postAnswer(4L, 2L,
                new AnswerPostDto("박자바의 질문에 대한 답변입니다."));

        // 질문 댓글 등록
        commentController.postQuestionComment(1L, 1L,
                new CommentPostDto("홍길동의 1번째 질문에 대한 1번째 코멘트입니다."));
        commentController.postQuestionComment(2L, 1L,
                new CommentPostDto("홍길동의 1번째 질문에 대한 2번째 코멘트입니다."));
        commentController.postQuestionComment(3L, 1L,
                new CommentPostDto("홍길동의 1번째 질문에 대한 3번째 코멘트입니다."));
        commentController.postQuestionComment(1L, 2L,
                new CommentPostDto("홍길동의 2번째 질문에 대한 1번째 코멘트입니다."));
        commentController.postQuestionComment(1L, 3L,
                new CommentPostDto("김코딩의 질문에 대한 1번째 코멘트입니다."));
        commentController.postQuestionComment(3L, 3L,
                new CommentPostDto("김코딩의 질문에 대한 2번째 코멘트입니다."));

        // 답변 댓글 등록
        commentController.postAnswerComment(1L, 1L,
                new CommentPostDto("홍길동의 1번째 질문에 대한 1번째 답변의 1번째 코멘트입니다."));
        commentController.postAnswerComment(2L, 1L,
                new CommentPostDto("홍길동의 1번째 질문에 대한 1번째 답변의 2번째 코멘트입니다."));
        commentController.postAnswerComment(3L, 1L,
                new CommentPostDto("홍길동의 1번째 질문에 대한 1번째 답변의 3번째 코멘트입니다."));
        commentController.postAnswerComment(3L, 2L,
                new CommentPostDto("홍길동의 1번째 질문에 대한 2번째 답변의 1번째 코멘트입니다."));
        commentController.postAnswerComment(3L, 4L,
                new CommentPostDto("김코딩의 1번째 질문에 대한 1번째 답변의 1번째 코멘트입니다."));
        commentController.postAnswerComment(2L, 4L,
                new CommentPostDto("김코딩의 1번째 질문에 대한 1번째 답변의 2번째 코멘트입니다."));
    }

}

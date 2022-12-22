//package pre006.stackoverflow.domain.question.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import pre006.stackoverflow.domain.question.entity.Question;
//import pre006.stackoverflow.domain.question.entity.QuestionVote;
//import pre006.stackoverflow.domain.question.repository.QuestionRepository;
//
//import javax.transaction.Transactional;
//
//@Service
//@Slf4j
//public class QuestionVoteService {
//
//        private final QuestionRepository questionRepository;
//
//        public QuestionVoteService(QuestionRepository questionRepository) {
//            this.questionRepository = questionRepository;
//        }
//
//        @Transactional
//        public void addQuestionVote(Long questionId) {
//            Question question = questionRepository.findByQuestionId(questionId);
//            question.addQuestionVoteList(new QuestionVote());
//        }
//
//}

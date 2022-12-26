package pre006.stackoverflow.domain.question.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pre006.stackoverflow.domain.question.entity.Question;
import pre006.stackoverflow.domain.question.mapper.QuestionMapper;
import pre006.stackoverflow.domain.question.repository.QuestionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {


    private final QuestionRepository questionRepository;



    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question) {

        Optional<Question> questionOptional = questionRepository.findById(question.getQuestionId());
        if (questionOptional.isPresent()) {
            Question question1 = questionOptional.get();
            question1.setTitle(question.getTitle());
            question1.setContent(question.getContent());
            return questionRepository.save(question1);
        }
        return questionRepository.save(question);


    }

    public void deleteQuestion(long questionId) {
        questionRepository.deleteById(questionId);

    }

    public Question getQuestion(long questionId) {

    Question findQuestion = questionRepository.findById(questionId).get();
   // findQuestion.setViewCount(findQuestion.getViewCount()+1);
    questionRepository.save(findQuestion);
    return findQuestion;
    }



}

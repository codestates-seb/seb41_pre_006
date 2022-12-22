package pre006.stackoverflow.global.exceptionHandler;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

/**
 * 글로벌 예외 처리 클래스 <br>
 * ex) UserService.findById() 메서드를 보면, Optional 값이 null이면 NoSuchElementException을 throw 한다. <br>
 * 해당 예외가 발생하면 message에 "No Such User" 라고 메시지를 적어서 보냈고 <br>
 * 이를 본 클래스가 잡아서 처리한다.
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 서비스 계층의 Optional<> null 값인 경우의 예외 처리 <br>
     * 리포지토리 계층의 remove(id) 값이 없을 때의 예외 처리
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class})
    public ErrorResult handleNoSuchElementException(RuntimeException e) {
        return new ErrorResult("404 NOT FOUND", e.getMessage());
    }
}

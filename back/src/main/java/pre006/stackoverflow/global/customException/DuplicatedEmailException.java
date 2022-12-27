package pre006.stackoverflow.global.customException;

public class DuplicatedEmailException extends RuntimeException{

    public DuplicatedEmailException() {
    }

    public DuplicatedEmailException(String message) {
        super(message);
    }
}

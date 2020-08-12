package tn.enis.bookstrore.web.exception;

public class GlobalException extends Exception {

    GlobalException(String message) {
        super(message);
    }

    GlobalException(String message, Throwable throwable) {
        super(message, throwable);
    }

    GlobalException(Throwable throwable) {
        super(throwable);
    }
}

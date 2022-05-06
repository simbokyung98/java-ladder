package ladder.exception;

public class InvalidNumberOfParticipants extends RuntimeException {
    private static final String MESSAGE = "ERROR] 참여자 수는 최소 2명 이상이어야 합니다.";

    public InvalidNumberOfParticipants() {
        super(MESSAGE);
    }
}

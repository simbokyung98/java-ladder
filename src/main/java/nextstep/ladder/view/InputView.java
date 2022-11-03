package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] inputPerson() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        try {
            return SCANNER.nextLine().trim().split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력 값입니다.", e);
        }
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return SCANNER.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다", e);
        }
    }
}

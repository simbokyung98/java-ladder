package ladderWithInterface.custom;

import ladderWithInterface.engin.CoordinateGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    private static final CoordinateGenerator COORDINATE_GENERATION = new ManualCoordinateGenerator();

    private Direction direction;

    @BeforeEach
    void create() {
        direction = Direction.first(COORDINATE_GENERATION.generate());
    }

    @Test
    @DisplayName("사다리의 처음 생성 확인")
    void 사다리_생성() {
        assertThat(direction.isRight()).isTrue();
    }

    @Test
    @DisplayName("사다리의 이전 죄표가 연결되어 있을 경우 다음 좌표는 연결하지 않음")
    void 사다리_다음좌표_연결확인() {
        Direction result = direction.next(COORDINATE_GENERATION.generate());
        assertThat(result.isRight()).isFalse();
    }

    @Test
    @DisplayName("사다리의 이전 죄표가 연결되어 있을 경우 다음 좌표는 연결하지 않음")
    void 사다리_마지막_연결확인() {
        Direction result = direction.end();
        assertThat(result.isRight()).isFalse();
    }

    @Test
    @DisplayName("사다리 좌표가 어디로 이동할 수 있는지 리턴")
    void 이동위치_확인() {
        assertThat(direction.move()).isEqualTo(1);
    }
}
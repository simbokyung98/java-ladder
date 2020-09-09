package cc.oakk.ladder.model.line;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 7, 8 })
    public void width(int width) {
        assertThat(new Line(width).width()).isEqualTo(width);
    }

    @Test
    public void connect() {
        final Line line = new Line(6);
        assertThat(line.isConnected(0)).isEqualTo(Connection.FALSE);
        line.connect(0);
        assertThat(line.isConnected(0)).isEqualTo(Connection.TRUE);

        line.connect(2, 4);
        assertThat(line.isConnected(2)).isEqualTo(Connection.TRUE);
        assertThat(line.isConnected(4)).isEqualTo(Connection.TRUE);
    }

    @Test
    public void connect_ShouldThrow() {
        final Line line = new Line(4);
        line.connect(0);
        assertThatIllegalArgumentException().isThrownBy(() -> line.connect(1));
        assertThatIllegalArgumentException().isThrownBy(() -> line.connect(3));
    }
}
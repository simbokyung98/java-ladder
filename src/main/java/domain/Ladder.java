package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int length, int height) {
        IntStream.range(0, height)
            .mapToObj(i -> Line.newLine(length, new Random()::nextBoolean))
            .forEach(lines::add);
    }

    public Integer search(Integer location) {
        for (Line line : lines) {
            location = line.move(location);
        }

        return location;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return lines.stream()
            .map(Line::toString)
            .collect(Collectors.joining("\n"));
    }
}
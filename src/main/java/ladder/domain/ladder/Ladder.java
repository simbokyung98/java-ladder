package ladder.domain.ladder;


import java.util.List;
import ladder.domain.strategy.NextPointGenerationStrategy;

public class Ladder {

  private final Lines lines;

  private Ladder(Lines lines) {
    this.lines = lines;
  }

  public static Ladder createLadder(LadderSizeInfo sizeInfo, NextPointGenerationStrategy generationStrategy) {
    Lines lines = Lines.createLines(sizeInfo, generationStrategy);
    return new Ladder(lines);
  }


  public int height() {
    return lines.height();
  }

  public List<Boolean> getRow(int rowNumber) {
    return lines.getRow(rowNumber).getPoints();
  }

  public int getIndexOfResult(int startIndex) {
    return lines.getLastIndex(startIndex);
  }


}

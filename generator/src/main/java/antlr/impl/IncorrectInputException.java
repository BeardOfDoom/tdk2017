package antlr.impl;

public class IncorrectInputException extends RuntimeException {

  private final int line;

  private final int charPositionInLine;

  private final String msg;

  public IncorrectInputException(IncorrectInputException e) {
    this.line = e.line;
    this.charPositionInLine = e.charPositionInLine;
    this.msg = e.msg;
  }

  public IncorrectInputException(int line, int charPositionInLine, String msg) {
    this.line = line;
    this.charPositionInLine = charPositionInLine;
    this.msg = msg;
  }

  public int getLine() {
    return line;
  }

  public int getCharPositionInLine() {
    return charPositionInLine;
  }

  public String getMsg() {
    return msg;
  }
}

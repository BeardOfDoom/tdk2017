package representations;

public class ErrorRepresentation {
  Integer line;
  Integer positionInLine;
  String offendingToken;
  String message;

  public ErrorRepresentation() {
  }

  public ErrorRepresentation(Integer line, Integer positionInLine, String offendingToken,
      String message) {
    this.line = line;
    this.positionInLine = positionInLine;
    this.offendingToken = offendingToken;
    this.message = message;
  }

  public Integer getLine() {
    return line;
  }

  public void setLine(Integer line) {
    this.line = line;
  }

  public Integer getPositionInLine() {
    return positionInLine;
  }

  public void setPositionInLine(Integer positionInLine) {
    this.positionInLine = positionInLine;
  }

  public String getOffendingToken() {
    return offendingToken;
  }

  public void setOffendingToken(String offendingToken) {
    this.offendingToken = offendingToken;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}

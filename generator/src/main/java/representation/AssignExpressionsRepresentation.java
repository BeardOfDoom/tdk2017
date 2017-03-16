package representation;

import java.util.ArrayList;
import java.util.List;

public class AssignExpressionsRepresentation {

  List<SetAssignRepresentation> setAssigns = new ArrayList<>();
  List<MatrixAssignRepresentation> matrixAssigns = new ArrayList<>();

  public AssignExpressionsRepresentation() {
  }

  public AssignExpressionsRepresentation(
      List<SetAssignRepresentation> setAssigns,
      List<MatrixAssignRepresentation> matrixAssigns) {
    this.setAssigns = setAssigns;
    this.matrixAssigns = matrixAssigns;
  }

  public List<SetAssignRepresentation> getSetAssigns() {
    return setAssigns;
  }

  public void setSetAssigns(List<SetAssignRepresentation> setAssigns) {
    this.setAssigns = setAssigns;
  }

  public List<MatrixAssignRepresentation> getMatrixAssigns() {
    return matrixAssigns;
  }

  public void setMatrixAssigns(List<MatrixAssignRepresentation> matrixAssigns) {
    this.matrixAssigns = matrixAssigns;
  }

  public void addSetAssignment(SetAssignRepresentation representation) {
    setAssigns.add(representation);
  }

  public void addMatrixAssignment(MatrixAssignRepresentation representation) {
    matrixAssigns.add(representation);
  }
}

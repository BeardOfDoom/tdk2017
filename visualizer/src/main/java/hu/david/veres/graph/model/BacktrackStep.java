package hu.david.veres.graph.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BacktrackStep implements Step {

    private boolean back;
    private String operatorId;
    private String nodeId;

}

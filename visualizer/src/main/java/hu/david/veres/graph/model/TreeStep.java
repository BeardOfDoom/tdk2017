package hu.david.veres.graph.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class TreeStep implements Step {

    private List<String> openedOperatorIds;
    private List<String> openedNodeIds;
    private String operatorId;
    private String nodeId;

    public TreeStep() {
        openedOperatorIds = new ArrayList<>();
        openedNodeIds = new ArrayList<>();
    }

}

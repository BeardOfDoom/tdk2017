package hu.david.veres.graph.form;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProblemForm {

    private String stateSpace;
    private List<String> algorithms;
    private String heuristic;

}

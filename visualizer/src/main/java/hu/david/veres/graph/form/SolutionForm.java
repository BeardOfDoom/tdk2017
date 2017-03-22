package hu.david.veres.graph.form;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SolutionForm {

    private List<String> algorithms;
    private String heuristic;

}

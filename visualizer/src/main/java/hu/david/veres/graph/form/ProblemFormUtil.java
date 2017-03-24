package hu.david.veres.graph.form;

import model.UserInput;

public final class ProblemFormUtil {

    private ProblemFormUtil() {
    }

    public static UserInput extractUserInput(ProblemForm problemForm) {

        String heuristicFunction = problemForm.getHeuristic();
        boolean doBackTrackSimple = problemForm.getAlgorithms().contains("BackTrackSimple");
        boolean doBackTrackCircle = problemForm.getAlgorithms().contains("BackTrackCircle");
        boolean doBackTrackPathLengthLimitation = problemForm.getAlgorithms().contains("BackTrackPathLengthLimitation");
        boolean doBackTrackOptimal = problemForm.getAlgorithms().contains("BackTrackOptimal");
        boolean doBreadthFirst = problemForm.getAlgorithms().contains("BreadthFirst");
        boolean doDepthFirst = problemForm.getAlgorithms().contains("DepthFirst");
        boolean doOptimal = problemForm.getAlgorithms().contains("Optimal");
        boolean doBestFirst = problemForm.getAlgorithms().contains("BestFirst");
        boolean doA = problemForm.getAlgorithms().contains("A");

        UserInput userInput = new UserInput(heuristicFunction, doBackTrackSimple, doBackTrackCircle, doBackTrackPathLengthLimitation, doBackTrackOptimal, doBreadthFirst, doDepthFirst, doOptimal, doBestFirst, doA);

        return userInput;
    }

}

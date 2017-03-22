package hu.david.veres.graph.form;

import model.UserInput;

public final class SolutionFormToUserInputConverter {

    private SolutionFormToUserInputConverter() {
    }

    public static UserInput convert(SolutionForm solutionForm) {

        String heuristicFunction = solutionForm.getHeuristic();
        boolean doBackTrackSimple = solutionForm.getAlgorithms().contains("BackTrackSimple");
        boolean doBackTrackCircle = solutionForm.getAlgorithms().contains("BackTrackCircle");
        boolean doBackTrackPathLengthLimitation = solutionForm.getAlgorithms().contains("BackTrackPathLengthLimitation");
        boolean doBackTrackOptimal = solutionForm.getAlgorithms().contains("BackTrackOptimal");
        boolean doBreadthFirst = solutionForm.getAlgorithms().contains("BreadthFirst");
        boolean doDepthFirst = solutionForm.getAlgorithms().contains("DepthFirst");
        boolean doOptimal = solutionForm.getAlgorithms().contains("Optimal");
        boolean doBestFirst = solutionForm.getAlgorithms().contains("BestFirst");
        boolean doA = solutionForm.getAlgorithms().contains("A");

        UserInput userInput = new UserInput(heuristicFunction, doBackTrackSimple, doBackTrackCircle, doBackTrackPathLengthLimitation, doBackTrackOptimal, doBreadthFirst, doDepthFirst, doOptimal, doBestFirst, doA);

        return userInput;
    }

}

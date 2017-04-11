package hu.david.veres.graph.validator;

import hu.david.veres.graph.form.ProblemForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProblemFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ProblemForm.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ProblemForm problemForm = (ProblemForm) o;

        // validate state-space textarea
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stateSpace", "State-space can't be empty!");

        // validate search algorithms
        ValidationUtils.rejectIfEmpty(errors, "algorithms", "You must choose at least one algorithm!");

        // validate limits
        if (problemForm.getAlgorithms().contains("BackTrackPathLengthLimitation")) {

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "backTrackPathLengthLimitationLimit", "You must declare the limit for the Backtrack with pathlength limitation algorithm!");

            // validate limit value
            if (problemForm.getBackTrackPathLengthLimitationLimit() <= 0) {
                errors.rejectValue("backTrackPathLengthLimitationLimit", "Backtrack with pathlength limitation algorithm's limit must be greater than 0!");
            }

        }

        if (problemForm.getAlgorithms().contains("BackTrackOptimal")) {

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "backTrackOptimalLimit", "You must declare the limit for the Backtrack branch and bound algorithm!");

            // validate limit value
            if (problemForm.getBackTrackOptimalLimit() <= 0) {
                errors.rejectValue("backTrackPathLengthLimitationLimit", "Backtrack branch and bound algorithm's limit must be greater than 0!");
            }

        }

    }

}

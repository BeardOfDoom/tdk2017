package hu.david.veres.graph.validator;

import hu.david.veres.graph.exception.result.ResultValidationException;
import hu.david.veres.graph.model.Result;

public interface ResultValidator {

    void validate(Result result) throws ResultValidationException;

}

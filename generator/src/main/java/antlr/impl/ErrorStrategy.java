package antlr.impl;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;

public class ErrorStrategy extends DefaultErrorStrategy {

  @Override
  protected void reportInputMismatch(Parser recognizer, InputMismatchException e) {
    System.out.println("input mismatch");
    String msg = "mismatched input " + getTokenErrorDisplay(e.getOffendingToken()) +
        " expecting " + e.getExpectedTokens().toString(recognizer.getVocabulary());
    recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
  }

  @Override
  protected void reportFailedPredicate(Parser recognizer, FailedPredicateException e) {
    System.out.println("failed predicate");
    super.reportFailedPredicate(recognizer, e);
  }

  @Override
  protected void reportUnwantedToken(Parser recognizer) {
    System.out.println("unwanted token");
    super.reportUnwantedToken(recognizer);
  }

  @Override
  protected void reportMissingToken(Parser recognizer) {
    System.out.println("missing token");
    super.reportMissingToken(recognizer);
  }

  @Override
  protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e) {
    System.out.println("no viable alternative");
    super.reportNoViableAlternative(recognizer, e);
  }


}

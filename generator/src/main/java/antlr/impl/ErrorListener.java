package antlr.impl;

import java.util.BitSet;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class ErrorListener extends BaseErrorListener {

  @Override
  public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
      int charPositionInLine, String msg, RecognitionException e) {

    System.out.println("ErrorListener: syntax");

    super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
  }

  @Override
  public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
      boolean exact, BitSet ambigAlts, ATNConfigSet configs) {

    System.out.println("ErrorListener: ambiguity");

    super.reportAmbiguity(recognizer, dfa, startIndex, stopIndex, exact, ambigAlts, configs);
  }

  @Override
  public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
      BitSet conflictingAlts, ATNConfigSet configs) {

    System.out.println("ErrorListener: attempting");
    super.reportAttemptingFullContext(recognizer, dfa, startIndex, stopIndex, conflictingAlts,
        configs);
  }

  @Override
  public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
      int prediction, ATNConfigSet configs) {
    System.out.println("ErrorListener: sensitivity");
    super.reportContextSensitivity(recognizer, dfa, startIndex, stopIndex, prediction, configs);
  }
}

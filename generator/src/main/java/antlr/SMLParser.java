// Generated from D:/Laci/egyetem/szakdolgozat/SML/src/main/java/antlr\SML.g4 by ANTLR 4.6
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SMLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD_PARAM=1, KEYWORD_FROM=2, KEYWORD_TO=3, KEYWORD_BY=4, KEYWORD_TIMES=5, 
		KEYWORD_ATTRIBUTE=6, KEYWORD_VAR=7, KEYWORD_COST=8, KEYWORD_IS=9, KEYWORD_OF=10, 
		KEYWORD_SET=11, KEYWORD_MATRIX=12, KEYWORD_WORD=13, KEYWORD_NUMBER=14, 
		SYMBOL_EQUAL=15, SYMBOL_NOT_EQUAL=16, SYMBOL_LESSER=17, SYMBOL_GREATER=18, 
		SYMBOL_LESSER_OR_EQUAL=19, SYMBOL_GREATER_OR_EQUAL=20, SYMBOL_ADDITION=21, 
		SYMBOL_SUBSTRACT=22, SYMBOL_MULTIPLICATION=23, SYMBOL_DIVISION=24, SYMBOL_ASSIGN=25, 
		SYMBOL_REFERENCE=26, SYMBOL_QUOTE=27, SYMBOL_COMMA=28, SYMBOL_LPAREN=29, 
		SYMBOL_RPAREN=30, SYMBOL_LBRACE=31, SYMBOL_RBRACE=32, SYMBOL_LBRACK=33, 
		SYMOBL_RBRACK=34, KEYWORD_MAXIMUM=35, KEYWORD_MINIMUM=36, KEYWORD_AVERAGE=37, 
		KEYWORD_CARDINALITY=38, KEYWORD_AND=39, KEYWORD_OR=40, KEYWORD_NOT=41, 
		STATE_ATTRIBUTES_DELIMITER=42, STATE_START_DELIMITER=43, STATE_GOAL_DELIMITER=44, 
		OPERATOR_DELIMITER=45, OPERATOR_DESCRIPTION_DELIMITER=46, OPERATOR_PRECONDITION_DELIMITER=47, 
		OPERATOR_EFFECT_DELIMITER=48, INT=49, FLOAT=50, SIGN=51, CHAR=52, WS=53;
	public static final int
		RULE_expr = 0, RULE_state_expr = 1, RULE_state_description = 2, RULE_state_description_line = 3, 
		RULE_state_start = 4, RULE_state_goal = 5, RULE_operation_expr = 6, RULE_operation_description = 7, 
		RULE_operator_cost = 8, RULE_operator_precondition = 9, RULE_operator_effect = 10, 
		RULE_attr_struct = 11, RULE_attr_type = 12, RULE_comparator = 13, RULE_binary_operator = 14, 
		RULE_unary_operator = 15, RULE_boolean_operator = 16, RULE_var_defining_expression = 17, 
		RULE_assign_expression = 18, RULE_expression = 19, RULE_init_statement = 20, 
		RULE_parameter_description_line = 21, RULE_attr_name = 22, RULE_attr_reference = 23, 
		RULE_matrix_reference = 24, RULE_reference = 25, RULE_dimension_part = 26, 
		RULE_dimension = 27, RULE_number = 28, RULE_numbers = 29, RULE_words = 30, 
		RULE_word = 31, RULE_name = 32;
	public static final String[] ruleNames = {
		"expr", "state_expr", "state_description", "state_description_line", "state_start", 
		"state_goal", "operation_expr", "operation_description", "operator_cost", 
		"operator_precondition", "operator_effect", "attr_struct", "attr_type", 
		"comparator", "binary_operator", "unary_operator", "boolean_operator", 
		"var_defining_expression", "assign_expression", "expression", "init_statement", 
		"parameter_description_line", "attr_name", "attr_reference", "matrix_reference", 
		"reference", "dimension_part", "dimension", "number", "numbers", "words", 
		"word", "name"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'param'", "'from'", "'to'", "'by'", "'times'", "'Attr'", "'var'", 
		"'cost'", "'is'", "'of'", "'set'", "'matrix'", "'word'", "'number'", "'=='", 
		"'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'='", 
		"'$'", "'\"'", "','", "'('", "')'", "'{'", "'}'", "'['", "']'", "'max'", 
		"'min'", "'avg'", "'card'", "'and'", "'or'", "'not'", "'STATE_ATTRIBUTES:'", 
		"'STATE_START:'", "'STATE_GOAL:'", "'OPERATORS:'", "'OPERATOR_DESCRIPTION:'", 
		"'OPERATOR_PRECONDITION:'", "'OPERATOR_EFFECT:'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD_PARAM", "KEYWORD_FROM", "KEYWORD_TO", "KEYWORD_BY", "KEYWORD_TIMES", 
		"KEYWORD_ATTRIBUTE", "KEYWORD_VAR", "KEYWORD_COST", "KEYWORD_IS", "KEYWORD_OF", 
		"KEYWORD_SET", "KEYWORD_MATRIX", "KEYWORD_WORD", "KEYWORD_NUMBER", "SYMBOL_EQUAL", 
		"SYMBOL_NOT_EQUAL", "SYMBOL_LESSER", "SYMBOL_GREATER", "SYMBOL_LESSER_OR_EQUAL", 
		"SYMBOL_GREATER_OR_EQUAL", "SYMBOL_ADDITION", "SYMBOL_SUBSTRACT", "SYMBOL_MULTIPLICATION", 
		"SYMBOL_DIVISION", "SYMBOL_ASSIGN", "SYMBOL_REFERENCE", "SYMBOL_QUOTE", 
		"SYMBOL_COMMA", "SYMBOL_LPAREN", "SYMBOL_RPAREN", "SYMBOL_LBRACE", "SYMBOL_RBRACE", 
		"SYMBOL_LBRACK", "SYMOBL_RBRACK", "KEYWORD_MAXIMUM", "KEYWORD_MINIMUM", 
		"KEYWORD_AVERAGE", "KEYWORD_CARDINALITY", "KEYWORD_AND", "KEYWORD_OR", 
		"KEYWORD_NOT", "STATE_ATTRIBUTES_DELIMITER", "STATE_START_DELIMITER", 
		"STATE_GOAL_DELIMITER", "OPERATOR_DELIMITER", "OPERATOR_DESCRIPTION_DELIMITER", 
		"OPERATOR_PRECONDITION_DELIMITER", "OPERATOR_EFFECT_DELIMITER", "INT", 
		"FLOAT", "SIGN", "CHAR", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SML.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SMLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExprContext extends ParserRuleContext {
		public State_exprContext state_expr() {
			return getRuleContext(State_exprContext.class,0);
		}
		public TerminalNode OPERATOR_DELIMITER() { return getToken(SMLParser.OPERATOR_DELIMITER, 0); }
		public TerminalNode EOF() { return getToken(SMLParser.EOF, 0); }
		public List<Operation_exprContext> operation_expr() {
			return getRuleContexts(Operation_exprContext.class);
		}
		public Operation_exprContext operation_expr(int i) {
			return getRuleContext(Operation_exprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			state_expr();
			setState(67);
			match(OPERATOR_DELIMITER);
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				operation_expr();
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPERATOR_DESCRIPTION_DELIMITER );
			setState(73);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_exprContext extends ParserRuleContext {
		public State_descriptionContext state_description() {
			return getRuleContext(State_descriptionContext.class,0);
		}
		public State_startContext state_start() {
			return getRuleContext(State_startContext.class,0);
		}
		public State_goalContext state_goal() {
			return getRuleContext(State_goalContext.class,0);
		}
		public State_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterState_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitState_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitState_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_exprContext state_expr() throws RecognitionException {
		State_exprContext _localctx = new State_exprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_state_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			state_description();
			setState(76);
			state_start();
			setState(77);
			state_goal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_descriptionContext extends ParserRuleContext {
		public TerminalNode STATE_ATTRIBUTES_DELIMITER() { return getToken(SMLParser.STATE_ATTRIBUTES_DELIMITER, 0); }
		public List<State_description_lineContext> state_description_line() {
			return getRuleContexts(State_description_lineContext.class);
		}
		public State_description_lineContext state_description_line(int i) {
			return getRuleContext(State_description_lineContext.class,i);
		}
		public State_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterState_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitState_description(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitState_description(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_descriptionContext state_description() throws RecognitionException {
		State_descriptionContext _localctx = new State_descriptionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_state_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(STATE_ATTRIBUTES_DELIMITER);
			setState(81); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(80);
				state_description_line();
				}
				}
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==KEYWORD_ATTRIBUTE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_description_lineContext extends ParserRuleContext {
		public Attr_nameContext attr_name() {
			return getRuleContext(Attr_nameContext.class,0);
		}
		public TerminalNode KEYWORD_IS() { return getToken(SMLParser.KEYWORD_IS, 0); }
		public Attr_structContext attr_struct() {
			return getRuleContext(Attr_structContext.class,0);
		}
		public TerminalNode KEYWORD_OF() { return getToken(SMLParser.KEYWORD_OF, 0); }
		public Attr_typeContext attr_type() {
			return getRuleContext(Attr_typeContext.class,0);
		}
		public State_description_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_description_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterState_description_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitState_description_line(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitState_description_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_description_lineContext state_description_line() throws RecognitionException {
		State_description_lineContext _localctx = new State_description_lineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_state_description_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			attr_name();
			setState(86);
			match(KEYWORD_IS);
			setState(87);
			attr_struct();
			setState(88);
			match(KEYWORD_OF);
			setState(89);
			attr_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_startContext extends ParserRuleContext {
		public TerminalNode STATE_START_DELIMITER() { return getToken(SMLParser.STATE_START_DELIMITER, 0); }
		public List<Parameter_description_lineContext> parameter_description_line() {
			return getRuleContexts(Parameter_description_lineContext.class);
		}
		public Parameter_description_lineContext parameter_description_line(int i) {
			return getRuleContext(Parameter_description_lineContext.class,i);
		}
		public List<Assign_expressionContext> assign_expression() {
			return getRuleContexts(Assign_expressionContext.class);
		}
		public Assign_expressionContext assign_expression(int i) {
			return getRuleContext(Assign_expressionContext.class,i);
		}
		public State_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterState_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitState_start(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitState_start(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_startContext state_start() throws RecognitionException {
		State_startContext _localctx = new State_startContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_state_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(STATE_START_DELIMITER);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KEYWORD_PARAM) {
				{
				{
				setState(92);
				parameter_description_line();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(98);
				assign_expression();
				}
				}
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SYMBOL_REFERENCE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_goalContext extends ParserRuleContext {
		public TerminalNode STATE_GOAL_DELIMITER() { return getToken(SMLParser.STATE_GOAL_DELIMITER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<Parameter_description_lineContext> parameter_description_line() {
			return getRuleContexts(Parameter_description_lineContext.class);
		}
		public Parameter_description_lineContext parameter_description_line(int i) {
			return getRuleContext(Parameter_description_lineContext.class,i);
		}
		public State_goalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_goal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterState_goal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitState_goal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitState_goal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_goalContext state_goal() throws RecognitionException {
		State_goalContext _localctx = new State_goalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_state_goal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(STATE_GOAL_DELIMITER);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KEYWORD_PARAM) {
				{
				{
				setState(104);
				parameter_description_line();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operation_exprContext extends ParserRuleContext {
		public Operation_descriptionContext operation_description() {
			return getRuleContext(Operation_descriptionContext.class,0);
		}
		public Operator_preconditionContext operator_precondition() {
			return getRuleContext(Operator_preconditionContext.class,0);
		}
		public Operator_effectContext operator_effect() {
			return getRuleContext(Operator_effectContext.class,0);
		}
		public Operation_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOperation_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOperation_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOperation_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operation_exprContext operation_expr() throws RecognitionException {
		Operation_exprContext _localctx = new Operation_exprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_operation_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			operation_description();
			setState(113);
			operator_precondition();
			setState(114);
			operator_effect();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operation_descriptionContext extends ParserRuleContext {
		public TerminalNode OPERATOR_DESCRIPTION_DELIMITER() { return getToken(SMLParser.OPERATOR_DESCRIPTION_DELIMITER, 0); }
		public Operator_costContext operator_cost() {
			return getRuleContext(Operator_costContext.class,0);
		}
		public List<Parameter_description_lineContext> parameter_description_line() {
			return getRuleContexts(Parameter_description_lineContext.class);
		}
		public Parameter_description_lineContext parameter_description_line(int i) {
			return getRuleContext(Parameter_description_lineContext.class,i);
		}
		public Operation_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOperation_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOperation_description(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOperation_description(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operation_descriptionContext operation_description() throws RecognitionException {
		Operation_descriptionContext _localctx = new Operation_descriptionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_operation_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(OPERATOR_DESCRIPTION_DELIMITER);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_COST) {
				{
				setState(117);
				operator_cost();
				}
			}

			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KEYWORD_PARAM) {
				{
				{
				setState(120);
				parameter_description_line();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_costContext extends ParserRuleContext {
		public TerminalNode KEYWORD_COST() { return getToken(SMLParser.KEYWORD_COST, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public Operator_costContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_cost; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOperator_cost(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOperator_cost(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOperator_cost(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_costContext operator_cost() throws RecognitionException {
		Operator_costContext _localctx = new Operator_costContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_operator_cost);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(KEYWORD_COST);
			setState(127);
			number();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_preconditionContext extends ParserRuleContext {
		public TerminalNode OPERATOR_PRECONDITION_DELIMITER() { return getToken(SMLParser.OPERATOR_PRECONDITION_DELIMITER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Operator_preconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_precondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOperator_precondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOperator_precondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOperator_precondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_preconditionContext operator_precondition() throws RecognitionException {
		Operator_preconditionContext _localctx = new Operator_preconditionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_operator_precondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(OPERATOR_PRECONDITION_DELIMITER);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SYMBOL_REFERENCE) | (1L << SYMBOL_QUOTE) | (1L << SYMBOL_LPAREN) | (1L << KEYWORD_MAXIMUM) | (1L << KEYWORD_MINIMUM) | (1L << KEYWORD_AVERAGE) | (1L << KEYWORD_CARDINALITY) | (1L << INT) | (1L << FLOAT) | (1L << SIGN) | (1L << CHAR))) != 0)) {
				{
				setState(130);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_effectContext extends ParserRuleContext {
		public TerminalNode OPERATOR_EFFECT_DELIMITER() { return getToken(SMLParser.OPERATOR_EFFECT_DELIMITER, 0); }
		public List<Var_defining_expressionContext> var_defining_expression() {
			return getRuleContexts(Var_defining_expressionContext.class);
		}
		public Var_defining_expressionContext var_defining_expression(int i) {
			return getRuleContext(Var_defining_expressionContext.class,i);
		}
		public List<Assign_expressionContext> assign_expression() {
			return getRuleContexts(Assign_expressionContext.class);
		}
		public Assign_expressionContext assign_expression(int i) {
			return getRuleContext(Assign_expressionContext.class,i);
		}
		public Operator_effectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_effect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOperator_effect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOperator_effect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOperator_effect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_effectContext operator_effect() throws RecognitionException {
		Operator_effectContext _localctx = new Operator_effectContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_operator_effect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(OPERATOR_EFFECT_DELIMITER);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KEYWORD_VAR) {
				{
				{
				setState(134);
				var_defining_expression();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(140);
				assign_expression();
				}
				}
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SYMBOL_REFERENCE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_structContext extends ParserRuleContext {
		public TerminalNode KEYWORD_SET() { return getToken(SMLParser.KEYWORD_SET, 0); }
		public TerminalNode KEYWORD_MATRIX() { return getToken(SMLParser.KEYWORD_MATRIX, 0); }
		public DimensionContext dimension() {
			return getRuleContext(DimensionContext.class,0);
		}
		public Attr_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_struct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterAttr_struct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitAttr_struct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitAttr_struct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_structContext attr_struct() throws RecognitionException {
		Attr_structContext _localctx = new Attr_structContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attr_struct);
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEYWORD_SET:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				match(KEYWORD_SET);
				}
				break;
			case KEYWORD_MATRIX:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(146);
				match(KEYWORD_MATRIX);
				setState(147);
				dimension();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_typeContext extends ParserRuleContext {
		public TerminalNode KEYWORD_WORD() { return getToken(SMLParser.KEYWORD_WORD, 0); }
		public TerminalNode KEYWORD_NUMBER() { return getToken(SMLParser.KEYWORD_NUMBER, 0); }
		public Attr_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterAttr_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitAttr_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitAttr_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_typeContext attr_type() throws RecognitionException {
		Attr_typeContext _localctx = new Attr_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_attr_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_la = _input.LA(1);
			if ( !(_la==KEYWORD_WORD || _la==KEYWORD_NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparatorContext extends ParserRuleContext {
		public TerminalNode SYMBOL_EQUAL() { return getToken(SMLParser.SYMBOL_EQUAL, 0); }
		public TerminalNode SYMBOL_NOT_EQUAL() { return getToken(SMLParser.SYMBOL_NOT_EQUAL, 0); }
		public TerminalNode SYMBOL_GREATER() { return getToken(SMLParser.SYMBOL_GREATER, 0); }
		public TerminalNode SYMBOL_LESSER() { return getToken(SMLParser.SYMBOL_LESSER, 0); }
		public TerminalNode SYMBOL_GREATER_OR_EQUAL() { return getToken(SMLParser.SYMBOL_GREATER_OR_EQUAL, 0); }
		public TerminalNode SYMBOL_LESSER_OR_EQUAL() { return getToken(SMLParser.SYMBOL_LESSER_OR_EQUAL, 0); }
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SYMBOL_EQUAL) | (1L << SYMBOL_NOT_EQUAL) | (1L << SYMBOL_LESSER) | (1L << SYMBOL_GREATER) | (1L << SYMBOL_LESSER_OR_EQUAL) | (1L << SYMBOL_GREATER_OR_EQUAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_operatorContext extends ParserRuleContext {
		public TerminalNode SYMBOL_ADDITION() { return getToken(SMLParser.SYMBOL_ADDITION, 0); }
		public TerminalNode SYMBOL_SUBSTRACT() { return getToken(SMLParser.SYMBOL_SUBSTRACT, 0); }
		public TerminalNode SYMBOL_MULTIPLICATION() { return getToken(SMLParser.SYMBOL_MULTIPLICATION, 0); }
		public TerminalNode SYMBOL_DIVISION() { return getToken(SMLParser.SYMBOL_DIVISION, 0); }
		public Binary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterBinary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitBinary_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitBinary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_operatorContext binary_operator() throws RecognitionException {
		Binary_operatorContext _localctx = new Binary_operatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_binary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SYMBOL_ADDITION) | (1L << SYMBOL_SUBSTRACT) | (1L << SYMBOL_MULTIPLICATION) | (1L << SYMBOL_DIVISION))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_operatorContext extends ParserRuleContext {
		public TerminalNode KEYWORD_MAXIMUM() { return getToken(SMLParser.KEYWORD_MAXIMUM, 0); }
		public TerminalNode KEYWORD_MINIMUM() { return getToken(SMLParser.KEYWORD_MINIMUM, 0); }
		public TerminalNode KEYWORD_AVERAGE() { return getToken(SMLParser.KEYWORD_AVERAGE, 0); }
		public TerminalNode KEYWORD_CARDINALITY() { return getToken(SMLParser.KEYWORD_CARDINALITY, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitUnary_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitUnary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEYWORD_MAXIMUM) | (1L << KEYWORD_MINIMUM) | (1L << KEYWORD_AVERAGE) | (1L << KEYWORD_CARDINALITY))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_operatorContext extends ParserRuleContext {
		public TerminalNode KEYWORD_AND() { return getToken(SMLParser.KEYWORD_AND, 0); }
		public TerminalNode KEYWORD_OR() { return getToken(SMLParser.KEYWORD_OR, 0); }
		public Boolean_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterBoolean_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitBoolean_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitBoolean_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_operatorContext boolean_operator() throws RecognitionException {
		Boolean_operatorContext _localctx = new Boolean_operatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_boolean_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_la = _input.LA(1);
			if ( !(_la==KEYWORD_AND || _la==KEYWORD_OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_defining_expressionContext extends ParserRuleContext {
		public TerminalNode KEYWORD_VAR() { return getToken(SMLParser.KEYWORD_VAR, 0); }
		public Attr_typeContext attr_type() {
			return getRuleContext(Attr_typeContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode SYMBOL_ASSIGN() { return getToken(SMLParser.SYMBOL_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Var_defining_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_defining_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterVar_defining_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitVar_defining_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitVar_defining_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_defining_expressionContext var_defining_expression() throws RecognitionException {
		Var_defining_expressionContext _localctx = new Var_defining_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_var_defining_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(KEYWORD_VAR);
			setState(161);
			attr_type();
			setState(162);
			name();
			setState(163);
			match(SYMBOL_ASSIGN);
			setState(164);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_expressionContext extends ParserRuleContext {
		public Attr_referenceContext attr_reference() {
			return getRuleContext(Attr_referenceContext.class,0);
		}
		public TerminalNode SYMBOL_ASSIGN() { return getToken(SMLParser.SYMBOL_ASSIGN, 0); }
		public Init_statementContext init_statement() {
			return getRuleContext(Init_statementContext.class,0);
		}
		public Matrix_referenceContext matrix_reference() {
			return getRuleContext(Matrix_referenceContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Assign_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterAssign_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitAssign_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitAssign_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_expressionContext assign_expression() throws RecognitionException {
		Assign_expressionContext _localctx = new Assign_expressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assign_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				{
				setState(166);
				attr_reference();
				setState(167);
				match(SYMBOL_ASSIGN);
				setState(168);
				init_statement();
				}
				}
				break;
			case 2:
				{
				{
				setState(170);
				matrix_reference();
				setState(171);
				match(SYMBOL_ASSIGN);
				setState(172);
				expression(0);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Paren_exprContext extends ExpressionContext {
		public TerminalNode SYMBOL_LPAREN() { return getToken(SMLParser.SYMBOL_LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SYMBOL_RPAREN() { return getToken(SMLParser.SYMBOL_RPAREN, 0); }
		public Paren_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterParen_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitParen_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitParen_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Unary_exprContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public TerminalNode SYMBOL_LPAREN() { return getToken(SMLParser.SYMBOL_LPAREN, 0); }
		public TerminalNode SYMBOL_RPAREN() { return getToken(SMLParser.SYMBOL_RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SYMBOL_COMMA() { return getToken(SMLParser.SYMBOL_COMMA, 0); }
		public Unary_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterUnary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitUnary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitUnary_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Compare_exprContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Compare_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterCompare_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitCompare_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitCompare_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Reference_exprContext extends ExpressionContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public Reference_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterReference_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitReference_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitReference_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Binary_exprContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public Binary_operatorContext binary_operator() {
			return getRuleContext(Binary_operatorContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Binary_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterBinary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitBinary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitBinary_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bool_exprContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public Boolean_operatorContext boolean_operator() {
			return getRuleContext(Boolean_operatorContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Bool_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterBool_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitBool_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitBool_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Name_exprContext extends ExpressionContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Name_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterName_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitName_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitName_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Word_exprContext extends ExpressionContext {
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public Word_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterWord_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitWord_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitWord_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Number_exprContext extends ExpressionContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public Number_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterNumber_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitNumber_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitNumber_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SYMBOL_LPAREN:
				{
				_localctx = new Paren_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(177);
				match(SYMBOL_LPAREN);
				setState(178);
				expression(0);
				setState(179);
				match(SYMBOL_RPAREN);
				}
				break;
			case KEYWORD_MAXIMUM:
			case KEYWORD_MINIMUM:
			case KEYWORD_AVERAGE:
			case KEYWORD_CARDINALITY:
				{
				_localctx = new Unary_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				unary_operator();
				setState(182);
				match(SYMBOL_LPAREN);
				setState(183);
				((Unary_exprContext)_localctx).left = expression(0);
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SYMBOL_COMMA) {
					{
					setState(184);
					match(SYMBOL_COMMA);
					setState(185);
					((Unary_exprContext)_localctx).right = expression(0);
					}
				}

				setState(188);
				match(SYMBOL_RPAREN);
				}
				break;
			case SYMBOL_REFERENCE:
				{
				_localctx = new Reference_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				reference();
				}
				break;
			case CHAR:
				{
				_localctx = new Name_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				name();
				}
				break;
			case INT:
			case FLOAT:
			case SIGN:
				{
				_localctx = new Number_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				number();
				}
				break;
			case SYMBOL_QUOTE:
				{
				_localctx = new Word_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				word();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(208);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new Compare_exprContext(new ExpressionContext(_parentctx, _parentState));
						((Compare_exprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(196);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(197);
						comparator();
						setState(198);
						((Compare_exprContext)_localctx).right = expression(9);
						}
						break;
					case 2:
						{
						_localctx = new Bool_exprContext(new ExpressionContext(_parentctx, _parentState));
						((Bool_exprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(200);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(201);
						boolean_operator();
						setState(202);
						((Bool_exprContext)_localctx).right = expression(8);
						}
						break;
					case 3:
						{
						_localctx = new Binary_exprContext(new ExpressionContext(_parentctx, _parentState));
						((Binary_exprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(205);
						binary_operator();
						setState(206);
						((Binary_exprContext)_localctx).right = expression(7);
						}
						break;
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Init_statementContext extends ParserRuleContext {
		public TerminalNode SYMBOL_LBRACE() { return getToken(SMLParser.SYMBOL_LBRACE, 0); }
		public TerminalNode SYMBOL_RBRACE() { return getToken(SMLParser.SYMBOL_RBRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SYMBOL_COMMA() { return getTokens(SMLParser.SYMBOL_COMMA); }
		public TerminalNode SYMBOL_COMMA(int i) {
			return getToken(SMLParser.SYMBOL_COMMA, i);
		}
		public Init_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterInit_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitInit_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitInit_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Init_statementContext init_statement() throws RecognitionException {
		Init_statementContext _localctx = new Init_statementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_init_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(SYMBOL_LBRACE);
			{
			setState(214);
			expression(0);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL_COMMA) {
				{
				{
				setState(215);
				match(SYMBOL_COMMA);
				setState(216);
				expression(0);
				}
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(222);
			match(SYMBOL_RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_description_lineContext extends ParserRuleContext {
		public TerminalNode KEYWORD_PARAM() { return getToken(SMLParser.KEYWORD_PARAM, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode KEYWORD_FROM() { return getToken(SMLParser.KEYWORD_FROM, 0); }
		public List<TerminalNode> INT() { return getTokens(SMLParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(SMLParser.INT, i);
		}
		public TerminalNode KEYWORD_TO() { return getToken(SMLParser.KEYWORD_TO, 0); }
		public TerminalNode KEYWORD_BY() { return getToken(SMLParser.KEYWORD_BY, 0); }
		public Parameter_description_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_description_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterParameter_description_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitParameter_description_line(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitParameter_description_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_description_lineContext parameter_description_line() throws RecognitionException {
		Parameter_description_lineContext _localctx = new Parameter_description_lineContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parameter_description_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(KEYWORD_PARAM);
			setState(225);
			name();
			{
			{
			setState(226);
			match(KEYWORD_FROM);
			setState(227);
			match(INT);
			setState(228);
			match(KEYWORD_TO);
			setState(229);
			match(INT);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_BY) {
				{
				setState(230);
				match(KEYWORD_BY);
				setState(231);
				match(INT);
				}
			}

			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_nameContext extends ParserRuleContext {
		public TerminalNode KEYWORD_ATTRIBUTE() { return getToken(SMLParser.KEYWORD_ATTRIBUTE, 0); }
		public TerminalNode INT() { return getToken(SMLParser.INT, 0); }
		public Attr_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterAttr_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitAttr_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitAttr_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_nameContext attr_name() throws RecognitionException {
		Attr_nameContext _localctx = new Attr_nameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_attr_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(KEYWORD_ATTRIBUTE);
			setState(235);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_referenceContext extends ParserRuleContext {
		public TerminalNode SYMBOL_REFERENCE() { return getToken(SMLParser.SYMBOL_REFERENCE, 0); }
		public TerminalNode INT() { return getToken(SMLParser.INT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Attr_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterAttr_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitAttr_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitAttr_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_referenceContext attr_reference() throws RecognitionException {
		Attr_referenceContext _localctx = new Attr_referenceContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_attr_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(SYMBOL_REFERENCE);
			setState(240);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(238);
				match(INT);
				}
				break;
			case CHAR:
				{
				setState(239);
				name();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Matrix_referenceContext extends ParserRuleContext {
		public Attr_referenceContext attr_reference() {
			return getRuleContext(Attr_referenceContext.class,0);
		}
		public DimensionContext dimension() {
			return getRuleContext(DimensionContext.class,0);
		}
		public Matrix_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterMatrix_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitMatrix_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitMatrix_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matrix_referenceContext matrix_reference() throws RecognitionException {
		Matrix_referenceContext _localctx = new Matrix_referenceContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_matrix_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			attr_reference();
			setState(243);
			dimension();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceContext extends ParserRuleContext {
		public Attr_referenceContext attr_reference() {
			return getRuleContext(Attr_referenceContext.class,0);
		}
		public Matrix_referenceContext matrix_reference() {
			return getRuleContext(Matrix_referenceContext.class,0);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(245);
				attr_reference();
				}
				break;
			case 2:
				{
				setState(246);
				matrix_reference();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dimension_partContext extends ParserRuleContext {
		public TerminalNode SYMBOL_LBRACK() { return getToken(SMLParser.SYMBOL_LBRACK, 0); }
		public TerminalNode SYMOBL_RBRACK() { return getToken(SMLParser.SYMOBL_RBRACK, 0); }
		public TerminalNode INT() { return getToken(SMLParser.INT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Dimension_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimension_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterDimension_part(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitDimension_part(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitDimension_part(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dimension_partContext dimension_part() throws RecognitionException {
		Dimension_partContext _localctx = new Dimension_partContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_dimension_part);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(SYMBOL_LBRACK);
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(250);
				match(INT);
				}
				break;
			case CHAR:
				{
				setState(251);
				name();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(254);
			match(SYMOBL_RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimensionContext extends ParserRuleContext {
		public List<Dimension_partContext> dimension_part() {
			return getRuleContexts(Dimension_partContext.class);
		}
		public Dimension_partContext dimension_part(int i) {
			return getRuleContext(Dimension_partContext.class,i);
		}
		public DimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterDimension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitDimension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitDimension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimensionContext dimension() throws RecognitionException {
		DimensionContext _localctx = new DimensionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_dimension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			dimension_part();
			setState(257);
			dimension_part();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SMLParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(SMLParser.FLOAT, 0); }
		public TerminalNode SIGN() { return getToken(SMLParser.SIGN, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIGN) {
				{
				setState(259);
				match(SIGN);
				}
			}

			setState(262);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumbersContext extends ParserRuleContext {
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public List<TerminalNode> SYMBOL_COMMA() { return getTokens(SMLParser.SYMBOL_COMMA); }
		public TerminalNode SYMBOL_COMMA(int i) {
			return getToken(SMLParser.SYMBOL_COMMA, i);
		}
		public NumbersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numbers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterNumbers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitNumbers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitNumbers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumbersContext numbers() throws RecognitionException {
		NumbersContext _localctx = new NumbersContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_numbers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(264);
			number();
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL_COMMA) {
				{
				{
				setState(265);
				match(SYMBOL_COMMA);
				setState(266);
				number();
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WordsContext extends ParserRuleContext {
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public List<TerminalNode> SYMBOL_COMMA() { return getTokens(SMLParser.SYMBOL_COMMA); }
		public TerminalNode SYMBOL_COMMA(int i) {
			return getToken(SMLParser.SYMBOL_COMMA, i);
		}
		public WordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_words; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterWords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitWords(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitWords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordsContext words() throws RecognitionException {
		WordsContext _localctx = new WordsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(272);
			word();
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL_COMMA) {
				{
				{
				setState(273);
				match(SYMBOL_COMMA);
				setState(274);
				word();
				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WordContext extends ParserRuleContext {
		public List<TerminalNode> SYMBOL_QUOTE() { return getTokens(SMLParser.SYMBOL_QUOTE); }
		public TerminalNode SYMBOL_QUOTE(int i) {
			return getToken(SMLParser.SYMBOL_QUOTE, i);
		}
		public List<TerminalNode> INT() { return getTokens(SMLParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(SMLParser.INT, i);
		}
		public List<TerminalNode> CHAR() { return getTokens(SMLParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(SMLParser.CHAR, i);
		}
		public WordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_word; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordContext word() throws RecognitionException {
		WordContext _localctx = new WordContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_word);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(SYMBOL_QUOTE);
			setState(282); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(281);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==CHAR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(284); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INT || _la==CHAR );
			setState(286);
			match(SYMBOL_QUOTE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public List<TerminalNode> CHAR() { return getTokens(SMLParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(SMLParser.CHAR, i);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_name);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(289); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(288);
					match(CHAR);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(291); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\67\u0128\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\6\2H\n\2\r\2\16\2I\3\2\3\2\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\6\4T\n\4\r\4\16\4U\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\7\6`\n\6\f\6\16"+
		"\6c\13\6\3\6\6\6f\n\6\r\6\16\6g\3\7\3\7\7\7l\n\7\f\7\16\7o\13\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\t\3\t\5\ty\n\t\3\t\7\t|\n\t\f\t\16\t\177\13\t\3\n"+
		"\3\n\3\n\3\13\3\13\5\13\u0086\n\13\3\f\3\f\7\f\u008a\n\f\f\f\16\f\u008d"+
		"\13\f\3\f\6\f\u0090\n\f\r\f\16\f\u0091\3\r\3\r\3\r\5\r\u0097\n\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00b1\n\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00bd\n\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u00c5\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\7\25\u00d3\n\25\f\25\16\25\u00d6\13\25\3\26\3\26"+
		"\3\26\3\26\7\26\u00dc\n\26\f\26\16\26\u00df\13\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00eb\n\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\5\31\u00f3\n\31\3\32\3\32\3\32\3\33\3\33\5\33\u00fa\n\33\3\34\3"+
		"\34\3\34\5\34\u00ff\n\34\3\34\3\34\3\35\3\35\3\35\3\36\5\36\u0107\n\36"+
		"\3\36\3\36\3\37\3\37\3\37\7\37\u010e\n\37\f\37\16\37\u0111\13\37\3 \3"+
		" \3 \7 \u0116\n \f \16 \u0119\13 \3!\3!\6!\u011d\n!\r!\16!\u011e\3!\3"+
		"!\3\"\6\"\u0124\n\"\r\"\16\"\u0125\3\"\2\3(#\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2\t\3\2\17\20\3\2\21\26\3\2\27"+
		"\32\3\2%(\3\2)*\3\2\63\64\4\2\63\63\66\66\u0125\2D\3\2\2\2\4M\3\2\2\2"+
		"\6Q\3\2\2\2\bW\3\2\2\2\n]\3\2\2\2\fi\3\2\2\2\16r\3\2\2\2\20v\3\2\2\2\22"+
		"\u0080\3\2\2\2\24\u0083\3\2\2\2\26\u0087\3\2\2\2\30\u0096\3\2\2\2\32\u0098"+
		"\3\2\2\2\34\u009a\3\2\2\2\36\u009c\3\2\2\2 \u009e\3\2\2\2\"\u00a0\3\2"+
		"\2\2$\u00a2\3\2\2\2&\u00b0\3\2\2\2(\u00c4\3\2\2\2*\u00d7\3\2\2\2,\u00e2"+
		"\3\2\2\2.\u00ec\3\2\2\2\60\u00ef\3\2\2\2\62\u00f4\3\2\2\2\64\u00f9\3\2"+
		"\2\2\66\u00fb\3\2\2\28\u0102\3\2\2\2:\u0106\3\2\2\2<\u010a\3\2\2\2>\u0112"+
		"\3\2\2\2@\u011a\3\2\2\2B\u0123\3\2\2\2DE\5\4\3\2EG\7/\2\2FH\5\16\b\2G"+
		"F\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\2\2\3L\3\3\2\2\2"+
		"MN\5\6\4\2NO\5\n\6\2OP\5\f\7\2P\5\3\2\2\2QS\7,\2\2RT\5\b\5\2SR\3\2\2\2"+
		"TU\3\2\2\2US\3\2\2\2UV\3\2\2\2V\7\3\2\2\2WX\5.\30\2XY\7\13\2\2YZ\5\30"+
		"\r\2Z[\7\f\2\2[\\\5\32\16\2\\\t\3\2\2\2]a\7-\2\2^`\5,\27\2_^\3\2\2\2`"+
		"c\3\2\2\2a_\3\2\2\2ab\3\2\2\2be\3\2\2\2ca\3\2\2\2df\5&\24\2ed\3\2\2\2"+
		"fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\13\3\2\2\2im\7.\2\2jl\5,\27\2kj\3\2\2"+
		"\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\5(\25\2q\r\3\2"+
		"\2\2rs\5\20\t\2st\5\24\13\2tu\5\26\f\2u\17\3\2\2\2vx\7\60\2\2wy\5\22\n"+
		"\2xw\3\2\2\2xy\3\2\2\2y}\3\2\2\2z|\5,\27\2{z\3\2\2\2|\177\3\2\2\2}{\3"+
		"\2\2\2}~\3\2\2\2~\21\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\n\2\2\u0081\u0082"+
		"\5:\36\2\u0082\23\3\2\2\2\u0083\u0085\7\61\2\2\u0084\u0086\5(\25\2\u0085"+
		"\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086\25\3\2\2\2\u0087\u008b\7\62\2"+
		"\2\u0088\u008a\5$\23\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008e"+
		"\u0090\5&\24\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\27\3\2\2\2\u0093\u0097\7\r\2\2\u0094\u0095"+
		"\7\16\2\2\u0095\u0097\58\35\2\u0096\u0093\3\2\2\2\u0096\u0094\3\2\2\2"+
		"\u0097\31\3\2\2\2\u0098\u0099\t\2\2\2\u0099\33\3\2\2\2\u009a\u009b\t\3"+
		"\2\2\u009b\35\3\2\2\2\u009c\u009d\t\4\2\2\u009d\37\3\2\2\2\u009e\u009f"+
		"\t\5\2\2\u009f!\3\2\2\2\u00a0\u00a1\t\6\2\2\u00a1#\3\2\2\2\u00a2\u00a3"+
		"\7\t\2\2\u00a3\u00a4\5\32\16\2\u00a4\u00a5\5B\"\2\u00a5\u00a6\7\33\2\2"+
		"\u00a6\u00a7\5(\25\2\u00a7%\3\2\2\2\u00a8\u00a9\5\60\31\2\u00a9\u00aa"+
		"\7\33\2\2\u00aa\u00ab\5*\26\2\u00ab\u00b1\3\2\2\2\u00ac\u00ad\5\62\32"+
		"\2\u00ad\u00ae\7\33\2\2\u00ae\u00af\5(\25\2\u00af\u00b1\3\2\2\2\u00b0"+
		"\u00a8\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b1\'\3\2\2\2\u00b2\u00b3\b\25\1"+
		"\2\u00b3\u00b4\7\37\2\2\u00b4\u00b5\5(\25\2\u00b5\u00b6\7 \2\2\u00b6\u00c5"+
		"\3\2\2\2\u00b7\u00b8\5 \21\2\u00b8\u00b9\7\37\2\2\u00b9\u00bc\5(\25\2"+
		"\u00ba\u00bb\7\36\2\2\u00bb\u00bd\5(\25\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd"+
		"\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\7 \2\2\u00bf\u00c5\3\2\2\2\u00c0"+
		"\u00c5\5\64\33\2\u00c1\u00c5\5B\"\2\u00c2\u00c5\5:\36\2\u00c3\u00c5\5"+
		"@!\2\u00c4\u00b2\3\2\2\2\u00c4\u00b7\3\2\2\2\u00c4\u00c0\3\2\2\2\u00c4"+
		"\u00c1\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00d4\3\2"+
		"\2\2\u00c6\u00c7\f\n\2\2\u00c7\u00c8\5\34\17\2\u00c8\u00c9\5(\25\13\u00c9"+
		"\u00d3\3\2\2\2\u00ca\u00cb\f\t\2\2\u00cb\u00cc\5\"\22\2\u00cc\u00cd\5"+
		"(\25\n\u00cd\u00d3\3\2\2\2\u00ce\u00cf\f\b\2\2\u00cf\u00d0\5\36\20\2\u00d0"+
		"\u00d1\5(\25\t\u00d1\u00d3\3\2\2\2\u00d2\u00c6\3\2\2\2\u00d2\u00ca\3\2"+
		"\2\2\u00d2\u00ce\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5)\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7!\2\2\u00d8"+
		"\u00dd\5(\25\2\u00d9\u00da\7\36\2\2\u00da\u00dc\5(\25\2\u00db\u00d9\3"+
		"\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00e0\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\7\"\2\2\u00e1+\3\2\2\2"+
		"\u00e2\u00e3\7\3\2\2\u00e3\u00e4\5B\"\2\u00e4\u00e5\7\4\2\2\u00e5\u00e6"+
		"\7\63\2\2\u00e6\u00e7\7\5\2\2\u00e7\u00ea\7\63\2\2\u00e8\u00e9\7\6\2\2"+
		"\u00e9\u00eb\7\63\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb-\3"+
		"\2\2\2\u00ec\u00ed\7\b\2\2\u00ed\u00ee\7\63\2\2\u00ee/\3\2\2\2\u00ef\u00f2"+
		"\7\34\2\2\u00f0\u00f3\7\63\2\2\u00f1\u00f3\5B\"\2\u00f2\u00f0\3\2\2\2"+
		"\u00f2\u00f1\3\2\2\2\u00f3\61\3\2\2\2\u00f4\u00f5\5\60\31\2\u00f5\u00f6"+
		"\58\35\2\u00f6\63\3\2\2\2\u00f7\u00fa\5\60\31\2\u00f8\u00fa\5\62\32\2"+
		"\u00f9\u00f7\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa\65\3\2\2\2\u00fb\u00fe"+
		"\7#\2\2\u00fc\u00ff\7\63\2\2\u00fd\u00ff\5B\"\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\7$\2\2\u0101\67\3\2\2\2"+
		"\u0102\u0103\5\66\34\2\u0103\u0104\5\66\34\2\u01049\3\2\2\2\u0105\u0107"+
		"\7\65\2\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2"+
		"\u0108\u0109\t\7\2\2\u0109;\3\2\2\2\u010a\u010f\5:\36\2\u010b\u010c\7"+
		"\36\2\2\u010c\u010e\5:\36\2\u010d\u010b\3\2\2\2\u010e\u0111\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110=\3\2\2\2\u0111\u010f\3\2\2\2"+
		"\u0112\u0117\5@!\2\u0113\u0114\7\36\2\2\u0114\u0116\5@!\2\u0115\u0113"+
		"\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"?\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011c\7\35\2\2\u011b\u011d\t\b\2\2"+
		"\u011c\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f"+
		"\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\7\35\2\2\u0121A\3\2\2\2\u0122"+
		"\u0124\7\66\2\2\u0123\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0123\3"+
		"\2\2\2\u0125\u0126\3\2\2\2\u0126C\3\2\2\2\34IUagmx}\u0085\u008b\u0091"+
		"\u0096\u00b0\u00bc\u00c4\u00d2\u00d4\u00dd\u00ea\u00f2\u00f9\u00fe\u0106"+
		"\u010f\u0117\u011e\u0125";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
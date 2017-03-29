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
		T__0=1, STATE_DELIMITER=2, STATE_ATTRIBUTES_DELIMITER=3, STATE_START_DELIMITER=4, 
		STATE_GOAL_DELIMITER=5, OPERATOR_DELIMITER=6, OPERATOR_DESCRIPTION_DELIMITER=7, 
		OPERATOR_PRECONDITION_DELIMITER=8, OPERATOR_EFFECT_DELIMITER=9, KEYWORD_PARAM=10, 
		KEYWORD_FROM=11, KEYWORD_TO=12, KEYWORD_BY=13, KEYWORD_TIMES=14, KEYWORD_ATTRIBUTE=15, 
		KEYWORD_VAR=16, KEYWORD_COST=17, KEYWORD_NAME=18, KEYWORD_IS=19, KEYWORD_OF=20, 
		KEYWORD_SET=21, KEYWORD_MATRIX=22, KEYWORD_WORD=23, KEYWORD_NUMBER=24, 
		KEYWORD_MINIMUM=25, KEYWORD_MAXIMUM=26, KEYWORD_SUM=27, KEYWORD_AVERAGE=28, 
		KEYWORD_UNION=29, KEYWORD_INTERSECT=30, KEYWORD_DIFFERENCE=31, KEYWORD_ADD=32, 
		KEYWORD_REMOVE=33, KEYWORD_CARDINALITY=34, KEYWORD_AND=35, KEYWORD_OR=36, 
		KEYWORD_NOT=37, KEYWORD_INF=38, SYMBOL_EQUAL=39, SYMBOL_NOT_EQUAL=40, 
		SYMBOL_LESSER=41, SYMBOL_GREATER=42, SYMBOL_LESSER_OR_EQUAL=43, SYMBOL_GREATER_OR_EQUAL=44, 
		SYMBOL_ADDITION=45, SYMBOL_SUBSTRACT=46, SYMBOL_MULTIPLICATION=47, SYMBOL_DIVISION=48, 
		SYMBOL_ASSIGN=49, SYMBOL_REFERENCE=50, SYMBOL_COMMA=51, SYMBOL_QUOTE=52, 
		SYMBOL_SINGLE_QOUTE=53, SYMBOL_LPAREN=54, SYMBOL_RPAREN=55, SYMBOL_LBRACE=56, 
		SYMBOL_RBRACE=57, SYMBOL_LBRACK=58, SYMOBL_RBRACK=59, INT=60, FLOAT=61, 
		SIGN=62, PARAM_NAME=63, CHAR=64, WS=65;
	public static final int
		RULE_expr = 0, RULE_state_expr = 1, RULE_state_description = 2, RULE_state_description_line = 3, 
		RULE_state_start = 4, RULE_state_start_line = 5, RULE_state_goal = 6, 
		RULE_operator_expr = 7, RULE_operator_description = 8, RULE_operator_cost = 9, 
		RULE_operator_precondition = 10, RULE_operator_effect = 11, RULE_operator_effect_line = 12, 
		RULE_attr_struct = 13, RULE_attr_type = 14, RULE_comparator = 15, RULE_binary_operator = 16, 
		RULE_unary_operator = 17, RULE_boolean_operator = 18, RULE_var_defining_expression = 19, 
		RULE_name_defining_expression = 20, RULE_expression = 21, RULE_parameter_description_line = 22, 
		RULE_attr_name = 23, RULE_attr_reference = 24, RULE_parameterized_attr_reference = 25, 
		RULE_matrix_reference = 26, RULE_parameterized_matrix_reference = 27, 
		RULE_dimension = 28, RULE_normal_reference = 29, RULE_parameterized_reference = 30, 
		RULE_reference = 31, RULE_number = 32, RULE_word = 33;
	public static final String[] ruleNames = {
		"expr", "state_expr", "state_description", "state_description_line", "state_start", 
		"state_start_line", "state_goal", "operator_expr", "operator_description", 
		"operator_cost", "operator_precondition", "operator_effect", "operator_effect_line", 
		"attr_struct", "attr_type", "comparator", "binary_operator", "unary_operator", 
		"boolean_operator", "var_defining_expression", "name_defining_expression", 
		"expression", "parameter_description_line", "attr_name", "attr_reference", 
		"parameterized_attr_reference", "matrix_reference", "parameterized_matrix_reference", 
		"dimension", "normal_reference", "parameterized_reference", "reference", 
		"number", "word"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\'", "'STATE:'", "'STATE_ATTRIBUTES:'", "'STATE_START:'", "'STATE_GOAL:'", 
		"'OPERATORS:'", "'OPERATOR_DESCRIPTION:'", "'OPERATOR_PRECONDITION:'", 
		"'OPERATOR_EFFECT:'", "'param'", "'from'", "'to'", "'by'", "'times'", 
		"'Attr'", "'var'", "'cost'", "'name'", "'is'", "'of'", "'set'", "'matrix'", 
		"'word'", "'number'", "'min'", "'max'", "'sum'", "'avg'", "'union'", "'intersect'", 
		"'difference'", "'add'", "'remove'", "'card'", "'and'", "'or'", "'not'", 
		"'inf'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", 
		"'/'", "'='", "'$'", "','", "'\"'", "'''", "'('", "')'", "'{'", "'}'", 
		"'['", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "STATE_DELIMITER", "STATE_ATTRIBUTES_DELIMITER", "STATE_START_DELIMITER", 
		"STATE_GOAL_DELIMITER", "OPERATOR_DELIMITER", "OPERATOR_DESCRIPTION_DELIMITER", 
		"OPERATOR_PRECONDITION_DELIMITER", "OPERATOR_EFFECT_DELIMITER", "KEYWORD_PARAM", 
		"KEYWORD_FROM", "KEYWORD_TO", "KEYWORD_BY", "KEYWORD_TIMES", "KEYWORD_ATTRIBUTE", 
		"KEYWORD_VAR", "KEYWORD_COST", "KEYWORD_NAME", "KEYWORD_IS", "KEYWORD_OF", 
		"KEYWORD_SET", "KEYWORD_MATRIX", "KEYWORD_WORD", "KEYWORD_NUMBER", "KEYWORD_MINIMUM", 
		"KEYWORD_MAXIMUM", "KEYWORD_SUM", "KEYWORD_AVERAGE", "KEYWORD_UNION", 
		"KEYWORD_INTERSECT", "KEYWORD_DIFFERENCE", "KEYWORD_ADD", "KEYWORD_REMOVE", 
		"KEYWORD_CARDINALITY", "KEYWORD_AND", "KEYWORD_OR", "KEYWORD_NOT", "KEYWORD_INF", 
		"SYMBOL_EQUAL", "SYMBOL_NOT_EQUAL", "SYMBOL_LESSER", "SYMBOL_GREATER", 
		"SYMBOL_LESSER_OR_EQUAL", "SYMBOL_GREATER_OR_EQUAL", "SYMBOL_ADDITION", 
		"SYMBOL_SUBSTRACT", "SYMBOL_MULTIPLICATION", "SYMBOL_DIVISION", "SYMBOL_ASSIGN", 
		"SYMBOL_REFERENCE", "SYMBOL_COMMA", "SYMBOL_QUOTE", "SYMBOL_SINGLE_QOUTE", 
		"SYMBOL_LPAREN", "SYMBOL_RPAREN", "SYMBOL_LBRACE", "SYMBOL_RBRACE", "SYMBOL_LBRACK", 
		"SYMOBL_RBRACK", "INT", "FLOAT", "SIGN", "PARAM_NAME", "CHAR", "WS"
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
		public TerminalNode STATE_DELIMITER() { return getToken(SMLParser.STATE_DELIMITER, 0); }
		public State_exprContext state_expr() {
			return getRuleContext(State_exprContext.class,0);
		}
		public TerminalNode OPERATOR_DELIMITER() { return getToken(SMLParser.OPERATOR_DELIMITER, 0); }
		public TerminalNode EOF() { return getToken(SMLParser.EOF, 0); }
		public Name_defining_expressionContext name_defining_expression() {
			return getRuleContext(Name_defining_expressionContext.class,0);
		}
		public List<Operator_exprContext> operator_expr() {
			return getRuleContexts(Operator_exprContext.class);
		}
		public Operator_exprContext operator_expr(int i) {
			return getRuleContext(Operator_exprContext.class,i);
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
			setState(68);
			match(STATE_DELIMITER);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_NAME) {
				{
				setState(69);
				name_defining_expression();
				}
			}

			setState(72);
			state_expr();
			setState(73);
			match(OPERATOR_DELIMITER);
			setState(75); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(74);
				operator_expr();
				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPERATOR_DESCRIPTION_DELIMITER );
			setState(79);
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
			setState(81);
			state_description();
			setState(82);
			state_start();
			setState(83);
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
			setState(85);
			match(STATE_ATTRIBUTES_DELIMITER);
			setState(87); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(86);
				state_description_line();
				}
				}
				setState(89); 
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
			setState(91);
			attr_name();
			setState(92);
			match(KEYWORD_IS);
			setState(93);
			attr_struct();
			setState(94);
			match(KEYWORD_OF);
			setState(95);
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
		public List<State_start_lineContext> state_start_line() {
			return getRuleContexts(State_start_lineContext.class);
		}
		public State_start_lineContext state_start_line(int i) {
			return getRuleContext(State_start_lineContext.class,i);
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
			setState(97);
			match(STATE_START_DELIMITER);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KEYWORD_PARAM) {
				{
				{
				setState(98);
				parameter_description_line();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(104);
				state_start_line();
				}
				}
				setState(107); 
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

	public static class State_start_lineContext extends ParserRuleContext {
		public TerminalNode SYMBOL_ASSIGN() { return getToken(SMLParser.SYMBOL_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Attr_referenceContext attr_reference() {
			return getRuleContext(Attr_referenceContext.class,0);
		}
		public Matrix_referenceContext matrix_reference() {
			return getRuleContext(Matrix_referenceContext.class,0);
		}
		public State_start_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_start_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterState_start_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitState_start_line(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitState_start_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_start_lineContext state_start_line() throws RecognitionException {
		State_start_lineContext _localctx = new State_start_lineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_state_start_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(109);
				attr_reference();
				}
				break;
			case 2:
				{
				setState(110);
				matrix_reference();
				}
				break;
			}
			setState(113);
			match(SYMBOL_ASSIGN);
			setState(114);
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
		enterRule(_localctx, 12, RULE_state_goal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(STATE_GOAL_DELIMITER);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KEYWORD_PARAM) {
				{
				{
				setState(117);
				parameter_description_line();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
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

	public static class Operator_exprContext extends ParserRuleContext {
		public Operator_descriptionContext operator_description() {
			return getRuleContext(Operator_descriptionContext.class,0);
		}
		public Operator_preconditionContext operator_precondition() {
			return getRuleContext(Operator_preconditionContext.class,0);
		}
		public Operator_effectContext operator_effect() {
			return getRuleContext(Operator_effectContext.class,0);
		}
		public Operator_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOperator_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOperator_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOperator_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_exprContext operator_expr() throws RecognitionException {
		Operator_exprContext _localctx = new Operator_exprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_operator_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			operator_description();
			setState(126);
			operator_precondition();
			setState(127);
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

	public static class Operator_descriptionContext extends ParserRuleContext {
		public TerminalNode OPERATOR_DESCRIPTION_DELIMITER() { return getToken(SMLParser.OPERATOR_DESCRIPTION_DELIMITER, 0); }
		public Name_defining_expressionContext name_defining_expression() {
			return getRuleContext(Name_defining_expressionContext.class,0);
		}
		public Operator_costContext operator_cost() {
			return getRuleContext(Operator_costContext.class,0);
		}
		public List<Parameter_description_lineContext> parameter_description_line() {
			return getRuleContexts(Parameter_description_lineContext.class);
		}
		public Parameter_description_lineContext parameter_description_line(int i) {
			return getRuleContext(Parameter_description_lineContext.class,i);
		}
		public Operator_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOperator_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOperator_description(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOperator_description(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_descriptionContext operator_description() throws RecognitionException {
		Operator_descriptionContext _localctx = new Operator_descriptionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_operator_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(OPERATOR_DESCRIPTION_DELIMITER);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_NAME) {
				{
				setState(130);
				name_defining_expression();
				}
			}

			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_COST) {
				{
				setState(133);
				operator_cost();
				}
			}

			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KEYWORD_PARAM) {
				{
				{
				setState(136);
				parameter_description_line();
				}
				}
				setState(141);
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
		enterRule(_localctx, 18, RULE_operator_cost);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(KEYWORD_COST);
			setState(143);
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
		enterRule(_localctx, 20, RULE_operator_precondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(OPERATOR_PRECONDITION_DELIMITER);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEYWORD_MINIMUM) | (1L << KEYWORD_MAXIMUM) | (1L << KEYWORD_AVERAGE) | (1L << KEYWORD_UNION) | (1L << KEYWORD_ADD) | (1L << KEYWORD_REMOVE) | (1L << KEYWORD_CARDINALITY) | (1L << KEYWORD_INF) | (1L << SYMBOL_REFERENCE) | (1L << SYMBOL_QUOTE) | (1L << SYMBOL_LPAREN) | (1L << SYMBOL_LBRACE) | (1L << INT) | (1L << FLOAT) | (1L << SIGN) | (1L << PARAM_NAME))) != 0)) {
				{
				setState(146);
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
		public List<Operator_effect_lineContext> operator_effect_line() {
			return getRuleContexts(Operator_effect_lineContext.class);
		}
		public Operator_effect_lineContext operator_effect_line(int i) {
			return getRuleContext(Operator_effect_lineContext.class,i);
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
		enterRule(_localctx, 22, RULE_operator_effect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(OPERATOR_EFFECT_DELIMITER);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KEYWORD_VAR) {
				{
				{
				setState(150);
				var_defining_expression();
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(156);
				operator_effect_line();
				}
				}
				setState(159); 
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

	public static class Operator_effect_lineContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode SYMBOL_ASSIGN() { return getToken(SMLParser.SYMBOL_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Operator_effect_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_effect_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOperator_effect_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOperator_effect_line(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOperator_effect_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_effect_lineContext operator_effect_line() throws RecognitionException {
		Operator_effect_lineContext _localctx = new Operator_effect_lineContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_operator_effect_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			reference();
			setState(162);
			match(SYMBOL_ASSIGN);
			setState(163);
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
		enterRule(_localctx, 26, RULE_attr_struct);
		try {
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEYWORD_SET:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(KEYWORD_SET);
				}
				break;
			case KEYWORD_MATRIX:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(166);
				match(KEYWORD_MATRIX);
				setState(167);
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
		enterRule(_localctx, 28, RULE_attr_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
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
		enterRule(_localctx, 30, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
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
		enterRule(_localctx, 32, RULE_binary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
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
		public TerminalNode KEYWORD_UNION() { return getToken(SMLParser.KEYWORD_UNION, 0); }
		public TerminalNode KEYWORD_ADD() { return getToken(SMLParser.KEYWORD_ADD, 0); }
		public TerminalNode KEYWORD_REMOVE() { return getToken(SMLParser.KEYWORD_REMOVE, 0); }
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
		enterRule(_localctx, 34, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEYWORD_MINIMUM) | (1L << KEYWORD_MAXIMUM) | (1L << KEYWORD_AVERAGE) | (1L << KEYWORD_UNION) | (1L << KEYWORD_ADD) | (1L << KEYWORD_REMOVE) | (1L << KEYWORD_CARDINALITY))) != 0)) ) {
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
		enterRule(_localctx, 36, RULE_boolean_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
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
		public TerminalNode PARAM_NAME() { return getToken(SMLParser.PARAM_NAME, 0); }
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
		enterRule(_localctx, 38, RULE_var_defining_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(KEYWORD_VAR);
			setState(181);
			attr_type();
			setState(182);
			match(PARAM_NAME);
			setState(183);
			match(SYMBOL_ASSIGN);
			setState(184);
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

	public static class Name_defining_expressionContext extends ParserRuleContext {
		public TerminalNode KEYWORD_NAME() { return getToken(SMLParser.KEYWORD_NAME, 0); }
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public Name_defining_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_defining_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterName_defining_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitName_defining_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitName_defining_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Name_defining_expressionContext name_defining_expression() throws RecognitionException {
		Name_defining_expressionContext _localctx = new Name_defining_expressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_name_defining_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(KEYWORD_NAME);
			setState(187);
			word();
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
	public static class Param_name_exprContext extends ExpressionContext {
		public TerminalNode PARAM_NAME() { return getToken(SMLParser.PARAM_NAME, 0); }
		public Param_name_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterParam_name_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitParam_name_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitParam_name_expr(this);
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
	public static class Set_init_exprContext extends ExpressionContext {
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
		public Set_init_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterSet_init_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitSet_init_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitSet_init_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Two_param_unary_exprContext extends ExpressionContext {
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
		public Two_param_unary_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterTwo_param_unary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitTwo_param_unary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitTwo_param_unary_expr(this);
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
	public static class One_param_unary_exprContext extends ExpressionContext {
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public TerminalNode SYMBOL_LPAREN() { return getToken(SMLParser.SYMBOL_LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SYMBOL_RPAREN() { return getToken(SMLParser.SYMBOL_RPAREN, 0); }
		public One_param_unary_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOne_param_unary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOne_param_unary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOne_param_unary_expr(this);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new Paren_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(190);
				match(SYMBOL_LPAREN);
				setState(191);
				expression(0);
				setState(192);
				match(SYMBOL_RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new One_param_unary_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				unary_operator();
				setState(195);
				match(SYMBOL_LPAREN);
				setState(196);
				expression(0);
				setState(197);
				match(SYMBOL_RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new Two_param_unary_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				unary_operator();
				setState(200);
				match(SYMBOL_LPAREN);
				setState(201);
				((Two_param_unary_exprContext)_localctx).left = expression(0);
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SYMBOL_COMMA) {
					{
					setState(202);
					match(SYMBOL_COMMA);
					setState(203);
					((Two_param_unary_exprContext)_localctx).right = expression(0);
					}
				}

				setState(206);
				match(SYMBOL_RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new Set_init_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				match(SYMBOL_LBRACE);
				{
				setState(209);
				expression(0);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SYMBOL_COMMA) {
					{
					{
					setState(210);
					match(SYMBOL_COMMA);
					setState(211);
					expression(0);
					}
					}
					setState(216);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(217);
				match(SYMBOL_RBRACE);
				}
				break;
			case 5:
				{
				_localctx = new Reference_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				reference();
				}
				break;
			case 6:
				{
				_localctx = new Word_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				word();
				}
				break;
			case 7:
				{
				_localctx = new Number_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				number();
				}
				break;
			case 8:
				{
				_localctx = new Param_name_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				match(PARAM_NAME);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(237);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new Compare_exprContext(new ExpressionContext(_parentctx, _parentState));
						((Compare_exprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(225);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(226);
						comparator();
						setState(227);
						((Compare_exprContext)_localctx).right = expression(11);
						}
						break;
					case 2:
						{
						_localctx = new Bool_exprContext(new ExpressionContext(_parentctx, _parentState));
						((Bool_exprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(229);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(230);
						boolean_operator();
						setState(231);
						((Bool_exprContext)_localctx).right = expression(10);
						}
						break;
					case 3:
						{
						_localctx = new Binary_exprContext(new ExpressionContext(_parentctx, _parentState));
						((Binary_exprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(233);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(234);
						binary_operator();
						setState(235);
						((Binary_exprContext)_localctx).right = expression(9);
						}
						break;
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class Parameter_description_lineContext extends ParserRuleContext {
		public TerminalNode KEYWORD_PARAM() { return getToken(SMLParser.KEYWORD_PARAM, 0); }
		public TerminalNode PARAM_NAME() { return getToken(SMLParser.PARAM_NAME, 0); }
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
		enterRule(_localctx, 44, RULE_parameter_description_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(KEYWORD_PARAM);
			setState(243);
			match(PARAM_NAME);
			{
			{
			setState(244);
			match(KEYWORD_FROM);
			setState(245);
			match(INT);
			setState(246);
			match(KEYWORD_TO);
			setState(247);
			match(INT);
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_BY) {
				{
				setState(248);
				match(KEYWORD_BY);
				setState(249);
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
		enterRule(_localctx, 46, RULE_attr_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(KEYWORD_ATTRIBUTE);
			setState(253);
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
		enterRule(_localctx, 48, RULE_attr_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(SYMBOL_REFERENCE);
			setState(256);
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

	public static class Parameterized_attr_referenceContext extends ParserRuleContext {
		public TerminalNode SYMBOL_REFERENCE() { return getToken(SMLParser.SYMBOL_REFERENCE, 0); }
		public TerminalNode PARAM_NAME() { return getToken(SMLParser.PARAM_NAME, 0); }
		public Parameterized_attr_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterized_attr_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterParameterized_attr_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitParameterized_attr_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitParameterized_attr_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameterized_attr_referenceContext parameterized_attr_reference() throws RecognitionException {
		Parameterized_attr_referenceContext _localctx = new Parameterized_attr_referenceContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_parameterized_attr_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(SYMBOL_REFERENCE);
			setState(259);
			match(PARAM_NAME);
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
		enterRule(_localctx, 52, RULE_matrix_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			attr_reference();
			setState(262);
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

	public static class Parameterized_matrix_referenceContext extends ParserRuleContext {
		public Parameterized_attr_referenceContext parameterized_attr_reference() {
			return getRuleContext(Parameterized_attr_referenceContext.class,0);
		}
		public DimensionContext dimension() {
			return getRuleContext(DimensionContext.class,0);
		}
		public Parameterized_matrix_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterized_matrix_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterParameterized_matrix_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitParameterized_matrix_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitParameterized_matrix_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameterized_matrix_referenceContext parameterized_matrix_reference() throws RecognitionException {
		Parameterized_matrix_referenceContext _localctx = new Parameterized_matrix_referenceContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_parameterized_matrix_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			parameterized_attr_reference();
			setState(265);
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

	public static class DimensionContext extends ParserRuleContext {
		public ExpressionContext dimensionN;
		public ExpressionContext dimensionM;
		public List<TerminalNode> SYMBOL_LBRACK() { return getTokens(SMLParser.SYMBOL_LBRACK); }
		public TerminalNode SYMBOL_LBRACK(int i) {
			return getToken(SMLParser.SYMBOL_LBRACK, i);
		}
		public List<TerminalNode> SYMOBL_RBRACK() { return getTokens(SMLParser.SYMOBL_RBRACK); }
		public TerminalNode SYMOBL_RBRACK(int i) {
			return getToken(SMLParser.SYMOBL_RBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 56, RULE_dimension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(SYMBOL_LBRACK);
			setState(268);
			((DimensionContext)_localctx).dimensionN = expression(0);
			setState(269);
			match(SYMOBL_RBRACK);
			setState(270);
			match(SYMBOL_LBRACK);
			setState(271);
			((DimensionContext)_localctx).dimensionM = expression(0);
			setState(272);
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

	public static class Normal_referenceContext extends ParserRuleContext {
		public Attr_referenceContext attr_reference() {
			return getRuleContext(Attr_referenceContext.class,0);
		}
		public Matrix_referenceContext matrix_reference() {
			return getRuleContext(Matrix_referenceContext.class,0);
		}
		public Normal_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normal_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterNormal_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitNormal_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitNormal_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Normal_referenceContext normal_reference() throws RecognitionException {
		Normal_referenceContext _localctx = new Normal_referenceContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_normal_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(274);
				attr_reference();
				}
				break;
			case 2:
				{
				setState(275);
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

	public static class Parameterized_referenceContext extends ParserRuleContext {
		public Parameterized_attr_referenceContext parameterized_attr_reference() {
			return getRuleContext(Parameterized_attr_referenceContext.class,0);
		}
		public Parameterized_matrix_referenceContext parameterized_matrix_reference() {
			return getRuleContext(Parameterized_matrix_referenceContext.class,0);
		}
		public Parameterized_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterized_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterParameterized_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitParameterized_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitParameterized_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameterized_referenceContext parameterized_reference() throws RecognitionException {
		Parameterized_referenceContext _localctx = new Parameterized_referenceContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_parameterized_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(278);
				parameterized_attr_reference();
				}
				break;
			case 2:
				{
				setState(279);
				parameterized_matrix_reference();
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

	public static class ReferenceContext extends ParserRuleContext {
		public Normal_referenceContext normal_reference() {
			return getRuleContext(Normal_referenceContext.class,0);
		}
		public Parameterized_referenceContext parameterized_reference() {
			return getRuleContext(Parameterized_referenceContext.class,0);
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
		enterRule(_localctx, 62, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(282);
				normal_reference();
				}
				break;
			case 2:
				{
				setState(283);
				parameterized_reference();
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SMLParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(SMLParser.FLOAT, 0); }
		public TerminalNode KEYWORD_INF() { return getToken(SMLParser.KEYWORD_INF, 0); }
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
		enterRule(_localctx, 64, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIGN) {
				{
				setState(286);
				match(SIGN);
				}
			}

			setState(289);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEYWORD_INF) | (1L << INT) | (1L << FLOAT))) != 0)) ) {
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

	public static class WordContext extends ParserRuleContext {
		public List<TerminalNode> SYMBOL_QUOTE() { return getTokens(SMLParser.SYMBOL_QUOTE); }
		public TerminalNode SYMBOL_QUOTE(int i) {
			return getToken(SMLParser.SYMBOL_QUOTE, i);
		}
		public List<TerminalNode> SYMBOL_REFERENCE() { return getTokens(SMLParser.SYMBOL_REFERENCE); }
		public TerminalNode SYMBOL_REFERENCE(int i) {
			return getToken(SMLParser.SYMBOL_REFERENCE, i);
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
		enterRule(_localctx, 66, RULE_word);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(SYMBOL_QUOTE);
			setState(293); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(292);
				_la = _input.LA(1);
				if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SYMBOL_REFERENCE) | (1L << SYMBOL_QUOTE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(295); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (STATE_DELIMITER - 2)) | (1L << (STATE_ATTRIBUTES_DELIMITER - 2)) | (1L << (STATE_START_DELIMITER - 2)) | (1L << (STATE_GOAL_DELIMITER - 2)) | (1L << (OPERATOR_DELIMITER - 2)) | (1L << (OPERATOR_DESCRIPTION_DELIMITER - 2)) | (1L << (OPERATOR_PRECONDITION_DELIMITER - 2)) | (1L << (OPERATOR_EFFECT_DELIMITER - 2)) | (1L << (KEYWORD_PARAM - 2)) | (1L << (KEYWORD_FROM - 2)) | (1L << (KEYWORD_TO - 2)) | (1L << (KEYWORD_BY - 2)) | (1L << (KEYWORD_TIMES - 2)) | (1L << (KEYWORD_ATTRIBUTE - 2)) | (1L << (KEYWORD_VAR - 2)) | (1L << (KEYWORD_COST - 2)) | (1L << (KEYWORD_NAME - 2)) | (1L << (KEYWORD_IS - 2)) | (1L << (KEYWORD_OF - 2)) | (1L << (KEYWORD_SET - 2)) | (1L << (KEYWORD_MATRIX - 2)) | (1L << (KEYWORD_WORD - 2)) | (1L << (KEYWORD_NUMBER - 2)) | (1L << (KEYWORD_MINIMUM - 2)) | (1L << (KEYWORD_MAXIMUM - 2)) | (1L << (KEYWORD_SUM - 2)) | (1L << (KEYWORD_AVERAGE - 2)) | (1L << (KEYWORD_UNION - 2)) | (1L << (KEYWORD_INTERSECT - 2)) | (1L << (KEYWORD_DIFFERENCE - 2)) | (1L << (KEYWORD_ADD - 2)) | (1L << (KEYWORD_REMOVE - 2)) | (1L << (KEYWORD_CARDINALITY - 2)) | (1L << (KEYWORD_AND - 2)) | (1L << (KEYWORD_OR - 2)) | (1L << (KEYWORD_NOT - 2)) | (1L << (KEYWORD_INF - 2)) | (1L << (SYMBOL_EQUAL - 2)) | (1L << (SYMBOL_NOT_EQUAL - 2)) | (1L << (SYMBOL_LESSER - 2)) | (1L << (SYMBOL_GREATER - 2)) | (1L << (SYMBOL_LESSER_OR_EQUAL - 2)) | (1L << (SYMBOL_GREATER_OR_EQUAL - 2)) | (1L << (SYMBOL_ADDITION - 2)) | (1L << (SYMBOL_SUBSTRACT - 2)) | (1L << (SYMBOL_MULTIPLICATION - 2)) | (1L << (SYMBOL_DIVISION - 2)) | (1L << (SYMBOL_ASSIGN - 2)) | (1L << (SYMBOL_COMMA - 2)) | (1L << (SYMBOL_SINGLE_QOUTE - 2)) | (1L << (SYMBOL_LPAREN - 2)) | (1L << (SYMBOL_RPAREN - 2)) | (1L << (SYMBOL_LBRACE - 2)) | (1L << (SYMBOL_RBRACE - 2)) | (1L << (SYMBOL_LBRACK - 2)) | (1L << (SYMOBL_RBRACK - 2)) | (1L << (INT - 2)) | (1L << (FLOAT - 2)) | (1L << (SIGN - 2)) | (1L << (PARAM_NAME - 2)) | (1L << (CHAR - 2)) | (1L << (WS - 2)))) != 0) );
			setState(297);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3C\u012e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\5\2I\n\2\3\2\3\2\3\2\6\2N\n\2\r\2\16\2O\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\4\3\4\6\4Z\n\4\r\4\16\4[\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\7\6f\n\6\f\6\16\6i\13\6\3\6\6\6l\n\6\r\6\16\6m\3\7\3\7\5\7"+
		"r\n\7\3\7\3\7\3\7\3\b\3\b\7\by\n\b\f\b\16\b|\13\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\5\n\u0086\n\n\3\n\5\n\u0089\n\n\3\n\7\n\u008c\n\n\f\n\16"+
		"\n\u008f\13\n\3\13\3\13\3\13\3\f\3\f\5\f\u0096\n\f\3\r\3\r\7\r\u009a\n"+
		"\r\f\r\16\r\u009d\13\r\3\r\6\r\u00a0\n\r\r\r\16\r\u00a1\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\5\17\u00ab\n\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u00cf\n\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00d7\n\27\f\27\16\27\u00da"+
		"\13\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00e2\n\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00f0\n\27\f\27\16\27"+
		"\u00f3\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00fd\n\30\3"+
		"\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3"+
		"\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\5\37\u0117\n\37\3 \3"+
		" \5 \u011b\n \3!\3!\5!\u011f\n!\3\"\5\"\u0122\n\"\3\"\3\"\3#\3#\6#\u0128"+
		"\n#\r#\16#\u0129\3#\3#\3#\2\3,$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BD\2\t\3\2\31\32\3\2).\3\2/\62\5\2\33\34\36"+
		"\37\"$\3\2%&\4\2((>?\5\2\3\3\64\64\66\66\u012b\2F\3\2\2\2\4S\3\2\2\2\6"+
		"W\3\2\2\2\b]\3\2\2\2\nc\3\2\2\2\fq\3\2\2\2\16v\3\2\2\2\20\177\3\2\2\2"+
		"\22\u0083\3\2\2\2\24\u0090\3\2\2\2\26\u0093\3\2\2\2\30\u0097\3\2\2\2\32"+
		"\u00a3\3\2\2\2\34\u00aa\3\2\2\2\36\u00ac\3\2\2\2 \u00ae\3\2\2\2\"\u00b0"+
		"\3\2\2\2$\u00b2\3\2\2\2&\u00b4\3\2\2\2(\u00b6\3\2\2\2*\u00bc\3\2\2\2,"+
		"\u00e1\3\2\2\2.\u00f4\3\2\2\2\60\u00fe\3\2\2\2\62\u0101\3\2\2\2\64\u0104"+
		"\3\2\2\2\66\u0107\3\2\2\28\u010a\3\2\2\2:\u010d\3\2\2\2<\u0116\3\2\2\2"+
		">\u011a\3\2\2\2@\u011e\3\2\2\2B\u0121\3\2\2\2D\u0125\3\2\2\2FH\7\4\2\2"+
		"GI\5*\26\2HG\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\5\4\3\2KM\7\b\2\2LN\5\20\t"+
		"\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7\2\2\3R\3\3\2"+
		"\2\2ST\5\6\4\2TU\5\n\6\2UV\5\16\b\2V\5\3\2\2\2WY\7\5\2\2XZ\5\b\5\2YX\3"+
		"\2\2\2Z[\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\7\3\2\2\2]^\5\60\31\2^_\7\25\2"+
		"\2_`\5\34\17\2`a\7\26\2\2ab\5\36\20\2b\t\3\2\2\2cg\7\6\2\2df\5.\30\2e"+
		"d\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hk\3\2\2\2ig\3\2\2\2jl\5\f\7\2"+
		"kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\13\3\2\2\2or\5\62\32\2pr\5\66"+
		"\34\2qo\3\2\2\2qp\3\2\2\2rs\3\2\2\2st\7\63\2\2tu\5,\27\2u\r\3\2\2\2vz"+
		"\7\7\2\2wy\5.\30\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|"+
		"z\3\2\2\2}~\5,\27\2~\17\3\2\2\2\177\u0080\5\22\n\2\u0080\u0081\5\26\f"+
		"\2\u0081\u0082\5\30\r\2\u0082\21\3\2\2\2\u0083\u0085\7\t\2\2\u0084\u0086"+
		"\5*\26\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087"+
		"\u0089\5\24\13\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008d\3"+
		"\2\2\2\u008a\u008c\5.\30\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\23\3\2\2\2\u008f\u008d\3\2\2"+
		"\2\u0090\u0091\7\23\2\2\u0091\u0092\5B\"\2\u0092\25\3\2\2\2\u0093\u0095"+
		"\7\n\2\2\u0094\u0096\5,\27\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\27\3\2\2\2\u0097\u009b\7\13\2\2\u0098\u009a\5(\25\2\u0099\u0098\3\2\2"+
		"\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f"+
		"\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\5\32\16\2\u009f\u009e\3\2\2\2"+
		"\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\31"+
		"\3\2\2\2\u00a3\u00a4\5@!\2\u00a4\u00a5\7\63\2\2\u00a5\u00a6\5,\27\2\u00a6"+
		"\33\3\2\2\2\u00a7\u00ab\7\27\2\2\u00a8\u00a9\7\30\2\2\u00a9\u00ab\5:\36"+
		"\2\u00aa\u00a7\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\35\3\2\2\2\u00ac\u00ad"+
		"\t\2\2\2\u00ad\37\3\2\2\2\u00ae\u00af\t\3\2\2\u00af!\3\2\2\2\u00b0\u00b1"+
		"\t\4\2\2\u00b1#\3\2\2\2\u00b2\u00b3\t\5\2\2\u00b3%\3\2\2\2\u00b4\u00b5"+
		"\t\6\2\2\u00b5\'\3\2\2\2\u00b6\u00b7\7\22\2\2\u00b7\u00b8\5\36\20\2\u00b8"+
		"\u00b9\7A\2\2\u00b9\u00ba\7\63\2\2\u00ba\u00bb\5,\27\2\u00bb)\3\2\2\2"+
		"\u00bc\u00bd\7\24\2\2\u00bd\u00be\5D#\2\u00be+\3\2\2\2\u00bf\u00c0\b\27"+
		"\1\2\u00c0\u00c1\78\2\2\u00c1\u00c2\5,\27\2\u00c2\u00c3\79\2\2\u00c3\u00e2"+
		"\3\2\2\2\u00c4\u00c5\5$\23\2\u00c5\u00c6\78\2\2\u00c6\u00c7\5,\27\2\u00c7"+
		"\u00c8\79\2\2\u00c8\u00e2\3\2\2\2\u00c9\u00ca\5$\23\2\u00ca\u00cb\78\2"+
		"\2\u00cb\u00ce\5,\27\2\u00cc\u00cd\7\65\2\2\u00cd\u00cf\5,\27\2\u00ce"+
		"\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\79"+
		"\2\2\u00d1\u00e2\3\2\2\2\u00d2\u00d3\7:\2\2\u00d3\u00d8\5,\27\2\u00d4"+
		"\u00d5\7\65\2\2\u00d5\u00d7\5,\27\2\u00d6\u00d4\3\2\2\2\u00d7\u00da\3"+
		"\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00db\u00dc\7;\2\2\u00dc\u00e2\3\2\2\2\u00dd\u00e2\5@!"+
		"\2\u00de\u00e2\5D#\2\u00df\u00e2\5B\"\2\u00e0\u00e2\7A\2\2\u00e1\u00bf"+
		"\3\2\2\2\u00e1\u00c4\3\2\2\2\u00e1\u00c9\3\2\2\2\u00e1\u00d2\3\2\2\2\u00e1"+
		"\u00dd\3\2\2\2\u00e1\u00de\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2"+
		"\2\2\u00e2\u00f1\3\2\2\2\u00e3\u00e4\f\f\2\2\u00e4\u00e5\5 \21\2\u00e5"+
		"\u00e6\5,\27\r\u00e6\u00f0\3\2\2\2\u00e7\u00e8\f\13\2\2\u00e8\u00e9\5"+
		"&\24\2\u00e9\u00ea\5,\27\f\u00ea\u00f0\3\2\2\2\u00eb\u00ec\f\n\2\2\u00ec"+
		"\u00ed\5\"\22\2\u00ed\u00ee\5,\27\13\u00ee\u00f0\3\2\2\2\u00ef\u00e3\3"+
		"\2\2\2\u00ef\u00e7\3\2\2\2\u00ef\u00eb\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2-\3\2\2\2\u00f3\u00f1\3\2\2\2"+
		"\u00f4\u00f5\7\f\2\2\u00f5\u00f6\7A\2\2\u00f6\u00f7\7\r\2\2\u00f7\u00f8"+
		"\7>\2\2\u00f8\u00f9\7\16\2\2\u00f9\u00fc\7>\2\2\u00fa\u00fb\7\17\2\2\u00fb"+
		"\u00fd\7>\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd/\3\2\2\2\u00fe"+
		"\u00ff\7\21\2\2\u00ff\u0100\7>\2\2\u0100\61\3\2\2\2\u0101\u0102\7\64\2"+
		"\2\u0102\u0103\7>\2\2\u0103\63\3\2\2\2\u0104\u0105\7\64\2\2\u0105\u0106"+
		"\7A\2\2\u0106\65\3\2\2\2\u0107\u0108\5\62\32\2\u0108\u0109\5:\36\2\u0109"+
		"\67\3\2\2\2\u010a\u010b\5\64\33\2\u010b\u010c\5:\36\2\u010c9\3\2\2\2\u010d"+
		"\u010e\7<\2\2\u010e\u010f\5,\27\2\u010f\u0110\7=\2\2\u0110\u0111\7<\2"+
		"\2\u0111\u0112\5,\27\2\u0112\u0113\7=\2\2\u0113;\3\2\2\2\u0114\u0117\5"+
		"\62\32\2\u0115\u0117\5\66\34\2\u0116\u0114\3\2\2\2\u0116\u0115\3\2\2\2"+
		"\u0117=\3\2\2\2\u0118\u011b\5\64\33\2\u0119\u011b\58\35\2\u011a\u0118"+
		"\3\2\2\2\u011a\u0119\3\2\2\2\u011b?\3\2\2\2\u011c\u011f\5<\37\2\u011d"+
		"\u011f\5> \2\u011e\u011c\3\2\2\2\u011e\u011d\3\2\2\2\u011fA\3\2\2\2\u0120"+
		"\u0122\7@\2\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123\u0124\t\7\2\2\u0124C\3\2\2\2\u0125\u0127\7\66\2\2\u0126\u0128"+
		"\n\b\2\2\u0127\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u0127\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\7\66\2\2\u012cE\3\2\2\2"+
		"\33HO[gmqz\u0085\u0088\u008d\u0095\u009b\u00a1\u00aa\u00ce\u00d8\u00e1"+
		"\u00ef\u00f1\u00fc\u0116\u011a\u011e\u0121\u0129";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from D:/Laci/egyetem/szakdolgozat/SML/src/main/java/antlr\SML.g4 by ANTLR 4.6
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SMLLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "STATE_DELIMITER", "STATE_ATTRIBUTES_DELIMITER", "STATE_START_DELIMITER", 
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


	public SMLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SML.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2C\u01ea\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3"+
		"#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3"+
		")\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3"+
		":\3:\3;\3;\3<\3<\3=\3=\7=\u01c4\n=\f=\16=\u01c7\13=\3>\3>\7>\u01cb\n>"+
		"\f>\16>\u01ce\13>\3>\3>\7>\u01d2\n>\f>\16>\u01d5\13>\3?\3?\3@\3@\3@\3"+
		"@\7@\u01dd\n@\f@\16@\u01e0\13@\3A\3A\3B\6B\u01e5\nB\rB\16B\u01e6\3B\3"+
		"B\2\2C\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35"+
		"9\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66"+
		"k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\3\2\5\4\2--//\4\2C\\c|\5\2\13"+
		"\f\17\17\"\"\u01f0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2"+
		"\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2"+
		"\u0083\3\2\2\2\3\u0085\3\2\2\2\5\u0087\3\2\2\2\7\u008e\3\2\2\2\t\u00a0"+
		"\3\2\2\2\13\u00ad\3\2\2\2\r\u00b9\3\2\2\2\17\u00c4\3\2\2\2\21\u00da\3"+
		"\2\2\2\23\u00f1\3\2\2\2\25\u0102\3\2\2\2\27\u0108\3\2\2\2\31\u010d\3\2"+
		"\2\2\33\u0110\3\2\2\2\35\u0113\3\2\2\2\37\u0119\3\2\2\2!\u011e\3\2\2\2"+
		"#\u0122\3\2\2\2%\u0127\3\2\2\2\'\u012c\3\2\2\2)\u012f\3\2\2\2+\u0132\3"+
		"\2\2\2-\u0136\3\2\2\2/\u013d\3\2\2\2\61\u0142\3\2\2\2\63\u0149\3\2\2\2"+
		"\65\u014d\3\2\2\2\67\u0151\3\2\2\29\u0155\3\2\2\2;\u0159\3\2\2\2=\u015f"+
		"\3\2\2\2?\u0169\3\2\2\2A\u0174\3\2\2\2C\u0178\3\2\2\2E\u017f\3\2\2\2G"+
		"\u0184\3\2\2\2I\u0188\3\2\2\2K\u018b\3\2\2\2M\u018f\3\2\2\2O\u0193\3\2"+
		"\2\2Q\u0196\3\2\2\2S\u0199\3\2\2\2U\u019b\3\2\2\2W\u019d\3\2\2\2Y\u01a0"+
		"\3\2\2\2[\u01a3\3\2\2\2]\u01a5\3\2\2\2_\u01a7\3\2\2\2a\u01a9\3\2\2\2c"+
		"\u01ab\3\2\2\2e\u01ad\3\2\2\2g\u01af\3\2\2\2i\u01b1\3\2\2\2k\u01b3\3\2"+
		"\2\2m\u01b5\3\2\2\2o\u01b7\3\2\2\2q\u01b9\3\2\2\2s\u01bb\3\2\2\2u\u01bd"+
		"\3\2\2\2w\u01bf\3\2\2\2y\u01c1\3\2\2\2{\u01c8\3\2\2\2}\u01d6\3\2\2\2\177"+
		"\u01d8\3\2\2\2\u0081\u01e1\3\2\2\2\u0083\u01e4\3\2\2\2\u0085\u0086\7^"+
		"\2\2\u0086\4\3\2\2\2\u0087\u0088\7U\2\2\u0088\u0089\7V\2\2\u0089\u008a"+
		"\7C\2\2\u008a\u008b\7V\2\2\u008b\u008c\7G\2\2\u008c\u008d\7<\2\2\u008d"+
		"\6\3\2\2\2\u008e\u008f\7U\2\2\u008f\u0090\7V\2\2\u0090\u0091\7C\2\2\u0091"+
		"\u0092\7V\2\2\u0092\u0093\7G\2\2\u0093\u0094\7a\2\2\u0094\u0095\7C\2\2"+
		"\u0095\u0096\7V\2\2\u0096\u0097\7V\2\2\u0097\u0098\7T\2\2\u0098\u0099"+
		"\7K\2\2\u0099\u009a\7D\2\2\u009a\u009b\7W\2\2\u009b\u009c\7V\2\2\u009c"+
		"\u009d\7G\2\2\u009d\u009e\7U\2\2\u009e\u009f\7<\2\2\u009f\b\3\2\2\2\u00a0"+
		"\u00a1\7U\2\2\u00a1\u00a2\7V\2\2\u00a2\u00a3\7C\2\2\u00a3\u00a4\7V\2\2"+
		"\u00a4\u00a5\7G\2\2\u00a5\u00a6\7a\2\2\u00a6\u00a7\7U\2\2\u00a7\u00a8"+
		"\7V\2\2\u00a8\u00a9\7C\2\2\u00a9\u00aa\7T\2\2\u00aa\u00ab\7V\2\2\u00ab"+
		"\u00ac\7<\2\2\u00ac\n\3\2\2\2\u00ad\u00ae\7U\2\2\u00ae\u00af\7V\2\2\u00af"+
		"\u00b0\7C\2\2\u00b0\u00b1\7V\2\2\u00b1\u00b2\7G\2\2\u00b2\u00b3\7a\2\2"+
		"\u00b3\u00b4\7I\2\2\u00b4\u00b5\7Q\2\2\u00b5\u00b6\7C\2\2\u00b6\u00b7"+
		"\7N\2\2\u00b7\u00b8\7<\2\2\u00b8\f\3\2\2\2\u00b9\u00ba\7Q\2\2\u00ba\u00bb"+
		"\7R\2\2\u00bb\u00bc\7G\2\2\u00bc\u00bd\7T\2\2\u00bd\u00be\7C\2\2\u00be"+
		"\u00bf\7V\2\2\u00bf\u00c0\7Q\2\2\u00c0\u00c1\7T\2\2\u00c1\u00c2\7U\2\2"+
		"\u00c2\u00c3\7<\2\2\u00c3\16\3\2\2\2\u00c4\u00c5\7Q\2\2\u00c5\u00c6\7"+
		"R\2\2\u00c6\u00c7\7G\2\2\u00c7\u00c8\7T\2\2\u00c8\u00c9\7C\2\2\u00c9\u00ca"+
		"\7V\2\2\u00ca\u00cb\7Q\2\2\u00cb\u00cc\7T\2\2\u00cc\u00cd\7a\2\2\u00cd"+
		"\u00ce\7F\2\2\u00ce\u00cf\7G\2\2\u00cf\u00d0\7U\2\2\u00d0\u00d1\7E\2\2"+
		"\u00d1\u00d2\7T\2\2\u00d2\u00d3\7K\2\2\u00d3\u00d4\7R\2\2\u00d4\u00d5"+
		"\7V\2\2\u00d5\u00d6\7K\2\2\u00d6\u00d7\7Q\2\2\u00d7\u00d8\7P\2\2\u00d8"+
		"\u00d9\7<\2\2\u00d9\20\3\2\2\2\u00da\u00db\7Q\2\2\u00db\u00dc\7R\2\2\u00dc"+
		"\u00dd\7G\2\2\u00dd\u00de\7T\2\2\u00de\u00df\7C\2\2\u00df\u00e0\7V\2\2"+
		"\u00e0\u00e1\7Q\2\2\u00e1\u00e2\7T\2\2\u00e2\u00e3\7a\2\2\u00e3\u00e4"+
		"\7R\2\2\u00e4\u00e5\7T\2\2\u00e5\u00e6\7G\2\2\u00e6\u00e7\7E\2\2\u00e7"+
		"\u00e8\7Q\2\2\u00e8\u00e9\7P\2\2\u00e9\u00ea\7F\2\2\u00ea\u00eb\7K\2\2"+
		"\u00eb\u00ec\7V\2\2\u00ec\u00ed\7K\2\2\u00ed\u00ee\7Q\2\2\u00ee\u00ef"+
		"\7P\2\2\u00ef\u00f0\7<\2\2\u00f0\22\3\2\2\2\u00f1\u00f2\7Q\2\2\u00f2\u00f3"+
		"\7R\2\2\u00f3\u00f4\7G\2\2\u00f4\u00f5\7T\2\2\u00f5\u00f6\7C\2\2\u00f6"+
		"\u00f7\7V\2\2\u00f7\u00f8\7Q\2\2\u00f8\u00f9\7T\2\2\u00f9\u00fa\7a\2\2"+
		"\u00fa\u00fb\7G\2\2\u00fb\u00fc\7H\2\2\u00fc\u00fd\7H\2\2\u00fd\u00fe"+
		"\7G\2\2\u00fe\u00ff\7E\2\2\u00ff\u0100\7V\2\2\u0100\u0101\7<\2\2\u0101"+
		"\24\3\2\2\2\u0102\u0103\7r\2\2\u0103\u0104\7c\2\2\u0104\u0105\7t\2\2\u0105"+
		"\u0106\7c\2\2\u0106\u0107\7o\2\2\u0107\26\3\2\2\2\u0108\u0109\7h\2\2\u0109"+
		"\u010a\7t\2\2\u010a\u010b\7q\2\2\u010b\u010c\7o\2\2\u010c\30\3\2\2\2\u010d"+
		"\u010e\7v\2\2\u010e\u010f\7q\2\2\u010f\32\3\2\2\2\u0110\u0111\7d\2\2\u0111"+
		"\u0112\7{\2\2\u0112\34\3\2\2\2\u0113\u0114\7v\2\2\u0114\u0115\7k\2\2\u0115"+
		"\u0116\7o\2\2\u0116\u0117\7g\2\2\u0117\u0118\7u\2\2\u0118\36\3\2\2\2\u0119"+
		"\u011a\7C\2\2\u011a\u011b\7v\2\2\u011b\u011c\7v\2\2\u011c\u011d\7t\2\2"+
		"\u011d \3\2\2\2\u011e\u011f\7x\2\2\u011f\u0120\7c\2\2\u0120\u0121\7t\2"+
		"\2\u0121\"\3\2\2\2\u0122\u0123\7e\2\2\u0123\u0124\7q\2\2\u0124\u0125\7"+
		"u\2\2\u0125\u0126\7v\2\2\u0126$\3\2\2\2\u0127\u0128\7p\2\2\u0128\u0129"+
		"\7c\2\2\u0129\u012a\7o\2\2\u012a\u012b\7g\2\2\u012b&\3\2\2\2\u012c\u012d"+
		"\7k\2\2\u012d\u012e\7u\2\2\u012e(\3\2\2\2\u012f\u0130\7q\2\2\u0130\u0131"+
		"\7h\2\2\u0131*\3\2\2\2\u0132\u0133\7u\2\2\u0133\u0134\7g\2\2\u0134\u0135"+
		"\7v\2\2\u0135,\3\2\2\2\u0136\u0137\7o\2\2\u0137\u0138\7c\2\2\u0138\u0139"+
		"\7v\2\2\u0139\u013a\7t\2\2\u013a\u013b\7k\2\2\u013b\u013c\7z\2\2\u013c"+
		".\3\2\2\2\u013d\u013e\7y\2\2\u013e\u013f\7q\2\2\u013f\u0140\7t\2\2\u0140"+
		"\u0141\7f\2\2\u0141\60\3\2\2\2\u0142\u0143\7p\2\2\u0143\u0144\7w\2\2\u0144"+
		"\u0145\7o\2\2\u0145\u0146\7d\2\2\u0146\u0147\7g\2\2\u0147\u0148\7t\2\2"+
		"\u0148\62\3\2\2\2\u0149\u014a\7o\2\2\u014a\u014b\7k\2\2\u014b\u014c\7"+
		"p\2\2\u014c\64\3\2\2\2\u014d\u014e\7o\2\2\u014e\u014f\7c\2\2\u014f\u0150"+
		"\7z\2\2\u0150\66\3\2\2\2\u0151\u0152\7u\2\2\u0152\u0153\7w\2\2\u0153\u0154"+
		"\7o\2\2\u01548\3\2\2\2\u0155\u0156\7c\2\2\u0156\u0157\7x\2\2\u0157\u0158"+
		"\7i\2\2\u0158:\3\2\2\2\u0159\u015a\7w\2\2\u015a\u015b\7p\2\2\u015b\u015c"+
		"\7k\2\2\u015c\u015d\7q\2\2\u015d\u015e\7p\2\2\u015e<\3\2\2\2\u015f\u0160"+
		"\7k\2\2\u0160\u0161\7p\2\2\u0161\u0162\7v\2\2\u0162\u0163\7g\2\2\u0163"+
		"\u0164\7t\2\2\u0164\u0165\7u\2\2\u0165\u0166\7g\2\2\u0166\u0167\7e\2\2"+
		"\u0167\u0168\7v\2\2\u0168>\3\2\2\2\u0169\u016a\7f\2\2\u016a\u016b\7k\2"+
		"\2\u016b\u016c\7h\2\2\u016c\u016d\7h\2\2\u016d\u016e\7g\2\2\u016e\u016f"+
		"\7t\2\2\u016f\u0170\7g\2\2\u0170\u0171\7p\2\2\u0171\u0172\7e\2\2\u0172"+
		"\u0173\7g\2\2\u0173@\3\2\2\2\u0174\u0175\7c\2\2\u0175\u0176\7f\2\2\u0176"+
		"\u0177\7f\2\2\u0177B\3\2\2\2\u0178\u0179\7t\2\2\u0179\u017a\7g\2\2\u017a"+
		"\u017b\7o\2\2\u017b\u017c\7q\2\2\u017c\u017d\7x\2\2\u017d\u017e\7g\2\2"+
		"\u017eD\3\2\2\2\u017f\u0180\7e\2\2\u0180\u0181\7c\2\2\u0181\u0182\7t\2"+
		"\2\u0182\u0183\7f\2\2\u0183F\3\2\2\2\u0184\u0185\7c\2\2\u0185\u0186\7"+
		"p\2\2\u0186\u0187\7f\2\2\u0187H\3\2\2\2\u0188\u0189\7q\2\2\u0189\u018a"+
		"\7t\2\2\u018aJ\3\2\2\2\u018b\u018c\7p\2\2\u018c\u018d\7q\2\2\u018d\u018e"+
		"\7v\2\2\u018eL\3\2\2\2\u018f\u0190\7k\2\2\u0190\u0191\7p\2\2\u0191\u0192"+
		"\7h\2\2\u0192N\3\2\2\2\u0193\u0194\7?\2\2\u0194\u0195\7?\2\2\u0195P\3"+
		"\2\2\2\u0196\u0197\7#\2\2\u0197\u0198\7?\2\2\u0198R\3\2\2\2\u0199\u019a"+
		"\7>\2\2\u019aT\3\2\2\2\u019b\u019c\7@\2\2\u019cV\3\2\2\2\u019d\u019e\7"+
		">\2\2\u019e\u019f\7?\2\2\u019fX\3\2\2\2\u01a0\u01a1\7@\2\2\u01a1\u01a2"+
		"\7?\2\2\u01a2Z\3\2\2\2\u01a3\u01a4\7-\2\2\u01a4\\\3\2\2\2\u01a5\u01a6"+
		"\7/\2\2\u01a6^\3\2\2\2\u01a7\u01a8\7,\2\2\u01a8`\3\2\2\2\u01a9\u01aa\7"+
		"\61\2\2\u01aab\3\2\2\2\u01ab\u01ac\7?\2\2\u01acd\3\2\2\2\u01ad\u01ae\7"+
		"&\2\2\u01aef\3\2\2\2\u01af\u01b0\7.\2\2\u01b0h\3\2\2\2\u01b1\u01b2\7$"+
		"\2\2\u01b2j\3\2\2\2\u01b3\u01b4\7)\2\2\u01b4l\3\2\2\2\u01b5\u01b6\7*\2"+
		"\2\u01b6n\3\2\2\2\u01b7\u01b8\7+\2\2\u01b8p\3\2\2\2\u01b9\u01ba\7}\2\2"+
		"\u01bar\3\2\2\2\u01bb\u01bc\7\177\2\2\u01bct\3\2\2\2\u01bd\u01be\7]\2"+
		"\2\u01bev\3\2\2\2\u01bf\u01c0\7_\2\2\u01c0x\3\2\2\2\u01c1\u01c5\4\62;"+
		"\2\u01c2\u01c4\4\62;\2\u01c3\u01c2\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c3"+
		"\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6z\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c8"+
		"\u01cc\4\62;\2\u01c9\u01cb\4\62;\2\u01ca\u01c9\3\2\2\2\u01cb\u01ce\3\2"+
		"\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce"+
		"\u01cc\3\2\2\2\u01cf\u01d3\7\60\2\2\u01d0\u01d2\4\62;\2\u01d1\u01d0\3"+
		"\2\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4"+
		"|\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d6\u01d7\t\2\2\2\u01d7~\3\2\2\2\u01d8"+
		"\u01de\4c|\2\u01d9\u01dd\5y=\2\u01da\u01dd\5\u0081A\2\u01db\u01dd\7a\2"+
		"\2\u01dc\u01d9\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01db\3\2\2\2\u01dd\u01e0"+
		"\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u0080\3\2\2\2\u01e0"+
		"\u01de\3\2\2\2\u01e1\u01e2\t\3\2\2\u01e2\u0082\3\2\2\2\u01e3\u01e5\t\4"+
		"\2\2\u01e4\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6"+
		"\u01e7\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\bB\2\2\u01e9\u0084\3\2"+
		"\2\2\t\2\u01c5\u01cc\u01d3\u01dc\u01de\u01e6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
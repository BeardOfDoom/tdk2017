// Generated from D:/Laci/egyetem/szakdolgozat/tdk2017/generator/src/main/java/antlr\SML.g4 by ANTLR 4.6
package antlr.generated;
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"KEYWORD_PARAM", "KEYWORD_FROM", "KEYWORD_TO", "KEYWORD_BY", "KEYWORD_TIMES", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\67\u018b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3"+
		"-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/\3"+
		"/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\7\62\u016e"+
		"\n\62\f\62\16\62\u0171\13\62\3\63\3\63\7\63\u0175\n\63\f\63\16\63\u0178"+
		"\13\63\3\63\3\63\7\63\u017c\n\63\f\63\16\63\u017f\13\63\3\64\3\64\3\65"+
		"\3\65\3\66\6\66\u0186\n\66\r\66\16\66\u0187\3\66\3\66\2\2\67\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67\3\2\5\4\2-"+
		"-//\4\2C\\c|\5\2\13\f\17\17\"\"\u018e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2"+
		"[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3"+
		"\2\2\2\2i\3\2\2\2\2k\3\2\2\2\3m\3\2\2\2\5s\3\2\2\2\7x\3\2\2\2\t{\3\2\2"+
		"\2\13~\3\2\2\2\r\u0084\3\2\2\2\17\u0089\3\2\2\2\21\u008d\3\2\2\2\23\u0092"+
		"\3\2\2\2\25\u0095\3\2\2\2\27\u0098\3\2\2\2\31\u009c\3\2\2\2\33\u00a3\3"+
		"\2\2\2\35\u00a8\3\2\2\2\37\u00af\3\2\2\2!\u00b2\3\2\2\2#\u00b5\3\2\2\2"+
		"%\u00b7\3\2\2\2\'\u00b9\3\2\2\2)\u00bc\3\2\2\2+\u00bf\3\2\2\2-\u00c1\3"+
		"\2\2\2/\u00c3\3\2\2\2\61\u00c5\3\2\2\2\63\u00c7\3\2\2\2\65\u00c9\3\2\2"+
		"\2\67\u00cb\3\2\2\29\u00cd\3\2\2\2;\u00cf\3\2\2\2=\u00d1\3\2\2\2?\u00d3"+
		"\3\2\2\2A\u00d5\3\2\2\2C\u00d7\3\2\2\2E\u00d9\3\2\2\2G\u00db\3\2\2\2I"+
		"\u00df\3\2\2\2K\u00e3\3\2\2\2M\u00e7\3\2\2\2O\u00ec\3\2\2\2Q\u00f0\3\2"+
		"\2\2S\u00f3\3\2\2\2U\u00f7\3\2\2\2W\u0109\3\2\2\2Y\u0116\3\2\2\2[\u0122"+
		"\3\2\2\2]\u012d\3\2\2\2_\u0143\3\2\2\2a\u015a\3\2\2\2c\u016b\3\2\2\2e"+
		"\u0172\3\2\2\2g\u0180\3\2\2\2i\u0182\3\2\2\2k\u0185\3\2\2\2mn\7r\2\2n"+
		"o\7c\2\2op\7t\2\2pq\7c\2\2qr\7o\2\2r\4\3\2\2\2st\7h\2\2tu\7t\2\2uv\7q"+
		"\2\2vw\7o\2\2w\6\3\2\2\2xy\7v\2\2yz\7q\2\2z\b\3\2\2\2{|\7d\2\2|}\7{\2"+
		"\2}\n\3\2\2\2~\177\7v\2\2\177\u0080\7k\2\2\u0080\u0081\7o\2\2\u0081\u0082"+
		"\7g\2\2\u0082\u0083\7u\2\2\u0083\f\3\2\2\2\u0084\u0085\7C\2\2\u0085\u0086"+
		"\7v\2\2\u0086\u0087\7v\2\2\u0087\u0088\7t\2\2\u0088\16\3\2\2\2\u0089\u008a"+
		"\7x\2\2\u008a\u008b\7c\2\2\u008b\u008c\7t\2\2\u008c\20\3\2\2\2\u008d\u008e"+
		"\7e\2\2\u008e\u008f\7q\2\2\u008f\u0090\7u\2\2\u0090\u0091\7v\2\2\u0091"+
		"\22\3\2\2\2\u0092\u0093\7k\2\2\u0093\u0094\7u\2\2\u0094\24\3\2\2\2\u0095"+
		"\u0096\7q\2\2\u0096\u0097\7h\2\2\u0097\26\3\2\2\2\u0098\u0099\7u\2\2\u0099"+
		"\u009a\7g\2\2\u009a\u009b\7v\2\2\u009b\30\3\2\2\2\u009c\u009d\7o\2\2\u009d"+
		"\u009e\7c\2\2\u009e\u009f\7v\2\2\u009f\u00a0\7t\2\2\u00a0\u00a1\7k\2\2"+
		"\u00a1\u00a2\7z\2\2\u00a2\32\3\2\2\2\u00a3\u00a4\7y\2\2\u00a4\u00a5\7"+
		"q\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7f\2\2\u00a7\34\3\2\2\2\u00a8\u00a9"+
		"\7p\2\2\u00a9\u00aa\7w\2\2\u00aa\u00ab\7o\2\2\u00ab\u00ac\7d\2\2\u00ac"+
		"\u00ad\7g\2\2\u00ad\u00ae\7t\2\2\u00ae\36\3\2\2\2\u00af\u00b0\7?\2\2\u00b0"+
		"\u00b1\7?\2\2\u00b1 \3\2\2\2\u00b2\u00b3\7#\2\2\u00b3\u00b4\7?\2\2\u00b4"+
		"\"\3\2\2\2\u00b5\u00b6\7>\2\2\u00b6$\3\2\2\2\u00b7\u00b8\7@\2\2\u00b8"+
		"&\3\2\2\2\u00b9\u00ba\7>\2\2\u00ba\u00bb\7?\2\2\u00bb(\3\2\2\2\u00bc\u00bd"+
		"\7@\2\2\u00bd\u00be\7?\2\2\u00be*\3\2\2\2\u00bf\u00c0\7-\2\2\u00c0,\3"+
		"\2\2\2\u00c1\u00c2\7/\2\2\u00c2.\3\2\2\2\u00c3\u00c4\7,\2\2\u00c4\60\3"+
		"\2\2\2\u00c5\u00c6\7\61\2\2\u00c6\62\3\2\2\2\u00c7\u00c8\7?\2\2\u00c8"+
		"\64\3\2\2\2\u00c9\u00ca\7&\2\2\u00ca\66\3\2\2\2\u00cb\u00cc\7$\2\2\u00cc"+
		"8\3\2\2\2\u00cd\u00ce\7.\2\2\u00ce:\3\2\2\2\u00cf\u00d0\7*\2\2\u00d0<"+
		"\3\2\2\2\u00d1\u00d2\7+\2\2\u00d2>\3\2\2\2\u00d3\u00d4\7}\2\2\u00d4@\3"+
		"\2\2\2\u00d5\u00d6\7\177\2\2\u00d6B\3\2\2\2\u00d7\u00d8\7]\2\2\u00d8D"+
		"\3\2\2\2\u00d9\u00da\7_\2\2\u00daF\3\2\2\2\u00db\u00dc\7o\2\2\u00dc\u00dd"+
		"\7c\2\2\u00dd\u00de\7z\2\2\u00deH\3\2\2\2\u00df\u00e0\7o\2\2\u00e0\u00e1"+
		"\7k\2\2\u00e1\u00e2\7p\2\2\u00e2J\3\2\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5"+
		"\7x\2\2\u00e5\u00e6\7i\2\2\u00e6L\3\2\2\2\u00e7\u00e8\7e\2\2\u00e8\u00e9"+
		"\7c\2\2\u00e9\u00ea\7t\2\2\u00ea\u00eb\7f\2\2\u00ebN\3\2\2\2\u00ec\u00ed"+
		"\7c\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef\7f\2\2\u00efP\3\2\2\2\u00f0\u00f1"+
		"\7q\2\2\u00f1\u00f2\7t\2\2\u00f2R\3\2\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5"+
		"\7q\2\2\u00f5\u00f6\7v\2\2\u00f6T\3\2\2\2\u00f7\u00f8\7U\2\2\u00f8\u00f9"+
		"\7V\2\2\u00f9\u00fa\7C\2\2\u00fa\u00fb\7V\2\2\u00fb\u00fc\7G\2\2\u00fc"+
		"\u00fd\7a\2\2\u00fd\u00fe\7C\2\2\u00fe\u00ff\7V\2\2\u00ff\u0100\7V\2\2"+
		"\u0100\u0101\7T\2\2\u0101\u0102\7K\2\2\u0102\u0103\7D\2\2\u0103\u0104"+
		"\7W\2\2\u0104\u0105\7V\2\2\u0105\u0106\7G\2\2\u0106\u0107\7U\2\2\u0107"+
		"\u0108\7<\2\2\u0108V\3\2\2\2\u0109\u010a\7U\2\2\u010a\u010b\7V\2\2\u010b"+
		"\u010c\7C\2\2\u010c\u010d\7V\2\2\u010d\u010e\7G\2\2\u010e\u010f\7a\2\2"+
		"\u010f\u0110\7U\2\2\u0110\u0111\7V\2\2\u0111\u0112\7C\2\2\u0112\u0113"+
		"\7T\2\2\u0113\u0114\7V\2\2\u0114\u0115\7<\2\2\u0115X\3\2\2\2\u0116\u0117"+
		"\7U\2\2\u0117\u0118\7V\2\2\u0118\u0119\7C\2\2\u0119\u011a\7V\2\2\u011a"+
		"\u011b\7G\2\2\u011b\u011c\7a\2\2\u011c\u011d\7I\2\2\u011d\u011e\7Q\2\2"+
		"\u011e\u011f\7C\2\2\u011f\u0120\7N\2\2\u0120\u0121\7<\2\2\u0121Z\3\2\2"+
		"\2\u0122\u0123\7Q\2\2\u0123\u0124\7R\2\2\u0124\u0125\7G\2\2\u0125\u0126"+
		"\7T\2\2\u0126\u0127\7C\2\2\u0127\u0128\7V\2\2\u0128\u0129\7Q\2\2\u0129"+
		"\u012a\7T\2\2\u012a\u012b\7U\2\2\u012b\u012c\7<\2\2\u012c\\\3\2\2\2\u012d"+
		"\u012e\7Q\2\2\u012e\u012f\7R\2\2\u012f\u0130\7G\2\2\u0130\u0131\7T\2\2"+
		"\u0131\u0132\7C\2\2\u0132\u0133\7V\2\2\u0133\u0134\7Q\2\2\u0134\u0135"+
		"\7T\2\2\u0135\u0136\7a\2\2\u0136\u0137\7F\2\2\u0137\u0138\7G\2\2\u0138"+
		"\u0139\7U\2\2\u0139\u013a\7E\2\2\u013a\u013b\7T\2\2\u013b\u013c\7K\2\2"+
		"\u013c\u013d\7R\2\2\u013d\u013e\7V\2\2\u013e\u013f\7K\2\2\u013f\u0140"+
		"\7Q\2\2\u0140\u0141\7P\2\2\u0141\u0142\7<\2\2\u0142^\3\2\2\2\u0143\u0144"+
		"\7Q\2\2\u0144\u0145\7R\2\2\u0145\u0146\7G\2\2\u0146\u0147\7T\2\2\u0147"+
		"\u0148\7C\2\2\u0148\u0149\7V\2\2\u0149\u014a\7Q\2\2\u014a\u014b\7T\2\2"+
		"\u014b\u014c\7a\2\2\u014c\u014d\7R\2\2\u014d\u014e\7T\2\2\u014e\u014f"+
		"\7G\2\2\u014f\u0150\7E\2\2\u0150\u0151\7Q\2\2\u0151\u0152\7P\2\2\u0152"+
		"\u0153\7F\2\2\u0153\u0154\7K\2\2\u0154\u0155\7V\2\2\u0155\u0156\7K\2\2"+
		"\u0156\u0157\7Q\2\2\u0157\u0158\7P\2\2\u0158\u0159\7<\2\2\u0159`\3\2\2"+
		"\2\u015a\u015b\7Q\2\2\u015b\u015c\7R\2\2\u015c\u015d\7G\2\2\u015d\u015e"+
		"\7T\2\2\u015e\u015f\7C\2\2\u015f\u0160\7V\2\2\u0160\u0161\7Q\2\2\u0161"+
		"\u0162\7T\2\2\u0162\u0163\7a\2\2\u0163\u0164\7G\2\2\u0164\u0165\7H\2\2"+
		"\u0165\u0166\7H\2\2\u0166\u0167\7G\2\2\u0167\u0168\7E\2\2\u0168\u0169"+
		"\7V\2\2\u0169\u016a\7<\2\2\u016ab\3\2\2\2\u016b\u016f\4\62;\2\u016c\u016e"+
		"\4\62;\2\u016d\u016c\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170d\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0176\4\62;\2"+
		"\u0173\u0175\4\62;\2\u0174\u0173\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0174"+
		"\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0179\3\2\2\2\u0178\u0176\3\2\2\2\u0179"+
		"\u017d\7\60\2\2\u017a\u017c\4\62;\2\u017b\u017a\3\2\2\2\u017c\u017f\3"+
		"\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017ef\3\2\2\2\u017f\u017d"+
		"\3\2\2\2\u0180\u0181\t\2\2\2\u0181h\3\2\2\2\u0182\u0183\t\3\2\2\u0183"+
		"j\3\2\2\2\u0184\u0186\t\4\2\2\u0185\u0184\3\2\2\2\u0186\u0187\3\2\2\2"+
		"\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a"+
		"\b\66\2\2\u018al\3\2\2\2\7\2\u016f\u0176\u017d\u0187\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
grammar SML;

expr: STATE_DELIMITER name_defining_expression? state_expr OPERATOR_DELIMITER operation_expr+ EOF;

state_expr: state_description state_start state_goal;

state_description: STATE_ATTRIBUTES_DELIMITER state_description_line+;

state_description_line: attr_name KEYWORD_IS attr_struct KEYWORD_OF attr_type;

state_start: STATE_START_DELIMITER parameter_description_line* assign_expression+;

state_goal: STATE_GOAL_DELIMITER parameter_description_line* expression;

/*-----------------------------------------------------------------------------------------------*/

operation_expr: operation_description operator_precondition operator_effect;

operation_description: OPERATOR_DESCRIPTION_DELIMITER name_defining_expression? operator_cost? parameter_description_line*;
operator_cost: KEYWORD_COST number;

operator_precondition: OPERATOR_PRECONDITION_DELIMITER expression?;

operator_effect: OPERATOR_EFFECT_DELIMITER var_defining_expression* assign_expression+;

/*-----------------------------------------------------------------------------------------------*/

attr_struct: KEYWORD_SET | (KEYWORD_MATRIX dimension);
attr_type: KEYWORD_WORD | KEYWORD_NUMBER;

comparator: SYMBOL_EQUAL | SYMBOL_NOT_EQUAL | SYMBOL_GREATER | SYMBOL_LESSER | SYMBOL_GREATER_OR_EQUAL | SYMBOL_LESSER_OR_EQUAL;
binary_operator: SYMBOL_ADDITION | SYMBOL_SUBSTRACT | SYMBOL_MULTIPLICATION | SYMBOL_DIVISION;
unary_operator: KEYWORD_MAXIMUM | KEYWORD_MINIMUM | KEYWORD_AVERAGE | KEYWORD_CARDINALITY;
boolean_operator: KEYWORD_AND | KEYWORD_OR;

var_defining_expression: KEYWORD_VAR attr_type name SYMBOL_ASSIGN expression;
name_defining_expression: KEYWORD_NAME name;

expression
  :  SYMBOL_LPAREN expression SYMBOL_RPAREN #paren_expr
  | left=expression comparator right=expression #compare_expr
  | left=expression boolean_operator right=expression #bool_expr
  | left=expression binary_operator right=expression #binary_expr
  | unary_operator SYMBOL_LPAREN expression SYMBOL_RPAREN #one_param_unary_expr
  | unary_operator SYMBOL_LPAREN left=expression (SYMBOL_COMMA right=expression)? SYMBOL_RPAREN #two_param_unary_expr
  | reference #reference_expr
  | word #word_expr
  | number #number_expr
  | name #name_expr
  ;

assign_expression: ((attr_reference SYMBOL_ASSIGN init_statement) | (matrix_reference SYMBOL_ASSIGN expression));
init_statement: SYMBOL_LBRACE (expression (SYMBOL_COMMA  expression)*) SYMBOL_RBRACE;

parameter_description_line: KEYWORD_PARAM name ((KEYWORD_FROM INT KEYWORD_TO INT (KEYWORD_BY INT)?));

/*-----------------------------------------------------------------------------------------------*/

attr_name: KEYWORD_ATTRIBUTE INT;
attr_reference: SYMBOL_REFERENCE (INT | name);
matrix_reference: attr_reference dimension;
reference: (attr_reference | matrix_reference);
dimension_part: SYMBOL_LBRACK (INT | name) SYMOBL_RBRACK;
dimension: dimension_part dimension_part;

KEYWORD_PARAM: 'param';
KEYWORD_FROM: 'from';
KEYWORD_TO: 'to';
KEYWORD_BY: 'by';
KEYWORD_TIMES: 'times';
KEYWORD_ATTRIBUTE: 'Attr';
KEYWORD_VAR: 'var';
KEYWORD_COST: 'cost';
KEYWORD_NAME: 'name';

KEYWORD_IS: 'is';
KEYWORD_OF: 'of';
KEYWORD_SET: 'set';
KEYWORD_MATRIX: 'matrix';
KEYWORD_WORD: 'word';
KEYWORD_NUMBER: 'number';

SYMBOL_EQUAL: '==';
SYMBOL_NOT_EQUAL: '!=';
SYMBOL_LESSER: '<';
SYMBOL_GREATER: '>';
SYMBOL_LESSER_OR_EQUAL: '<=';
SYMBOL_GREATER_OR_EQUAL: '>=';

SYMBOL_ADDITION: '+';
SYMBOL_SUBSTRACT: '-';
SYMBOL_MULTIPLICATION: '*';
SYMBOL_DIVISION: '/';

SYMBOL_ASSIGN: '=';
SYMBOL_REFERENCE: '$';
SYMBOL_COMMA : ',' ;
SYMBOL_QUOTE: '\"';

SYMBOL_LPAREN: '(' ;
SYMBOL_RPAREN: ')' ;
SYMBOL_LBRACE: '{' ;
SYMBOL_RBRACE: '}' ;
SYMBOL_LBRACK: '[' ;
SYMOBL_RBRACK: ']' ;

KEYWORD_MAXIMUM: 'max';
KEYWORD_MINIMUM: 'min';
KEYWORD_AVERAGE: 'avg';

KEYWORD_CARDINALITY: 'card';

KEYWORD_AND: 'and';
KEYWORD_OR: 'or';
KEYWORD_NOT: 'not';

STATE_DELIMITER: 'STATE:';
STATE_ATTRIBUTES_DELIMITER: 'STATE_ATTRIBUTES:';
STATE_START_DELIMITER: 'STATE_START:';
STATE_GOAL_DELIMITER: 'STATE_GOAL:';

OPERATOR_DELIMITER: 'OPERATORS:' ;
OPERATOR_DESCRIPTION_DELIMITER: 'OPERATOR_DESCRIPTION:';
OPERATOR_PRECONDITION_DELIMITER: 'OPERATOR_PRECONDITION:';
OPERATOR_EFFECT_DELIMITER: 'OPERATOR_EFFECT:';

INT: (('0' | '1'..'9') '0'..'9'*);
FLOAT: (('0' | '1'..'9') '0'..'9'*)'.'('0'..'9'*);
SIGN: ('+' | '-');

number: SIGN? (INT | FLOAT);
word: (SYMBOL_QUOTE .*? SYMBOL_QUOTE);
name: CHAR+;
CHAR: ('a'..'z' | 'A'..'Z');
WS: [ \t\r\n]+ -> skip ;
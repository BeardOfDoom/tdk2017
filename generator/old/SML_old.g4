grammar SML;

expr: state_expr OPERATOR_DELIMITER operation_expr+ EOF;

state_expr: state_description state_start state_goal;

state_description: STATE_ATTRIBUTES_DELIMITER state_description_line+;

state_description_line: attr_name KEYWORD_IS attr_struct KEYWORD_OF attr_type;

state_start: STATE_START_DELIMITER parameter_description_line* state_start_line+;

state_start_line: ((attr_reference SYMBOL_ASSIGN init_statement) | (matrix_reference SYMBOL_ASSIGN expression));

state_goal: STATE_GOAL_DELIMITER parameter_description_line* boolean_expression?;

/*-----------------------------------------------------------------------------------------------*/

operation_expr: operation_description operator_precondition operator_effect;

operation_description: OPERATOR_DESCRIPTION_DELIMITER operator_cost? parameter_description_line*;
operator_cost: KEYWORD_COST number;

operator_precondition: OPERATOR_PRECONDITION_DELIMITER boolean_expression?;

operator_effect: OPERATOR_EFFECT_DELIMITER var_defining_expression* assigning_expression+;

/*-----------------------------------------------------------------------------------------------*/

attr_struct: (KEYWORD_SET | (KEYWORD_MATRIX dimension));
attr_type: (KEYWORD_WORD | KEYWORD_NUMBER);
comparator: (SYMBOL_EQUAL | SYMBOL_NOT_EQUAL | SYMBOL_GREATER | SYMBOL_LESSER | SYMBOL_GREATER_OR_EQUAL | SYMBOL_LESSER_OR_EQUAL);

binary_operator: (SYMBOL_ADDITION | SYMBOL_SUBSTRACT | SYMBOL_MULTIPLICATION | SYMBOL_DIVISION);
unary_operator: (KEYWORD_MAXIMUM | KEYWORD_MINIMUM | KEYWORD_AVERAGE | KEYWORD_CARDINALITY);
boolean_operator: (KEYWORD_AND | KEYWORD_OR | KEYWORD_NOT);

expression_unit: (unary_expression | reference | name | number | word);
unary_expression: unary_operator SYMBOL_LPAREN (expression (SYMBOL_COMMA expression)?) SYMBOL_RPAREN;
binary_expression: (expression_unit (binary_operator (expression_unit | binary_expression))+) | (SYMBOL_LPAREN binary_expression SYMBOL_RPAREN);

assigning_expression: reference SYMBOL_ASSIGN expression;
comparing_expression: expression comparator expression;
boolean_expression: KEYWORD_NOT? (comparing_expression (boolean_operator (comparing_expression | boolean_expression))*) | (KEYWORD_NOT? SYMBOL_LPAREN boolean_expression SYMBOL_RPAREN);
var_defining_expression: KEYWORD_VAR attr_type name SYMBOL_ASSIGN expression;

expression: (expression_unit | unary_expression | binary_expression);

init_statement: SYMBOL_LBRACE (expression (SYMBOL_COMMA expression)*) SYMBOL_RBRACE;

parameter_description_line: KEYWORD_PARAM name ((KEYWORD_FROM INT KEYWORD_TO INT (KEYWORD_BY INT)?) | (KEYWORD_NUMBER INT INT KEYWORD_TIMES));

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
SYMBOL_QUOTE: '\"';
SYMBOL_COMMA : ',' ;

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

CHAR: ('a'..'z' | 'A'..'Z');

number: SIGN? (INT | FLOAT);
numbers: (number (SYMBOL_COMMA number)*);
words: (word (SYMBOL_COMMA word)*);

word: SYMBOL_QUOTE (INT | CHAR)+ SYMBOL_QUOTE;

name: CHAR+;

WS: [ \t\r\n]+ -> skip ;
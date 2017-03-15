// Generated from D:/Laci/egyetem/szakdolgozat/tdk2017/generator/src/main/java/antlr\SML.g4 by ANTLR 4.6
package antlr.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SMLParser}.
 */
public interface SMLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SMLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SMLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SMLParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#state_expr}.
	 * @param ctx the parse tree
	 */
	void enterState_expr(SMLParser.State_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#state_expr}.
	 * @param ctx the parse tree
	 */
	void exitState_expr(SMLParser.State_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#state_description}.
	 * @param ctx the parse tree
	 */
	void enterState_description(SMLParser.State_descriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#state_description}.
	 * @param ctx the parse tree
	 */
	void exitState_description(SMLParser.State_descriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#state_description_line}.
	 * @param ctx the parse tree
	 */
	void enterState_description_line(SMLParser.State_description_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#state_description_line}.
	 * @param ctx the parse tree
	 */
	void exitState_description_line(SMLParser.State_description_lineContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#state_start}.
	 * @param ctx the parse tree
	 */
	void enterState_start(SMLParser.State_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#state_start}.
	 * @param ctx the parse tree
	 */
	void exitState_start(SMLParser.State_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#state_start_line}.
	 * @param ctx the parse tree
	 */
	void enterState_start_line(SMLParser.State_start_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#state_start_line}.
	 * @param ctx the parse tree
	 */
	void exitState_start_line(SMLParser.State_start_lineContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#state_goal}.
	 * @param ctx the parse tree
	 */
	void enterState_goal(SMLParser.State_goalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#state_goal}.
	 * @param ctx the parse tree
	 */
	void exitState_goal(SMLParser.State_goalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#operation_expr}.
	 * @param ctx the parse tree
	 */
	void enterOperation_expr(SMLParser.Operation_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#operation_expr}.
	 * @param ctx the parse tree
	 */
	void exitOperation_expr(SMLParser.Operation_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#operation_description}.
	 * @param ctx the parse tree
	 */
	void enterOperation_description(SMLParser.Operation_descriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#operation_description}.
	 * @param ctx the parse tree
	 */
	void exitOperation_description(SMLParser.Operation_descriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#operator_cost}.
	 * @param ctx the parse tree
	 */
	void enterOperator_cost(SMLParser.Operator_costContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#operator_cost}.
	 * @param ctx the parse tree
	 */
	void exitOperator_cost(SMLParser.Operator_costContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#operator_precondition}.
	 * @param ctx the parse tree
	 */
	void enterOperator_precondition(SMLParser.Operator_preconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#operator_precondition}.
	 * @param ctx the parse tree
	 */
	void exitOperator_precondition(SMLParser.Operator_preconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#operator_effect}.
	 * @param ctx the parse tree
	 */
	void enterOperator_effect(SMLParser.Operator_effectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#operator_effect}.
	 * @param ctx the parse tree
	 */
	void exitOperator_effect(SMLParser.Operator_effectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#attr_struct}.
	 * @param ctx the parse tree
	 */
	void enterAttr_struct(SMLParser.Attr_structContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#attr_struct}.
	 * @param ctx the parse tree
	 */
	void exitAttr_struct(SMLParser.Attr_structContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#attr_type}.
	 * @param ctx the parse tree
	 */
	void enterAttr_type(SMLParser.Attr_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#attr_type}.
	 * @param ctx the parse tree
	 */
	void exitAttr_type(SMLParser.Attr_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(SMLParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(SMLParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#binary_operator}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator(SMLParser.Binary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#binary_operator}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator(SMLParser.Binary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(SMLParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(SMLParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#boolean_operator}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_operator(SMLParser.Boolean_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#boolean_operator}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_operator(SMLParser.Boolean_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#expression_unit}.
	 * @param ctx the parse tree
	 */
	void enterExpression_unit(SMLParser.Expression_unitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#expression_unit}.
	 * @param ctx the parse tree
	 */
	void exitExpression_unit(SMLParser.Expression_unitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expression(SMLParser.Unary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expression(SMLParser.Unary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#binary_expression}.
	 * @param ctx the parse tree
	 */
	void enterBinary_expression(SMLParser.Binary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#binary_expression}.
	 * @param ctx the parse tree
	 */
	void exitBinary_expression(SMLParser.Binary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#assigning_expression}.
	 * @param ctx the parse tree
	 */
	void enterAssigning_expression(SMLParser.Assigning_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#assigning_expression}.
	 * @param ctx the parse tree
	 */
	void exitAssigning_expression(SMLParser.Assigning_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#comparing_expression}.
	 * @param ctx the parse tree
	 */
	void enterComparing_expression(SMLParser.Comparing_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#comparing_expression}.
	 * @param ctx the parse tree
	 */
	void exitComparing_expression(SMLParser.Comparing_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#boolean_expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_expression(SMLParser.Boolean_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#boolean_expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_expression(SMLParser.Boolean_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#var_defining_expression}.
	 * @param ctx the parse tree
	 */
	void enterVar_defining_expression(SMLParser.Var_defining_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#var_defining_expression}.
	 * @param ctx the parse tree
	 */
	void exitVar_defining_expression(SMLParser.Var_defining_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SMLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SMLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#init_statement}.
	 * @param ctx the parse tree
	 */
	void enterInit_statement(SMLParser.Init_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#init_statement}.
	 * @param ctx the parse tree
	 */
	void exitInit_statement(SMLParser.Init_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#parameter_description_line}.
	 * @param ctx the parse tree
	 */
	void enterParameter_description_line(SMLParser.Parameter_description_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#parameter_description_line}.
	 * @param ctx the parse tree
	 */
	void exitParameter_description_line(SMLParser.Parameter_description_lineContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#attr_name}.
	 * @param ctx the parse tree
	 */
	void enterAttr_name(SMLParser.Attr_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#attr_name}.
	 * @param ctx the parse tree
	 */
	void exitAttr_name(SMLParser.Attr_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#attr_reference}.
	 * @param ctx the parse tree
	 */
	void enterAttr_reference(SMLParser.Attr_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#attr_reference}.
	 * @param ctx the parse tree
	 */
	void exitAttr_reference(SMLParser.Attr_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#matrix_reference}.
	 * @param ctx the parse tree
	 */
	void enterMatrix_reference(SMLParser.Matrix_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#matrix_reference}.
	 * @param ctx the parse tree
	 */
	void exitMatrix_reference(SMLParser.Matrix_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(SMLParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(SMLParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#dimension_part}.
	 * @param ctx the parse tree
	 */
	void enterDimension_part(SMLParser.Dimension_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#dimension_part}.
	 * @param ctx the parse tree
	 */
	void exitDimension_part(SMLParser.Dimension_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#dimension}.
	 * @param ctx the parse tree
	 */
	void enterDimension(SMLParser.DimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#dimension}.
	 * @param ctx the parse tree
	 */
	void exitDimension(SMLParser.DimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(SMLParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(SMLParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#numbers}.
	 * @param ctx the parse tree
	 */
	void enterNumbers(SMLParser.NumbersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#numbers}.
	 * @param ctx the parse tree
	 */
	void exitNumbers(SMLParser.NumbersContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#words}.
	 * @param ctx the parse tree
	 */
	void enterWords(SMLParser.WordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#words}.
	 * @param ctx the parse tree
	 */
	void exitWords(SMLParser.WordsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#word}.
	 * @param ctx the parse tree
	 */
	void enterWord(SMLParser.WordContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#word}.
	 * @param ctx the parse tree
	 */
	void exitWord(SMLParser.WordContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(SMLParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(SMLParser.NameContext ctx);
}
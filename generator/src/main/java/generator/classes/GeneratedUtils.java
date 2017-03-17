package generator.classes;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class GeneratedUtils {

  private GeneratedUtils() {
  }

  public static Double min(List<List<Double>> matrix) {
    return matrix.stream().map(Collections::min).min(Double::compareTo).get();
  }

  public static Double min(List<List<Double>> matrixA, List<List<Double>> matrixB) {
    return Math.min(min(matrixA), min(matrixB));
  }

  public static Double min(List<List<Double>> matrix, Set<Double> set) {
    return Math.min(min(matrix), min(set));
  }

  public static Double min(List<List<Double>> matrix, Double number) {
    return Math.min(min(matrix), number);
  }

  public static Double min(Set<Double> set) {
    return Collections.min(set);
  }

  public static Double min(Set<Double> set1, Set<Double> set2) {
    return Math.min(min(set1), min(set2));
  }

  public static Double min(Set<Double> set, Double number) {
    return Math.min(min(set), number);
  }

  public static Double min(Double numberA, Double numberB) {
    return Math.min(numberA, numberB);
  }

  public static <T extends Object> Double card(Set<T> set) {
    return Double.valueOf(set.size());
  }

  public static <T extends Object> Double card(List<List<T>> list) {
    return list.stream().mapToDouble(List::size).sum();
  }
}
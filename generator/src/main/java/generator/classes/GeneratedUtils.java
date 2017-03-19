package generator.classes;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
  - min
  - max
  - card
  - sum
  - avg
  - union
  - intersect
 */


public class GeneratedUtils {

  private GeneratedUtils() {
  }

  public static Double min(List<List<Double>> matrix) {
    return matrix.stream().map(Collections::min).min(Double::compareTo).get();
  }

  public static Double min(Set<Double> set) {
    return Collections.min(set);
  }

  public static Double min(Double numberA, Double numberB) {
    return Math.min(numberA, numberB);
  }

  public static Double max(List<List<Double>> matrix) {
    return matrix.stream().map(Collections::max).max(Double::compareTo).get();
  }

  public static Double max(Set<Double> set) {
    return Collections.max(set);
  }

  public static Double max(Double numberA, Double numberB) {
    return Math.max(numberA, numberB);
  }

  public static Double sum(List<List<Double>> matrix) {
    return matrix.stream().mapToDouble(list -> list.stream().mapToDouble(Double::doubleValue).sum())
        .sum();
  }

  public static Double sum(Set<Double> set) {
    return set.stream().mapToDouble(Double::doubleValue).sum();
  }

  public static Double avg(List<List<Double>> matrix) {
    Double sum = sum(matrix);
    Double card = card(matrix);

    return sum / card;
  }

  public static Double avg(Set<Double> set) {
    return set.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
  }

  public static <T extends Object> Set<T> union(Set<T> setA, Set<T> setB) {
    Set<T> result = new HashSet<>();
    result.addAll(setA);
    result.addAll(setB);

    return result;
  }

  //TODO: Is it worth to select the iterating set??
  public static Set<Double> intersect(Set<Double> setA, Set<Double> setB) {
    Set<Double> result = new HashSet<>();

    for (Double element : setA) {
      if (setB.contains(element)) {
        result.add(element);
      }
    }

    return result;
  }

  public static <T extends Object> Double card(Set<T> set) {
    return Double.valueOf(set.size());
  }

  public static <T extends Object> Double card(List<List<T>> list) {
    return list.stream().mapToDouble(List::size).sum();
  }
}
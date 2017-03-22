package something;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public static <T extends Object> Set<T> intersect(Set<T> setA, Set<T> setB) {
    Set<T> result = new HashSet<>();

    result.addAll(setA);
    result.retainAll(setB);

    return result;
  }

  public static <T extends Object> Set<T> difference(Set<T> setA, Set<T> setB) {
    Set<T> result = new HashSet<>();
    result.addAll(setA);
    result.remove(setB);

    return result;
  }

  public static <T extends Object> void add(Set<T> set, T element) {
    set.add(element);
  }

  public static <T extends Object> void remove(Set<T> set, T element) {
    set.remove(element);
  }


  public static <T extends Object> Double card(Set<T> set) {
    return Double.valueOf(set.size());
  }

  public static <T extends Object> Double card(List<List<T>> list) {
    return list.stream().mapToDouble(List::size).sum();
  }
}
package generator.classes;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class GeneratedUtils {

  public static Double min(Set<Double> set) {
    return Collections.min(set);
  }

  public static Double min(Set<Double> set, Double number) {
    return Math.min(min(set), number);
  }

  public static Double min(Double number, Set<Double> set) {
    return Math.min(min(set), number);
  }

  public static Double min(Set<Double> set1, Set<Double> set2) {
    return Math.min(min(set1), min(set2));
  }

  public static Double min(List<List<Double>> matrix) {
    return matrix.stream().map(Collections::min).min(Double::compareTo).get();
  }

  public static <T extends Number> boolean compare(T numberA, T numberB, CompareType type) {
    return true;
  }

}
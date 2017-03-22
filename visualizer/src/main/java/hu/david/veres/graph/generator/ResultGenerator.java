package hu.david.veres.graph.generator;

import hu.david.veres.graph.model.Result;

import java.io.File;
import java.io.IOException;

public interface ResultGenerator {

    Result generate(File file) throws IOException;

}

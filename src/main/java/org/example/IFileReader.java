package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IFileReader {
  String readFromFile(String path) throws IOException;
}

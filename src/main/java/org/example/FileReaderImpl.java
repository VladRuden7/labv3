package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class FileReaderImpl implements IFileReader{
  public String readFromFile(String path) throws IOException {
    FileReader reader = new FileReader(path);
    String s = "";
    int c;
    while ((c = reader.read()) != -1) {
      s += (char) c;
    }
    return s;
  }

}

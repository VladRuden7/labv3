package org.example;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    IFileReader fileReader = new FileReaderImpl();
    ITextProcessor textProcessor = new TextProcessorImpl();
    Mocks main = new Mocks(fileReader, textProcessor);
    main.run(main.getPathFromUser());
  }
}

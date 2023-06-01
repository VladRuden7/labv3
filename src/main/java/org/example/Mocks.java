package org.example;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.IOException;
import java.util.List;

public class Mocks implements IMocks {
  private IFileReader fileReader;
  private ITextProcessor textProcessor;

  public Mocks() {

  }

  public Mocks(IFileReader fileReader, ITextProcessor textProcessor) {
    this.fileReader = fileReader;
    this.textProcessor = textProcessor;
  }

  public void run(String Path) throws IOException {
    String path = Path;
    if (path == null || path.isEmpty()) {
      System.out.println("Bye!");
      return;
    }

    String text = fileReader.readFromFile(path);
    String[] s = textProcessor.splitWords(text);
    List<String> result = textProcessor.result(s);

    if (result.isEmpty()) {
      System.out.println("No acceptable words found!");
    } else {
      System.out.print("Acceptable words: ");
      for (String word : result) {
        System.out.print(word + " ");
      }
      System.out.println();
    }
  }

  public String getPathFromUser() {
    Frame frame = new Frame();
    frame.setSize(500, 500);
    FileDialog fileDialog = new FileDialog(frame, "Choose file!");
    fileDialog.setVisible(true);
    return fileDialog.getDirectory() + fileDialog.getFile();
  }
}
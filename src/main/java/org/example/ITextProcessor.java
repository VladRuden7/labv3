package org.example;

import java.util.ArrayList;

public interface ITextProcessor {
  String[] splitWords(String text);
  ArrayList<String> result(String[] s);
}

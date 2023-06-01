package org.example;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessorImpl implements ITextProcessor{
  @Override
  public String[] splitWords(String text) {
    if(text == null || text.length() == 0 ) return null;
    Pattern p = Pattern.compile("\\W");
    Matcher k = p.matcher(text);
    String s = k.replaceAll(" ");
    s = s.trim().replaceAll("\\s{2,}", " ");
    String l[] = s.split(" ");
    if(l.length == 1 && l[0].equals("")) return null;
    for (int i = 0; i<l.length;i++) {
      if(l[i].length() > 30) l[i] = l[i].substring(0,29);
    }
    return l;
  }

  @Override
  public ArrayList<String> result(String[] s) {
    ArrayList<String> result = new ArrayList<>();
    String sPattern = "^(?:([A-Za-z])(?!.*\\1))*$";
    for (String s1: s) {
      if(Pattern.matches(sPattern,s1))
      {
        if(result.contains(s1))
          continue;
        result.add(s1);
      }
    }
    return result;
  }

}

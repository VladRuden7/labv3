import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import org.example.IFileReader;
import org.example.ITextProcessor;
import org.example.Mocks;
import org.example.TextProcessorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Headers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


public class Tests {

  @Mock
  IFileReader fileReader;
  @Mock
  ITextProcessor textProcessor;
  @Spy
  TextProcessorImpl textProcessor2;

  @InjectMocks
  Mocks mocks;
  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testMocksRun() throws IOException {
    ArrayList<String> res = new ArrayList<>();
    res.add("Testing");
    res.add("output");
    String[] s = new String[]{"Hello"};
    LinkedHashSet<String> key = new LinkedHashSet<>();
    key.add("hui");
    when(textProcessor.splitWords("Hello")).thenReturn(s);
    doReturn(res).when(textProcessor).result(s);
    when(fileReader.readFromFile(anyString())).thenReturn("Hello");
    mocks.run("test.txt");
    verify(fileReader,times(1)).readFromFile(anyString());
    verify(textProcessor,times(1)).result(s);
  }
  @Test
  public void testMockexception() throws IOException {
    doThrow(IOException.class).when(fileReader).readFromFile(anyString());
    assertThrows(IOException.class,()-> mocks.run("Nofile"));
  }
  @Test
  public void testwithSpy() throws IOException {
    when(textProcessor2.splitWords(anyString())).thenReturn(new String[]{"Tesing","Spy", "aaa"});
    when(fileReader.readFromFile(anyString())).thenReturn("Any");
    mocks.run("path");

  }

}



import java.io.IOException;
import java.io.File;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.util.Progress;
import org.apache.uima.util.FileUtils;
import org.apache.uima.jcas.JCas;

/**
 * CollectionReader import the file that need to be processed and get the
 * content in the file. The content will be processed in the following steps.
 * 
 * @author yanhe
 * 
 */
public class Reader extends CollectionReader_ImplBase {
  private File mFile;
  private String mEncoding;
  public static final String PARAM_FILE= "InputFile";
  private int i=0;
  
  /**
   * getNext get the content in the file and convert the content into string
   * and store it inside a string.
   */
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    JCas jcas;
    String fileInput = (String) getConfigParameterValue(PARAM_FILE);
    //System.out.println(fileInput);
    mFile = new File(fileInput);
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new CollectionException(e);
    }
    File file =(File) mFile;
    String text=FileUtils.file2String(file, mEncoding);
    jcas.setDocumentText(text);
    System.out.println("Reading Input file");
    // Try to print the content in the file
  }
  
  /**
   * hasNext check if the function has reached the last line of the content,
   * if it is not, then continue reading the next line, 
   * if it is, then stop reading the content
   */
  public boolean hasNext() throws IOException, CollectionException {
    // Check if the content is final, stop reading 
    if (i==0) {
      i++;
      return true;
      }
    else
    {
      i++;
      return false;}
  }

  /**
   * getProgress returns null
   */
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return null;
  }

  public void close() throws IOException {
    // TODO Auto-generated method stub
  }

}




import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceProcessException;
import org.xml.sax.SAXException;

/**
 * CasConsumer build a new file and save the gene name and ID that have been
 * extracted by geneFinder.
 * @author yanhe
 *
 */
public class consumer extends CasConsumer_ImplBase {
  public static final String PARAM_FILE= "OutputFile";
  int docNum;
  File out = null;
  BufferedWriter bw = null;

  /**
   * initialize prepare to write the gene information into a file.
   */
  @Override
  public void initialize() {

    docNum = 0;
    String OutputFile = (String) getConfigParameterValue(PARAM_FILE);
    try {
    //out = new File("src/main/resources/hw2-yanhe.out");
    //System.out.println(fileOutput);
    File out= new File(OutputFile);
    bw = new BufferedWriter(new FileWriter(out));
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
  
  /**
   * processCas has the function that get the gene ID and name from the sentence
   * and try to write it into a local file whose name is hw1-yanhe.out
   */
  @Override
  public void processCas(CAS aCAS) throws ResourceProcessException {
    // TODO Auto-generated method stub
    JCas jcas = null;
   
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      //throw new CollectionException(e);
    }
    
    // get the file's name of the input file from CAS
    FSIterator<Annotation> iter = jcas.getAnnotationIndex(genetag.type).iterator();
    System.out.println("Consuming CAS");
    String geneID = "";
    String geneContent = "";
    int start = -1;
    int end = -1;
    
    while (iter.hasNext()){
      genetag annotation = (genetag) iter.next();
      //System.out.println("Content output now");
      System.out.println(annotation.getContent());
      geneID = annotation.getID();
      geneContent = annotation.getContent();
      start = annotation.getBegin();
      System.out.println(start);
      end = annotation.getEnd();
    
    try {
      writeInFile(geneID, geneContent, start, end);
    } catch (IOException e) {
      throw new ResourceProcessException(e);
    } catch (SAXException e) {
      throw new ResourceProcessException(e);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    }
       
  }
  
  /**
   * writeInFile store the gene ID and name into the local file.
   * @param geneIdentifier is the ID of the gene
   * @param geneName is the name of the gene
   * @param start is the first index of the gene's name in the sentence 
   * @param end is the last index of the gene's name in the sentence 
   */
  public void writeInFile(String geneIdentifier, String geneName, int start, int end)
          throws Exception {
        bw.write(geneIdentifier + "|" + start + " " + end + "|" + geneName);
        bw.newLine();
        bw.flush();
      }
  
  /**
   * destroy ends the process of write the gene information into the file.
   */
  @Override
  public void destroy() {

    try {
      if (bw != null) {
        bw.close();
        bw = null;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

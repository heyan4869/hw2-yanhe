import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

/**
 * Annotator process the content of the file and split the content by each line
 * and use the substring function to cut each line into two parts, the first part
 * is the ID of the sentence and the second part is the content of the sentence.
 * 
 * @author yanhe
 * 
 */
public class annotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    String textContent = jcas.getDocumentText();
    String text[] = textContent.split("\\n");
    System.out.println("Annotating content");
    
    for(int i = 0; i< text.length;i++){
      int firstSpace = text[i].indexOf(' ');
      String sentenceID = text[i].substring(0, firstSpace);
      String sentenceContent = text[i].substring(firstSpace);
      // System.out.println(text[i]);
      sentence annotation = new sentence(jcas);
      annotation.setID(sentenceID);
      annotation.setContent(sentenceContent);
      annotation.addToIndexes();
    }
  }
}

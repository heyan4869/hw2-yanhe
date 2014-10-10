import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.cas.FSIterator;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;

import edu.cmu.deiis.types.Genetag;
import edu.cmu.deiis.types.Sentence;

/**
 * GeneLingpipe implement one of the most important function which is find the
 * gene name in the content of the file via using the LingPipe name recognizer.
 * 
 * @author yanhe
 * 
 */
public class GeneLingpipe extends JCasAnnotator_ImplBase {
  private static final int MAX_N_BEST_CHUNKS = 5;

  /**
   * process(Jcas aCas) use the Lingpipe to identify the gene's information in the content
   * of the file
  */
  @Override
  public void process(JCas aCas) throws AnalysisEngineProcessException {
    JCas jcas = aCas;
    String pathway = "/ne-en-bio-genetag.HmmChunker";
    //File modelFile = new File("src/main/resources/ne-en-bio-genetag.HmmChunker");
    System.out.println("Reading chunker from file = " + pathway);
    FSIterator it = jcas.getAnnotationIndex(Sentence.type).iterator();

    ConfidenceChunker chunker = null;
	try {
	  //chunker = (ConfidenceChunker) AbstractExternalizable.readObject(modelFile);
	  chunker = (ConfidenceChunker) AbstractExternalizable.readResourceObject(pathway);
	} catch (IOException e) {
	  e.printStackTrace();
	} catch (ClassNotFoundException e) {
	  e.printStackTrace();
	}
   
	DecimalFormat ft = new DecimalFormat("#0.0000");
    while(it.hasNext()){
      Sentence ann = (Sentence)it.get();  
      String sen = ann.getContent();
      String id = ann.getID();
      char[] senten = sen.toCharArray();
      Iterator<Chunk> itera = 
        		chunker.nBestChunks(senten, 0, senten.length, MAX_N_BEST_CHUNKS);
      String gene;
 
      for(int n = 0; itera.hasNext(); n++){
        Chunk c = (Chunk) itera.next();
         double conf = Math.pow(2.0, c.score());
            
         if(conf > 0.06){
            
           gene = (sen.substring(c.start(), c.end()));
       	   int begin = c.start() ;
           int end = c.end();
           begin = begin - countBlank(sen.substring(0,begin)) ;
           end = begin + gene.length() - countBlank(gene) - 1;

           Genetag gt = new Genetag(aCas);
           gt.setID(id);
           gt.setContent(gene);
           gt.setConfidence(conf);
           gt.setCasProcessorId("lingp");
           gt.setBegin(begin);
           gt.setEnd(end);
           gt.addToIndexes();
           
        }
        //System.out.println(count++);
        it.next();
       }   
    }      
  }
    
 
  private int countBlank(String s){
    int count = 0;
    for(int i = 0; i < s.length(); i++) {
        if(Character.isWhitespace(s.charAt(i))) {
            count++;
        }
     }
    return count;
  }
}
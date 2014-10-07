import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.cas.FSIterator;
import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.util.AbstractExternalizable;

/**
 * geneFinder implement one of the most important function which is find the
 * gene name in the content of the file via using the LingPipe name recognizer.
 * @author yanhe
 *
 */
public class genefinder extends JCasAnnotator_ImplBase {

  /**
   * process use the LingPipe to identify the gene's information in the content
   * of the file
   */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    JCas jcas = aJCas;
    int count = 0;
    
    File modelFile = new File("src/main/resources/ne-en-bio-genetag.HmmChunker");
    System.out.println("Reading chunker from file = " + modelFile);
    FSIterator it = jcas.getAnnotationIndex(sentence.type).iterator();
    Chunker chunker = null;
   
    try {
      chunker = (Chunker) AbstractExternalizable.readObject(modelFile);
      //System.out.println("chunker success");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    while(it.hasNext()){
    	System.out.println("Iterator success");
        sentence ann = (sentence)it.get();  
        String sen = ann.getContent();
        String id = ann.getID();
        Chunking chunking = chunker.chunk(ann.getContent());     
        //System.out.println("Chunking=" + chunking);
       
        String gene;
        Set<Chunk> set = chunking.chunkSet();
        System.out.println(set);
        Iterator itor = set.iterator();
        while(itor.hasNext()){
            Chunk c = (Chunk) itor.next();
            gene = (sen.substring(c.start(), c.end()));
            //System.out.println(c.start());
            //System.out.println(c.end());
            //System.out.println("Finding gene");
            int begin = c.start() ;
            int end = c.end();
            begin = begin - countBlank(sen.substring(0,begin)) ;
            end = begin + gene.length() - countBlank(gene) - 1;
            genetag gt = new genetag(aJCas);
            gt.setID(id);
            gt.setContent(gene);
            gt.setBegin(begin);
            gt.setEnd(end);
            gt.addToIndexes();
           
        }
        //System.out.println(count++);
        it.next();
        
    }
          
  }
    
  /**
   * countBlank counts the space in each sentence and use it to calculate
   * the accurate start and end index of gene's name in the sentence.
   * @param phrase is the sentence whose type is string that processed by
   * geneFinder.
   * @return
   */
  private int countBlank(String phrase){
    int countBlank = 0;
    for(int i=0; i<phrase.length(); i++) {
        if(Character.isWhitespace(phrase.charAt(i))) {
            countBlank++;
        }
     }
    return countBlank;
  }
  
}

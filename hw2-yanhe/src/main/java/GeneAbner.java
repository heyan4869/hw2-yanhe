import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;

import edu.cmu.deiis.types.Genetag;
import edu.cmu.deiis.types.Sentence;
import abner.Tagger;

/**
 * GeneAbner contribute to the  function which is find the gene name
 * in the content of the file via using the Abner name recognizer.
 * @author yanhe
 *
 */
public class GeneAbner extends JCasAnnotator_ImplBase {

	/**
	 * process(Jcas aCas) use the Abner to identify the gene's information in the content
	 * of the file
	*/
	@Override
	public void process(JCas aCas) throws AnalysisEngineProcessException {
	  JCas jcas = aCas;
	  FSIterator it = jcas.getAnnotationIndex(Sentence.type).iterator();
      Tagger t = new Tagger(1);
	  int begin;
	  int end;
		
	  while(it.hasNext()){
	    Sentence ann = (Sentence)it.get();  
	    String sen = ann.getContent();
	    String id = ann.getID();
	    t.tokenize(sen);
    	//System.out.println("Abner analysing");
    	String[][] ents = t.getEntities(sen);
	    String gene;
	        
	    for (int i = 0; i < ents[0].length; i++) {
	      gene = ents[0][i]; 
	      begin = sen.indexOf(gene);
	      end = begin + gene.length();
	      //System.out.println(begin);
	      //System.out.println(end);
	      if(begin != -1){
	    	begin = begin - countBlank(sen.substring(0,begin)) ;
	    	end = begin + gene.length() - countBlank(gene) - 1;
	    	//System.out.println(begin);
	    	//System.out.println(end);   
	    	Genetag gt = new Genetag(aCas);
	    	gt.setID(id);
	    	gt.setContent(gene);	    	    	
	    	gt.setBegin(begin);
	    	gt.setEnd(end);
	    	gt.setConfidence(0);
	    	gt.setCasProcessorId("abner");
	    	gt.addToIndexes();
	      }
	    }
	    it.next();	    	
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

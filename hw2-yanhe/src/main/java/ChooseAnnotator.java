import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;

import edu.cmu.deiis.types.Gene;
import edu.cmu.deiis.types.Genetag;

/**
 * ChooseAnnotator complete the function that merge the gene recognition result that 
 * generated by GeneLingpipe and GeneAbner with unique selection method.
 * 
 * @author yanhe
 * 
 */
public class ChooseAnnotator extends JCasAnnotator_ImplBase {

  /**
   * process(JCas aCas) process the result of GeneLingpipe and GeneAbner, choose the 
   * selected gene name based on its confidence and make the result more accurate. 
   */
  @Override
  public void process(JCas aCas) throws AnalysisEngineProcessException {
	JCas jcas = aCas;
	FSIterator it = jcas.getAnnotationIndex(Genetag.type).iterator();
	Genetag gene;
	String ID;
	String Content;
	int begin, end = -1;
	double conf = 0.0;
	HashSet<String> abners = new HashSet<String>();
	HashMap<String, Double> lingps = new HashMap<String, Double>();
		
	while(it.hasNext()){
      gene = (Genetag)it.get();
      String processor = gene.getCasProcessorId();		
      if(processor.equals("abner")){
		String key = gene.getID() + " " + String.format("%03d", gene.getBegin()) + " " 
			+ String.format("%03d",gene.getEnd()) + " " + gene.getContent() ;
		abners.add(key);
	  }
			
	  if(processor.equals("lingp")){
		String key = gene.getID() + " " + String.format("%03d", gene.getBegin()) + " " 
			+ String.format("%03d",gene.getEnd()) + " " + gene.getContent() ;
		lingps.put(key, gene.getConfidence());	
	  }
	  it.next();
	}
		
	Iterator lingpIt = lingps.entrySet().iterator();
	while(lingpIt.hasNext()){
      Map.Entry entry = (Map.Entry) lingpIt.next();
	  Double val = (Double) entry.getValue();
	  String Key = (String) entry.getKey(); 
	  if(Key.charAt(14) == ' '){
		if(val >= 0.6){
		  Gene g = new Gene(jcas);
	      g.setID(Key.substring(0, 14));
          g.setBegin(Integer.parseInt(Key.substring(15, 18)));
          g.setEnd(Integer.parseInt(Key.substring(19, 22)));
          g.setContent(Key.substring(23));
          g.addToIndexes();
	    }
		if(val < 0.6){
		  if(abners.contains(Key)){
			Gene g = new Gene(jcas);
		    g.setID(Key.substring(0, 14));
			g.setBegin(Integer.parseInt(Key.substring(15, 18)));
			g.setEnd(Integer.parseInt(Key.substring(19, 22)));
			g.setContent(Key.substring(23));
			g.addToIndexes();
		  }
		}
	  }
    }
	Iterator abnerit = abners.iterator();
	while(abnerit.hasNext()){
		String key = (String)abnerit.next();
		if(key.charAt(14) == ' '){
			Gene g = new Gene(jcas);
			g.setID(key.substring(0, 14));
			g.setBegin(Integer.parseInt(key.substring(15, 18)));
			g.setEnd(Integer.parseInt(key.substring(19, 22)));
			g.setContent(key.substring(23));
			g.addToIndexes();	
		}
	}
  }
}

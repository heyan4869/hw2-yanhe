import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;


public class chooseannotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aCas) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		JCas jcas = aCas;
		FSIterator it = jcas.getAnnotationIndex(genetag.type).iterator();
		genetag gene;
		String ID;
		String Content;
		int begin, end = -1;
		double conf = 0.0;
		HashSet<String> abners = new HashSet<String>();
		HashMap<String, Double> lingps = new HashMap<String, Double>();
		
		while(it.hasNext()){
			gene = (genetag)it.get();
			String processor = gene.getCasProcessorId();
			
			if(processor.equals("abner")){
				String key = gene.getID() + " " + String.format("%03d", gene.getBegin()) + " " 
							+ String.format("%03d",gene.getEnd()) + " " + gene.getContent() ;
				abners.add(key);
				//System.out.println(key);
			}
			
			if(processor.equals("lingp")){
				String key = gene.getID() + " " + String.format("%03d", gene.getBegin()) + " " 
						+ String.format("%03d",gene.getEnd()) + " " + gene.getContent() ;
				lingps.put(key, gene.getConfidence());	
				//System.out.println(key);
			}
			it.next();
		}
		
		//clear the previous jcas
		//jcas.reset();
		
		Iterator lingpIt = lingps.entrySet().iterator();
		while(lingpIt.hasNext()){
			Map.Entry entry = (Map.Entry) lingpIt.next();
			Double val = (Double) entry.getValue();
			String Key = (String) entry.getKey(); 
			if(Key.charAt(14) == ' '){
				if(val >= 0.5){
					gene g = new gene(jcas);
					//System.out.println(Key);
					g.setID(Key.substring(0, 14));
            		g.setBegin(Integer.parseInt(Key.substring(15, 18)));
            		g.setEnd(Integer.parseInt(Key.substring(19, 22)));
            		g.setContent(Key.substring(23));
            		g.addToIndexes();
				}
				if(val < 0.5){
					if(abners.contains(Key)){
						gene g = new gene(jcas);
						g.setID(Key.substring(0, 14));
						//System.out.println(Key.substring(0, 14));
						g.setBegin(Integer.parseInt(Key.substring(15, 18)));
						//System.out.println(Key.substring(15, 17));
						g.setEnd(Integer.parseInt(Key.substring(19, 22)));
						g.setContent(Key.substring(23));
						g.addToIndexes();
					}
				}
			}
			//it.next();
		}


	}

}

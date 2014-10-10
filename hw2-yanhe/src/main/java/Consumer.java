import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceProcessException;
import org.xml.sax.SAXException;

import edu.cmu.deiis.types.Gene;

/**
 * Consumer build a new file and save the gene name and ID that have been
 * extracted by ChooseAnnotator.
 * 
 * @author yanhe
 *
 */
public class Consumer extends CasConsumer_ImplBase {
  private BufferedWriter buf;
  public static final String PARAM_OUTPUTDIR = "OutputFile";
  /**
   * process() write the gene ID,name,index into the disk file, which are got from geneAnalysis. 
   */
  @Override
  public void processCas(CAS aCAS) throws ResourceProcessException {
	File out = new File(((String) getConfigParameterValue(PARAM_OUTPUTDIR)).trim());
	try{			
      buf = new BufferedWriter(new FileWriter(out));
	}catch(Exception e){
      e.printStackTrace();
	}
	System.out.println("Consumer initialized");
	JCas jcas;
	try {
	  jcas = aCAS.getJCas();
    } catch (CASException e) {
	throw new ResourceProcessException(e);
	}
	    
	FSIterator it = jcas.getAnnotationIndex(Gene.type).iterator();
	String geneId = "";
	String geneContent = "";
	// String processor = "";
	int start,end = -1;
	//double conf = 0.0; 
	    
	while(it.hasNext()){
	  Gene annotation = (Gene) it.next();
	  geneId = annotation.getID();
	  geneContent = annotation.getContent();			
	  start = annotation.getBegin();
	  end = annotation.getEnd();

	  try {
		writeIntoFile(geneId, geneContent, start, end);
		//writeIntoFile(geneId, geneContent, start, end, conf, processor);
		//System.out.println("writing~!");
      } catch (IOException e) {
		throw new ResourceProcessException(e);
	  } catch (SAXException e) {
		throw new ResourceProcessException(e);
	  } catch (Exception e) {
		e.printStackTrace();
	  }		
    }
  }
			
	
  public void writeIntoFile(String geneId, String geneContent, int start, int end)
	throws Exception {
	buf.write(geneId + "|" + start + " " + end + "|" + geneContent);
	buf.newLine();
	buf.flush();
	}

}

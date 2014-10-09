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


public class consumer extends CasConsumer_ImplBase {
	private BufferedWriter buf;
	public static final String PARAM_OUTPUTDIR = "OutputFile";
	/**
	 * process() write the gene ID,name,index into the disk file, which are got from geneAnalysis. 
	 */
	@Override
	public void processCas(CAS aCAS) throws ResourceProcessException {
		// TODO Auto-generated method stub
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
	    
	    FSIterator it = jcas.getAnnotationIndex(gene.type).iterator();
	    String geneId = "";
	    String geneContent = "";
	    // String processor = "";
	    int start,end = -1;
	    //double conf = 0.0; 
	    
	    while(it.hasNext()){
	    	gene annotation = (gene) it.next();
			geneId = annotation.getID();
			geneContent = annotation.getContent();			
			start = annotation.getBegin();
			end = annotation.getEnd();
			//conf = annotation.getConfidence();
			//processor = annotation.getCasProcessorId();

			try {
				writeIntoFile(geneId, geneContent, start, end);
				//writeIntoFile(geneId, geneContent, start, end, conf, processor);
				//System.out.println("writing~!");
			} catch (IOException e) {
				throw new ResourceProcessException(e);
			} catch (SAXException e) {
				throw new ResourceProcessException(e);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    }
	    System.out.println("System performance");
	    BufferedReader my = null,sample=null;
	    int myall = 0;
	    int all = 0;
	    int hit = 0;
	    try {
			sample = new BufferedReader(new FileReader("src/main/resources/sample.out"));
			my = new BufferedReader(new FileReader("src/main/resources/outputfile.out"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    HashSet<String> myout = new HashSet<String>();
	    try {
	    	String temp = null;
			while((temp = my.readLine()) != null){
				myout.add(temp);
				myall++;
				//System.out.println(my.readLine());
				
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String key = null;
			while((key = sample.readLine()) != null){
				all++;
				if(myout.contains(key))
					hit++;
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(hit);
		//System.out.println(myall);
		//System.out.println(all);
		double precision = (double)hit/(double)myall;
		double recall = (double)hit/(double)all;
		double fmeasure = 2*precision*recall/(precision+recall);
		System.out.println("Precision is " + precision);
		System.out.println("Recall is " + recall);
		System.out.println("F-measure is " + fmeasure);
	}
	
	public void writeIntoFile(String geneIdentifier, String geneName, int start, int end)
			throws Exception {
		buf.write(geneIdentifier + "|" + start + " " + end + "|" + geneName);
		buf.newLine();
		buf.flush();
	}


}

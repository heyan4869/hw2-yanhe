
/* First created by JCasGen Wed Sep 11 13:44:28 EDT 2013 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** 
 * Updated by JCasGen Thu Oct 09 17:10:57 EDT 2014
 *  */
public class Annotation_Type extends org.apache.uima.jcas.tcas.Annotation_Type {
  /**  */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /**  */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Annotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Annotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Annotation(addr, Annotation_Type.this);
  			   Annotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Annotation(addr, Annotation_Type.this);
  	  }
    };
  /**  */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Annotation.typeIndexID;
  /**  
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.deiis.types.Annotation");
 
  /**  */
  final Feature casFeat_casProcessorId;
  /**  */
  final int     casFeatCode_casProcessorId;
  /**  */ 
  public String getCasProcessorId(int addr) {
        if (featOkTst && casFeat_casProcessorId == null)
      jcas.throwFeatMissing("casProcessorId", "edu.cmu.deiis.types.Annotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_casProcessorId);
  }
  /**  */    
  public void setCasProcessorId(int addr, String v) {
        if (featOkTst && casFeat_casProcessorId == null)
      jcas.throwFeatMissing("casProcessorId", "edu.cmu.deiis.types.Annotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_casProcessorId, v);}
    
  
 
  /**  */
  final Feature casFeat_confidence;
  /**  */
  final int     casFeatCode_confidence;
  /**  */ 
  public double getConfidence(int addr) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "edu.cmu.deiis.types.Annotation");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_confidence);
  }
  /**  */    
  public void setConfidence(int addr, double v) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "edu.cmu.deiis.types.Annotation");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_confidence, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	*  */
  public Annotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_casProcessorId = jcas.getRequiredFeatureDE(casType, "casProcessorId", "uima.cas.String", featOkTst);
    casFeatCode_casProcessorId  = (null == casFeat_casProcessorId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_casProcessorId).getCode();

 
    casFeat_confidence = jcas.getRequiredFeatureDE(casType, "confidence", "uima.cas.Double", featOkTst);
    casFeatCode_confidence  = (null == casFeat_confidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_confidence).getCode();

  }
}



    
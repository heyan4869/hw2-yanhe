
/* First created by JCasGen Thu Oct 09 16:12:31 EDT 2014 */

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import edu.cmu.deiis.types.Annotation_Type;

public class gene_Type extends Annotation_Type {

  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (gene_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = gene_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new gene(addr, gene_Type.this);
  			   gene_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new gene(addr, gene_Type.this);
  	  }
    };
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = gene.typeIndexID;

  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("gene");
 
  final Feature casFeat_ID;
  final int     casFeatCode_ID;

  public String getID(int addr) {
        if (featOkTst && casFeat_ID == null)
      jcas.throwFeatMissing("ID", "gene");
    return ll_cas.ll_getStringValue(addr, casFeatCode_ID);
  }
  
  public void setID(int addr, String v) {
        if (featOkTst && casFeat_ID == null)
      jcas.throwFeatMissing("ID", "gene");
    ll_cas.ll_setStringValue(addr, casFeatCode_ID, v);}
    
  
 
  final Feature casFeat_Content;
  final int     casFeatCode_Content;

  public String getContent(int addr) {
        if (featOkTst && casFeat_Content == null)
      jcas.throwFeatMissing("Content", "gene");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Content);
  }
 
  public void setContent(int addr, String v) {
        if (featOkTst && casFeat_Content == null)
      jcas.throwFeatMissing("Content", "gene");
    ll_cas.ll_setStringValue(addr, casFeatCode_Content, v);}
    
  

  public gene_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_ID = jcas.getRequiredFeatureDE(casType, "ID", "uima.cas.String", featOkTst);
    casFeatCode_ID  = (null == casFeat_ID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ID).getCode();

 
    casFeat_Content = jcas.getRequiredFeatureDE(casType, "Content", "uima.cas.String", featOkTst);
    casFeatCode_Content  = (null == casFeat_Content) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Content).getCode();

  }
}



    
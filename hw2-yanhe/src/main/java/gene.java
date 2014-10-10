

/* First created by JCasGen Thu Oct 09 16:12:31 EDT 2014 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.deiis.types.Annotation;



public class gene extends Annotation {
  
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(gene.class);
  
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
  
  protected gene() {/* intentionally empty block */}
    
  public gene(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  

  public gene(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  public gene(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   


  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: ID

  public String getID() {
    if (gene_Type.featOkTst && ((gene_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "gene");
    return jcasType.ll_cas.ll_getStringValue(addr, ((gene_Type)jcasType).casFeatCode_ID);}
    
  public void setID(String v) {
    if (gene_Type.featOkTst && ((gene_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "gene");
    jcasType.ll_cas.ll_setStringValue(addr, ((gene_Type)jcasType).casFeatCode_ID, v);}    
   
    
  //*--------------*
  //* Feature: Content

  public String getContent() {
    if (gene_Type.featOkTst && ((gene_Type)jcasType).casFeat_Content == null)
      jcasType.jcas.throwFeatMissing("Content", "gene");
    return jcasType.ll_cas.ll_getStringValue(addr, ((gene_Type)jcasType).casFeatCode_Content);}
    
  public void setContent(String v) {
    if (gene_Type.featOkTst && ((gene_Type)jcasType).casFeat_Content == null)
      jcasType.jcas.throwFeatMissing("Content", "gene");
    jcasType.ll_cas.ll_setStringValue(addr, ((gene_Type)jcasType).casFeatCode_Content, v);}    
  }

    
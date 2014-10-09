

/* First created by JCasGen Mon Oct 06 21:28:13 EDT 2014 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.deiis.types.Annotation;




/** 
 * Updated by JCasGen Thu Oct 09 17:10:57 EDT 2014
 * XML source: /Users/Yan/git/hw2-yanhe/hw2-yanhe/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class genetag extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(genetag.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected genetag() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public genetag(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public genetag(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public genetag(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: ID

  /** getter for ID - gets 
   * @generated
   * @return value of the feature 
   */
  public String getID() {
    if (genetag_Type.featOkTst && ((genetag_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "genetag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((genetag_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setID(String v) {
    if (genetag_Type.featOkTst && ((genetag_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "genetag");
    jcasType.ll_cas.ll_setStringValue(addr, ((genetag_Type)jcasType).casFeatCode_ID, v);}    
   
    
  //*--------------*
  //* Feature: Content

  /** getter for Content - gets 
   * @generated
   * @return value of the feature 
   */
  public String getContent() {
    if (genetag_Type.featOkTst && ((genetag_Type)jcasType).casFeat_Content == null)
      jcasType.jcas.throwFeatMissing("Content", "genetag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((genetag_Type)jcasType).casFeatCode_Content);}
    
  /** setter for Content - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setContent(String v) {
    if (genetag_Type.featOkTst && ((genetag_Type)jcasType).casFeat_Content == null)
      jcasType.jcas.throwFeatMissing("Content", "genetag");
    jcasType.ll_cas.ll_setStringValue(addr, ((genetag_Type)jcasType).casFeatCode_Content, v);}    
  }

    


/* First created by JCasGen Fri Oct 10 16:16:47 EDT 2014 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** 
 * Updated by JCasGen Fri Oct 10 16:16:47 EDT 2014
 * XML source: /Users/Yan/git/hw2-yanhe/hw2-yanhe/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class Genetag extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Genetag.class);
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
  protected Genetag() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Genetag(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Genetag(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Genetag(JCas jcas, int begin, int end) {
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
    if (Genetag_Type.featOkTst && ((Genetag_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "edu.cmu.deiis.types.Genetag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Genetag_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setID(String v) {
    if (Genetag_Type.featOkTst && ((Genetag_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "edu.cmu.deiis.types.Genetag");
    jcasType.ll_cas.ll_setStringValue(addr, ((Genetag_Type)jcasType).casFeatCode_ID, v);}    
   
    
  //*--------------*
  //* Feature: Content

  /** getter for Content - gets 
   * @generated
   * @return value of the feature 
   */
  public String getContent() {
    if (Genetag_Type.featOkTst && ((Genetag_Type)jcasType).casFeat_Content == null)
      jcasType.jcas.throwFeatMissing("Content", "edu.cmu.deiis.types.Genetag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Genetag_Type)jcasType).casFeatCode_Content);}
    
  /** setter for Content - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setContent(String v) {
    if (Genetag_Type.featOkTst && ((Genetag_Type)jcasType).casFeat_Content == null)
      jcasType.jcas.throwFeatMissing("Content", "edu.cmu.deiis.types.Genetag");
    jcasType.ll_cas.ll_setStringValue(addr, ((Genetag_Type)jcasType).casFeatCode_Content, v);}    
  }

    
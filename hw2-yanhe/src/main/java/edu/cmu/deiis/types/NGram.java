

/* First created by JCasGen Wed Sep 11 13:44:28 EDT 2013 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;


/** 
 * Updated by JCasGen Thu Oct 09 17:10:57 EDT 2014
 * XML source: /Users/Yan/git/hw2-yanhe/hw2-yanhe/src/main/resources/descriptors/deiis_types.xml
 *  */
public class NGram extends Annotation {
  /** 
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NGram.class);
  /** 
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /**   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   *  */
  protected NGram() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   *  */
  public NGram(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /**  */
  public NGram(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /**  */  
  public NGram(JCas jcas, int begin, int end) {
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
   *  modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: elements

  /** getter for elements - gets 
   * 
   * @return value of the feature 
   */
  public FSArray getElements() {
    if (NGram_Type.featOkTst && ((NGram_Type)jcasType).casFeat_elements == null)
      jcasType.jcas.throwFeatMissing("elements", "edu.cmu.deiis.types.NGram");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((NGram_Type)jcasType).casFeatCode_elements)));}
    
  /** setter for elements - sets  
   * 
   * @param v value to set into the feature 
   */
  public void setElements(FSArray v) {
    if (NGram_Type.featOkTst && ((NGram_Type)jcasType).casFeat_elements == null)
      jcasType.jcas.throwFeatMissing("elements", "edu.cmu.deiis.types.NGram");
    jcasType.ll_cas.ll_setRefValue(addr, ((NGram_Type)jcasType).casFeatCode_elements, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for elements - gets an indexed value - 
   *  */
  public Annotation getElements(int i) {
    if (NGram_Type.featOkTst && ((NGram_Type)jcasType).casFeat_elements == null)
      jcasType.jcas.throwFeatMissing("elements", "edu.cmu.deiis.types.NGram");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NGram_Type)jcasType).casFeatCode_elements), i);
    return (Annotation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NGram_Type)jcasType).casFeatCode_elements), i)));}

  /** indexed setter for elements - sets an indexed value - 
   *  */
  public void setElements(int i, Annotation v) { 
    if (NGram_Type.featOkTst && ((NGram_Type)jcasType).casFeat_elements == null)
      jcasType.jcas.throwFeatMissing("elements", "edu.cmu.deiis.types.NGram");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NGram_Type)jcasType).casFeatCode_elements), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NGram_Type)jcasType).casFeatCode_elements), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: elementType

  /** getter for elementType - gets 
   * 
   * @return value of the feature 
   */
  public String getElementType() {
    if (NGram_Type.featOkTst && ((NGram_Type)jcasType).casFeat_elementType == null)
      jcasType.jcas.throwFeatMissing("elementType", "edu.cmu.deiis.types.NGram");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NGram_Type)jcasType).casFeatCode_elementType);}
    
  /** setter for elementType - sets  
   * 
   * @param v value to set into the feature 
   */
  public void setElementType(String v) {
    if (NGram_Type.featOkTst && ((NGram_Type)jcasType).casFeat_elementType == null)
      jcasType.jcas.throwFeatMissing("elementType", "edu.cmu.deiis.types.NGram");
    jcasType.ll_cas.ll_setStringValue(addr, ((NGram_Type)jcasType).casFeatCode_elementType, v);}    
  }

    
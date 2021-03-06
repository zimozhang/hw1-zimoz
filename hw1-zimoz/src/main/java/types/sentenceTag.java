

/* First created by JCasGen Fri Oct 10 18:26:13 EDT 2014 */
package types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Fri Oct 10 18:26:13 EDT 2014
 * XML source: /home/zimo/workspace/hw1-zimoz/src/main/resources/typeSystemDescriptor.xml
 * @generated */
public class sentenceTag extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(sentenceTag.class);
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
  protected sentenceTag() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public sentenceTag(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public sentenceTag(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public sentenceTag(JCas jcas, int begin, int end) {
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
    if (sentenceTag_Type.featOkTst && ((sentenceTag_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "types.sentenceTag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((sentenceTag_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setID(String v) {
    if (sentenceTag_Type.featOkTst && ((sentenceTag_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "types.sentenceTag");
    jcasType.ll_cas.ll_setStringValue(addr, ((sentenceTag_Type)jcasType).casFeatCode_ID, v);}    
   
    
  //*--------------*
  //* Feature: Text

  /** getter for Text - gets 
   * @generated
   * @return value of the feature 
   */
  public String getText() {
    if (sentenceTag_Type.featOkTst && ((sentenceTag_Type)jcasType).casFeat_Text == null)
      jcasType.jcas.throwFeatMissing("Text", "types.sentenceTag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((sentenceTag_Type)jcasType).casFeatCode_Text);}
    
  /** setter for Text - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setText(String v) {
    if (sentenceTag_Type.featOkTst && ((sentenceTag_Type)jcasType).casFeat_Text == null)
      jcasType.jcas.throwFeatMissing("Text", "types.sentenceTag");
    jcasType.ll_cas.ll_setStringValue(addr, ((sentenceTag_Type)jcasType).casFeatCode_Text, v);}    
  }

    
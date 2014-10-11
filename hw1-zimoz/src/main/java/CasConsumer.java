import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.collection.base_cpm.CasObjectProcessor;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;

import types.geneTag;



public class CasConsumer extends CasConsumer_ImplBase implements CasObjectProcessor {
  
  File outFile;
  File compareFile;
  FileWriter fileWriter;
  FileWriter compareWriter;
  
 
  public CasConsumer() {
  }
  
  // extract configuration parameter settings
//  public void initialize() throws ResourceInitializationException{
  public void initialize() throws ResourceInitializationException {
//    super.initialize(aUimaContext);
    String oPath = (String) getUimaContext().getConfigParameterValue("outputdocument");
//    String samplefile = (String) getUimaContext().getConfigParameterValue("SAMPLE_FILE");
//    String samplefile = (String) getUimaContext().getConfigParameterValue("SAMPLE_FILE");
 // Output file should be specified in the descriptor
    if (oPath == null) {
      throw new ResourceInitializationException(
              ResourceInitializationException.CONFIG_SETTING_ABSENT, new Object[] { "outputdocument" });
    }
    
    try {
//      outFile = new File("outputdocument");
      outFile = new File("/home/zimo/Desktop/hw1-zimoz.out");
      fileWriter = new FileWriter(outFile);
//      fileWriter = new FileWriter(compareFile);
    } catch (IOException e2) {
      // TODO Auto-generated catch block
      e2.printStackTrace();
    }
    
    
    
  }
    
  public synchronized void processCas(CAS aCAS) throws ResourceProcessException {
   
/**
 * Get the sentence ID and the original sentences from collectionReader
 * Get the start and end point of each gene
 */
     JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    
    
 /**
  * Iterates and prints annotations.
  * Counts the correct and total number of recognitions in the meanwhile.
  */
    Iterator annotationIter = jcas.getAnnotationIndex(geneTag.type).iterator();
    
    while (annotationIter.hasNext()) {
      
      geneTag g= (geneTag) annotationIter.next();
      
      // get the text that is enclosed within the annotation in the CAS
      String aText = g.getText();
      try {
        System.out.println("#############");
        fileWriter.write(((geneTag) g).getID() + '|');
        fileWriter.write(g.getStart() + " " + g.getEnd() + "|");
        fileWriter.write(g.getText() + '\n');
        fileWriter.flush();
      } catch (IOException e) {
        throw new ResourceProcessException(e);
      }
    }
//      }
   
//      try {
//          br.close();
//      } catch (IOException ignoreMe){
//     // TODO Auto-generated catch block
//        ignoreMe.printStackTrace();
      }  

      
  @Override
  public void destroy() {
 /**
  * Calculates the precision and recall for evaluating the performance of the Annotators  
  */
      
      if (fileWriter != null) {
      try {
        fileWriter.close();
      } catch (IOException e) {
        // ignore IOException on destroy
      }
    
      }
  } 

}
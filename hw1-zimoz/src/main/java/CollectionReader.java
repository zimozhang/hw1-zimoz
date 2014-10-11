import java.io.*;
import java.util.*;

import org.apache.uima.cas.CAS;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.jcas.JCas;
import org.apache.uima.cas.CASException;



public class CollectionReader extends CollectionReader_ImplBase {
  
  public static final String PARAM_INPUTDIR = "inputdocument";
  
  ArrayList<String> sentences;
  
  private int mCurrentIndex;
  
  @Override
 
  public void initialize() throws ResourceInitializationException {
    
    sentences = new ArrayList<String>();
    
    BufferedReader br;

    String line;
    try {
      br = new BufferedReader(new FileReader(((String) getConfigParameterValue(PARAM_INPUTDIR))));
      line = br.readLine();
      
      while (line != null) {
        sentences.add(line);
        
        line = br.readLine();
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    

    
    mCurrentIndex = 0;
    
  }
  
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    // TODO Auto-generated method stub
  
  JCas jcas;
  try {
    jcas = aCAS.getJCas();
  } catch (CASException e) {
    throw new CollectionException(e);
  }
  
  
  String file = sentences.get(mCurrentIndex++);
  jcas.setDocumentText(file);
  
 
  
 
  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    // TODO Auto-generated method stub
    return mCurrentIndex < sentences.size();
  }

  @Override
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub

  }

}
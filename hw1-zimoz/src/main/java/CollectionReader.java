import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;

import types.sentenceTag;

public class CollectionReader extends CollectionReader_ImplBase {
  
  public static final String PARAM_INPUTDIR = "inputdocument";
  
  private int mCurrentIndex;
  
  @Override
 
  public void initialize() throws ResourceInitializationException {
    
    ArrayList<String> sentences = new ArrayList<String>();
    
    File directory = new File(((String) getConfigParameterValue(PARAM_INPUTDIR)).trim());
    
    try{
      sentences = readFile(directory);
    }catch (Exception e){
      e.printStackTrace();
    }
    
    mCurrentIndex = 0;
    
  }
  
  private ArrayList<String> records = new ArrayList<String>();
  
  private ArrayList<String> readFile(File directory) throws Exception
  {
    String line = null;
    
    
    BufferedReader reader = new BufferedReader(new FileReader(directory));
    
     while ((line = reader.readLine()) != null) 
     {
         records.add(line);
     }
     
     reader. close();

     return records;
  }
  
  
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    // TODO Auto-generated method stub
  
  JCas jcas;
  try {
    jcas = aCAS.getJCas();
  } catch (CASException e) {
    throw new CollectionException(e);
  }
  
  
  String file = records.get(mCurrentIndex++);
  System.out.println(file);
  sentenceTag st = new sentenceTag(jcas);
  st.setID(file.substring(0, 14));
  st.setText(file.substring(15, file.length()));
  st.addToIndexes();
  
 
  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    // TODO Auto-generated method stub
    return mCurrentIndex < records.size();
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
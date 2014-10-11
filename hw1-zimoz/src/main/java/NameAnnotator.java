import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.tutorial.RoomNumber;
import org.apache.uima.util.Level;

import types.geneTag;



public class NameAnnotator extends JCasAnnotator_ImplBase {
  
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);
}
  
public void process(JCas aJCas) {
    // get annotation indexes
    String st = aJCas.getDocumentText();
    
    
    PosTagNamedEntityRecognizer ner;
    try {
      ner = new PosTagNamedEntityRecognizer();
      Map<Integer, Integer> tokens = ner.getGeneSpans(st.substring(15, st.length()));
      //Iterator<Entry<Integer, Integer>> it = tokens.entrySet().iterator();
      
      for (Map.Entry<Integer, Integer> pairs:tokens.entrySet() ) { //For every annotation we get in GeneAnnotater
        //Map.Entry pairs = (Map.Entry)it.next();
        
        geneTag a = new geneTag(aJCas);
        int k = (int) pairs.getKey();
        int v = (int) pairs.getValue();
        System.out.println(k);
        a.setBegin(k);
        a.setEnd(v);
        
        a.setID(st.substring(0, 14));
        a.setText(st.substring(k+15, v+15));
        
        
        a.addToIndexes();
      }
      
      
    } catch (ResourceInitializationException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    };
}
    
   

private int countWhiteSpace(String phrase){
  int countBlank = 0;
  for(int i=0; i<phrase.length(); i++) {
    if(Character.isWhitespace(phrase.charAt(i))) {
        countBlank++;
    }
}
  return countBlank;
}

}
package leetcode2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wy on 2017/6/14.
 */
public class p30 {

      @Test
      public void test(){

             String s="lingmindraboofooowingdingbarrwingmonkeypoundcake";
             String l[]=new String[]{"fooo","barr","wing","ding","wing"};
             findSubstring1(s,l);
      }

       // concatenation 连接
       public List<Integer> findSubstring(String S, String[] L) {
           List<Integer> res = new ArrayList<Integer>();
           if (S == null || L == null || L.length == 0) return res;
           int len = L[0].length(); // length of each word

           Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
           for (String w : L)
               map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
           int length=S.length() - len * L.length;
           for (int i = 0; i <=length; i++) {
               Map<String, Integer> copy = new HashMap<String, Integer>(map);
               for (int j = 0; j < L.length; j++) { // checkc if match
                   int start=i + j*len;
                   int end=i + j*len+len;
                   String str = S.substring(start,end); // next word
                   if (copy.containsKey(str)) { // is in remaining words
                       int count = copy.get(str);
                       if (count == 1) copy.remove(str);
                       else copy.put(str, count - 1);
                       if (copy.isEmpty()) { // matches
                           res.add(i);
                           break;
                       }
                   } else break; // not in L
               }
           }
           return res;
       }


       // simple method
       public List<Integer> findSubstring1(String s, String[] words) {
              List<Integer> result=new ArrayList<Integer>();
           if (s== null || words== null || words.length == 0) return result;
              HashMap<String,Integer> map=new HashMap<String, Integer>();
              for(String word:words){
                  map.put(word,map.containsKey(word)?map.get(word)+1:1);
              }
              int wordLength=words[0].length();
              int length=s.length()-wordLength*words.length;
              for(int i=0;i<=length;i++){
                  HashMap<String,Integer> copy=new HashMap<String, Integer>(map);
                  for(int j=0;j<words.length;j++){
                      int start=i+j*wordLength;
                      int end=i+j*wordLength+wordLength;
                      // inclusive start
                      // exclusive end
                      String sub=s.substring(start,end);
                      if(copy.containsKey(sub)){
                          int count=copy.get(sub);
                          if(count==1)
                             copy.remove(sub);
                          else
                              copy.put(sub,count-1);
                          if(copy.size()==0){
                              result.add(i);
                              break;
                          }
                      }else {
                          break;
                      }
                  }

              }
           return result;
       }
}

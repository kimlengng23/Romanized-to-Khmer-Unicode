import java.util.*;
public class WordEdge implements Comparable<WordEdge>{
	public String key;
	//public Set<String> value = new HashSet<String>();
	public String value;
	//public WordEdge(String k, Set<String> v){
	public WordEdge(String k, String v){
		key = k;
		value = v;
		
	}
	public int compareTo(WordEdge w){
		if(this.key.compareTo(w.key)==0){
			return this.value.compareTo(w.value);
		}
		else{
			return this.key.compareTo(w.key);
		}
	}
	
}

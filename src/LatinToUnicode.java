import java.util.*;
import java.io.*;
public class LatinToUnicode {
	public static void main(String[] args) throws IOException{
		Map<String,String> latinMap = new HashMap<String,String>();
		File wordFile = new File("SortedCommonWords.txt");
		loadWords(latinMap,wordFile);
		while(true){
			System.out.print("User Input: ");
			Scanner input = new Scanner(System.in);
			String latinString = input.nextLine();
			if(latinString.equals("quit"))
				break;
			System.out.println(toString(latinString,latinMap));
		}
		
	}
	//convert a string of latin words to a string of unicode words
	//latin words must be separated by a white space
	public static String toString(String latin, Map<String,String> latinMap) throws IOException{
		String[] wordArray = latin.split("\\s");
		String toReturn = "";
		FileWriter fw = null;
		BufferedWriter bw = null;
		File unknownWord = new File("UnknownWords.txt");
		if(!unknownWord.exists()){
			unknownWord.createNewFile();
		}
		fw = new FileWriter(unknownWord.getAbsoluteFile(),true);
		bw = new BufferedWriter(fw);
		
		for(int i=0;i<wordArray.length;i++){
			if(latinMap.containsKey(wordArray[i])){
				toReturn+=latinMap.get(wordArray[i]);
			}
			else{
				bw.write(wordArray[i]+"\n");
				toReturn+=(" "+wordArray[i]+" ");
			}
		}
		
		bw.close();
		fw.close();
		
		return toReturn;
	}
	//load words into the map
	public static void loadWords(Map<String,String> latinMap, File wordFile) throws IOException{
		if(!wordFile.exists()){
			System.out.println("File not found!");
			System.exit(1);
		}
		Scanner input = new Scanner(wordFile);
		while(input.hasNext()){
			String latin = input.next();
			String unicode = input.next();
			//System.out.println(latin+" "+unicode);
			latinMap.put(latin,unicode);
		}
		input.close();
		
	}
	
}

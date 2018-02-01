import java.io.*;
import java.util.*;
public class WorkWithFiles {
	public static void main(String[] args) throws IOException{
		//sortWord("CommonWords.txt","SortedCommonWords.txt");
		combineDuplicate("SortedCommonWords.txt","SortedNoDuplicate.txt");
		//System.out.print("ទី"=="ទី");
		
	}
	private static void combineDuplicate(String sPath, String dPath) throws IOException{
		File sf = new File(sPath);
		File df = new File(dPath);
		Scanner input = new Scanner(sf);
		if(!df.exists()){
			df.createNewFile();
		}
		FileWriter fw = new FileWriter(df.getAbsolutePath(),true);
		BufferedWriter bw = new BufferedWriter(fw);
		String preL="";
		String preU="";
		String latin;
		String unicode;
		if(input.hasNext()){
			latin = input.next();
			unicode = input.next();
			bw.write(latin+" "+unicode);
			preL = latin;
			preU = unicode;
		}
		while(input.hasNext()){
			latin = input.next();
			unicode = input.next();
			if(latin.equals(preL)){
				if(!unicode.equals(preU)){
					bw.write(" "+unicode);
					preU = unicode;
				}
			}
			else{
				bw.write("\n"+latin+" "+unicode);
				preL = latin;
				preU = unicode;
			}
		}
		bw.close();
		fw.close();
		input.close();
	}
	private static void sortWord(String sPath,String dPath) throws IOException{
		PriorityQueue<WordEdge> pq = new PriorityQueue<WordEdge>();
		File sf = new File(sPath);
		
		if(!sf.exists()){
			System.exit(1);
		}
		Scanner sc = new Scanner(sf);
		while(sc.hasNext()){
			String s1 = sc.next();
			String s2 = sc.next();
			if(sc.hasNext()){
				sc.nextLine();
			}
			System.out.println(s1+" "+s2);
			WordEdge tmp = new WordEdge(s1,s2);
			//sc.nextLine();
			pq.offer(tmp);
		}
		sc.close();
		System.out.println("===========");
		File df = new File(dPath);
		PrintWriter pw = new PrintWriter(df);
		while(!pq.isEmpty()){
			WordEdge tmp = pq.remove();
			System.out.println(tmp.key+" "+tmp.value);
			pw.println(tmp.key+" "+tmp.value);
		}
		pw.close();
	}
	private static void moveCommon(String sPath,String dPath) throws IOException{
		File unknown = new File(sPath);
		Scanner input = new Scanner(unknown);
		File common = new File(dPath);
		FileWriter fw = new FileWriter(common.getAbsoluteFile(),true);
		BufferedWriter bw = new BufferedWriter(fw);
		while(input.hasNext()){
			String latin = input.next();
			String unicode = input.next();
			bw.write(latin+" "+unicode+"\n");
		}
		bw.close();
		fw.close();
		input.close();
	}
}

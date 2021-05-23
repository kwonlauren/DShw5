import java.io.*;

public class Matching
{
	private static HashTable<Key, Pair> hashTable;
	public static void main(String args[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			try
			{
				String input = br.readLine();
				if (input.compareTo("QUIT") == 0)
					break;
				command(input);
			}
			catch (IOException e)
			{
				System.out.println("입력이 잘못되었습니다. 오류 : " + e.toString());
			}
			catch (IllegalStateException e){
				System.out.println("잘못된 명령어입니다. 오류 : " + e.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void command(String input) throws Exception
	{
		char c = input.charAt(0);
		input = input.substring(2);
		switch(c){
			case '<':
				readData(input); break;
			case '@': printData(Integer.parseInt(input)); break;
			case '?': searchPattern(input); break;
			default: throw new IllegalStateException("Unexpected value" + c);
		}
	}

	private static void readData(String filename){
		hashTable = new HashTable<>();
		File file = new File(filename);
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			while((line = br.readLine()) != null){
				pushData(line);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
			}

	private static void pushData(String line){
		//separates line into length 6 and pushes into hash table
		try{
			int len = line.length();
			if(len < 6) throw new IllegalArgumentException();
			for(int i=0; i<len-5; i++){
				Key k = new Key(line.substring(i,i+6));
				Pair p = new Pair(i+1, i+6);
				hashTable.insert(k, p);
			}
		} catch(IllegalArgumentException e) {
			System.err.println("line shorter than 6.");
		}
	}

	private static void printData(int index){

	}

	private static void searchPattern(String pattern){
		//TODO: implement function
	}
}

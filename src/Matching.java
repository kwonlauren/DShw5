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

	private static void command(String input)
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
			int linenum = 1;
			while((line = br.readLine()) != null){
				pushData(line, linenum);
				linenum++;
			}
		} catch (IOException e){
			e.printStackTrace();
		}
			}

	private static void pushData(String line, int linenum){
		//separates line into length 6 and pushes into hash table
		try{
			int len = line.length();
			if(len < 6) throw new IllegalArgumentException();
			for(int i=0; i<len-5; i++){
				Key k = new Key(line.substring(i,i+6));
				Pair p = new Pair(linenum, i+1);
				hashTable.insert(k, p);
			}
		} catch(IllegalArgumentException e) {
			System.err.println("line shorter than 6.");
		}
	}

	private static void printData(int index){
		hashTable.print(index);
	}

	private static void searchPattern(String pattern){
		/**
		 * 처음 6자리를 검색해서 result에 저장.
		 * result와 다음 6자리 검색결과를 모두 만족하는 pair를 추려서 result에 다시 저장한다. 추리기 = compareLL
		 * 마지막에는 가장 끝의 6자리를 검색하고(6으로 나누어 떨어지지 않을 수도 있으므로) 위와 같이 result에 저장한다.
		 */
		int len = pattern.length();
		int n = (int) Math.ceil((double)len/6);//조각의 총 개수
		LinkedList<Pair> result = new LinkedList<>();
		boolean exists = true;

		if(hashTable.search(new Key(pattern.substring(0,6))) != null){
			//첫 조각 검색결과가 존재하는 경우, 그것을 copy해서 Result 초기화
			result = hashTable.search(new Key(pattern.substring(0,6))).shallowCopy();
			if(len > 6){//len=6일 때는 result에 더이상 작업 필요x
				for(int i=1; i<n-1; i++){//2번째 조각 ~ 마지막에서 두번째 조각
					LinkedList<Pair> LL = hashTable.search(new Key(pattern.substring(6*i, 6*i+6)));
					if(LL == null){
						exists = false;
						break;
					}
					result = compareLL(result, LL, 6*i);
					if(result.numItems == 0){
						exists = false;
						break;
					}
				}
				//마지막 조각에 대한 작업
				LinkedList<Pair> LL = hashTable.search(new Key(pattern.substring(len-6, len)));
				if(LL == null){
					exists = false;
				} else{
					result = compareLL(result, LL, len-6);
					if(result.numItems == 0) exists = false;
				}
			}
		} else{//첫 조각부터 없는 경우
			exists = false;
		}

		//출력
		if(exists == false){
			System.out.println("(0, 0)");
		} else{
			System.out.println(result.toString());
		}
	}


	private static LinkedList<Pair> compareLL(LinkedList<Pair> LL1, LinkedList<Pair> LL2, int interval){
		// LL1, LL2에서 interval만큼 떨어진 연속한 pair를 찾아 새로운 LL로 만들고, 리턴한다.
		LinkedList<Pair> result = new LinkedList<Pair>();
		LLNode<Pair> Node1 = LL1.head.next;
		LLNode<Pair> Node2 = LL2.head.next;
		while(Node1 != null && Node2 != null){
			if(Node2.item.a < Node1.item.a) Node2 = Node2.next;
			else if(Node2.item.a > Node1.item.a) Node1 = Node1.next;
			else{//Node2.item.a == Node1.item.a
				if(Node2.item.b < Node1.item.b + interval) Node2 = Node2.next;
				else if(Node2.item.b > Node1.item.b + interval) Node1 = Node1.next;
				else{ //Node2.item.b == Node1.item.b + 6
					result.append(Node1.item);
					Node1 = Node1.next;
					Node2 = Node2.next;
				}
			}
		}
		return result;
	}

}

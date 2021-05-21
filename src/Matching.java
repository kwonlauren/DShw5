import java.io.*;

public class Matching
{
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
		input = input.substring(1);
		input.trim();
		switch(c){
			case '<': readData(input); break;
			case '@': printData(Integer.parseInt(input)); break;
			case '?': searchPattern(input); break;
			default: throw new IllegalStateException("Unexpected value" + c);
		}
	}

	private static void readData(String filename){
		//TODO: implement function
	}

	private static void printData(int index){
		//TODO: implement function
	}

	private static void searchPattern(String pattern){
		//TODO: implement function
	}
}

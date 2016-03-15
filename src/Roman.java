import java.util.Scanner;
import java.util.ArrayList;

public class Roman
{
	
	int userInput;
	int digitModded;
	int checkForLargeInt;
	
	Scanner scanner = new Scanner(System.in);
	ArrayList<Character> romanCharsFivesList = new ArrayList<>();
	ArrayList<Character> romanCharsTensList = new ArrayList<>();
	ArrayList<Integer> inputSeparatedList = new ArrayList<>();
	
	
	
	public Roman()
	{
		
	}
	
	
	
	public void Run()
	{
		SetUpConverter();

		FillSeparatedInputList();

		PrintRomanNumeral();
	}
	
		public void SetUpConverter()
		{
			FillFivesList();
			FillTensList();
			GetUserInput();
		}	
	
			public void FillFivesList()
			{
				romanCharsFivesList.add('V');
				romanCharsFivesList.add('L');
				romanCharsFivesList.add('D');
				romanCharsFivesList.add('V');
			}
			
			public void FillTensList()
			{
				romanCharsTensList.add('I');
				romanCharsTensList.add('X');
				romanCharsTensList.add('C');
				romanCharsTensList.add('M');
				romanCharsTensList.add('X');
			}
			
			public void GetUserInput()
			{
				System.out.println("Please enter the integer that you'd like converted to Roman Numerals. Must be greater than 0 and equal to or less than 10,000.");
				userInput = scanner.nextInt();	
			}
	
		public void FillSeparatedInputList()
		{
			while(userInput > 0)
			{
				inputSeparatedList.add(userInput % 10);
				userInput /= 10;
			}
		}
	
		public void PrintRomanNumeral()
		{
			for(int i = inputSeparatedList.size() - 1; i >= 0; i--)
			{
				CheckFor1KMultiplier(i);
				if (inputSeparatedList.get(i) < 5)
				{	
					PrintForDigitsLessThanFive(i);
				}
				else if (inputSeparatedList.get(i) > 5)
				{
					PrintForDigitsGreaterThanFive(i);
				}
				else
				{
					PrintForDigitFive(i);
				}
			}
		}
	
		public void CheckFor1KMultiplier(int i)
		{
			if(i == 3 && inputSeparatedList.get(i) >= 4)
			{
				if(inputSeparatedList.get(i) == 4 || inputSeparatedList.get(i) == 9)
				{
					System.out.print("__\n");
				}
				else
				{
					System.out.print("_\n");
				}
			}
			if(i == 4)
			{
				System.out.print("_\n");
			}
		}
	
		public void PrintForDigitsLessThanFive(int i)
		{
			if(inputSeparatedList.get(i) == 4)
			{
				System.out.print(romanCharsTensList.get(i) + "" + romanCharsFivesList.get(i));
			}
			else
			{
				for(int j = 0; j < inputSeparatedList.get(i); j++)
				{
					System.out.print(romanCharsTensList.get(i));
				}
			}
		}	
	
		public void PrintForDigitsGreaterThanFive(int i)
		{
			if(inputSeparatedList.get(i) == 9)
			{
				System.out.print(romanCharsTensList.get(i) + "" + romanCharsTensList.get(i + 1));
			}
			else
			{
				System.out.print(romanCharsFivesList.get(i));
				for(int j = 5; j < inputSeparatedList.get(i); j++)
				{
					System.out.print(romanCharsTensList.get(i));
				}
			}
		}
	
		public void PrintForDigitFive(int i)
		{
			System.out.print(romanCharsFivesList.get(i));
		}

}

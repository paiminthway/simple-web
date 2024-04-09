package LoginAuthentication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IDandPasswords {
	String[][] logininfo = new String[100][2];
	int i = 0;
	IDandPasswords(){
		try{
		File inputFile = new File("C:\\Users\\DELL\\workspace\\Raven\\IDAndPassword.txt");
		Scanner scanner = new Scanner(inputFile);
		while(scanner.hasNextLine()){
			String[] numOfWord = null;
			String line = scanner.nextLine();
			if(!line.trim().isEmpty())
			numOfWord = line.split("\\s+");
			logininfo[i][0] = numOfWord[0];
			logininfo[i][1] = numOfWord[1];
			i++;
		}
		scanner.close();
		}catch(FileNotFoundException e){
			System.out.print("File not found");
		}
	}
	protected String[][] getLoginInfo(){
		return logininfo;
	}
}
/**public class IDandPasswords {
	
	String[][] logininfo = new String[10][2];
	IDandPasswords(){
		logininfo[0][0] = "Raven";
		logininfo[0][1]= "pizza";
	}
	protected String[][] getLoginInfo(){
		return logininfo;
	}
}*/

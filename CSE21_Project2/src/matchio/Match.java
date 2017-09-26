package matchio;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.*;

import matchio.Student;

public class Match {
	public static void main(String [] args){
		
		int studentCount = 0;
		
		Student[] arr = new Student[100];
		try {
			Scanner input = new Scanner ( new FileReader("FullRoster.txt") );
			while (input.hasNextLine()) {
				String[] stu = input.nextLine().split("\t");
			
				Student st = new Student(stu[0], stu[1].charAt(0));
				String [] datearr = stu[2].split("-"); 
				int[] dateint = new int[3];
				for (int i = 0; i < datearr.length; i++) {
					dateint[i] = Integer.parseInt(datearr[i]);
				}
				st.setbday(dateint[0], dateint[1], dateint[2]);
				st.setpref(Integer.parseInt(stu[3]), Integer.parseInt(stu[4]), Integer.parseInt(stu[5]), Integer.parseInt(stu[6]));
				
				arr[studentCount] = st;
				
				studentCount++;
			} 
			input.close();
		} catch ( NoSuchElementException e){
			System.out.println(e); 
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		
		int[][] match = new int [100][100];
		for (int i = 0; i < match.length; i++){
			for (int k = 0; k < match.length; k++){
			match[i][k] = 0;
			}
		}
		
		for (int i = 0; i < studentCount; i++){
			for (int k = 0; k < studentCount; k++){
				match[i][k] = arr[i].compare(arr[i], arr[k]);
			}
		}
		
		boolean[] hasbeenmatched = new boolean [100];
		boolean[] printed = new boolean [100];
		
		for (int k = 0; k < 100; k++){
			hasbeenmatched[k] = false;
			printed[k] = false;
		}	
		
		int bestMatch = 0;
		int matchNumber = 0;
		for (int i = 0; i < studentCount; i++){
			
			if(hasbeenmatched[i] == false){
				bestMatch = 0;
				matchNumber = 0;
				for (int k = 0; k < studentCount; k++){
					if (i == k)
						continue;
					if(match[i][k] > bestMatch && hasbeenmatched[k] == false){
						bestMatch = match[i][k];
						matchNumber = k;
					}
				}	
			}
			
			
			if (bestMatch > 0 && printed[i] == false){
				System.out.println(arr[i].getName() + " matches with " + arr[matchNumber].getName() + " with the score " + match[i][matchNumber]);
				hasbeenmatched[i] = true;
				hasbeenmatched[matchNumber] = true;
				printed[i] = true;
				printed[matchNumber] = true;
			}
			else if (printed[i] == false)
				System.out.println(arr[i].getName() + " has no matches");
		}
		
	}

}

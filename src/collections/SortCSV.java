package collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCSV {
	
	List<Student> studentsList = new ArrayList<Student>();   
	
	public static void main(String[] args)
	{
		SortCSV sortCSV = new SortCSV();
		sortCSV.readCSVFile("unsortedList.csv");
		sortCSV.sortStudents();
		sortCSV.createSortedCSVFile("sortedList.csv");
	}

	private void createSortedCSVFile(String fileName) {

		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			for(Student student: studentsList)
			{
				writer.write(student.toString());
				writer.write("\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally
		{
			if(writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
	}

	private void sortStudents() {
		
		Collections.sort(studentsList);
		for(Student student: studentsList)
		{
			System.out.println(student.toString());
		}
		
	}

	private void readCSVFile(String filePath) {
		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String line = reader.readLine(); // skips first line
			while((line = reader.readLine()) != null)
			{
				String[] studentDetails = line.split(",");
				Student student = new Student();
				for(int i = 0; i < studentDetails.length; i++)
				{
					switch(i)
					{
					case 0:
						student.setStudentId(Integer.parseInt(studentDetails[i]));
						break;
					case 1:
						student.setFirstName(studentDetails[i]);
						break;
					case 2:
						student.setLastName(studentDetails[i]);
						break;
					case 3:
						student.setFinalMark(Integer.parseInt(studentDetails[i]));
						break;
					case 4:
						student.setFinalGrade(studentDetails[i]);
						break;
					}
					studentsList.add(student);
				}
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

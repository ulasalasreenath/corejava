package org.speakingcs.corejava.collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCSVFile {

	List<Student> studentsList = new ArrayList<Student>();
	String[] studentHeaders = null;

	/**
	 * Programs execution starts from here
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			SortCSVFile sortCSV = new SortCSVFile();
			sortCSV.readCSVFile("unsortedList.csv");
			sortCSV.sortStudents();
			sortCSV.createSortedCSVFile("sortedList.csv");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates the CSV file with sorted Student's data
	 * 
	 * @param fileName
	 */
	private void createSortedCSVFile(String fileName) {

		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(fileName));

			if (studentHeaders != null) {
				for (int i = 0; i < studentHeaders.length; i++) {
					if (i != studentHeaders.length - 1) {
						writer.write(studentHeaders[i] + ",");
					} else {
						writer.write(studentHeaders[i]);
					}
				}
				writer.write("\n");
			}

			// writing student's information to csv file
			for (Student student : studentsList) {
				writer.write(student.toString());
				writer.write("\n");
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/**
	 * Sorting Student objects
	 */
	private void sortStudents() {

		Collections.sort(studentsList);
		/*for (Student student : studentsList) {
			System.out.println(student.toString());
		}*/
	}

	/**
	 * Reads the csv file located at filePath and creates List of Student
	 * objects
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	private void readCSVFile(String filePath) throws IOException {

		BufferedReader reader = null;

		try {
			// reader for reading content of csv file
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

			String line = reader.readLine(); // skips first line, as the first
												// line contains meta data
			if (line != null) {
				studentHeaders = line.split(",");
			} else {
				System.out.println("file is empty");
			}

			while ((line = reader.readLine()) != null) {
				// split each line by ","
				String[] studentDetails = line.split(",");
				// creating Student object
				Student student = new Student();
				for (int i = 0; i < studentDetails.length; i++) {
					switch (i) {
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

				}
				studentsList.add(student);
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

}

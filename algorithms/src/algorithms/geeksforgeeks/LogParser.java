package algorithms.geeksforgeeks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LogParser {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filename = "/Users/vijayanbalasubramanian/Documents/workspacehk/algorithms/src/algorithms/geeksforgeeks/input_1.txt";
		if (args.length > 0) {
			filename = args[0];
		}

		String answer = parseFile(filename);
		System.out.println(answer);
	}

	static String parseFile(String filename) throws FileNotFoundException, IOException {
		/*
		 * Don't modify this function
		 */
		BufferedReader input = new BufferedReader(new FileReader(filename));
		List<String> allLines = new ArrayList<String>();
		String line;
		while ((line = input.readLine()) != null) {
			allLines.add(line);
		}
		input.close();

		return parseLines(allLines.toArray(new String[allLines.size()]));
	}

	// (11/01/2015-04:00:00) :: START
	// MM/dd/yyyy-hh:mm:ss
	static String parseLines(String[] lines) {
		Date startTime = null;
		Date endTime;
		double result = 0;
		Date connectedStartTime = null;
		Date connectedEndTime;
		double connectedTime = 0;
		for (String line : lines) {
			String[] row = line.split("::");
			SimpleDateFormat temp = new SimpleDateFormat("MM/dd/yyyy-hh:mm:ss");
			try {
				Date tt = temp.parse(row[0].trim().substring(1, row[0].trim().length() - 1));
				if (row[1].trim().equals("START")) {
					startTime = tt;
				} else if (row[1].trim().equals("SHUTDOWN")) {
					endTime = tt;
					result = connectedTime / TimeUnit.MILLISECONDS.toMinutes(endTime.getTime() - startTime.getTime());

				} else if (row[1].trim().equals("CONNECTED")) {
					connectedStartTime = tt;
				} else if (row[1].trim().equals("DISCONNECTED")) {
					connectedEndTime = tt;
					connectedTime += TimeUnit.MILLISECONDS
							.toMinutes(connectedEndTime.getTime() - connectedStartTime.getTime());
					connectedStartTime = null;

				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return String.valueOf(((int)(result * 100))) + "%";
	}
}

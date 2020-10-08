package bgu.spl.mics.application.passiveObjects;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Passive object representing the diary where all reports are stored.
 * <p>
 * This class must be implemented safely as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add ONLY private fields and methods to this class as you see fit.
 */
public class Diary {
	private static class SingletonHolder {
		private static Diary instance = new Diary();
	}
	private List<Report>reports=new LinkedList<>();
	private AtomicInteger total = new AtomicInteger(0);
	/**
	 * Retrieves the single instance of this class.
	 */
	public static Diary getInstance() {
		return SingletonHolder.instance;
	}

	public List<Report> getReports() {
		return reports;
	}
	public void increment(){total.getAndIncrement();}

	/**
	 * adds a report to the diary
	 * @param reportToAdd - the report to add
	 */
	public void addReport(Report reportToAdd){
		synchronized (this) {
			reports.add(reportToAdd);
		}
	}

	/**
	 *
	 * <p>
	 * Prints to a file name @filename a serialized object List<Report> which is a
	 * List of all the reports in the diary.
	 * This method is called by the main method in order to generate the output.
	 */
	public void printToFile(String filename) {
		Gson gson=new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).setPrettyPrinting().create();
		String diary=gson.toJson(Diary.getInstance());
		try(FileWriter writer=new FileWriter(filename)){
			writer.write(diary);
		}
		catch (Exception e){e.printStackTrace();}
	}
	/**
	 * Gets the total number of received missions (executed / aborted) by all the M-instances.
	 * @return the total number of received missions (executed / aborted) be all the M-instances.
	 */
	public int getTotal(){
		return total.intValue();
	}
}

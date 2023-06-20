package com.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
/**
 * @author rajpr
 * @see used to get report
 * @date 15/02/2023
 */
public class Reporting extends BaseClass {
	/**
	 * @see used to generate JVM report
	 * @param json
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void generateJVMReport(String json) throws FileNotFoundException, IOException {
		File file = new File(getProjectPath()+getPropertyFileValue("jvmPath"));

		Configuration configuration = new Configuration(file, "Adactin Hotel Automation ");
		configuration.addClassifications("browser", "chrome");
		configuration.addClassifications("browser version", "109");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(json);
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();

	}

}

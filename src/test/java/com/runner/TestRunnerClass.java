package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/**
 * @author rajpr
 * @see used to run a project
 * @date 14/02/2023
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags="@smoke",stepNotifications=false,dryRun=false,monochrome=true,plugin= {"pretty","json:target/index.json"},features="src/test/resources",glue="com.stepdefinition")

public class TestRunnerClass extends BaseClass {
	/**
	 * @see used to generate JVM report
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJVMReport(getProjectPath()+getPropertyFileValue("jsonPath"));
	}
	
	
	
	}



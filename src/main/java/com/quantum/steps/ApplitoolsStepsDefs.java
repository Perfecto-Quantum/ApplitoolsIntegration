/**
 * 
 */
package com.quantum.steps;


import com.applitools.eyes.Eyes;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.quantum.utils.AppiumUtils;
import com.quantum.utils.ConfigurationUtils;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

/**
 * @author chirag.jayswal
 *
 */
@QAFTestStepProvider
public class ApplitoolsStepsDefs {
	@Then("I check window \"(.*?)\"")
	public void checkWindow(String tag) {applitoolsCheckWindow(tag, false);}


	@Then("I check complete window \"(.*?)\"")
	public void checkCompleteWindow(String tag) {applitoolsCheckWindow(tag, true);}



	public void applitoolsCheckWindow(String tag, boolean fullPageScreenshot) {
		Object o = ConfigurationManager.getBundle().getObject("Eyes");
		if (null != o) {
			Eyes e = (Eyes) o;
			WebDriver orgDriver = new WebDriverTestBase().getDriver();
			if (!e.getIsOpen()) {
// Appium or Selenium?
				if (ConfigurationUtils.getBaseBundle().getPropertyValue("driver.name").contains("Remote"))
					orgDriver = e.open(orgDriver, orgDriver.getCurrentUrl(), "Demo");
// how to get suite/test name?							ConfigurationUtils.getBaseBundle().getPropertyValue("suite.name").toString());

				else

					orgDriver = e.open(orgDriver, AppiumUtils.getAppiumDriver().getCapabilities().getCapability("appName").toString(), "Demo");

			}

			try {
				if (fullPageScreenshot)
					e.setForceFullPageScreenshot(true);
				e.checkWindow(tag);
			} catch (Exception ex){
				System.out.println(ex.getMessage());
			}
		}
	}
}

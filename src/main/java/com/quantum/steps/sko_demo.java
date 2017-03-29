/**
 * 
 */
package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.StringUtil;
import com.quantum.utils.AppiumUtils;
import com.quantum.utils.ConfigurationUtils;
import com.quantum.utils.ConsoleUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.verifyText;

/**
 * @author chirag.jayswal
 *
 */
@QAFTestStepProvider
public class sko_demo {


	@Then("I go to services menu")
	public static void goToConatct() {
		QAFExtendedWebDriver d = new WebDriverTestBase().getDriver();
		try {
			d.findElement("menu").click();

		}catch (Exception e)
		{
			//do noting !! just oprn menu
		}

		d.findElement("contact").click();

	}



}

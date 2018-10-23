package com.crm.pages;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hotportal.pages.BasePage;

public class CRMSitePage extends BasePage {

	static final Logger log = LogManager.getLogger(CRMSitePage.class.getName());
	WebElement buttonSetDirection, bSendBill, bEdit, rbPhone, bApprove, bGoToScenario, bCategory, bNext, b360,
			product360tab, mailAddress1, mailAddress2;

	public CRMSitePage(WebDriver driver) throws IOException {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//

	// @FindBy(xpath = ".//*[@id='HT_CASEINFO_WRK_HT_CASE_INFO_GBX']/img")
	// WebElement setDirectionDetails;

	public boolean sendBill(String SiteNumber) throws InterruptedException, IOException {
		boolean sendBill = false;

		// Begin flow of the login
		log.info("Begin the flow of the go to site");
		try {
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ptifrmtgtframe");
			bSendBill = returnSlowElement(By.xpath(".//*[@id='HT_QUICK_FORM_1']/img"));
			click(bSendBill);
			sendBill = true;
		} catch (TimeoutException te) {
			log.fatal("Exception received: ");
			te.printStackTrace();
			return false;
		} catch (Exception e) {
			log.fatal("Exception received: ");
			e.printStackTrace();
			return false;
		}

		Thread.sleep(2000);

		if (sendBill) {

		} else
			return false;

		return sendBill;
	}

	public boolean verifyMailExist(String SiteNumber) throws InterruptedException, IOException {
		boolean bVerifyMailExist = false;

		// Begin flow of the login
		log.info("Begin the flow of the go to site");
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ptifrmtgtframe");
			Thread.sleep(1000);
			mailAddress2 = driver.findElement(By.xpath("//tr[contains(@id,'row1')]//select[contains(@id,'HT_EMAIL_DRV_HT_DOMAIN')]"));
			mailAddress1 = driver.findElement(By.xpath("//tr[contains(@id,'row1')]//input[contains(@id,'HT_EMAIL_DRV_HT_NAME')]"));
			String textInsideInputBox = mailAddress1.getAttribute("value");
			
			System.out.println("Text in email field: " + textInsideInputBox);
			
			if (textInsideInputBox.isEmpty()) {
				Actions act = new Actions(driver);
				Select sMail2 = new Select(mailAddress2);
				Thread.sleep(2000);
				//sMail2.selectByValue("gmail.com");
				sMail2.selectByValue("gmail.com");
				Thread.sleep(2000);
				act.sendKeys(Keys.TAB).build().perform();
				Thread.sleep(2000);
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("ptifrmtgtframe");
				
				clickJS(mailAddress1);
				act.sendKeys("hagai1973").build().perform();
				Thread.sleep(2000);
				act.sendKeys(Keys.TAB).build().perform();
				Thread.sleep(2000);
				driver.findElements(By.xpath("//a[contains(@id,'ICSave')]/img")).get(0).click();
			}

			bVerifyMailExist = true;
		} catch (TimeoutException te) {
			log.fatal("Exception received: ");
			te.printStackTrace();
			return false;
		} catch (Exception e) {
			log.fatal("Exception received: ");
			e.printStackTrace();
			return false;
		}

		Thread.sleep(2000);

		if (!bVerifyMailExist)
			return false;
		else
		return bVerifyMailExist;
	}

	public boolean setDirection() throws InterruptedException, IOException {
		boolean bSetDirection = true;

		// Begin flow of the login
		log.info("Begin the flow of the direction details");
		try {
			driver.switchTo().frame("ptifrmtgtframe");
			WebElement buttonSetDirection = returnSlowElement(
					By.xpath(".//*[@id='HT_CASEINFO_WRK_HT_CASE_INFO_GBX']/img"));
			clickJS(buttonSetDirection);
			bEdit = returnSlowElement(By.xpath(".//*[@id='DERIVED_RC_EDIT_CONTACT']"));
			clickJS(bEdit);
			// Need to add number detection

			List<WebElement> wPhones = driver.findElements(By.xpath(".//td[3]//span[@class='PSEDITBOX_DISPONLY']"));
			int count = 1;
			for (WebElement w : wPhones) {
				if (w.getText().contains("-")) {
					break;
				} else {
					count = count + 1;
				}
			}

			count = count + 1;

			WebElement rb = driver.findElement(By.xpath(".//tr[" + count
					+ "]/td[1]/div[contains(@id,'BO_CNTCT_CM_VW')]/input[contains(@id,'BO_CNTCT_CM_VW')]"));
			clickJS(rb);

			bApprove = returnSlowElement(By.id("DERIVED_RC_CNCT_OK_PB"));
			clickJS(bApprove);

		} catch (TimeoutException te) {
			log.fatal("Exception received: ");
			te.printStackTrace();
			return false;
		} catch (StaleElementReferenceException ser) {
			log.info("Some issue accured for dealing with elements: StaleElementReferenceException");

		} catch (Exception e) {
			log.info("Some issue accured for dealing with elements: exception");
			e.printStackTrace();
			// return false;
		}
		driver.switchTo().defaultContent();
		return bSetDirection;
	}

	public boolean getProduct360(String SiteNumber) throws InterruptedException, IOException {
		boolean getProduct360 = true;

		// Begin flow of the login
		log.info("Begin the flow of the 360 product");
		try {
			driver.switchTo().frame("ptifrmtgtframe");
			b360 = returnSlowElement(By.xpath(".//*[@id='HT_360PRODUCT']/img"));
			clickJS(b360);
			Thread.sleep(10000);

		} catch (TimeoutException te) {
			log.fatal("Exception received: ");
			te.printStackTrace();
			getProduct360 = false;
		} catch (StaleElementReferenceException ser) {
			log.info("Some issue accured for dealing with elements: StaleElementReferenceException");
			// return false;
		} catch (Exception e) {
			log.info("Some issue accured for dealing with elements: exception");
			e.printStackTrace();

			getProduct360 = false;
		}

		try {
			product360tab = returnSlowElement(By.xpath(".//td[contains(text(),'Product 360')]"));
			if (!IsObjectExist(product360tab)) {
				getProduct360 = false;
			}
		} catch (Exception e) {
			log.info("Some issue accured for dealing with elements: exception");
			e.printStackTrace();

			Thread.sleep(5000);
			getProduct360 = false;
		}
		driver.switchTo().defaultContent();
		return getProduct360;
	}

	public boolean goToScenario() throws InterruptedException, IOException {
		boolean boogoToScenario = true;

		// Begin flow of the login
		log.info("Begin the flow of the direction details");
		try {
			driver.switchTo().frame("ptifrmtgtframe");
			bGoToScenario = driver.findElement(By.id("RC_BS_EXEC_WRK_RC_BS_NEXT_BTN"));
			clickJS(bGoToScenario);
		} catch (TimeoutException te) {
			log.fatal("Exception received: ");
			te.printStackTrace();
			return false;
		} catch (StaleElementReferenceException ser) {
			log.info("Some issue accured for dealing with elements: StaleElementReferenceException");
			// e.printStackTrace();
			// return false;
		}

		catch (Exception e) {
			log.info("Some issue accured for dealing with elements: exception");
			e.printStackTrace();
			return false;
		}
		driver.switchTo().defaultContent();
		return boogoToScenario;
	}

	public boolean goToScenarioStages() throws InterruptedException, IOException {
		boolean booGoToScenarioStages = true;

		// Begin flow of the login
		log.info("Begin the flow of the goToScenario Stages");
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ptifrmtgtframe");

			VerifyPageIsReady(By.id("processing"));
			bCategory = returnSlowElement(By.xpath(".//tr[4]//input[@class='PSRADIOBUTTON'][@type='radio']"));
			clickJS(bCategory);

			bNext = returnSlowElement(By.id("RC_BS_EXEC_WRK_RC_BS_NEXT_BTN"));
			clickJS(bNext);
			VerifyPageIsReady(By.id("processing"));

			
			bNext = returnSlowElement(By.id("RC_BS_EXEC_WRK_RC_BS_NEXT_BTN"));
			clickJS(bNext);
			VerifyPageIsReady(By.id("processing"));

			// bNext = returnSlowElement(By.id("RC_BS_EXEC_WRK_RC_BS_NEXT_BTN"));
			// clickJS(bNext);
			// Thread.sleep(3000);

		} catch (TimeoutException te) {
			log.fatal("Exception received: ");
			te.printStackTrace();
			return false;
		} catch (StaleElementReferenceException ser) {
			log.info("Some issue accured for dealing with elements: StaleElementReferenceException");
			// e.printStackTrace();
			// return false;
		}

		catch (Exception e) {
			log.info("Some issue accured for dealing with elements: exception");
			e.printStackTrace();
			return false;
		}
		driver.switchTo().defaultContent();
		return booGoToScenarioStages;
	}

	public boolean StagesQuestions() throws InterruptedException, IOException {
		boolean bGoToScenarioStagesQuestions = true;

		// Begin flow of the login
		log.info("Begin the flow of the questions details");
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ptifrmtgtframe");

			// צפייה ושמע
			bCategory = returnSlowElement(By.xpath(".//tbody/tr[1]/td/div/input[@type='radio']"));
			if(bCategory==null) {
				log.fatal("Could not find the expected radio button for continue");
				return false;
			}
				
			clickJS(bCategory);
			bNext = returnSlowElement(By.id("RC_BS_EXEC_WRK_RC_BS_NEXT_BTN"));
			clickJS(bNext);

			// תמונה
//			driver.switchTo().frame("ptifrmtgtframe");
			VerifyPageIsReady(By.id("processing"));
			bCategory = returnSlowElement(By.xpath(".//tbody/tr[1]/td/div/input[@type='radio']"));
			clickJS(bCategory);
			WebElement bNext1 = returnSlowElement(By.id("RC_BS_EXEC_WRK_RC_BS_NEXT_BTN"));
			clickJS(bNext1);
			VerifyPageIsReady(By.id("processing"));

		} catch (TimeoutException te) {
			log.fatal("Exception received: ");
			te.printStackTrace();
			return false;
		} catch (StaleElementReferenceException ser) {
			log.info("Some issue accured for dealing with elements: StaleElementReferenceException");
			return false;
		}

		catch (Exception e) {
			log.info("Some issue accured for dealing with elements: exception");
			e.printStackTrace();
			return false;
		}
		driver.switchTo().defaultContent();
		return bGoToScenarioStagesQuestions;
	}

	public boolean StagesQuestions2() throws InterruptedException, IOException {
		boolean booStagesQuestions2 = true;

		// Begin flow of the login
		log.info("Begin the flow of the questions details 2");
		try {

			driver.switchTo().defaultContent();
			driver.switchTo().frame("ptifrmtgtframe");
			VerifyPageIsReady(By.id("processing"));

			// אין קליטה בחלק מהערוצים לתקן
			WebElement bCategory1 = driver.findElement(By.xpath((".//tbody/tr[3]/td/div/input[@type='radio']")));
			clickJS(bCategory1);

			WebElement bNext1 = returnSlowElement(By.id("RC_BS_EXEC_WRK_RC_BS_NEXT_BTN"));
			clickJS(bNext1);

			VerifyPageIsReady(By.id("processing"));
			// בממיר
			bCategory = returnSlowElement(By.xpath(".//tbody/tr[1]/td/div/input[@type='radio']"));
			VerifyPageIsReady(By.id("processing"));
			clickJS(bCategory);
			VerifyPageIsReady(By.id("processing"));
			bNext = returnSlowElement(By.id("RC_BS_EXEC_WRK_RC_BS_NEXT_BTN"));
			VerifyPageIsReady(By.id("processing"));
			clickJS(bNext);
			VerifyPageIsReady(By.id("processing"));
			// מגבר
			bCategory = returnSlowElement(By.xpath(".//tbody/tr[2]/td/div/input[@type='radio']"));
			clickJS(bCategory);
			bNext = returnSlowElement(By.id("RC_BS_EXEC_WRK_RC_BS_NEXT_BTN"));
			clickJS(bNext);
			VerifyPageIsReady(By.id("processing"));
			// לקוח אינו בחוב
			bCategory = returnSlowElement(By.xpath(".//tbody/tr[2]/td/div/input[@type='radio']"));
			clickJS(bCategory);

			VerifyPageIsReady(By.id("processing"));
			bNext = returnSlowElement(By.id("RC_BS_EXEC_WRK_RC_BS_NEXT_BTN"));
			clickJS(bNext);
		
			VerifyPageIsReady(By.id("processing"));
			bNext = returnSlowElement(By.id("RC_BS_EXEC_WRK_RC_BS_NEXT_BTN"));
			clickJS(bNext);
			VerifyPageIsReady(By.id("processing"));
			Thread.sleep(1000);
			bNext = returnSlowElement(By.id("RC_BS_EXEC_WRK_RC_BS_NEXT_BTN"));
			clickJS(bNext);
			VerifyPageIsReady(By.id("processing"));
			Thread.sleep(1000);

			// סיים תסריט
			bNext = returnSlowElement(By.id("RC_BS_EXEC_WRK_RC_BS_NEXT_BTN"));
			clickJS(bNext);
			VerifyPageIsReady(By.id("processing"));
			Thread.sleep(1000);

		} catch (TimeoutException te) {
			log.fatal("Exception received: ");
			te.printStackTrace();
			return false;
		} catch (StaleElementReferenceException ser) {
			log.info("Some issue accured for dealing with elements: StaleElementReferenceException");

		}

		catch (Exception e) {
			log.info("Some issue accured for dealing with elements: exception");
			e.printStackTrace();
			return false;
		}
		driver.switchTo().defaultContent();
		return booStagesQuestions2;
	}

	public boolean FedexQuestions() throws InterruptedException, IOException {
		boolean bFedexQuestions = true;

		// Begin flow of the login
		log.info("Begin the flow of the Fedex questions details");
		try {

			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.switchTo().frame("ptifrmtgtframe");
			Thread.sleep(3000);

			// המשך טיפול
			try {
				WebElement bContinueCare = driver.findElement(By.xpath((".//*[@class='PSLEVEL1GRIDINACTIVETAB']/a")));
				clickJS(bContinueCare);
			} catch (NoSuchElementException te) {
				bNext = returnSlowElement(By.id("RC_BS_EXEC_WRK_RC_BS_NEXT_BTN"));
				clickJS(bNext);
				Thread.sleep(1000);
				WebElement bContinueCare = driver.findElement(By.xpath((".//*[@class='PSLEVEL1GRIDINACTIVETAB']/a")));
				clickJS(bContinueCare);

			}
			// שליחות
			WebElement sDeliveryType = driver
					.findElement(By.xpath((".//select[contains(@id,'HT_CASE_SC_HT_EQUIPMENT')]")));
			clickJS(sDeliveryType);

			Actions act = new Actions(driver);
			act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
					.build().perform();

		} catch (NoSuchElementException te) {
			log.fatal("Exception received: ");
			te.printStackTrace();
			return false;
		} catch (StaleElementReferenceException ser) {
			log.info("Some issue accured for dealing with elements: StaleElementReferenceException");

		}

		catch (Exception e) {
			log.info("Some issue accured for dealing with elements: exception");
			e.printStackTrace();
			return false;
		}
		driver.switchTo().defaultContent();
		return bFedexQuestions;
	}

	public boolean FedexQuestions2() throws InterruptedException, IOException {
		log.info("Begin the flow of the Fedex questions details");

		VerifyPageIsReady(By.id("processing"));
		driver.switchTo().defaultContent();
		VerifyPageIsReady(By.id("processing"));
		driver.switchTo().frame("ptifrmtgtframe");
		VerifyPageIsReady(By.id("processing"));

		// סוג קריאה
		WebElement bCallType = driver
				.findElement(By.xpath((".//input[contains(@id,'HT_CASE_TECH_WR_HT_SETSC_TYPE_')]")));
		clickJS(bCallType);

		VerifyPageIsReady(By.id("processing"));
		// פתיחת פק"ע
		WebElement bOpenPKA = driver.findElement(By.xpath((".//*[@id='COMPOSIA_HT_BTN_NEW_PAKA_SC']")));
		clickJS(bOpenPKA);
		
		VerifyPageIsReady(By.id("processing"));
		Thread.sleep(3000);
		// סגרית חלון הזהרה
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();

		boolean bFound = false;
		int i = 0;

		driver.switchTo().defaultContent();

		while (bFound == false) {

			driver.switchTo().frame(i);
			VerifyPageIsReady(By.id("processing"));
			try {

				// הצג פרטי יומן
				WebElement bCalendarDetails = driver.findElement(By.xpath((".//*[@id='HT_SO_DRV_HT_SHOW_CALENDAR']")));
				clickJS(bCalendarDetails);
				bFound = true;
				System.out.println("The number of the frame that was found is: " + i);

			} catch (NoSuchElementException ee) {
				i = i + 1;
				driver.switchTo().defaultContent();
				System.out.println("failed for no such element");
			} catch (Exception e1) {
				i = i + 1;
				driver.switchTo().defaultContent();
				System.out.println("failed for no general");
			}

		}

		return true;
	}

	public boolean FedexQuestions3() throws InterruptedException, IOException {
		log.info("Begin the flow of the Fedex questions details");

		VerifyPageIsReady(By.id("processing"));

		driver.switchTo().defaultContent();

		int count = 0;
		int index = 0;

		while ((count == 0) && (index < 5)) {
			count = driver.findElements(By.xpath(".//*[@id='#ICOK']")).size();
			log.info("appear warning message ?" + count);
			VerifyPageIsReady(By.id("processing"));
			Thread.sleep(2000);
			index += 1;
		}

		// סגירת חלון הזהרה
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);

		boolean bFound = false;

		while (bFound == false) {

			try {
				// בחירת פרטים מרשימה חלקים
				driver.switchTo().defaultContent();
				VerifyPageIsReady(By.id("processing"));
				
				driver.switchTo().frame("ptModFrame_2");
				VerifyPageIsReady(By.id("processing"));
				
				int appear = driver.findElements(By.id("HT_SO_DRV_HT_DESCR")).size();
				System.out.println("appear: " + appear);
				if (appear > 0) {

					bFound = true;
					// List<WebElement> cbWL =
					// driver.findElements(By.xpath(".//table[@id='ACE_HT_SO_DRV_HT_GBX13']//input[contains(@name,'HT_SO_DRV_SELECT_FLAG')]"));
					List<WebElement> cbWL = driver
							.findElements(By.xpath(".//table[@id='ACE_HT_SO_DRV_HT_GBX13']//input[(@value='Y')]"));
					System.out.println("Size of cb list: " + cbWL.size());

					List<WebElement> cbWL2 = driver
							.findElements(By.xpath(".//span[contains(@id,'WZ1_SERIAL_VW_HT_CONVERTER_TYPE')]"));

					//בחירת ציוד מתוך רשימה
					try {
						for (int i = 0; i < cbWL.size(); i++) {
							System.out
									.println("Print data in col 2 of the device name value: " + cbWL2.get(i).getText());
							Thread.sleep(1000);
							if (!(cbWL2.get(i).getText().equals("FIBERBOX"))) {
								if (!(cbWL2.get(i).getText().contains("MOCA"))) {
									if ((cbWL.get(i).isEnabled()) & (cbWL.get(i).isDisplayed())) {
										if (!cbWL2.get(i).getText().isEmpty() || (!cbWL2.get(i).getText().equals(""))
												|| (!cbWL2.get(i).getText().equals(" "))) {
											// if (cbWL.get(i).getAttribute("value") == ("Y")) {
											clickJS(cbWL.get(i));
											Thread.sleep(2000);
											// }
											act.sendKeys(Keys.ENTER).build().perform();
											break;
										}
									}
								}

							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

					Thread.sleep(2000);
					WebElement bYoman = driver.findElement(By.id("HT_SO_DRV_HT_SHOW_CALENDAR"));
					clickJS(bYoman);
					VerifyPageIsReady(By.id("processing"));
					Thread.sleep(3000);

					act.sendKeys(Keys.ENTER).build().perform();
		
					List<WebElement> cbTime = driver.findElements(By.className("HT_BUTTON_GREEN"));
					System.out.println("Size of cb list: " + cbTime.size());
					clickJS(cbTime.get(0));

					WebElement bSaveAndClose = driver.findElement(By.id("HT_SO_DRV_HT_CLOSE_BTN"));
					clickJS(bSaveAndClose);

					VerifyPageIsReady(By.id("processing"));
					Thread.sleep(2000);

					driver.switchTo().defaultContent();

					List<WebElement> iframesList = driver.findElements(By.tagName("iframe"));
					int listSize = iframesList.size();
					System.out.println("Number of frames in main: " + listSize);

					try {
						for (WebElement ifr : iframesList) {
							String frameid = ifr.getAttribute("id");
							System.out.println(frameid);
						}

					} catch (Exception e1) {
						System.out.println("failed for no general");
						e1.printStackTrace();
					}

					for (int f = 0; f < listSize; f++) {
						try {
							driver.switchTo().defaultContent();
							// driver.switchTo().frame(f);
							driver.switchTo().frame(4);

							if (driver.findElements(By.id("HT_SO_SMRY_DRV_OK_BTN")).size() > 0) {
								WebElement bApprove = driver.findElement(By.id("HT_SO_SMRY_DRV_OK_BTN"));
								clickJS(bApprove);
								break;
							}

						} catch (Exception e1) {
							System.out.println("failed for no general");
							e1.printStackTrace();
						}

					}

				}

			} catch (NoSuchElementException ee) {
				System.out.println("failed for no such element");
			} catch (Exception e1) {
				System.out.println("failed for no general");
				e1.printStackTrace();
			}

		}

		System.out.println("Go out!!!!!!");
		return true;
	}
}

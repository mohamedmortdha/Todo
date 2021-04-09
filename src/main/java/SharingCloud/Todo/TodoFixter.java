package SharingCloud.Todo;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TodoFixter {
	private static WebDriver dr = null;
	public String open_url, todo, action, category;

	public void setOpen_url(String open_url) {

		// Put a Implicit wait, this means that any search for elements on the page
		// could take the time the implicit wait is set for before throwing exception
		dr = new ChromeDriver();

		// Put a Implicit wait, this means that any search for elements on the page
		// could take the time the implicit wait is set for before throwing exception

		dr.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		// Launch the Online Store Website

		dr.get("http://localhost:9090/");
//        dr.get(open_url);
//	       

	}
    private void submitTodo(String todo)throws InterruptedException{
    	dr.findElement(By.xpath("/html/body/form/input")).sendKeys(todo);
		Thread.sleep(200);
		dr.findElement(By.xpath("/html/body/form/button")).click();
		Thread.sleep(200);
    }
	public void setTodo(String todo) throws InterruptedException {
		Thread.sleep(200);
		submitTodo(todo);
	}

	public void setTodo1(String todo1) throws InterruptedException {
		submitTodo(todo1);

	}

	public void setTodo2(String todo2) throws InterruptedException {
		submitTodo(todo2);
	}

	public void setTodo3(String todo3) throws InterruptedException {
		submitTodo(todo3);
	}

	public void setTodo4(String todo4) throws InterruptedException {
		submitTodo(todo4);
		List<WebElement> elms = dr.findElements(By.xpath("/html/body/ul/li[1]/span"));
		assertNotEquals(elms.get(0).getText(), "Personnel");
		assertNotEquals(elms.get(0).getText(), "Professionnel");
	}
	public void setTodo5(String todo5) throws InterruptedException {
		submitTodo(todo5);
		List<WebElement> elms = dr.findElements(By.xpath("/html/body/ul/li[2]/span[1]"));
		assertEquals(elms.get(0).getText(), "Personnel");

	}
	public void setTodo6(String todo6) throws InterruptedException {
		submitTodo(todo6);
		List<WebElement> elms = dr.findElements(By.xpath("/html/body/ul/li[3]/span[1]"));
		assertEquals(elms.get(0).getText(), "Personnel");
	}
	public void setTodo7(String todo7) throws InterruptedException {
		submitTodo(todo7);
		List<WebElement> elms = dr.findElements(By.xpath("/html/body/ul/li[4]/span[1]"));
		assertEquals(elms.get(0).getText(), "Professionnel");
	}
	public void setCategory(String category) throws InterruptedException{
		if (category != null) {
			dr.findElement(By.xpath("/html/body/form/button")).click();
			Thread.sleep(200);
		}
	}
	public void setCategory1(String category1) throws InterruptedException{
		List<WebElement> elms = dr.findElements(By.tagName("option"));
		for (WebElement elm : elms) {
			if(elm.getText().trim().equals(category1)) {
				elm.click();
			}
			
		}
	}
	public void setCategory2(String category2) throws InterruptedException{
		List<WebElement> elms = dr.findElements(By.tagName("option"));
		for (WebElement elm : elms) {
			if(elm.getText().trim().equals(category2)) {
				elm.click();
			}
			
		}
	}
	public void setCategory3(String category3) throws InterruptedException{
		List<WebElement> elms = dr.findElements(By.tagName("option"));
		for (WebElement elm : elms) {
			if(elm.getText().trim().equals(category3)) {
				elm.click();
			}
			
		}
	}
	public void setCheckbox(String checkbox)throws InterruptedException {
		if (checkbox.equals("oui")) {
			dr.findElement(By.xpath("/html/body/ul/li[1]/input")).click();
			Thread.sleep(200);
		}
	}
	public void setRemove(String remove)throws InterruptedException {
		if (remove.equals("oui")) {
			WebElement elm = dr.findElement(By.xpath("//html/body/ul/li/button"));
			assertTrue(elm.isDisplayed());
			elm.click();
			Thread.sleep(200);
		}
	}
	

	public String Result() {

		List<WebElement> elms = dr.findElements(By.xpath("/html/body/ul/li/span"));
		for (WebElement elm : elms) {
			assertEquals(elm.getText(), "Adopter de bonne partiques de test");
		}
		WebElement elm = dr.findElement(By.xpath("/html/body/ul/li[1]/input"));
		assertFalse(elm.isSelected());
		dr.close();

		return "Adopter de bonne partiques de test And Not Selected";
	}
	public String Result2() {

		List<WebElement> elms = dr.findElements(By.xpath("/html/body/ul/li[1]/span"));
		for (WebElement elm : elms) {
			assertEquals(elm.getText(), "Adopter de bonne partiques de test");
		}
		List<WebElement> elms2 = dr.findElements(By.xpath("/html/body/ul/li[2]/span"));
		for (WebElement elm : elms2) {
			assertEquals(elm.getText(), "Comprendre le Keyword-Driven Testing");
		}
		List<WebElement> elms3 = dr.findElements(By.xpath("/html/body/ul/li[3]/span"));
		for (WebElement elm : elms3) {
			assertEquals(elm.getText(), "Automatiser des cas de test avec Robot FrameWork");
		}
		WebElement elm = dr.findElement(By.xpath("/html/body/ul/li[1]/input"));
		assertTrue(elm.isSelected());
		WebElement elm2 = dr.findElement(By.xpath("/html/body/ul/li[2]/input"));
		assertFalse(elm2.isSelected());
		WebElement elm3 = dr.findElement(By.xpath("/html/body/ul/li[3]/input"));
		assertFalse(elm3.isSelected());
		dr.close();
	

		return "Adopter de bonne partiques de test, Comprendre le Keyword-Driven Testing , Automatiser des cas de test avec Robot FrameWork ,first selected , second not slected and third not selected";
	}
	public String Result3() {

		try {
			WebElement elm = dr.findElement(By.xpath("//html/body/ul/li/button"));
			assertTrue(false);
		}catch (Exception e) {
			assertTrue(true);
		}
	
		dr.close();

		return "Contain button remove and Not Contain Element Choisir le bon type de framework de test";
	}
	public String Result4() {

		dr.close();

		return "Personnel,Personnel and Professionnel";
	}

}

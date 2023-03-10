package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLoginPageTest {
  @Test
  public void f(Integer n,String s) {
  }
  @DataProvider(name="dataProvider")
  public Object[][] dpmethod(){
	  return new Object[][]
			  {
		  {"Keertyhi","sshsh"},{"dfsf","4567"},{"vz","456"}
			  };
	  
  }
}

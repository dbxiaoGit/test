/**
 * @ version 1.0
 * @ author dbxiao
 */

package com.db;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
  @Test
  public void f() {
	  System.out.println("test");
  }
  @Test
  public void f1() {
	  System.out.println("test1");
	  int a=2;
	  Assert.assertTrue(a==1,"sdftr true ");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("test_before");

  }

  @AfterTest
  public void afterTest() {
	  System.out.println("test_after");

  }

}

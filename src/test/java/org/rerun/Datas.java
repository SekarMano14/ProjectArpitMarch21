package org.rerun;

import org.testng.annotations.DataProvider;

public class Datas {

	@DataProvider(name="login",indices= {0,2},parallel=true)
	public static Object[][] getData() {
		
		return new Object[][] {
			{"manoj","kumar","manoJ","Kumar"},
            {"Raj","kumar","raj","Kumar"},
            {"Ram","kumar","ram","kumar"},
            {"Suresh","kumar","suresh","kumar"}
            };
	}
}

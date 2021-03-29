package org.rerun;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
public class WithoutKnow implements IAnnotationTransformer{
	public void transform(ITestAnnotation a, Class testClass, Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer r = a.getRetryAnalyzer();
		if(r==null) {
		
		a.setRetryAnalyzer(WithKnown.class);
		}
	}

}

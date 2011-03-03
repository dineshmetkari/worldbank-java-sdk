/*
 * Copyright 2010-2011 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package org.worldbank.api.services;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * The Class AllTests.
 */
public class AllTests {

	/**
	 * Suite.
	 * 
	 * @return the test
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.worldbank.api.services");
		//$JUnit-BEGIN$
		suite.addTestSuite(IndicatorQueryTest.class);
		suite.addTestSuite(SourceQueryTest.class);
		suite.addTestSuite(CountryQueryTest.class);
		suite.addTestSuite(IncomeLevelQueryTest.class);
		suite.addTestSuite(LendingTypeQueryTest.class);
		suite.addTestSuite(TopicQueryTest.class);
		//$JUnit-END$
		return suite;
	}
}

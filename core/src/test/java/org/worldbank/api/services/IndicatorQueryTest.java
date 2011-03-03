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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.worldbank.api.common.PagedList;
import org.worldbank.api.schema.Indicator;

/**
 * The Class IndicatorQueryTest.
 */
public class IndicatorQueryTest extends BaseWorldBankQueryTest {
	
	/** The service. */
	private IndicatorQuery service;

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createIndicatorQuery();
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	/**
	 * Test list.
	 */
	@Test
	public void testList() {
		PagedList<Indicator> indicators = service.list();
		assertNotNullOrEmpty("Indicators must not be null or empty.", indicators);
	}
}

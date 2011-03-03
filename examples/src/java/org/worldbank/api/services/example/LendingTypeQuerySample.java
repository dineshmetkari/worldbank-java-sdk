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
package org.worldbank.api.services.example;

import java.util.List;

import org.worldbank.api.schema.LendingType;
import org.worldbank.api.services.LendingTypeQuery;
import org.worldbank.api.services.WorldBankQueryFactory;


/**
 * The Class LendingTypeQuerySample.
 */
public class LendingTypeQuerySample {

    /**
     * The main method.
     * 
     * @param args the arguments
     * 
     * @throws Exception the exception
     */
	public static void main(String[] args) throws Exception {
		WorldBankQueryFactory factory = WorldBankQueryFactory.newInstance();
		LendingTypeQuery service = factory.createLendingTypeQuery();
		List<LendingType> lendingTypes = service.list();
		for (LendingType lendingType : lendingTypes) {
			printResult(lendingType);
		}
	}

	/**
	 * Prints the result.
	 * 
	 * @param lendingType the lending type
	 */
	private static void printResult(LendingType lendingType) {
		System.out.println(lendingType.getId() + ":" + lendingType.getValue());
	}
}

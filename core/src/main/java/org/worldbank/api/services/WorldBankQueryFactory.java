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

import org.worldbank.api.services.impl.SourceQueryImpl;
import org.worldbank.api.services.impl.CountryQueryImpl;
import org.worldbank.api.services.impl.IncomeLevelQueryImpl;
import org.worldbank.api.services.impl.IndicatorQueryImpl;
import org.worldbank.api.services.impl.LendingTypeQueryImpl;
import org.worldbank.api.services.impl.TopicQueryImpl;




/**
 * A factory for creating WorldBankQuery objects.
 */
public class WorldBankQueryFactory {

    /**
     * Instantiates a new world bank query factory.
     */
	private WorldBankQueryFactory() {
    }
	
    /**
     * New instance.
     * 
     * @return the world bank query factory
     */
    public static WorldBankQueryFactory newInstance() {
        return new WorldBankQueryFactory();
    }
    
    /**
     * Creates a new WorldBankQuery object.
     * 
     * @return the source query
     */
    public SourceQuery createSourceQuery() {
    	return new SourceQueryImpl();
    }

    /**
     * Creates a new WorldBankQuery object.
     * 
     * @return the country query
     */
    public CountryQuery createCountryQuery() {
    	return new CountryQueryImpl();
    }
    
    /**
     * Creates a new WorldBankQuery object.
     * 
     * @return the income level query
     */
    public IncomeLevelQuery createIncomeLevelQuery() {
    	return new IncomeLevelQueryImpl();
    }
    
    /**
     * Creates a new WorldBankQuery object.
     * 
     * @return the indicator query
     */
    public IndicatorQuery createIndicatorQuery() {
    	return new IndicatorQueryImpl();
    }

    /**
     * Creates a new WorldBankQuery object.
     * 
     * @return the lending type query
     */
    public LendingTypeQuery createLendingTypeQuery() {
    	return new LendingTypeQueryImpl();
    }
    
    /**
     * Creates a new WorldBankQuery object.
     * 
     * @return the topic query
     */
    public TopicQuery createTopicQuery() {
    	return new TopicQueryImpl();
    }
}

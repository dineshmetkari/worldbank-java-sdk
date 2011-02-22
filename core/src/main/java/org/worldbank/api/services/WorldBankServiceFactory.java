/*
 * Copyright 2010 Nabeel Mukhtar 
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

import org.worldbank.api.services.impl.OrganizationServiceImpl;




/**
 * A factory for creating GitHubService objects.
 */
public class WorldBankServiceFactory {

    /**
	 * Instantiates a new git hub service factory.
	 */
	private WorldBankServiceFactory() {
    }
	
    /**
	 * New instance.
	 * 
	 * @return the git hub service factory
	 */
    public static WorldBankServiceFactory newInstance() {
        return new WorldBankServiceFactory();
    }
    
    /**
	 * Creates a new GitHubService object.
	 * 
	 * @return the organization service
	 */
    public OrganizationService createOrganizationService() {
    	return new OrganizationServiceImpl();
    }
}

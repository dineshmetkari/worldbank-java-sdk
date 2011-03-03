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

import org.worldbank.api.common.PagedList;

/**
 * The Interface WorldBankQuery.
 */
public interface WorldBankQuery<E> extends WorldBankCommunicator {
	
	/**
	 * Single result.
	 * 
	 * @return the e
	 */
	public E singleResult();

	/**
	 * List.
	 * 
	 * @return the paged list< e>
	 */
	public PagedList<E> list();
	
	/**
	 * Reset.
	 */
//	public void addResonseHandler(AsyncResponseHandler<List<T>> handler);
	
	/**
	 * Reset.
	 */
	public void reset();

}

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
package org.worldbank.api.common;

import java.util.List;

/**
 * The Interface PagedList.
 */
public interface PagedList<E> extends List<E> {
	
	/**
	 * The Class Page.
	 */
	public class Page {
		
		/** The start. */
		private int start;
		
		/** The label. */
		private int label;
		
		/**
		 * Gets the start.
		 * 
		 * @return the start
		 */
		public int getStart() {
			return start;
		}
		
		/**
		 * Sets the start.
		 * 
		 * @param start the new start
		 */
		public void setStart(int start) {
			this.start = start;
		}
		
		/**
		 * Gets the label.
		 * 
		 * @return the label
		 */
		public int getLabel() {
			return label;
		}
		
		/**
		 * Sets the label.
		 * 
		 * @param label the new label
		 */
		public void setLabel(int label) {
			this.label = label;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Page [label=" + label + ", start=" + start + "]";
		}
	}
	
	
	/**
	 * Gets the pages.
	 * 
	 * @return the pages
	 */
	public List<Page> getPages();
	
	/**
	 * Gets the estimated result count.
	 * 
	 * @return the estimated result count
	 */
	public long getEstimatedResultCount();
	
	/**
	 * Gets the current page index.
	 * 
	 * @return the current page index
	 */
	public int getCurrentPageIndex();
	
	/**
	 * Gets the more results url.
	 * 
	 * @return the more results url
	 */
	public String getMoreResultsUrl();
}

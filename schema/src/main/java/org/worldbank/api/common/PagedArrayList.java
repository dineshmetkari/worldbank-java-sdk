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

import java.util.ArrayList;
import java.util.List;


/**
 * The Class PagedArrayList.
 */
public class PagedArrayList<E> extends ArrayList<E> implements PagedList<E> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5011544152511118680L;
	
	/** The cursor. */
	private Cursor cursor = new Cursor();
	
	/**
	 * Gets the cursor.
	 * 
	 * @return the cursor
	 */
	public Cursor getCursor() {
		return cursor;
	}
	
	/**
	 * Sets the cursor.
	 * 
	 * @param cursor the new cursor
	 */
	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
	}
	
	/* (non-Javadoc)
	 * @see org.worldbank.api.common.PagedList#getPages()
	 */
	public List<Page> getPages() {
		return cursor.getPages();
	}
	
	/* (non-Javadoc)
	 * @see org.worldbank.api.common.PagedList#getEstimatedResultCount()
	 */
	public long getEstimatedResultCount() {
		return cursor.getEstimatedResultCount();
	}
	
	/* (non-Javadoc)
	 * @see org.worldbank.api.common.PagedList#getCurrentPageIndex()
	 */
	public int getCurrentPageIndex() {
		return cursor.getCurrentPageIndex();
	}
	
	/* (non-Javadoc)
	 * @see org.worldbank.api.common.PagedList#getMoreResultsUrl()
	 */
	public String getMoreResultsUrl() {
		return cursor.getMoreResultsUrl();
	}
	
	/**
	 * The Class Cursor.
	 */
	public static class Cursor {
		
		/** The pages. */
		private List<Page> pages = new ArrayList<Page>();
		
		/** The estimated result count. */
		private long estimatedResultCount;
		
		/** The current page index. */
		private int currentPageIndex;
		
		/** The more results url. */
		private String moreResultsUrl;
		
		/**
		 * Gets the pages.
		 * 
		 * @return the pages
		 */
		public List<Page> getPages() {
			return pages;
		}
		
		/**
		 * Sets the pages.
		 * 
		 * @param pages the new pages
		 */
		public void setPages(List<Page> pages) {
			this.pages = pages;
		}
		
		/**
		 * Gets the estimated result count.
		 * 
		 * @return the estimated result count
		 */
		public long getEstimatedResultCount() {
			return estimatedResultCount;
		}
		
		/**
		 * Sets the estimated result count.
		 * 
		 * @param estimatedResultCount the new estimated result count
		 */
		public void setEstimatedResultCount(long estimatedResultCount) {
			this.estimatedResultCount = estimatedResultCount;
		}
		
		/**
		 * Gets the current page index.
		 * 
		 * @return the current page index
		 */
		public int getCurrentPageIndex() {
			return currentPageIndex;
		}
		
		/**
		 * Sets the current page index.
		 * 
		 * @param currentPageIndex the new current page index
		 */
		public void setCurrentPageIndex(int currentPageIndex) {
			this.currentPageIndex = currentPageIndex;
		}
		
		/**
		 * Gets the more results url.
		 * 
		 * @return the more results url
		 */
		public String getMoreResultsUrl() {
			return moreResultsUrl;
		}
		
		/**
		 * Sets the more results url.
		 * 
		 * @param moreResultsUrl the new more results url
		 */
		public void setMoreResultsUrl(String moreResultsUrl) {
			this.moreResultsUrl = moreResultsUrl;
		}
	}
}

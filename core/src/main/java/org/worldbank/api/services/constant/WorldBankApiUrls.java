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
package org.worldbank.api.services.constant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.worldbank.api.schema.ValueEnum;


/**
 * The Class GitHubApiUrls.
 */
public final class WorldBankApiUrls {

    /** The Constant API_URLS_FILE. */
    public static final String API_URLS_FILE = "WorldBankApiUrls.properties";

    /** The Constant logger. */
    private static final Logger logger = Logger.getLogger(WorldBankApiUrls.class.getCanonicalName());
    
    /** The Constant gitHubApiUrls. */
    private static final Properties worldBankApiUrls = new Properties();

    static {
        try {
            worldBankApiUrls.load(WorldBankApiUrls.class.getResourceAsStream(API_URLS_FILE));
        } catch (IOException e) {
        	logger.log(Level.SEVERE, "An error occurred while loading urls.", e);
        }
    }
    
    /** The Constant GET_ORGANIZATION_URL. */
    public static final String GET_ORGANIZATION_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.getOrganization");
    
    /** The Constant GET_ORGANIZATIONS_URL. */
    public static final String GET_ORGANIZATIONS_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.getOrganizations");
    
    /** The Constant UPDATE_ORGANIZATION_URL. */
    public static final String UPDATE_ORGANIZATION_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.updateOrganization");
    
    /** The Constant GET_ALL_REPOSITORIES_URL. */
    public static final String GET_ALL_REPOSITORIES_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.getAllRepositories");

    /** The Constant GET_PUBLIC_REPOSITORIES_URL. */
    public static final String GET_PUBLIC_REPOSITORIES_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.getPublicRepositories");

    /** The Constant GET_PUBLIC_MEMBERS_URL. */
    public static final String GET_PUBLIC_MEMBERS_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.getPublicMembers");

    /** The Constant GET_TEAMS_URL. */
    public static final String GET_TEAMS_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.getTeams");

    /** The Constant CREATE_TEAM_URL. */
    public static final String CREATE_TEAM_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.createTeam");

    /** The Constant GET_TEAM_URL. */
    public static final String GET_TEAM_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.getTeam");

    /** The Constant UPDATE_TEAM_URL. */
    public static final String UPDATE_TEAM_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.updateTeam");

    /** The Constant DELETE_TEAM_URL. */
    public static final String DELETE_TEAM_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.deleteTeam");

    /** The Constant GET_TEAM_MEMBERS_URL. */
    public static final String GET_TEAM_MEMBERS_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.getTeamMembers");

    /** The Constant ADD_TEAM_MEMBER_URL. */
    public static final String ADD_TEAM_MEMBER_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.addTeamMember");

    /** The Constant REMOVE_TEAM_MEMBER_URL. */
    public static final String REMOVE_TEAM_MEMBER_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.removeTeamMember");
    
    /** The Constant GET_TEAM_REPOSITORIES_URL. */
    public static final String GET_TEAM_REPOSITORIES_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.getTeamRepositories");

    /** The Constant ADD_TEAM_REPOSITORY_URL. */
    public static final String ADD_TEAM_REPOSITORY_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.addTeamRepository");
    
    /** The Constant REMOVE_TEAM_REPOSITORY_URL. */
    public static final String REMOVE_TEAM_REPOSITORY_URL = worldBankApiUrls.getProperty("com.github.api.v2.services.organizationService.removeTeamRepository");
    
    /**
	 * Instantiates a new git hub api urls.
	 */
    private WorldBankApiUrls() {}

    /**
	 * The Class GitHubApiUrlBuilder.
	 */
    public static class GitHubApiUrlBuilder {
        
        /** The Constant API_URLS_PLACEHOLDER_START. */
        private static final char API_URLS_PLACEHOLDER_START = '{';

        /** The Constant API_URLS_PLACEHOLDER_END. */
        private static final char API_URLS_PLACEHOLDER_END = '}';
        
    	/** The url format. */
	    private String urlFormat;
	    
    	/** The parameters map. */
	    private Map<String, String> parametersMap = new HashMap<String, String>();
    	
		/** The fields map. */
		private Map<String, String> fieldsMap = new HashMap<String, String>();
	    
    	/**
		 * Instantiates a new git hub api url builder.
		 * 
		 * @param urlFormat
		 *            the url format
		 */
	    public GitHubApiUrlBuilder(String urlFormat) {
	    	this(urlFormat, ApplicationConstants.DEFAULT_API_VERSION, ApplicationConstants.DEFAULT_FORMAT);
    	}
    	
    	/**
		 * Instantiates a new git hub api url builder.
		 * 
		 * @param urlFormat
		 *            the url format
		 * @param apiVersion
		 *            the api version
		 * @param format
		 *            the format
		 */
	    public GitHubApiUrlBuilder(String urlFormat, String apiVersion, String format) {
    		this.urlFormat = urlFormat;
    		fieldsMap.put(ParameterNames.VERSION, apiVersion);
    		fieldsMap.put(ParameterNames.FORMAT, format);
    	}
	    
    	/**
		 * With parameter.
		 * 
		 * @param name
		 *            the name
		 * @param value
		 *            the value
		 * 
		 * @return the git hub api url builder
		 */
	    public GitHubApiUrlBuilder withParameter(String name, String value) {
	    	if (value != null && value.length() > 0) {
	    		parametersMap.put(name, encodeUrl(value));
	    	}
    		
    		return this;
    	}
    	
    	/**
		 * With parameter enum.
		 * 
		 * @param name
		 *            the name
		 * @param value
		 *            the value
		 * 
		 * @return the git hub api url builder
		 */
	    public GitHubApiUrlBuilder withParameterEnum(String name, ValueEnum value) {
	    	withParameter(name, value.value());
    		
    		return this;
    	}
	    
    	/**
		 * With parameter enum set.
		 * 
		 * @param name
		 *            the name
		 * @param enumSet
		 *            the enum set
		 * @param separator
		 *            the separator
		 * 
		 * @return the git hub api url builder
		 */
	    public GitHubApiUrlBuilder withParameterEnumSet(String name, Set<? extends ValueEnum> enumSet, String separator) {
	    	StringBuilder builder = new StringBuilder();
	    	
	    	for (Iterator<? extends ValueEnum> iterator = enumSet.iterator(); iterator.hasNext();) {
	    		builder.append(encodeUrl(iterator.next().value()));
	    		if (iterator.hasNext()) {
	    			builder.append(separator);
	    		}
			}
	    	
	    	parametersMap.put(name, builder.toString());
	    	
    		return this;
    	}
	    
		/**
		 * With empty field.
		 * 
		 * @param name
		 *            the name
		 * 
		 * @return the git hub api url builder
		 */
		public GitHubApiUrlBuilder withEmptyField(String name) {
			fieldsMap.put(name, "");

			return this;
		}

		/**
		 * With field.
		 * 
		 * @param name
		 *            the name
		 * @param value
		 *            the value
		 * 
		 * @return the git hub api url builder
		 */
		public GitHubApiUrlBuilder withField(String name, String value) {
			withField(name, value, false);

			return this;
		}

		/**
		 * With field.
		 * 
		 * @param name
		 *            the name
		 * @param value
		 *            the value
		 * @param escape
		 *            the escape
		 * 
		 * @return the git hub api url builder
		 */
		public GitHubApiUrlBuilder withField(String name, String value,
				boolean escape) {
			if (escape) {
				fieldsMap.put(name, encodeUrl(value));
			} else {
				fieldsMap.put(name, value);
			}

			return this;
		}

		/**
		 * With field enum.
		 * 
		 * @param name
		 *            the name
		 * @param value
		 *            the value
		 * 
		 * @return the git hub api url builder
		 */
		public GitHubApiUrlBuilder withFieldEnum(String name, ValueEnum value) {
			if (value.value() == null || value.value().length() == 0) {
				fieldsMap.put(name, "");
			} else {
				fieldsMap.put(name, value.value());
			}

			return this;
		}
	    
    	
		/**
		 * Builds the url.
		 * 
		 * @return the string
		 */
		public String buildUrl() {
			StringBuilder urlBuilder = new StringBuilder();
			StringBuilder placeHolderBuilder = new StringBuilder();
			boolean placeHolderFlag = false;
			boolean firstParameter = true;
			for (int i = 0; i < urlFormat.length(); i++) {
				if (urlFormat.charAt(i) == API_URLS_PLACEHOLDER_START) {
					placeHolderBuilder = new StringBuilder();
					placeHolderFlag = true;
				} else if (placeHolderFlag
						&& urlFormat.charAt(i) == API_URLS_PLACEHOLDER_END) {
					String placeHolder = placeHolderBuilder.toString();
					if (fieldsMap.containsKey(placeHolder)) {
						urlBuilder.append(fieldsMap.get(placeHolder));
					} else if (parametersMap.containsKey(placeHolder)) {
						StringBuilder builder = new StringBuilder();
						if (firstParameter) {
							firstParameter = false;
						} else {
							builder.append("&");
						}
						builder.append(placeHolder);
						builder.append("=");
						builder.append(parametersMap.get(placeHolder));
						urlBuilder.append(builder.toString());
					} else {
						// we did not find a binding for the placeholder.
						// skip it.
						// urlBuilder.append(API_URLS_PLACEHOLDER_START);
						// urlBuilder.append(placeHolder);
						// urlBuilder.append(API_URLS_PLACEHOLDER_END);
					}
					placeHolderFlag = false;
				} else if (placeHolderFlag) {
					placeHolderBuilder.append(urlFormat.charAt(i));
				} else {
					urlBuilder.append(urlFormat.charAt(i));
				}
			}


			logger.log(Level.FINE, "URL generated: " + urlBuilder.toString());
			
			return urlBuilder.toString();
		}
    	
        /**
		 * Encode url.
		 * 
		 * @param original
		 *            the original
		 * 
		 * @return the string
		 */
        private static String encodeUrl(String original) {
        	try {
    			return URLEncoder.encode(original, ApplicationConstants.CONTENT_ENCODING);
    		} catch (UnsupportedEncodingException e) {
    			// should never be here..
    			return original;
    		}
        }
    }
}

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
package org.worldbank.api.services.impl;

import org.worldbank.api.schema.Source;
import org.worldbank.api.services.SourceQuery;
import org.worldbank.api.services.constant.WorldBankApiUrls;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * The Class SourceQueryImpl.
 */
public class SourceQueryImpl extends BaseWorldBankQuery<Source> implements
		SourceQuery {

	/* (non-Javadoc)
	 * @see org.worldbank.api.services.WorldBankQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = createWorldBankApiUrlBuilder(WorldBankApiUrls.SOURCES_URL);
	}

	/* (non-Javadoc)
	 * @see org.worldbank.api.services.impl.BaseWorldBankQuery#unmarshall(com.google.gson.JsonElement)
	 */
	@Override
	protected Source unmarshall(JsonElement response) {
		Gson gson = getGsonBuilder().create();
		return gson.fromJson(response, Source.class);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#addTeamMember(java.lang.String, java.lang.String)
	 */
//	@Override
//	public void addTeamMember(String teamId, String userName) {
//		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.ADD_TEAM_MEMBER_URL);
//        String                apiUrl  = builder.withField(ParameterNames.TEAM_ID, teamId).buildUrl();
//        Map<String, String> parameters = new HashMap<String, String>();
//        parameters.put(ParameterNames.NAME, userName);
//        unmarshall(callApiPost(apiUrl, parameters));
//	}
}

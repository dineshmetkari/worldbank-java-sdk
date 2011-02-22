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
package org.worldbank.api.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.worldbank.api.schema.Organization;
import org.worldbank.api.schema.Permission;
import org.worldbank.api.schema.Repository;
import org.worldbank.api.schema.Team;
import org.worldbank.api.schema.User;
import org.worldbank.api.services.OrganizationService;
import org.worldbank.api.services.constant.WorldBankApiUrls;
import org.worldbank.api.services.constant.ParameterNames;
import org.worldbank.api.services.constant.WorldBankApiUrls.GitHubApiUrlBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * The Class OrganizationServiceImpl.
 */
public class OrganizationServiceImpl extends BaseWorldBankService implements
		OrganizationService {

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#addTeamMember(java.lang.String, java.lang.String)
	 */
	@Override
	public void addTeamMember(String teamId, String userName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.ADD_TEAM_MEMBER_URL);
        String                apiUrl  = builder.withField(ParameterNames.TEAM_ID, teamId).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.NAME, userName);
        unmarshall(callApiPost(apiUrl, parameters));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#addTeamRepository(java.lang.String, java.lang.String)
	 */
	@Override
	public void addTeamRepository(String teamId, String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.ADD_TEAM_REPOSITORY_URL);
        String                apiUrl  = builder.withField(ParameterNames.TEAM_ID, teamId).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.NAME, userName + "/" + repositoryName);
        unmarshall(callApiPost(apiUrl, parameters));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#createTeam(com.github.api.v2.schema.Team)
	 */
	@Override
	public Team createTeam(String organizationName, String teamName, Permission permission, List<String> repoNames) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.CREATE_TEAM_URL);
        String                apiUrl  = builder.withField(ParameterNames.ORGANIZATION_NAME, organizationName).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("team[" + ParameterNames.NAME + "]", teamName);
        parameters.put("team[" + ParameterNames.PERMISSION + "]", permission.value());
        for (String repoName : repoNames) {
            parameters.put("team[" + ParameterNames.REPO_NAMES + "][]", repoName);
		}
        JsonObject json = unmarshall(callApiPost(apiUrl, parameters));
        
        return unmarshall(new TypeToken<Team>(){}, json.get("team"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#deleteTeam(java.lang.String)
	 */
	@Override
	public void deleteTeam(String teamId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.DELETE_TEAM_URL);
        String                apiUrl  = builder.withField(ParameterNames.TEAM_ID, teamId).buildUrl();
        callApiDelete(apiUrl);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#getAllOrganizationRepositories()
	 */
	@Override
	public List<Repository> getAllOrganizationRepositories() {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.GET_ALL_REPOSITORIES_URL);
        String                apiUrl  = builder.buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.get("repositories"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#getOrganization(java.lang.String)
	 */
	@Override
	public Organization getOrganization(String name) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.GET_ORGANIZATION_URL);
        String                apiUrl  = builder.withField(ParameterNames.ORGANIZATION_NAME, name).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
		Gson gson = getGsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		return gson.fromJson(json.get("organization"), new TypeToken<Organization>(){}.getType());
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#getPublicMembers(java.lang.String)
	 */
	@Override
	public List<User> getPublicMembers(String organizationName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.GET_PUBLIC_MEMBERS_URL);
        String                apiUrl  = builder.withField(ParameterNames.ORGANIZATION_NAME, organizationName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<User>>(){}, json.get("users"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#getPublicRepositories(java.lang.String)
	 */
	@Override
	public List<Repository> getPublicRepositories(String organizationName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.GET_PUBLIC_REPOSITORIES_URL);
        String                apiUrl  = builder.withField(ParameterNames.ORGANIZATION_NAME, organizationName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.get("repositories"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#getTeam(java.lang.String)
	 */
	@Override
	public Team getTeam(String teamId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.GET_TEAM_URL);
        String                apiUrl  = builder.withField(ParameterNames.TEAM_ID, teamId).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Team>(){}, json.get("team"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#getTeamMembers(java.lang.String)
	 */
	@Override
	public List<User> getTeamMembers(String teamId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.GET_TEAM_MEMBERS_URL);
        String                apiUrl  = builder.withField(ParameterNames.TEAM_ID, teamId).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<User>>(){}, json.get("users"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#getTeamRepositories(java.lang.String)
	 */
	@Override
	public List<Repository> getTeamRepositories(String teamId) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.GET_TEAM_REPOSITORIES_URL);
        String                apiUrl  = builder.withField(ParameterNames.TEAM_ID, teamId).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Repository>>(){}, json.get("repositories"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#getTeams(java.lang.String)
	 */
	@Override
	public List<Team> getTeams(String organizationName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.GET_TEAMS_URL);
        String                apiUrl  = builder.withField(ParameterNames.ORGANIZATION_NAME, organizationName).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Team>>(){}, json.get("teams"));
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#getUserOrganizations()
	 */
	@Override
	public List<Organization> getUserOrganizations() {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.GET_ORGANIZATIONS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<List<Organization>>(){}, json.get("organizations"));
	}
	
	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#removeTeamMember(java.lang.String, java.lang.String)
	 */
	@Override
	public void removeTeamMember(String teamId, String userName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.REMOVE_TEAM_MEMBER_URL);
        String                apiUrl  = builder.withField(ParameterNames.TEAM_ID, teamId).withParameter(ParameterNames.NAME, userName).buildUrl();
        callApiDelete(apiUrl);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#removeTeamRepository(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void removeTeamRepository(String teamId, String userName, String repositoryName) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.REMOVE_TEAM_REPOSITORY_URL);
        String                apiUrl  = builder.withField(ParameterNames.TEAM_ID, teamId).withParameter(ParameterNames.NAME, userName + "/" + repositoryName).buildUrl();
        callApiDelete(apiUrl);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#updateOrganization(com.github.api.v2.schema.Organization)
	 */
	@Override
	public void updateOrganization(Organization organization) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.UPDATE_ORGANIZATION_URL);
        String                apiUrl  = builder.withField(ParameterNames.ORGANIZATION_NAME, organization.getName()).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("organization[" + ParameterNames.NAME + "]", organization.getName());
        parameters.put("organization[" + ParameterNames.EMAIL + "]", organization.getEmail());
        parameters.put("organization[" + ParameterNames.BLOG + "]", organization.getBlog());
        parameters.put("organization[" + ParameterNames.COMPANY + "]", organization.getCompany());
        parameters.put("organization[" + ParameterNames.LOCATION + "]", organization.getLocation());
        parameters.put("organization[" + ParameterNames.BILLING_EMAIL + "]", organization.getBillingEmail());
        callApiPost(apiUrl, parameters);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.OrganizationService#updateTeam(com.github.api.v2.schema.Team)
	 */
	@Override
	public void updateTeam(Team team) {
		GitHubApiUrlBuilder builder = createGitHubApiUrlBuilder(WorldBankApiUrls.UPDATE_TEAM_URL);
		String                apiUrl  = builder.withField(ParameterNames.TEAM_ID, team.getId()).buildUrl();
		
        callApiMethod(apiUrl, getGsonBuilder().create().toJson(team), "application/json", "PUT", 200);
	}
}

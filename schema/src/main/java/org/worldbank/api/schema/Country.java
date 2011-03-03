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
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.03 at 06:25:04 PM GMT+05:00 
//


package org.worldbank.api.schema;

/**
 * The Class Country.
 */
public class Country extends SchemaEntity {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8704389217990381580L;
	
	/** The iso2 code. */
	protected String iso2Code;
    
    /** The name. */
    protected String name;
    
    /** The region. */
    protected Region region;
    
    /** The adminregion. */
    protected Adminregion adminregion;
    
    /** The income level. */
    protected IncomeLevel incomeLevel;
    
    /** The lending type. */
    protected LendingType lendingType;
    
    /** The capital city. */
    protected String capitalCity;
    
    /** The longitude. */
    protected String longitude;
    
    /** The latitude. */
    protected String latitude;
    
    /** The id. */
    protected String id;

    /**
     * Gets the iso2 code.
     * 
     * @return the iso2 code
     */
    public String getIso2Code() {
        return iso2Code;
    }

    /**
     * Sets the iso2 code.
     * 
     * @param value the new iso2 code
     */
    public void setIso2Code(String value) {
        this.iso2Code = value;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * 
     * @param value the new name
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the region.
     * 
     * @return the region
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Sets the region.
     * 
     * @param value the new region
     */
    public void setRegion(Region value) {
        this.region = value;
    }

    /**
     * Gets the adminregion.
     * 
     * @return the adminregion
     */
    public Adminregion getAdminregion() {
        return adminregion;
    }

    /**
     * Sets the adminregion.
     * 
     * @param value the new adminregion
     */
    public void setAdminregion(Adminregion value) {
        this.adminregion = value;
    }

    /**
     * Gets the income level.
     * 
     * @return the income level
     */
    public IncomeLevel getIncomeLevel() {
        return incomeLevel;
    }

    /**
     * Sets the income level.
     * 
     * @param value the new income level
     */
    public void setIncomeLevel(IncomeLevel value) {
        this.incomeLevel = value;
    }

    /**
     * Gets the lending type.
     * 
     * @return the lending type
     */
    public LendingType getLendingType() {
        return lendingType;
    }

    /**
     * Sets the lending type.
     * 
     * @param value the new lending type
     */
    public void setLendingType(LendingType value) {
        this.lendingType = value;
    }

    /**
     * Gets the capital city.
     * 
     * @return the capital city
     */
    public String getCapitalCity() {
        return capitalCity;
    }

    /**
     * Sets the capital city.
     * 
     * @param value the new capital city
     */
    public void setCapitalCity(String value) {
        this.capitalCity = value;
    }

    /**
     * Gets the longitude.
     * 
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude.
     * 
     * @param value the new longitude
     */
    public void setLongitude(String value) {
        this.longitude = value;
    }

    /**
     * Gets the latitude.
     * 
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude.
     * 
     * @param value the new latitude
     */
    public void setLatitude(String value) {
        this.latitude = value;
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param value the new id
     */
    public void setId(String value) {
        this.id = value;
    }

}

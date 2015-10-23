/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.bcnet.portlet.biobank.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bcnet.portlet.biobank.NoSuchSampleException;
import com.bcnet.portlet.biobank.model.Sample;
import com.bcnet.portlet.biobank.service.base.SampleLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.TermQuery;
import com.liferay.portal.kernel.search.TermQueryFactoryUtil;
import com.liferay.portal.kernel.search.TermRangeQuery;
import com.liferay.portal.kernel.search.TermRangeQueryFactoryUtil;
import com.liferay.portal.kernel.search.facet.MultiValueFacet;

/**
 * The implementation of the sample local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.service.SampleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.base.SampleLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.SampleLocalServiceUtil
 */
public class SampleLocalServiceImpl extends SampleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bcnet.portlet.biobank.service.SampleLocalServiceUtil} to access the sample local service.
	 */
	
	public Hits search(long companyId, String keywords) throws SearchException{
		System.out.println("-----SampleLocalServiceImpl search called------");
		
		SearchContext searchContext = new SearchContext();
		//searchContext.setAndSearch(false);
		
		
		Map<String, Serializable> attributes = new HashMap<String, Serializable>();
		
		attributes.put("sampleCollectionName", keywords);
		attributes.put("biobankName", keywords);
		attributes.put("materialType", keywords);
		attributes.put("container", keywords);
		attributes.put("storageTemperature", keywords);
		attributes.put("sampledTime", keywords);
		attributes.put("anatomicalPartOntology", keywords);
		attributes.put("anatomicalPartOntologyVersion", keywords);
		attributes.put("anatomicalPartOntologyCode", keywords);
		attributes.put("anatomicalPartOntologyDescription", keywords);
		attributes.put("anatomicalPartFreeText", keywords);
		attributes.put("sex", keywords);
		attributes.put("ageLow", keywords);
		attributes.put("ageHigh", keywords);
		attributes.put("ageUnit", keywords);
		attributes.put("diseaseOntology", keywords);
		attributes.put("diseaseOntologyVersion", keywords);
		attributes.put("diseaseOntologyCode", keywords);
		attributes.put("diseaseOntologyDescription", keywords);
		attributes.put("diseaseFreeText", keywords);
		attributes.put("countryOfOrigin", keywords);

		searchContext.setAttributes(attributes);
		searchContext.setCompanyId(companyId);
		searchContext.setKeywords(keywords);
		System.out.println(searchContext.getAttributes());
        
		QueryConfig queryConfig = new QueryConfig();
		
		queryConfig.setHighlightEnabled(false);
		queryConfig.setScoreEnabled(false);
		//searchContext.setAttribute("materialType:", keywords);
		searchContext.setQueryConfig(queryConfig);
		
		BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
		 
		TermQuery termQuery = TermQueryFactoryUtil.create(searchContext, "materialType", keywords);
		TermQuery termQuery1 = TermQueryFactoryUtil.create(searchContext, "container", keywords);
		TermQuery termQuery2 = TermQueryFactoryUtil.create(searchContext, "anatomicalPartFreeText", keywords);
		TermRangeQuery termRangeQuery = TermRangeQueryFactoryUtil.create(searchContext, "materialType", "blood", "plasma", true, true);
		
		try {
			searchQuery.add(termQuery, BooleanClauseOccur.SHOULD);
			searchQuery.add(termQuery1, BooleanClauseOccur.SHOULD);
			searchQuery.add(termQuery2, BooleanClauseOccur.SHOULD);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(searchContext.getCompanyId());
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
				Sample.class);
		System.out.println("-----SampleLocalServiceImpl search called------"+indexer.getFullQuery(searchContext));
		System.out.println("-----SampleLocalServiceImpl search called------"+indexer);
		System.out.println(termQuery.toString());
		System.out.println(termQuery1.toString());
		System.out.println(termQuery2.toString());
		System.out.println(termRangeQuery.toString());
		return SearchEngineUtil.search(searchContext, searchQuery);
		//return indexer.search(searchContext);
	}
	
	public Sample addSample(Sample sample) throws SystemException{
		System.out.println("-----SampleLocalServiceImpl addSample called------");
		Sample s = super.addSample(sample);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
				Sample.class);

		try {
			indexer.reindex(s);
		} catch (SearchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public Sample deleteSample(long sampleDbId) throws NoSuchSampleException, SystemException{
		System.out.println("-----SampleLocalServiceImpl deleteSample called------");
		Sample sample = samplePersistence.remove(sampleDbId);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
				Sample.class);

		try {
			indexer.delete(sample);
		} catch (SearchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sample;
		
	}
	
	public void deleteSamplesByuuid(String uuid){
		try {
			samplePersistence.removeByuuid(uuid);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Sample> getSamplesByuuid(String uuid){
		try {
			return samplePersistence.findByuuid(uuid);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
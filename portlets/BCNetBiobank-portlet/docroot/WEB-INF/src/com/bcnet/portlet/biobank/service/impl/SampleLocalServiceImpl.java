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
import java.util.Map.Entry;

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
import com.liferay.portal.kernel.search.TokenizerUtil;
import com.liferay.portal.kernel.search.facet.Facet;
import com.liferay.portal.kernel.search.facet.MultiValueFacet;
import com.liferay.portal.util.PortalUtil;

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
		searchContext.setAndSearch(false);
		searchContext.setAttribute("paginationType", "more");
        //searchContext.setStart(0);
        //searchContext.setEnd(10);
        
		
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
		searchContext.setKeywords(keywords);
		searchContext.setCompanyId(companyId);
		
		//System.out.println(searchContext.getAttributes());
		System.out.println(searchContext.getCompanyId());
		System.out.println(searchContext.getKeywords());
		
		/*String[] entryClassNames = { Sample.class.getName() };
		searchContext.setEntryClassNames(entryClassNames);
		MultiValueFacet biobankNameFacet = new MultiValueFacet(searchContext);
		biobankNameFacet.setFieldName("biobankName");
		searchContext.addFacet(biobankNameFacet);
		
		MultiValueFacet materialTypeFacet = new MultiValueFacet(searchContext);
		materialTypeFacet.setFieldName("materialType");
		searchContext.addFacet(materialTypeFacet);
		searchContext.setAttribute("materialType", keywords);*/
		//searchContext.setAttribute("entryClassName",Sample.class.getName());
		//searchContext.setEntryClassNames(entryClassNames);
		//searchContext.setAttribute("materialType", keywords);
		System.out.println(searchContext.getAttributes());
		
		//QueryConfig queryConfig = new QueryConfig();
		
		//queryConfig.setHighlightEnabled(true);
		//queryConfig.setScoreEnabled(true);
		//searchContext.setAttribute("materialType:", keywords);
		//searchContext.setQueryConfig(queryConfig);
		
		BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
		
		String[] partskeywords = keywords.split("\\s+");
		
		for(String str: partskeywords){
			TermQuery termQueryBiobankName = TermQueryFactoryUtil.create(searchContext, "biobankName", str);
			TermQuery termQuerySampleCollectionName = TermQueryFactoryUtil.create(searchContext, "sampleCollectionName", str);
			TermQuery termQueryMaterialType = TermQueryFactoryUtil.create(searchContext, "materialType", str);
			TermQuery termQueryContainer = TermQueryFactoryUtil.create(searchContext, "container", str);
			TermQuery termQueryStorageTemperature = TermQueryFactoryUtil.create(searchContext, "storageTemperature", str);
			TermQuery termQueryAnatomicalPartOntology = TermQueryFactoryUtil.create(searchContext, "anatomicalPartOntology", str);
			TermQuery termQueryAnatomicalPartOntologyVersion = TermQueryFactoryUtil.create(searchContext, "anatomicalPartOntologyVersion", str);
			TermQuery termQueryAnatomicalPartOntologyCode = TermQueryFactoryUtil.create(searchContext, "anatomicalPartOntologyCode", str);
			TermQuery termQueryAnatomicalPartOntologyDescription = TermQueryFactoryUtil.create(searchContext, "anatomicalPartOntologyDescription", str);
			TermQuery termQueryAnatomicalPartFreeText = TermQueryFactoryUtil.create(searchContext, "anatomicalPartFreeText", str);
			TermQuery termQuerySex = TermQueryFactoryUtil.create(searchContext, "sex", str);
			TermQuery termQueryDiseaseOntology = TermQueryFactoryUtil.create(searchContext, "diseaseOntology", str);
			TermQuery termQueryDiseaseOntologyVersion = TermQueryFactoryUtil.create(searchContext, "diseaseOntologyVersion", str);
			TermQuery termQueryDiseaseOntologyCode = TermQueryFactoryUtil.create(searchContext, "diseaseOntologyCode", str);
			TermQuery termQueryDiseaseOntologyDescription = TermQueryFactoryUtil.create(searchContext, "diseaseOntologyDescription", str);
			TermQuery termQueryDiseaseFreeText = TermQueryFactoryUtil.create(searchContext, "diseaseFreeText", str);
			TermQuery termQueryCountryOfOrigin = TermQueryFactoryUtil.create(searchContext, "countryOfOrigin", str);
				
			try {
				searchQuery.add(termQueryBiobankName, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQuerySampleCollectionName, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQueryMaterialType, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQueryContainer, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQueryStorageTemperature, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQueryAnatomicalPartOntology, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQueryAnatomicalPartOntologyVersion, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQueryAnatomicalPartOntologyCode, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQueryAnatomicalPartOntologyDescription, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQueryAnatomicalPartFreeText, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQuerySex, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQueryDiseaseOntology, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQueryDiseaseOntologyVersion, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQueryDiseaseOntologyCode, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQueryDiseaseOntologyDescription, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQueryDiseaseFreeText, BooleanClauseOccur.SHOULD);
				searchQuery.add(termQueryCountryOfOrigin, BooleanClauseOccur.SHOULD);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
		
		TermRangeQuery termRangeQuery = TermRangeQueryFactoryUtil.create(searchContext, "materialType", "blood", "plasma", true, true);
		//System.out.println(termQuery2.toString());
		//searchQuery.addRequiredTerm("container", keywords);
		
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
				Sample.class);
		System.out.println("-----SampleLocalServiceImpl search called------"+indexer.getFullQuery(searchContext));
		//System.out.println("-----SampleLocalServiceImpl search called------"+indexer);
		//System.out.println(termQuery.toString());
		//System.out.println(termQuery1.toString());
		//System.out.println(termQuery2.toString());
		//System.out.println(termRangeQuery.toString());
		
		System.out.println(TokenizerUtil.tokenize("materialType", keywords, "EN"));
		System.out.println(searchContext.getFacets());
		for(Entry<String, Facet> facet : searchContext.getFacets().entrySet()){
			System.out.println(facet);
		}
		//return SearchEngineUtil.search(searchContext, searchQuery);
		return indexer.search(searchContext);
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
	
	public List<Sample> getSamplesByBiobankDbId(long biobankDbId){
		try {
			return samplePersistence.findBybiobankDbId(biobankDbId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Sample> getSamplesBySampleCollectionDbId(long sampleCollectionDbId){
		try {
			return samplePersistence.findBysampleCollectionDbId(sampleCollectionDbId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
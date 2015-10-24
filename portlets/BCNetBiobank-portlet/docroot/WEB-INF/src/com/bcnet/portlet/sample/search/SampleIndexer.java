package com.bcnet.portlet.sample.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;

import javax.portlet.PortletURL;



import com.bcnet.portlet.biobank.model.Sample;
import com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleLocalServiceUtil;
import com.bcnet.portlet.biobank.service.persistence.SampleActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;

public class SampleIndexer extends BaseIndexer{

	public static final String[] CLASS_NAMES = { Sample.class.getName() };
	
	//public static final String PORTLET_ID = "sample-lister-search";
	public static final String PORTLET_ID = "samplelistersearch_WAR_BCNetBiobankportlet";
	
	
	@Override
	public String[] getClassNames() {
		// TODO Auto-generated method stub
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		// TODO Auto-generated method stub
		return PORTLET_ID;
	}

	public Hits search(SearchContext searchContext) throws SearchException{
		System.out.println("-----search called from SampleIndexer------");
		return super.search(searchContext);
	}
	
	@Override
	protected void doDelete(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-----doDelete called------");
		Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
		Sample sample = (Sample)obj;

        deleteDocument(company.getCompanyId(), sample.getSampleDbId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-----doGetDocument called------");
		Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
		Sample sample = (Sample)obj;
		
		Document document = getBaseModelDocument(PORTLET_ID, sample);
		
		if(sample.getSampleCollectionDbId() > 0){
			document.addText("sampleCollectionName", SampleCollectionLocalServiceUtil.getSampleCollection(sample.getSampleCollectionDbId()).getName());
		}
		//document.add(new Field("biobankName", BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(sample.getBiobankDbId()).getBiobankName()));
		//document.add(new Field("materialType", sample.getMaterialType()));
		document.addText("biobankName", BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(sample.getBiobankDbId()).getBiobankName());
		document.addKeyword("materialType", sample.getMaterialType());
		document.addKeyword("container", sample.getContainer());
		document.addText("storageTemperature", sample.getStorageTemperature());
		document.addDate("sampledTime", sample.getSampledTime());
		document.addText("anatomicalPartOntology", sample.getAnatomicalPartOntology());
		document.addKeyword("anatomicalPartOntologyVersion", sample.getAnatomicalPartOntologyVersion());
		document.addKeyword("anatomicalPartOntologyCode", sample.getAnatomicalPartOntologyCode());
		document.addText("anatomicalPartOntologyDescription", sample.getAnatomicalPartOntologyDescription());
		document.addText("anatomicalPartFreeText", sample.getAnatomicalPartFreeText());
		document.addKeyword("sex", sample.getSex());
		document.addNumber("ageLow", sample.getAgeLow());
		document.addNumber("ageHigh", sample.getAgeHigh());
		document.addText("ageUnit", sample.getAgeUnit());
		document.addText("diseaseOntology", sample.getDiseaseOntology());
		document.addKeyword("diseaseOntologyVersion", sample.getDiseaseOntologyVersion());
		document.addKeyword("diseaseOntologyCode", sample.getDiseaseOntologyCode());
		document.addText("diseaseOntologyDescription", sample.getDiseaseOntologyDescription());
		document.addText("diseaseFreeText", sample.getDiseaseFreeText());
		document.addKeyword("countryOfOrigin", sample.getCountryOfOrigin());
		document.addNumber(Field.COMPANY_ID, company.getCompanyId());
		document.addNumber(Field.GROUP_ID, company.getGroupId());
		
		return document;
	}

	
	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		addSearchTerm(searchQuery, searchContext, "sampleCollectionName", true);
		addSearchTerm(searchQuery, searchContext, "biobankName", true);
		addSearchTerm(searchQuery, searchContext, "materialType", true);
		addSearchTerm(searchQuery, searchContext, "container", true);
		addSearchTerm(searchQuery, searchContext, "storageTemperature", true);
		addSearchTerm(searchQuery, searchContext, "anatomicalPartOntology", true);
		addSearchTerm(searchQuery, searchContext, "anatomicalPartOntologyVersion", true);
		addSearchTerm(searchQuery, searchContext, "anatomicalPartOntologyCode", true);
		addSearchTerm(searchQuery, searchContext, "anatomicalPartOntologyDescription", true);
		addSearchTerm(searchQuery, searchContext, "anatomicalPartFreeText", true);
		addSearchTerm(searchQuery, searchContext, "sex", true);
		addSearchTerm(searchQuery, searchContext, "ageLow", true);
		addSearchTerm(searchQuery, searchContext, "ageHigh", true);
		addSearchTerm(searchQuery, searchContext, "ageUnit", true);
		addSearchTerm(searchQuery, searchContext, "diseaseOntology", true);
		addSearchTerm(searchQuery, searchContext, "diseaseOntologyVersion", true);
		addSearchTerm(searchQuery, searchContext, "diseaseOntologyCode", true);
		addSearchTerm(searchQuery, searchContext, "diseaseOntologyDescription", true);
		addSearchTerm(searchQuery, searchContext, "diseaseFreeText", true);
		addSearchTerm(searchQuery, searchContext, "countryOfOrigin", true);
		
		LinkedHashMap<String, Object> params =
			(LinkedHashMap<String, Object>)searchContext.getAttribute("params");

		if (params != null) {
			String expandoAttributes = (String)params.get("expandoAttributes");

			if (Validator.isNotNull(expandoAttributes)) {
				addSearchExpando(searchQuery, searchContext, expandoAttributes);
			}
		}
	}
	

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet,
			PortletURL portletURL) throws Exception {
		// TODO Auto-generated method stub
		Summary summary = createSummary(document);

        summary.setMaxContentLength(200);

        return summary;
		
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		// TODO Auto-generated method stub
		Sample sample = (Sample)obj;

         Document document = getDocument(sample);

         Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
         SearchEngineUtil.updateDocument(
                 getSearchEngineId(), company.getCompanyId(), document);
		
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		long companyId = GetterUtil.getLong(ids[0]);

        reindexSamples(companyId);
	}

	protected void reindexSamples(long companyId) throws SystemException, PortalException {
		// TODO Auto-generated method stub
		final Collection<Document> documents = new ArrayList<Document>();

        ActionableDynamicQuery actionableDynamicQuery = new SampleActionableDynamicQuery() {

                @Override
                protected void addCriteria(DynamicQuery dynamicQuery) {
                }

                @Override
                protected void performAction(Object object) throws PortalException {
                        Sample sample = (Sample) object;

                        Document document = getDocument(sample);

                        documents.add(document);
                }

        };

        actionableDynamicQuery.setCompanyId(companyId);

        actionableDynamicQuery.performActions();

        SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId,
                        documents);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		// TODO Auto-generated method stub
		Sample sample = SampleLocalServiceUtil.getSample(classPK);

        doReindex(sample);
		
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		// TODO Auto-generated method stub
		return PORTLET_ID;
	}

}

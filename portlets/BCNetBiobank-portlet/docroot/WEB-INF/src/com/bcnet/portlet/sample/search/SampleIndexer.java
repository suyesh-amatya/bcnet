package com.bcnet.portlet.sample.search;

import java.util.ArrayList;
import java.util.Collection;
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
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;

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
		Sample sample = (Sample)obj;
		
		Document document = getBaseModelDocument(PORTLET_ID, sample);
		
		document.addText("sampleCollectionName", SampleCollectionLocalServiceUtil.getSampleCollection(sample.getSampleCollectionDbId()).getName());
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
		
		return document;
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

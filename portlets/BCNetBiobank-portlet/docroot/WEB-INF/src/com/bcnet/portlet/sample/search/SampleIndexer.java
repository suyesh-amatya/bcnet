package com.bcnet.portlet.sample.search;

import java.util.Locale;

import javax.portlet.PortletURL;

import com.bcnet.portlet.biobank.model.Sample;
import com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;

public class SampleIndexer extends BaseIndexer{

	public static final String[] CLASS_NAMES = { Sample.class.getName() };
	
	public static final String PORTLET_ID = "sample-lister-search";
	
	
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

	@Override
	protected void doDelete(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
		Sample sample = (Sample)arg0;

        deleteDocument(company.getCompanyId(), sample.getSampleDbId());
	}

	@Override
	protected Document doGetDocument(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		Sample sample = (Sample)arg0;
		
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
		document.addNumber("ageHight", sample.getAgeHigh());
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
	protected Summary doGetSummary(Document arg0, Locale arg1, String arg2,
			PortletURL arg3) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doReindex(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doReindex(String[] arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doReindex(String arg0, long arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}

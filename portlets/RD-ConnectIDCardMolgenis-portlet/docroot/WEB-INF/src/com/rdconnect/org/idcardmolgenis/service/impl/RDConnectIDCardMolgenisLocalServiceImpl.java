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

package com.rdconnect.org.idcardmolgenis.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import sun.misc.BASE64Encoder;
import sun.org.mozilla.javascript.internal.json.JsonParser;

import com.liferay.portal.kernel.util.Base64;
import com.rdconnect.org.idcardmolgenis.service.base.RDConnectIDCardMolgenisLocalServiceBaseImpl;

/**
 * The implementation of the r d connect i d card molgenis local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rdconnect.org.idcardmolgenis.service.RDConnectIDCardMolgenisLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author suyeshamatya
 * @see com.rdconnect.org.idcardmolgenis.service.base.RDConnectIDCardMolgenisLocalServiceBaseImpl
 * @see com.rdconnect.org.idcardmolgenis.service.RDConnectIDCardMolgenisLocalServiceUtil
 */
public class RDConnectIDCardMolgenisLocalServiceImpl
extends RDConnectIDCardMolgenisLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rdconnect.org.idcardmolgenis.service.RDConnectIDCardMolgenisLocalServiceUtil} to access the r d connect i d card molgenis local service.
	 */
	private static String LOGIN_URL = "https://molgenis21.target.rug.nl/api/v1/login"; 


	public String getUserCredential() {

		String url = "https://molgenis21.target.rug.nl/api/v1/login";
		System.out.println("Calling Molgenis Login API: " + url);
		try {
			HttpClient c = new DefaultHttpClient();        
			HttpPost p = new HttpPost(url); 

			p.setEntity(new StringEntity("{\"username\":\"" + "user" + "\",\"password\":\"" + "hackathon789" + "\"}", 
					ContentType.create("application/json")));

			HttpResponse r = c.execute(p);

			BufferedReader rd = new BufferedReader(new InputStreamReader(r.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				//Parse our JSON response               
				JSONParser j = new JSONParser();
				JSONObject o = (JSONObject)j.parse(line);

				System.out.println(o.toJSONString());
				String token = (String) o.get("token");
				System.out.println((String) o.get("token"));
				return readData(token);
				//return o.toJSONString();
			}
		}
		catch(ParseException e) {
			System.out.println(e);
		}
		catch(IOException e) {
			System.out.println(e);
		}           
		return "";
	}


	private String readData(String token) {
		String url = "https://molgenis21.target.rug.nl/api/v2/test?aggs=x==Diseases;distinct==ParticipantID&p=biobankid=p=http%3A%2F%2Fcatalogue.rd-connect.eu%2Fweb%2F71542";
		try {
			String cols = "{key: 'Disease Name',sortable: true},";
			cols += "{key: 'Number of Patients, Donors',sortable: true},";
			cols += "{key: 'Gene',sortable: true},";
			cols += "{key: 'ORPHA Code',sortable: true},";
			cols += "{key: 'ICD 10',sortable: true},";
			cols += "{key: 'OMIM',sortable: true},";
			cols += "{key: 'Synonym(s)',sortable: true}";
			HttpClient c = new DefaultHttpClient();        
			HttpGet p = new HttpGet(url);       

			p.addHeader("x-molgenis-token", token);
			HttpResponse r = c.execute(p);
			System.out.println("Request Send");
			BufferedReader rd = new BufferedReader(new InputStreamReader(r.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				//Parse our JSON response      
				System.out.println("Line: " + line);
				JSONParser j = new JSONParser();
				JSONObject o = (JSONObject)j.parse(line);
				JSONObject m = (JSONObject)o.get("aggs");
				JSONArray lx = (JSONArray)m.get("xLabels");
				JSONObject xlabel = (JSONObject)lx.get(0);
				JSONArray matrix = (JSONArray)m.get("matrix");
				JSONArray count = (JSONArray)matrix.get(0);

				String data = "{'Disease Name':'" + (String)xlabel.get("Label") + "',";
				data += "'Number of Patients, Donors':'" + count.get(0)
						+ "',";
				data += "'ORPHA Code':'" + (String)xlabel.get("IRI") + "'}";

				String returnstring = "AUI().use('aui-datatable','aui-datatype','datatable-sort',"
						+ "function(Y){ "
							+ "var remoteData = [" + data + "];"
							+ "var nestedCols = [" + cols + "];"
							+ "var dataTable = new Y.DataTable({"
								+ "columns: nestedCols,data: remoteData}).render('#diseasematrix');"
								+ "dataTable.get('boundingBox').unselectable();});";


						System.out.println(o.toJSONString());
						System.out.println(m.toJSONString());
						return returnstring;
			}
			//return returnstring;
		}
		catch(ParseException e) {
			System.out.println(e);
		}
		catch(IOException e) {
			System.out.println(e);
		}  
		return "";
	}

}
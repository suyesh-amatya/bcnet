package com.rdconnect.org.idcardmolgenis;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.util.bridges.mvc.MVCPortlet;

public class RDConnectIDCardMolgenisPortlet extends MVCPortlet{

	public void test(ActionRequest request, ActionResponse response){
		System.out.println("test");
	}
}

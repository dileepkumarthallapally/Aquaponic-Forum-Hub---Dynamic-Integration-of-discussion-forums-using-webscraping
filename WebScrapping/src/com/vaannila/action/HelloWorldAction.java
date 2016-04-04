package com.vaannila.action;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vaannila.form.HelloWorldForm;

public class HelloWorldAction extends Action {
	static HashMap<String, String>Cats = new HashMap<String, String>();
	private RequestDispatcher rd;
	
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	HelloWorldForm hwForm = (HelloWorldForm) form;
	hwForm.setMessage("Hello World");
	
return mapping.findForward("success");
}
}

package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//mandatory
@RequestMapping("/test") //optional BUT reco.
public class TestController {
	public TestController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	@GetMapping("/test1")//=@RequestMapping : method=GET
	public ModelAndView testMe()
	{
		System.out.println("in test me");
		//return ModelAndView object wrapping logical view nm + model attribute/s
		//o.s.w.s.ModelAndView(String viewName,String modelAttrName,Object value)
		return new ModelAndView("/test/test1", "server_date", LocalDateTime.now());
		//Handler rets M&V to the D.S
		//logical view name : /test/test1 , actual view name reted by V.R (View resolver)  
		//   /WEB-INF/views/test/test1.jsp
	}
}

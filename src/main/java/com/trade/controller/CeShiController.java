package com.trade.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用于测试
 * @author admin
 *
 */
@Controller
@RequestMapping(value="/test")
public class CeShiController {
     
	 Logger log=Logger.getLogger(CeShiController.class);
	   /**
	    * 测试用
	    */
	@RequestMapping(value="/ceshi.do")
	public ModelAndView ceshi(ModelAndView view) throws Exception{
		if(true){
		
			
			    try {
					int n=1/0;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}finally{
					System.out.println("*******************");
				    log.info("大神啊hahahhah+++++++++");
				}
				
		}
		return view;
	}
}

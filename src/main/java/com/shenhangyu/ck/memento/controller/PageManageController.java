/**
 *版权所有©深航渔
 */
package com.shenhangyu.icard.icardweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="控制页面跳转")
@RestController
@RequestMapping("/page")
public class PageManageController {
	@ApiOperation(value="打开页面",httpMethod="POST",notes="打开页面",response=String.class)
	@RequestMapping(value="/icard-page")
	public String getICardInfo(){
		return "/static/icard-info";
	}
}

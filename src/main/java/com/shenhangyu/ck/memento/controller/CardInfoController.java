package com.shenhangyu.icard.icardweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.shenhangyu.icard.icardweb.bean.CardInfoBean;
import com.shenhangyu.icard.icardweb.service.CardInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.websocket.server.PathParam;

/**
 * 版权所有©深航渔
 *卡信息查询Contraller
 * @author Administrator
 * @create 2020-04-12 14:49
 */
@Api(tags="卡号信息相关接口")
@RestController
@RequestMapping("/icard-info")
public class CardInfoController {

	private static Logger logger = LoggerFactory.getLogger(CardInfoController.class);
	
    @Autowired(required = false)
    private CardInfoService CardInfoService;
    
    @ApiOperation(value = "根据卡号更新信息",notes="根据卡号更新信息",httpMethod="POST",response=CardInfoBean.class)
    @PostMapping("/getCardInfoBean")
    public CardInfoBean getCardInfoBean(){
    	logger.info("测试JSON对象转换");
    	List<CardInfoBean> beans = CardInfoService.queryICardInfos();
    	CardInfoBean bean = beans.get(0);
        return bean;
    }
    
    @ApiOperation(value = "根据卡号更新信息",notes="根据卡号更新信息",httpMethod="GET",response=String.class)
    @GetMapping("/cardInfoPage")
    public String cardInfoPage(){
    	logger.info("打开卡信息页面");
        return "cardInfoPage";
    }

    @ApiOperation(value = "根据用户名查询信息",notes="根据用户名查询信息",httpMethod="POST",response=JSONObject.class)
    @ResponseBody
    @PostMapping("/queryCard")
    public JSONObject queryCardinfo(@ApiParam(name="json",value="请求参数为Json对象")@RequestBody JSONObject json){
    	logger.info("进入查询卡号信息controller...........");
        String userZhName = json.getString("userZhName");
        CardInfoBean cardInfoBean = CardInfoService.getCardInfoBean(userZhName);
        JSONObject resObject = JSONObject.parseObject(JSONObject.toJSON(cardInfoBean).toString());
        return resObject;
    }
    @ApiOperation(value = "根据卡号更新信息",notes="根据卡号更新信息",httpMethod="POST",response=JSONObject.class)
    @ResponseBody
    @PostMapping("/updateCard")
    public JSONObject updateCardinfo(@ApiParam(name="json",value="请求参数为Json对象")@RequestBody JSONObject json){
    	logger.info("进入更新卡号信息controller...........");
        String userZhName = json.getString("userZhName");
        CardInfoBean cardInfoBean = CardInfoService.getCardInfoBean(userZhName);
        JSONObject resObject = JSONObject.parseObject(JSONObject.toJSON(cardInfoBean).toString());
        return resObject;
    }
}

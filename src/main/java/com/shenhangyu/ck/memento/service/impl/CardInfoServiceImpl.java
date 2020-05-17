/**
 * 版权所有©深航渔
 */
package com.shenhangyu.ck.memento.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shenhangyu.ck.memento.bean.CardInfoBean;
import com.shenhangyu.ck.memento.mapper.CardInfoMapper;
import com.shenhangyu.ck.memento.service.CardInfoService;

/**
 *描述：
 *@author moshenghang
 *@create 2020/4/13 0013 20:17
 */
@Service
public class CardInfoServiceImpl implements CardInfoService {
	
	private static Logger logger = LoggerFactory.getLogger(CardInfoServiceImpl.class);
	
	@Autowired
	private CardInfoMapper cardInfoMapper;
	
	@Override
    public List<CardInfoBean> queryICardInfos(){
    	logger.info("进入查询全部卡信息服务层..........");
    	List<CardInfoBean> cards = new ArrayList<CardInfoBean>();
    	cards=cardInfoMapper.selectAllCardInfoBeans();
        return cards;
    }

	@Override
	public CardInfoBean getCardInfoBean(String userZhName) {
		logger.info("进入查询单个卡信息服务层..........");
		CardInfoBean bean = new CardInfoBean();
		bean.setCardNo("1234567890123456");
		bean.setUserZhName("test");
		return bean;
	}
}

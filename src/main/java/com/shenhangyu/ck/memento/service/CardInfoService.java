/**
 *版权所有©深航渔渔渔
 */
package com.shenhangyu.ck.memento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shenhangyu.ck.memento.bean.CardInfoBean;


/**
 * 描述:查询卡卡号信息接口
 *
 * @author moshenghang
 * @create 2020/4/13 0013 20:15
 */
@Service
public interface CardInfoService {
	
	public CardInfoBean getCardInfoBean(String userZhName);
	
    public List<CardInfoBean> queryICardInfos();
}

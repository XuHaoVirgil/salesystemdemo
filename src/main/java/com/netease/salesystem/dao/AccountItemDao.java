package com.netease.salesystem.dao;

import java.util.List;

import com.netease.salesystem.pojo.AccountItem;

public interface AccountItemDao {

	List<AccountItem> selectAccountByUserId (Integer userid);
}

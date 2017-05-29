package com.tanpugi.fm.service;

import com.tanpugi.fm.service.model.FriendListReturnModel;
import com.tanpugi.fm.service.model.DefaultReturnModel;
import com.tanpugi.fm.service.model.FriendAddUpdateReturnModel;

public interface FriendService {

	DefaultReturnModel addConnection(String personFrom, String personTo);
	FriendListReturnModel listConnections(String personFrom);
	FriendListReturnModel listCommonConnections(String personFrom1, String personFrom2);
	DefaultReturnModel follow(String followed, String follower);
	DefaultReturnModel unfollow(String followed, String follower);
	FriendAddUpdateReturnModel addUpdate(String sender, String text);

}
 
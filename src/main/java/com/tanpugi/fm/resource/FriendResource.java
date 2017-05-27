package com.tanpugi.fm.resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tanpugi.fm.resource.request.FriendAddRequest;
import com.tanpugi.fm.resource.request.FriendAddUpdateRequest;
import com.tanpugi.fm.resource.request.FriendFollowRequest;
import com.tanpugi.fm.resource.request.FriendListCommonRequest;
import com.tanpugi.fm.resource.request.FriendListRequest;
import com.tanpugi.fm.resource.request.FriendUnfollowRequest;
import com.tanpugi.fm.resource.response.FriendAddResponse;
import com.tanpugi.fm.resource.response.FriendAddUpdateResponse;
import com.tanpugi.fm.resource.response.FriendFollowResponse;
import com.tanpugi.fm.resource.response.FriendListCommonResponse;
import com.tanpugi.fm.resource.response.FriendListResponse;
import com.tanpugi.fm.resource.response.FriendUnfollowResponse;

@RestController
@RequestMapping("/friend")
public class FriendResource {
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public FriendAddResponse add(@RequestBody FriendAddRequest request) {
		FriendAddResponse response = new FriendAddResponse();
		response.setSuccess(true);
		return response;
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="list")
	public FriendListResponse list(@RequestBody FriendListRequest request) {
		FriendListResponse response = new FriendListResponse();
		response.setSuccess(true);
		return response;
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="listcommon")
	public FriendListCommonResponse list(@RequestBody FriendListCommonRequest request) {
		FriendListCommonResponse response = new FriendListCommonResponse();
		response.setSuccess(true);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="follow")
	public FriendFollowResponse follow(@RequestBody FriendFollowRequest request) {
		FriendFollowResponse response = new FriendFollowResponse();
		response.setSuccess(true);
		return response;
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.DELETE, value="follow")
	public FriendUnfollowResponse follow(@RequestBody FriendUnfollowRequest request) {
		FriendUnfollowResponse response = new FriendUnfollowResponse();
		response.setSuccess(true);
		return response;
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="update")
	public FriendAddUpdateResponse follow(@RequestBody FriendAddUpdateRequest request) {
		FriendAddUpdateResponse response = new FriendAddUpdateResponse();
		response.setSuccess(true);
		return response;
	}
}

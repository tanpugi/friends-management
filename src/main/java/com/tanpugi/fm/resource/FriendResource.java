package com.tanpugi.fm.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tanpugi.fm.resource.model.FriendAddRequest;
import com.tanpugi.fm.resource.model.FriendAddResponse;
import com.tanpugi.fm.resource.model.FriendAddUpdateRequest;
import com.tanpugi.fm.resource.model.FriendAddUpdateResponse;
import com.tanpugi.fm.resource.model.FriendFollowRequest;
import com.tanpugi.fm.resource.model.FriendFollowResponse;
import com.tanpugi.fm.resource.model.FriendListCommonRequest;
import com.tanpugi.fm.resource.model.FriendListCommonResponse;
import com.tanpugi.fm.resource.model.FriendListRequest;
import com.tanpugi.fm.resource.model.FriendListResponse;
import com.tanpugi.fm.resource.model.FriendUnfollowRequest;
import com.tanpugi.fm.resource.model.FriendUnfollowResponse;
import com.tanpugi.fm.service.FriendService;
import com.tanpugi.fm.service.model.DefaultReturnModel;
import com.tanpugi.fm.service.model.FriendAddUpdateReturnModel;
import com.tanpugi.fm.service.model.FriendListReturnModel;

@RestController
@RequestMapping("/friend")
public class FriendResource {
	
	@Autowired
	private FriendService friendService;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public FriendAddResponse add(@Valid @RequestBody FriendAddRequest request) {
		String personFrom = request.getFriends().get(0);
		String personTo = request.getFriends().get(1);
		
		DefaultReturnModel returnModel =
			friendService.addConnection(personFrom, personTo);

		FriendAddResponse response = new FriendAddResponse();
		response.initResponse(returnModel);

		return response;
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="list")
	public FriendListResponse list(@Valid @RequestBody FriendListRequest request) {		
		FriendListReturnModel returnModel =
			friendService.listConnections(request.getUser());
	
		FriendListResponse response = new FriendListResponse();
		response.initResponse(returnModel);
		response.setFriends(returnModel.getConnections());
		
		return response;
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="listcommon")
	public FriendListCommonResponse listCommon(@Valid @RequestBody FriendListCommonRequest request) {
		String personFrom1 = request.getFriends().get(0);
		String personFrom2 = request.getFriends().get(1);
		
		FriendListReturnModel returnModel =
			friendService.listCommonConnections(personFrom1, personFrom2);

		FriendListCommonResponse response = new FriendListCommonResponse();
		response.initResponse(returnModel);
		response.setFriends(returnModel.getConnections());
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="follow")
	public FriendFollowResponse follow(@Valid @RequestBody FriendFollowRequest request) {
		DefaultReturnModel returnModel =
				friendService.follow(request.getTarget(), request.getRequestor());

		FriendFollowResponse response = new FriendFollowResponse();
		response.initResponse(returnModel);
		
		return response;
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.DELETE, value="follow")
	public FriendUnfollowResponse unfollow(@Valid @RequestBody FriendUnfollowRequest request) {
		DefaultReturnModel returnModel =
				friendService.unfollow(request.getTarget(), request.getRequestor());
		
		FriendUnfollowResponse response = new FriendUnfollowResponse();
		response.initResponse(returnModel);
		
		return response;
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="update")
	public FriendAddUpdateResponse addUpdate(@Valid @RequestBody FriendAddUpdateRequest request) {
		FriendAddUpdateReturnModel returnModel = friendService.addUpdate(request.getSender(), request.getText());

		FriendAddUpdateResponse response = new FriendAddUpdateResponse();
		response.initResponse(returnModel);
		response.setRecipients(returnModel.getRecipients());

		return response;
	}
}

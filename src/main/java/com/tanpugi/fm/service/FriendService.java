package com.tanpugi.fm.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanpugi.fm.domain.SubscriptionRepository;
import com.tanpugi.fm.domain.FriendConnection;
import com.tanpugi.fm.domain.FriendConnectionRepository;
import com.tanpugi.fm.domain.Subscription;
import com.tanpugi.fm.domain.Update;
import com.tanpugi.fm.domain.UpdateRepository;
import com.tanpugi.fm.service.model.FriendListReturnModel;
import com.tanpugi.fm.service.model.DefaultReturnModel;
import com.tanpugi.fm.service.model.FriendAddUpdateReturnModel;
import com.tanpugi.fm.service.model.ReturnCode;

@Service
public class FriendService {

	@Autowired
	private FriendConnectionRepository connectionRepository;
	@Autowired
	private SubscriptionRepository followerRepository;
	@Autowired
	private UpdateRepository updateRepository;

	public DefaultReturnModel addConnection(
		String personFrom, String personTo) {
		DefaultReturnModel returnModel = new DefaultReturnModel();
		
		if ((connectionRepository.countByPersonFromAndPersonTo(personFrom, personTo) == 0)) {
			FriendConnection entity1 = new FriendConnection();
			entity1.setPersonFrom(personFrom);
			entity1.setPersonTo(personTo);
			connectionRepository.save(entity1);

			FriendConnection entity2 = new FriendConnection();
			entity2.setPersonFrom(personTo);
			entity2.setPersonTo(personFrom);
			connectionRepository.save(entity2);
			
			returnModel.setReturnCode(ReturnCode.OK);
		} else {
			returnModel.setErrorMessage("EXISTS");
			returnModel.setReturnCode(ReturnCode.FAILED);
		}
		
		return returnModel;
	}
	
	public FriendListReturnModel listConnections(String personFrom) {
		FriendListReturnModel returnModel = new FriendListReturnModel();
		List<FriendConnection.PersonTo> persons = connectionRepository.findAllByPersonFrom(personFrom);
		for (FriendConnection.PersonTo person : persons) {
			returnModel.addConnection(person.getPersonTo());
		}
		
		returnModel.setReturnCode(ReturnCode.OK);
		
		return returnModel;
	}
	
	public FriendListReturnModel listCommonConnections(String personFrom1, String personFrom2) {
		FriendListReturnModel returnModel = new FriendListReturnModel();
		
		List<FriendConnection.PersonTo> flist1 = connectionRepository.findAllByPersonFrom(personFrom1);
		List<FriendConnection.PersonTo> flist2 = connectionRepository.findAllByPersonFrom(personFrom2);
		List<FriendConnection.PersonTo> fcommon = getCommonRecords(flist1, flist2);
		for (FriendConnection.PersonTo person : fcommon) {
			returnModel.addConnection(person.getPersonTo());
		}
		
		returnModel.setReturnCode(ReturnCode.OK);
		
		return returnModel;
	}
	
	public DefaultReturnModel follow(String followed, String follower) {
		DefaultReturnModel returnModel = new DefaultReturnModel();
		if (followerRepository.countByFollowedAndFollower(followed, follower) == 0) {
			Subscription fo = new Subscription();
			fo.setFollowed(followed);
			fo.setFollower(follower);
			
			followerRepository.save(fo);

			returnModel.setReturnCode(ReturnCode.OK);
		} else {
			returnModel.setErrorMessage("EXISTS");
			returnModel.setReturnCode(ReturnCode.FAILED);
		}
		
		return returnModel;
	}

	public DefaultReturnModel unfollow(String followed, String follower) {
		DefaultReturnModel returnModel = new DefaultReturnModel();
		Subscription fo = new Subscription();
		fo.setFollowed(followed);
		fo.setFollower(follower);
			
		followerRepository.delete(fo);

		returnModel.setReturnCode(ReturnCode.OK);
		
		return returnModel;
	}
	
	public FriendAddUpdateReturnModel addUpdate(String sender, String text) {
		Update update = new Update();
		update.setSender(sender);
		update.setText(text);

		updateRepository.save(update);
		
		Set<Subscription.Follower> recipients = followerRepository.findAllByFollowed(sender);
		recipients.addAll(getMentions(text));
		
		FriendAddUpdateReturnModel returnModel = new FriendAddUpdateReturnModel();
		for (Subscription.Follower recipient : recipients) {
			returnModel.addRecipient(recipient.getFollower());	
		}
		
		returnModel.setReturnCode(ReturnCode.OK);
		
		return returnModel;
	}
	
	
	private List<FriendConnection.PersonTo> getCommonRecords(List<FriendConnection.PersonTo> list1, List<FriendConnection.PersonTo> list2) {
		Map<FriendConnection.PersonTo, Boolean> dupMap = new HashMap<>();
		list1.stream().forEach((v) -> { dupMap.put(v, false); });
		return list2.stream().filter((v) -> dupMap.containsKey(v)).distinct().collect(Collectors.toList());
	}
	
	private Set<Subscription.Follower> getMentions(String text) {
		Set<Subscription.Follower> mentions = new HashSet<>();
		Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(text);
	    while (m.find()) {
	    	Subscription.Follower ff = new Subscription.Follower();
	    	ff.setFollower(m.group());
	    	mentions.add(ff);
	    }
		return mentions;
	}
}
 
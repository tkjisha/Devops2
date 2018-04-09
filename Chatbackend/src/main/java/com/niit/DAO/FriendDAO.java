package com.niit.DAO;

import java.util.List;

import com.niit.Model.Friend;
import com.niit.Model.UserDetail;
public interface FriendDAO {

	public boolean sendFriendRequest(Friend friend);
	public boolean deleteFriendRequest(int friendId);
	public List<Friend> showSuggestedFriend(String loginname);
	public List<Friend> showAllFriend(String loginname);
	public List<Friend> showPendingRequestList(String loginname);
	public boolean acceptFriendRequest(int friendId);
}

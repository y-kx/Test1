package cn.fc.service;

import cn.fc.dao.UserMapper;
import cn.fc.pojo.Real_estate;
import cn.fc.pojo.Sale;
import cn.fc.pojo.Users;
import cn.fc.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.Null;
import java.io.File;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;


	@Override
	public Users login(String userName, String password) throws Exception {
		// TODO Auto-generated method stub
		Users user= null;
		user = userMapper.login(userName,password);
		//匹配密码
		return user;
	}

	@Override
	public List<Sale> getUserList(@Param("name")String name,
								  @Param("currentPageNo") Integer currentPageNo, @Param("pageSize") Integer pageSize) throws Exception {
		currentPageNo = (currentPageNo-1)*pageSize;
		return userMapper.getUserList(name, currentPageNo, pageSize);
	}

	@Override
	public boolean reg(Users user) throws Exception {
		boolean flag = false;
		if(userMapper.reg(user) > 0)
			flag = true;
		return flag;

	}

	@Override
	public int getUserCount( String name) throws Exception {
		return userMapper.getUserCount(name);
	}

//	@Override
//	public Users selectUserCodeExist(String cardId) throws Exception {
//		// TODO Auto-generated method stub
//		return userMapper.login(cardId);
//	}

	@Override
	public boolean add(Sale sale) throws Exception {
		boolean flag = false;
		if(userMapper.add(sale) > 0)
			flag = true;
		return flag;
	}

	@Override
	public int deleteUserById(Integer delId) throws Exception {
		int count = userMapper.deleteUserById(delId);
		return count;
	}

	@Override
	public Real_estate getRealById(Integer id) throws Exception {
		return  userMapper.getRealById(id);
	}

	@Override
	public boolean modify(Real_estate real_estate) throws Exception {
		boolean flag = false;
		if(userMapper.modify(real_estate) > 0)
			flag = true;
		return flag;
	}


	public List<Real_estate> cha() throws Exception {
		return userMapper.cha();
	}
	public List<Real_estate> chaa(String productName){

            return userMapper.chaa(productName);


	}


}

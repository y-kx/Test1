package cn.fc.dao;

import cn.fc.pojo.Real_estate;
import cn.fc.pojo.Sale;
import cn.fc.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	/**
	 * 用户登录
	 *
	 * @param userName
	 * @param password
	 * @return
	 */
	public Users login(@Param("userName") String userName,@Param("password") String password) throws Exception;
	/**
	 * 用户注册
	 *
	 */
	public int reg(Users user)throws Exception;

	/**
	 * 根据条件查询用户列表
	 * @param name
	 * @return
	 */
	public List<Sale> getUserList(@Param("name") String name,
								  @Param("currentPageNo") Integer currentPageNo, @Param("pageSize") Integer pageSize) throws Exception;

	/**
	 * 通过条件查询-用户表记录数

	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int getUserCount(@Param("name") String name)throws Exception;


	/**
	 * 添加房产
	 *
	 */
	public int add(Sale sale)throws Exception;

	/**
	 * 通过Id删除Real_estate信息
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public int deleteUserById(@Param("id") Integer delId)throws Exception;


	/**
	 * 通过Id获取Real_estate
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Real_estate getRealById(@Param("id") Integer id)throws Exception;

	/**
	 * 修改用户信息
	 * @param real_estate
	 * @return
	 * @throws Exception
	 */
	public int modify(Real_estate real_estate)throws Exception;

    /**
     * 查看商品数量
     * @param
     * @return
     * @throws Exception
     */
	public List<Real_estate> cha()throws Exception;
	public List<Real_estate> chaa(@Param("productName") String productName);
}

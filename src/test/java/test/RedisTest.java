package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baseutil.BaseJunitUtil;
/**
 * redis测试类
 * @author admin
 *
 */
import com.baseutil.RedisCacheUtil;
import com.trade.entity.User;
@Component
public class RedisTest extends BaseJunitUtil {

	 
	
	@Autowired
	RedisCacheUtil redisCacheUtil;
   
	@Test
	public void test() {
       //字符串处理
		redisCacheUtil.put("key1","i am zifuchuan");
		System.out.println("这是一个字符串    "+redisCacheUtil.get("key1"));
	
	    //map处理
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("key2","key2");
		map.put("key3", "key3");
	   
		redisCacheUtil.put("map",map);
		
		Map map1=redisCacheUtil.get("map",Map.class);
		
		if(map1 !=null){
			System.out.println("zhe shi key2  "+map1.get("key2"));
			System.out.println("zhe shi key3  "+map1.get("key2"));
		}
		
		//entity处理
		User user=new User();
		user.setId("dd");//该处需要进行测试，看看策略生成器是否有用
		user.setName("zheshime");
		redisCacheUtil.put("user",user);
		
		User user1=redisCacheUtil.get("user",User.class);
		System.out.println("id: "+user1.getId()+"  name:"+user1.getName());
		
		//list处理
		List<String> list=new ArrayList<String>();
		list.add("zhesiyigelist");
		redisCacheUtil.put("list",list);
		
		List<String> list1=redisCacheUtil.get("list",List.class);
		System.out.println("这是一个list："+ list1.get(0));
		
	
		
	}
	
	
}

package com.example.demo.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Prod;
import com.example.demo.form.AddProdForm;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProdRepositoryImpl implements ProdRepository {

	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Prod> selectByProd() {
		
		String sql = "SELECT * FROM m_product ORDER BY product_id";
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		
		//値の取得→結果の格納
		List<Prod> result = new ArrayList<Prod>();
		for(Map<String, Object> one : list) {
			Prod prod = new Prod();
			prod.setProdId((String) one.get("product_id"));
			prod.setProdName((String) one.get("product_name"));
			prod.setPrice((int) one.get("price"));
			prod.setImgId((String) one.get("img_id"));
			result.add(prod);
			
		}
		
		return result;
	}

	@Override
	public void insertProd(List<AddProdForm> form, HttpSession session) {
		// TODO 自動生成されたメソッド・スタブ
		
		String sql = "INSERT INTO t_sales (user_id, product_id, quantity, sales_date)"
				+ "VALUES (?, ?, ?, ?)";
		
		Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
		
		@SuppressWarnings("unchecked")
		List<AddProdForm> cart = (List<AddProdForm>) session.getAttribute("cart");
		String userId = (String) session.getAttribute("userId");
		
		for(AddProdForm num : cart) {
			jdbcTemplate.update(sql, userId,num.getProductId(), 1 , currentDate);
		}
		
		System.out.println(cart);
		System.out.println(userId);
		
	}

	@Override
	public List<Prod> selectByUserId(String userId) {
		String sql = 
				"SELECT										"
			+	"	ts.sales_id,							"
		    +	"	ts.user_id,								"
		    +	"	mu.user_name,							"
		    +	"	ts.product_id,							"
		    +	"	mp.product_name,						"
		    +	"	mp.price,								"
		    +	"	ts.quantity,							"
		    +	"	ts.sales_date							"
		    +	"FROM										"
		    +	"	t_sales ts								"
		    +	"	INNER JOIN 	m_product mp				"
		    +	"		ON ts.product_id = mp.product_id	"
		    +	"	LEFT OUTER JOIN m_user mu				"
		    +	"		ON ts.user_id = mu.user_id			"
		    +	"WHERE										"
		    +	"	ts.user_id = ?							"
		    +	"ORDER BY									"
		    +	"	ts.sales_date DESC,						"
		    +	"	ts.sales_id ASC						";
		
		
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,userId);
		
		//値の取得→結果の格納
		List<Prod> result = new ArrayList<Prod>();
		for(Map<String, Object> one : list) {
			Prod prod = new Prod();
			prod.setSalesId((int) one.get("sales_id"));
			prod.setUserId((String) one.get("user_id"));
			prod.setUserName((String) one.get("user_name"));
			prod.setProdId((String) one.get("product_id"));
			prod.setProdName((String) one.get("product_name"));
			prod.setPrice((int) one.get("price"));
			prod.setQuantity((int) one.get("quantity"));
			prod.setSalesDate((Date) one.get("sales_date"));
			result.add(prod);
			
		}
		return result;
	}

}

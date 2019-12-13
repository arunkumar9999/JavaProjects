package com.dao;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  

import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  

import com.model.Product;

public class ProductDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Product product){  
    String sql="insert into Product(productId,productName,price) values('"+product.getProductId()+"',"+product.getProductName()+",'"+product.getPrice()+"')";  
    return template.update(sql);  
}  
public int update(Product product){  
    String sql="update Product set  productName="+product.getProductName()+",price='"+product.getPrice()+"' where productId="+product.getPrice()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Product where productId="+id+"";  
    return template.update(sql);  
}  
public ProductDao getById(int id){  
    String sql="select * from Product where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<ProductDao>(ProductDao.class));  
}  
public List<Product> getEmployees(){  
    return template.query("select * from Product",new RowMapper<Product>(){  
        public Product mapRow(ResultSet rs, int row) throws SQLException {  
        	Product e=new Product();  
            e.setProductId(rs.getInt(1));  
            e.setProductName(rs.getString(2));  
            e.setPrice(rs.getFloat(3));  
             return e;  
        }  
    });  
}  
}  

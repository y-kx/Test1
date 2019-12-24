package cn.fc.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Real_estate {
    private Integer id;
    private  String  productName;
    private int quantity;

    @Override
    public String toString() {
        return "Real_estate{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Real_estate(Integer id, String productName, int quantity) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
    }
    public  Real_estate(){}
}

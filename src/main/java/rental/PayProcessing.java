package rental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="PayProcessing_table")
public class PayProcessing {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String carId;
    private String customerNm;
    private Integer qty;
    private String reervationId;

    @PostPersist
    public void onPostPersist(){
        Payed payed = new Payed();
        BeanUtils.copyProperties(this, payed);
        payed.publish();


    }

    @PostRemove
    public void onPostRemove(){
        Paycancelled paycancelled = new Paycancelled();
        BeanUtils.copyProperties(this, paycancelled);
        paycancelled.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
    public String getCustomerNm() {
        return customerNm;
    }

    public void setCustomerNm(String customerNm) {
        this.customerNm = customerNm;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public String getReervationId() {
        return reervationId;
    }

    public void setReervationId(String reervationId) {
        this.reervationId = reervationId;
    }




}

package hellojpa;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Data
public class Product {
    @Id @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "product")
    private List<MemberProduct> memberProducts = new ArrayList<>();

}

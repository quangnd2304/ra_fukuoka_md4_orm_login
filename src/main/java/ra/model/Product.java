package ra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @Column(name = "product_id",columnDefinition = "char(5)")
    private String id;
    @Column(name = "product_name",columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String name;
    private float price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @Column(columnDefinition = "varchar(200)")
    private String title;
    @Column(name = "product_status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "catalog_id",referencedColumnName = "catalog_id")
    private Categories catalog;
}

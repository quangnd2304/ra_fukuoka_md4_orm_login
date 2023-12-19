package ra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Categories {
    @Id
    @Column(name = "catalog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "catalog_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String name;
    @Column(columnDefinition = "text")
    private String descriptions;
    @Column(name = "catalog_status")
    private boolean status;
    /*
    * fetch: eager và lazy
    * eager: cho phép lấy tất cả các dữ liệu liên quan
    * lazy: không lấy các dữ liệu liên quan
    * OneToMany: mặc định là lazy
    * ManyToOne: mắc định là eager
    * */
    @OneToMany(mappedBy = "catalog",fetch = FetchType.EAGER)
    private List<Product> listProduct = new ArrayList<>();
}

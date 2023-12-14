package ra.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name",columnDefinition = "varchar(50)",nullable = false,unique = true)
    private String userName;
    @Column(name = "password",columnDefinition = "varchar(50)",nullable = false)
    private String password;
    //full_name: default jpa tạo
    @Column(name = "fullName",columnDefinition = "varchar(100)",nullable = false)
    private String fullName;
    @Column(columnDefinition = "varchar(100)",nullable = false,unique = true)
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updated;
    //Mặc định có quyền user (user:0 - admin:1)
    private boolean permission=false;
    @Column(name = "user_status")
    private boolean status = true;
}

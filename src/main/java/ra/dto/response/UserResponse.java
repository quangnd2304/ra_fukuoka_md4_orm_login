package ra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private int userId;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private Date created;
    private boolean status;
}

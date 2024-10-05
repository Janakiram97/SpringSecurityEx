import com.example.SpringSecuritysection4.model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InstanceOf {

    public static void main(String[] args) {
        Object obj=new ArrayList<>();

        UserDetailsService user=null;
        if(user instanceof JdbcUserDetailsManager){

        }
        Customer customer=null;
    }
}

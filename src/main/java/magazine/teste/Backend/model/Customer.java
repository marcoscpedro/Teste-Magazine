package magazine.teste.Backend.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;





@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @NotBlank(message = "The name's field can not be empty or null")
    private String name;

    @Valid
    @NotNull(message = "The e-mail's field can not be empty or null")
    private String email; 

    @Valid
    private String cpf;

    
    
    public Customer(){}

    public Customer(String name, String email, String cpf){
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

     public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

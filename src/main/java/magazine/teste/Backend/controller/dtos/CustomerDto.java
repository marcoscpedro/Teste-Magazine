package magazine.teste.Backend.controller.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import magazine.teste.Backend.model.Customer;

public class CustomerDto {

    @Valid
    @NotEmpty(message = "The name field can not be empty or null")
    private String name;

    @NotBlank(message = "The email field can not be empty or null")
    private String email;

    @NotBlank(message = "The cpf field can not be empty or null")
    private String cpf;

    public Customer toCustomer() {
        Customer newCustomer = new Customer();
        newCustomer.setEmail(this.email);
        newCustomer.setName(this.name);
        newCustomer.setCpf(this.cpf);
        return newCustomer;
    }

    public String toString() {
        return "Name: " + this.name + ", Email: " + this.email + ", CPF: " + this.cpf;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
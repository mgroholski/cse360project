package com.squad.project.spring.DTO;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;
import lombok.Data;

@Data
public class StudentDTO{
    private Long id;

    private List<OrderDTO> orders;

    private String email;

    private String permissions;

    public StudentDTO(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        //TODO
        return "";
    }
}

package com.squad.project.spring.DTO;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;
import lombok.Data;

import com.squad.project.spring.DTO.*;

@Data
public class StudentDTO{
    private Long id;

    private String name;

    private List<OrderDTO> orders;

    @Override
    public String toString() {
        //TODO
        return "";
    }
}

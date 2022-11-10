package com.squad.project.spring.DTO;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;
import lombok.Data;

import com.squad.project.spring.DTO.*;

@Data
public class PizzaDTO{
    private Long id;

    private List<String> piztTopList;

    private String pizType;

    private double cost;

    @Override
    public String toString() 
    {
        //TODO
        return "";
    }
}

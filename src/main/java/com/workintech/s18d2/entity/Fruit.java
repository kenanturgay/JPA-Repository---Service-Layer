package com.workintech.s18d2.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "fruit", schema = "fsweb")
public class Fruit extends Plant {

    

}

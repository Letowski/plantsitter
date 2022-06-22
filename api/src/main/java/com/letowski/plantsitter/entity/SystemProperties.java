package com.letowski.plantsitter.entity;

import com.letowski.plantsitter.entity.enums.SystemPropertyKey;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity(name = "system_properties")
public class SystemProperties {

    @Id
    @Enumerated(EnumType.STRING)
    private SystemPropertyKey name;

    private String value;
}

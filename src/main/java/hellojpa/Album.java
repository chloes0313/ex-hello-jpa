package hellojpa;

import lombok.Data;

import javax.persistence.Entity;

@Data
//@Entity
public class Album extends Item {
    private String artist;
}

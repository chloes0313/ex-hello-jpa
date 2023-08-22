package hellojpa;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastModifiedDate;
    private String lastModifiedBy;
}

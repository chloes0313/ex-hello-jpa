package hellojpa;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Data
@Embeddable
public class Period {
    //Period : 기간
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}

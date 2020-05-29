package tn.enis.bookstrore.util.notification;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.Map;

@NoArgsConstructor
@Data
@ToString
public class Mail {

    private String from;
    private String to;
    private Date sendDate;
    private String subject;
    private String body;
}

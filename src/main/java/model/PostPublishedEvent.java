package model;


import lombok.*;


import java.util.List;

//@getter and @setter allow us to reduce the generate code as much as we have a lot attribut
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
//builder allowed to create new instance like builder a new pattern to our field
@Builder
public class PostPublishedEvent {

    private String postUrl;
    private String postTitle;
    private List<String> emails;


}

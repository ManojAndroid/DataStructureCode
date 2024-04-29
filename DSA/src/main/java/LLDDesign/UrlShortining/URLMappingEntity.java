package LLDDesign.UrlShortining;
//@Entity
public class URLMappingEntity {
   // @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String longURL;
    private String shortURL;

    // Getters and setters

    // note use  redis or other noSql db for low latency ans scaling
}

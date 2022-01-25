package br.usp.ime.verao.backend;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Meme {
    @Id
    @SequenceGenerator(
            name = "meme_seq_generator",
            sequenceName = "meme_seq_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "meme_seq_generator"
    )
    private long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @ElementCollection
    @Column(
            name = "keywords"
    )
    private List<String> keywords;

    @Column(
            name = "url"
    )
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

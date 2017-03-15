package hu.david.veres.graph.entity;

import javax.persistence.*;

@Entity
@Table(name = "testtable")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "testcolumn")
    private String text;

}

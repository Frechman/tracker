package ru.gavrilov.tracker.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter

@Entity
@Table(name = "ITEMS")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "DATE", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "spring.jackson.date-format")
    private Date dateCreate;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.dateCreate = Timestamp.valueOf(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "Item[" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateCreate=" + dateCreate +
                ']';
    }
}

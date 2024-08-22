package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
      name="posts",uniqueConstraints={@UniqueConstraint(columnNames={"title"})}
)
@Data
public class Post {


    @Id
    @GeneratedValue(
            strategy=GenerationType.IDENTITY
    )
    private Long id;


    @Column(name="title",nullable=false)
    private String title;
    @Column(name="description",nullable=false)
    private String description;
    @Column(name="content",nullable=false)
    private String content;

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

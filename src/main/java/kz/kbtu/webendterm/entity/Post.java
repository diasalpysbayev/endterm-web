package kz.kbtu.webendterm.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "post")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String text;

  private String author;

  @CreationTimestamp
  private LocalDateTime createdAt; //Automated created date timestamp

  @UpdateTimestamp
  private LocalDateTime modifiedAt;

  public Long getId() {
    return id;
  }

  public Post setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public Post setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getText() {
    return text;
  }

  public Post setText(String text) {
    this.text = text;
    return this;
  }

  public String getAuthor() {
    return author;
  }

  public Post setAuthor(String author) {
    this.author = author;
    return this;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(LocalDateTime modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Post post = (Post) o;
    return Objects.equals(id, post.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

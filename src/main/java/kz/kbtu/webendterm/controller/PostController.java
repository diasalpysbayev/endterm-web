package kz.kbtu.webendterm.controller;

import kz.kbtu.webendterm.dto.ApiResponse;
import kz.kbtu.webendterm.dto.login.LoginRequestDTO;
import kz.kbtu.webendterm.dto.login.LoginResponseDTO;
import kz.kbtu.webendterm.entity.Post;
import kz.kbtu.webendterm.service.post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @PostMapping("/create")
  public ApiResponse<Void> create(@RequestBody Post post) {
    try {
      postService.create(post);
      return new ApiResponse<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/delete")
  public ApiResponse<Void> delete(@RequestBody Long id) {
    try {
      postService.delete(id);
      return new ApiResponse<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/edit")
  public ApiResponse<Void> edit(@RequestBody Post post) {
    try {
      postService.edit(post);
      return new ApiResponse<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/all")
  public ApiResponse<List<Post>> getAll() {
    try {
      return new ApiResponse<>(HttpStatus.OK, postService.getAll());
    } catch (Exception e) {
      return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/by-author")
  public ApiResponse<List<Post>> getAllByAuthor(@RequestBody String author) {
    try {
      return new ApiResponse<>(HttpStatus.OK, postService.getAllByAuthor(author));
    } catch (Exception e) {
      return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}

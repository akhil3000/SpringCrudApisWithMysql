package com.example.demo.controller;

import com.example.demo.payload.PostDto;
import com.example.demo.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService)
    {
        this.postService=postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
       return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
     public List<PostDto> getAllPosts()
    {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto>getPostById(@PathVariable(name="id")long id)
    {
        return ResponseEntity.ok(postService.getPostById(id));
    }
   @PutMapping("/{id}")
   public ResponseEntity<PostDto>updatePost(@RequestBody PostDto postDto,@PathVariable(name="id")long id )
   {
         PostDto postResponse=postService.updatePost(postDto,id);
         return new ResponseEntity<>(postResponse,HttpStatus.OK);

   }
   @DeleteMapping("/{id}")
   public ResponseEntity<String>deletePost(@PathVariable(name="id")long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post entity deleted Successfully",HttpStatus.OK);

   }









}

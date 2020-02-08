import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {
  info = '';
  postTitle: String;
  postContent: String;
  formGroup: FormGroup;

  constructor(
    private formBuilder: FormBuilder, private userService: UserService,
    private postService: PostService
  ) {
    this.formBuilder = formBuilder;
    this.postService = postService;
    this.formGroup = this.formBuilder.group({
      postTitle: '',
      postContent: ''
    });
  }

  ngOnInit() {
    /*this.userService.getUserBoard().subscribe(
      data => {
        this.info = data;
      },
      err => {
        this.info = JSON.parse(err.error).message;
      }
    );*/
  }

  onSubmit(formData) {
    console.log("data before service:", formData);

    this.postTitle = this.formGroup.get('postTitle').value;
    this.postContent = this.formGroup.get('postContent').value;

    const newPost = {
      title: this.postTitle,
      content: this.postContent
    };

    this.postService.createPost(newPost).subscribe((data) => {
      console.log(data);
    });
  }
}

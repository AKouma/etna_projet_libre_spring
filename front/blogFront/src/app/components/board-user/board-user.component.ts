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
  content = '';
  postTitle: String;
  postDescription: String;
  formGroup: FormGroup;

  constructor(
    private formBuilder: FormBuilder, private userService: UserService,
    private postService: PostService
  ) {
    this.formBuilder = formBuilder;
    this.postService = postService;
    this.formGroup = this.formBuilder.group({
      postTitle: '',
      posDescription: ''
    });
  }

  ngOnInit() {
    this.userService.getUserBoard().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }

  onSubmit(formGroup: FormGroup) {
    this.postTitle = this.formGroup.get('postTitle').value;
    this.postDescription = this.formGroup.get('posDescription').value;

    let newPostData = {
      title: this.postTitle,
      description: this.postDescription
    };

    this.postService.createPost(newPostData).subscribe((data) => {
      console.log(data);
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, FormControl } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { PostService } from 'src/app/services/post.service';
import { TokenStorageService } from '../../services/token-storage.service';

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {
  userData = '';
  postTitle: String;
  postContent: String;
  postCategorie: String;
  commentContent: String;
  formGroup: FormGroup;
  formGroupComment: FormGroup;

  /*categories: any = [
    {
      id: 1, categorie: 'movie'
    },
    {
      id: 2, categorie: 'sport'
    },
    {
      id: 3, categorie: 'other'
    },
  ];*/

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private tokenStorageService: TokenStorageService,
    private postService: PostService
  ) {

    this.formBuilder = formBuilder;
    this.postService = postService;
    /*this.formGroupComment = this.formBuilder.group({

    });*/

    this.formGroup = this.formBuilder.group({
      postTitle: '',
      postContent: '',
      postCategorie: ''
    });
  }

  ngOnInit() {
    console.log("user info Koumare:", this.tokenStorageService.getUser());
    this.userService.getUserInfo(this.tokenStorageService.getToken()).subscribe((data) => {
      this.userData = data;
      console.log("Msg for koumare--> user info--> ", this.userData);
    });
    console.log("Or there: ", this.userService.getUserInfo(this.tokenStorageService.getToken()));
    /*this.userService.getUserBoard().subscribe(
      data => {
        this.info = data;
        console.log('user info:', this.info);
      },
      err => {
        this.info = JSON.parse(err.error).message;
      }
    );*/
  }

  deletePost(postId) {
    this.postService.deletePost(postId).subscribe((data) => {
      console.log("res to delete request:", data);
    });
    window.location.reload();
  }

  createComment(postId) {

  }

  onSubmit(formData) {
    console.log('data before service:', formData);

    this.postTitle = this.formGroup.get('postTitle').value;
    this.postContent = this.formGroup.get('postContent').value;
    this.postCategorie = this.formGroup.get('postCategorie').value;

    const newPost = {
      title: this.postTitle,
      content: this.postContent,
      categories: this.postCategorie
    };

    this.postService.createPost(newPost).subscribe((data) => {
      console.log(data);
    });
    window.location.reload();
  }
}

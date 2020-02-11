import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, FormControl } from '@angular/forms';
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

  categories: any = [
    {
      id: 1, categorie: 'movie'
    },
    {
      id: 2, categorie: 'sport'
    },
    {
      id: 3, categorie: 'other'
    },
  ];

  constructor(
    private formBuilder: FormBuilder, private userService: UserService,
    private postService: PostService
  ) {
    const formControls = this.categories.map((control) => {
      let fmControl = new FormControl(false);

      console.log(fmControl);
    });
    this.formBuilder = formBuilder;
    this.postService = postService;
    this.formGroup = this.formBuilder.group({
      postTitle: '',
      postContent: '',
      categories: new FormArray(formControls)
    });
  }

  ngOnInit() {
    this.userService.getUserBoard().subscribe(
      data => {
        this.info = data;
        console.log('user info:', this.info);
      },
      err => {
        this.info = JSON.parse(err.error).message;
      }
    );
  }

  onSubmit(formData) {
    console.log('data before service:', formData);

    this.postTitle = this.formGroup.get('postTitle').value;
    this.postContent = this.formGroup.get('postContent').value;

    const selectedCategorie = this.formGroup.value.categories.map((checked, index) => {
      checked ? this.categories[index].id : null
    }).filter(value => value != null);

    const newPost = {
      title: this.postTitle,
      content: this.postContent,
      categories: selectedCategorie
    };

    this.postService.createPost(newPost).subscribe((data) => {
      console.log(data);
    });
  }
}

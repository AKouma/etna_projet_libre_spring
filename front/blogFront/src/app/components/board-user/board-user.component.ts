import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from '../../services/user.service';

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
  ) {
    this.formBuilder = formBuilder;
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
  }
}

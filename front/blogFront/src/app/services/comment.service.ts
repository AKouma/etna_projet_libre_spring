import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TokenStorageService } from './token-storage.service';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Access-Control-Allow-Origin': '*',
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient, private tokenStorageService: TokenStorageService) { }

  createComment(comment): Observable<any> {
    httpOptions.headers.set('Authorization', 'Bearer ' + this.tokenStorageService.getToken());
    const data = JSON.stringify({ postId: comment.postId, content: comment.content });
    console.log("data: stringify", data);
    const dataAsJSON = JSON.parse(data);

    console.log("comment to send: ", comment);
    console.log("comment to send as JSON: ", dataAsJSON);
    return this.http.post<any>('http://localhost:8090/post/update_post', dataAsJSON, httpOptions);
  }
}

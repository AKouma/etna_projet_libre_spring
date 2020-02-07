import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({
    'Access-Control-Allow-Origin': '*',
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  getPosts(): Observable<any> {
    return this.http.get('http://localhost:3000/getPosts');
  }

  createPost(post): Observable<Object> {
    const data = JSON.stringify({ title: post.title, description: post.description });
    const dataAsJSON = JSON.parse(data);

    console.log("post to send: ", post);
    console.log("post to send as JSON: ", dataAsJSON);
    return this.http.post<Event>('http://localhost:3000/insert-post', dataAsJSON, httpOptions);
  }
}

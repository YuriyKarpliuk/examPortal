import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private http:HttpClient) { }

  public quizzes(){
    return this.http.get(`${baseUrl}/quiz/all`);
  }

  public addQuiz(quiz:any){
    return this.http.post(`${baseUrl}/quiz/`,quiz);
  }
  public deleteQuiz(id:any){
    return this.http.delete(`${baseUrl}/quiz/${id}`);
  }

  public getQuiz(id:any){
    return this.http.get(`${baseUrl}/quiz/${id}`);

  }
  public updateQuiz(quiz:any){
return this.http.put(`${baseUrl}/quiz/`,quiz);
  }

  public getQuizzesByCategoryId(id:any){
return this.http.get(`${baseUrl}/quiz/category/${id}`);
  }

  public getActiveQuizzes(){
    return this.http.get(`${baseUrl}/quiz/active`);
  }
  public getActiveQuizzesByCategoryId(id:any){
    return this.http.get(`${baseUrl}/quiz/category/active/${id}`);
  }
}

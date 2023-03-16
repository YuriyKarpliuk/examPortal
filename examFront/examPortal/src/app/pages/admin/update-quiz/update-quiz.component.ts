import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-quiz',
  templateUrl: './update-quiz.component.html',
  styleUrls: ['./update-quiz.component.css']
})
export class UpdateQuizComponent implements OnInit{

  constructor(private _route:ActivatedRoute, private _quiz:QuizService,private _category:CategoryService,private _router:Router){}

  id=0;
  quiz={ title:'',
  description:'',
  maxMarks:'',
  numberOfQuestions:'',
  active:true,
category:{
id:''}};

categories=[
  {
    id:'',
    title:''
  }
];
  ngOnInit(): void {
this.id=this._route.snapshot.params['id'];
this._quiz.getQuiz(this.id).subscribe(
  (data:any)=>{
    this.quiz=data;
    console.log(this._quiz);
  },
  (error)=>{
    console.log('error');
  }
)

this._category.categories().subscribe(
  (data:any)=>{
this.categories=data;
  },(error)=>{
alert('error in loading categories');
  }
)
  }

  public updateData(){
    this._quiz.updateQuiz(this.quiz).subscribe((data:any)=>{
Swal.fire('Success!!!','quiz updated','success').then((e)=>{
  this._router.navigate(['/admin/quizzes']);
});
    },(error)=>{
      Swal.fire('Error','error in updating quiz','error');
      console.log(error);

    })
  }

}

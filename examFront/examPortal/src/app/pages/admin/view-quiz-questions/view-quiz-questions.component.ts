import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-quiz-questions',
  templateUrl: './view-quiz-questions.component.html',
  styleUrls: ['./view-quiz-questions.component.css']
})
export class ViewQuizQuestionsComponent implements OnInit{
  id=0;
  title='';
  questions=[{id:'',content:'',option1:'',option2:'',option3:'',option4:'',answer:'',image:''}
];

  constructor(private _route:ActivatedRoute,private question:QuestionService,private _snak:MatSnackBar){}
  ngOnInit(): void {

    this.id=this._route.snapshot.params['id'];
    this.title=this._route.snapshot.params['title'];
    this.question.getQuestionsOfQuiz(this.id).subscribe((data:any)=>{
console.log(data);
this.questions=data;

    },
    (error)=>{
      console.log(error);

    })
    console.log(this.id);
    console.log(this.title);



  }

  deleteQuestion(id:any){
    Swal.fire({
      icon:'info',
      showCancelButton:true,
      confirmButtonText:'Delete',
      title:'Are you sure, delete this question?',
    }).then((result)=>{
      if(result.isConfirmed){
        this.question.deleteQuestion(id).subscribe((data:any)=>{
          this._snak.open('Question deleted!','',{
            duration: 3000,
          });
          this.questions=this.questions.filter((q)=>q.id!=id);
        },
        (error)=>{
          this._snak.open('Error in deleting questions','',{
            duration:3000,
          });
          console.log(error);
        });
      }
    })
  }

}

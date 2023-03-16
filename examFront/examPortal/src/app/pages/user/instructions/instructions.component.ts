import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-instructions',
  templateUrl: './instructions.component.html',
  styleUrls: ['./instructions.component.css']
})
export class InstructionsComponent implements OnInit{


id:any;
quiz:any;

  constructor(private _route:ActivatedRoute,private _quiz:QuizService,private _router:Router){}
  ngOnInit(): void {

    this.id=this._route.snapshot.params['qId'];

    this._quiz.getQuiz(this.id).subscribe(
      (data)=>{
        this.quiz=data;
      },
      (error)=>{
        console.log(error);
        alert('Error in loading quiz data');
      }
    )
  }

  startQuiz(){
Swal.fire({
  title:'Do you want to start the quiz?',
  showCancelButton:true,
  confirmButtonText:`Start`,
  denyButtonText:`Don't start`,
  icon:'info',
}).then((result)=>{
  if(result.isConfirmed){

    this._router.navigate(['/start/'+this.id]);
  }
  else{
    Swal.fire(`Quiz isn't started`,'','info');
  }
})
  }

}

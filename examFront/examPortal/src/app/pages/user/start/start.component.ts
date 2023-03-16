import { LocationStrategy } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.css']
})
export class StartComponent implements OnInit{

  id:any;
  questions=[{givenAnswer:'',answer:'',content:'',option1:'',option2:'',option3:'',option4:'',quiz:{title:'',maxMarks:0}}];


  marksGot=0;
  correctAnswers=0;
  attempted=0;

  timer:any;

  isSubmit=false;
  constructor(private locationSt:LocationStrategy,private _route:ActivatedRoute
    ,private _question:QuestionService){}
  ngOnInit(): void {
    this.preventBackButton();
    this.id=this._route.snapshot.params['qId'];
    this.loadQuestions();
  }
  loadQuestions() {
    this._question.getQuestionsOfQuizForTest(this.id).subscribe(
      (data:any)=>{
        this.questions=data;

        this.timer=this.questions.length*2*60;

        this.questions.forEach(q=>{
          q['givenAnswer']='';
        })


        this.startTimer();
      },(error)=>{
        console.log(error);
        Swal.fire('Error','Error in loading questions of quiz','error');
      }
    )
  }

  preventBackButton(){
    history.pushState(null,"",location.href);
    this.locationSt.onPopState(()=>{
      history.pushState(null,"",location.href);
    });
  }

  submitQuiz(){
    Swal.fire({
      title:'Do you want to submit the quiz?',
      showCancelButton:true,
      confirmButtonText:`Submit`,
      denyButtonText:`Don't save`,
      icon:'info',
    }).then((e)=>{
      if(e.isConfirmed){

      this.evaluateQuiz();

      }

    })
  }

  startTimer(){
    let t=window.setInterval(()=>{
if(this.timer<=0){
  this.evaluateQuiz();
  clearInterval(t);
}else{
  this.timer--;
}
    },1000)
  }

  getFormattedTime(){
    let mm=Math.floor(this.timer/60);
    let ss=this.timer-mm*60;
    return `${mm} min : ${ss} sec`;
  }

  evaluateQuiz(){
    this._question.evalQuiz(this.questions).subscribe((data:any)=>{
      console.log(data);
    this.isSubmit=true;
      this.marksGot=parseFloat(Number(data.marksGot).toFixed(2));
      this.correctAnswers=data.correctAnswers;
      this.attempted=data.attempted;
    },(error)=>{
      console.log(error);
    })



  }
  printPage(){
    window.print();
  }
}

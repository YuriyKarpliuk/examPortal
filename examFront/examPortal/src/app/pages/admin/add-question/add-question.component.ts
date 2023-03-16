import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';


@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit{

  public Editor:any= ClassicEditor;

  id:any;
  title='';
  question={content:'',option1:'',option2:'',option3:'',option4:'',answer:'',image:'',quiz:{id:''}};
 

  constructor(private _route:ActivatedRoute,private _question:QuestionService){}
  ngOnInit(): void {

    this.id=this._route.snapshot.params['id'];
    this.title=this._route.snapshot.params['title'];
    
this.question.quiz['id']=this.id;

  }
  formSubmit(){
    if(this.question.content.trim()==''|| this.question.content==null){
      return;
    }
    if(this.question.option1.trim()==''|| this.question.option1==null){
      return;
    }
    if(this.question.option2.trim()==''|| this.question.option2==null){
      return;
    }
    if(this.question.answer.trim()==''|| this.question.answer==null){
      return;
    }
    this._question.addQuestion(this.question).subscribe(
      
      (data:any)=>{
        Swal.fire('Success','Question Added','success');
        this.question.content='';
        this.question.option1='';
        this.question.option2='';
        this.question.option3='';
        this.question.option4='';
        this.question.answer='';
        
      },
      (error)=>{
        Swal.fire('Error','Error in adding question','error');
      }
    )
  }

}

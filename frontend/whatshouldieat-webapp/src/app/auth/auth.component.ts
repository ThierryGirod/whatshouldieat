import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService, IUser } from './auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent {

  isInitialLogin = false;
  isConfirm = false;
  isLoading = false;
  isLoginMode = true;
  error: string;
  user: IUser;

  constructor(private authService: AuthService, private router: Router){
    this.user = {} as IUser;
  }

  onSubmit(form: NgForm){
      this.error = "";
      this.isLoading = true;
      console.log(this.user);

      if(!this.isLoginMode){
        this.authService.signUp(this.user).then(() => {
          this.isLoading = false;
          this.isConfirm = true;
        }).catch((resp) => {
          this.isLoading = false;
          this.error = resp.message;
        });
      }else{
        this.authService.signIn(this.user).then(() => {
          if(this.isInitialLogin){
            this.authService.updateUser(this.user).then(()=> {

             console.log("user updated")
             console.log(this.user)
          }).catch((e)=> console.log(e));
          }
          this.isInitialLogin=false;
          this.isLoading = false;
          this.router.navigate(["/suggest"]);
        }).catch((resp) => {
          this.isLoading = false;
          this.error = resp.message;
        });
      }

     
  }

  public confirmSignUp(): void {
    this.isLoading = true;
    this.isInitialLogin = true;
    this.authService.confirmSignUp(this.user)
    .then(() => {
      this.isLoginMode = true;
      this.isConfirm = false;
      this.isLoading = false;
   
    }).catch(() => {
      this.isLoading = false;
    });
  }

  onSwitchMode(){
    this.error = "";
    this.isLoginMode = !this.isLoginMode;
  }
}

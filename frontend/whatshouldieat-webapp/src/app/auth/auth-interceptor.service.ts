import { HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpParams, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, exhaustMap, take } from "rxjs";
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor{

  constructor(private authService: AuthService){}
 
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      return this.authService.authenticationSubject.pipe(
          take(1),
          exhaustMap(user => { 

              if(!user){
                  console.log("user = null");
                  return next.handle(req);
              }
              
              
              console.log("curren user info");
              console.log(this.authService.getUser())
              const modifiedReq = req.clone({
                headers: new HttpHeaders().append('authorization', 'bearer: '+ user.signInUserSession.accessToken.jwtToken)
              });
         

              console.log("modifiedReq");
              console.log(modifiedReq);
              return next.handle(modifiedReq);
          })
      );
   
  }
}

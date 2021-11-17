import { User } from './../model/user';
import { Observable } from 'rxjs';
import { _url } from './../const/_url';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

constructor(private http:HttpClient) { }

  login(input:string):Observable<any>{
    return this.http.post(_url.login,input,{headers:{'Content-Type':'application/x-www-form-urlencoded'}});
  }

  logout():Observable<any>{
    return this.http.post(_url.logout,{});
  }

  register(user:User):Observable<any>{
    return this.http.post(_url.register,user);
  }

  addCampaign(input:any):Observable<any>{
    return this.http.post(_url.addCompaign,input);
  }

  getCompaigns():Observable<any>{
    return this.http.get(_url.getCompaigns);
  }

  getCompaign(id:number):Observable<any>{
    return this.http.get(_url.getCompaign+id);
  }

  getUserCompaign(id:string):Observable<any>{
    return this.http.get(_url.getUserCampaigns+id);
  }

  getUserAttendCompaign(id:string):Observable<any>{
    return this.http.get(_url.getUserAttendedCampaigns+id);
  }

  removeCompaign(id:number):Observable<any>{
    return this.http.delete(_url.removeCampaigns+id);
  }

  noUsers():Observable<any>{
    return this.http.get(_url.noUser);
  }

  getUserList():Observable<any>{
    return this.http.get(_url.userList);
  }

  addAnswers(obj:any):Observable<any>{
    return this.http.post(_url.addAnswers+obj.campaignId,obj);
  }
}

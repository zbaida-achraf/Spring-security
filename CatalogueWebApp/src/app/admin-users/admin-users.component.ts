import { Component, OnInit } from '@angular/core';
import {UserService} from '../user.service';

@Component({
  selector: 'app-admin-users',
  templateUrl: './admin-users.component.html',
  styleUrls: ['./admin-users.component.css']
})
export class AdminUsersComponent implements OnInit {
  users;
  constructor(private userService:UserService) { }

  ngOnInit() {
    this.userService.getAllUsers()
      .subscribe(data=>{
        this.users=data;
      },err=>{
        console.log(err);
      })
  }

}

import { daysInYear } from 'date-fns';
import { Component, OnInit } from '@angular/core';
import { CalendarView, CalendarEvent } from 'angular-calendar';
import { DataService } from './services/data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'angular-calendar-interface';

  viewDate: Date = new Date();
  view: CalendarView = CalendarView.Month;
  CalendarView = CalendarView;

  setView = (view: CalendarView) => this.view = view;

  events: CalendarEvent[] = [];

  constructor(private dataService: DataService) {}

  ngOnInit(): void {
    this.dataService.getAllEvent().subscribe((data: any) => this.events.push({
      title: data[0].title,
      start: new Date(data[1].start),
      end: new Date(data[1].end)
    }));
    console.log(this.events);
  }
}
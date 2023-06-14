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
    this.dataService.getAllEvent().subscribe((data: any) => data.forEach((element: { title: any; start: string | number | Date; end: string | number | Date; }) => {
      this.events.push({
        title: element.title,
        start: new Date(element.start),
        end: new Date(element.end)
      });
    }));
    console.log(this.events);
  }
}

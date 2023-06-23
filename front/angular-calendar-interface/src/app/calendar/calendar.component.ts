import { Component, OnInit } from '@angular/core';
import { CalendarView, CalendarEvent } from 'angular-calendar';
import { DataService } from '../services/data.service';
import { StorageService } from '../services/storage.service';
@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss']
})
export class CalendarComponent implements OnInit {
  title = 'angular-calendar-interface';

  viewDate: Date = new Date();
  view: CalendarView = CalendarView.Month;
  CalendarView = CalendarView;

  setView = (view: CalendarView) => this.view = view;

  events: CalendarEvent[] = [];
  constructor(private dataService: DataService, private storageService: StorageService) { }

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
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
}

import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-tab-content',
  templateUrl: './tab-content.component.html',
  styleUrls: ['./tab-content.component.css']
})
export class TabContentComponent implements OnInit {

    @Input() card: any;

  constructor() { }

  ngOnInit(): void {
  }


  public frontData(): any[] {

      return [
        this.card.manufacturer
      ];
    }

}

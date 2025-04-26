import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StatisticService } from '../../services/statistic.service';
import { Statistic } from '../../models/statistic.model';

@Component({
  selector: 'app-statistic',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './statistic.component.html',
  styleUrls: ['./statistic.component.css']
})
export class StatisticComponent implements OnInit {
  statistics: Statistic | null = null;

  constructor(private statisticService: StatisticService) {}

  ngOnInit(): void {
    this.statisticService.getFullStatistics().subscribe({
      next: (data) => {
        this.statistics = data;
      },
      error: (error) => {
        console.error('Error loading statistics', error);
      }
    });
  }

  get hasStatistics(): boolean {
    return this.statistics !== null;
  }

}

import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';
import { HeroService } from '../hero.service';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  heroes!: Hero[];

  constructor(private heroService: HeroService, private messageService: MessageService) {

  }

  getHeroes(): void {
    this.heroService.getHeroes().subscribe(heroesObs => this.heroes = heroesObs);
  }
  onSelect(hero: Hero): void {
    this.messageService.add(`HeroesComponent: Selected hero = ${hero.name}`);
  }
  ngOnInit(): void {
    this.getHeroes();
  }

}
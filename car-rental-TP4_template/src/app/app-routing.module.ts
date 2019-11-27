import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CarsComponent } from './cars/cars.component';
import { CarDetailComponent } from './car-detail/car-detail.component';

const appRoutes: Routes = [
  { path: '',
    redirectTo: '/cars',
    pathMatch: 'full'
  },
  { path: 'cars/:plateNumber',
    component: CarDetailComponent
  },
  { path: 'cars',
    component: CarsComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { TestBed } from '@angular/core/testing';

import { CartObservableService } from './cart-observable.service';

describe('CartObservableService', () => {
  let service: CartObservableService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CartObservableService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

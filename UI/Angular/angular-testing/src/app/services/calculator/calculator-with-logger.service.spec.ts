import { LoggerService } from '../logger/logger.service';
import { CalculatorWithLoggerService } from './calculator-with-logger.service';

describe('CalculatorwithLoggerService', () => {

  let mockLoggerService: any;
  let calculator: CalculatorWithLoggerService;
  beforeEach(() => {
    console.log('calling before each');
    mockLoggerService = jasmine.createSpyObj('LoggerService', ['log']);
    calculator = new CalculatorWithLoggerService(mockLoggerService);
  });

  it('should add two numbers', () => {
    let result = calculator.add(2, 2);
    expect(result).toBe(4);
    expect(mockLoggerService.log).toHaveBeenCalledTimes(1);
  });

  it('should subtract two numbers', () => {
    let result = calculator.subtract(2, 2);
    expect(result).toBe(0);
    expect(mockLoggerService.log).toHaveBeenCalledTimes(1);
  });
});

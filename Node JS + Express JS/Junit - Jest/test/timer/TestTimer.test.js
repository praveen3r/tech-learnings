jest.useFakeTimers();
jest.spyOn(global, 'setTimeout');

test('waits 1 second before ending the game', () => {
  const timerGame = require('../../src/timer/TestTimer');
  timerGame();
  //jest.runAllTimers();

  expect(setTimeout).toHaveBeenCalledTimes(1);
  expect(setTimeout).toHaveBeenLastCalledWith(expect.any(Function), 1000);
});

test('calls the callback after 1 second', () => {
    const timerGame = require('../../src/timer/TestTimer');
    const callback = jest.fn();
  
    timerGame(callback);
  
    // At this point in time, the callback should not have been called yet
    expect(callback).not.toBeCalled();
  
    // Fast-forward until all timers have been executed
    jest.runAllTimers();
  
    // Now our callback should have been called!
    expect(callback).toBeCalled();
    expect(callback).toHaveBeenCalledTimes(1);
  });
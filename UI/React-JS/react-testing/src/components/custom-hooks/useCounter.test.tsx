import { act, renderHook } from "@testing-library/react";
import useCounter from "./useCounter";

test("test1", () => {
  const { result } = renderHook(useCounter, {
    initialProps: {
      initialValue: 0,
      incrementValue: 10,
    },
  });
  expect(result.current.count).toBe(0);
});

test("test2", () => {
  const { result } = renderHook(useCounter, {
    initialProps: {
      initialValue: 0,
      incrementValue: 10,
    },
  });
  act(() => result.current.increment());
  expect(result.current.count).toBe(10);
});

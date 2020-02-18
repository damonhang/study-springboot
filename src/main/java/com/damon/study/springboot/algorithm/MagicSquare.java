package com.damon.study.springboot.algorithm;

import java.util.HashMap;
import java.util.Map;

//非线程安全
public class MagicSquare {

  private Map<Integer, Boolean> validateMap;

  public MagicSquare() {
    validateMap = new HashMap<>();
    for (int i = 1; i <= 9; i++) {
      validateMap.put(i, false);
    }
  }

  public int numMagicSquaresInside(int[][] grid) {
    int rowLength = grid.length;
    if (rowLength < 3) {
      return 0;
    }
    int columnLength = grid[0].length;
    if (columnLength < 3) {
      return 0;
    }
    int count = 0;
    int[][] fixGrid;
    for (int deep = 0; deep <= rowLength - 3; deep++) {
      for (int width = 0; width <= columnLength - 3; width++) {
        if (grid[deep + 1][width + 1] != 5) {
          continue;
        }
        fixGrid = new int[3][3];
        fixGrid[0] = new int[]{grid[deep][width], grid[deep][width + 1], grid[deep][width + 2]};
        fixGrid[1] = new int[]{grid[deep + 1][width], grid[deep + 1][width + 1], grid[deep + 1][width + 2]};
        fixGrid[2] = new int[]{grid[deep + 2][width], grid[deep + 2][width + 1], grid[deep + 2][width + 2]};
        if (isMagicSquare(fixGrid)) {
          count++;
        }
      }
    }
    return count;
  }

  protected boolean isMagicSquare(int[][] grid) {
    if (!containsAllNum(grid)) {
      return false;
    }
    final int result = grid[0][0] + grid[0][1] + grid[0][2];
    //所有行相等
    for (int row = 1; row < 3; row++) {
      int tempResult = grid[row][0] + grid[row][1] + grid[row][2];
      if (tempResult != result) {
        return false;
      }
    }
    //所有列相等
    for (int column = 0; column < 3; column++) {
      int tempResult = grid[0][column] + grid[1][column] + grid[2][column];
      if (tempResult != result) {
        return false;
      }
    }
    //对角相等
    return result == (grid[0][0] + grid[1][1] + grid[2][2]) && result == (grid[2][0] + grid[1][1] + grid[0][2]);
  }

  public boolean containsAllNum(int[][] grid) {
    resetMap(validateMap);
    for (int row = 0; row < 3; row++) {
      for (int column = 0; column < 3; column++) {
        int value = grid[row][column];
        if (validateMap.containsKey(value)) {
          validateMap.put(value, true);
        }
      }
    }
    return isAllTrue(validateMap);
  }

  private void resetMap(Map<Integer, Boolean> validateMap) {
    for (Integer integer : validateMap.keySet()) {
      validateMap.put(integer, false);
    }
  }

  private boolean isAllTrue(Map<Integer, Boolean> validateMap) {
    for (Boolean value : validateMap.values()) {
      if (!value) {
        return false;
      }
    }
    return true;
  }
}

package com.damon.study.springboot.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class MagicSquareTest {

  MagicSquare magicSquare = new MagicSquare();

  @Test
  public void shouldMagicSquareSuccess() {
    boolean magicSquare = this.magicSquare.isMagicSquare(new int[][]{{4, 3, 8}, {9, 5, 1}, {2, 7, 6}});
    boolean notMagicSquare = this.magicSquare.isMagicSquare(new int[][]{{3, 8, 4}, {5, 1, 9}, {7, 6, 2}});
    boolean notMagicSquare1 = this.magicSquare.isMagicSquare(new int[][]{{4, 8, 4}, {5, 1, 9}, {7, 6, 2}});
    Assert.assertTrue(magicSquare);
    Assert.assertFalse(notMagicSquare);
    Assert.assertFalse(notMagicSquare1);
  }

  @Test
  public void numMagicSquaresInsideSuccess() {
    int num = magicSquare.numMagicSquaresInside(new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}});
    Assert.assertEquals(num,1);
  }

}
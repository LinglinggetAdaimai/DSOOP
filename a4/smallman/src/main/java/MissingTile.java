public class MissingTile {
  public static void tileGrid(Grid board){
      setTileHelper(0,0,board.size(), board.getPaintedCellX(), board.getPaintedCellY(), board);
  }

  public static void setTileHelper(int startX, int startY, int subGridsize, int paintedX, int paintedY, Grid ori_grid){
    if (subGridsize == 2) {
      switch (getDirection(paintedX, paintedY, subGridsize)) { // checked and fins with size 2
        case 0: // checked
          ori_grid.setTile(startX + 1, startY, 0);// checked
          break;
        case 1: // checked
          ori_grid.setTile(startX + 1, startY + 1, 1); // checked
          break;
        case 2: // checked
          ori_grid.setTile(startX, startY + 1, 2); // checked
          break;
        case 3: // checked
          ori_grid.setTile(startX, startY, 3); // checked

      }
    }
    else {
      int newsize = (subGridsize / 2);
      switch (getDirection(paintedX, paintedY, subGridsize)) {
        case 0:
          ori_grid.setTile(startX + newsize, (startY + newsize) - 1, 0); // set tile for the original
          // NW quardrant
          setTileHelper(startX , startY, newsize, convertPaintedX(newsize - 1, newsize), convertPaintedY(newsize - 1, newsize), ori_grid);
          // NE quardrant
          setTileHelper(startX + newsize, startY, newsize, convertPaintedX(paintedX, newsize), convertPaintedY(paintedY, newsize), ori_grid);
          // SE quardrant check paited y
          setTileHelper(startX + newsize, startY + newsize, newsize, convertPaintedX(newsize, newsize), convertPaintedY(newsize, newsize), ori_grid);
          // SW quardrant
          setTileHelper(startX, startY +newsize, newsize, convertPaintedX((newsize) - 1, newsize), convertPaintedY(newsize, newsize), ori_grid);
          break;
        case 1:
          ori_grid.setTile(startX + newsize, startY + newsize, 1); // set tile for the original
          // NW quardrant
          setTileHelper(startX, startY, newsize, convertPaintedX((newsize) - 1, newsize), convertPaintedY((newsize) - 1, newsize), ori_grid);
          // NE quardrant
          setTileHelper(startX + newsize, startY, newsize, convertPaintedX(newsize, newsize), convertPaintedY((newsize) - 1, newsize), ori_grid);
          // SE quardrant
          setTileHelper(startX + newsize, startY + newsize, newsize, convertPaintedX(paintedX, newsize), convertPaintedY(paintedY, newsize), ori_grid);
          // SW quardrant
          setTileHelper(startX, startY + newsize, newsize, convertPaintedX((newsize) - 1, newsize), convertPaintedY(newsize, newsize), ori_grid);
          break;
        case 2:
          ori_grid.setTile((startX + newsize)- 1, startY + newsize, 2); // set tile for the original
          // NW quardrant
          setTileHelper(startX, startY, newsize, convertPaintedX((newsize) - 1, newsize), convertPaintedY((newsize) - 1, newsize), ori_grid);
          // NE quardrant
          setTileHelper(startX + newsize, startY, newsize, convertPaintedX(newsize, newsize), convertPaintedY((newsize) - 1, newsize), ori_grid);
          // SE quardrant
          setTileHelper(startX + newsize, startY + newsize, newsize, convertPaintedX(newsize, newsize), convertPaintedY(newsize, newsize), ori_grid);
          // SW quardrant
          setTileHelper(startX, startY+newsize, newsize, convertPaintedX(paintedX, newsize), convertPaintedY(paintedY, newsize), ori_grid);
          break;
        case 3:
          ori_grid.setTile((startX + newsize)-1, (startY + newsize)-1, 3); // set tile for the original // checked
          // NW quardrant
          setTileHelper(startX, startY, newsize, convertPaintedX(paintedX, newsize), convertPaintedY(paintedY, newsize), ori_grid);
          // NE quardrant
          setTileHelper(startX + newsize, startY, newsize, convertPaintedX(newsize, newsize), convertPaintedY(newsize - 1, newsize), ori_grid);
          // SE quardrant
          setTileHelper(startX + newsize, startY + newsize, newsize, convertPaintedX( newsize, newsize), convertPaintedY(newsize, newsize), ori_grid);
          // SW quardrant
          setTileHelper(startX, startY + newsize, newsize, convertPaintedX((newsize) - 1, newsize), convertPaintedY(newsize, newsize), ori_grid);
          break;
      }
    }
  }

  public static int getDirection(int paintedX, int paintedY, int size){
    int sizeDtwo = size/2;
    if (paintedX >= sizeDtwo && paintedY < sizeDtwo) return 0; // NorthEast
    if (paintedX >= sizeDtwo && paintedY >= sizeDtwo) return 1; // SouthEast
    if (paintedX < sizeDtwo && paintedY >= sizeDtwo) return 2; // SouthEast
    if (paintedX < sizeDtwo && paintedY < sizeDtwo) return 3; // NorthWest

    return 0;
  }

  public static int convertPaintedX (int paintedX, int size){
    // convert the painted x from the bigger gird to a smaller grid
    if (paintedX >= size) return paintedX - size;
    return paintedX;
  }

  public static int convertPaintedY (int paintedY, int size){
    // convert the painted x from the bigger gird to a smaller grid
    if (paintedY >= size) return paintedY - size;
    return paintedY;
  }

}

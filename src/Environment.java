
public class Environment
{

	int r;
	int c;
	private Cell[][] cells = new Cell[r][c];

	/*
	 * @ rows the number of rows in the 2D environment array
	 * 
	 * @ cols the number of columns in the 2D environment array
	 */
	public Environment(int rows, int cols)
	{
		r = rows;
		c = cols;

	}

	/*
	 * Populate the cell in a particular coordinate location
	 * 
	 * @r the row address of the 2D array
	 * 
	 * @c the column address of the 2D array
	 * 
	 * @cell the cell object that you want to put in that "table" location
	 */
	public void fillCell(int r, int c, Cell cell)
	{
		System.out.println("h");
		cells[r][c] = cell;

	}

	/*
	 * return the cell object from a particular x,y location in 2D environment array
	 * 
	 * @r row coordinate from 2D environment array
	 * 
	 * @c column coordinate from 2D environment array
	 */
	public Cell getCell(int r, int c)
	{
		if (cells != null)
		{

			return cells[r][c];
		} else
		{
			return null;
		}

	}

}

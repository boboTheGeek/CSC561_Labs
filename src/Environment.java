
public class Environment
{

	private Cell[][] cells;

	/*
	 * Initialize environment instance with specified 2D dimensions
	 * 
	 * @param rows - the number of rows in the 2D environment array
	 * 
	 * @param cols - the number of columns in the 2D environment array
	 */
	public Environment(int rows, int cols)
	{

		cells = new Cell[rows][cols];

	}

	/*
	 * Populate the cell in a particular coordinate location
	 * 
	 * @param row - the row address of the 2D array
	 * 
	 * @param col - the column address of the 2D array
	 * 
	 * @param cell - the cell object that you want to put in that "table" location
	 * 
	 * boolean addLifeForm(int row, int col, LifeForm entity)
	 * Adds a LifeForm to the Cell theCells[row][col]. Will not add the
	 * LifeForm if the row and col are invalid or if a LifeForm is already in 
	 * that Cell. Returns true if successfully added, false otherwise.
	 */
	public boolean addLifeForm(int row, int col, Cell cell)
	{
		if (cells[row][col] == null)
		{
			cells[row][col] = cell;
			return true;
		}
		else
		{
			return false;
		}


		

	}

	/*
	 * return the cell object from a particular x,y location in 2D environment array
	 * 
	 * @param row - row coordinate from 2D environment array
	 * 
	 * @param col - column coordinate from 2D environment array
	 * 
	 * @return requested cell (null if empty)
	 */
	public Cell getCell(int row, int col)
	{
		if (cells != null)
		{

			return cells[row][col];
		}
		else
		{
			return null;
		}

	}

	/*
	 * Removes the LifeForm at theCells[row][col]. Returns the LifeForm removed
	 * (null if no LifeForm in the Cell).
	 * 
	 * @param row - row coordinate from 2D environment array
	 * 
	 * @param col - column coordinate from 2D environment array
	 * 
	 * @return life form removed else null
	 */
	public LifeForm removeLifeForm(int row, int col)
	{
		if (cells[row][col] != null)
		{
			LifeForm removeMe = cells[row][col].getLifeForm();
			cells[row][col].addLifeForm(null);
			return removeMe;
		}
		else
		{
			return null;
		}

	}

}

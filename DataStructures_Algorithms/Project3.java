/**
 * Created by athompson on 11/13/2015.
 *
 * Alexander Mark Thompson
 *
 * CS 360 -- Project 3 -- Word Search
 *
 * Description: This project reads a text file and stores the words to be searched for in a HashSet, then using
 * Depth First Search, the program searches through a 2D array that the puzzle is stored in, and then checks to see
 * if that value is in the HashSet, if it is then it has found the word, and if not then it continues through the
 * puzzle.
 */
 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.lang.StringBuilder;
 
public class Project3 {
    public static void main(String[] args)
    {
        ReadFile file = new ReadFile();
        String[][] puzzle = file.readPuzzle();
        Set words = new HashSet<>();
        words = file.words();
        DFS dfs = new DFS();
        int length = puzzle[0].length;
        boolean[][] visited = new boolean[length][length];
        for(int i=0; i<length; i++)
        {
            for(int j = 0; j < length; j++)
            {
                //Initializing all the values of visited to false
                visited[i][j] = false;
            }
        }
        
        //Calling the Depth First Search class initializing the starting row and starting column to 0
        dfs.dfs(0, 0, puzzle, visited, words);
    }
}
 
/*
Class to read in both files, the 'puzzle.txt' and 'words.txt' and stores the puzzle file in a 2D array using the method
called 'readPuzzle()' with a return type of String[][], and stores the words file in a HashSet with the 'words()'
method with a return type of Set.
 */
 
class ReadFile
{
    BufferedReader puzzleBR = null;
    private String nameLine;
    String[][] empty = new String[0][0];
    String[][] puzzle;
    int i = 0;
 
    /*
    Reads the 'puzzle.txt' file using a FileReader and then uses it in a BufferedReader to be able to read the lines
    of the file. The first line is set to a String variable called len, to then be converted into a integer which is then
    stored in an integer variable I call length. This variable is used to initialize the 2D array set above called puzzle.
    The method then goes through a while loop that is saying ' as long as there is something to read in the file ' do
    what is inside. It stores the lines in puzzle. This is all within a try statement, which is followed by catch
    statements that catch if the file cannot be found, or an IOException. The method is concluded with a 'finally'
    statement that closes the BufferedReader, and then catches an IOException if there is one.
     */
    
    public String[][] readPuzzle()
    {
        try
        {
            puzzleBR = new BufferedReader(new FileReader("puzzle.txt"));
            nameLine = null;
            String len = puzzleBR.readLine();
            int length = Integer.parseInt(len);  //len being converted to an integer
            puzzle = new String[length][length];  //puzzle being initialized
            while((nameLine = puzzleBR.readLine()) != null)
            {
                puzzle[i] = nameLine.split(" ");  //Stores the lines in puzzle
                i++;
            }
            return puzzle;
        }catch(FileNotFoundException e){
            e.printStackTrace();  //catches FileNotFoundException
        }catch(IOException e){
            e.printStackTrace();  //catches IOException
        }finally{
            if(puzzleBR != null)
            {
                try{
                    puzzleBR.close();  //closes BufferedReader
                }catch(IOException e){
                    e.printStackTrace();  //IOException is caught if there is one
                }
            }
        }
        return empty;  //Needs this since the return type for this method is String[][]
    }
 
    /*
     * This method initializes a variable of the type Set<String> into a new HashSet<String> and then tries to Scan in the file
     * 'words.txt' and adds the lines to the variable initialized at the beginning. If the file is not found or there is an IOException,
     * then an error message is printed instead of storing the lines in the Set.
     */
    
    public Set words()
    {
        Set<String> wordSet = new HashSet<String>();
 
        try {
        	
        	//Creating the Scanner to scan the file 'words.txt'
            Scanner file = new Scanner(new File("words.txt"));  
 
            while (file.hasNext()) {
                String line = file.nextLine();
                for (String word : line.split(" ")) {
                    wordSet.add(word);  //Storing the lines from the file 'words.txt'
                }
            }
            file.close();
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return wordSet;
    }
}
 
/*
 * This is my Depth First Search Class. It first creates an array of strings that stores what the different directions should be.
 * Then inside the class, I create a StringBuilder called builder. Then my first method makes sure that the movement that is taking place
 * is a valid movement. What is meant by a valid movement is that there is somewhere to go, for instance if you start at the top left of 
 * the puzzle north, northeast, northwest, and southwest are all not valid movements because there are no letters in those directions. Then
 * the next method is where I take into effect the movement in the different directions based of which letter from the directions String 
 * array initialized at the beginning. The last method is my depth first search. It iterates through the puzzle, and for each direction as 
 * long as it is a valid movement a 2D array called visited, is set to true. Then the letters from the puzzle are added to the 
 * StringBuilder. Next the method checks to see if a word is in the StringBuilder, and if so it is printed along with how many spaces 
 * over, down and what direction the word is at. Next, recursion happens since the next letter is false meaning it has not been visited 
 * yet. Finally, the row and col variables are incremented depending on the direction. 
 */

class DFS
{
    String[] directions = {"N", "S", "E", "W", "NW", "NE", "SE", "SW"};  //String array that the directions are stored in
    StringBuilder builder = new StringBuilder();  //StringBuillder is created
 
    /*
     * boolean method to check to see if a movement is valid
     * @param dirs is the directions
     * @param len is the puzzle size
    */
    boolean isValid(int row, int col, int[] dirs, int len)
    {
        if (row + dirs[0] < -1 || row + dirs[0] >= len+1)
        {
            return false;
        }
        if (col + dirs[1] < -1 || col + dirs[1] >= len+1)
        {
            return false;
        }
        return true;
    }
 
    int[] changeDirection(String direction)
    {
    	//North Direction
        if(direction == "N")
        {
            int[] n = {-1,0};
            return n;
        }
        //South Direction
        else if(direction == "S")
        {
            int[] s = {1,0};
            return s;
        }
        //East Direction
        else if(direction == "E")
        {
            int[] e = {0,1};
            return e;
        }
        //West Direction
        else if(direction == "W")
        {
            int[] w = {0,-1};
            return w;
        }
        //North West Direction
        else if (direction == "NW")
        {
            int[] nw = {-1,-1};
            return nw;
        }
        //North East Direction
        else if(direction == "NE")
        {
            int[] ne = {-1,1};
            return ne;
        }
        //South East Direction
        else if(direction == "SE")
        {
            int[] se = {1,1};
            return se;
        }
        //South West Direction
        else if(direction == "SW")
        {
            int[] sw = {1,-1};
            return sw;
        }
        else{
            return null;
        }
    }
 
 
    void dfs(int startRow, int startCol, String[][] board, boolean[][] visited, Set words) {
        String word;  //initializes what to add to the StringBuilder
        int row = 0;  //initializes the row to 0
        int col = 0;  //initializes the col to 0
        for (; startRow < board[0].length; startRow++) {
            for (; startCol < board[0].length; startCol++) {
                for (String direction : directions) {
                    row = startRow;
                    col = startCol;
                    while (isValid(row, col, changeDirection(direction), board[0].length)) {
                        visited[startRow][startCol] = true;
                        word = board[row][col];
                        builder.append(word);  //adds the letters to the StringBuilder
                        if (words.contains(builder.toString())) {
                            String found = builder.toString() + "(" + (startCol + 1) + "," + (startRow+1) + ","
                                    + direction + ")";
                            System.out.println(found);
                        }
                        if (!visited[startRow][startCol]) {
                        	//Recursion step
                            dfs(row, col, board, visited, words);
                        }
                        row += changeDirection(direction)[0];  //increments the row by the given direction
                        col += changeDirection(direction)[1];  //increments the col by the given direction
                    }
                    builder.setLength(0);
                }
            }
            startCol = 0;
        }
 
    }
}

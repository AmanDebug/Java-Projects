import java.util.*;

public class tic {
    private String[][] arr = new String[3][3];
    private Scanner ob = new Scanner(System.in);
    private Random rand = new Random();

    public tic() {
        // initialize board with "-"
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                arr[i][j] = "-";
    }
}
    }
//first is for HUMAN vs COMPUTER where we follow
//user move
//check win
//computer move
//check win
    public void first() {


        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                arr[i][j] = "-";
    }
}

        System.out.println("You have X. Choose an option between 1 and 9 (layout: 1..3 top row, 7..9 bottom row)");
        printBoard();
        boolean gameover= false;
        while(!gameover){

// User's turn
        int chance1 = 0;
        while (true) { // repeat until valid input & empty cell
            System.out.print("Enter your move (1-9): ");
            if (!ob.hasNextInt()) { // not an integer
                System.out.println("Wrong input — not a number. Try again.");
                ob.next(); // consume the bad token
                continue;
            }

            chance1 = ob.nextInt();
            if (chance1 < 1 || chance1 > 9) {
                System.out.println("Number must be between 1 and 9. Try again.");
                continue;
            }

            int r = (chance1 - 1) / 3;
            int c = (chance1 - 1) % 3;

            if (!arr[r][c].equals("-")) { // cell already taken
                System.out.println("Cell already chosen. Pick a different one.");
                continue;
            }

            arr[r][c] = "X";
            break;
        }

        printBoard();




//check win
        String win= checkWin();
        if(win!=null){
            if(win.equals("X"))
                System.out.println("USER WINS");
            else
                System.out.println("COMPUTER WINS");
            gameover=true;
            printBoard();
            return;
        }
        if(boardFull()){//checks for draw
            System.out.println("DRAW");
            gameover= true;
            printBoard();
        }

     



// Computer's turn
        int compInp;
        while (true) {
            compInp = rand.nextInt(9) + 1; // 1..9
            int r = (compInp - 1) / 3;
            int c = (compInp - 1) % 3;
            if (arr[r][c].equals("-")) {
                arr[r][c] = "O";
                System.out.println("Computer chose: " + compInp);
                break;
            }
            // else keep trying
        }

        printBoard();






//check win
        win= checkWin();
        if(win!=null){
            if(win.equals("X"))
                System.out.println("USER WINS");
            else
                System.out.println("COMPUTER WINS");
            gameover=true;
            printBoard();
            return;
        }
        if(boardFull()){//checks for draw
            System.out.println("DRAW");
            gameover= true;
            printBoard();
        }



    }

    choose();
    }

//this is for human vs human
//user1 turn
//check win
//user 2 turn
//check win
    public void second(){

        
        //clear the array or playing board
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                arr[i][j] = "-";
    }
}
        //each player is denoted by X and O. They will each get a chance
        boolean gameover= false;
        boolean Turn= true; //true for X false for O
        while(!gameover){
            String currentPlayer= Turn ?"X":"O";
            System.out.println("Player "+currentPlayer+" turn");

            int move=0;
            while (true) {
                System.out.print("Enter your move (1-9): ");
                printBoard();
                if (!ob.hasNextInt()) {
                    System.out.println("Wrong input — not a number. Try again.");
                    ob.next(); // consume bad token
                    continue;
                }

                move= ob.nextInt();
                if(move<1 || move>9){
                    System.out.println("your input must be between 1 to 9");
                    continue;
                }
                int r = (move - 1) / 3;
                int c = (move - 1) % 3;

                if (!arr[r][c].equals("-")) {
                    System.out.println("Cell already chosen. Pick a different one.");
                    continue;
                }
                arr[r][c]= currentPlayer;
                break;
            }
            printBoard();

            //check win
            String win= checkWin();
            if(win!=null){
                System.out.println("player "+win+" wins");
                gameover=true;
                printBoard();
                return;
                
            }

            if (boardFull()) {
                System.out.println("Draw!");
                gameover = true;
                printBoard();
                return;
            }
            //switch turn
            Turn= !Turn;

        }


        choose();
    }



    private String checkWin(){
        
        String win= null;
        //rows
        if((!arr[0][0].equals("-"))&&arr[0][0].equals(arr[0][1])&&arr[0][0].equals(arr[0][2]))//1st row
            win= arr[0][0];
        else if((!arr[1][0].equals("-"))&&arr[1][0].equals(arr[1][1])&&arr[1][0].equals(arr[1][2]))//2nd row
            win= arr[1][0];
        else if((!arr[2][0].equals("-"))&&arr[2][0].equals(arr[2][1])&&arr[2][0].equals(arr[2][2]))
            win = arr[2][0];

        //columns
        else if((!arr[0][0].equals("-"))&&arr[0][0].equals(arr[1][0])&&arr[0][0].equals(arr[2][0]))//1st column
            win= arr[0][0];
        else if((!arr[0][1].equals("-"))&&arr[0][1].equals(arr[1][1])&&arr[0][1].equals(arr[2][1]))//2nd column
            win= arr[0][1];
        else if((!arr[0][2].equals("-"))&&arr[0][2].equals(arr[1][2])&&arr[0][2].equals(arr[2][2]))//3rd column
        win= arr[0][2];

        //diagonals
        else if((!arr[0][0].equals("-"))&&arr[0][0].equals(arr[1][1])&&arr[0][0].equals(arr[2][2]))//1st diagonal
        win= arr[0][0];
        else if((!arr[0][2].equals("-"))&&arr[0][2].equals(arr[1][1])&&arr[0][2].equals(arr[2][0]))
            win= arr[0][2];

        return win;
    }
    private boolean boardFull() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (arr[i][j].equals("-")) {
                return false;
            }
        }
    }
    return true;
}
    private void printBoard() {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }

        
    }
    public void choose(){
        while(true){
        System.out.println("1. Human vs Computer");
        System.out.println("2. Human vs Human");
        System.out.println("3. Exit");
        int choice= ob.nextInt();
        switch (choice){
        case 1:
            first();
            break;

        case 2:
            second();
            break;
            

        case 3:
            System.out.println("thank you for playing");
            return ;

        default:
            System.out.println("wrong input");
    }
    }
    }
    public static void main(String[] args) {
        tic game = new tic();
        System.out.println("Hi Player. Welcome to the TIC TAC TOE game. What do you want to play today?");
        
        game.choose();
    }
}

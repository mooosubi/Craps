//Calculations


//this class does the bulk of calculations
//for the project

public class CalculationsClass {

    //declare class variables
    private double sumOfDice;
  
    private static double point = 0;  
    private static boolean GameStatus = false;
  
    private String winLoss = "";

    //create a class constr.uctor
    //its the first method that runs in the class
    //it really just sets things up
    //the constructor has the same name as the class
  
    CalculationsClass(double theDiceSum)
    { 
        sumOfDice = theDiceSum;
    }
    
    private void CalculateWinLoss()
    {
        if(GameStatus == false)
        {
            if(sumOfDice == 7 || sumOfDice == 11)
            {
                winLoss = "You won on your first roll! Roll to play again";
                point = 0;

            }
            else if(sumOfDice == 2 || sumOfDice == 3 || sumOfDice == 11)
            {
                winLoss = "You lost on your first roll! Roll to play again";
                point = 0;
            }
            else
            {
                point = sumOfDice;
                winLoss = "Point: " + point;
                GameStatus = true;

            }
        }
        else if(GameStatus == true)
        {
            if(sumOfDice == 7)
            {
                winLoss = "You lost! Your point was: " + point + ".  Roll to play again";
                GameStatus = false;
                point = 0;
            }
            else if(sumOfDice == point)
            {
                winLoss = "You won! Your point was " + point + " .  Roll to play again";
                GameStatus = false;
                point = 0;

            }
            else
            {
                winLoss = "Keep rolling! Your point is " + point + ".  Roll to play again"; 
            }
        }
    }
    public String getString()
    {
        CalculateWinLoss();
        return winLoss;
    }
  }
  
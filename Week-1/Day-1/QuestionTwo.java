public class QuestionTwo {
    public static String rps(String p1, String p2) {
      
      
      if(p1.equals(p2)){
        return "Draw!";
        
      }
      
      switch(p1){
          case "paper":
          return p2.equals("rock") ? "Player 1 won!" : "Player 2 won!";
           case "rock":
          return p2.equals("scissors") ? "Player 1 won!" : "Player 2 won!";
           case "scissors":
          return p2.equals("paper") ? "Player 1 won!" : "Player 2 won!";
          default:
          return "Input please";
      }
    }
  }
import java.util.*;

/**
 * Put your name and student id here
 * Name: Pusanisa Jarusiripat
 * ID: 6580564
 */

/*
 * The ScoreKeeper class stores scores and answers basic statistical average
 * about the scores. It is intended to be use as part of another class for
 * score storage.
 */
public class ScoreKeeper {
   // Declare private member variables as needed
   double[] scores;

   public ScoreKeeper() {
      // Create an instance for this.scores
      this.scores = null;
   }
   
   /*
    * Record the scores given by double[] scores into your instance variable
    * scores. If the member variable already has existing data, clear it before
    * putting in the new scores.
    */
   public void setScores(double[] scores) { 
      
      // malloc by the size and put the number in
      this.scores = new double[scores.length]; 
      this.scores = scores;

   }
   
   // Return an array double[] of scores as was previously set
   public double[] getScores() { 
      return scores;
   }
  
   /*
    * Return the average of the scores after excluding the minimum and maximum
    * value. In short, it should return 
    *   (SUM(this.scores) - MIN(this.scores) - MAX(this.scores))/(n-2), where
    * n is the length of the score list. This function will return Double.NaN if 
    * n is <= 2 because no meaningful average can be computed.
    */
   public double getCalibratedAverage() {

      // if less than 2 elements then we return null
         // if not then return the sum of the avg of the scores w/o max,min

      if (this.scores.length <= 2) {
         return Double.NaN;
      }
      else {
         double[] array = this.scores;
         int n = array.length;
         Arrays.sort(array);
         double sum = (Arrays.stream(array).sum()) - array[0] - array[n-1];
         return sum/(n-2);
      }
      
   }
   
   public static void main(String[] args) {
      System.out.println("=== ScoreKeeper ===");
      double[] sampleScores0 = {2.5, 1.0, 9.8, 5.4, 3.3, 0.25, 4.25};
      double[] sampleScores1 = {0.5, 9};

      ScoreKeeper scoreKeeper0 = new ScoreKeeper();
      scoreKeeper0.setScores(sampleScores0);
      System.out.println("scoreKeeper0: " + Arrays.toString(scoreKeeper0.getScores()));
      System.out.println("Calibrated Average: " + scoreKeeper0.getCalibratedAverage());

      System.out.printf("\n");
      
      ScoreKeeper scoreKeeper1 = new ScoreKeeper();
      scoreKeeper1.setScores(sampleScores1);
      System.out.println("scoreKeeper1: " + Arrays.toString(scoreKeeper1.getScores()));
      System.out.println("Calibrated Average: " + scoreKeeper1.getCalibratedAverage());
   }
}

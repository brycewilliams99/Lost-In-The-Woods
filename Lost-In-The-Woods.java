import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import javax.print.DocFlavor.URL;
import javax.sound.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
public class SEFinalProject{

  //Menu method to take care of main menu for user.
  static void Menu() throws IOException, InterruptedException{
    Scanner sc = new Scanner(System.in);

    System.out.println("Welcome!");
    System.out.println();
    System.out.println("Enter the number cooresponding to what you want grade you would like to do!");
    System.out.println("1. Grades K-2");
    System.out.println("2. Grades 3-5");
    System.out.println("3. Grades 6-8");
    System.out.println("4. Exit Program");
    System.out.print("Enter choice: ");
    int choice = sc.nextInt();

    while(choice == 0 || choice > 4){
      System.out.println("Invalid choice! Try Again!");
      System.out.print("Enter choice: ");
      choice = sc.nextInt();
    }
    if (choice == 1){
      System.out.println("Grades K-2!");
      System.out.println();
      GradesK2();
    }
    else if (choice == 2) {
      System.out.println("Grades 3-5!");
      System.out.println();
      Grades3_5();
    }
    else if (choice == 3){
      System.out.println("Grades 6-8!");
      System.out.println();
      Grades6_8();
    }
    else {
      System.exit(0);
    }
  }

  //Grades6-8 Method
  static void Grades6_8()throws IOException, InterruptedException {
   Grades6_8 g68 = new Grades6_8();
   g68.simulate();
  }


  //Grades3-5 Method
  static void Grades3_5() throws IOException, InterruptedException {
   Grades3_5 g35 = new Grades3_5();
   g35.simulate();
  }

  //GradesK2 Method
  static void GradesK2() throws IOException, InterruptedException{
    Scanner sc = new Scanner(System.in);

    int prog_restart = 0;

    while (prog_restart != 1){
      int choice = 0;

      while (choice == 0){
        System.out.println("Enter the size of the forest between 2 and 50!");
        System.out.println("The forest will be a square!");
        System.out.print("Enter size: ");
        int size_of_forest = sc.nextInt();
        System.out.println();

        //Check to see if number meets requirements
        if (size_of_forest < 2 | size_of_forest > 50){
          System.out.println("Error, not a valid size number! Try again!");
          System.out.println();
        }
        else{
          System.out.println("The number that was selected for the size was: " + size_of_forest);
          System.out.println();
          choice += 1;
        }

        int[][] forest = new int[size_of_forest][size_of_forest];

        int x1 = 0;
        int y1 = 0;
        int x2 = size_of_forest - 1;
        int y2 = size_of_forest - 1;
        int player2P = 2;
        int player1P = 1;
        int player1_move = 0;
        int player2_check = 0;
        int player2_move = 0;
        int player1_counter = 0;
        int player2_counter = 0;


        Random rand = new Random();
        forest[x1][y1] = player1P;
        forest[x2][y2] = player2P;

        int[] coords = {x1+1, y1+1, x2+1, y2+1};
        ForestGraphics fg = new ForestGraphics(size_of_forest, size_of_forest, coords);

        System.out.println();


        while (player1_counter != 1000000 && player2_counter != 1000000){

          if (forest[x1][y1] == forest[x2][y2]){
            break;
          }
          else{

            int player1_check = 0;
          while (player1_check != 1){

          player1_move = rand.nextInt(9);

          if (player1_move == 1){ //Move Player1 North
            if (x1 - 1 < 0) {
              continue;
            }
            else{
              x1 -= 1;
              forest[x1][y1] = player1P;
              player1_check += 1;
              player1_counter += 1;
            }
          }

          else if (player1_move ==2) { //Move Player1 South
            if (x1 + 1 >= size_of_forest){
              continue;
            }
            else{
              x1 += 1;
              forest[x1][y1] = player1P;
              player1_check += 1;
              player1_counter += 1;
            }
          }

          else if (player1_move == 3) { //Move Player1 East
            if (y1 + 1 >= size_of_forest){
              continue;
            }
            else{
              y1 += 1;
              forest[x1][y1] = player1P;
              player1_check += 1;
              player1_counter += 1;
            }
          }

          else if (player1_move == 4) {  //Move Player1 West
            if (y1 - 1 < 0) {
              continue;
            }
            else{
              y1 -= 1;
              forest[x1][y1] = player1P;
              player1_check += 1;
              player1_counter += 1;
            }
          }

          else if (player1_move == 5){ //Move Player 1 NorthEast
            if (x1 - 1 < 0 | y1 + 1 >= size_of_forest){
              continue;
            }
            else{
              x1 -= 1;
              y1 += 1;
              forest[x1][y1] = player1P;
              player1_check += 1;
              player1_counter += 1;
            }
          }

          else if (player1_move == 6){ //Move Player1 NorthWest
            if (x1 - 1 < 0 | y1 - 1 < 0){
              continue;
            }
            else{
              x1 -= 1;
              y1 -= 1;
              forest[x1][y1] = player1P;
              player1_check += 1;
              player1_counter += 1;
            }
          }

          else if (player1_move == 7){ //Move Player1 SouthEast
            if (x1 + 1 >= size_of_forest | y1 + 1 >= size_of_forest){
              continue;
            }
            else{
              x1 += 1;
              y1 += 1;
              forest[x1][y1] = player1P;
              player1_check += 1;
              player1_counter += 1;
            }
          }

          else if (player1_move == 8){
            if (x1 + 1 >= size_of_forest | y1 - 1 < 0){ //Move Player1 SouthWest
              continue;
            }
            else{
              x1 += 1;
              y1 -= 1;
              forest[x1][y1] = player1P;
              player1_check += 1;
              player1_counter += 1;
            }
          }

          else{
            continue;
          }
          }

          player2_check = 0;
          while (player2_check != 1){
            player2_move = rand.nextInt(9);
            //System.out.println(player2_move + " player 2");

            if (player2_move == 1){ //Move Player2 North
              if (x2 - 1 < 0){
                continue;
              }
              else{
                x2 -= 1;
                forest[x2][y2] = player2P;
                player2_check += 1;
                player2_counter += 1;
              }
            }

            else if (player2_move == 2){ //Move Player2 South
              if (x2 + 1 >= size_of_forest){
                continue;
              }
              else{
                x2 += 1;
                forest[x2][y2] = player2P;
                player2_check += 1;
                player2_counter += 1;
              }
            }

            else if (player2_move == 3){ //Move Player2 East
              if(y2 + 1 >= size_of_forest){
                continue;
              }
              else{
                y2 += 1;
                forest[x2][y2] = player2P;
                player2_check += 1;
                player2_counter += 1;
              }
            }

            else if (player2_move == 4){ //Move Player2 West
              if(y2 - 1 < 0){
                continue;
              }
              else{
                y2 -= 1;
                forest[x2][y2] = player2P;
                player2_check += 1;
                player2_counter += 1;
              }
            }

            else if (player2_move == 5){ //Move Player2 NorthEast
              if(x2 - 1 <= 0 | y2 + 1 >= size_of_forest){
                continue;
              }
              else{
                x2 -= 1;
                y2 += 1;
                forest[x2][y2] = player2P;
                player2_check += 1;
                player2_counter += 1;
              }
            }

            else if (player2_move == 6){ //Move Player2 NorthWest
              if(x2 - 1 < 0 | y2 - 1 < 0){
                continue;
              }
              else{
                x2 -= 1;
                y2 -= 1;
                forest[x2][y2] = player2P;
                player2_check += 1;
                player2_counter += 1;
              }
            }

            else if (player2_move == 7){ //Move Player SouthEast
              if (x2 + 1 >= size_of_forest | y2 + 1 >= size_of_forest){
                continue;
              }
              else{
                x2 += 1;
                y2 += 1;
                forest[x2][y2] = player2P;
                player2_check += 1;
                player2_counter += 1;
              }
            }

            else if (player2_move == 8){
              if (x2 + 1 >= size_of_forest | y2 - 1 < 0){ //Move Player2 SouthWest
                continue;
              }
              else{
                x2 += 1;
                y2 -= 1;
                forest[x2][y2] = player2P;
                player2_check += 1;
                player2_counter += 1;
              }
            }

            else{
              continue;
            }

          }

        }
          Thread.sleep(800);
          coords[0] = x1+1;
          coords[1] = y1+1;
          coords[2] = x2+1;
          coords[3] = y2+1;
          fg.updateCoords(coords);
        }


        fg.successfulMeeting();
        System.out.println("They found each other at " + (x2+1) + "," + (y2+1));
        fg.closeFrame();
      }

      System.out.println("Would you like to do the program over again? (Y/N)");
      char prog_check = sc.next().charAt(0);
      if (prog_check == 'Y'){
        continue;
      }
      else{
        prog_restart += 1;
      }
      Menu();
    }

  }



  public static void main(String[] args) throws IOException, InterruptedException{
    Scanner sc = new Scanner(System.in);
    Menu();
  }
}

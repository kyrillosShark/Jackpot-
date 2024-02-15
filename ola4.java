package ola3;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import java.util.Arrays;
import java.util.Random;
import java.text.DecimalFormat;
public class OLA3 extends Application implements EventHandler<ActionEvent>
{
	public String cardDeck(int whatNumber) {//function that inputs all of the car
		String[] array= new String[53];//into an array. Takes any number and returns 
		for (int i = 1; i < 53; i++) { //the array value
		
            array[i]= i+".png";
           
        }
		    
           return array[whatNumber];
		
	}
	
	
    
public static void main(String[] args) {
    Application.launch(args);
  }
  @Override
  public void start(Stage primaryStage) {//setting up stage
    DecimalFormat decimal= new DecimalFormat("0.00");
	primaryStage.setTitle("OLA4_sharkawy");//title
    StackPane finalStrucure= new StackPane();//stackpane to place all the constituents on
    HBox root= new HBox(); //all of the VBOX and Hbox elements
    VBox vb= new VBox();
    VBox vb2=new VBox();
    root.setPadding(new Insets(2,2,2,2));
    root.setAlignment(Pos.TOP_CENTER);
   
    vb.setPadding(new Insets(5,5,5,5));
    vb2.setPadding(new Insets(10,10,10,10));
    
    
    Image image= new Image("0.png");
    ImageView firstCard= new ImageView(image);
    firstCard.setFitHeight(100);
    firstCard.setFitWidth(88);                      //setting up all of the initial card view
    
    

    Image image2= new Image("0.png");
    ImageView secondCard= new ImageView(image2);      //for all the cards
    secondCard.setFitHeight(100);
    secondCard.setFitWidth(88);
    
    

    Image image3= new Image("0.png");
    ImageView thirdCard= new ImageView(image3);
    thirdCard.setFitHeight(100);
    thirdCard.setFitWidth(88);
    
    Image image4= new Image("0.png");
    ImageView fourthCard= new ImageView(image4);
    fourthCard.setFitHeight(100);
    fourthCard.setFitWidth(88);
    
    
    
    
    root.getChildren().addAll(firstCard,secondCard,thirdCard,fourthCard); //adding cards to HBox
   
    vb.setAlignment(Pos.CENTER);
    
    
    Label label1 = new Label("Amount Inserted: $");
               //default labels
    
    Label label5=new Label("Amount won this spin: $0.00");
    Label label3= new Label("Total Amount Won: $0.00");
    Label label2= new Label("So far you spent: $0.00");
    Label label4=new Label("Insert an amount to play");
    
    TextField text = new TextField ();
    HBox hb = new HBox();
    
    
    
 
   
    hb.getChildren().addAll(label1, text);
    hb.setSpacing(10);
    hb.setAlignment(Pos.CENTER);
    
    text.setOnAction(this);
    
    Button but=new Button("Spin");
    but.setOnAction(new EventHandler<ActionEvent>()
    {
    	double totalSpent=0;
 	    double winTotal=0;
    	@Override
    	public void handle(ActionEvent event)
    	{
    	   
    	   int winCounter=0;
    	try                                           //validate user input
    	{
           String userInp= text.getText();
    	   double userInpValue=Double.parseDouble(userInp);
           label1.setText("Amount Inserted: $");
           Random rand= new Random();
           int firstR =rand.nextInt(1,52);
           firstCard.setImage(new Image(cardDeck(firstR)));
           int secondR =rand.nextInt(1,52);
           secondCard.setImage(new Image(cardDeck(secondR)));
           int thirdR =rand.nextInt(1,52);
           thirdCard.setImage(new Image(cardDeck(thirdR)));
           int fourthR =rand.nextInt(1,52);
           
           fourthCard.setImage(new Image(cardDeck(fourthR)));
           text.clear();  
           System.out.println(userInp);
           
          
           if (firstR==secondR)
        	    winCounter+=1;
        	    // if two of the cards are the same update win counter
           if (firstR==thirdR)
        	   winCounter+=1;
           if(firstR==fourthR)
        	   winCounter+=1;
           if (secondR==thirdR)
           {
        	   winCounter+=1;
        	  // another if statement to validate if more the cards are the same  
           }
           if(secondR==fourthR)
        	   winCounter+=1;
           
           if (thirdR==firstR)
           {
        	   winCounter+=1;	   
           }
           if(thirdR==fourthR)
        	   winCounter+=1;
    
    
           if (winCounter==1) {
        	   label4.setText("Good job! You won DOUBLE x2!");
        	   winTotal=winTotal+userInpValue;         //if theres 2 similar cards output 
        	   totalSpent=totalSpent+userInpValue;
        	   label5.setText("Amount won this spin: $"+decimal.format(userInpValue));
           }

           if (winCounter==2)
           {
        		 label4.setText(" Sweet! You won Triple 3x!");
        		 winTotal=winTotal+userInpValue;				//output for 2 cards
        		 totalSpent=totalSpent+userInpValue;
        		 label5.setText("Amount won this spin: $"+decimal.format(winCounter));
           }
           
           if (winCounter==3)
           {
        		 label4.setText(" JACKPOT! You won QUADRUPLE 4x!");
        		 winTotal=winTotal+userInpValue;				//output for 2 cards
        		 totalSpent=totalSpent+userInpValue;
        		 label5.setText("Amount won this spin: $"+decimal.format(winCounter));
           }
        	 
        	if(winCounter==4)
        	{
        		label4.setText("JACKPOT! QUADRUPLE win x4");
        		winTotal=winTotal+userInpValue;
        		totalSpent=totalSpent+userInpValue;
        		label5.setText("Amount won this spin: $"+decimal.format(winCounter));
        	}
        	
        	
        	if(winCounter==0)
        	{
        		label4.setText("No luck! Try again");
        		totalSpent=totalSpent+userInpValue;
        		label5.setText("Amount won this spin: $0.00");
  
        	}
                
           System.out.println();
           winCounter=0;
           label3.setText("Total Amount Won: $"+decimal.format(winTotal));
           label2.setText("So far you spent: $"+decimal.format(totalSpent));
    	}
           
    	
    	catch(NumberFormatException e)
    	{
    		label4.setText("Error. Please enter an appropriate value");
    		
    	}
    	
    	}}
    	
    );
    vb.getChildren().addAll(hb,label5,label2,label3);
    vb.setSpacing(10);
    vb2.getChildren().addAll(but,label4);            //positioning of scene elements
    vb2.setAlignment(Pos.BOTTOM_CENTER);
    
    
    finalStrucure.getChildren().addAll(vb,root,vb2);
    Scene scene = new Scene(finalStrucure,400,350);
    primaryStage.setScene(scene);
    primaryStage.show();								//show program
  }


}






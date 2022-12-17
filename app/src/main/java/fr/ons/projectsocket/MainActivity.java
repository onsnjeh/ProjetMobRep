package fr.ons.projectsocket;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
  /*  private static Formulaire formulaire;
    private static AccessBD BD;

    private static String nonFichier = "saveFormulaire";*/
    // declaring required variables
    private Socket client;
    private PrintWriter printwriter;
    private EditText textField1,textField2,textField3,textField4 ,textField5 ,textField6, textField7  ;
    private Button button;
    private String message1="";
    private String message2="";
    private String message3="";
    private String message4="";
    private String message5="";
    private String message6="";
    private String message7="";
//bd
  /*  private String Q1;
    private String Q2;
    private String Q3;
    private String Q4;
    private String Q5;
    private String Q6;
    private String Q7;
    private String id;
    private Context context;*/

    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reference to the text field
        textField1 = (EditText) findViewById(R.id.editText1);
        textField2 = (EditText) findViewById(R.id.editText2);
        textField3 = (EditText) findViewById(R.id.editText3);
        textField4 = (EditText) findViewById(R.id.editText4);
        textField5 = (EditText) findViewById(R.id.editText5);
        textField6 = (EditText) findViewById(R.id.editText6);
        textField7 = (EditText) findViewById(R.id.editText7);
//bd
       /* BD=new AccessBD(context);
        formulaire=BD.RécupérerDernier();
        formulaire=new Formulaire(id,Q1,Q2,Q3,Q4,Q5,Q6,Q7);
            // Serializer.serialize(nonFichier, players, context);
            BD.ajouter(formulaire);
*/

        // reference to the send button
        button = (Button) findViewById(R.id.button1);

        // Button press event listener
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // get the text message on the text field
                message1 = textField1.getText().toString();
                message2 = textField2.getText().toString();
                message3 = textField3.getText().toString();
                message4= textField4.getText().toString();
                message5 = textField5.getText().toString();
                message6 = textField6.getText().toString();
                message7 = textField7.getText().toString();



                // start the Thread to connect to server
              new Thread(new ClientThread(message1)).start();
             //new Thread(new ClientThread(message2)).start();
                //new Thread(new ClientThread(message3)).start();
              //  new Thread(new ClientThread(message4)).start();
               //new Thread(new ClientThread(message5)).start();
               /*  new Thread(new ClientThread(message6)).start();
                new Thread(new ClientThread(message7)).start();*/



            }
        });
    }

    // the ClientThread class performs
    // the networking operations
    class ClientThread implements Runnable {
        private String message="";

        ClientThread(String message) {
            this.message = message;
        }
        @Override
        public void run() {
            try {
                // the IP and port should be correct to have a connection established
                // Creates a stream socket and connects it to the specified port number on the named host.
                client = new Socket("192.168.1.11", 4444);  // connect to server
               printwriter = new PrintWriter(client.getOutputStream(),true);
                printwriter.write(message);  // write the message to output stream

                printwriter.flush();
                printwriter.close();
                // get the inputstream from socket, which will have
                // the message from the clients

                client.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
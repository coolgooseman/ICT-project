import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

import java.util.ArrayList;


public class BasicGame implements GameLoop {
    boolean optie1 = false;
    boolean optie2 = false;
    boolean optie3 = false;
    String currentScreen = "startPagina";

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new BasicGame(), 750, 750, 40);
    }

    @Override
    public void init() {


    }

    @Override
    public void loop() {
        //SaxionApp.clear();
        switch (currentScreen) {
            case "startPagina" -> startPagina();
            case "gameMenu" -> gameMenu();

            case "mensNiet" -> nietGamePagina();
            case "mensWel" -> welGamePagina();
            case "verzuipNiet" -> drankGamePagina();
            case "regelPagina" -> regelPagina();
            case "playerMenu" -> playerMenu();
            case "2player" -> twoPlayer();
            case "3player" -> threePlayer();
            case "4player" -> fourPlayer();


        }
        
    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {
    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {
        switch (currentScreen) {
            case "startPagina":
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    //int x = mouseEvent.getX();
                    //int y = mouseEvent.getY();
                    currentScreen = "gameMenu";
                }
                break;
            case "gameMenu":
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 198 && y > 94) {
                        if (x > 0 && x < 485) {
                            currentScreen = "mensNiet";
                            optie1 = true;
                        }
                    }
                }
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 338 && y > 235) {
                        if (x > 0 && x < 485) {
                            currentScreen = "verzuipNiet";
                            optie2 = true;
                        }
                    }
                }
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 480 && y > 375) {
                        if (x > 0 && x < 485) {
                            currentScreen = "mensWel";
                            optie3 = true;
                        }
                    }
                }
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 620 && y > 517) {
                        if (x > 0 && x < 485) {
                            currentScreen = "regelPagina";
                        }
                    }
                }
                break;
            case "mensNiet":
            case "verzuipNiet":
            case "mensWel":
                currentScreen = "playerMenu";
//                if (mouseEvent.isMouseUp() && mouseEvent.isLeftMouseButton()) {
//                    dobbelsteen();
//                }
                break;
            case "playerMenu":
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 198 && y > 94) {
                        if (x > 0 && x < 485) {
                            currentScreen = "2player";
                        }
                    }
                }
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 338 && y > 235) {
                        if (x > 0 && x < 485) {
                            currentScreen = "3player";
                        }
                    }
                }
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 480 && y > 375) {
                        if (x > 0 && x < 485) {
                            currentScreen = "4player";
                        }
                    }
                }
        }

    }

    public void playerMenu(){
        /*
        SaxionApp.drawImage("keuze menu.png",0,0,750,750);
        //SaxionApp.drawRectangle(200,200, 20,20);
        int aantalSpelers = 0;
        switch (aantalSpelers){
            case 2: //SaxionApp.drawImage('...',0,0,750,750); break;
            case 3: //SaxionApp.drawImage('...',0,0,750,750); break;
            case 4: //SaxionApp.drawImage('...',0,0,750,750); break;
        }

        ArrayList<Players> players = new ArrayList<>();

         */
    }

    public void twoPlayer(){
        //SaxionApp.drawImage("...",0,0,750,750);
        if(optie1){
            currentScreen = "mensNiet";
        } else if (optie2) {
            currentScreen = "verzuipNiet";
        } else if (optie3){
            currentScreen = "mensWel";
        }

    }

    public void threePlayer(){
        //SaxionApp.drawImage("...",0,0,750,750);
        if(optie1){
            currentScreen = "mensNiet";
        } else if (optie2) {
            currentScreen = "verzuipNiet";
        } else if (optie3){
            currentScreen = "mensWel";
        }
    }

    public void fourPlayer(){
        //SaxionApp.drawImage("...",0,0,750,750);
        if(optie1){
            currentScreen = "mensNiet";
        } else if (optie2) {
            currentScreen = "verzuipNiet";
        } else if (optie3){
            currentScreen = "mensWel";
        }
    }

    public void dobbelsteen(){
        int randomNummer = SaxionApp.getRandomValueBetween(1,7);
        switch (randomNummer) {
            case 1 -> SaxionApp.drawImage("Sandbox/stip1.png", 350, 348, 55, 55);
            case 2 -> SaxionApp.drawImage("Sandbox/stip2.png", 350, 348, 55, 55);
            case 3 -> SaxionApp.drawImage("Sandbox/stip3.png", 350, 348, 55, 55);
            case 4 -> SaxionApp.drawImage("Sandbox/stip4.png", 350, 348, 55, 55);
            case 5 -> SaxionApp.drawImage("Sandbox/stip5.png", 350, 348, 55, 55);
            case 6 -> SaxionApp.drawImage("Sandbox/stip6.png", 350, 348, 55, 55);
        }
    }

    public void startPagina() {
        SaxionApp.drawImage("Sandbox/start pagina.png", 0, 0, 750, 750);

    }

    public void gameMenu() {
        SaxionApp.drawImage("Sandbox/keuze menu.png", 0, 0, 750, 750);
    }

    public void nietGamePagina() {
        SaxionApp.drawImage("Sandbox/bord mens erger je niet.png", 0, 0, 750, 750);
        playerMenu();
    }

    public void welGamePagina() {
        SaxionApp.drawImage("Sandbox/bord mens erger je niet.png", 0, 0, 750, 750);
        playerMenu();
    }

    public void drankGamePagina() {
        SaxionApp.drawImage("Sandbox/bord mens erger je wel.png", 0, 0, 750, 750);
        playerMenu();
    }

    public void regelPagina() {
        //SaxionApp.drawimage("foto.png",0,0,750,750);
        //wachten op foto collin denk ik
    }

    public void playerMovement(){



    }
}


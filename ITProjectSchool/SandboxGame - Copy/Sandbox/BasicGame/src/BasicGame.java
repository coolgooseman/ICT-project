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
    int counter = -1;
    int randomNummer = 0;

    BoardPositions[] positie = new BoardPositions[56];

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new BasicGame(), 750, 750, 40);
    }

    @Override
    public void init() {
        playerMovement();

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
                if (mouseEvent.isMouseUp() && mouseEvent.isLeftMouseButton()) {
                    dobbelsteen();
                }
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

    public void dobbelsteen() {
        randomNummer = SaxionApp.getRandomValueBetween(1, 7);
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
    }

    public void drankGamePagina() {

        SaxionApp.drawImage("Sandbox/bord mens erger je wel.png", 0, 0, 750, 750);
        playerMenu();
    }

    public void regelPagina() {
        //SaxionApp.drawimage("foto.png",0,0,750,750);
        //wachten op foto collin denk ik
    }

    public void playerMovement() {
        //up
        for (int p = 670; p > 410; p = p - 60) {
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = 315;
            pos.y = p;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20,20);
        }
        //left
        for (int p = 260; p > 70; p = p - 60){
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = p;
            pos.y = 410;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20,20);
        }
        //up
        for (int p = 376; p > 300; p = p - 60){
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = 70;
            pos.y = p;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20,20);
        }
        //right
        for (int p = 143; p < 340; p = p + 60){
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = p;
            pos.y = 300;
            pos.position = counter;
            SaxionApp.drawRectangle(pos.x, pos.y, 20,20);
        }
        //up
        for (int p = 250; p > 50; p = p - 60){
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = 300;
            pos.y = p;
            pos.position = counter;
            SaxionApp.drawRectangle(pos.x, pos.y, 20,20);
        }
        //right
        for (int p = 380; p < 500; p = p + 60){
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = p;
            pos.y = 65;
            pos.position = counter;
            SaxionApp.drawRectangle(pos.x, pos.y, 20,20);
        }
        //down
        for (int p = 140; p < 300; p = p + 60){
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = 435;
            pos.y = p;
            pos.position = counter;
            SaxionApp.drawRectangle(pos.x, pos.y, 20,20);
        }
        //right
        for (int p = 425; p < 700; p = p + 60){
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = p;
            pos.y = 310;
            pos.position = counter;
            SaxionApp.drawRectangle(pos.x, pos.y, 20,20);
        }
        //down
        for (int p = 360; p < 470; p = p + 60){
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = 670;
            pos.y = p;
            pos.position = counter;
            SaxionApp.drawRectangle(pos.x, pos.y, 20,20);
        }
        //left
        for (int p = 600; p > 400; p = p - 60){
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = p;
            pos.y = 430;
            pos.position = counter;
            SaxionApp.drawRectangle(pos.x, pos.y, 20,20);
        }
        //down
        for (int p = 480; p < 660; p = p + 60){
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = 425;
            pos.y = p;
            pos.position = counter;
            SaxionApp.drawRectangle(pos.x, pos.y, 20,20);
        }
        //left
        for (int p = 440; p > 340; p = p - 60){
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = p;
            pos.y = 670;
            pos.position = counter;
            SaxionApp.drawRectangle(pos.x, pos.y, 20,20);
        }
    }
    public void actualPlayerMovement(){
        for (int i = 0; i < randomNummer; i++){

        }
    }
}


import nl.saxion.app.CsvReader;
import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

import java.awt.*;
import java.util.ArrayList;


public class BasicGame implements GameLoop {

    boolean alreadyDrawn = false;
    boolean mensNiet = false;
    boolean verzuipNiet = false;
    boolean mensWel = false;
    String currentScreen = "startPagina";
    int counter = -1;
    int aantalSpelers = 0;
    int randomNummer = 0;
    int moveX = 0;
    int moveY = 0;

    boolean playerOne = true;
    boolean playerTwo = false;
    boolean playerThree = false;
    boolean playerFour = false;

    BoardPositions[] positie = new BoardPositions[62];
    ArrayList<Player> players = new ArrayList<>();

    Player player = new Player();
    Player player1 = new Player();

    Player player2 = new Player();
    Player player3 = new Player();
    Player player4 = new Player();


    public static void main(String[] args) {
        SaxionApp.startGameLoop(new BasicGame(), 750, 750, 40);
    }

    @Override
    public void init() {
        //init id's
        player1.id = 1;
        player2.id = 2;
        player3.id = 3;
        player4.id = 4;

        playerPositions();

        readPlayersIn();

        player1.positionplayer = 10;
        player2.positionplayer = 30;
        player3.positionplayer = 20;
    }

    @Override
    public void loop() {

        switch (currentScreen) {
            case "startPagina" -> startPagina();
            case "gameMenu" -> gameMenu();
            case "mensNiet" -> nietGamePagina();
            case "mensWel" -> welGamePagina();
            case "verzuipNiet" -> drankGamePagina();
            case "regelPagina" -> regelPagina();
            case "mensNietRegels" -> mensNietRegels();
            case "verzuipNietRegels" -> verzuipNietRegels();
            case "mensWelRegels" -> mensWelRegels();
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
                    currentScreen = "gameMenu";
                }
                break;
            case "gameMenu":
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 198 && y > 94) {
                        if (x > 0 && x < 485) {
                            currentScreen = "playerMenu";
                            mensNiet = true;
                        }
                    }
                }
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 338 && y > 235) {
                        if (x > 0 && x < 485) {
                            currentScreen = "playerMenu";
                            verzuipNiet = true;
                        }
                    }
                }
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 480 && y > 375) {
                        if (x > 0 && x < 485) {
                            currentScreen = "playerMenu";
                            mensWel = true;
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
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 620 && y > 517) {
                        if (x > 0 && x < 485) {
                            currentScreen = "gameMenu";
                        }
                    }
                }
                break;
            case "regelPagina":
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 283 && y > 179) {
                        if (x > 0 && x < 528) {
                            currentScreen = "mensNietRegels";
                        }
                    }
                }
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 424 && y > 320) {
                        if (x > 0 && x < 528) {
                            currentScreen = "verzuipNietRegels";
                        }
                    }
                }
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 565 && y > 461) {
                        if (x > 0 && x < 528) {
                            currentScreen = "mensWelRegels";
                        }
                    }
                }
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 750 && y > 654) {
                        if (x > 0 && x < 534) {
                            currentScreen = "gameMenu";
                        }
                    }
                }
                break;
            case "mensNietRegels":
            case "verzuipNietRegels":
            case "mensWelRegels":
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 750 && y > 654) {
                        if (x > 0 && x < 534) {
                            currentScreen = "regelPagina";
                        }
                    }
                }
                break;
            case "mensNiet":
            case "verzuipNiet":
            case "mensWel":
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 750 && y > 715) {
                        if (x > 0 && x < 750) {
                            currentScreen = "gameMenu";
                            mensWel = false;
                            mensNiet = false;
                            verzuipNiet = false;
                        }
                    }
                }
                //^^ terug naar menu in spel//

                if (aantalSpelers == 2) {
                    if (playerOne) {
                        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                            dobbelsteen();
                            System.out.println("--------1");
                            System.out.println(randomNummer);
                            actualPlayermovement();
                            System.out.println(player2.positionplayer);
                            System.out.println(player1.counterPos);
                            playerOne = false;
                            playerTwo = true;
                        }
                    } else if (playerTwo) {
                        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                            dobbelsteen();
                            System.out.println("--------2");
                            System.out.println(randomNummer);
                            actualPlayermovement();
                            playerTwo = false;
                            playerOne = true;
                        }
                    }
                }
                if (aantalSpelers == 3) {
                    if (playerOne) {
                        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                            dobbelsteen();
                            System.out.println("--------");
                            System.out.println(randomNummer);
                            actualPlayermovement();
                            playerOne = false;
                            playerTwo = true;
                        }
                    } else if (playerTwo) {
                        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                            dobbelsteen();
                            System.out.println("--------");
                            System.out.println(randomNummer);
                            actualPlayermovement();
                            playerTwo = false;
                            playerThree = true;
                        }
                    } else if (playerThree) {
                        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                            dobbelsteen();
                            System.out.println("--------");
                            System.out.println(randomNummer);
                            actualPlayermovement();
                            playerTwo = false;
                            playerOne = true;
                        }
                    }
                }
                if (aantalSpelers == 4) {
                    if (playerOne) {
                        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                            dobbelsteen();
                            System.out.println("--------");
                            System.out.println(randomNummer);
                            actualPlayermovement();
                            playerOne = false;
                            playerTwo = true;
                        }
                    } else if (playerTwo) {
                        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                            dobbelsteen();
                            System.out.println("--------");
                            System.out.println(randomNummer);
                            actualPlayermovement();
                            playerTwo = false;
                            playerThree = true;
                        }
                    } else if (playerThree) {
                        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                            dobbelsteen();
                            System.out.println("--------");
                            System.out.println(randomNummer);
                            actualPlayermovement();
                            playerThree = false;
                            playerFour = true;
                        }
                    } else if (playerFour) {
                        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                            dobbelsteen();
                            System.out.println("--------");
                            System.out.println(randomNummer);
                            actualPlayermovement();
                            playerFour = false;
                            playerOne = true;
                        }
                    }
                }
        }

    }

    public void playerMenu() {
        SaxionApp.drawImage("Sandbox/player menu.png", 0, 0, 750, 750);
    }

    public void twoPlayer() {
        aantalSpelers = 2;
        if (mensNiet) {
            currentScreen = "mensNiet";
        } else if (verzuipNiet) {
            currentScreen = "verzuipNiet";
        } else if (mensWel) {
            currentScreen = "mensWel";
        }
    }

    public void threePlayer() {
        aantalSpelers = 3;
        if (mensNiet) {
            currentScreen = "mensNiet";
        } else if (verzuipNiet) {
            currentScreen = "verzuipNiet";
        } else if (mensWel) {
            currentScreen = "mensWel";
        }
    }

    public void fourPlayer() {
        aantalSpelers = 4;
        if (mensNiet) {
            currentScreen = "mensNiet";
        } else if (verzuipNiet) {
            currentScreen = "verzuipNiet";
        } else if (mensWel) {
            currentScreen = "mensWel";
        }
    }

    public void startPagina() {
        SaxionApp.drawImage("Sandbox/start pagina.png", 0, 0, 750, 750);
    }

    public void gameMenu() {
        SaxionApp.drawImage("Sandbox/keuze menu.png", 0, 0, 750, 750);
    }

    public void nietGamePagina() {
        readPlayersIn();
        SaxionApp.drawImage("Sandbox/bord mens erger je niet.png", 0, 0, 750, 750);
        drawPlayer();
    }

    public void drankGamePagina() {
        readPlayersIn();
        SaxionApp.drawImage("Sandbox/bord mens erger je niet.png", 0, 0, 750, 750);
        drawPlayer();
    }

    public void welGamePagina() {
        readPlayersIn();
        SaxionApp.drawImage("Sandbox/bord mens erger je wel.png", 0, 0, 750, 750);
        drawPlayer();


    }

    public void regelPagina() {
        SaxionApp.drawImage("Sandbox/regels keuze menu.png", 0, 0, 750, 750);
    }

    public void mensNietRegels() {
        SaxionApp.drawImage("Sandbox/Regels mens erger je niet.png", 0, 0, 750, 750);
    }


    public void verzuipNietRegels() {
        SaxionApp.drawImage("Sandbox/mens verzuip je niet regels.png", 0, 0, 750, 750);
        //SaxionApp.drawText("mens verzuip je niet", 200, 200, 30);
    }

    public void mensWelRegels() {
        SaxionApp.drawImage("Sandbox/regels Mens erger je Wel.png", 0, 0, 750, 750);
        //SaxionApp.drawText("mens erger je wel", 200, 200, 30);
    }

    public void dobbelsteen() {
        randomNummer = SaxionApp.getRandomValueBetween(1, 7);
        switch (randomNummer) {
            case 0 -> {
                SaxionApp.setFill(Color.white);
                SaxionApp.drawRectangle(350, 348, 55, 55);
            }
            case 1 -> SaxionApp.drawImage("Sandbox/stip1.png", 350, 348, 55, 55);
            case 2 -> SaxionApp.drawImage("Sandbox/stip2.png", 350, 348, 55, 55);
            case 3 -> SaxionApp.drawImage("Sandbox/stip3.png", 350, 348, 55, 55);
            case 4 -> SaxionApp.drawImage("Sandbox/stip4.png", 350, 348, 55, 55);
            case 5 -> SaxionApp.drawImage("Sandbox/stip5.png", 350, 348, 55, 55);
            case 6 -> SaxionApp.drawImage("Sandbox/stip6.png", 350, 348, 55, 55);
        }
    }

    public void readPlayersIn() {

        CsvReader reader = new CsvReader("Sandbox/pionPositie.csv");
        reader.skipRow();
        reader.setSeparator(';');

        while (reader.loadRow()) {
            //color, x, y, h, w, id
            Player p = new Player();
            p.kleur = reader.getString(0);
            p.x = reader.getInt(1);
            p.y = reader.getInt(2);
            p.h = reader.getInt(3);
            p.w = reader.getInt(4);
            p.id = reader.getInt(5);

            players.add(p);
        }

        for (Player p : players) {
            switch (aantalSpelers) {
                case 2:
                    switch (p.kleur) {
                        case "red" -> {
                            SaxionApp.turnBorderOff();
                            SaxionApp.setFill(Color.red);
                            SaxionApp.drawRectangle(p.x, p.y, p.w, p.h);
                        }
                        case "yellow" -> {
                            SaxionApp.turnBorderOff();
                            SaxionApp.setFill(Color.yellow);
                            SaxionApp.drawRectangle(p.x, p.y, p.w, p.h);
                        }
                        case "green", "blue" -> {
                            SaxionApp.turnBorderOff();
                            SaxionApp.setFill(Color.gray);
                            SaxionApp.drawRectangle(p.x, p.y, p.w, p.h);
                        }
                    }
                    break;
                case 3:
                    switch (p.kleur) {
                        case "red" -> {
                            SaxionApp.turnBorderOff();
                            SaxionApp.setFill(Color.red);
                            SaxionApp.drawRectangle(p.x, p.y, p.w, p.h);
                        }
                        case "yellow" -> {
                            SaxionApp.turnBorderOff();
                            SaxionApp.setFill(Color.yellow);
                            SaxionApp.drawRectangle(p.x, p.y, p.w, p.h);
                        }
                        case "green" -> {
                            SaxionApp.turnBorderOff();
                            SaxionApp.setFill(Color.green);
                            SaxionApp.drawRectangle(p.x, p.y, p.w, p.h);
                        }
                        case "blue" -> {
                            SaxionApp.turnBorderOff();
                            SaxionApp.setFill(Color.gray);
                            SaxionApp.drawRectangle(p.x, p.y, p.w, p.h);
                        }
                    }
                    break;
                case 4:
                    switch (p.kleur) {
                        case "red" -> {
                            SaxionApp.turnBorderOff();
                            SaxionApp.setFill(Color.red);
                            SaxionApp.drawRectangle(p.x, p.y, p.w, p.h);
                        }
                        case "yellow" -> {
                            SaxionApp.turnBorderOff();
                            SaxionApp.setFill(Color.yellow);
                            SaxionApp.drawRectangle(p.x, p.y, p.w, p.h);
                        }
                        case "green" -> {
                            SaxionApp.turnBorderOff();
                            SaxionApp.setFill(Color.green);
                            SaxionApp.drawRectangle(p.x, p.y, p.w, p.h);
                        }
                        case "blue" -> {
                            SaxionApp.turnBorderOff();
                            SaxionApp.setFill(Color.blue);
                            SaxionApp.drawRectangle(p.x, p.y, p.w, p.h);
                        }
                    }
                    break;
            }
        }
    }

    public void playerPositions() {
        //up
        for (int p = 670; p > 410; p = p - 60) {
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = 315;
            pos.y = p;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
        }
        //left
        for (int p = 260; p > 70; p = p - 60) {
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = p;
            pos.y = 410;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
        }
        //up
        for (int p = 376; p > 300; p = p - 60) {
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = 70;
            pos.y = p;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
        }
        //right
        for (int p = 143; p < 340; p = p + 60) {
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = p;
            pos.y = 300;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
        }
        //up
        for (int p = 250; p > 50; p = p - 60) {
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = 300;
            pos.y = p;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
        }
        //right
        for (int p = 380; p < 500; p = p + 60) {
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = p;
            pos.y = 65;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
        }
        //down
        for (int p = 140; p < 300; p = p + 60) {
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = 435;
            pos.y = p;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
        }
        //right
        for (int p = 425; p < 700; p = p + 60) {
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = p;
            pos.y = 310;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
        }
        //down
        for (int p = 360; p < 470; p = p + 60) {
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = 670;
            pos.y = p;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
        }
        //left
        for (int p = 600; p > 400; p = p - 60) {
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = p;
            pos.y = 430;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
        }
        //down
        for (int p = 480; p < 660; p = p + 60) {
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = 425;
            pos.y = p;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
        }
        //left
        for (int p = 440; p > 340; p = p - 60) {
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = p;
            pos.y = 670;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
        }
        //innerposities fr this time
        for (int p = 70; p < 300; p = p + 60) {
            BoardPositions pos = new BoardPositions();
            counter++;
            pos.x = p;
            pos.y = 370;
            pos.position = counter;
            positie[counter] = pos;
            SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
        }

    }

    public void actualPlayermovement() {
        //movement
        //na 39 moet speler naar binnen
        //40 41 42 43 zijn de binnenste posities
        //44 45 46 47 in counterPos
        if (playerOne) {
            player1.positionplayer = randomNummer + player1.positionplayer;
            player1.counterPos = player1.counterPos + randomNummer;
            if (!player1.isEchtBinnen) {
                if (player1.counterPos > 39) {
                    if (player1.counterPos == 44) {

                    } else if (player1.counterPos == 45) {

                    } else if (player1.counterPos == 46) {

                    } else if (player1.counterPos == 47) {

                    } else {
                        player1.positionplayer = player1.counterPos;

                        {
                            player1.positionplayerBinnen = player1.counterPos;
                            player1.binnenKomen = true;
                        }
                    }
                }
            }
            } else if (playerTwo) {
                player2.positionplayer = randomNummer + player2.positionplayer;

            } else if (playerThree) {
                player3.positionplayer = randomNummer + player3.positionplayer;


            } else if (playerFour) {
                player4.positionplayer = randomNummer + player4.positionplayer;
            }
            //onderkant bord reset positie
            if (player1.positionplayer >= 40) {
                player1.positionplayer = player1.positionplayer - 40;
            }
            if (player2.positionplayer >= 40) {
                player2.positionplayer = player2.positionplayer - 40;
            }
            if (player3.positionplayer >= 40) {
                player3.positionplayer = player3.positionplayer - 40;
            }
            if (player4.positionplayer >= 40) {
                player4.positionplayer = player4.positionplayer - 40;
            }

    }


        public void drawPlayer () {
            if (aantalSpelers == 2) {
                if (player1.binnenKomen) {
                    SaxionApp.drawBorderedText(String.valueOf(player1.id), positie[player1.positionplayerBinnen].x, positie[player1.positionplayerBinnen].y, 20);
                    player.binnenKomen = false;
                    player1.isEchtBinnen = true;
                } else {
                    SaxionApp.drawBorderedText(String.valueOf(player1.id), positie[player1.positionplayer].x, positie[player1.positionplayer].y, 20);
                    SaxionApp.drawBorderedText(String.valueOf(player2.id), positie[player2.positionplayer].x, positie[player2.positionplayer].y, 20);
                }
            } else if (aantalSpelers == 3) {
                SaxionApp.drawBorderedText(String.valueOf(player3.id), positie[player3.positionplayer].x, positie[player3.positionplayer].y, 20);
                SaxionApp.drawBorderedText(String.valueOf(player2.id), positie[player2.positionplayer].x, positie[player2.positionplayer].y, 20);
                SaxionApp.drawBorderedText(String.valueOf(player1.id), positie[player1.positionplayer].x, positie[player1.positionplayer].y, 20);
            } else if (aantalSpelers == 4) {
                SaxionApp.drawBorderedText(String.valueOf(player4.id), positie[player4.positionplayer].x, positie[player4.positionplayer].y, 20);
                SaxionApp.drawBorderedText(String.valueOf(player3.id), positie[player3.positionplayer].x, positie[player3.positionplayer].y, 20);
                SaxionApp.drawBorderedText(String.valueOf(player2.id), positie[player2.positionplayer].x, positie[player2.positionplayer].y, 20);
                SaxionApp.drawBorderedText(String.valueOf(player1.id), positie[player1.positionplayer].x, positie[player1.positionplayer].y, 20);
            }
        }
        public void drawKanskaart () {
            ArrayList<String> kanskaarten = new ArrayList<>();
            kanskaarten.add("Je hebt geluk! Je mag 5 stappen vooruit!");
            kanskaarten.add("Je mag het aantal gegooide ogen vooruit!");
            kanskaarten.add("Wie of wie? Je mag een andere speler 3 stappen achteruit zetten!");

            int kansKeuze = SaxionApp.getRandomValueBetween(0, 3);


            if (player1.positionplayer == 4 || player1.positionplayer == 18 || player1.positionplayer == 24 || player1.positionplayer == 38) {
                //if (player1.positionplayer == 10) {
                SaxionApp.clear();
                SaxionApp.drawImage("Sandbox/kanskaart.png", 175, 250, 400, 200);
                SaxionApp.drawText("Druk op de 'linkermuisknop' om verder te spelen", 175, 200, 20);
                SaxionApp.setTextDrawingColor(Color.black);
                SaxionApp.drawText(kanskaarten.get(kansKeuze), 200, 330, 20);

            } else if (player2.positionplayer == 4 || player2.positionplayer == 18 || player2.positionplayer == 24 || player2.positionplayer == 38) {
                SaxionApp.clear();
                SaxionApp.drawImage("Sandbox/kanskaart.png", 175, 250, 400, 200);
                SaxionApp.drawText("Druk op de 'linkermuisknop' om verder te spelen", 175, 200, 20);
                SaxionApp.setTextDrawingColor(Color.black);
                SaxionApp.drawText(kanskaarten.get(kansKeuze), 200, 330, 20);

            } else if (player3.positionplayer == 4 || player3.positionplayer == 18 || player3.positionplayer == 24 || player3.positionplayer == 38) {
                SaxionApp.clear();
                SaxionApp.drawImage("Sandbox/kanskaart.png", 175, 250, 400, 200);
                SaxionApp.drawText("Druk op de 'linkermuisknop' om verder te spelen", 175, 200, 20);
                SaxionApp.setTextDrawingColor(Color.black);
                SaxionApp.drawText(kanskaarten.get(kansKeuze), 200, 330, 20);

            } else if (player4.positionplayer == 4 || player4.positionplayer == 18 || player4.positionplayer == 24 || player4.positionplayer == 38) {
                SaxionApp.clear();
                SaxionApp.drawImage("Sandbox/kanskaart.png", 175, 250, 400, 200);
                SaxionApp.drawText("Druk op de 'linkermuisknop' om verder te spelen", 175, 200, 20);
                SaxionApp.setTextDrawingColor(Color.black);
                SaxionApp.drawText(kanskaarten.get(kansKeuze), 200, 330, 20);
            }

            //Achtergrond kleur (Zelfde kleur als bord)
            Color achtergrond = new Color(254, 246, 159);
            SaxionApp.setBackgroundColor(achtergrond);
        }
    }








import nl.saxion.app.CsvReader;
import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

import java.awt.*;


public class BasicGame implements GameLoop {

    String currentScreen = "startPagina";

    int aantalSpelers = 0;
    int randomNummer = 0;

    boolean mensNiet = false;
    boolean verzuipNiet = false;
    boolean mensWel = false;
    boolean playerOne = true;
    boolean playerTwo = false;
    boolean playerThree = false;
    boolean playerFour = false;

    Position[] posities = new Position[72];
    Pion[] pionen = new Pion[16];

    //ArrayList<String> kanskaarten = new ArrayList<>();


    //int kansKeuze = SaxionApp.getRandomValueBetween(0, 3);


    public static void main(String[] args) {
        SaxionApp.startGameLoop(new BasicGame(), 750, 750, 40);
    }

    @Override
    public void init() {
        Positions();
        createPion();
    }

    @Override
    public void loop() {
        SaxionApp.clear();
        switch (currentScreen) {
            //case "kanskaart" -> kansKaartDraw();
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
            case "startPagina" -> startScreenMouseEvent(mouseEvent);
            case "gameMenu" -> gameMenuMouseEvent(mouseEvent);
            case "playerMenu" -> playerMenuMouseEvent(mouseEvent);
            case "regelPagina" -> regelPaginaMouseEvent(mouseEvent);
            case "mensNietRegels" -> mensNietRegelsMouseEvent(mouseEvent);
            case "verzuipNietRegels" -> verzuipNietRegelsMouseEvent(mouseEvent);
            case "mensWelRegels" -> mensWelRegelsMouseEvent(mouseEvent);
            case "mensNiet" -> mensNietGameMouseEvent(mouseEvent);
            case "verzuipNiet" -> verzuipNietGameMouseEvent(mouseEvent);
            case "mensWel" -> mensWelGameMouseEvent(mouseEvent);
        }
    }

    public void startScreenMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
            currentScreen = "gameMenu";
        }
    }

    public void gameMenuMouseEvent(MouseEvent mouseEvent) {
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
    }

    public void playerMenuMouseEvent(MouseEvent mouseEvent) {
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
    }

    public void regelPaginaMouseEvent(MouseEvent mouseEvent) {
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
    }

    public void mensNietRegelsMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            if (y < 750 && y > 654) {
                if (x > 0 && x < 534) {
                    currentScreen = "regelPagina";
                }
            }
        }

    }

    public void verzuipNietRegelsMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            if (y < 750 && y > 654) {
                if (x > 0 && x < 534) {
                    currentScreen = "regelPagina";
                }
            }
        }
    }

    public void mensWelRegelsMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            if (y < 750 && y > 654) {
                if (x > 0 && x < 534) {
                    currentScreen = "regelPagina";
                }
            }
        }

    }

    public void mensNietGameMouseEvent(MouseEvent mouseEvent) {
        //terug naar menu in spel
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

        playersTurnMouseEvent(mouseEvent);
    }

    public void verzuipNietGameMouseEvent(MouseEvent mouseEvent) {
        //terug naar menu in spel
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

        playersTurnMouseEvent(mouseEvent);
    }

    public void mensWelGameMouseEvent(MouseEvent mouseEvent) {
        //terug naar menu in spel
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

        playersTurnMouseEvent(mouseEvent);
    }

    public void playersTurnMouseEvent(MouseEvent mouseEvent) {
        if (aantalSpelers == 2) {
            if (playerOne) {
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    dobbelsteen();
                    System.out.println("--------1");
                    System.out.println("gedobbled: " + randomNummer);
                    for (Pion p : pionen) {
                        if (!p.onBoard){
                        if (randomNummer == 6) {
                            if (p.pionID == 11) {
                                if (p.pionPositie < 26) {
                                    p.pionPositie = 26;
                                    p.onBoard = true;
                                    System.out.println("positie: " + p.pionPositie);
                                    drawPion();
                                    if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                                        dobbelsteen();
                                        System.out.println("gedobbled: " + randomNummer);
                                        movePlayer(p.pionID, p.pionPositie);
                                        System.out.println("positie: " + p.pionPositie);
                                    }
                                }
                            }
                        }
                        } else {
                            if (p.pionID == 11 && p.onBoard) {
                                dobbelsteen();
                                System.out.println("gedobbled: " + randomNummer);
                                movePlayer(p.pionID, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie);
                            }
                        }

                    }
                    playerOne = false;
                    playerTwo = true;

                }
            } else if (playerTwo) {
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    dobbelsteen();
                    System.out.println("--------2");
                    System.out.println("gedobbled: " + randomNummer);
                    for (Pion p : pionen) {
                        if (!p.onBoard){
                        if (randomNummer == 6) {
                            if (p.pionID == 22) {
                                if (p.pionPositie < 46) {
                                    p.pionPositie = 46;
                                    p.onBoard = true;
                                    System.out.println("positie: " + p.pionPositie);
                                    drawPion();
                                    if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                                        dobbelsteen();
                                        System.out.println("gedobbled: " + randomNummer);
                                        movePlayer(p.pionID, p.pionPositie);
                                        System.out.println("positie: " + p.pionPositie);
                                    }
                                }
                            }
                        }
                        } else {
                            if (p.pionID == 22 && p.onBoard) {
                                dobbelsteen();
                                System.out.println("gedobbled: " + randomNummer);
                                movePlayer(p.pionID, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie);
                            }
                        }
                    }
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
                    playerOne = false;
                    playerTwo = true;
                }
            } else if (playerTwo) {
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    dobbelsteen();
                    System.out.println("--------");
                    System.out.println(randomNummer);
                    playerTwo = false;
                    playerThree = true;
                }
            } else if (playerThree) {
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    dobbelsteen();
                    System.out.println("--------");
                    System.out.println(randomNummer);
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
                    playerOne = false;
                    playerTwo = true;
                }
            } else if (playerTwo) {
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    dobbelsteen();
                    System.out.println("--------");
                    System.out.println(randomNummer);
                    playerTwo = false;
                    playerThree = true;
                }
            } else if (playerThree) {
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    dobbelsteen();
                    System.out.println("--------");
                    System.out.println(randomNummer);
                    playerThree = false;
                    playerFour = true;
                }
            } else if (playerFour) {
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    dobbelsteen();
                    System.out.println("--------");
                    System.out.println(randomNummer);
                    playerFour = false;
                    playerOne = true;
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

    public void regelPagina() {
        SaxionApp.drawImage("Sandbox/regels keuze menu.png", 0, 0, 750, 750);
    }

    public void mensNietRegels() {
        SaxionApp.drawImage("Sandbox/Regels mens erger je niet.png", 0, 0, 750, 750);
    }

    public void verzuipNietRegels() {
        SaxionApp.drawImage("Sandbox/mens verzuip je niet regels.png", 0, 0, 750, 750);
    }

    public void mensWelRegels() {
        SaxionApp.drawImage("Sandbox/regels Mens erger je Wel.png", 0, 0, 750, 750);
    }

    public void nietGamePagina() {
        SaxionApp.drawImage("Sandbox/bord mens erger je niet.png", 0, 0, 750, 750);
        drawPion();
    }

    public void drankGamePagina() {
        SaxionApp.drawImage("Sandbox/bord mens erger je niet.png", 0, 0, 750, 750);
        drawPion();
    }

    public void welGamePagina() {
        SaxionApp.drawImage("Sandbox/bord mens erger je wel.png", 0, 0, 750, 750);
        drawPion();
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

    public void createPion() {
        CsvReader reader = new CsvReader("Sandbox/pionPositie.csv");
        reader.skipRow();
        reader.setSeparator(';');

        int positie = 0;

        while (reader.loadRow()) {
            Pion p = new Pion();

            p.kleur = reader.getString(0);
            p.h = reader.getInt(3);
            p.w = reader.getInt(4);
            p.pionID = reader.getInt(5);
            p.playerID = reader.getInt(6);
            p.pionPositie = positie;

            pionen[positie] = p;
            positie++;
        }

        //check
        for (Pion p : pionen) {
            System.out.println("ID: " + p.pionID + " Kleur: " + p.kleur + " Positie pion: " + p.pionPositie + " PlayersID: " + p.playerID);
        }
    }

    public void drawPion() {
        for (Position pos : posities) {
            for (Pion p : pionen) {
                if (p.pionPositie == pos.position) {
                    switch (aantalSpelers) {
                        case 2:
                            switch (p.kleur) {
                                case "red" -> {
                                    SaxionApp.turnBorderOff();
                                    SaxionApp.setFill(Color.red);
                                    SaxionApp.drawRectangle(pos.x, pos.y, p.h, p.w);
                                }
                                case "yellow" -> {
                                    SaxionApp.turnBorderOff();
                                    SaxionApp.setFill(Color.yellow);
                                    SaxionApp.drawRectangle(pos.x, pos.y, p.h, p.w);
                                }
                                default -> {
                                    SaxionApp.turnBorderOff();
                                    SaxionApp.setFill(Color.gray);
                                    SaxionApp.drawRectangle(pos.x, pos.y, p.h, p.w);
                                }
                            }
                            break;
                        case 3:
                            switch (p.kleur) {
                                case "red" -> {
                                    SaxionApp.turnBorderOff();
                                    SaxionApp.setFill(Color.red);
                                    SaxionApp.drawRectangle(pos.x, pos.y, p.h, p.w);
                                }
                                case "yellow" -> {
                                    SaxionApp.turnBorderOff();
                                    SaxionApp.setFill(Color.yellow);
                                    SaxionApp.drawRectangle(pos.x, pos.y, p.h, p.w);
                                }
                                case "green" -> {
                                    SaxionApp.turnBorderOff();
                                    SaxionApp.setFill(Color.green);
                                    SaxionApp.drawRectangle(pos.x, pos.y, p.h, p.w);
                                }
                                default -> {
                                    SaxionApp.turnBorderOff();
                                    SaxionApp.setFill(Color.gray);
                                    SaxionApp.drawRectangle(pos.x, pos.y, p.h, p.w);
                                }
                            }
                            break;
                        case 4:
                            switch (p.kleur) {
                                case "red" -> {
                                    SaxionApp.turnBorderOff();
                                    SaxionApp.setFill(Color.red);
                                    SaxionApp.drawRectangle(pos.x, pos.y, p.h, p.w);
                                }
                                case "yellow" -> {
                                    SaxionApp.turnBorderOff();
                                    SaxionApp.setFill(Color.yellow);
                                    SaxionApp.drawRectangle(pos.x, pos.y, p.h, p.w);
                                }
                                case "green" -> {
                                    SaxionApp.turnBorderOff();
                                    SaxionApp.setFill(Color.green);
                                    SaxionApp.drawRectangle(pos.x, pos.y, p.h, p.w);
                                }
                                case "blue" -> {
                                    SaxionApp.turnBorderOff();
                                    SaxionApp.setFill(Color.blue);
                                    SaxionApp.drawRectangle(pos.x, pos.y, p.h, p.w);
                                }
                            }
                            break;
                    }
                }
            }
        }

    }

    public void Positions() {
        //start posities
        CsvReader reader = new CsvReader("Sandbox/pionPositie.csv");
        reader.skipRow();
        reader.setSeparator(';');

        int count = 0;

        while (reader.loadRow()) {
            Position p = new Position();
            p.x = reader.getInt(1);
            p.y = reader.getInt(2);
            p.position = count;
            posities[count] = p;
            count++;
        }

        //boardPosities
        //up
        for (int i = 650; i > 472; i = i - 59) {
            Position pos = new Position();
            pos.x = 298;
            pos.y = i;
            //count++;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }

        //left
        for (int p = 298; p > 120; p = p - 59) {
            Position pos = new Position();
            pos.x = p;
            pos.y = 414;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }
        //up
        for (int p = 414; p > 295; p = p - 59) {
            Position pos = new Position();
            pos.x = 62;
            pos.y = p;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }
        //right
        for (int p = 121; p < 299; p = p + 59) {
            Position pos = new Position();
            pos.x = p;
            pos.y = 296;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }
        //up
        for (int p = 237; p > 118; p = p - 59) {
            Position pos = new Position();
            pos.x = 298;
            pos.y = p;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }
        //right
        for (int p = 298; p < 417; p = p + 59) {
            Position pos = new Position();
            pos.x = p;
            pos.y = 60;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }
        //down
        for (int p = 119; p < 238; p = p + 59) {
            Position pos = new Position();
            pos.x = 416;
            pos.y = p;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }
        //right
        for (int p = 416; p < 653; p = p + 59) {
            Position pos = new Position();
            pos.x = p;
            pos.y = 296;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }
        //down
        for (int p = 355; p < 415; p = p + 59) {
            Position pos = new Position();
            pos.x = 652;
            pos.y = p;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }
        //left
        for (int p = 593; p > 415; p = p - 59) {
            Position pos = new Position();
            pos.x = p;
            pos.y = 414;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }
        //down
        for (int p = 473; p < 592; p = p + 59) {
            Position pos = new Position();
            pos.x = 416;
            pos.y = p;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }
        //left
        for (int p = 416; p > 356; p = p - 59) {
            Position pos = new Position();
            pos.x = p;
            pos.y = 650;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }

        //innerPositions
        //yellow
        for (int i = 121; i < 299; i = i + 59) {
            Position pos = new Position();
            pos.x = i;
            pos.y = 355;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }

        //green
        for (int i = 119; i < 297; i = i + 59) {
            Position pos = new Position();
            pos.x = 357;
            pos.y = i;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }

        //rood
        for (int i = 593; i > 415; i = i - 59) {
            Position pos = new Position();
            pos.x = i;
            pos.y = 355;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }


        //blue
        for (int i = 591; i > 413; i = i - 59) {
            Position pos = new Position();
            pos.x = 357;
            pos.y = i;
            pos.position = count;
            posities[count] = pos;
            //SaxionApp.drawRectangle(pos.x, pos.y, 20, 20);
            count++;
        }

        //check
        for (Position p : posities) {
            System.out.println("X: " + p.x + " Y: " + p.y + " pos: " + p.position);
            SaxionApp.drawRectangle(p.x, p.y, 41, 41);
        }
    }

    private void movePlayer(int pionID, int pionPositie) {
        if (playerOne) {
            for (Pion p : pionen) {
                if (p.pionID == pionID) {
                    p.pionPositie = pionPositie + randomNummer;
                    drawPion();
                }
            }
        } else if (playerTwo) {
            for (Pion p : pionen) {
                if (p.pionID == pionID) {

                    p.pionPositie = pionPositie + randomNummer;
                    drawPion();
                }
            }
        } else if (playerThree) {
            for (Pion p : pionen) {
                if (p.pionID == pionID) {

                    p.pionPositie = pionPositie + randomNummer;
                    drawPion();
                }
            }
        } else if (playerFour) {
            for (Pion p : pionen) {
                if (p.pionID == pionID) {

                    p.pionPositie = pionPositie + randomNummer;
                    drawPion();
                }
            }
        }
        for (Pion p : pionen) {
            if (!p.rondje) {
                if (p.pionPositie >= 55) {
                    p.pionPositie = p.pionPositie - 40;
                    p.rondje = true;
                }
            }
            if (p.rondje) {
                if (p.pionID == 11) {
                    if (p.pionPositie > 25) {
                        p.pionPositie = 56;
                    }
                }
            }
            if (p.rondje){
                if (p.pionID == 22) {
                    if (p.pionPositie > 45) {
                        p.pionPositie = 64;
                    }
                }
            }

        }
    }

    /*
    public void actualPlayermovement() {
        //check of speler binnen kan komen
        if (player1.positionplayer >= 4 && player1.positionplayer <= 9) {
            player1.binnenKomen = true;
        }
        //movement
        //na 39 moet speler naar binnen
        //44 45 46 47 is te hoog en dan doet die niks, kan evt code in niet nodig i think -jorn
        //code nog niet aangepast voor meerdan 2 spelers
        if (playerOne) {
            if (!player1.isEchtBinnen) {
                player1.positionplayer = randomNummer + player1.positionplayer;
                player1.counterPos = player1.counterPos + randomNummer;
                if (player1.counterPos > 39) {
                    if (player1.counterPos == 45) {
                        //do nothing
                    } else if (player1.counterPos == 46) {
                        //do nothing
                    } else if (player1.counterPos == 47) {
                        //do nothing
                    } else if (player1.counterPos == 48) {
                        //do nothing
                    } else {
                        player1.binnenKomen = true;
                        player1.positionplayerBinnen = 0;
                    }
                }
            }
        } else if (playerTwo) {
            player2.positionplayer = randomNummer + player2.positionplayer;
            player2.counterPos = player2.counterPos + randomNummer;
            if (!player2.isEchtBinnen) {
                if (player2.counterPos > 39) {
                    if (player2.counterPos == 45) {
                        //do nothing
                    } else if (player2.counterPos == 46) {
                        //do nothing
                    } else if (player2.counterPos == 47) {
                        //do nothing
                    } else if (player2.counterPos == 48) {
                        //do nothing
                    } else {
                        player2.binnenKomen = true;
                        player2.positionplayerBinnen = 4;

                    }
                }
            }

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

    public void drawPlayer() {
        //shit werkt erg cracked maar het werkt nu soort van, kijken of het zo kan met meerder spelers
        if (aantalSpelers == 2) {
            if (player1.binnenKomen) {
                SaxionApp.drawBorderedText(String.valueOf(player1.id), innerPositie[player1.positionplayerBinnen].x, innerPositie[player1.positionplayerBinnen].y, 20);
                player1.isEchtBinnen = true;
            }
            if (player2.binnenKomen) {
                SaxionApp.drawBorderedText(String.valueOf(player2.id), innerPositie[player2.positionplayerBinnen].x, innerPositie[player2.positionplayerBinnen].y, 20);
                player2.isEchtBinnen = true;
            }
            if (!player1.binnenKomen) {
                SaxionApp.drawBorderedText(String.valueOf(player1.id), positie[player1.positionplayer].x, positie[player1.positionplayer].y, 20);
            }
            if (!player2.binnenKomen) {
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

    public void drawKanskaart() {
        if (player1.positionplayer == 4 || player1.positionplayer == 18 || player1.positionplayer == 24 || player1.positionplayer == 38) {
            SaxionApp.setTextDrawingColor(Color.black);
            currentScreen = "kanskaart";



        } else if (player2.positionplayer == 4 || player2.positionplayer == 18 || player2.positionplayer == 24 || player2.positionplayer == 38) {
            SaxionApp.setTextDrawingColor(Color.black);
            currentScreen = "kanskaart";



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

    public void kansKaartDraw() {
        SaxionApp.clear();
        SaxionApp.drawImage("Sandbox/kanskaart.png", 175, 250, 400, 200);
        SaxionApp.drawText("Druk op de 'linkermuisknop' om verder te spelen", 175, 200, 20);
        SaxionApp.drawText(kanskaarten.get(kansKeuze), 200, 330, 20);
    }

     */
}




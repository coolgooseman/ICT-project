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
    int show = 0;

    boolean mensNiet = false;
    boolean verzuipNiet = false;
    boolean mensWel = false;
    boolean playerOne = true;
    boolean playerTwo = false;
    boolean playerThree = false;
    boolean playerFour = false;

    Position[] posities = new Position[72];
    Pion[] pionen = new Pion[16];

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new BasicGame(), 750, 800, 40);
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
            case "yellowWins" -> yellowWins();
            case "redWins" -> redWins();
            case "greenWins" -> greenWins();
            case "blueWins" -> blueWins();
            case "YellowVerzuipNietWins" -> geelVerzuipjenietWin();
            case "RedVerzuipNietWins" -> roodVerzuipjenietWin();
            case "GroenVerzuipNietWins" -> groenVerzuipjenietWin();
            case "BlueVerzuipNietWins" -> blauwVerzuipjenietWin();
            case "KansKaart" -> showkansKaartScreen(pionID);
            case "truthKaartKeuze" -> showTruthKeuzeScreen(pionID);
            case "truthKaart" -> showTruthKaart();
            case "dareKaart" -> showDareKaart(pionID);
        }
    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {
        switch (currentScreen) {
            case "yellowWins" -> yellowWinsKeyEvent(keyboardEvent);
            case "redWins" -> redWinsKeyEvent(keyboardEvent);
            case "greenWins" -> greenWinsKeyEvent(keyboardEvent);
            case "blueWins" -> blueWinsKeyEvent(keyboardEvent);
            case "YellowVerzuipNietWins" -> geelVerzuipjenietWinKeyEvent(keyboardEvent);
            case "RedVerzuipNietWins" -> roodVerzuipjenietWinKeyEvent(keyboardEvent);
            case "GroenVerzuipNietWins" -> groenVerzuipjenietWinKeyEvent(keyboardEvent);
            case "BlueVerzuipNietWins" -> blauwVerzuipjenietWinKeyEvent(keyboardEvent);
            case "KansKaart" -> kansKaartScreenKeyEvent(keyboardEvent);
            case "truthKaart" -> truthKaartKeyEvent(keyboardEvent);
            case "dareKaart" -> dareKaartKeyEvent(keyboardEvent);
        }
    }

    public void yellowWinsKeyEvent(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.isKeyPressed()) {
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_SPACE) {
                resetGame();
            }
        }

    }

    public void redWinsKeyEvent(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.isKeyPressed()) {
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_SPACE) {
                resetGame();
            }
        }
    }

    public void greenWinsKeyEvent(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.isKeyPressed()) {
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_SPACE) {
                resetGame();
            }
        }
    }

    public void blueWinsKeyEvent(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.isKeyPressed()) {
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_SPACE) {
                resetGame();
            }
        }
    }

    public void geelVerzuipjenietWinKeyEvent(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.isKeyPressed()) {
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_SPACE) {
                resetGame();
            }
        }

    }

    public void roodVerzuipjenietWinKeyEvent(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.isKeyPressed()) {
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_SPACE) {
                resetGame();
            }
        }
    }

    public void groenVerzuipjenietWinKeyEvent(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.isKeyPressed()) {
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_SPACE) {
                resetGame();
            }
        }
    }

    public void blauwVerzuipjenietWinKeyEvent(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.isKeyPressed()) {
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_SPACE) {
                resetGame();
            }
        }
    }

    public void kansKaartScreenKeyEvent(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.isKeyPressed()) {
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_SPACE) {
                currentScreen = "mensWel";
                SaxionApp.setBackgroundColor(Color.black);
                kiesKansText = false;
                System.out.println("PION_ID: " + pionID);
                System.out.println("kans kaart index: " + kansKeuze);
                voerKansKaartUit(pionID);
            }
        }
    }

    public void truthKaartKeyEvent(KeyboardEvent keyboardEvent){
        if (keyboardEvent.isKeyPressed()) {
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_ENTER) {
                currentScreen = "mensWel";
                SaxionApp.setBackgroundColor(Color.black);
                kiesKaart = false;
                aardrijkskunde = false;
                sport = false;
                wetenshap = false;
                geschiedenis = false;
                amusement = false;
                ict = false;
                System.out.println("PION_ID: " + pionID);
                vooruit = true;
                voerTruthKaartUit(pionID);
            }
        }

        if (keyboardEvent.isKeyPressed()) {
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_BACK_SPACE) {
                currentScreen = "mensWel";
                SaxionApp.setBackgroundColor(Color.black);
                kiesKaart = false;
                aardrijkskunde = false;
                sport = false;
                wetenshap = false;
                geschiedenis = false;
                amusement = false;
                ict = false;
                System.out.println("PION_ID: " + pionID);
                voerTruthKaartUit(pionID);
            }
        }
    }

    public void dareKaartKeyEvent(KeyboardEvent keyboardEvent){
        if (keyboardEvent.isKeyPressed()) {
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_SPACE) {
                currentScreen = "mensWel";
                SaxionApp.setBackgroundColor(Color.black);
                kiesDare = false;
                System.out.println("PION_ID: " + pionID);
                System.out.println("dare kaart index: " + kansKeuze);
                skip = true;
                voerDareUit(pionID);
            }
        }

        if (keyboardEvent.isKeyPressed()) {
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_ENTER) {
                currentScreen = "mensWel";
                SaxionApp.setBackgroundColor(Color.black);
                kiesDare = false;
                System.out.println("PION_ID: " + pionID);
                System.out.println("dare kaart index: " + kansKeuze);
                dareVooruit = true;
                voerTruthKaartUit(pionID);
            }
        }

        if (keyboardEvent.isKeyPressed()) {
            if (keyboardEvent.getKeyCode() == KeyboardEvent.VK_BACK_SPACE) {
                currentScreen = "mensWel";
                SaxionApp.setBackgroundColor(Color.black);
                kiesDare = false;
                System.out.println("PION_ID: " + pionID);
                System.out.println("dare kaart index: " + kansKeuze);
                voerTruthKaartUit(pionID);
            }
        }
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
            case "truthKaartKeuze" -> showTruthKeuzeScreenMouseEvent(mouseEvent);
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
                    if (mensNiet) {
                        currentScreen = "mensNiet";
                    } else {
                        currentScreen = "regelPagina";
                    }
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
                    if (verzuipNiet) {
                        currentScreen = "verzuipNiet";
                    } else {
                        currentScreen = "regelPagina";
                    }
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
                    if (mensWel) {
                        currentScreen = "mensWel";
                    } else {
                        currentScreen = "regelPagina";
                    }
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
                    resetGame();
                }
            }
        }

        //laat spelregels zien tijdens het spel
        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            if (y < 798 && y > 753) {
                if (x > 700 && x < 745) {
                    currentScreen = "mensNietRegels";
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
                    resetGame();
                }
            }
        }

        //laat spelregels zien tijdens het spel
        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            if (y < 798 && y > 753) {
                if (x > 700 && x < 745) {
                    currentScreen = "verzuipNietRegels";
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
                    resetGame();
                }
            }
        }

        //laat spelregels zien tijdens het spel
        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            if (y < 798 && y > 753) {
                if (x > 700 && x < 745) {
                    currentScreen = "mensWelRegels";
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
                        if (!p.onBoard) {
                            if (p.pionID == 11) {
                                if (randomNummer == 6) {
                                    setToStart(11, 26);
                                }
                            }
                        } else if (p.pionID == 11 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(12, 26);
                            }
                        } else if (p.pionID == 12 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(13, 26);
                            }
                        } else if (p.pionID == 13 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(14, 26);
                            }
                        } else {
                            if (p.pionID == 11 && p.pionPositie < 56) {
                                movePlayer(11, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 12 && p.pionPositie != 56) {
                                movePlayer(12, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 13 && p.pionPositie != 56) {
                                movePlayer(13, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 14 && p.pionPositie != 56) {
                                movePlayer(14, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            }
                        }

                    }
                    spelerKnockout();
                    winCon();
                    if (mensWel) {
                        chekKanskaart();
                        checkTruthKaart();
                        checkDareKaart();
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
                        if (!p.onBoard) {
                            if (p.pionID == 21) {
                                if (randomNummer == 6) {
                                    setToStart(21, 46);
                                }
                            }
                        } else if (p.pionID == 21 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(22, 46);
                            }
                        } else if (p.pionID == 22 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(23, 46);
                            }
                        } else if (p.pionID == 23 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(24, 46);
                            }
                        } else {
                            if (p.pionID == 21 && p.pionPositie < 64) {
                                movePlayer(21, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 22 && p.pionPositie != 64) {
                                movePlayer(22, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 23 && p.pionPositie != 64) {
                                movePlayer(23, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 24 && p.pionPositie != 64) {
                                movePlayer(24, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            }
                        }

                    }
                    spelerKnockout();
                    winCon();
                    if (mensWel) {
                        chekKanskaart();
                        checkTruthKaart();
                        checkDareKaart();
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
                    System.out.println("--------1");
                    System.out.println("gedobbled: " + randomNummer);
                    for (Pion p : pionen) {
                        if (!p.onBoard) {
                            if (p.pionID == 11) {
                                if (randomNummer == 6) {
                                    setToStart(11, 26);
                                }
                            }
                        } else if (p.pionID == 11 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(12, 26);
                            }
                        } else if (p.pionID == 12 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(13, 26);
                            }
                        } else if (p.pionID == 13 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(14, 26);
                            }
                        } else {
                            if (p.pionID == 11 && p.pionPositie < 56) {
                                movePlayer(11, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 12 && p.pionPositie != 56) {
                                movePlayer(12, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 13 && p.pionPositie != 56) {
                                movePlayer(13, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 14 && p.pionPositie != 56) {
                                movePlayer(14, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            }
                        }
                    }
                    spelerKnockout();
                    winCon();
                    if (mensWel) {
                        chekKanskaart();
                        checkTruthKaart();
                        checkDareKaart();                    }
                    playerOne = false;
                    playerTwo = true;


                }
            } else if (playerTwo) {
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    dobbelsteen();
                    System.out.println("--------2");
                    System.out.println("gedobbled: " + randomNummer);
                    for (Pion p : pionen) {
                        if (!p.onBoard) {
                            if (p.pionID == 21) {
                                if (randomNummer == 6) {
                                    setToStart(21, 46);
                                }
                            }
                        } else if (p.pionID == 21 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(22, 46);
                            }
                        } else if (p.pionID == 22 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(23, 46);
                            }
                        } else if (p.pionID == 23 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(24, 46);
                            }
                        } else {
                            if (p.pionID == 21 && p.pionPositie < 64) {
                                movePlayer(21, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 22 && p.pionPositie != 64) {
                                movePlayer(22, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 23 && p.pionPositie != 64) {
                                movePlayer(23, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 24 && p.pionPositie != 64) {
                                movePlayer(24, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            }
                        }
                    }
                    spelerKnockout();
                    winCon();
                    if (mensWel) {
                        chekKanskaart();
                        checkTruthKaart();
                        checkDareKaart();                    }
                    playerTwo = false;
                    playerThree = true;
                }
            } else if (playerThree) {
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    dobbelsteen();
                    System.out.println("--------3");
                    System.out.println("gedobbled: " + randomNummer);
                    for (Pion p : pionen) {
                        if (!p.onBoard) {
                            if (p.pionID == 31) {
                                if (randomNummer == 6) {
                                    setToStart(31, 36);
                                }
                            }
                        } else if (p.pionID == 31 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(32, 36);
                            }
                        } else if (p.pionID == 32 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(33, 36);
                            }
                        } else if (p.pionID == 33 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(34, 36);
                            }
                        } else {
                            if (p.pionID == 31 && p.pionPositie != 60) {
                                movePlayer(31, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 32 && p.pionPositie != 60) {
                                movePlayer(32, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 33 && p.pionPositie != 60) {
                                movePlayer(33, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 34 && p.pionPositie != 60) {
                                movePlayer(34, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            }
                        }
                    }
                    spelerKnockout();
                    winCon();
                    if (mensWel) {
                        chekKanskaart();
                        checkTruthKaart();
                        checkDareKaart();
                    }
                    playerThree = false;
                    playerOne = true;
                }
            }
        }
        if (aantalSpelers == 4) {
            if (playerOne) {
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    dobbelsteen();
                    System.out.println("--------1");
                    System.out.println("gedobbled: " + randomNummer);
                    for (Pion p : pionen) {
                        if (!p.onBoard) {
                            if (p.pionID == 11) {
                                if (randomNummer == 6) {
                                    setToStart(11, 26);
                                }
                            }
                        } else if (p.pionID == 11 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(12, 26);
                            }
                        } else if (p.pionID == 12 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(13, 26);
                            }
                        } else if (p.pionID == 13 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(14, 26);
                            }
                        } else {
                            if (p.pionID == 11 && p.pionPositie < 56) {
                                movePlayer(11, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 12 && p.pionPositie != 56) {
                                movePlayer(12, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 13 && p.pionPositie != 56) {
                                movePlayer(13, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 14 && p.pionPositie != 56) {
                                movePlayer(14, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            }
                        }
                    }
                    spelerKnockout();
                    winCon();
                    if (mensWel) {
                        chekKanskaart();
                        checkTruthKaart();
                        checkDareKaart();
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
                        if (!p.onBoard) {
                            if (p.pionID == 21) {
                                if (randomNummer == 6) {
                                    setToStart(21, 46);
                                }
                            }
                        } else if (p.pionID == 21 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(22, 46);
                            }
                        } else if (p.pionID == 22 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(23, 46);
                            }
                        } else if (p.pionID == 23 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(24, 46);
                            }
                        } else {
                            if (p.pionID == 21 && p.pionPositie < 64) {
                                movePlayer(21, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 22 && p.pionPositie != 64) {
                                movePlayer(22, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 23 && p.pionPositie != 64) {
                                movePlayer(23, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 24 && p.pionPositie != 64) {
                                movePlayer(24, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            }
                        }
                    }
                    spelerKnockout();
                    winCon();
                    if (mensWel) {
                        chekKanskaart();
                        checkTruthKaart();
                        checkDareKaart();
                    }
                    playerTwo = false;
                    playerThree = true;

                }
            } else if (playerThree) {
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    dobbelsteen();
                    System.out.println("--------3");
                    System.out.println("gedobbled: " + randomNummer);
                    for (Pion p : pionen) {
                        if (!p.onBoard) {
                            if (p.pionID == 31) {
                                if (randomNummer == 6) {
                                    setToStart(31, 36);
                                }
                            }
                        } else if (p.pionID == 31 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(32, 36);
                            }
                        } else if (p.pionID == 32 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(33, 36);
                            }
                        } else if (p.pionID == 33 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(34, 36);
                            }
                        } else {
                            if (p.pionID == 31 && p.pionPositie != 60) {
                                movePlayer(31, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 32 && p.pionPositie != 60) {
                                movePlayer(32, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 33 && p.pionPositie != 60) {
                                movePlayer(33, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 34 && p.pionPositie != 60) {
                                movePlayer(34, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            }
                        }
                    }
                    spelerKnockout();
                    winCon();
                    if (mensWel) {
                        chekKanskaart();
                        checkTruthKaart();
                        checkDareKaart();
                    }
                    playerThree = false;
                    playerFour = true;

                }
            } else if (playerFour) {
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    dobbelsteen();
                    System.out.println("--------4");
                    System.out.println("gedobbled: " + randomNummer);
                    for (Pion p : pionen) {
                        if (!p.onBoard) {
                            if (p.pionID == 41) {
                                if (randomNummer == 6) {
                                    setToStart(41, 16);
                                }
                            }
                        } else if (p.pionID == 41 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(42, 16);
                            }
                        } else if (p.pionID == 42 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(43, 16);
                            }
                        } else if (p.pionID == 43 && p.inHonk) {
                            if (randomNummer == 6) {
                                setToStart(44, 16);
                            }
                        } else {
                            if (p.pionID == 41 && p.pionPositie != 55) {
                                movePlayer(41, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 42 && p.pionPositie != 55) {
                                movePlayer(42, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 43 && p.pionPositie != 55) {
                                movePlayer(43, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            } else if (p.pionID == 44 && p.pionPositie != 55) {
                                movePlayer(44, p.pionPositie);
                                System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                            }
                        }
                    }
                    spelerKnockout();
                    winCon();
                    if (mensWel) {
                        chekKanskaart();
                        checkTruthKaart();
                        checkDareKaart();
                    }
                    playerFour = false;
                    playerOne = true;

                }
            }
        }
    }

    public void showTruthKeuzeScreenMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            if (y < 264 && y > 142 ) {
                if (x > 127 && x < 356) {
                    aardrijkskunde = true;
                    currentScreen = "truthKaart";
                }
            }
        }

        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            if (y < 262 && y > 140 ) {
                if (x > 410 && x < 639) {
                    sport = true;
                    currentScreen = "truthKaart";
                }
            }
        }

        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            if (y < 456 && y > 333 ) {
                if (x > 127 && x < 356) {
                    wetenshap = true;
                    currentScreen = "truthKaart";
                }
            }
        }

        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            if (y < 455 && y > 332 ) {
                if (x > 411 && x < 640) {
                    geschiedenis = true;
                    currentScreen = "truthKaart";
                }
            }
        }

        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            if (y < 643 && y > 512 ) {
                if (x > 125 && x < 355) {
                    amusement = true;
                    currentScreen = "truthKaart";
                }
            }
        }

        if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            if (y < 641 && y > 520 ) {
                if (x > 411 && x < 640) {
                    ict = true;
                    currentScreen = "truthKaart";
                }
            }
        }

    }


    //pagina code
    public void startPagina() {
        SaxionApp.drawImage("Sandbox/start pagina.png", 0, 0, 750, 750);
    }

    public void playerMenu() {
        SaxionApp.drawImage("Sandbox/player menu.png", 0, 0, 750, 750);
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
        SaxionApp.drawImage("Sandbox/regels Mens verzuip je niet.png", 0, 0, 750, 750);
    }

    public void mensWelRegels() {
        SaxionApp.drawImage("Sandbox/regels Mens erger je Wel.png", 0, 0, 750, 750);
    }

    public void nietGamePagina() {
        if (show == 0) {
            System.out.println("mens erg je niet");
            show++;
        }

        SaxionApp.drawImage("Sandbox/bord mens erger je niet.png", 0, 0, 750, 750);
        SaxionApp.drawImage("Sandbox/vraagteken.png", 700, 753, 45, 45);
        drawPion();
        showInfo();
        drawDobbelsteen();
    }

    public void drankGamePagina() {
        if (show == 0) {
            System.out.println("mens verzuip je niet");
            show++;
        }
        SaxionApp.drawImage("Sandbox/bord mens erger je niet.png", 0, 0, 750, 750);
        SaxionApp.drawImage("Sandbox/vraagteken.png", 700, 753, 45, 45);
        drawPion();
        showSlokken(randomNummer);
        showInfo();
        drawDobbelsteen();
    }

    public void welGamePagina() {
        if (show == 0) {
            System.out.println("mens erger je wel");
            show++;
        }
        SaxionApp.drawImage("Sandbox/bord mens erger je wel.png", 0, 0, 750, 750);
        SaxionApp.drawImage("Sandbox/vraagteken.png", 700, 753, 45, 45);
        drawPion();
        showInfo();
        drawDobbelsteen();
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

    //game code
    public void dobbelsteen() {
        randomNummer = SaxionApp.getRandomValueBetween(1, 7);
    }

    public void drawDobbelsteen() {
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

    public void showSlokken(int gegooit) {
        for (Pion p : pionen) {
            if (playerOne) {
                if (gegooit == 1) {
                    SaxionApp.setTextDrawingColor(Color.white);
                    SaxionApp.drawText("GEEL drink 2 slokken.", 375, 765, 20);
                    //System.out.println("GEEL drink 2 slokken.");
                } else if (p.pionID == 11 && p.inHonk || p.pionID == 12 && p.inHonk || p.pionID == 13 && p.inHonk || p.pionID == 14 && p.inHonk) {
                    SaxionApp.setTextDrawingColor(Color.white);
                    SaxionApp.drawText("GEEL drink 5 slok.", 375, 765, 20);
                    //System.out.println("GEEL drink 5 slokken.");
                } else if (p.pionID == 11 && !p.onBoard || p.pionID == 12 && !p.onBoard || p.pionID == 13 && !p.onBoard || p.pionID == 14 && !p.onBoard) {
                    if (gegooit == 3) {
                        SaxionApp.setTextDrawingColor(Color.white);
                        SaxionApp.drawText("GEEL drink 1 slok.", 375, 765, 20);
                        //System.out.println("GEEL drink 1 slok.");
                    }
                } else if (gegooit == 6) {
                    SaxionApp.setTextDrawingColor(Color.white);
                    SaxionApp.drawText("GEEL drink 5 slokken.", 375, 765, 20);
                    //System.out.println("GEEL drink 5 slokken.");
                }
            } else if (playerTwo) {
                if (p.pionID == 21 && !p.onBoard || p.pionID == 22 && !p.onBoard || p.pionID == 23 && !p.onBoard || p.pionID == 24 && !p.onBoard) {
                    if (gegooit == 3) {
                        SaxionApp.setTextDrawingColor(Color.white);
                        SaxionApp.drawText("ROOD drink 1 slok.", 375, 765, 20);
                        //System.out.println("ROOD drink 1 slok.");
                    }
                } else if (p.pionID == 21 && p.inHonk || p.pionID == 22 && p.inHonk || p.pionID == 23 && p.inHonk || p.pionID == 24 && p.inHonk) {
                    SaxionApp.setTextDrawingColor(Color.white);
                    SaxionApp.drawText("ROOD drink 5 slokken.", 375, 765, 20);
                    //System.out.println("ROOD drink 5 slokken.");

                } else if (gegooit == 6) {
                    SaxionApp.setTextDrawingColor(Color.white);
                    SaxionApp.drawText("ROOD drink 5 slokken.", 375, 765, 20);
                    //System.out.println("ROOD drink 5 slokken.");
                } else if (gegooit == 1) {
                    SaxionApp.setTextDrawingColor(Color.white);
                    SaxionApp.drawText("ROOD drink 2 slokken.", 375, 765, 20);
                    //System.out.println("ROOD drink 2 slokken.");
                }
            } else if (playerThree) {
                if (p.pionID == 31 && !p.onBoard || p.pionID == 32 && !p.onBoard || p.pionID == 33 && !p.onBoard || p.pionID == 34 && !p.onBoard) {
                    if (gegooit == 3) {
                        SaxionApp.setTextDrawingColor(Color.white);
                        SaxionApp.drawText("GROEN drink 1 slok.", 375, 765, 20);
                        //System.out.println("GROEN drink 1 slok.");
                    }
                } else if (p.pionID == 31 && p.inHonk || p.pionID == 32 && p.inHonk || p.pionID == 33 && p.inHonk || p.pionID == 34 && p.inHonk) {
                    SaxionApp.setTextDrawingColor(Color.white);
                    SaxionApp.drawText("GROEN drink 5 slokken.", 375, 765, 20);
                    //System.out.println("GROEN drink 5 slokken.");
                } else if (gegooit == 6) {
                    SaxionApp.setTextDrawingColor(Color.white);
                    SaxionApp.drawText("GROEN drink 5 slokken.", 375, 765, 20);
                    //System.out.println("GROEN drink 5 slokken.");
                } else if (gegooit == 1) {
                    SaxionApp.setTextDrawingColor(Color.white);
                    SaxionApp.drawText("GROEN drink 2 slokken.", 375, 765, 20);
                    //System.out.println("GROEN drink 2 slokken.");
                }
            } else if (playerFour) {
                if (p.pionID == 41 && !p.onBoard || p.pionID == 42 && !p.onBoard || p.pionID == 43 && !p.onBoard || p.pionID == 44 && !p.onBoard) {
                    if (gegooit == 3) {
                        SaxionApp.setTextDrawingColor(Color.white);
                        SaxionApp.drawText("BLAUW drink 1 slok.", 375, 765, 20);
                        //System.out.println("Blauw drink 1 slok");
                    }
                } else if (p.pionID == 41 && p.inHonk || p.pionID == 42 && p.inHonk || p.pionID == 43 && p.inHonk || p.pionID == 44 && p.inHonk) {
                    SaxionApp.setTextDrawingColor(Color.white);
                    SaxionApp.drawText("BLAUW drink 5 slokken.", 375, 765, 20);
                    //System.out.println("BLAUW drink 5 slokken.");
                } else if (gegooit == 6) {
                    SaxionApp.setTextDrawingColor(Color.white);
                    SaxionApp.drawText("BLAUW drink 5 slokken.", 375, 765, 20);
                    //System.out.println("BLAUW drink 5 slokken.");
                } else if (gegooit == 1) {
                    SaxionApp.setTextDrawingColor(Color.white);
                    SaxionApp.drawText("BLAUW drink 2 slokken.", 375, 765, 20);
                    //System.out.println("BLAUW drink 2 slokken.");
                }
            }
        }
    }

    public void showInfo() {
        if (playerOne) {
            SaxionApp.setTextDrawingColor(Color.yellow);
            SaxionApp.drawText("Geel is aan de beurt.", 10, 765, 30);
        } else if (playerTwo) {
            SaxionApp.setTextDrawingColor(Color.red);
            SaxionApp.turnBorderOff();
            SaxionApp.drawText("Rood is aan de beurt.", 10, 765, 30);
        } else if (playerThree) {
            SaxionApp.setTextDrawingColor(Color.green);
            SaxionApp.turnBorderOff();
            SaxionApp.drawText("Groen is aan de beurt.", 10, 765, 30);
        } else if (playerFour) {
            SaxionApp.setTextDrawingColor(Color.blue);
            SaxionApp.turnBorderOff();
            SaxionApp.drawText("Blauw is aan de beurt.", 10, 765, 30);
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
                                    //SaxionApp.drawText("" + p.pionID,pos.x,pos.y,20);
                                }
                                case "yellow" -> {
                                    SaxionApp.turnBorderOff();
                                    SaxionApp.setFill(Color.yellow);
                                    SaxionApp.drawRectangle(pos.x, pos.y, p.h, p.w);
                                    //SaxionApp.drawText("" + p.pionID,pos.x,pos.y,20);
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

    public void setToStart(int pionID, int start) {
        for (Pion p : pionen) {
            if (p.pionID == pionID) {
                if (!p.onBoard) {
                    p.pionPositie = start;
                    p.onBoard = true;
                    System.out.println("positie: " + p.pionPositie + " pionID: " + p.pionID);
                    drawPion();
                }

            }
        }

    }

    public void movePlayer(int pionID, int pionPositie) {
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
        checkRondje();

    }

    public void checkRondje(){
        for (Pion p : pionen) {
            if (!p.rondje) {
                if (p.pionPositie >= 55) {
                    p.pionPositie = p.pionPositie - 39;
                    p.rondje = true;
                }
                if (p.pionID == 41 && p.pionPositie >= 50 || p.pionID == 42 && p.pionPositie >= 50 || p.pionID == 43 && p.pionPositie >= 50 || p.pionID == 44 && p.pionPositie >= 50) {
                    p.rondje = true;
                }
            }

            if (p.rondje) {
                if (p.pionID == 11) {
                    if (p.pionPositie > 25) {
                        p.pionPositie = 56;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 12) {
                    if (p.pionPositie > 25) {
                        p.pionPositie = 57;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 13) {
                    if (p.pionPositie > 25) {
                        p.pionPositie = 58;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 14) {
                    if (p.pionPositie > 25) {
                        p.pionPositie = 59;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 21) {
                    if (p.pionPositie > 45) {
                        p.pionPositie = 64;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 22) {
                    if (p.pionPositie > 45) {
                        p.pionPositie = 65;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 23) {
                    if (p.pionPositie > 45) {
                        p.pionPositie = 66;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 24) {
                    if (p.pionPositie > 45) {
                        p.pionPositie = 67;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 31) {
                    if (p.pionPositie > 35) {
                        p.pionPositie = 60;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 32) {
                    if (p.pionPositie > 35) {
                        p.pionPositie = 61;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 33) {
                    if (p.pionPositie > 35) {
                        p.pionPositie = 62;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 34) {
                    if (p.pionPositie > 35) {
                        p.pionPositie = 63;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 41) {
                    if (p.pionPositie >= 55) {
                        p.pionPositie = 68;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 42) {
                    if (p.pionPositie >= 55) {
                        p.pionPositie = 69;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 43) {
                    if (p.pionPositie >= 55) {
                        p.pionPositie = 70;
                        p.inHonk = true;
                    }
                } else if (p.pionID == 44) {
                    if (p.pionPositie >= 55) {
                        p.pionPositie = 71;
                        p.inHonk = true;
                    }
                }
            }
        }

    }

    public void winCon() {
        boolean gewonnen = false;
        int tempwin = 0;
        for (Pion p : pionen) {
            if (p.pionID == 11 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (p.pionID == 12 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (p.pionID == 13 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (p.pionID == 14 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (tempwin == 4) {
                if (verzuipNiet) {
                    gewonnen = true;
                    currentScreen = "YellowVerzuipNietWins";
                } else {
                    System.out.println("Player geel wins");
                    gewonnen = true;
                    currentScreen = "yellowWins";
                    break;
                }
            }
        }
        if (!gewonnen) {
            tempwin = 0;
        }
        for (Pion p : pionen) {
            if (p.pionID == 21 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (p.pionID == 22 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (p.pionID == 23 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (p.pionID == 24 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (tempwin == 4) {
                if (!gewonnen) {
                    if (verzuipNiet) {
                        gewonnen = true;
                        currentScreen = "RedVerzuipNietWins";
                    } else {
                        System.out.println("Player rood wins");
                        gewonnen = true;
                        currentScreen = "redWins";
                        break;
                    }
                }
            }
        }
        if (!gewonnen) {
            tempwin = 0;
        }
        for (Pion p : pionen) {
            if (p.pionID == 31 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (p.pionID == 32 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (p.pionID == 33 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (p.pionID == 34 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (tempwin == 4) {
                if (!gewonnen) {
                    if (verzuipNiet) {
                        gewonnen = true;
                        currentScreen = "GroenVerzuipNietWins";
                    } else {
                        System.out.println("Player groen wins");
                        gewonnen = true;
                        currentScreen = "greenWins";
                        break;
                    }
                }
            }
        }
        if (!gewonnen) {
            tempwin = 0;
        }
        for (Pion p : pionen) {
            if (p.pionID == 41 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (p.pionID == 42 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (p.pionID == 43 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (p.pionID == 44 && p.inHonk) {
                tempwin = tempwin + 1;
            }
            if (tempwin == 4) {
                if (!gewonnen) {
                    if (verzuipNiet) {
                        gewonnen = true;
                        currentScreen = "BlueVerzuipNietWins";
                    } else {
                        System.out.println("Player blauw wins");
                        currentScreen = "blueWins";
                        break;
                    }
                }
            }
        }

    }

    public void yellowWins() {
        SaxionApp.drawImage("Sandbox/win pagina yellow.png", 0, 0, 750, 750);
        SaxionApp.setTextDrawingColor(Color.WHITE);
        SaxionApp.drawText("Druk op de spatsiebalk om naar start te gaan.", 10, 765, 20);

    }

    public void redWins() {
        SaxionApp.drawImage("Sandbox/win pagina red.png", 0, 0, 750, 750);
        SaxionApp.setTextDrawingColor(Color.WHITE);
        SaxionApp.drawText("Druk op de spatsiebalk om naar start te gaan.", 10, 765, 20);

    }

    public void greenWins() {
        SaxionApp.drawImage("Sandbox/win pagina green.png", 0, 0, 750, 750);
        SaxionApp.setTextDrawingColor(Color.WHITE);
        SaxionApp.drawText("Druk op de spatsiebalk om naar start te gaan.", 10, 765, 20);
    }

    public void blueWins() {
        SaxionApp.drawImage("Sandbox/win pagina blue.png", 0, 0, 750, 750);
        SaxionApp.setTextDrawingColor(Color.WHITE);
        SaxionApp.drawText("Druk op de spatsiebalk om naar start te gaan.", 10, 765, 20);
    }

    public void geelVerzuipjenietWin() {
        SaxionApp.drawImage("Sandbox/win pagina yellow verzuip.png", 0, 0, 750, 750);
        SaxionApp.setTextDrawingColor(Color.WHITE);
        SaxionApp.drawText("Druk op de spatsiebalk om naar start te gaan.", 10, 765, 20);
    }

    public void blauwVerzuipjenietWin() {
        SaxionApp.drawImage("Sandbox/win pagina blue verzuip.png", 0, 0, 750, 750);
        SaxionApp.setTextDrawingColor(Color.WHITE);
        SaxionApp.drawText("Druk op de spatsiebalk om naar start te gaan.", 10, 765, 20);
    }

    public void groenVerzuipjenietWin() {
        SaxionApp.drawImage("Sandbox/win pagina green verzuip.png", 0, 0, 750, 750);
        SaxionApp.setTextDrawingColor(Color.WHITE);
        SaxionApp.drawText("Druk op de spatsiebalk om naar start te gaan.", 10, 765, 20);
    }

    public void roodVerzuipjenietWin() {
        SaxionApp.drawImage("Sandbox/win pagina red verzuip.png", 0, 0, 750, 750);
        SaxionApp.setTextDrawingColor(Color.WHITE);
        SaxionApp.drawText("Druk op de spatsiebalk om naar start te gaan.", 10, 765, 20);
    }

    public void spelerKnockout() {
        int positie = 0;
        if (playerOne) {
            for (Pion p : pionen) {
                if (p.onBoard) {
                    if (p.pionID == 11 || p.pionID == 12 || p.pionID == 13 || p.pionID == 14) {
                        positie = p.pionPositie;
                    }
                    if (p.pionPositie == positie) {
                        if (p.pionID == 21 || p.pionID == 22 || p.pionID == 23 || p.pionID == 24) {
                            p.pionPositie = 6;
                            p.onBoard = false;
                            System.out.println("Geel is op rood gekomen, rood staat nu op: 6");
                            if (verzuipNiet) {
                                SaxionApp.setTextDrawingColor(Color.white);
                                SaxionApp.drawText("ROOD drink 5 slokken.", 375, 765, 30);
                            }
                        }
                        if (p.pionID == 31 || p.pionID == 32 || p.pionID == 33 || p.pionID == 34) {
                            p.pionPositie = 8;
                            p.onBoard = false;
                            System.out.println("Geel is op groen gekomen, groen staat nu op: 8");
                            if (verzuipNiet) {
                                SaxionApp.setTextDrawingColor(Color.white);
                                SaxionApp.drawText("GROEN drink 5 slokken.", 375, 765, 30);
                            }
                        }
                        if (p.pionID == 41 || p.pionID == 42 || p.pionID == 43 || p.pionID == 44) {
                            p.pionPositie = 12;
                            p.onBoard = false;
                            System.out.println("Geel is op blauw gekomen, blauw staat nu op: 12");
                            if (verzuipNiet) {
                                SaxionApp.setTextDrawingColor(Color.white);
                                SaxionApp.drawText("BLAUW drink 5 slokken.", 375, 765, 30);
                            }
                        }

                    }
                }
            }
        } else if (playerTwo) {
            for (Pion p : pionen) {
                if (p.onBoard) {
                    if (p.pionID == 21 || p.pionID == 22 || p.pionID == 23 || p.pionID == 24) {
                        positie = p.pionPositie;
                    }
                    if (p.pionPositie == positie) {
                        if (p.pionID == 11 || p.pionID == 12 || p.pionID == 13 || p.pionID == 14) {
                            p.pionPositie = 0;
                            p.onBoard = false;
                            System.out.println("Rood is op geel gekomen, geel staat nu op: 0");
                            if (verzuipNiet) {
                                SaxionApp.setTextDrawingColor(Color.white);
                                SaxionApp.drawText("GEEL drink 5 slokken.", 375, 765, 30);
                            }
                        }
                        if (p.pionID == 31 || p.pionID == 32 || p.pionID == 33 || p.pionID == 34) {
                            p.pionPositie = 8;
                            p.onBoard = false;
                            System.out.println("Rood is op groen gekomen, groen staat nu op: 8");
                            if (verzuipNiet) {
                                SaxionApp.setTextDrawingColor(Color.white);
                                SaxionApp.drawText("GROEN drink 5 slokken.", 375, 765, 30);
                            }
                        }
                        if (p.pionID == 41 || p.pionID == 42 || p.pionID == 43 || p.pionID == 44) {
                            p.pionPositie = 12;
                            p.onBoard = false;
                            System.out.println("Rood is op blauw gekomen, blauw staat nu op: 12");
                            if (verzuipNiet) {
                                SaxionApp.setTextDrawingColor(Color.white);
                                SaxionApp.drawText("BLAUW drink 5 slokken.", 375, 765, 30);
                            }
                        }
                    }
                }
            }
        } else if (playerThree) {
            for (Pion p : pionen) {
                if (p.onBoard) {
                    if (p.pionID == 31 || p.pionID == 32 || p.pionID == 33 || p.pionID == 34) {
                        positie = p.pionPositie;
                    }
                    if (p.pionPositie == positie) {
                        if (p.pionID == 11 || p.pionID == 12 || p.pionID == 13 || p.pionID == 14) {
                            p.pionPositie = 0;
                            p.onBoard = false;
                            System.out.println("Groen is op geel gekomen, geel staat nu op: 0");
                            if (verzuipNiet) {
                                SaxionApp.setTextDrawingColor(Color.white);
                                SaxionApp.drawText("GEEL drink 5 slokken.", 375, 765, 30);
                            }
                        }
                        if (p.pionID == 21 || p.pionID == 22 || p.pionID == 23 || p.pionID == 24) {
                            p.pionPositie = 6;
                            p.onBoard = false;
                            System.out.println("Groen is op rood gekomen, rood staat nu op: 6");
                            if (verzuipNiet) {
                                SaxionApp.setTextDrawingColor(Color.white);
                                SaxionApp.drawText("ROOD drink 5 slokken.", 375, 765, 30);
                            }
                        }
                        if (p.pionID == 41 || p.pionID == 42 || p.pionID == 43 || p.pionID == 44) {
                            p.pionPositie = 12;
                            p.onBoard = false;
                            System.out.println("Groen is op blauw gekomen, blauw staat nu op: 12");
                            if (verzuipNiet) {
                                SaxionApp.setTextDrawingColor(Color.white);
                                SaxionApp.drawText("BLAUW drink 5 slokken.", 375, 765, 30);
                            }
                        }
                    }
                }
            }
        } else if (playerFour) {
            for (Pion p : pionen) {
                if (p.onBoard) {
                    if (p.pionID == 41 || p.pionID == 42 || p.pionID == 43 || p.pionID == 44) {
                        positie = p.pionPositie;
                    }
                    if (p.pionPositie == positie) {
                        if (p.pionID == 11 || p.pionID == 12 || p.pionID == 13 || p.pionID == 14) {
                            p.pionPositie = 0;
                            p.onBoard = false;
                            System.out.println("Blauw is op geel gekomen, geel staat nu op: 0");
                            if (verzuipNiet) {
                                SaxionApp.setTextDrawingColor(Color.white);
                                SaxionApp.drawText("GEEL drink 5 slokken.", 375, 765, 30);
                            }
                        }
                        if (p.pionID == 21 || p.pionID == 22 || p.pionID == 23 || p.pionID == 24) {
                            p.pionPositie = 6;
                            p.onBoard = false;
                            System.out.println("Blauw is op rood gekomen, rood staat nu op: 6");
                            if (verzuipNiet) {
                                SaxionApp.setTextDrawingColor(Color.white);
                                SaxionApp.drawText("ROOD drink 5 slokken.", 375, 765, 30);
                            }
                        }
                        if (p.pionID == 31 || p.pionID == 32 || p.pionID == 33 || p.pionID == 34) {
                            p.pionPositie = 8;
                            p.onBoard = false;
                            System.out.println("Blauw is op groen gekomen, groen staat nu op: 8");
                            if (verzuipNiet) {
                                SaxionApp.setTextDrawingColor(Color.white);
                                SaxionApp.drawText("GROEN drink 5 slokken.", 375, 765, 30);
                            }
                        }
                    }
                }
            }
        }
    }

    //reset code
    public void resetGame() {
        aantalSpelers = 0;
        randomNummer = 0;
        show = 0;
        mensNiet = false;
        mensWel = false;
        verzuipNiet = false;
        playerOne = true;
        playerTwo = false;
        playerThree = false;
        playerFour = false;
        resetPion(11, 0);
        resetPion(12, 1);
        resetPion(13, 2);
        resetPion(14, 3);
        resetPion(21, 4);
        resetPion(22, 5);
        resetPion(23, 6);
        resetPion(24, 7);
        resetPion(31, 8);
        resetPion(32, 9);
        resetPion(33, 10);
        resetPion(34, 11);
        resetPion(41, 12);
        resetPion(42, 13);
        resetPion(43, 14);
        resetPion(44, 15);
        currentScreen = "startPagina";
    }

    public void resetPion(int pionID, int positie) {
        for (Pion p : pionen) {
            if (p.pionID == pionID) {
                p.pionPositie = positie;
                p.onBoard = false;
                p.inHonk = false;
                p.rondje = false;
            }

        }
    }

    int pionID = 0;

    //kans kaarten
    boolean kiesKansText = false;
    String kansText = "";
    int kansKeuze = 0;

    public void chekKanskaart() {
        for (Pion p : pionen) {
            if (playerOne) {
                if (p.pionID == 11 && p.pionPositie == 20 || p.pionID == 11 && p.pionPositie == 34 || p.pionID == 11 && p.pionPositie == 40 || p.pionID == 11 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 12 && p.pionPositie == 20 || p.pionID == 12 && p.pionPositie == 34 || p.pionID == 12 && p.pionPositie == 40 || p.pionID == 12 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 13 && p.pionPositie == 20 || p.pionID == 13 && p.pionPositie == 34 || p.pionID == 13 && p.pionPositie == 40 || p.pionID == 13 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 14 && p.pionPositie == 20 || p.pionID == 14 && p.pionPositie == 34 || p.pionID == 14 && p.pionPositie == 40 || p.pionID == 14 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                }
            } else if (playerTwo) {
                if (p.pionID == 21 && p.pionPositie == 20 || p.pionID == 21 && p.pionPositie == 34 || p.pionID == 21 && p.pionPositie == 40 || p.pionID == 21 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 22 && p.pionPositie == 20 || p.pionID == 22 && p.pionPositie == 34 || p.pionID == 22 && p.pionPositie == 40 || p.pionID == 22 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 23 && p.pionPositie == 20 || p.pionID == 23 && p.pionPositie == 34 || p.pionID == 23 && p.pionPositie == 40 || p.pionID == 23 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 24 && p.pionPositie == 20 || p.pionID == 24 && p.pionPositie == 34 || p.pionID == 24 && p.pionPositie == 40 || p.pionID == 24 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                }
            } else if (playerThree) {
                if (p.pionID == 31 && p.pionPositie == 20 || p.pionID == 31 && p.pionPositie == 34 || p.pionID == 31 && p.pionPositie == 40 || p.pionID == 31 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 32 && p.pionPositie == 20 || p.pionID == 32 && p.pionPositie == 34 || p.pionID == 32 && p.pionPositie == 40 || p.pionID == 32 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 33 && p.pionPositie == 20 || p.pionID == 33 && p.pionPositie == 34 || p.pionID == 33 && p.pionPositie == 40 || p.pionID == 33 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 34 && p.pionPositie == 20 || p.pionID == 34 && p.pionPositie == 34 || p.pionID == 34 && p.pionPositie == 40 || p.pionID == 34 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                }
            } else if (playerFour) {
                if (p.pionID == 41 && p.pionPositie == 20 || p.pionID == 41 && p.pionPositie == 34 || p.pionID == 41 && p.pionPositie == 40 || p.pionID == 41 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 42 && p.pionPositie == 20 || p.pionID == 42 && p.pionPositie == 34 || p.pionID == 42 && p.pionPositie == 40 || p.pionID == 42 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 43 && p.pionPositie == 20 || p.pionID == 43 && p.pionPositie == 34 || p.pionID == 43 && p.pionPositie == 40 || p.pionID == 43 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 44 && p.pionPositie == 20 || p.pionID == 44 && p.pionPositie == 34 || p.pionID == 44 && p.pionPositie == 40 || p.pionID == 44 && p.pionPositie == 54) {
                    currentScreen = "KansKaart";
                    pionID = p.pionID;
                }
            }
        }
    }

    public void showkansKaartScreen(int pionID) {
        String[] kansKaarten = {"Je hebt geluk! Je mag 5 stappen vooruit!",
                "Wie o Wie? Zet een van de tegenspelers 3 stappen achteruit.",
                "Je mag het aantal gegooide ogen vooruit!"};

        Color achtergrond = SaxionApp.createColor(255, 251, 208);
        SaxionApp.setBackgroundColor(achtergrond);
        SaxionApp.drawImage("Sandbox/kanskaart.png", 25, 200, 700, 350);

        if (pionID == 11 || pionID == 12 || pionID == 13 || pionID == 14) {
            SaxionApp.drawText("GEEL: ", 320, 275, 40);
        } else if (pionID == 21 || pionID == 22 || pionID == 23 || pionID == 24) {
            SaxionApp.drawText("ROOD: ", 320, 275, 40);
        } else if (pionID == 31 || pionID == 32 || pionID == 33 || pionID == 34) {
            SaxionApp.drawText("GROEN: ", 320, 275, 40);
        } else if (pionID == 41 || pionID == 42 || pionID == 43 || pionID == 44) {
            SaxionApp.drawText("BLAUW: ", 320, 275, 40);
        }


        if (!kiesKansText) {
            kansKeuze = SaxionApp.getRandomValueBetween(0, kansKaarten.length);
            kansText = kansKaarten[kansKeuze];
            kiesKansText = true;
        }
        SaxionApp.setTextDrawingColor(Color.white);
        SaxionApp.drawText(kansText, 100, 375, 25);

        SaxionApp.setTextDrawingColor(Color.white);
        SaxionApp.drawText("druk op spatie om verder te gaan.", 270, 500, 15);

    }

    public void voerKansKaartUit(int pionID) {
        System.out.println("pionID: " + pionID);
        for (Pion p : pionen) {
            if (p.pionID == pionID && !p.inHonk) {
                if (kansKeuze == 0) {
                    p.pionPositie += 5;
                    checkRondje();
                    System.out.println(p.pionID + " 5+ stappen vooruit");
                    System.out.println("pID " + p.pionPositie + " positie: " + p.pionPositie);
                } else if (kansKeuze == 1) {
                    System.out.println("er moet een speler achteruit......");
                } else if (kansKeuze == 2) {
                    p.pionPositie += randomNummer;
                    checkRondje();
                    System.out.println(p.pionID + " " + randomNummer + " stappen vooruit");
                    System.out.println("pID " + p.pionPositie + " positie: " + p.pionPositie);
                }

            }
        }

    }

    //----------------------------------------------------------

    //truth kaarten//
    boolean aardrijkskunde = false;
    boolean sport = false;
    boolean wetenshap = false;
    boolean geschiedenis  = false;
    boolean amusement = false;
    boolean ict = false;
    boolean kiesKaart = false;
    boolean vooruit = false;
    String kaartText = "";
    int kaartIndex = 0;

    public void checkTruthKaart(){
        for (Pion p : pionen) {
            if (playerOne) {
                if (p.pionID == 11 && p.pionPositie == 30 || p.pionID == 11 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                } else if (p.pionID == 12 && p.pionPositie == 30 || p.pionID == 12 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                } else if (p.pionID == 13 && p.pionPositie == 30 || p.pionID == 13 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                } else if (p.pionID == 14 && p.pionPositie == 30 || p.pionID == 14 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                }
            } else if (playerTwo) {
                if (p.pionID == 21 && p.pionPositie == 30 || p.pionID == 21 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                } else if (p.pionID == 22 && p.pionPositie == 30 || p.pionID == 22 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                } else if (p.pionID == 23 && p.pionPositie == 30 || p.pionID == 23 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                } else if (p.pionID == 24 && p.pionPositie == 30 || p.pionID == 24 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                }
            } else if (playerThree) {
                if (p.pionID == 31 && p.pionPositie == 30 || p.pionID == 31 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                } else if (p.pionID == 32 && p.pionPositie == 30 || p.pionID == 32 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                } else if (p.pionID == 33 && p.pionPositie == 30 || p.pionID == 33 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                } else if (p.pionID == 34 && p.pionPositie == 30 || p.pionID == 34 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                }
            } else if (playerFour) {
                if (p.pionID == 41 && p.pionPositie == 30 || p.pionID == 41 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                } else if (p.pionID == 42 && p.pionPositie == 30 || p.pionID == 42 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                } else if (p.pionID == 43 && p.pionPositie == 30 || p.pionID == 43 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                } else if (p.pionID == 44 && p.pionPositie == 30 || p.pionID == 44 && p.pionPositie == 44) {
                    currentScreen = "truthKaartKeuze";
                    pionID = p.pionID;
                }
            }
        }
    }

    public void showTruthKeuzeScreen(int pionID){
        Color achtergrond = SaxionApp.createColor(255, 251, 208);
        SaxionApp.setBackgroundColor(achtergrond);
        SaxionApp.drawImage("Sandbox/truth keuzes.png", 0, 0, 750, 750);

        SaxionApp.setTextDrawingColor(Color.black);
        if (pionID == 11 || pionID == 12 || pionID == 13 || pionID == 14) {
            SaxionApp.drawText("GEEL: ", 415, 35, 40);
        } else if (pionID == 21 || pionID == 22 || pionID == 23 || pionID == 24) {
            SaxionApp.drawText("ROOD: ", 415, 35, 40);
        } else if (pionID == 31 || pionID == 32 || pionID == 33 || pionID == 34) {
            SaxionApp.drawText("GROEN: ", 415, 35, 40);
        } else if (pionID == 41 || pionID == 42 || pionID == 43 || pionID == 44) {
            SaxionApp.drawText("BLAUW: ", 415, 35, 40);
        }

        SaxionApp.setTextDrawingColor(Color.white);
        SaxionApp.drawText("Aarderijkskunde", 140, 195, 25);
        SaxionApp.drawText("sport", 425, 195, 25);
        SaxionApp.drawText("wetenschap", 140, 385, 25);
        SaxionApp.drawText("geschiedenis", 425, 385, 25);
        SaxionApp.drawText("amasument", 140, 580, 25);
        SaxionApp.drawText("ict", 425, 580, 25);

        SaxionApp.setTextDrawingColor(Color.black);
        SaxionApp.drawText("kies een categorie", 95,85,30);

    }

    public void showTruthKaart(){
        String[] aardrijkskundevraag = {"Wat is de hoofdstad van IJsland?",
                "In welk land ligt het meest noordelijke punt van Afrika? ",
                "Wat is de langste rivier van Zuid-Amerika?",
                "Van welk Europees land is Tallinn de hoofdstad?",
                "Wat is de munteenheid van Japan?",
                "Waar staat de hoogste toren ter wereld, de Burj Khalifa? ",
                "Wat is het de grootste eiland ter wereld?",
                "In welke gemeente ligt Langeveen Overijsel?",
                "Hoeveel landen heeft Noord-Amerika? ",
                "Wat is de hoogste hoofdstad te wereld?"};

        String[] sportvragen = {"Waar vond het WK voetbal van 2010 plaats? ",
                "Welke speler van het Nederlands elftal heeft de meeste interlands op zijn naam staan? ",
                "Hoeveel punten is een touchdown waard in American Football? ",
                "Op welk formule-1 circuit wordt jaarlijks de Grand Prix van Groot-Brittannië gehouden? ",
                "Wie werd Wereldkampioen Darts bij de PDC in 2007?",
                "Bij welke sport horen de termen pancake, side-out en floater? ",
                "Uit hoeveel veldspelers bestaat een waterpolo team? ",
                "Op welke ondergrond wordt er getennist op Wimbledon? ",
                "Hoe wordt bij tafeltennis een winnende opslag genoemd waarbij de tegenstander de bal niet raakt? ",
                "Welk turnonderdeel is geen olympische sport voor vrouwen? "};

        String[] wetenschapvragen = {"Hoeveel scheikundige elementen zijn er in het periodiek systeem?",
                "Wie was de uitvinder van de stoommachine?",
                "Waar staat de scheikundige afkorting ‘Au’ voor? ",
                "In welke maateenheid wordt een beeldscherm aangeduid? ",
                "Waar staat de afkorting Hz voor?",
                "Wat is de afkorting voor het getal 3,14? ",
                "Wat is de eigenschap van metaal als het warm wordt?",
                "Wat duiden Kelvin en Fahrenheit aan?",
                "Welke toetsenbord indeling gebruiken ze in Duitsland? ",
                "Wat is de tegenhanger van gelijkspanning? "};

        String[] geschiedenisvragen = {"In welk jaar viel de Berlijnse muur? ",
                "Wat was de voornaam van Napoleon?",
                "Hoe heet de Japanse techniek van papier vouwen in figuurtjes? ",
                "Welk soort dier is ‘Pegasus’ in de Griekse mythologie? ",
                "Wat was de voornaam van Hitler?",
                "Waar staat de afkorting van de V.O.C. voor?",
                "Hoe heette de vader van Anne Frank? ",
                "Welke titel gaven de Egyptenaren vroeger aan hun Koning of Koningin?",
                "Wie schilderde de nachtwacht? ",
                "Welk politiek leider hield de bekende toespraak “I have a dream”?"};

        String[] amasumentvragen = {"Onder welke naam is de filmprijs Academy Award beter bekend?",
                "Hoe heet de televisie prijs voor de beste reclamespot?",
                "Wie speelde meneer Aart in de kinderserie Sesamstraat? ",
                "Welk bedrijf maakte als eerste een volledige 3D-Animatiefilm? ",
                "Wat is de naam van de rode race-auto in de animatie film Cars? ",
                "Wat was de naam van het kanaal DisneyXD voor 2010?",
                "In welke fictieve plaats speelt goede tijden slechte tijden zich af?",
                "Hoe heet de rechter in het tv-programma De Rijdende Rechter? ",
                "Door welk programma is Ben Saunders bekend geworden in 2011? ",
                "Met welke woorden sloot Piet Paulusma zijn weerbericht altijd af? "};

        String[] ictvragen = {"Welke software heeft het logo van een walvis? ",
                "Waar staat ECCRAM voor?",
                "Wie is de uitvinder van Microsoft? ",
                "Wat is de populairste programmeertaal? ",
                "In welk jaar is het besturingssysteem Linux uitgekomen? ",
                "Waar staat de term Central Processing Unit voor?"};


        Color achtergrond = SaxionApp.createColor(255, 251, 208);
        SaxionApp.setBackgroundColor(achtergrond);
        SaxionApp.drawImage("Sandbox/Truth kaart.png", 25, 200, 700, 350);

        if (aardrijkskunde){
            if (!kiesKaart) {
                kaartIndex = SaxionApp.getRandomValueBetween(0, aardrijkskundevraag.length);
                kaartText = aardrijkskundevraag[kaartIndex];
                kiesKaart = true;
            }
            SaxionApp.setTextDrawingColor(Color.white);
            SaxionApp.drawText(kaartText, 75, 375, 20);
            truthKaartAntwoord();

        } else if (sport){
            if (!kiesKaart) {
                kaartIndex = SaxionApp.getRandomValueBetween(0, sportvragen.length);
                kaartText = sportvragen[kaartIndex];
                kiesKaart = true;
            }
            SaxionApp.setTextDrawingColor(Color.white);
            SaxionApp.drawText(kaartText, 75, 375, 20);
            truthKaartAntwoord();

        } else if (wetenshap) {
            if (!kiesKaart) {
                kaartIndex = SaxionApp.getRandomValueBetween(0, wetenschapvragen.length);
                kaartText = wetenschapvragen[kaartIndex];
                kiesKaart = true;
            }
            SaxionApp.setTextDrawingColor(Color.white);
            SaxionApp.drawText(kaartText, 75, 375, 20);
            truthKaartAntwoord();

        } else if (geschiedenis) {
            if (!kiesKaart) {
                kaartIndex = SaxionApp.getRandomValueBetween(0, geschiedenisvragen.length);
                kaartText = geschiedenisvragen[kaartIndex];
                kiesKaart = true;
            }
            SaxionApp.setTextDrawingColor(Color.white);
            SaxionApp.drawText(kaartText, 75, 375, 20);
            truthKaartAntwoord();

        } else if (amusement) {
            if (!kiesKaart) {
                kaartIndex = SaxionApp.getRandomValueBetween(0, amasumentvragen.length);
                kaartText = amasumentvragen[kaartIndex];
                kiesKaart = true;
            }
            SaxionApp.setTextDrawingColor(Color.white);
            SaxionApp.drawText(kaartText, 75, 375, 20);
            truthKaartAntwoord();

        } else if (ict) {
            if (!kiesKaart) {
                kaartIndex = SaxionApp.getRandomValueBetween(0, ictvragen.length);
                kaartText = ictvragen[kaartIndex];
                kiesKaart = true;
            }
            SaxionApp.setTextDrawingColor(Color.white);
            SaxionApp.drawText(kaartText, 75, 375, 20);
            truthKaartAntwoord();
        }

        SaxionApp.setTextDrawingColor(Color.green);
        SaxionApp.drawText("GOED? druk op ENTER", 95,570,25);
        SaxionApp.setTextDrawingColor(Color.red);
        SaxionApp.drawText("FOUT? druk op BACK", 385,570,25);


    }

    public void truthKaartAntwoord(){
        String[] aarderijkskundeAntwooord = {"Reykjavik","Tunesië","De Amazone","Estland","De Japanse Yen","Dubai","Groenland","Gemeente Tubbergen","3: Mexico, Canada, USA","Quito, Ecuador"};
        String[] sportAntwooord = {"Zuid-Afrika","Wesley Sneijder, 134 Interlands","Zes","Silverstone","Raymond van Barneveld","Volleybal","6","Gras","Ace","Ringen"};
        String[] wetenschapAntwooord = {"118","James Watt","Het element Goud","Inch","Hertz","Pi","Het zet uit","Temperatuur","Qwertz","Wisselspanning"};
        String[] geschiedenisAntwooord = {"1989","Napoleon","Origami","Gevleugeld Paard","Adolf","Vereenigde Oostindische Compagnie","Otto Frank","Farao","Rembrandt van Rijn","Martin Luther King"};
        String[] amusementAntwooord = {"Oscar","De gouden Loekie","Aart Staartjes","Pixar","lightning McQueen","Jetix","Meerdijk","Frank Visser","The Voice of Holland","Oant Moan"};
        String[] ictAntwooord = {"Error Correcting RAM","Docker","Bill Gates","Python","1992","Processor"};

        if(aardrijkskunde){
            switch (kaartIndex) {
                case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> SaxionApp.drawText(aarderijkskundeAntwooord[kaartIndex], 95, 505, 20);
            }
        } else if(sport) {
            switch (kaartIndex) {
                case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> SaxionApp.drawText(sportAntwooord[kaartIndex], 95, 505, 20);
            }
        } else if (wetenshap) {
            switch (kaartIndex) {
                case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> SaxionApp.drawText(wetenschapAntwooord[kaartIndex], 95, 505, 20);
            }
        } else if (geschiedenis) {
            switch (kaartIndex) {
                case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> SaxionApp.drawText(geschiedenisAntwooord[kaartIndex], 95, 505, 20);
            }
        } else if (amusement) {
            switch (kaartIndex) {
                case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> SaxionApp.drawText(amusementAntwooord[kaartIndex], 95, 505, 20);
            }
        } else if (ict){
            switch (kaartIndex) {
                case 0, 1, 2, 3, 4, 5-> SaxionApp.drawText(ictAntwooord[kaartIndex], 95, 510, 20);
            }
        }


    }

    public void voerTruthKaartUit(int pionID){
        for(Pion p : pionen) {
            if (vooruit) {
                if(p.pionID == pionID && !p.inHonk){
                    System.out.println("je mag " + randomNummer + " stappen vooruit.");
                    p.pionPositie += randomNummer;
                    checkRondje();
                }
            } else{
                System.out.println("je blijft op de plek staan.");
            }
        }
        vooruit = false;
    }

    //-------------------------------------------------------


    //dare kaarten
    boolean kiesDare = false;
    boolean skip = false;
    boolean dareVooruit = false;
    String dareText = "";
    int dareKaart = 0;
    public void checkDareKaart(){
        for (Pion p : pionen) {
            if (playerOne) {
                if (p.pionID == 11 && p.pionPositie == 24 || p.pionID == 11 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 12 && p.pionPositie == 24 || p.pionID == 12 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 13 && p.pionPositie == 24 || p.pionID == 13 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 14 && p.pionPositie == 24 || p.pionID == 14 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                }
            } else if (playerTwo) {
                if (p.pionID == 21 && p.pionPositie == 24 || p.pionID == 21 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 22 && p.pionPositie == 24 || p.pionID == 22 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 23 && p.pionPositie == 24 || p.pionID == 23 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 24 && p.pionPositie == 24 || p.pionID == 24 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                }
            } else if (playerThree) {
                if (p.pionID == 31 && p.pionPositie == 24 || p.pionID == 31 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 32 && p.pionPositie == 24 || p.pionID == 32 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 33 && p.pionPositie == 24 || p.pionID == 33 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 34 && p.pionPositie == 24 || p.pionID == 34 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                }
            } else if (playerFour) {
                if (p.pionID == 41 && p.pionPositie == 24 || p.pionID == 41 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 42 && p.pionPositie == 24 || p.pionID == 42 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 43 && p.pionPositie == 24 || p.pionID == 43 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                } else if (p.pionID == 44 && p.pionPositie == 24 || p.pionID == 44 && p.pionPositie == 50) {
                    currentScreen = "dareKaart";
                    pionID = p.pionID;
                }
            }
        }
    }

    public void showDareKaart(int pionID){
        String[] dareKaarten = {"FUN RUN, Ren een rondje om je huis!",
                "Trek een kledingstuk naar keuze uit!",
                "Drink je glas leeg!",
                "Ga naar buiten en dans als een cowboy!",
                "Praat met een Duits accent de komende 2 rondes. ",
                "Ga breakdancen!"};

        Color achtergrond = SaxionApp.createColor(255, 251, 208);
        SaxionApp.setBackgroundColor(achtergrond);
        SaxionApp.drawImage("Sandbox/darekaart.png", 25, 200, 700, 350);

        if (pionID == 11 || pionID == 12 || pionID == 13 || pionID == 14) {
            SaxionApp.drawText("GEEL: ", 320, 275, 40);
        } else if (pionID == 21 || pionID == 22 || pionID == 23 || pionID == 24) {
            SaxionApp.drawText("ROOD: ", 320, 275, 40);
        } else if (pionID == 31 || pionID == 32 || pionID == 33 || pionID == 34) {
            SaxionApp.drawText("GROEN: ", 320, 275, 40);
        } else if (pionID == 41 || pionID == 42 || pionID == 43 || pionID == 44) {
            SaxionApp.drawText("BLAUW: ", 320, 275, 40);
        }

        if (!kiesDare) {
            dareKaart = SaxionApp.getRandomValueBetween(0, dareKaarten.length);
            dareText = dareKaarten[kansKeuze];
            kiesDare = true;
        }
        SaxionApp.setTextDrawingColor(Color.white);
        SaxionApp.drawText(dareText, 100, 375, 25);

        SaxionApp.setTextDrawingColor(Color.white);
        SaxionApp.drawText("skip: SPATIE        goed: ENTER         fout: BACK", 100, 500, 15);
    }

    public void voerDareUit(int pionID){
        for(Pion p : pionen) {
            if (skip) {
                if (p.pionID == pionID){
                    if(pionID == 11 || pionID == 12 || pionID == 13 || pionID == 14) {
                        p.pionPositie = 26;
                        System.out.println(pionID + " pion terug naar start");
                    } else if (pionID == 21 || pionID == 22 || pionID == 23 || pionID == 24) {
                        p.pionPositie = 46;
                        System.out.println(pionID + " pion terug naar start");
                    } else if (pionID == 31 || pionID == 32 || pionID == 33 || pionID == 34) {
                        p.pionPositie = 36;
                        System.out.println(pionID + " pion terug naar start");
                    } else if (pionID == 41 || pionID == 42 || pionID == 43 || pionID == 44) {
                        p.pionPositie = 16;
                        System.out.println(pionID + " pion terug naar start");
                    }
                }
            } else if (dareVooruit) {
                if(p.pionID == pionID){
                    p.pionPositie += randomNummer;
                    checkRondje();
                    System.out.println(pionID + " gaat " + randomNummer + " vooruit.");
                }
            } else {
                if(p.pionID == pionID){
                    System.out.println(pionID + " blijft op de plek staan.");
                }
            }
        }
    }
    //------------------------------------------------------
}




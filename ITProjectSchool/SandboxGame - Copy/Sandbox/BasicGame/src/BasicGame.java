import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;


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
        SaxionApp.clear();
        switch (currentScreen) {
            case "gameMenu" -> gameMenu();
            case "startPagina" -> startPagina();
            case "mensNiet" -> nietGamePagina();
            case "mensWel" -> welGamePagina();
            case "verzuipNiet" -> drankGamePagina();
            case "regelPagina" -> regelPagina();
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
                            currentScreen = "mensWel";
                            optie2 = true;
                        }
                    }
                }
                if (mouseEvent.isMouseDown() && mouseEvent.isLeftMouseButton()) {
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    if (y < 480 && y > 375) {
                        if (x > 0 && x < 485) {
                            currentScreen = "verzuipNiet";
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
            case "mensWel":
            case "verzuipNiet":
                if (mouseEvent.isMouseUp() && mouseEvent.isLeftMouseButton()) {
                    dobbelsteen();
                }
                break;
        }
    }

    public void dobbelsteen(){
        int randomNummer = SaxionApp.getRandomValueBetween(1,7);
        switch (randomNummer) {
            case 1 -> SaxionApp.drawImage("Sandbox/stip1.png", 350, 345, 60, 60);
            case 2 -> SaxionApp.drawImage("Sandbox/stip2.png", 350, 345, 60, 60);
            case 3 -> SaxionApp.drawImage("Sandbox/stip3.png", 350, 345, 60, 60);
            case 4 -> SaxionApp.drawImage("Sandbox/stip4.png", 350, 345, 60, 60);
            case 5 -> SaxionApp.drawImage("Sandbox/stip5.png", 350, 345, 60, 60);
            case 6 -> SaxionApp.drawImage("Sandbox/stip6.png", 350, 345, 60, 60);
        }
    }

    public void gameMenu() {
        SaxionApp.drawImage("Sandbox/keuze menu.png", 0, 0, 750, 750);
    }

    public void startPagina() {
        SaxionApp.drawImage("Sandbox/start pagina.png", 0, 0, 750, 750);

    }

    public void nietGamePagina() {

        SaxionApp.drawImage("Sandbox/bord mens erger je niet.png", 0, 0, 750, 750);
    }

    public void welGamePagina() {

        SaxionApp.drawImage("Sandbox/bord mens erger je niet.png", 0, 0, 750, 750);
    }

    public void drankGamePagina() {

        SaxionApp.drawImage("Sandbox/bord mens erger je wel.png", 0, 0, 750, 750);
    }

    public void regelPagina() {
        //SaxionApp.drawimage("foto.png",0,0,750,750);
        //wachten op foto collin denk ik
    }
}


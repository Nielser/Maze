import java.awt.*;

public class Tile extends Rectangle{

    //Wander stellen
    public Tile(int x, int y){

        setBounds(x,y,32,32);
    }

    //Wand zeichnen ToDo Bild statt füllung, siehe minecraft? 32x32 oder 16x16 Texturenpacks
    public void render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x,y,width,height);
    }

}

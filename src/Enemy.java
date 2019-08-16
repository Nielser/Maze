import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;
import com.sun.tools.javah.Util;

import java.awt.*;

public class Enemy extends Rectangle {

    //Todo Wächter Gegner hinzufügen, Langsamer, aber Stärker

    //Gegner mit Start Pixel x,y und einer Höhe und Breite von 32 Pixel und einem Speed von 2
    public  Enemy(int x, int y){
            setBounds(x,y,32,32);
        }

        public int speed = 2;
    public int d =1;

    // ToDo oberer Enemy Bug und hängt einer Ecke fest
    //Bewegung und aggro pro Tick
    public void tick() {
        damage();
        if(speed>0) aggro();
        else if(Math.abs(Game.player.x-this.x)>150|Math.abs(Game.player.y-this.y)>150){
            speed=2;
            d=1;
        }

        if (((Game.player.x-this.x)>0)   && cantMove(x + speed, y)) {x += speed;if(speed < 0&&this.x%4==2)x+=2;}
        if (((Game.player.x-this.x)<0)  && cantMove(x - speed, y)) {x -= speed;if(speed < 0&&this.x%4==2)x-=2;}
        if (((Game.player.y-this.y)>0)   && cantMove(x, y + speed)) {y += speed;if(speed < 0&&this.y%4==2)y+=2;}
        if (((Game.player.y-this.y)<0)  && cantMove(x, y - speed)) {y -= speed;if(speed < 0&&this.y%4==2)y-=2;}
    }

    //Wenn näher, dann sind Gegner schneller
    private void aggro(){
        if(Math.abs(Game.player.x-this.x)>200)speed=1;
        else {
            speed = 2;
            //wenn speed 1 war kann es sein, das Gegner auf einem ungeradenen pixel anfangen, dann bleiben dies stehen
            if(this.x%2==1)x+=1;
        }
        if(Math.abs(Game.player.y-this.y)>200)speed=1;
        else {
            speed = 2;
            if(this.y%2==1)y+=1;
        }

    }


    //Check jeden Block, ob Gegner damit kolidiert, wenn er noch einen Schritt nach vorne macht. wenn nicht dann true
    private boolean cantMove(int nextx, int nexty){
        Rectangle bounds = new Rectangle(nextx, nexty,width,height);
        Level level = Game.level;
            for (int xx = 0; xx < level.tiles.length; xx++) {
                for (int yy = 0; yy < level.tiles[0].length; yy++) {
                    if (level.tiles[xx][yy] != null) {
                        if (bounds.intersects(level.tiles[xx][yy])) {
                            return false;
                    }
                }
            }
        }

        return true;
    }

    //Mobcollision
    public void damage(){
        if(d!=0){
            Rectangle bounds = new Rectangle(x,y,width,height);
            if (bounds.intersects(Game.player)){
                System.out.println("Got u");
                Game.player.health -= d;
                speed=-4;
                d=0;
                System.out.println(Game.player.health);
                if(Game.player.health==0)Game.player.speed =0;

            }
        }


    }


        //Farbe und füllung der Gegner
        public void render(Graphics g){
            g.setColor(Color.red);
            g.fillRect(x,y,32,32);
        }




}


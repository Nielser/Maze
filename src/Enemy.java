import java.awt.*;

public class Enemy extends Rectangle {

    public  Enemy(int x, int y){
            setBounds(x,y,32,32);
        }
        public int speed = 2;



        //TODO Aggro einbauen erst ab einnem Abstand von 200?

    public void tick() {
    aggro();
        if (((Game.player.x-this.x)>0)   && cantMove(x + speed, y)) x += speed;
        if (((Game.player.x-this.x)<0)  && cantMove(x - speed, y)) x -= speed;
        if (((Game.player.y-this.y)>0)   && cantMove(x, y + speed)) y += speed;
        if (((Game.player.y-this.y)<0)  && cantMove(x, y - speed)) y -= speed;
    }

    private void aggro(){
        if(Math.abs(Game.player.x-this.x)>200)speed=1;
        else {
            speed = 2;
            if(this.x%2==1)x+=1;
        }
        if(Math.abs(Game.player.y-this.y)>200)speed=1;
        else {
            speed = 2;
            if(this.y%2==1)y+=1;
        }

    }

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

        public void render(Graphics g){
            g.setColor(Color.red);
            g.fillRect(x,y,32,32);
        }




}


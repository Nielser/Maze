import java.awt.*;

public class Enemy extends Rectangle {

    public  Enemy(int x, int y){
            setBounds(x,y,30,30);
        }
        public int speed = 3;



        //TODO Aggro einbauen erst ab einnem Abstand von 200?

    public void tick() {
    aggro();
        if (((Game.player.x-this.x)>0)   && cantMove(x + speed, y)) x += speed;
        if (((Game.player.x-this.x)<0)  && cantMove(x - speed, y)) x -= speed;
        if (((Game.player.y-this.y)>0)   && cantMove(x, y + speed)) y += speed;
        if (((Game.player.y-this.y)<0)  && cantMove(x, y - speed)) y -= speed;
    }

    private void aggro(){
        if(Math.abs(Game.player.x-this.x)>200)speed=1; else speed = 3;
        if(Math.abs(Game.player.y-this.y)>200)speed=1; else speed = 3;;

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
            g.fillRect(x,y,30,30);
        }




}


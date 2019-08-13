import java.awt.*;

public class Player extends Rectangle {

    private static final long serialVersionUID = 1L;

    public boolean right,left,up,down;
    public int speed = 6;
    public int health = 3;

    public Player(int x, int y){
        setBounds(x,y,30,30);
    }

    public void tick(){
        if(right&& canMove(x+speed,y) )x+=speed;
        if(left && canMove(x-speed,y))x-=speed;
        if(down&& canMove(x,y+speed) )y+=speed;
        if(up && canMove(x,y-speed))y-=speed;
    }

    private boolean canMove(int nextx, int nexty){
        Rectangle bounds = new Rectangle(nextx, nexty,width,height);
        Level level = Game.level;
        for(int xx = 0; xx < level.tiles.length;xx++ ){
            for(int yy = 0; yy< level.tiles[0].length;yy++){
                if(level.tiles[xx][yy] != null){
                    if(bounds.intersects(level.tiles[xx][yy])){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public void render(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(x,y ,width, height);

    }


}
